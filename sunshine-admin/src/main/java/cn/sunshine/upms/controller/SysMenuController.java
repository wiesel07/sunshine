package cn.sunshine.upms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.hutool.core.util.ObjectUtil;
import cn.sunshine.common.api.R;
import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.common.constant.UpmsUrlConstant;
import cn.sunshine.common.util.BeanUtilsExt;
import cn.sunshine.upms.entity.SysMenu;
import cn.sunshine.upms.entity.req.SysMenuPageReq;
import cn.sunshine.upms.entity.req.SysMenuReq;
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
@Api(tags = "菜单前端控制器")
public class SysMenuController {

	@Autowired
	private ISysMenuService sysMenuService;

	@ApiOperation(value = "获取列表(分页)", notes = "获取列表(分页)")
	@GetMapping(UpmsUrlConstant.QUERY_PAGE)
	public R<PageResp<SysMenu>> queryPage(@Valid SysMenuPageReq sysMenuPageReq) {
		log.info("获取列表(分页)(sysMenuPageReq={})", sysMenuPageReq);

		IPage<SysMenu> page = new Page<>(sysMenuPageReq.getPageNo(), sysMenuPageReq.getPageSize());

		QueryWrapper<SysMenu> qw = new QueryWrapper<>();
		qw.orderByDesc(SysMenu.MENU_CODE);
		page = sysMenuService.page(page, qw);

		PageResp<SysMenu> pageResp = new PageResp<>();
		pageResp.setRows(page.getRecords());
		pageResp.setTotal(page.getTotal());
		// 返回结果集组
		return new R<PageResp<SysMenu>>(pageResp);

	}

	@ApiOperation(value = "新增菜单", notes = "新增菜单")
	@PostMapping(UpmsUrlConstant.CREATE)
	public R<String> create(@Valid @RequestBody SysMenuReq sysMenuReq) {
		log.info("新增菜单(sysMenuReq={})", sysMenuReq);

		SysMenu sysMenu = new SysMenu();
		BeanUtilsExt.copyProperties(sysMenuReq, sysMenu);
		if (ObjectUtil.isNotNull(sysMenu.getMenuPid())) {
			SysMenu parentSysMenu = sysMenuService.getById(sysMenu.getMenuPid());
			sysMenu.setMenuPid(parentSysMenu.getMenuPid());
			sysMenu.setMenuPcode(parentSysMenu.getMenuPcode());
			sysMenu.setMenuPname(parentSysMenu.getMenuPname());
		}else {
			sysMenu.setMenuPid(0l);
			sysMenu.setMenuPcode("0");
			sysMenu.setMenuPname("所有菜单");
		}
		
		sysMenuService.save(sysMenu);

		return new R<String>();
	}
}
