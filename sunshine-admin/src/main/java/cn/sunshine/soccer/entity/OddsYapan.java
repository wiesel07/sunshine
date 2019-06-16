package cn.sunshine.soccer.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
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
    * 亚盘赔率
    * </p>
*
* @author wuj
* @since 2019-06-16
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("soccer_odds_yapan")
    @ApiModel(value="OddsYapan对象", description="亚盘赔率")
    public class OddsYapan implements Serializable {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "ID")
            @TableId(value = "ODDS_YAPAN_ID", type = IdType.ID_WORKER)
    private Long oddsYapanId;

            @ApiModelProperty(value = "场次ID")
        @TableField("MATCH_ID")
    private Long matchId;

            @ApiModelProperty(value = "澳门")
        @TableField("ODDS_YAPAN_AOMEN")
    private Float oddsYapanAomen;

            @ApiModelProperty(value = "Bet365")
        @TableField("ODDS_YAPAN_BET365")
    private Float oddsYapanBet365;

            @ApiModelProperty(value = "皇冠")
        @TableField("ODDS_YAPAN_HG")
    private Float oddsYapanHg;

            @ApiModelProperty(value = "易胜博")
        @TableField("ODDS_YAPAN_YSB")
    private Float oddsYapanYsb;

            @ApiModelProperty(value = "伟德")
        @TableField("ODDS_YAPAN_WEIDE")
    private Float oddsYapanWeide;

            @ApiModelProperty(value = "立博")
        @TableField("ODDS_YAPAN_LIBO")
    private Float oddsYapanLibo;

            @ApiModelProperty(value = "澳门大小球")
        @TableField("ODDS_YAPAN_AOMEN_SIZE")
    private Float oddsYapanAomenSize;

            @ApiModelProperty(value = "Bet365大小球")
        @TableField("ODDS_YAPAN_BET365_SIZE")
    private Float oddsYapanBet365Size;

            @ApiModelProperty(value = "皇冠大小球")
        @TableField("ODDS_YAPAN_HG_SIZE")
    private Float oddsYapanHgSize;

            @ApiModelProperty(value = "易胜博大小球")
        @TableField("ODDS_YAPAN_YSB_SIZE")
    private Float oddsYapanYsbSize;

            @ApiModelProperty(value = "伟德大小球")
        @TableField("ODDS_YAPAN_WEIDE_SIZE")
    private Float oddsYapanWeideSize;

            @ApiModelProperty(value = "立博大小球")
        @TableField("ODDS_YAPAN_LIBO_SIZE")
    private Float oddsYapanLiboSize;

            @ApiModelProperty(value = "创建时间")
            @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

            @ApiModelProperty(value = "修改时间")
        @TableField("MODIFY_TIME")
    private LocalDateTime modifyTime;


        public static final String ODDS_YAPAN_ID = "ODDS_YAPAN_ID";

        public static final String MATCH_ID = "MATCH_ID";

        public static final String ODDS_YAPAN_AOMEN = "ODDS_YAPAN_AOMEN";

        public static final String ODDS_YAPAN_BET365 = "ODDS_YAPAN_BET365";

        public static final String ODDS_YAPAN_HG = "ODDS_YAPAN_HG";

        public static final String ODDS_YAPAN_YSB = "ODDS_YAPAN_YSB";

        public static final String ODDS_YAPAN_WEIDE = "ODDS_YAPAN_WEIDE";

        public static final String ODDS_YAPAN_LIBO = "ODDS_YAPAN_LIBO";

        public static final String ODDS_YAPAN_AOMEN_SIZE = "ODDS_YAPAN_AOMEN_SIZE";

        public static final String ODDS_YAPAN_BET365_SIZE = "ODDS_YAPAN_BET365_SIZE";

        public static final String ODDS_YAPAN_HG_SIZE = "ODDS_YAPAN_HG_SIZE";

        public static final String ODDS_YAPAN_YSB_SIZE = "ODDS_YAPAN_YSB_SIZE";

        public static final String ODDS_YAPAN_WEIDE_SIZE = "ODDS_YAPAN_WEIDE_SIZE";

        public static final String ODDS_YAPAN_LIBO_SIZE = "ODDS_YAPAN_LIBO_SIZE";

        public static final String CREATE_TIME = "CREATE_TIME";

        public static final String MODIFY_TIME = "MODIFY_TIME";

}
