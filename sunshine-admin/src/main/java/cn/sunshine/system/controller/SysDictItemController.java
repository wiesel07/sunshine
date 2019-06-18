package cn.sunshine.system.controller;

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
import cn.sunshine.system.entity.req.SysDictItemPageReq;
import cn.sunshine.system.entity.req.SysDictItemReq;
import cn.sunshine.system.entity.resp.SysDictItemPageResp;
import cn.sunshine.system.service.ISysDictItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


/**
 * <p>
 *  数据字典项 前端控制器
 * </p>
 *
 * @author wuj
 * @since 2019-06-18
 */
@Slf4j
@Api(tags = "数据字典项 前端控制器")
@RestController
@RequestMapping("/system/sysDictItem")
public class SysDictItemController { 
    
    
    @Autowired
	private ISysDictItemService sysDictItemService;

	
	@ApiOperation(value = "获取列表(分页)", notes = "获取列表(分页)")
	@GetMapping(CommonUrlConstant.QUERY_PAGE)
	public R<PageResp<SysDictItemPageResp>> queryPage(@Valid SysDictItemPageReq sysDictItemPageReq) {
		log.info("获取列表(分页)(sysDictItemPageReq={})", sysDictItemPageReq);
		
		PageResp<SysDictItemPageResp> pageResp = sysDictItemService.queryPage(sysDictItemPageReq);
		// 返回结果集组
		return new R<>(pageResp);
	}

	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping(CommonUrlConstant.CREATE)
	public R<String> create(@Valid @RequestBody SysDictItemReq sysDictItemReq) {
		log.info("新增(sysDictItemReq={})", sysDictItemReq);

		sysDictItemService.doCreate(sysDictItemReq);

		return new R<String>();
	}

	@ApiOperation(value = "修改", notes = "修改")
	@PostMapping(CommonUrlConstant.UPDATE)
	public R<String> update(@Valid @RequestBody SysDictItemReq sysDictItemReq) {
		log.info("修改(sysDictItemReq={})", sysDictItemReq);

		sysDictItemService.doUpdate(sysDictItemReq);

		return new R<String>();
	}
	
	
	@ApiOperation(value = "删除", notes = "删除")
	@PostMapping(CommonUrlConstant.REMOVE)
	public R<String> remove(@Valid @RequestBody OperParam operParam) {
		log.info("删除(operParam={})", operParam);

		sysDictItemService.doRemove(Long.valueOf(operParam.getId()));

		return new R<String>();
	}

}
