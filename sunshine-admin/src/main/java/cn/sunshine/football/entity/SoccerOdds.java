package cn.sunshine.football.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.time.LocalDateTime;
    import com.baomidou.mybatisplus.annotation.FieldFill;
    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 赔率
    * </p>
*
* @author wuj
* @since 2019-06-16
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @ApiModel(value="SoccerOdds对象", description="赔率")
    public class SoccerOdds implements Serializable {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "ID")
            @TableId(value = "ODDS_ID", type = IdType.ID_WORKER)
    private Long oddsId;

            @ApiModelProperty(value = "场次ID")
        @TableField("MATCH_ID")
    private Long matchId;

            @ApiModelProperty(value = "大小")
        @TableField("SIZE")
    private Float size;

            @ApiModelProperty(value = "亚盘")
        @TableField("YAPAI")
    private Float yapai;

            @ApiModelProperty(value = "欧赔")
        @TableField("OUPEI")
    private Float oupei;

            @ApiModelProperty(value = "主队大小")
        @TableField("SIZE_HOME")
    private Float sizeHome;

            @ApiModelProperty(value = "客队大小")
        @TableField("SIZE_GUEST")
    private Float sizeGuest;

            @ApiModelProperty(value = "亚盘主队")
        @TableField("YAPAN_HOME")
    private Float yapanHome;

            @ApiModelProperty(value = "亚盘客队")
        @TableField("YAPAN_GUEST")
    private Float yapanGuest;

            @ApiModelProperty(value = "欧赔胜")
        @TableField("OP_WIN")
    private Float opWin;

            @ApiModelProperty(value = "欧赔平")
        @TableField("OP_DRAW")
    private Float opDraw;

            @ApiModelProperty(value = "欧赔负")
        @TableField("OP_LOSE")
    private Float opLose;

            @ApiModelProperty(value = "创建时间")
            @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

            @ApiModelProperty(value = "修改时间")
        @TableField("MODIFY_TIME")
    private LocalDateTime modifyTime;


        public static final String ODDS_ID = "ODDS_ID";

        public static final String MATCH_ID = "MATCH_ID";

        public static final String SIZE = "SIZE";

        public static final String YAPAI = "YAPAI";

        public static final String OUPEI = "OUPEI";

        public static final String SIZE_HOME = "SIZE_HOME";

        public static final String SIZE_GUEST = "SIZE_GUEST";

        public static final String YAPAN_HOME = "YAPAN_HOME";

        public static final String YAPAN_GUEST = "YAPAN_GUEST";

        public static final String OP_WIN = "OP_WIN";

        public static final String OP_DRAW = "OP_DRAW";

        public static final String OP_LOSE = "OP_LOSE";

        public static final String CREATE_TIME = "CREATE_TIME";

        public static final String MODIFY_TIME = "MODIFY_TIME";

}
