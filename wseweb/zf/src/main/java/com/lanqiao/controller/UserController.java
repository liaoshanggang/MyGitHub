package com.lanqiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lanqiao.vo.UserInfo;

/*
 * 普通的javabean作为控制器,用spring-mvc的注解
 * @Controller注解来标识本类是一个SpringMVC Controller 对象
 */
@Controller
public class UserController {
	//输入框的名字和
	// /user/login， 只能处理post方式的请示，不指定则所请求方式都可地
	 //使用@RequestMapping注解来映射请求的URL。
	/**
	 * @param user 自动将请求中的参数注入到该对象的属性上，只要输入框的名字和类的属性名相同
	 * @param modelMap 其作用域为request
	 * @return
	 */
	@RequestMapping(value={"/user/login"},method={RequestMethod.POST})
	public String login(UserInfo user,ModelMap modelMap){
		System.out.println(user);
		modelMap.addAttribute("user", user);
		return "list";
	}
}
