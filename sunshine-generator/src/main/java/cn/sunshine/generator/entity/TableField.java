package cn.sunshine.generator.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 表实体对应字段信息
 * </p>
 *
 * @author wuj
 * @since 2019年6月17日
 */
@Data
@Accessors(chain = true)
public class TableField {
	// 字段名，如BILL_ID
	private String columnName;

	private String dataType;

	// 是否主键PRI
	private String key;

	private String comments;

	private Integer dataLength;

	private String nullable;

	// 根据dataType转换成java中对应的数据类型
	private String propertyType;

	// 列名(第一个字母小写)，如：org_id =>orgId
	private String propertyName;

	// 列名(第一个字母大写)，如：org_id =>OrgId
	private String capitalName;

}
