package cn.sunshine.soccer.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.soccer.entity.SoccerGame;
import cn.sunshine.soccer.entity.req.SoccerGamePageReq;
import cn.sunshine.soccer.entity.req.SoccerGameReq;
import cn.sunshine.soccer.entity.resp.SoccerGamePageResp; 
 /**
 * <p>
 *  足球比赛 服务类
 * </p>
 *
 * @author wuj
 * @since 2019-06-18
 */
public interface ISoccerGameService extends IService<SoccerGame> {


	/**
	 * 
	 * @Title: queryPage
	 * @Description:分页查询
	 * @param soccerGamePageReq
	 * @return
	 *
	 * @date   创建时间：2019年6月17日
	 * @author 作者：wuj
	 */
	PageResp<SoccerGamePageResp> queryPage(SoccerGamePageReq soccerGamePageReq);

    /**
	 * 
	 * @Title: doCreate  
	 * @Description:新增
	 * @param soccerGameReq
	 *
	 * @date   创建时间：2019-06-18
	 * @author 作者： wuj
	 */
	void doCreate(SoccerGameReq soccerGameReq);
	
	/**
	 * 
	 * @Title: doUpdate  
	 * @Description:修改
	 * @param soccerGameReq
	 *
	 * @date   创建时间：2019-06-18
	 * @author 作者： wuj
	 */
	void doUpdate(SoccerGameReq soccerGameReq);
	
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
