package com.lanqiao.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lanqiao.vo.Student;

//还可以使用types将某一个类型的对象都加入到session范围
@SessionAttributes(types = Student.class)
// 表示将request作用域中的"student"对象同时加入到session作用域之中。
// @SessionAttributes(value="student")
@RequestMapping("/FirstSpringDemo")
@Controller
public class TestController {

	@RequestMapping(value = "/firstSpringMVC", method = RequestMethod.POST)
	public String welcomeToSpringMVC() {
		return "success";
	}

	// 必须包含“name”参数，并且“age!=23”
	@RequestMapping(value = "/requestWithParams", params = { "name", "age!=23" })
	public String requestWithParams() {
		return "success";
	}

	@RequestMapping(value = "/requestWithHeaders", headers = {
			"Accept-Language=zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3",
			"Accept-Encoding=gzip, deflate" })
	public String requestWithHeaders() {
		return "success";
	}

	// 使用REST风格，处理“删除”的请求
	@RequestMapping(value = "/requestWithREST/{id}", method = RequestMethod.DELETE)
	public String requestWithRestDelete(@PathVariable("id") Integer id) {
		System.out.println("删除时需要的id:" + id);
		return "success";
	}

	// 使用REST风格，处理“修改”的请求
	@RequestMapping(value = "/requestWithREST/{id}", method = RequestMethod.PUT)
	public String requestWithRestPut(@PathVariable("id") Integer id) {
		System.out.println("修改时需要的id:" + id);
		return "success";
	}

	// 使用REST风格，处理“增加”的请求
	@RequestMapping(value = "/requestWithREST/{id}", method = RequestMethod.POST)
	public String requestWithRestAdd(@PathVariable("id") Integer id) {
		System.out.println("增加时需要的id:" + id);
		return "success";
	}

	// 使用REST风格，处理“查看”的请求
	@RequestMapping(value = "/requestWithREST/{id}", method = RequestMethod.GET)
	public String requestWithRestGet(@PathVariable("id") Integer id) {
		System.out.println("查询时需要的id:" + id);
		return "success";
	}

