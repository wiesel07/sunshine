package cn.sunshine.generator.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.sunshine.common.util.StrUtilExt;
import cn.sunshine.generator.common.config.properties.GeneratorProperties;
import cn.sunshine.generator.common.enums.DbColumnType;
import cn.sunshine.generator.common.enums.IColumnType;
import cn.sunshine.generator.entity.TableField;
import cn.sunshine.generator.entity.TableInfo;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 代码生成工具类
 * </p>
 *
 * @author wuj
 * @since 2019年6月17日
 */

@Slf4j
@UtilityClass
public class GenUtils {

	public void generatorCode(TableInfo tableInfo, List<TableField> tableFields, ZipOutputStream zip) {
		tableInfo = getTableInfo(tableInfo, tableFields);
		VelocityContext context = getVelocityContext(tableInfo, tableFields);

		// 获取模板列表
		List<String> templates = getTemplates();
		for (String template : templates) {
			// 渲染模板
			StringWriter sw = new StringWriter();
			Template tpl = Velocity.getTemplate(template, "UTF-8");
			tpl.merge(context, sw);
			try {
				// 添加到zip
				log.info(template);
				zip.putNextEntry(new ZipEntry(getFileName(template, tableInfo)));
				IOUtils.write(sw.toString(), zip, "UTF-8");

				IOUtils.closeQuietly(sw);
				zip.closeEntry();
			} catch (IOException e) {
				e.printStackTrace();
				log.info("渲染模板失败，表名：" + tableInfo.getTableName());
			}
		}

	}

	/**
	 * 获取文件名
	 */
	private String getFileName(String template, TableInfo tableInfo) {

		GeneratorProperties generatorProperties = GeneratorProperties.getGeneratorProperties();
		String capitalClassName = tableInfo.getCapitalClassName();
		String classname = tableInfo.getClassName();

		String capitalEntityName = String.format(generatorProperties.getEntityName(), capitalClassName);
		String capitalEntityReqName = capitalEntityName + "Req";
		String capitalEntityPageReqName = capitalEntityName + "PageReq";
		String capitalEntityRespName = capitalEntityName + "Resp";
		String capitalEntityPageRespName = capitalEntityName + "PageResp";

		String capitalMapperName = String.format(generatorProperties.getMapperName(), capitalClassName);
		String capitalXmlName = String.format(generatorProperties.getXmlName(), capitalClassName);
		String capitalServiceName = String.format(generatorProperties.getServiceName(), capitalClassName);
		String capitalServiceImplName = String.format(generatorProperties.getServiceImplName(), capitalClassName);
		String capitalControllerName = String.format(generatorProperties.getControllerName(), capitalClassName);
		String packagePath = "";
		
		String moduleName = generatorProperties.getModuleName(); 
		String basePath="sunshine/sunshine-admin/src/main/java/cn/sunshine"+File.separator+moduleName;
		String mapperXmlBasePath="sunshine/sunshine-admin/src/main/resources/cn/sunshine"+File.separator+moduleName;
		if (template.contains("Entity.java.vm")) {
			packagePath = basePath+File.separator +"entity"+ File.separator+ capitalEntityName + ".java";
			return packagePath;
		}
		
		if (template.contains("EntityReq.java.vm")) {
			packagePath = basePath+File.separator +"entity"+ File.separator+"req" +File.separator+capitalEntityReqName + ".java";
			return packagePath;
		}
		
		if (template.contains("EntityPageReq.java.vm")) {
			packagePath = basePath+File.separator +"entity"+ File.separator+"req" +File.separator+capitalEntityPageReqName + ".java";
			return packagePath;
		}

		if (template.contains("EntityResp.java.vm")) {
			packagePath = basePath+File.separator +"entity"+ File.separator+ "resp"+File.separator+capitalEntityRespName + ".java";
			return packagePath;
		}
		
		if (template.contains("EntityPageResp.java.vm")) {
			packagePath = basePath+File.separator +"entity"+ File.separator+ "resp"+File.separator+capitalEntityPageRespName + ".java";
			return packagePath;
		}
		
		if (template.contains("Service.java.vm") && (!template.contains("ServiceImpl.java.vm"))) {
			packagePath = basePath + File.separator+"service"+ File.separator
					+ capitalServiceName + ".java";
			return packagePath;
		}
		if (template.contains("ServiceImpl.java.vm")) {
			packagePath =basePath + File.separator+"service"+File.separator+"impl"+ File.separator
					+ capitalServiceImplName + ".java";
			return packagePath;
		}
		if (template.contains("Mapper.java.vm")) {
			packagePath = basePath + File.separator +"mapper"+ File.separator+ capitalMapperName + ".java";
			return packagePath;
		}

		if (template.contains("Controller.java.vm")) {
			packagePath = basePath + File.separator + "controller"+File.separator+capitalControllerName + ".java";
			return packagePath;
		}

		

		if (template.contains("Mapper.xml.vm")) {
			packagePath = mapperXmlBasePath + File.separator + capitalXmlName + ".xml";
			return packagePath;
		}
		

		return null;
	}

