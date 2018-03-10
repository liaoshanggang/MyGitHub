package edu.glut.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.glut.service.ISysUserService;
import edu.glut.vo.SysUser;

@Controller
@RequestMapping("/user")
public class SysUserController {
	@Resource
	ISysUserService iSysUserService;
	
	@RequestMapping(value = { "/login" }, method = { RequestMethod.POST })
	public String login(SysUser sysUser, ModelMap modelMap, HttpSession session) {
		System.out.println(sysUser);
		SysUser user = iSysUserService.selectForLogin(sysUser);
		if(user!=null){
			session.setAttribute("logUser", user);
			return "redirect:/main.jsp";
		}
		return "redirect:/login.jsp";
	}

}
