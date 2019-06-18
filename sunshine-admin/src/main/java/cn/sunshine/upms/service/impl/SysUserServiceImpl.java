package cn.sunshine.upms.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.sunshine.upms.entity.SysUser;
import cn.sunshine.upms.mapper.SysUserMapper;
import cn.sunshine.upms.service.ISysUserService;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author wuj
 * @since 2019-06-13
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
