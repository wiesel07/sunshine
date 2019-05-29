package cn.sunshine.upms.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色菜单
 * </p>
 *
 * @author wuj
 * @since 2019-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("bf_upms_role_menu")
@ApiModel(value = "BfUpmsRoleMenu对象", description = "角色菜单")
public class BfUpmsRoleMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "ID", type = IdType.ID_WORKER)
	private BigDecimal id;

	@TableField("ROLE_ID")
	private BigDecimal roleId;

	@TableField("MENU_ID")
	private BigDecimal menuId;

	public static final String ID = "ID";

	public static final String ROLE_ID = "ROLE_ID";

	public static final String MENU_ID = "MENU_ID";

}
