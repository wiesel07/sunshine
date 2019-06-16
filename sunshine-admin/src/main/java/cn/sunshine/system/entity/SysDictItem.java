package cn.sunshine.system.entity;

import java.math.BigDecimal;
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
 * 数据字典项
 * </p>
 *
 * @author wuj
 * @since 2019-06-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysDictItem对象", description = "数据字典项")
public class SysDictItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "ITEM_ID", type = IdType.ID_WORKER)
	private Long itemId;

	@TableField("DICT_CODE")
	private String dictCode;

	@TableField("DICT_NAME")
	private String dictName;

	@TableField("ITEM_CODE")
	private String itemCode;

	@TableField("ITEM_NAME")
	private String itemName;

	@TableField("ITME_PID")
	private BigDecimal itmePid;

	@TableField("ITEM_PCODE")
	private String itemPcode;

	@TableField("ITEM_PNAME")
	private String itemPname;

	@ApiModelProperty(value = "（启用 1  停用 0）")
	@TableField("STATUS")
	private String status;

	@TableField("CUSTOM1")
	private String custom1;

	@TableField("CUSTOM2")
	private String custom2;

	@TableField("CUSTOM3")
	private String custom3;

	@TableField("REMARK")
	private String remark;

	@ApiModelProperty(value = "逻辑删除：0 未删除 1 已删除")
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

}
