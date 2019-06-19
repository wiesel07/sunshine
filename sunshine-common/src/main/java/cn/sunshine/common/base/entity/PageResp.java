package cn.sunshine.common.base.entity;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 分页请求响应模型
 * </p>
 *
 * @author wuj
 * @since 2019年6月13日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@ApiModel
public class PageResp<T> {

	@ApiModelProperty(value = "当前页码")
	private long current;

	@ApiModelProperty(value = "页面大小")
	private long size;

	@ApiModelProperty(value = "总数")
	private long total;

//	@ApiModelProperty(value = "总页码")
//	private Integer pages;
	
	@ApiModelProperty("记录")
	private List<T> rows;
}
