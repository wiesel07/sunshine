package cn.sunshine.common.util;

import lombok.experimental.UtilityClass;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuj
 * @param <T>
 * @param <S>
 * @since 2019年6月17日
 */
@UtilityClass
public class Toolkit<S, T> {

	/**
	 * 公用转换器
	 */
	@SuppressWarnings("rawtypes")
	public  CommonConverter converter = new CommonConverter<>();
}
