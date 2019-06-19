package cn.sunshine.upms.controller;

import java.util.ArrayList;
import java.util.List;

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
import cn.sunshine.common.base.entity.TreeNode;
import cn.sunshine.common.constant.UpmsUrlConstant;
import cn.sunshine.upms.entity.MenuTree;
import cn.sunshine.upms.entity.req.SysMenuPageReq;
import cn.sunshine.upms.entity.req.SysMenuReq;
import cn.sunshine.upms.entity.resp.SysMenuPageResp;
import cn.sunshine.upms.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author wuj
 * @since 2019-06-13
 */
@Slf4j
@RestController
@RequestMapping(UpmsUrlConstant.SYSTEM_MENU)
@Api(tags = "菜单")
public class SysMenuController {

	@Autowired
	private ISysMenuService sysMenuService;

	@ApiOperation(value = "获取列表(分页)", notes = "获取列表(分页)")
	@GetMapping(UpmsUrlConstant.QUERY_PAGE)
	public R<PageResp<SysMenuPageResp>> queryPage(@Valid SysMenuPageReq sysMenuPageReq) {
		log.info("获取列表(分页)(sysMenuPageReq={})", sysMenuPageReq);

		PageResp<SysMenuPageResp> pageResp = sysMenuService.queryPage(sysMenuPageReq);
		// 返回结果集组
		return new R<>(pageResp);
	}

	@ApiOperation(value = "新增菜单", notes = "新增菜单")
	@PostMapping(UpmsUrlConstant.CREATE)
	public R<String> create(@Valid @RequestBody SysMenuReq sysMenuReq) {
		log.info("新增菜单(sysMenuReq={})", sysMenuReq);

//		SysMenu sysMenu = new SysMenu();
//		BeanUtilExt.copyProperties(sysMenuReq, sysMenu);
//		if (ObjectUtil.isNotNull(sysMenu.getMenuPid())) {
//			SysMenu parentSysMenu = sysMenuService.getById(sysMenu.getMenuPid());
//			sysMenu.setMenuPid(parentSysMenu.getMenuPid());
//			sysMenu.setMenuPcode(parentSysMenu.getMenuPcode());
//			sysMenu.setMenuPname(parentSysMenu.getMenuPname());
//		}else {
//			sysMenu.setMenuPid(0l);
//			sysMenu.setMenuPcode("0");
//			sysMenu.setMenuPname("所有菜单");
//		}

		sysMenuService.doCreate(sysMenuReq);

		return new R<String>();
	}

	@ApiOperation(value = "修改菜单", notes = "修改菜单")
	@PostMapping(UpmsUrlConstant.UPDATE)
	public R<String> update(@Valid @RequestBody SysMenuReq sysMenuReq) {
		log.info("修改菜单(sysMenuReq={})", sysMenuReq);

		sysMenuService.doUpdate(sysMenuReq);

		return new R<String>();
	}

	@ApiOperation(value = "删除菜单", notes = "删除菜单")
	@PostMapping(UpmsUrlConstant.REMOVE)
	public R<String> remove(@Valid @RequestBody OperParam operParam) {
		log.info("删除菜单(operParam={})", operParam);

		sysMenuService.doRemove(Long.valueOf(operParam.getId()));

		return new R<String>();
	}

	@GetMapping(UpmsUrlConstant.TREE)
	@ApiOperation(value = "查询树型菜单列表", notes = "查询树型功能列表")
	public R<List<MenuTree>> tree() {
		log.info("查询树型菜单列表");

		List<MenuTree> menuTrees = sysMenuService.getMenuTree();

		return new R<List<MenuTree>>(menuTrees);
	}
}
