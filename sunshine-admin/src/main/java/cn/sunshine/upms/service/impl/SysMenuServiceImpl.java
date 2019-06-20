package cn.sunshine.upms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.common.base.entity.TreeNode;
import cn.sunshine.common.constant.CommonConstant;
import cn.sunshine.common.enums.MenuType;
import cn.sunshine.common.enums.UpmsErrorCode;
import cn.sunshine.common.exception.SunshineException;
import cn.sunshine.common.util.BeanUtilExt;
import cn.sunshine.common.util.CollectionUtilExt;
import cn.sunshine.common.util.ObjectUtilExt;
import cn.sunshine.common.util.StrUtilExt;
import cn.sunshine.common.util.Toolkit;
import cn.sunshine.common.util.TreeUtil;
import cn.sunshine.upms.entity.MenuTree;
import cn.sunshine.upms.entity.SysMenu;
import cn.sunshine.upms.entity.SysRoleMenu;
import cn.sunshine.upms.entity.req.SysMenuPageReq;
import cn.sunshine.upms.entity.req.SysMenuReq;
import cn.sunshine.upms.entity.resp.SysMenuPageResp;
import cn.sunshine.upms.mapper.SysMenuMapper;
import cn.sunshine.upms.service.ISysMenuService;
import cn.sunshine.upms.service.ISysRoleMenuService;
import cn.sunshine.upms.service.ISysRoleService;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author wuj
 * @since 2019-06-13
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

	@Autowired
	private ISysRoleService sysRoleService;

	@Autowired
	private ISysRoleMenuService sysRoleMenuService;

	
	@SuppressWarnings("unchecked")
	@Override
	public PageResp<SysMenuPageResp> queryPage(SysMenuPageReq sysMenuPageReq) {
		IPage<SysMenu> page = new Page<>(sysMenuPageReq.getPageNo(), sysMenuPageReq.getPageSize());

		QueryWrapper<SysMenu> qw = new QueryWrapper<>();
		qw.orderByDesc(SysMenu.MENU_CODE);
		page = this.baseMapper.selectPage(page, qw);
		return Toolkit.converter.copyPage(page, SysMenuPageResp.class);
	}
	
	@Override
	@Transactional
	public void doCreate(SysMenuReq sysMenuReq) {

		// 判断菜单编码是否存在
		QueryWrapper<SysMenu> qw = new QueryWrapper<>();
		qw.eq(SysMenu.MENU_CODE, sysMenuReq.getMenuCode());

		if (this.baseMapper.selectCount(qw) >0 ) {
			throw new SunshineException(UpmsErrorCode.MENU_CODE_IS_EXIST);
		}

		// 菜单类型为菜单时url地址不能为空
		if (MenuType.MENU.getValue().equals(sysMenuReq.getMenuType())) {
			if (StrUtilExt.isBlank(sysMenuReq.getMenuUrl()))
				throw new SunshineException(UpmsErrorCode.MENU_URL_IS_EMPTY);
		}

		SysMenu sysMenu = new SysMenu();
		BeanUtilExt.copyProperties(sysMenuReq, sysMenu);

		// 父节点信息补充
		sysMenu = assembleParentInfo(sysMenu);

		if (this.baseMapper.insert(sysMenu) != 1) {
			throw new SunshineException(UpmsErrorCode.SQL_INSERT_ERROR);
		}

	}

	/**
	 * 
	 * @Description:父节点信息补充
	 * @param sysMenu
	 * @return
	 *
	 * @date 创建时间：2019年6月14日
	 * @author 作者：wuj
	 */
	private SysMenu assembleParentInfo(SysMenu sysMenu) {
		// 判断上级节点是否是顶级节点，是顶级节点则上级节点编码置为0,上级节点ID设置为0，否则在插入操作前先判断上级节点编码是否存在
		if (ObjectUtilExt.isNull(sysMenu.getMenuPid()) || CommonConstant.TOP_NODE_ID == sysMenu.getMenuPid()) {
			sysMenu.setMenuPcode(CommonConstant.TOP_NODE_CODE);
			sysMenu.setMenuPid(CommonConstant.TOP_NODE_ID);
			sysMenu.setMenuPname("所有菜单");
		} else {

			SysMenu parentSysMenu = this.baseMapper.selectById(sysMenu.getMenuPid());
			if (ObjectUtilExt.isNull(parentSysMenu)) {
				throw new SunshineException(UpmsErrorCode.MENU_PARENT_IS_NOTEXIST);
			}
			sysMenu.setMenuPcode(parentSysMenu.getMenuCode());
			sysMenu.setMenuPid(parentSysMenu.getMenuId());
			sysMenu.setMenuPname(parentSysMenu.getMenuName());
		}

		return sysMenu;
	}

	@Override
	public void doUpdate(SysMenuReq sysMenuReq) {

		// 判断菜单是否存在
		QueryWrapper<SysMenu> qw = new QueryWrapper<>();
		qw.eq(SysMenu.MENU_CODE, sysMenuReq.getMenuCode());

		SysMenu existSysMenu = this.baseMapper.selectOne(qw);
		if (ObjectUtilExt.isNull(existSysMenu)) {
			throw new SunshineException(UpmsErrorCode.MENU_IS_NOTEXIST);
		}

		// 菜单类型为菜单时url地址不能为空
		if (MenuType.MENU.getValue().equals(sysMenuReq.getMenuType())) {
			if (StrUtilExt.isBlank(sysMenuReq.getMenuUrl()))
				throw new SunshineException(UpmsErrorCode.MENU_URL_IS_EMPTY);
		}

		SysMenu sysMenu = new SysMenu();
		BeanUtilExt.copyProperties(sysMenuReq, sysMenu);

		// 当节点编码与原来节点编码不一致时，判断编码是否重复

		// 判断原父节点ID与修改后父节点ID是否一致
		if (ObjectUtilExt.isNull(sysMenu.getMenuPid()) || (!(existSysMenu.getMenuPid() == sysMenu.getMenuPid()))) {
			// 不一致，父节点信息补充
			sysMenu = assembleParentInfo(sysMenu);

		}

		// TODO 判断欲修改的上级部门一项是否为当前部门或子部门 （避免出现闭环）

		// 如果节点编码修改了，则遍历该节点的所有子节点，把对应的子节点信息改了
//		if (!(existBfUpmsMenu.getMenuCode().equals(bfUpmsMenu.getMenuCode()))) {
//			EntityWrapper<BfUpmsMenu> updateEw = new EntityWrapper<BfUpmsMenu>();
//			updateEw.eq(BfUpmsMenu.MENU_PID, bfUpmsMenu.getMenuId());
//
//			BfUpmsMenu updateBfUpmsMenu = BfUpmsMenu.builder().menuPid(bfUpmsMenu.getMenuId())
//					.menuPcode(bfUpmsMenu.getMenuCode()).menuPname(bfUpmsMenu.getMenuName()).build();
//			this.baseMapper.update(updateBfUpmsMenu, updateEw);
//		}
		if (this.baseMapper.updateById(sysMenu) != 1) {
			throw new SunshineException(UpmsErrorCode.SQL_UPDATE_ERROR);
		}

	}

	@Override
	public void doRemove(Long id) {
		// 判断欲删除菜单是否存在
		SysMenu sysMenu = this.baseMapper.selectById(id);
		if (ObjectUtilExt.isNull(sysMenu)) {
			throw new SunshineException(UpmsErrorCode.MENU_IS_NOTEXIST);
		}

		String menuType = sysMenu.getMenuType();
		if (MenuType.CATALOG.getValue().equals(menuType)) {
			// 如果是目录类型，需要判断菜单下是否存在子菜单，如果存在子菜单则不进行删除
			QueryWrapper<SysMenu> qw = new QueryWrapper<>();
			qw.eq(SysMenu.MENU_PID, id);
			if (this.baseMapper.selectCount(qw) > 0) {
				throw new SunshineException(UpmsErrorCode.MENU_CHILDREN_IS_EXIST);
			}
		}

		// 判断菜单是否被角色使用
		QueryWrapper<SysRoleMenu> roleMenuQw = new QueryWrapper<>();
		roleMenuQw.eq(SysRoleMenu.MENU_ID, id);

		if (sysRoleMenuService.count() > 0) {
			throw new SunshineException(UpmsErrorCode.MENU_IS_USED);
		}

		// 删除菜单
		if (this.baseMapper.deleteById(id) != 1) {
			throw new SunshineException(UpmsErrorCode.SQL_DELETE_ERROR);
		}

		// 迭代删除菜单下的子菜单
		deleteChildrenMenu(id);

	}

	/**
	 * 
	 * @Description:迭代删除子菜单
	 * @param id
	 *
	 * @date 创建时间：2019年6月14日
	 * @author 作者：wuj
	 */
	private void deleteChildrenMenu(Long id) {

		QueryWrapper<SysMenu> qw = new QueryWrapper<>();
		qw.eq(SysMenu.MENU_PID, id);

		List<SysMenu> childrenMenus = this.baseMapper.selectList(qw);

		if (CollectionUtilExt.isNotEmpty(childrenMenus)) {
			for (SysMenu sysMenu : childrenMenus) {
				deleteChildrenMenu(sysMenu.getMenuId());
				if (this.baseMapper.deleteById(sysMenu.getMenuId()) != 1) {
					throw new SunshineException(UpmsErrorCode.SQL_DELETE_ERROR);
				}
			}
		}
	}

	@Override
	public List<MenuTree> getMenuTree() {
		
		QueryWrapper<SysMenu> qw = new 	QueryWrapper<>();
		qw.eq(SysMenu.STATUS, "1");
		List<SysMenu> sysMenus = this.baseMapper.selectList(qw);

		List<MenuTree> menuTrees = new ArrayList<MenuTree>();

		for (SysMenu sysMenu : sysMenus) {
			MenuTree menuTree = new MenuTree();
			BeanUtilExt.copyProperties(sysMenu, menuTree);
			menuTree.setId(StrUtilExt.toString(sysMenu.getMenuId()));
			menuTree.setCode(sysMenu.getMenuCode());
			menuTree.setName(sysMenu.getMenuName());
			menuTree.setPid(StrUtilExt.toString(sysMenu.getMenuPid()));
			menuTrees.add(menuTree);
		}

		menuTrees = TreeUtil.buildTree(menuTrees);
		return menuTrees;
	}

	@Override
	public List<TreeNode> getRoleMenuTree(Long id) {

		QueryWrapper<SysRoleMenu> roleMenuQw = new QueryWrapper<>();
		List<SysRoleMenu> sysRoleMenus = sysRoleMenuService
				.list(roleMenuQw.select(SysRoleMenu.MENU_ID).eq(SysRoleMenu.ROLE_ID, id));

		List<Long> menuIds = new ArrayList<>();
		for (SysRoleMenu sysRoleMenu : sysRoleMenus) {
			menuIds.add(sysRoleMenu.getMenuId());
		}

		List<SysMenu> sysMenus = this.baseMapper.selectBatchIds(menuIds);
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		for (SysMenu sysMenu : sysMenus) {
			TreeNode treeNode = new TreeNode();
			BeanUtilExt.copyProperties(sysMenu, treeNode);
			treeNode.setId(StrUtilExt.toString(sysMenu.getMenuId()));
			treeNode.setCode(sysMenu.getMenuCode());
			treeNode.setName(sysMenu.getMenuName());
			treeNode.setPid(StrUtilExt.toString(sysMenu.getMenuPid()));
			treeNodes.add(treeNode);
		}

		treeNodes = TreeUtil.buildTree(treeNodes);
		return treeNodes;
	}


}
