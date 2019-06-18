package cn.sunshine.soccer.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
 *  赔率
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
@TableName("soccer_odds")
@ApiModel("赔率")
public class  SoccerOdds extends Model<SoccerOdds> {

    private static final long serialVersionUID = 1L; 
 
    
    @ApiModelProperty(value ="ID")
    @TableId(value = "ODDS_ID")
    private String oddsId;
    
    @ApiModelProperty(value ="场次ID")
    private String matchId;
    
    @ApiModelProperty(value ="大小")
    private Float size;
    
    @ApiModelProperty(value ="亚盘")
    private Float yapai;
    
    @ApiModelProperty(value ="欧赔")
    private Float oupei;
    
    @ApiModelProperty(value ="主队大小")
    private Float sizeHome;
    
    @ApiModelProperty(value ="客队大小")
    private Float sizeGuest;
    
    @ApiModelProperty(value ="亚盘主队")
    private Float yapanHome;
    
    @ApiModelProperty(value ="亚盘客队")
    private Float yapanGuest;
    
    @ApiModelProperty(value ="欧赔胜")
    private Float opWin;
    
    @ApiModelProperty(value ="欧赔平")
    private Float opDraw;
    
    @ApiModelProperty(value ="欧赔负")
    private Float opLose;
    
    @ApiModelProperty(value ="创建时间",hidden=true)
	@TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;
    
    @ApiModelProperty(value ="修改时间",hidden=true)
	@TableField(value = "MODIFY_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;
    
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

    @Override
	protected Serializable pkVal() {
		return this.oddsId;
	}
}
