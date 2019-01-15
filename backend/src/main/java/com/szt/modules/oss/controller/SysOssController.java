package com.szt.modules.oss.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.google.gson.Gson;
import com.szt.common.exception.RRException;
import com.szt.common.utils.ConfigConstant;
import com.szt.common.utils.Constant;
import com.szt.common.validator.ValidatorUtils;
import com.szt.common.validator.group.AliyunGroup;
import com.szt.common.validator.group.QcloudGroup;
import com.szt.common.validator.group.QiniuGroup;
import com.szt.modules.oss.cloud.CloudStorageConfig;
import com.szt.modules.oss.cloud.OSSFactory;
import com.szt.modules.sys.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.szt.modules.oss.entity.SysOssEntity;
import com.szt.modules.oss.service.SysOssService;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.R;
import com.szt.common.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 上传图片管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-06-19 22:33:41
 */
@Slf4j
@Api(value = "上传图片管理接口", tags = "上传图片管理接口")
@RestController
@RequestMapping("oss/sysoss")
@Controller("osssysoss")
public class SysOssController {
    @Autowired
    private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;
    private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("oss:sysoss:list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = sysOssService.queryPage(params,null);
		return R.ok().put("data", page);
    }

    /**
     * 云存储配置信息
     */
    @GetMapping("/config")
    @RequiresPermissions("oss:sysoss:config")
    public R config(){
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);
        return R.ok().put("data", config);
    }
    /**
     * 信息
     */
    @ApiOperation("信息")
    @GetMapping("/info/{id}")
    @RequiresPermissions("oss:sysoss:info")
    public R info(@PathVariable("id") Long id) {
            SysOssEntity sysOss = sysOssService.selectById(id);
        return R.ok().put("data", sysOss);
    }

    /**
     * 保存
     */
    @SysLog("保存信息")
    @ApiOperation("保存")
    @PostMapping("/save")
    @RequiresPermissions("oss:sysoss:save")
    public R save(@RequestBody SysOssEntity sysOss) {
             sysOss.insert();
            //校验类型
            ValidatorUtils.validateEntity(sysOss);
            sysOssService.insert(sysOss);
        return R.ok();
    }
    /**
     * 保存云存储配置信息
     */
    @PostMapping("/saveConfig")
    public R saveConfig(@RequestBody CloudStorageConfig config){
        //校验类型
        ValidatorUtils.validateEntity(config);
        if(config.getType() == Constant.CloudService.QINIU.getValue()){
            //校验七牛数据
            ValidatorUtils.validateEntity(config, QiniuGroup.class);
        }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            //校验阿里云数据
            ValidatorUtils.validateEntity(config, AliyunGroup.class);
        }else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
            //校验腾讯云数据
            ValidatorUtils.validateEntity(config, QcloudGroup.class);
        }
        sysConfigService.updateValueByKey(KEY, new Gson().toJson(config));
        return R.ok();
    }
    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        //上传文件
        String url = OSSFactory.build().upload(file.getBytes(),"upload/"+new Date().getTime()+"/"+ file.getOriginalFilename())+"?imageslim";
   //     String url = OSSFactory.build().uploadSuffix(file.getBytes(), suffix)+"?imageslim";
        //保存文件信息
        SysOssEntity ossEntity = new SysOssEntity();
        ossEntity.setUrl(url);
        ossEntity.insert();
        ossEntity.setRemarks("图片");
        sysOssService.insert(ossEntity);
        return R.ok().put("url", url).put("error", 0);
    }

    /**
     * 上传附件
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadAccessory")
    public R uploadAccessory(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return R.error();
        }
        //上传文件
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String url = OSSFactory.build().upload(file.getBytes(),"uploadAccessory/"+new Date().getTime()+"/"+ file.getOriginalFilename())+"?imageslim";
        //保存文件信息
        SysOssEntity ossEntity = new SysOssEntity();
        ossEntity.setUrl(url);
        ossEntity.insert();
        ossEntity.setRemarks("附件");
        sysOssService.insert(ossEntity);
        return R.ok().put("url", url).put("error", 0);
    }

    /**
     * 上传视频
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadVideo")
    public R uploadVideo(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return R.error();
        }
        //上传文件
        String url = OSSFactory.build().upload(file.getBytes(),"uploadVideo/"+new Date().getTime()+"/"+ file.getOriginalFilename())+"?imageslim";
        //保存文件信息
        SysOssEntity ossEntity = new SysOssEntity();
        ossEntity.setUrl(url);
        ossEntity.insert();
        ossEntity.setRemarks("视频");
        sysOssService.insert(ossEntity);
        return R.ok().put("url", url).put("error", 0);
    }
    /**
     * 修改
     */
    @SysLog("修改信息")
    @ApiOperation("修改")
    @PostMapping("/update")
    @RequiresPermissions("oss:sysoss:update")
    public R update(@RequestBody SysOssEntity sysOss) {
            sysOss.update();
            //校验类型
             ValidatorUtils.validateEntity(sysOss);
            sysOssService.updateById(sysOss);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除信息")
    @ApiOperation("删除")
    @PostMapping("/delete")
    @RequiresPermissions("oss:sysoss:delete")
    public R delete(@RequestBody Long[]ids) {
            sysOssService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    /**
     * 拖拽行排序
     */
    @ApiOperation("拖拽行排序")
    @PostMapping("/sort")
    public R sort(@RequestBody Long[]ids) {
        if(ids.length!=2){
            return R.error("数据错误");
        }
        sysOssService.sort(ids[0],ids[1]);
        return R.ok();
    }
    /**
     * 查询表格字段
     */
    @ApiOperation("查询表格字段")
    @RequestMapping(value = "/selectTableConfig",method = RequestMethod.GET)
    public R selectTableConfig() {
        return R.ok().put("data",sysOssService.selectTableConfig());
    }

}
