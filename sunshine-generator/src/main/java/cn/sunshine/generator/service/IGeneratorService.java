package cn.sunshine.generator.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.sunshine.common.base.entity.PageReq;
import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.generator.entity.TableField;
import cn.sunshine.generator.entity.TableInfo;

public interface IGeneratorService {

	/**
	 * 
	 * @Description:获取当前数据库表信息列表
	 * @param map
	 * @param pageReq
	 * @return
	 *
	 * @date 创建时间：2019年6月17日
	 * @author 作者：wuj
	 */
	PageResp<TableInfo> queryPage(Map<String, Object> map, PageReq pageReq);

	/**
	 * 
	 * @Description:根据表名查询对应表的相应信息
	 * @param tableName
	 * @return
	 *
	 * @date 创建时间：2019年6月17日
	 * @author 作者：wuj
	 */
	TableInfo queryTable(String tableName);

	/**
	 * 
	 * @Description:根据表名查询对应表的列信息
	 * @param tableName
	 * @return
	 *
	 * @date 创建时间：2019年6月17日
	 * @author 作者：wuj
	 */
	List<TableField> queryColumns(String tableName);

	/**
	 * 
	 * @Description:生成代码
	 * @param tableNames
	 * @return
	 * @throws IOException
	 *
	 * @date 创建时间：2019年6月17日
	 * @author 作者：wuj
	 */
	byte[] generatorCode(String[] tableNames) throws IOException;

}
