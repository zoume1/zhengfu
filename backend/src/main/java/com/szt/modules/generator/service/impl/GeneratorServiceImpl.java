package com.szt.modules.generator.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.szt.common.CommonServiceImpl;
import com.szt.common.utils.PageUtils;
import com.szt.common.utils.GenUtils;
import com.szt.modules.generator.dao.GeneratorModulesDao;
import com.szt.modules.generator.dao.GeneratorTemplateDao;
import com.szt.modules.generator.dao.SysGeneratorDao;
import com.szt.modules.generator.entity.*;
import com.szt.modules.generator.service.GeneratorService;
import com.szt.modules.generator.service.GeneratorTemplateConfigService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月19日 下午3:33:38
 */
@Slf4j
@Service("generatorServiceImpl")
public class GeneratorServiceImpl extends CommonServiceImpl<GeneratorModulesDao, GeneratorModulesEntity> implements GeneratorService {
	@Autowired
	private SysGeneratorDao sysGeneratorDao;
	@Autowired
	private GeneratorTemplateDao generatorTemplateDao;
	@Autowired
	private GeneratorTemplateConfigService generatorTemplateConfigService;

	public PageUtils queryList(Map<String, Object> params) {
        Page<Map<String, Object>> page = new Page<Map<String, Object>>(
                Integer.parseInt((String)params.get("page")),
                Integer.parseInt((String)params.get("limit"))
        );
        page.setRecords(sysGeneratorDao.queryList(page,params));
        return new PageUtils(page, null);
	}

	public int queryTotal(Map<String, Object> map) {
		return sysGeneratorDao.queryTotal(map);
	}

	public GeneratorTableEntity queryTable(String tableName) {
		return sysGeneratorDao.queryTable(tableName);
	}

	public List<GeneratorTableFieldEntity> queryColumns(String tableName) {
		return sysGeneratorDao.queryColumns(tableName);
	}
	@Transactional
	public byte[] generatorCode(String[] tableNames) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);
		List<ColumnListEntity> lists = new ArrayList<ColumnListEntity>();
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		Map<String, GeneratorTemplateConfigEntity> config  = generatorTemplateConfigService.queryGeneratorTemplateConfig();
		List<GeneratorTemplateEntity> templates = generatorTemplateDao.queryGeneratorTemplateList();
		for(String tableName : tableNames){
			//查询表信息
			GeneratorTableEntity table = queryTable(tableName);
			//查询列信息
			List<GeneratorTableFieldEntity> columns = queryColumns(tableName);
			table.setColumns(columns);
			//生成代码
			GenUtils.generatorCode(table, zip,lists,map,config,templates);
		}
		IOUtils.closeQuietly(zip);
		//def
		return outputStream.toByteArray();
	}




	private void queryTables() {
	}
}
