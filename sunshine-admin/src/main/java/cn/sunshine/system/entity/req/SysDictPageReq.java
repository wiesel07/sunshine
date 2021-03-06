package cn.sunshine.system.entity.req;

import cn.sunshine.common.base.entity.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

 /**
 * <p>
 *  数据字典 分页请求对象
 * </p>
 *
 * @author wuj
 * @since 2019-06-20
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("数据字典 分页请求对象")
public class SysDictPageReq extends PageReq<SysDictPageReq>  {

    
    
    @ApiModelProperty(value ="字典编码")
    private String dictCode;
    
    @ApiModelProperty(value ="字典名称")
    private String dictName;
    
    @ApiModelProperty(value ="备注")
    private String remark;
    
    
    @ApiModelProperty(value ="状态（启用 1  停用 0）")
    private String status;
	
}
