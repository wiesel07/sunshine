package cn.sunshine.generator.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import cn.sunshine.generator.entity.TableField;
import cn.sunshine.generator.entity.TableInfo;

@Mapper
public interface GeneratorMapper {

	/**
	 * 
	 * @Description:获取当前数据库表信息列表
	 * @param map
	 * @return
	 *
	 * @date 创建时间：2019年6月17日
	 * @author 作者：wuj
	 * @param <T>
	 * @param <T>
	 */
	List<TableInfo> queryPage(@Param(Constants.COLUMN_MAP) Map<String, Object> map,
			IPage<TableInfo> page);

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

}
