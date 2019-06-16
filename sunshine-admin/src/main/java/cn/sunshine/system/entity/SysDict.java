package cn.sunshine.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author wuj
 * @since 2019-06-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysDict对象", description = "数据字典")
public class SysDict implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "DICT_ID", type = IdType.ID_WORKER)
	private Long dictId;

	@TableField("DICT_CODE")
	private String dictCode;

	@TableField("DICT_NAME")
	private String dictName;

	@TableField("REMARK")
	private String remark;

	@ApiModelProperty(value = "逻辑删除：0 未删除 1 已删除")
	@TableField("DEL_FLAG")
	@TableLogic
	private String delFlag;

	public static final String DICT_ID = "DICT_ID";

	public static final String DICT_CODE = "DICT_CODE";

	public static final String DICT_NAME = "DICT_NAME";

	public static final String REMARK = "REMARK";

	public static final String DEL_FLAG = "DEL_FLAG";

}
