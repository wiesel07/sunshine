package cn.sunshine.common;

import cn.sunshine.common.api.IErrorCode;
import lombok.Getter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuj
 * @since 2019年6月14日
 */

public class SunshineException extends RuntimeException {

	private static final long serialVersionUID = -6188829639109514288L;

	/**
	 * 错误码
	 */
	@Getter
	private IErrorCode errorCode;

	
	public SunshineException(IErrorCode errorCode) {
    	super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

	public SunshineException(String message) {
        super(message);
    }

	public SunshineException(Throwable cause) {
        super(cause);
    }

	public SunshineException(String message, Throwable cause) {
        super(message, cause);
    }
	


}
