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
	UserMapper userMapper;

	//如果一个service类需要用到多个Mapper映射器接口，那么你可注入多个
	@Override
	public UserInfo selectForLogin(UserInfo user) {
		return userMapper.login(user);
	}
}
