package cn.sunshine.common.enums;

import cn.sunshine.common.api.IErrorCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuj
 * @since 2019年6月14日
 */

public enum UpmsErrorCode implements IErrorCode {

	
	CHECK_FAIL("1001001", "%S"), 
	CHECK_PARAMS_VALID("1001001", "参数校验失败[%s]%s"),
	CHECK_NOT_READABLE("1001002", "参数无效或格式异常"),
	CHECK_NOT_HANDLER("101004", "非法访问"),
	SQL_INSERT_ERROR("1018001","数据插入错误"),
	SQL_UPDATE_ERROR("1018002","数据更新错误"),
	SQL_DELETE_ERROR("1018003","数据删除错误"),

	
	MENU_CODE_IS_EXIST("2000001","菜单编码已存在"),
	MENU_CODE_IS_NOTEXIST("2000002","菜单编码不存在"),
	MENU_PARENT_IS_NOTEXIST("2000003","父类菜单不存在"),
	MENU_URL_IS_EMPTY("2000004","菜单类型为菜单时URL地址不能为空"),
	MENU_IS_NOTEXIST("2000001","菜单不存在"),
	MENU_CHILDREN_IS_EXIST("2000001","该菜单存在子菜单"),
	MENU_IS_USED("2000001","菜单被角色使用中，请先修改相应角色菜单权限");
//	MENU_PCODE_IS_NOTEXIST("2000001","父菜单编码不存在"),

//

//	MENU_CHILDREN_IS_EXIST("2000001","该菜单存在子菜单"),
//	MENU_FUNCTION_IS_NOTEXIST("2000001","菜单功能不存在");
	
	
	private final String code;
	private final String msg;

	UpmsErrorCode(final String code, final String msg) {
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



