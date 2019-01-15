package com.szt;

import com.szt.modules.generator.config.InitBusConfig;
import com.szt.modules.generator.dao.GeneratorTableDao;
import com.szt.modules.generator.entity.GeneratorTableEntity;
import com.szt.modules.generator.service.GeneratorBusConfigService;
import com.szt.modules.generator.service.GeneratorTableFieldService;
import com.szt.modules.generator.service.GeneratorTableService;
import com.szt.modules.sys.entity.SysPbAreaEntity;
import com.szt.modules.sys.service.SysConfigService;
import com.szt.modules.sys.service.SysMenuService;
import com.szt.modules.sys.service.SysPbAreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {
    @Autowired
    private GeneratorTableFieldService  generatorTableFieldService;
    @Autowired
    private GeneratorTableService  generatorTableService;
    @Autowired
    private SysPbAreaService sysPbAreaService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private GeneratorTableDao generatorTableDao;
    @Autowired
    private GeneratorBusConfigService generatorBusConfigService;
    /**
     * 更新字段索引
     */
    @Test
    public void test() {
        generatorTableFieldService.tabFieldIndexReload();
    }
    /**
     * 更新字段类型为下拉
     */
    @Test
    public void test1() {
        generatorTableFieldService.tabFieldTypeReload();
    }
    /**
     * 刷新地址列表
     */
    @Test
    public void test2() {
        sysPbAreaService.addressReload();
    }
    /**
     * 刷新地址缓存
     */
    @Test
    public void test3() {
     //   InitBusConfig.updateAddressConfig();
    }
    /**
     * 刷新字段表所有数据长度
     */
    @Test
    public void test4() {
        generatorTableFieldService.updateDataLength();
        //   InitBusConfig.updateAddressConfig();
    }
    /**
     * 刷新字段表所有数据长度
     */
    @Test
    public void test5() {
        sysPbAreaService.defaultData();
        //   InitBusConfig.updateAddressConfig();
    }
    /**
     * excel导出模板
     */
    @Test
    public void test6() {
        generatorTableService.excelModule("module");
    }
    /**
     * 刷新菜单层级
     */
    @Test
    public void reMuneLevel() {
        sysMenuService.reMuneLevel();
    }

    /**
     * 重新加载业务表格的tabId
     */
    @Test
    public void reloadBusconfig(){
        generatorBusConfigService.reloadBusconfig();
    }
    @Test
    public void test8(){
        GeneratorTableEntity tab = new GeneratorTableEntity();
        tab.setTableName("lp_users");
        Boolean boo = generatorTableDao.tableExist(tab.getTableName());
        System.out.println(boo);
    }
}
