package com.lanqiao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanqiao.mapper.UserMapper;
import com.lanqiao.service.IUserService;
import com.lanqiao.vo.UserInfo;

@Service("userService")
public class UserServiceImpl implements IUserService {
	//可以为属性注入依赖
	@Resource
	UserMapper userMapper;//注入了spring容器中的bean id="userService"

	//把事务控制在Service层，这个业务方法有可能要多个数据库操作完成，所有操作要在一个事务完成，粗粒度
	//如果一个service类需要用到多个Mapper映射器接口，那么你可注入多个
	@Override
	public UserInfo selectForLogin(UserInfo user) {
		return userMapper.login(user);
	}
	
	@Override
	public int insertForReg(UserInfo user) {
		return userMapper.reg(user);
	}
}
