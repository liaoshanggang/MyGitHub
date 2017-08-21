package com.lanqiao.service;

import com.lanqiao.vo.UserInfo;

/**
 * 因为service包中要加入事务的所以方法要满足嵌入方法的规则
 * @author gg
 *
 */
public interface IUserService {
	/**
	 * @param user
	 * @return
	 */
	public UserInfo selectForLogin(UserInfo user);
}
