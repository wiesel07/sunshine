package cn.sunshine.soccer.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
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
 *  足球比赛
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
@TableName("soccer_game")
@ApiModel("足球比赛")
public class  SoccerGame extends Model<SoccerGame> {

    private static final long serialVersionUID = 1L; 
 
    
    @ApiModelProperty(value ="期号")
    private String phase;
    
    @ApiModelProperty(value ="创建时间")
    private Date createAt;
    
    @ApiModelProperty(value ="正式时间")
    private Date officalDate;
    
    @ApiModelProperty(value ="场次")
    private String matchNum;
    
    @ApiModelProperty(value ="场次ID")
    @TableId(value = "MATCH_ID")
    private String matchId;
    
    @ApiModelProperty(value ="赛事名")
    private String matchName;
    
    @ApiModelProperty(value ="比赛时间")
    private Date matchDate;
    
    @ApiModelProperty(value ="停止时间")
    private Date timeEndsale;
    
    @ApiModelProperty(value ="主队名称")
    private String homeTeam;
    
    @ApiModelProperty(value ="客队名称")
    private String guestTeam;
    
    @ApiModelProperty(value ="主队排名")
    private String homeRank;
    
    @ApiModelProperty(value ="客队排名")
    private String guestRank;
    
    @ApiModelProperty(value ="全场比分")
    private String finalScore;
    
    @ApiModelProperty(value ="半场比分")
    private String halfScore;
    
    @ApiModelProperty(value ="星期")
    private String weekday;
    
    @ApiModelProperty(value ="状态")
    private String status;
    
    public static final String PHASE = "PHASE";
    public static final String CREATE_AT = "CREATE_AT";
    public static final String OFFICAL_DATE = "OFFICAL_DATE";
    public static final String MATCH_NUM = "MATCH_NUM";
    public static final String MATCH_ID = "MATCH_ID";
    public static final String MATCH_NAME = "MATCH_NAME";
    public static final String MATCH_DATE = "MATCH_DATE";
    public static final String TIME_ENDSALE = "TIME_ENDSALE";
    public static final String HOME_TEAM = "HOME_TEAM";
    public static final String GUEST_TEAM = "GUEST_TEAM";
    public static final String HOME_RANK = "HOME_RANK";
    public static final String GUEST_RANK = "GUEST_RANK";
    public static final String FINAL_SCORE = "FINAL_SCORE";
    public static final String HALF_SCORE = "HALF_SCORE";
    public static final String WEEKDAY = "WEEKDAY";
    public static final String STATUS = "STATUS";

    @Override
	protected Serializable pkVal() {
		return this.matchId;
	}
}
