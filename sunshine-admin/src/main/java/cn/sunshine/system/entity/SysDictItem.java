package cn.sunshine.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


 /**
 * <p>
 *  数据字典项
 * </p>
 *
 * @author wuj
 * @since 2019-06-18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
@TableName("sys_dict_item")
@ApiModel("数据字典项")
public class  SysDictItem extends Model<SysDictItem> {

    private static final long serialVersionUID = 1L; 
 
    
    @ApiModelProperty(value ="字典项ID")
    @TableId(value = "ITEM_ID")
    private Long itemId;
    
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
    
    @ApiModelProperty(value ="逻辑删除：0 未删除 1 已删除",hidden=true)
    @TableField("DEL_FLAG")
    @TableLogic
    private String delFlag;
    
    public static final String ITEM_ID = "ITEM_ID";
    public static final String DICT_CODE = "DICT_CODE";
    public static final String DICT_NAME = "DICT_NAME";
    public static final String ITEM_CODE = "ITEM_CODE";
    public static final String ITEM_NAME = "ITEM_NAME";
    public static final String ITME_PID = "ITME_PID";
    public static final String ITEM_PCODE = "ITEM_PCODE";
    public static final String ITEM_PNAME = "ITEM_PNAME";
    public static final String STATUS = "STATUS";
    public static final String CUSTOM1 = "CUSTOM1";
    public static final String CUSTOM2 = "CUSTOM2";
    public static final String CUSTOM3 = "CUSTOM3";
    public static final String REMARK = "REMARK";
    public static final String DEL_FLAG = "DEL_FLAG";

    @Override
	protected Serializable pkVal() {
		return this.itemId;
	}
}
