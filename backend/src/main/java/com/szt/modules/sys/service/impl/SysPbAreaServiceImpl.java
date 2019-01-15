package com.szt.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.szt.common.CommonServiceImpl;
import com.szt.common.utils.PageUtils;
import com.szt.modules.sys.dao.SysPbAreaDao;
import com.szt.modules.sys.entity.SysPbAreaEntity;
import com.szt.modules.sys.service.SysPbAreaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 地址管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-08-20 00:11:07
 */
@Service("syssysPbAreaService")
public class SysPbAreaServiceImpl extends CommonServiceImpl<SysPbAreaDao, SysPbAreaEntity> implements SysPbAreaService {

    //    @Autowired
//    private KeRegionService keRegionService;
    @Override
    @Transactional
    public void addressReload() {
        List<SysPbAreaEntity> list = baseMapper.selectList(null);
        for (SysPbAreaEntity item : list) {
            item.insert();
            baseMapper.updateById(item);
        }
    }

    @Override
    public List<SysPbAreaEntity> addressRedisReload() {
        return selectList(null);
    }

    @Override
    public void defaultData() {
//        List<KeRegionEntity> list = keRegionService.selectList(null);
//        for(KeRegionEntity item : list){
//            SysPbAreaEntity entity = new SysPbAreaEntity();
//            entity.setId(new Long(item.getId()));
//            entity.setParentid(new Long(item.getPid()));
//            entity.setAreaname(item.getName());
//            entity.setLevel(item.getType());
//            this.insertEntity(entity);
//        }
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params,Wrapper<SysPbAreaEntity> wrapper) {
        Page<SysPbAreaEntity> page = new Page<SysPbAreaEntity>(
                Integer.parseInt((String) params.get("page")),
                Integer.parseInt((String) params.get("limit"))
        );
        page.setRecords(baseMapper.queryList(page, params));
        return new PageUtils(page, this.tabName);
    }
}
