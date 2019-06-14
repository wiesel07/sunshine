package cn.sunshine.upms.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.sunshine.common.base.entity.TreeNode;
import cn.sunshine.upms.entity.MenuTree;
import cn.sunshine.upms.entity.SysMenu;
import cn.sunshine.upms.entity.req.SysMenuReq;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author wuj
 * @since 2019-06-13
 */
public interface ISysMenuService extends IService<SysMenu> {

	/**
	 * 
	 * @Title: doCreate  
	 * @Description:新增
	 * @param sysMenuReq
	 *
	 * @date   创建时间：2019年6月14日
	 * @author 作者：wuj
	 */
	void doCreate(SysMenuReq sysMenuReq);
	
	/**
	 * 
	 * @Title: doUpdate  
	 * @Description:修改
	 * @param sysMenuReq
	 *
	 * @date   创建时间：2019年6月14日
	 * @author 作者：wuj
	 */
	void doUpdate(SysMenuReq sysMenuReq);
	
	/**
	 * 
	 * @Title: doRemove  
	 * @Description:删除
	 * @param id
	 *
	 * @date   创建时间：2019年6月14日
	 * @author 作者：wuj
	 */
	void doRemove(Long id);
	
	/**
	 * 
	 * @Description:获取菜单树
	 * @return
	 *
	 * @date   创建时间：2019年6月14日
	 * @author 作者：wuj
	 */
	List<MenuTree> getMenuTree(); 
	
	/**
	 * 
	 * @Description:获取角色菜单树
	 * @param id
	 * @return
	 *
	 * @date   创建时间：2019年6月14日
	 * @author 作者：wuj
	 */
	List<TreeNode> getRoleMenuTree(Long id); 
	
}
