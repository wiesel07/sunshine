package cn.sunshine.common.enums;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

/**
 * <p>
 * 菜单类型枚举
 * </p>
 *
 * @author wuj
 * @since 2019年6月14日
 */

public enum MenuType implements BaseEnum<MenuType, String> {
	
	CATALOG("0", "目录"), 
	MENU("1", "菜单"), 
	BUTTON("2", "功能按钮");
	
	@Getter
	private String code;

	@Getter
	private String msg;


	MenuType(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
	static Map<String, MenuType> enumMap = new HashMap<String, MenuType>();
	static {
		for (MenuType value : MenuType.values()) {
			enumMap.put(value.getValue(), value);
		}
	}
	
	public static MenuType parse(String code) {
		return enumMap.get(code);
	}


    @Override
	public boolean isContainKey(String key) {
		return enumMap.containsKey(key);
	}


    @Override
	public String getValue() {
		return this.code;
	}

    @Override
	public String getName() {
		return this.msg;
	}
}




