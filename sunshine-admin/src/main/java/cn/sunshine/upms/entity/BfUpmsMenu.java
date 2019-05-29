package cn.sunshine.upms.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author wuj
 * @since 2019-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("bf_upms_menu")
@ApiModel(value = "BfUpmsMenu对象", description = "菜单表")
public class BfUpmsMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "菜单ID")
	@TableId(value = "MENU_ID", type = IdType.ID_WORKER)
	private BigDecimal menuId;

	@ApiModelProperty(value = "菜单编码")
	@TableField("MENU_CODE")
	private String menuCode;

	@ApiModelProperty(value = "菜单名称")
	@TableField("MENU_NAME")
	private String menuName;

	@ApiModelProperty(value = "父菜单ID")
	@TableField("MENU_PID")
	private BigDecimal menuPid;

	@ApiModelProperty(value = "父菜单编码")
	@TableField("MENU_PCODE")
	private String menuPcode;

	@ApiModelProperty(value = "父菜单名称")
	@TableField("MENU_PNAME")
	private String menuPname;

	@ApiModelProperty(value = "菜单地址")
	@TableField("MENU_URL")
	private String menuUrl;

	@ApiModelProperty(value = "菜单图标")
	@TableField("MENU_ICON")
	private String menuIcon;

	@ApiModelProperty(value = "菜单类型（0 目录 1菜单 2 按钮）")
	@TableField("MENU_TYPE")
	private String menuType;

	@ApiModelProperty(value = "排序")
	@TableField("SORT_NO")
	private Integer sortNo;

	@ApiModelProperty(value = "状态（启用 1 停用 0）")
	@TableField("STATUS")
	private String status;

	@ApiModelProperty(value = "备注")
	@TableField("REMARK")
	private String remark;

	public static final String MENU_ID = "MENU_ID";

	public static final String MENU_CODE = "MENU_CODE";

	public static final String MENU_NAME = "MENU_NAME";

	public static final String MENU_PID = "MENU_PID";

	public static final String MENU_PCODE = "MENU_PCODE";

	public static final String MENU_PNAME = "MENU_PNAME";

	public static final String MENU_URL = "MENU_URL";

	public static final String MENU_ICON = "MENU_ICON";

	public static final String MENU_TYPE = "MENU_TYPE";

	public static final String SORT_NO = "SORT_NO";

	public static final String STATUS = "STATUS";

	public static final String REMARK = "REMARK";

}