	// 使用@RequestParam注解接收请求参数
	@RequestMapping("/requestParam")
	public String requestParam(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "age", required = false, defaultValue = "23") Integer age) {
		System.out.println("name: " + name + "   age: " + age);
		return "success";
	}

	@RequestMapping("/requestHeader")
	public String requestHeader(
			@RequestHeader(value = "Accept-Language") String al) {
		System.out.println("Accept-Language:" + al);
		return "success";
	}

	/**
	 * @CookieValue可以给处理方法入参绑定某个Cookie值。 例如，客户端有一个名为JSESSIONID的Cookie对象，
	 *                                   服务端可以通过@CookieValue来获取此JSESSIONID的值：
	 * @param sessionid
	 * @return
	 */
	@RequestMapping("/cookieValue")
	public String cookieValue(
			@CookieValue(value = "JSESSIONID") String sessionid) {
		System.out.println("sessionid:" + sessionid);
		return "success";
	}

	/**
	 * 如果处理方法的参数是一个实体类对象， 那么SpringMVC会将请求的参数名与实体类对象的属性进行匹配，
	 * 为实体类对象的属性赋值，并且支持级联属性的赋值。
	 */
	// 使用实体类对象接收请求参数值(form表单中提交的数据)
	@RequestMapping("/entityProperties")
	public String entityProperties(Student student) {
		System.out.println(student);
		return "success";
	}

	// 使用Servlet API开发
	@RequestMapping("/developWithServletAPI")
	public String developWithServletAPI(HttpServletRequest requst,
			HttpServletResponse response, HttpSession session) {
		// 使用request和response参数处理请求或响应...
		return "success";
	}

	/**
	 * SpringMVC提供了四种途径来处理带数据的视图（M和V）： ModelAndView，ModelMap、Map及Model，
	 * 
	 * @SessionAttributes，@ModelAttribute
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		String view = "success";
		ModelAndView mav = new ModelAndView(view);
		Student student = new Student("张三", 23, null);
		// 添加student对象数据放入ModelAndView中
		mav.addObject("student ", student);// ???????????
		return mav;
	}

	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		Student student = new Student("张三", 23, null);
		map.put("student", student);
		return "success";
	}

	@RequestMapping("/testModelMap")
	public String testMap(ModelMap map) {
		Student student = new Student("张三", 23, null);
		map.put("student", student);
		return "success";
	}

	@RequestMapping("/testModel")
	public String testModel(Model map) {
		Student student = new Student("张三", 23, null);
		map.addAttribute("student", student);
		return "success";
	}

	@RequestMapping("/testSessionAttribute")
	public String testSessionAttribute(Map<String, Object> map) {
		Student student = new Student("张三", 23, null);
		map.put("student", student);
		return "success";
	}

	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(Student student) {// @ModelAttribute("stu")
		// 省略数据库的更新操作：将数据表中stuNo=31的学生信息，更新为参数student中的各属性值
		System.out.println("更新后的学生信息：姓名： " + student.getStuName() + ",年龄："
				+ student.getStuAge());
		return "success";
	}

	/**
	 * 标有@ModelAttribute注解的方法， 会在请求处理类中的每一个方法执行前，都执行一次，因此需要谨慎使用。
	 * 
	 * @param stuNo
	 * @param map
	 */
	// @ModelAttribute
	// public void queryStudentBeforeUpdate(int stuNo, Map<String, Object> map)
	// {
	// // 使用带数据的实体类对象，模拟从数据库中获取学号为stuNo的学生对象
	// Student student = new Student();
	// student.setStuNo(stuNo);
	// student.setStuName("张三");
	// student.setStuAge(23);
	// // 即用以上语句模拟Student student = stuService.queryStudentByNo(stuNo);
	//
	// // 将从数据库中查询的student对象放入map中
	// map.put("student", student);
	// // 如果map中的key值与请求处理方法的参数名不一致，则需要在参数前使用@ModelAttribute标识出map中对应的key值
	// //map.put("stu", student);
	// }

	@RequestMapping("/testI18n")
	public String testI18n() {
		return "success";
	}

	@RequestMapping("/testConversionServiceConverer")
	public String testConversionServiceConverer(
			@RequestParam("studentInfo") Student student) {
		System.out.println("学号:" + student.getStuNo() + ",姓名:"
				+ student.getStuName() + ",年龄:" + student.getStuAge());
		return "success";
	}

	@RequestMapping("/testDateTimeFormat")
	public String testDateTimeFormat(Student student, BindingResult result) {
		System.out.println("学号：" + student.getStuNo() + ",姓名："
				+ student.getStuName() + ",生日" + student.getBirthday());
		// 如果有错误信息
		if (result.getErrorCount() > 0) {
			// 循环遍历所有错误信息
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ":"
						+ error.getDefaultMessage());
			}
		}
		return "success";
	}

	@RequestMapping("/testValid")
	public String testValid(@Valid Student student, BindingResult result,
			Map<String, Object> map) {
		if (result.getErrorCount() > 0) {
			// 循环遍历所有错误信息
			// for (FieldError error : result.getFieldErrors()) {
			// System.out.println(error.getField() + ":"
			// + error.getDefaultMessage());
			// }

			// 将错误信息通过map放入request作用域之中
			map.put("errors", result.getFieldErrors());
			return "error";
		}
		return "success";
	}
	/**
	 * ①参数名：实际是判断是否与“首字母小写的参数类型”一致。
	 * 如参数的类型是Student，则会判断是否与首字母小写的参数类型（即”student”）一致。
	 * 此段落中，用“参数名”来代替“首字母小写的参数类型”仅仅是为了便于读者阅读。
	 */

}
