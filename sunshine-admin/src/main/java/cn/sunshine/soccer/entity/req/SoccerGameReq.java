package cn.sunshine.soccer.entity.req;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


 /**
 * <p>
 *  足球比赛 请求对象
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
@ApiModel("足球比赛 请求对象")
public class SoccerGameReq {

		
    @ApiModelProperty(value ="期号")
    private String phase;
		
    @ApiModelProperty(value ="创建时间")
    private Date createAt;
		
    @ApiModelProperty(value ="正式时间")
    private Date officalDate;
		
    @ApiModelProperty(value ="场次")
    private String matchNum;
		
    @ApiModelProperty(value ="场次ID")
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
	
}