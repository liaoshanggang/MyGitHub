package com.forward.service;

import com.forward.entity.User;

public class UserServer {
	public void userRegister(User u){
		System.out.println(u.getUsername());
		System.out.println(u.getPwd());
	}
}
