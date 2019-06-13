package cn.sunshine.common.api;

/**
 * <p>
 * REST API 错误码接口
 * </p>
 *
 * @author wuj
 * @since 2019年6月13日
 */

public interface IErrorCode {
	/**
	 * 错误编码 0、正常 1、失败
	 */
	String getCode();

	/**
	 * 错误描述
	 */
	String getMsg();
}
