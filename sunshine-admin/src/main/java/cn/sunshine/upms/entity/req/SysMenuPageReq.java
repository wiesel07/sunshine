package cn.sunshine.upms.entity.req;

import cn.sunshine.common.base.entity.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单分页请求数据模型
 * </p>
 *
 * @author wuj
 * @since 2019年6月13日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "菜单分页请求对象")
public class SysMenuPageReq extends PageReq {

	@ApiModelProperty(value = "菜单编码")
	private String menuCode;

	@ApiModelProperty(value = "菜单名称")
	private String menuName;
}
