package cn.sunshine.generator.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.sunshine.common.base.entity.PageReq;
import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.generator.common.utils.GenUtils;
import cn.sunshine.generator.entity.TableField;
import cn.sunshine.generator.entity.TableInfo;
import cn.sunshine.generator.mapper.GeneratorMapper;
import cn.sunshine.generator.service.IGeneratorService;

@Service
public class GeneratorServiceImpl implements IGeneratorService {

	@Autowired
	private GeneratorMapper generatorMapper;

	public PageResp<TableInfo> queryPage(Map<String, Object> map, PageReq pageReq) {
		PageResp<TableInfo> pageResp = new PageResp<TableInfo>();

		Page<TableInfo> page = new Page<>(pageReq.getPageNo(), pageReq.getPageSize());
		List<TableInfo> rows = generatorMapper.queryPage(map, page);
		pageResp.setRows(rows);
		pageResp.setTotal(page.getTotal());

		return pageResp;
	}

	public TableInfo queryTable(String tableName) {
		return generatorMapper.queryTable(tableName);
	}

	public List<TableField> queryColumns(String tableName) {
		return generatorMapper.queryColumns(tableName);
	}

	public byte[] generatorCode(String[] tableNames) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);

		for (String tableName : tableNames) {

			// 查询表信息
			TableInfo tableInfo = queryTable(tableName);
			// 查询列信息
			List<TableField> tableFields = queryColumns(tableName);

			// 生成代码
			GenUtils.generatorCode(tableInfo, tableFields, zip);
		}
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}

}
