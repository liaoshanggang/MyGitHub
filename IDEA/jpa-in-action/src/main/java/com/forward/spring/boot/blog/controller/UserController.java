package com.forward.spring.boot.blog.controller;

import com.forward.spring.boot.blog.domain.User;
import com.forward.spring.boot.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * 从 用户存储库 获取用户列表
	 * @return
	 */
	private List<User> getUserslist() {
		return (List<User>) userRepository.findAll();
	}

	/**
	 * 查询所有用户
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView list(Model model){
		model.addAttribute("userList", getUserslist());
		model.addAttribute("title", "用户管理");
		return new ModelAndView("users/list","userModel",model);
	}
	
	/**
	 *  根据id查询用户
	 * @param model
	 * @return
	 */
	@GetMapping("/{id}")
	public ModelAndView view(@PathVariable Long id,Model model){
		Optional<User> user = userRepository.findById(id);
		User user2 = user.get();
		model.addAttribute("user", user2);
		model.addAttribute("title", "查看用户");
		return new ModelAndView("users/view","userModel",model);
	}
	
	/**
	 * 获取创建页面表单
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView createForm(Model model){
		model.addAttribute("user", new User(null,null,null));
		model.addAttribute("title", "创建用户");
		return new ModelAndView("users/form","userModel",model);
	}

	/**
	 * 新建用户
	 * @param user
	 * @return
	 */
	@PostMapping
	public ModelAndView create(User user) {
		user = userRepository.save(user);
		return new ModelAndView("redirect:/users");
	}

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, Model model) {
		userRepository.deleteById(id);

		model.addAttribute("userList", getUserslist());
		model.addAttribute("title", "删除用户");
		return new ModelAndView("users/list", "userModel", model);
	}

	/**
	 * 修改用户
	 */
	@GetMapping(value = "modify/{id}")
	public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
		Optional<User> user = userRepository.findById(id);
		User user1 = user.get();
		model.addAttribute("user", user1);
		model.addAttribute("title", "修改用户");
		return new ModelAndView("users/form", "userModel", model);
	}

	/**
	 * 创建和修改用户
	 * @param model
	 * @return
	 */
//	@PostMapping
//	public ModelAndView saveOrUpdateUser(User user,Model model){
//		user = userRepository.SaveOrUpdateUser(user);
//		//model.addAttribute("user", new User());
//		return new ModelAndView("users/form","userModel",model);
//	}
}
