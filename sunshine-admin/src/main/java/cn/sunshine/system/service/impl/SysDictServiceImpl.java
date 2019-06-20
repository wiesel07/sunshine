package cn.sunshine.system.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.common.util.BeanUtilExt;
import cn.sunshine.common.util.Toolkit;
import cn.sunshine.system.entity.SysDict;
import cn.sunshine.system.entity.req.SysDictPageReq;
import cn.sunshine.system.entity.req.SysDictReq;
import cn.sunshine.system.entity.resp.SysDictPageResp;
import cn.sunshine.system.mapper.SysDictMapper;
import cn.sunshine.system.service.ISysDictService;


 /**
 * <p>
 *  数据字典 服务实现类
 * </p>
 *
 * @author wuj
 * @since 2019-06-20
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {


    @SuppressWarnings("unchecked")
	@Override
	public PageResp<SysDictPageResp> queryPage(SysDictPageReq sysDictPageReq) {
		IPage<SysDict> page = new Page<>(sysDictPageReq.getPageNo(), sysDictPageReq.getPageSize());

		QueryWrapper<SysDict> qw = new QueryWrapper<>();
	
		page = this.baseMapper.selectPage(page, qw);
		return Toolkit.converter.copyPage(page, SysDictPageResp.class);
	}

	@Override
    public void doCreate(SysDictReq sysDictReq){
    
       SysDict sysDict = new SysDict();
		BeanUtilExt.copyProperties(sysDictReq, sysDict);
		this.baseMapper.insert(sysDict);
    }
    
    
    @Override
    public void doUpdate(SysDictReq sysDictReq){
    
        SysDict sysDict = new SysDict();
		BeanUtilExt.copyProperties(sysDictReq, sysDict);
		this.baseMapper.updateById(sysDict);
    }
    
    
    @Override
    public void doRemove(Long id){
    
       this.baseMapper.deleteById(id);
    }
}
