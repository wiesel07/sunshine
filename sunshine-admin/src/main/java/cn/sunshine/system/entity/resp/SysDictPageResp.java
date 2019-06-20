package cn.sunshine.system.entity.resp;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


 /**
 * <p>
 *  数据字典 分页请求返回对象
 * </p>
 *
 * @author wuj
 * @since 2019-06-20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel("数据字典 分页请求返回对象")
public class SysDictPageResp {


    @ApiModelProperty(value ="字典ID")
    private Long dictId;

    @ApiModelProperty(value ="字典编码")
    private String dictCode;

    @ApiModelProperty(value ="字典名称")
    private String dictName;

    @ApiModelProperty(value ="备注")
    private String remark;


    @ApiModelProperty(value ="状态（启用 1  停用 0）")
    private String status;
   
}