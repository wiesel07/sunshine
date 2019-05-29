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
    * 角色信息
    * </p>
*
* @author wuj
* @since 2019-05-29
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("bf_upms_role")
    @ApiModel(value="BfUpmsRole对象", description="角色信息")
    public class BfUpmsRole implements Serializable {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "角色ID")
            @TableId(value = "ROLE_ID", type = IdType.ID_WORKER)
    private BigDecimal roleId;

            @ApiModelProperty(value = "角色编码")
        @TableField("ROLE_CODE")
    private String roleCode;

            @ApiModelProperty(value = "角色名称")
        @TableField("ROLE_NAME")
    private String roleName;

            @ApiModelProperty(value = "角色类型")
        @TableField("ROLE_TYPE")
    private String roleType;

            @ApiModelProperty(value = "角色状态（启用 1  停用 0）")
        @TableField("STATUS")
    private String status;

            @ApiModelProperty(value = "备注")
        @TableField("REMARK")
    private String remark;


        public static final String ROLE_ID = "ROLE_ID";

        public static final String ROLE_CODE = "ROLE_CODE";

        public static final String ROLE_NAME = "ROLE_NAME";

        public static final String ROLE_TYPE = "ROLE_TYPE";

        public static final String STATUS = "STATUS";

        public static final String REMARK = "REMARK";

}
