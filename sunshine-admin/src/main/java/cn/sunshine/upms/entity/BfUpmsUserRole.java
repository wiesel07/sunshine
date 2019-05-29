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
 * 用户角色
 * </p>
 *
 * @author wuj
 * @since 2019-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("bf_upms_user_role")
@ApiModel(value = "BfUpmsUserRole对象", description = "用户角色")
public class BfUpmsUserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "ID", type = IdType.ID_WORKER)
	private BigDecimal id;

	@TableField("USER_ID")
	private BigDecimal userId;

	@TableField("ROLE_ID")
	private BigDecimal roleId;

	public static final String ID = "ID";

	public static final String USER_ID = "USER_ID";

	public static final String ROLE_ID = "ROLE_ID";

}
