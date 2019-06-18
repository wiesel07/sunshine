package cn.sunshine.soccer.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.soccer.entity.SoccerOdds;
import cn.sunshine.soccer.entity.req.SoccerOddsPageReq;
import cn.sunshine.soccer.entity.req.SoccerOddsReq;
import cn.sunshine.soccer.entity.resp.SoccerOddsPageResp; 
 /**
 * <p>
 *  赔率 服务类
 * </p>
 *
 * @author wuj
 * @since 2019-06-18
 */
public interface ISoccerOddsService extends IService<SoccerOdds> {


	/**
	 * 
	 * @Title: queryPage
	 * @Description:分页查询
	 * @param soccerOddsPageReq
	 * @return
	 *
	 * @date   创建时间：2019年6月17日
	 * @author 作者：wuj
	 */
	PageResp<SoccerOddsPageResp> queryPage(SoccerOddsPageReq soccerOddsPageReq);

    /**
	 * 
	 * @Title: doCreate  
	 * @Description:新增
	 * @param soccerOddsReq
	 *
	 * @date   创建时间：2019-06-18
	 * @author 作者： wuj
	 */
	void doCreate(SoccerOddsReq soccerOddsReq);
	
	/**
	 * 
	 * @Title: doUpdate  
	 * @Description:修改
	 * @param soccerOddsReq
	 *
	 * @date   创建时间：2019-06-18
	 * @author 作者： wuj
	 */
	void doUpdate(SoccerOddsReq soccerOddsReq);
	
	/**
	 * 
	 * @Title: doRemove  
	 * @Description:删除
	 * @param id
	 *
	 * @date   创建时间：2019-06-18
	 * @author 作者： wuj
	 */
	void doRemove(Long id);
} 
