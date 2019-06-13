package cn.sunshine.upms.entity.req;

import cn.sunshine.common.base.entity.PageReq;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 菜单分页请求数据模型
 * </p>
 *
 * @author wuj
 * @since 2019年6月13日
 */

public class SysMenuPageReq extends PageReq {

	@ApiModelProperty(value = "菜单编码")
	private String menuCode;

	@ApiModelProperty(value = "菜单名称")
	private String menuName;
}
