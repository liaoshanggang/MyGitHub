package edu.glut.service;

import java.util.List;

import edu.glut.vo.SysUser;


public interface ISysUserService {
	/**
	 * 用戶登录
	 * @param user
	 * @return
	 */
	SysUser selectForLogin(SysUser user);
	
	public List<SysUser> selectCusManger();
}
