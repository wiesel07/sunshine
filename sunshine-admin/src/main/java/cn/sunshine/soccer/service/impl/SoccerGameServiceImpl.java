package cn.sunshine.soccer.service.impl;

import cn.sunshine.soccer.entity.SoccerGame;
import cn.sunshine.soccer.mapper.SoccerGameMapper;
import cn.sunshine.soccer.service.ISoccerGameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 足球比赛 服务实现类
 * </p>
 *
 * @author wuj
 * @since 2019-06-16
 */
@Service
public class SoccerGameServiceImpl extends ServiceImpl<SoccerGameMapper, SoccerGame> implements ISoccerGameService {

}
