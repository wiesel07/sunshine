package cn.sunshine.soccer.entity.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


 /**
 * <p>
 *  赔率 请求返回对象
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
@ApiModel("赔率 请求返回对象")
public class SoccerOddsResp {

	
    @ApiModelProperty(value ="ID")
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
	
	
	
}