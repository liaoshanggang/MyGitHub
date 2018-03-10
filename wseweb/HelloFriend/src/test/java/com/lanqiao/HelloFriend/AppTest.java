package com.lanqiao.HelloFriend;

import org.junit.Test;

import com.lanqiao.hello.HelloApp;

public class AppTest

{
	@Test
	public void testApp() {
		String s = new HelloApp().sayHello("james");
		System.out.println(s);
	}
}