	private List<String> getTemplates() {
		List<String> templates = new ArrayList<String>();

		templates.add("vm/common/api/entity/Entity.java.vm");
		templates.add("vm/common/api/entity/req/EntityPageReq.java.vm");
		templates.add("vm/common/api/entity/req/EntityReq.java.vm");
		templates.add("vm/common/api/entity/resp/EntityResp.java.vm");
		templates.add("vm/common/api/entity/resp/EntityPageResp.java.vm");
		templates.add("vm/common/api/service/Service.java.vm");
		
		templates.add("vm/common/spi/serviceImpl/ServiceImpl.java.vm");
		templates.add("vm/common/spi/mapper/Mapper.java.vm");
		templates.add("vm/common/spi/xml/Mapper.xml.vm");
		
		templates.add("vm/common/web/Controller.java.vm");
		

		return templates;
	}

	private VelocityContext getVelocityContext(TableInfo tableInfo, List<TableField> tableFields) {

		GeneratorProperties generatorProperties = GeneratorProperties.getGeneratorProperties();
		// 设置velocity资源加载器
		Properties prop = new Properties();
		prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		Velocity.init(prop);
		Map<String, Object> result = assembleData(tableInfo);

//		List<Long> ids = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			ids.add(IDUtils.newID());
//		}
//		result.put("ids", ids);
		result.put("author", generatorProperties.getAuthor());
		result.put("createDate", DateUtil.format(DateUtil.date(), DatePattern.NORM_DATE_PATTERN));
		return new VelocityContext(result);
	}

	// 组装模板数据
	private Map<String, Object> assembleData(TableInfo tableInfo) {

		GeneratorProperties generatorProperties = GeneratorProperties.getGeneratorProperties();
		// 封装模板数据
		Map<String, Object> map = new HashMap<>();

		String capitalClassName = tableInfo.getCapitalClassName();
		map.put("tableName", tableInfo.getTableName());
		map.put("tableComment", org.apache.commons.lang3.StringUtils.trim(tableInfo.getTableComment()));
		map.put("pk", tableInfo.getPk());
		map.put("className", tableInfo.getClassName());
		map.put("path", tableInfo.getClassName());
		map.put("capitalClassname", capitalClassName);
		map.put("tableFields", tableInfo.getTableFields());
		map.put("parent", generatorProperties.getParent());
		String moduleName = generatorProperties.getModuleName();
		map.put("moduleName", moduleName);
		if (StrUtil.isNotBlank(moduleName)) {
			map.put("packageName", generatorProperties.getParent() + "." + moduleName);
		} else {
			map.put("packageName", generatorProperties.getParent());
		}

		map.put("controllerPackageName", generatorProperties.getParent());
		// map.put("author", generatorProperties.getAuthor());
		// map.put("createDate", DateUtil.format(DateUtil.date(),
		// DatePattern.NORM_DATE_PATTERN));

		// 实体
		String capitalEntityName = String.format(generatorProperties.getEntityName(), capitalClassName);
		map.put("capitalEntityName", capitalEntityName);
		map.put("capitalEntityReqName", capitalEntityName + "Req");
		map.put("capitalEntityPageReqName", capitalEntityName + "PageReq");
		map.put("capitalEntityRespName", capitalEntityName + "Resp");
		map.put("capitalEntityPageRespName", capitalEntityName + "PageResp");
		map.put("entityName", StringUtils.uncapitalize(capitalEntityName));
		map.put("entityReqName", StringUtils.uncapitalize(capitalEntityName) + "Req");
		map.put("entityRespName", StringUtils.uncapitalize(capitalEntityName) + "Resp");
		map.put("entityPageRespName", StringUtils.uncapitalize(capitalEntityName) + "PageResp");
		map.put("entityPageReqName", StringUtils.uncapitalize(capitalEntityName) + "PageReq");

		// mapper
		String capitalMapperName = String.format(generatorProperties.getMapperName(), capitalClassName);
		map.put("capitalMapperName", capitalMapperName);
		map.put("mapperName", StringUtils.uncapitalize(capitalMapperName));

		map.put("xmlName", String.format(generatorProperties.getXmlName(), capitalClassName));

		// 服务层接口
		String capitalServiceName = String.format(generatorProperties.getServiceName(), capitalClassName);
		map.put("capitalServiceName", capitalServiceName);
		map.put("serviceName", StringUtils.uncapitalize(capitalServiceName));

		String capitalServiceImplName = String.format(generatorProperties.getServiceImplName(), capitalClassName);
		map.put("capitalServiceImplName", capitalServiceImplName);
		map.put("serviceImplName", StringUtils.uncapitalize(capitalServiceImplName).replace("Impl", ""));

		map.put("capitalControllerName", String.format(generatorProperties.getControllerName(), capitalClassName));

		return map;
	}

