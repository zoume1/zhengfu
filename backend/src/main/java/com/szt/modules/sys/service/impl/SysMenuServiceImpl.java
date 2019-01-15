package com.szt.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.szt.common.CommonServiceImpl;
import com.szt.common.utils.AdminUserUtils;
import com.szt.common.utils.Constant;
import com.szt.common.utils.MybatsMap;
import com.szt.common.utils.TreeUtils;
import com.szt.modules.sys.dao.SysMenuDao;
import com.szt.modules.sys.dao.SysRoleDao;
import com.szt.modules.sys.entity.SysMenuEntity;
import com.szt.modules.sys.entity.SysRoleEntity;
import com.szt.modules.sys.service.SysMenuService;
import com.szt.modules.sys.service.SysRoleMenuService;
import lombok.experimental.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 菜单管理
 *
 * @author liao
 * @email 1171964050@qq.com
 * @date 2018-10-01 17:29:19
 */
@Service("syssysMenuService")
public class SysMenuServiceImpl extends CommonServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Value("${spring.profiles.active}")
    private String active;

    @Override
    public List<SysMenuEntity> router() {
        return baseMapper.router();
    }

    @Override
    public JSONArray getUserMenuList(Long userId) {
        //系统管理员，拥有最高权限
        if (userId == Constant.SUPER_ADMIN /*|| active.equals("dev")*/) {
            EntityWrapper<SysMenuEntity> wr = new EntityWrapper<SysMenuEntity> ();
            //查询所有业务表
            wr.in("type",new Object[]{"1","0"});
            List<SysMenuEntity> list =  baseMapper.selectList(wr);
            JSONArray result = TreeUtils.listToTree(JSONArray.parseArray(JSON.toJSONString(list)),"id","parentId","children");
            return result;
        }

        EntityWrapper<SysRoleEntity> ews = new EntityWrapper<SysRoleEntity>();
        ews.in("id",JSON.parseArray(AdminUserUtils.getUser().getRoleIdJson(),Long.class));
        List<SysRoleEntity> roleList = sysRoleDao.selectList(ews);
        Set<Long> set = new HashSet<Long>();
        for(SysRoleEntity a : roleList){
            set.addAll(JSON.parseArray(a.getMenuIdJson(),Long.class));
        }
        EntityWrapper<SysMenuEntity> wr = new EntityWrapper<SysMenuEntity> ();
        //查询所有业务表
        wr.in("type",new Object[]{"1","0"});
        wr.in("id",set);
        List<SysMenuEntity> list =  baseMapper.selectList(wr);
        JSONArray result = TreeUtils.listToTree(JSONArray.parseArray(JSON.toJSONString(list)),"id","parentId","children");
        return result;
    }

    /**
     * 获取所有菜单列表
     */
    private List<SysMenuEntity> getAllMenuList(List<Long> menuIdList) {
        //查询根菜单列表
        List<SysMenuEntity> menuList = queryListParentId(0L, menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList);

        return menuList;
    }

    @Override
    public List<SysMenuEntity> queryListParentId(Long parentId) {
        return baseMapper.queryListParentId(parentId);
    }

    @Override
    public List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
        List<SysMenuEntity> menuList = queryListParentId(parentId);
        if (menuIdList == null) {
            return menuList;
        }

        List<SysMenuEntity> userMenuList = new ArrayList<>();
        for (SysMenuEntity menu : menuList) {
            if (menuIdList.contains(menu.getId())) {
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    /**
     * 递归
     */
    private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> menuList, List<Long> menuIdList) {
        List<SysMenuEntity> subMenuList = new ArrayList<SysMenuEntity>();

        for (SysMenuEntity entity : menuList) {
            //目录
            if (entity.getType().equals("")) {
               // entity.setList(getMenuTreeList(queryListParentId(entity.getId(), menuIdList), menuIdList));
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }
    @Override
    public void insertPermission(String comments, String moduleName, String pathName) {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("url","modules/"+moduleName+"/"+pathName+".html");
        if(baseMapper.selectByMap(map).size()==0){
            SysMenuEntity entity = new SysMenuEntity();
            entity.setParentId(1L);
            entity.setName(comments);
            entity.setUrl("modules/"+moduleName+"/"+pathName+".html");
            entity.setPerms(null);
            entity.setType("1");
            entity.setIcon("fa fa-file-code-o");
            entity.setLevel(2);
            baseMapper.insert(entity);
            SysMenuEntity entity1 = new SysMenuEntity();
            entity1.setParentId(entity.getId());
            entity1.setName("查看");
            entity1.setUrl(null);
            entity1.setPerms(moduleName+":"+pathName+":list,"+moduleName+":"+pathName+":info");
            entity1.setType("2");
            entity1.setIcon("fa fa-file-code-o");
            entity1.setLevel(3);
            baseMapper.insert(entity1);
            entity1 = new SysMenuEntity();
            entity1.setParentId(entity.getId());
            entity1.setName("新增");
            entity1.setUrl(null);
            entity1.setPerms(moduleName+":"+pathName+":save");
            entity1.setType("2");
            entity1.setIcon("fa fa-file-code-o");
            entity1.setLevel(3);
            baseMapper.insert(entity1);
            entity1 = new SysMenuEntity();
            entity1.setParentId(entity.getId());
            entity1.setName("修改");
            entity1.setUrl(null);
            entity1.setPerms(moduleName+":"+pathName+":update");
            entity1.setType("2");
            entity1.setIcon("fa fa-file-code-o");
            entity1.setLevel(3);
            baseMapper.insert(entity1);
            entity1 = new SysMenuEntity();
            entity1.setParentId(entity.getId());
            entity1.setName("删除");
            entity1.setUrl(null);
            entity1.setPerms(moduleName+":"+pathName+":delete");
            entity1.setType("2");
            entity1.setIcon("fa fa-file-code-o");
            entity1.setLevel(3);
            baseMapper.insert(entity1);
        }

    }

    @Override
    @Transactional
    public void reMuneLevel() {
        EntityWrapper test = new EntityWrapper();
        test.orderBy("type");
       List<SysMenuEntity> list = this.selectList(test);
       for(SysMenuEntity item : list){
           SysMenuEntity f =  this.selectById(item.getParentId());
           if(f==null){
               item.setLevel(1);
           }else{
               item.setLevel(f.getLevel()+1);
           }
           this.updateEntity(item);
       }
    }

    @Override
    public Object menuLevel(Long userId) {
        //系统管理员，拥有最高权限
        if (userId == Constant.SUPER_ADMIN /*|| active.equals("dev")*/) {
            EntityWrapper<SysMenuEntity>  me = new EntityWrapper<SysMenuEntity>();
            me.eq("parent_id",0L);
            return baseMapper.selectList(me);
        }

        EntityWrapper<SysRoleEntity> ews = new EntityWrapper<SysRoleEntity>();
        ews.in("id",JSON.parseArray(AdminUserUtils.getUser().getRoleIdJson(),Long.class));
        List<SysRoleEntity> roleList = sysRoleDao.selectList(ews);
        Set<Long> set = new HashSet<Long>();
        for(SysRoleEntity a : roleList){
            set.addAll(JSON.parseArray(a.getMenuIdJson(),Long.class));
        }
        EntityWrapper<SysMenuEntity> wr = new EntityWrapper<SysMenuEntity> ();
        //查询所有业务表
        wr.and("parent_id",0);
        wr.in("type",new Object[]{"1","0"});
        wr.in("id",set);
        List<SysMenuEntity> list =  baseMapper.selectList(wr);
        return list;
    }
}
