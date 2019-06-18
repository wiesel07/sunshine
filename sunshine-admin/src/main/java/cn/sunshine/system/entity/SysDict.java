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
 * 数据字典
 * </p>
 *
 * @author wuj
 * @since 2019-06-18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_dict")
@ApiModel("数据字典")
public class SysDict extends Model<SysDict> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "字典ID")
	@TableId(value = "DICT_ID")
	private Long dictId;

	@ApiModelProperty(value = "字典编码")
	private String dictCode;

	@ApiModelProperty(value = "字典名称")
	private String dictName;

	@ApiModelProperty(value = "备注")
	private String remark;

//    @ApiModelProperty(value ="逻辑删除：0 未删除 1 已删除",hidden=true)
//    @TableField("DEL_FLAG")
//    @TableLogic
	@TableLogic
	private String delFlag;

	public static final String DICT_ID = "DICT_ID";
	public static final String DICT_CODE = "DICT_CODE";
	public static final String DICT_NAME = "DICT_NAME";
	public static final String REMARK = "REMARK";
	public static final String DEL_FLAG = "DEL_FLAG";

	@Override
	protected Serializable pkVal() {
		return this.dictId;
	}
}
