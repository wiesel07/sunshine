package cn.sunshine.common.enums;

import cn.sunshine.common.api.IErrorCode;

/**
 * <p>
 * REST API 错误码
 * </p>
 *
 * @author wuj
 * @since 2019年6月13日
 */

public enum ApiErrorCode implements IErrorCode {

	SUCCESS("0", "成功"),

	FAILED("1", "失败");

	private final String code;
	private final String msg;

	ApiErrorCode(final String code, final String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return String.format(" ErrorCode:{code=%s, msg=%s} ", code, msg);
	}
}
