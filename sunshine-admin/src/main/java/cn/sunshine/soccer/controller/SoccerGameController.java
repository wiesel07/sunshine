package cn.sunshine.soccer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sunshine.common.api.R;
import cn.sunshine.common.base.entity.OperParam;
import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.common.constant.CommonUrlConstant;
import cn.sunshine.soccer.entity.req.SoccerGamePageReq;
import cn.sunshine.soccer.entity.req.SoccerGameReq;
import cn.sunshine.soccer.entity.resp.SoccerGamePageResp;
import cn.sunshine.soccer.service.ISoccerGameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


/**
 * <p>
 *  足球比赛 前端控制器
 * </p>
 *
 * @author wuj
 * @since 2019-06-18
 */
@Slf4j
@Api(tags = "足球比赛 前端控制器")
@RestController
@RequestMapping("/soccer/soccerGame")
public class SoccerGameController { 
    
    
    @Autowired
	private ISoccerGameService soccerGameService;

	
	@ApiOperation(value = "获取列表(分页)", notes = "获取列表(分页)")
	@GetMapping(CommonUrlConstant.QUERY_PAGE)
	public R<PageResp<SoccerGamePageResp>> queryPage(@Valid SoccerGamePageReq soccerGamePageReq) {
		log.info("获取列表(分页)(soccerGamePageReq={})", soccerGamePageReq);
		
		PageResp<SoccerGamePageResp> pageResp = soccerGameService.queryPage(soccerGamePageReq);
		// 返回结果集组
		return new R<>(pageResp);
	}

	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping(CommonUrlConstant.CREATE)
	public R<String> create(@Valid @RequestBody SoccerGameReq soccerGameReq) {
		log.info("新增(soccerGameReq={})", soccerGameReq);

		soccerGameService.doCreate(soccerGameReq);

		return new R<String>();
	}

	@ApiOperation(value = "修改", notes = "修改")
	@PostMapping(CommonUrlConstant.UPDATE)
	public R<String> update(@Valid @RequestBody SoccerGameReq soccerGameReq) {
		log.info("修改(soccerGameReq={})", soccerGameReq);

		soccerGameService.doUpdate(soccerGameReq);

		return new R<String>();
	}
	
	
	@ApiOperation(value = "删除", notes = "删除")
	@PostMapping(CommonUrlConstant.REMOVE)
	public R<String> remove(@Valid @RequestBody OperParam operParam) {
		log.info("删除(operParam={})", operParam);

		soccerGameService.doRemove(Long.valueOf(operParam.getId()));

		return new R<String>();
	}

}
