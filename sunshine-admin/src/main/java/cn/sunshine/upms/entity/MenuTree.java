package cn.sunshine.upms.entity;

import cn.sunshine.common.base.entity.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单树实体对象
 * </p>
 *
 * @author wuj
 * @since 2019年6月14日
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "菜单树响应对象")
public class MenuTree extends TreeNode {

	private static final long serialVersionUID = 1L;

//	@ApiModelProperty(value = "父菜单编码")
//	private String menuPcode;
//
//	@ApiModelProperty(value = "父菜单名称")
//	private String menuPname;

	@ApiModelProperty(value = "菜单地址")
	private String menuUrl;

	@ApiModelProperty(value = "菜单图标")
	private String menuIcon;

	@ApiModelProperty(value = "菜单类型（0 目录 1菜单 2 按钮）")
	private String menuType;

//	@ApiModelProperty(value = "排序")
//	private Integer sortNo;
//
//	@ApiModelProperty(value = "状态（启用 1 停用 0）")
//	private String status;
//
//	@ApiModelProperty(value = "备注")
//	private String remark;
}



