package com.lanqiao.service.impl;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lanqiao.service.IUserService;
import com.lanqiao.vo.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class UserServiceImplTest {
	//No qualifying bean of type 'com.lanqiao.service.IUserService' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@javax.annotation.Resource(shareable=true, lookup=, name=, description=, authenticationType=CONTAINER, type=class java.lang.Object, mappedName=)}
	@Resource
	IUserService userService;

	@Ignore
	@Test
	public void testSelectForLogin() {
		System.out.println(userService.getClass().getName());

		UserInfo userInfo = this.userService.selectForLogin(new UserInfo(null,
				"admin", "admin", null, null));
		System.out.println(userInfo);
	}

	@Test
	public void testInsertForReg(){
		this.userService.insertForReg(new UserInfo(null,
				"hello", "hello", "123456", "123456"));
//		this.userService.insertForReg(new UserInfo(null,
//				"hello", "hello", null, null));
	}
}
