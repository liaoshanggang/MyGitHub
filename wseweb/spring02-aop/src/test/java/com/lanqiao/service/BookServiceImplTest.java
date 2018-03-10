package com.lanqiao.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aop.xml")
public class BookServiceImplTest {

	@Autowired //自动注入，自动装配
	IBookService bookService;
	
	@Test
	public void testBuy() {
		bookService.buy("Spring从入门到放弃", "james", 45.5);
	}

	@Test
	public void testComments() {
		bookService.comments("andy", "Java开发攻城师必读");
	}

}
