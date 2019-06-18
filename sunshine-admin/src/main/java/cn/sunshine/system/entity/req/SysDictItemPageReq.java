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
 *  数据字典项 分页请求对象
 * </p>
 *
 * @author wuj
 * @since 2019-06-18
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("数据字典项 分页请求对象")
public class SysDictItemPageReq extends PageReq<SysDictItemPageReq>  {

    
    
    @ApiModelProperty(value ="字典编码")
    private String dictCode;
    
    @ApiModelProperty(value ="字典名称")
    private String dictName;
    
    @ApiModelProperty(value ="字典项编码")
    private String itemCode;
    
    @ApiModelProperty(value ="字典项名称")
    private String itemName;
    
    @ApiModelProperty(value ="父类字典项ID")
    private Long itmePid;
    
    @ApiModelProperty(value ="父类字段项编码")
    private String itemPcode;
    
    @ApiModelProperty(value ="父类字段项名称")
    private String itemPname;
    
    @ApiModelProperty(value ="状态（启用 1  停用 0）")
    private String status;
    
    @ApiModelProperty(value ="自定义字段1")
    private String custom1;
    
    @ApiModelProperty(value ="自定义字段2")
    private String custom2;
    
    @ApiModelProperty(value ="自定义字段3")
    private String custom3;
    
    @ApiModelProperty(value ="备注")
    private String remark;
    
	
}
