package cn.sunshine.upms.entity;

    import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
    * 用户信息
    * </p>
*
* @author wuj
* @since 2019-06-13
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @ApiModel(value="SysUser对象", description="用户信息")
    public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "用户ID")
            @TableId(value = "USER_ID", type = IdType.ID_WORKER)
    private Long userId;

            @ApiModelProperty(value = "用户账号")
        @TableField("USER_CODE")
    private String userCode;

            @ApiModelProperty(value = "用户名称")
        @TableField("USER_NAME")
    private String userName;

            @ApiModelProperty(value = "用户类型")
        @TableField("USER_TYPE")
    private String userType;

            @ApiModelProperty(value = "登录密码 MD5(用户名+#+密码)")
        @TableField("PASSWORD")
    private String password;

            @ApiModelProperty(value = "用户状态 0 未激活 1 正常 2 锁定 3 停用 9 注销  说明：未激活状态时， 登录后需要强制修改密码。")
        @TableField("STATUS")
    private String status;

            @ApiModelProperty(value = "状态为锁定时的解锁时间")
        @TableField("UNLOCK_TIME")
    private String unlockTime;

            @ApiModelProperty(value = "手机号码")
        @TableField("MOBILE_NO")
    private String mobileNo;

            @ApiModelProperty(value = "联系电话")
        @TableField("CONTACT_TEL")
    private String contactTel;

            @ApiModelProperty(value = "电子邮箱")
        @TableField("EMAIL")
    private String email;

            @ApiModelProperty(value = "最近登录时间")
        @TableField("LASTEST_LOGIN")
    private LocalDateTime lastestLogin;

            @ApiModelProperty(value = "最近登出时间")
        @TableField("LASTEST_LOGOUT")
    private LocalDateTime lastestLogout;

            @ApiModelProperty(value = "登录IP地址")
        @TableField("LOGIN_IP")
    private String loginIp;

            @ApiModelProperty(value = "登录次数")
        @TableField("LOGIN_COUNT")
    private Integer loginCount;

            @ApiModelProperty(value = "头像地址")
        @TableField("IMG_URL")
    private String imgUrl;

            @ApiModelProperty(value = "备注")
        @TableField("REMARK")
    private String remark;

            @ApiModelProperty(value = "创建者")
        @TableField("CREATOR")
    private String creator;

            @ApiModelProperty(value = "创建者ID")
        @TableField("CREATOR_ID")
    private String creatorId;

            @ApiModelProperty(value = "逻辑删除：0 未删除 1 已删除")
        @TableField("DEL_FLAG")
        @TableLogic
    private String delFlag;

            @ApiModelProperty(value = "创建时间")
            @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

            @ApiModelProperty(value = "修改时间")
        @TableField("MODIFY_TIME")
    private LocalDateTime modifyTime;


        public static final String USER_ID = "USER_ID";

        public static final String USER_CODE = "USER_CODE";

        public static final String USER_NAME = "USER_NAME";

        public static final String USER_TYPE = "USER_TYPE";

        public static final String PASSWORD = "PASSWORD";

        public static final String STATUS = "STATUS";

        public static final String UNLOCK_TIME = "UNLOCK_TIME";

        public static final String MOBILE_NO = "MOBILE_NO";

        public static final String CONTACT_TEL = "CONTACT_TEL";

        public static final String EMAIL = "EMAIL";

        public static final String LASTEST_LOGIN = "LASTEST_LOGIN";

        public static final String LASTEST_LOGOUT = "LASTEST_LOGOUT";

        public static final String LOGIN_IP = "LOGIN_IP";

        public static final String LOGIN_COUNT = "LOGIN_COUNT";

        public static final String IMG_URL = "IMG_URL";

        public static final String REMARK = "REMARK";

        public static final String CREATOR = "CREATOR";

        public static final String CREATOR_ID = "CREATOR_ID";

        public static final String DEL_FLAG = "DEL_FLAG";

        public static final String CREATE_TIME = "CREATE_TIME";

        public static final String MODIFY_TIME = "MODIFY_TIME";

}
