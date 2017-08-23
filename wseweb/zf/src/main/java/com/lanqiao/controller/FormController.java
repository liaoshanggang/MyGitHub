package com.lanqiao.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanqiao.vo.Person;

@Controller
@RequestMapping(value = "/FormDemo")
public class FormController {
	@RequestMapping(value = "/testForm")
	public String testForm(Map<String, Person> map) {
		Person per = new Person();
		per.setName("张三");
		per.setAge(23);
		// 在request域中增加command属性（JavaBean类型的属性）
		map.put("command", per);
		return "forward:/views/springForm.jsp";
	}
}