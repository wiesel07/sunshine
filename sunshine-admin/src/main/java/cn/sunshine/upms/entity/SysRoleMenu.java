package cn.sunshine.upms.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 角色菜单
    * </p>
*
* @author wuj
* @since 2019-06-13
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @ApiModel(value="SysRoleMenu对象", description="角色菜单")
    public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "ID", type = IdType.ID_WORKER)
    private Long id;

        @TableField("ROLE_ID")
    private Long roleId;

        @TableField("MENU_ID")
    private Long menuId;


        public static final String ID = "ID";

        public static final String ROLE_ID = "ROLE_ID";

        public static final String MENU_ID = "MENU_ID";

}
