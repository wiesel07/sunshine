package cn.sunshine.soccer.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.common.util.Toolkit;
import cn.sunshine.soccer.entity.SoccerOdds;
import cn.sunshine.soccer.entity.req.SoccerOddsPageReq;
import cn.sunshine.soccer.entity.req.SoccerOddsReq;
import cn.sunshine.soccer.entity.resp.SoccerOddsPageResp;
import cn.sunshine.soccer.mapper.SoccerOddsMapper;
import cn.sunshine.soccer.service.ISoccerOddsService;


 /**
 * <p>
 *  赔率 服务实现类
 * </p>
 *
 * @author wuj
 * @since 2019-06-18
 */
@Service
public class SoccerOddsServiceImpl extends ServiceImpl<SoccerOddsMapper, SoccerOdds> implements ISoccerOddsService {


    @SuppressWarnings("unchecked")
	@Override
	public PageResp<SoccerOddsPageResp> queryPage(SoccerOddsPageReq soccerOddsPageReq) {
		IPage<SoccerOdds> page = new Page<>(soccerOddsPageReq.getPageNo(), soccerOddsPageReq.getPageSize());

		QueryWrapper<SoccerOdds> qw = new QueryWrapper<>();
	
		page = this.baseMapper.selectPage(page, qw);
		return Toolkit.converter.copyPage(page, SoccerOddsPageResp.class);
	}

	@Override
    public void doCreate(SoccerOddsReq soccerOddsReq){
    
    }
    
    
    @Override
    public void doUpdate(SoccerOddsReq soccerOddsReq){
    
    }
    
    
    @Override
    public void doRemove(Long id){
    
    }
}
