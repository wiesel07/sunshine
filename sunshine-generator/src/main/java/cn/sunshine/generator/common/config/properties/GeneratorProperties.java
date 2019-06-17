package cn.sunshine.generator.common.config.properties;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;

/**
 * <p>
 * 代码生成文件配置参数
 * </p>
 *
 * @author wuj
 * @since 2019年6月17日
 */
@Data
public class GeneratorProperties {

	private String author;

	/**
	 * 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
	 */
	private String parent;

	private String moduleName;

	private String entityName;

	private String mapperName;

	private String xmlName;

	private String serviceName;

	private String serviceImplName;

	private String controllerName;

	/**
	 * 是否自动去掉表前缀，默认否
	 */
	private Boolean autoRemovePre;
	/**
	 * 表前缀
	 */
	private String tablePrefix;

	private String mybatisPath;

	private String xmlPath;

	private String busType;

	public static final String AUTHOR = "author";
	public static final String PARENT = "parent";
	public static final String MODULE_NAME = "moduleName";
	public static final String ENTITY_NAME = "entityName";
	public static final String MAPPER_NAME = "mapperName";
	public static final String XML_NAME = "xmlName";
	public static final String SERVICE_NAME = "serviceName";
	public static final String SERVICE_IMPL_NAME = "serviceImplName";
	public static final String CONTROLLER_NAME = "controllerName";
	public static final String AUTO_REMOVE_PRE = "autoRemovePre";
	public static final String TABLE_PRE_FIX = "tablePrefix";

	/**
	 * 
	 * @Description:获取生成策略配置实体
	 * @return
	 *
	 * @date 创建时间：2019年6月17日
	 * @author 作者：wuj
	 */
	public static GeneratorProperties getGeneratorProperties() {

		Map<String, Object> results = new HashMap<>();
		try {
			PropertiesConfiguration conf = new PropertiesConfiguration("generator.properties");
			Iterator<String> iterators = conf.getKeys();
			while (iterators.hasNext()) {
				String key = iterators.next();
				results.put(key, conf.getProperty(key));
			}

			return BeanUtil.mapToBean(results, GeneratorProperties.class, true);
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
