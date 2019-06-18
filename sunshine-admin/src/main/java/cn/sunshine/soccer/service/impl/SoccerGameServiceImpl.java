package cn.sunshine.soccer.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.common.util.Toolkit;
import cn.sunshine.soccer.entity.SoccerGame;
import cn.sunshine.soccer.entity.req.SoccerGamePageReq;
import cn.sunshine.soccer.entity.req.SoccerGameReq;
import cn.sunshine.soccer.entity.resp.SoccerGamePageResp;
import cn.sunshine.soccer.mapper.SoccerGameMapper;
import cn.sunshine.soccer.service.ISoccerGameService;


 /**
 * <p>
 *  足球比赛 服务实现类
 * </p>
 *
 * @author wuj
 * @since 2019-06-18
 */
@Service
public class SoccerGameServiceImpl extends ServiceImpl<SoccerGameMapper, SoccerGame> implements ISoccerGameService {


    @SuppressWarnings("unchecked")
	@Override
	public PageResp<SoccerGamePageResp> queryPage(SoccerGamePageReq soccerGamePageReq) {
		IPage<SoccerGame> page = new Page<>(soccerGamePageReq.getPageNo(), soccerGamePageReq.getPageSize());

		QueryWrapper<SoccerGame> qw = new QueryWrapper<>();
	
		page = this.baseMapper.selectPage(page, qw);
		return Toolkit.converter.copyPage(page, SoccerGamePageResp.class);
	}

	@Override
    public void doCreate(SoccerGameReq soccerGameReq){
    
    }
    
    
    @Override
    public void doUpdate(SoccerGameReq soccerGameReq){
    
    }
    
    
    @Override
    public void doRemove(Long id){
    
    }
}
