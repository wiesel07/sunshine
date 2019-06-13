package cn.sunshine.upms.entity.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuj
 * @since 2019年6月13日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysMenuReq请求对象")
public class SysMenuReq {

	@ApiModelProperty(value = "菜单ID")
	private Long menuId;

	@ApiModelProperty(value = "菜单编码")
	private String menuCode;

	@ApiModelProperty(value = "菜单名称")
	private String menuName;

	@ApiModelProperty(value = "父菜单ID")
	private Long menuPid;

	@ApiModelProperty(value = "菜单地址")
	private String menuUrl;

	@ApiModelProperty(value = "菜单图标")
	private String menuIcon;

	@ApiModelProperty(value = "菜单类型（0 目录 1菜单 2 按钮）")
	private String menuType;

	@ApiModelProperty(value = "排序")
	private Integer sortNo;

	@ApiModelProperty(value = "状态（启用 1 停用 0）")
	private String status;

	@ApiModelProperty(value = "备注")
	private String remark;
}
