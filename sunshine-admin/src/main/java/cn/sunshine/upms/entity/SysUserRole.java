package cn.sunshine.upms.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

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
 * @since 2019-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysUserRole对象", description = "用户角色")
public class SysUserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "ID", type = IdType.ID_WORKER)
	private Long id;

	@TableField("USER_ID")
	private Long userId;

	@TableField("ROLE_ID")
	private Long roleId;

	public static final String ID = "ID";

	public static final String USER_ID = "USER_ID";

	public static final String ROLE_ID = "ROLE_ID";

}
