package cn.sunshine.generator.common.enums;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuj
 * @since 2019年6月17日
 */

public interface IColumnType {
	 /**
     * <p>
     * 获取字段类型
     * </p>
     *
     * @return 字段类型
     */
    String getType();

    /**
     * <p>
     * 获取字段类型完整名
     * </p>
     *
     * @return 字段类型完整名
     */
    String getPkg();
}



