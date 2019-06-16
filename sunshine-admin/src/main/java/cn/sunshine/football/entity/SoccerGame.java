package cn.sunshine.football.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
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
 * 足球比赛
 * </p>
 *
 * @author wuj
 * @since 2019-06-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SoccerGame对象", description = "足球比赛")
public class SoccerGame implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "期号")
	@TableField("PHASE")
	private String phase;

	@ApiModelProperty(value = "创建时间")
	@TableField("CREATE_AT")
	private LocalDateTime createAt;

	@ApiModelProperty(value = "正式时间")
	@TableField("OFFICAL_DATE")
	private LocalDateTime officalDate;

	@ApiModelProperty(value = "场次")
	@TableField("MATCH_NUM")
	private String matchNum;

	@ApiModelProperty(value = "场次ID")
	@TableId(value = "MATCH_ID", type = IdType.ID_WORKER)
	private Long matchId;

	@ApiModelProperty(value = "赛事名")
	@TableField("MATCH_NAME")
	private String matchName;

	@ApiModelProperty(value = "比赛时间")
	@TableField("MATCH_DATE")
	private LocalDateTime matchDate;

	@ApiModelProperty(value = "停止时间")
	@TableField("TIME_ENDSALE")
	private LocalDateTime timeEndsale;

	@ApiModelProperty(value = "主队名称")
	@TableField("HOME_TEAM")
	private String homeTeam;

	@ApiModelProperty(value = "客队名称")
	@TableField("GUEST_TEAM")
	private String guestTeam;

	@ApiModelProperty(value = "主队排名")
	@TableField("HOME_RANK")
	private Integer homeRank;

	@ApiModelProperty(value = "客队排名")
	@TableField("GUEST_RANK")
	private Integer guestRank;

	@ApiModelProperty(value = "全场比分")
	@TableField("FINAL_SCORE")
	private String finalScore;

	@ApiModelProperty(value = "半场比分")
	@TableField("HALF_SCORE")
	private String halfScore;

	@ApiModelProperty(value = "星期")
	@TableField("WEEKDAY")
	private String weekday;

	@ApiModelProperty(value = "状态")
	@TableField("STATUS")
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

}
