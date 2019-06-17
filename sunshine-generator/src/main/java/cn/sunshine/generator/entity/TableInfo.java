package cn.sunshine.generator.entity;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 表实体
 * </p>
 *
 * @author wuj
 * @since 2019年6月17日
 */
@Data
@Accessors(chain = true)
public class TableInfo {
	// 所属用户
	private String owner;

	// 表类型
	private String tableType;

	// 表名，如AIMS_USE
	private String tableName;

	// 表备注
	private String engine;

	// 表备注
	private String tableComment;

	// 表的主键
	TableField pk;

	// 表的列名(不包含主键)
	List<TableField> tableFields;

	// 类名(第一个字母小写)，如：sys_user => sysUser
	private String className;

	// 类名(第一个字母大写)，如：sys_user => SysUser
	private String capitalClassName;
}
