package com.lanqiao.mapper;

import org.springframework.stereotype.Repository;

import com.lanqiao.vo.UserInfo;

//扫描映射器接口的时候自动加
@Repository
public interface UserMapper {
	public UserInfo login(UserInfo user);

	public int reg(UserInfo user);
}
