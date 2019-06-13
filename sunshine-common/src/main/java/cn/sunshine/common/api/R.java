package cn.sunshine.common.api;

import java.io.Serializable;
import java.util.Optional;

import cn.sunshine.common.enums.ApiErrorCode;
import lombok.Data;

/**
 * <p>
 * 通用请求返回结果
 * </p>
 *
 * @author wuj
 * @since 2019年6月13日
 */
@Data
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 业务错误码 00-成功
	 */
	private String respCode;

	/**
	 * 描述
	 */
	private String respMsg;

	/**
	 * 结果集
	 */
	private T data;

	public R() {
		super();
		this.respCode = "00";
		this.respMsg = "请求成功";
	}

	
    public R(T data) {
//    	if(data instanceof CommonError) {
//    		CommonError error = (CommonError) data;
//    		this.respCode = error.getCode();
//            this.respMsg = String.format("%s", error.getMsg());
//        	this.data = data;
//    	} else {
//			this.respCode = "00";
//			this.respMsg = "请求成功";
//			this.data = data;
//    	}
		this.respCode = "00";
		this.respMsg = "请求成功";
		this.data = data;
    }
	
	public R(IErrorCode errorCode) {
		// orElseGet若不为空值，orElseGet() 方法不创建对象。
		errorCode = Optional.ofNullable(errorCode).orElseGet(() -> ApiErrorCode.FAILED);
		this.respCode = errorCode.getCode();
		this.respMsg = errorCode.getMsg();
	}

	public R(String respCode, String respMsg) {
		this.respCode = respCode;
		this.respMsg = respMsg;
	}

	public R(String respCode, String respMsg, T data) {
		this.respCode = respCode;
		this.respMsg = respMsg;
		this.data = data;
	}
}