	// 生成渲染表的信息
	private TableInfo getTableInfo(TableInfo tableInfo, List<TableField> tableFields) {
		GeneratorProperties generatorProperties = GeneratorProperties.getGeneratorProperties();
		// 表名转换成Java类名
		String className = tableToJava(tableInfo.getTableName(), generatorProperties.getTablePrefix());
		tableInfo.setCapitalClassName(className);// 设置类名(第一个字母大写)
		tableInfo.setClassName(StringUtils.uncapitalize(className)); // 设置类名(第一个字母小写)

		for (TableField tableField : tableFields) {
			tableField.setPropertyType(processTypeConvert(tableField.getDataType()).getType());

			// 列名转换成Java属性名
			String capitalName = columnToJava(tableField.getColumnName());
			tableField.setCapitalName(capitalName);
			tableField.setPropertyName(StringUtils.uncapitalize(capitalName));
			tableField.setComments(org.apache.commons.lang3.StringUtils.trimToEmpty(tableField.getComments()));
			// 是否主键
			if (StrUtilExt.isNotEmpty(tableField.getKey()) && "PRI".equalsIgnoreCase(tableField.getKey())) {
				tableInfo.setPk(tableField);
			}
		}
		if (ObjectUtil.isNull(tableInfo.getPk())) {
			tableInfo.setPk(tableFields.get(0));
		}
		tableInfo.setTableFields(tableFields);
		return tableInfo;
	}

	/**
	 * 
	 * @Description:表名转换成Java类名(替换指定表前缀为空)
	 * @param tableName
	 * @param tablePrefix
	 * @return
	 *
	 * @date 创建时间：2019年6月17日
	 * @author 作者：wuj
	 */
	private String tableToJava(String tableName, String tablePrefix) {
		if (StringUtils.isNotBlank(tablePrefix)) {
			tableName = tableName.replace(tablePrefix, "");
		}
		return columnToJava(tableName);
	}

	/**
	 * 
	 * @Description:列名转换成Java属性名
	 * @param columnName
	 * @return
	 *
	 * @date 创建时间：2019年6月17日
	 * @author 作者：wuj
	 */
	private String columnToJava(String columnName) {
		return WordUtils.capitalizeFully(columnName, new char[] { '_' }).replace("_", "");
	}

	private IColumnType processTypeConvert(String fieldType) {
		String t = fieldType.toLowerCase();
		if (t.contains("char")) {
			return DbColumnType.STRING;
		} else if (t.contains("date") || t.contains("timestamp")) {
			// switch (globalConfig.getDateType()) {
			// case ONLY_DATE:
			return DbColumnType.DATE;
			// case SQL_PACK:
			// return DbColumnType.TIMESTAMP;
			// case TIME_PACK:
			// return DbColumnType.LOCAL_DATE_TIME;
			// }
		} else if (t.contains("number")) {
			if (t.matches("number\\(+\\d\\)")) {
				return DbColumnType.INTEGER;
			} else if (t.matches("number\\(+\\d{2}+\\)")) {
				return DbColumnType.LONG;
			} else if (t.contains(",")) {
				return DbColumnType.BIG_DECIMAL;
			} else if (StrUtil.equalsIgnoreCase("number", t)) {
				return DbColumnType.INTEGER;
			}
			return DbColumnType.DOUBLE;
		} else if (t.contains("float")) {
			return DbColumnType.FLOAT;
		} else if (t.contains("clob")) {
			// return DbColumnType.CLOB;
			return DbColumnType.STRING;
		} else if (t.contains("blob")) {
			return DbColumnType.BLOB;
		} else if (t.contains("binary")) {
			return DbColumnType.BYTE_ARRAY;
		} else if (t.contains("raw")) {
			return DbColumnType.BYTE_ARRAY;
		}
		return DbColumnType.STRING;
	}
}