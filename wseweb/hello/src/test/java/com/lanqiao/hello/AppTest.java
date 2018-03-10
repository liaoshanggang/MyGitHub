package com.lanqiao.hello;

import org.junit.Test;

public class AppTest

{
	@Test
	public void testApp() {
		String s = new HelloApp().sayHello("james");
		System.out.println(s);
	}
}
