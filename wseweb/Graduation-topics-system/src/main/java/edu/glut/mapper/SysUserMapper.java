package edu.glut.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.glut.vo.SysUser;

/**
 * 用户管理
 * @author Administrator
 *
 */
@Repository
public interface SysUserMapper{
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public SysUser login(SysUser user);
	
	public List<SysUser> selectCusManger();
}
