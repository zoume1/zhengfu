package com.szt.common;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.szt.common.exception.RRException;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.Query;
import com.szt.common.utils.SpringContextUtils;
import com.szt.common.utils.StringUtll;
import com.szt.common.validator.ValidatorUtils;
import com.szt.modules.generator.dao.GeneratorTableDao;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.generator.entity.GeneratorTableFieldEntity;
import com.szt.modules.generator.service.GeneratorTableService;
import com.szt.modules.sys.entity.SysCommcomFieldEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * 公抽象共业务层
 */
public abstract class CommonServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
    public String tabName;
    @Autowired
    private GeneratorTableDao generatorTableDao;

    //    /**
//     * 自动分页
//     *
//     * @param params
//     * @return
//     */
//    public PageUtils queryPage(Map<String, Object> params)  {
//        Wrapper<T> wrapper = Condition.create();
//        Page<T>  page = null;
//        try{
//              page = this.selectPage(new Query<T>(params,wrapper).getPage(),wrapper);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return new PageUtils(page);
//    }

    public CommonServiceImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> name = (Class<T>) type.getActualTypeArguments()[1];
        this.tabName = name.getAnnotation(TableName.class).value();

    }

    /**
     * 自动分页
     *
     * @param params
     * @return
     */
    public PageUtils queryPage(Map<String, Object> params, Wrapper<T> wrapper) {
        if (wrapper == null) {
            wrapper = Condition.create();
        }
        Page<T> page = null;
        try {
            page = this.selectPage(new Query<T>(params, wrapper).getPage(), wrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new PageUtils(page, this.tabName);
    }

//    /**
//     * 自动分页查询
//     *
//     * @param params
//     * @return
//     */
//    public Page<T> queryPage(Map<String, Object> params, T entity) {
//        try {
//            BeanUtils.copyProperties(entity, entity.getClass());
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        Page<T> page = new Page<T>(Integer.parseInt((String) params.get("limit")), Integer.parseInt((String) params.get("page")));
//        EntityWrapper<T> eWrapper = new EntityWrapper<T>(entity);
//        eWrapper.in("delete_flag", new Object[]{GeneratorTemplateConstant.DELETE_FLAG_0, GeneratorTemplateConstant.DELETE_FLAG_1});
//        Page<T> roleDOList = selectPage(page, eWrapper);
//
//        return roleDOList;
//    }

    /**
     * 逻辑删除
     *
     * @param ids
     * @param sysCommcomFieldEntity
     */
    @Transactional
    public void deleteFlagIds(Long[] ids, SysCommcomFieldEntity sysCommcomFieldEntity) {
        for (Long id : ids) {
            sysCommcomFieldEntity.setId(id);
            sysCommcomFieldEntity.setDeleteFlag(CommonConstant.DELETE_FLAG_1);
            baseMapper.updateById((T) sysCommcomFieldEntity);
        }
    }
    @Transactional
    public void insertEntity(T entity) {
        try {
            entity.getClass().getMethod("insert").invoke(entity);
            //校验类型
            ValidatorUtils.validateEntity(entity);
            this.insert(entity);
        } catch (Exception e) {
            throw new RRException(e.getMessage());
        }

    }

    /**
     * 批量新增
     *
     * @param list
     */
    @Transactional
    public void saveAll(List<T> list) {
        for (T entity : list) {
            this.insertEntity(entity);
        }
    }

    /**
     * 修改
     *
     * @param entity
     */
    @Transactional
    public void updateEntity(T entity) {
        try {
            entity.getClass().getMethod("update").invoke(entity);
            //校验类型
            ValidatorUtils.validateEntity(entity);
            this.updateById(entity);
        } catch (Exception e) {
            throw new RRException(e.getMessage());
        }
    }

    /**
     * 删除数据
     *
     * @param ids
     */
    @Transactional
    public void deleteList(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
    }
    /**
     * 拖拽排序
     *
     * @param id
     * @param id1
     */
    @Transactional
    public void sort(Long id, Long id1) {
        try {
        T en1 = this.selectById(id);
        T en2 = this.selectById(id1);
            Integer sortTotal= (Integer) en1.getClass().getMethod("getSort").invoke(en1)+(Integer) en2.getClass().getMethod("getSort").invoke(en2);
            en1.getClass().getMethod("setSort",Integer.class).invoke(en1,sortTotal-(Integer) en1.getClass().getMethod("getSort").invoke(en1));
            en2.getClass().getMethod("setSort",Integer.class).invoke(en2,sortTotal-(Integer) en1.getClass().getMethod("getSort").invoke(en1));
            this.updateEntity(en1);
            this.updateEntity(en2);
        } catch (Exception e) {
            throw new RRException(e);
        }
    }
    public  GeneratorTableEntity selectTableConfig(){
        GeneratorTableEntity tab =generatorTableDao.selectTableConfig(tabName);
        for(GeneratorTableFieldEntity field : tab.getColumns()){
            String attrName = StringUtll.columnToJava(field.getFieldName());
            field.setFieldName(org.apache.commons.lang.StringUtils.uncapitalize(attrName));
        }
       return  tab;
    }
}
