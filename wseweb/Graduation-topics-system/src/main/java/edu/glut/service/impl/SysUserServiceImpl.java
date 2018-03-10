package edu.glut.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.glut.mapper.SysUserMapper;
import edu.glut.service.ISysUserService;
import edu.glut.vo.SysUser;

@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService {
	// 可以为属性注入依赖
	@Resource
	SysUserMapper sysUserMapper;

	// 把事务控制在Service层，这个业务方法有可能要多个数据库操作完成，所有操作要在一个事务完成，粗粒度
	// 如果一个service类需要用到多个Mapper映射器接口，那么你可注入多个
	/**
	 * 用户登录
	 */
	@Override
	public SysUser selectForLogin(SysUser user) {
		return sysUserMapper.login(user);
	}

	@Override
	public List<SysUser> selectCusManger() {
		return sysUserMapper.selectCusManger();
	}
	
	
}
