package cn.sunshine.system.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.common.util.BeanUtilExt;
import cn.sunshine.common.util.Toolkit;
import cn.sunshine.system.entity.SysDictItem;
import cn.sunshine.system.entity.req.SysDictItemPageReq;
import cn.sunshine.system.entity.req.SysDictItemReq;
import cn.sunshine.system.entity.resp.SysDictItemPageResp;
import cn.sunshine.system.mapper.SysDictItemMapper;
import cn.sunshine.system.service.ISysDictItemService;


 /**
 * <p>
 *  数据字典项 服务实现类
 * </p>
 *
 * @author wuj
 * @since 2019-06-18
 */
@Service
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItem> implements ISysDictItemService {


    @SuppressWarnings("unchecked")
	@Override
	public PageResp<SysDictItemPageResp> queryPage(SysDictItemPageReq sysDictItemPageReq) {
		IPage<SysDictItem> page = new Page<>(sysDictItemPageReq.getPageNo(), sysDictItemPageReq.getPageSize());

		QueryWrapper<SysDictItem> qw = new QueryWrapper<>();
	
		page = this.baseMapper.selectPage(page, qw);
		return Toolkit.converter.copyPage(page, SysDictItemPageResp.class);
	}

	@Override
    public void doCreate(SysDictItemReq sysDictItemReq){
    
		SysDictItem sysDictItem = new SysDictItem();
		BeanUtilExt.copyProperties(sysDictItemReq, sysDictItem);
		this.baseMapper.insert(sysDictItem);
    }
    
    
    @Override
    public void doUpdate(SysDictItemReq sysDictItemReq){
    
    	SysDictItem sysDictItem = new SysDictItem();
		BeanUtilExt.copyProperties(sysDictItemReq, sysDictItem);
		this.baseMapper.updateById(sysDictItem);
    }
    
    
    @Override
    public void doRemove(Long id){
    
    	this.baseMapper.deleteById(id);
    }
}
