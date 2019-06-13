package cn.sunshine.common.base.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 分页请求数据模型
 * </p>
 *
 * @author wuj
 * @since 2019年6月13日
 */
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PageReq {

	@ApiModelProperty(value = "当前页码", required = true)
	@NotNull(message = "当前页码不能为空")
	@Min(value = 1L, message = "当前页码不能小于1")
	private Integer pageNo;

	@ApiModelProperty(value = "页面大小", required = true)
	@NotNull(message = "页面大小不能为空")
	@Min(value = 1L, message = "页码大小范围：1-500")
	@Max(value = 500L, message = "页码大小范围：1-500")
	private Integer pageSize;
}
