package cn.sunshine.system.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.system.entity.SysDict;
import cn.sunshine.system.entity.req.SysDictPageReq;
import cn.sunshine.system.entity.req.SysDictReq;
import cn.sunshine.system.entity.resp.SysDictPageResp; 
 /**
 * <p>
 *  数据字典 服务类
 * </p>
 *
 * @author wuj
 * @since 2019-06-18
 */
public interface ISysDictService extends IService<SysDict> {


	/**
	 * 
	 * @Title: queryPage
	 * @Description:分页查询
	 * @param sysDictPageReq
	 * @return
	 *
	 * @date   创建时间：2019年6月17日
	 * @author 作者：wuj
	 */
	PageResp<SysDictPageResp> queryPage(SysDictPageReq sysDictPageReq);

    /**
	 * 
	 * @Title: doCreate  
	 * @Description:新增
	 * @param sysDictReq
	 *
	 * @date   创建时间：2019-06-18
	 * @author 作者： wuj
	 */
	void doCreate(SysDictReq sysDictReq);
	
	/**
	 * 
	 * @Title: doUpdate  
	 * @Description:修改
	 * @param sysDictReq
	 *
	 * @date   创建时间：2019-06-18
	 * @author 作者： wuj
	 */
	void doUpdate(SysDictReq sysDictReq);
	
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
