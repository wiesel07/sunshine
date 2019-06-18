package cn.sunshine.system.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.system.entity.SysDictItem;
import cn.sunshine.system.entity.req.SysDictItemPageReq;
import cn.sunshine.system.entity.req.SysDictItemReq;
import cn.sunshine.system.entity.resp.SysDictItemPageResp; 
 /**
 * <p>
 *  数据字典项 服务类
 * </p>
 *
 * @author wuj
 * @since 2019-06-18
 */
public interface ISysDictItemService extends IService<SysDictItem> {


	/**
	 * 
	 * @Title: queryPage
	 * @Description:分页查询
	 * @param sysDictItemPageReq
	 * @return
	 *
	 * @date   创建时间：2019年6月17日
	 * @author 作者：wuj
	 */
	PageResp<SysDictItemPageResp> queryPage(SysDictItemPageReq sysDictItemPageReq);

    /**
	 * 
	 * @Title: doCreate  
	 * @Description:新增
	 * @param sysDictItemReq
	 *
	 * @date   创建时间：2019-06-18
	 * @author 作者： wuj
	 */
	void doCreate(SysDictItemReq sysDictItemReq);
	
	/**
	 * 
	 * @Title: doUpdate  
	 * @Description:修改
	 * @param sysDictItemReq
	 *
	 * @date   创建时间：2019-06-18
	 * @author 作者： wuj
	 */
	void doUpdate(SysDictItemReq sysDictItemReq);
	
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
