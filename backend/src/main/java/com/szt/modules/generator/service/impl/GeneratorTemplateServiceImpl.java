package com.szt.modules.generator.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.szt.common.CommonServiceImpl;
import com.szt.common.utils.GenUtils;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.Query;
import com.szt.modules.generator.constant.GeneratorTemplateConstant;
import com.szt.modules.generator.dao.GeneratorTemplateDao;
import com.szt.modules.generator.entity.GeneratorTemplateEntity;
import com.szt.modules.generator.service.GeneratorTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 模板配置
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-05-27 21:07:36
 */
@Slf4j
@Service("generatorTemplateService")
public class GeneratorTemplateServiceImpl extends CommonServiceImpl<GeneratorTemplateDao, GeneratorTemplateEntity> implements GeneratorTemplateService {

    /**
     * 自动分页查询
     * @param params
     * @return
     */
    public PageUtils queryPage(Map<String, Object> params){
        Wrapper wrapper = Condition.create();
        wrapper.in("delete_flag",new Object[]{GeneratorTemplateConstant.DELETE_FLAG_0,GeneratorTemplateConstant.DELETE_FLAG_1});
        Page<GeneratorTemplateEntity> page = null;
        try{
            page = this.selectPage(new Query<GeneratorTemplateEntity>(params,wrapper).getPage(),wrapper);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new PageUtils(page, this.tabName);
    }

    @Override
    @Transactional
    public void deleteFile(List<Long> longs) {
            baseMapper.deleteBatchIds(longs);
    }

    @Override
    public void insertFile(GeneratorTemplateEntity generatorTemplate) {
        //转义之后的字符
        File file  = new File("src/main/resources/"+GenUtils.TEMPLATE+"/"+generatorTemplate.getFileName());
        if(file.exists()){
            throw  new com.szt.common.exception.RRException("文件已经存在!");
        }
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        if(!file.exists()){
            try {
                file.createNewFile();
                //1.指定要写到的文件目录及名称
                //2.创建文件读入流对象
                FileOutputStream fos =new FileOutputStream(file);
                //3.定义结束标志
                fos.write(generatorTemplate.getText().getBytes());
                //4.刷新和关闭流
                fos.flush();
                fos.close();
                this.baseMapper.insert(generatorTemplate);
                //5.处理异常
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void updateByIdFile(GeneratorTemplateEntity generatorTemplate) {
//        // 下边这个也行
//        File file  = new File("src/main/resources/"+GenUtils.TEMPLATE+"/"+generatorTemplate.getFileName());
//        if(!file.exists()){
//            throw  new com.szt.common.exception.RRException("文件不存在!");
//        }
        FileOutputStream fos = null;
      //  try {
//            fos = new FileOutputStream(file);
//            //3.定义结束标志
//            fos.write(generatorTemplate.getText().getBytes());
//            /* 4.刷新和关闭流 */
//            fos.flush();
//            fos.close();
            this.baseMapper.updateById(generatorTemplate);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void removeFile() {

        List<GeneratorTemplateEntity> list = baseMapper.queryGeneratorTemplateListByDelete();
        for(GeneratorTemplateEntity item : list){
            File file  = new File("src/main/resources/"+GenUtils.TEMPLATE+"/"+item.getFileName());
            if(!file.exists()){
                log.info(item.getFileName()+"文件不存在！");
            }else{
                file.delete();
                baseMapper.deleteById(item.getId());
            }
        }
    }

    @Override
    public List<GeneratorTemplateEntity> queryGeneratorTemplateList() {
        return baseMapper.queryGeneratorTemplateList();
    }
}
