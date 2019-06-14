package cn.sunshine.common.enums;

/**
 * <p>
 * 枚举基类
 * </p>
 *
 * @author wuj
 * @since 2019年6月14日
 */

public interface BaseEnum<E extends Enum<?>, T> {
	
	T getValue();

	String getName();

	boolean isContainKey(T key);

}


