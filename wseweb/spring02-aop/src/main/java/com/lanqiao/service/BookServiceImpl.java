package com.lanqiao.service;

import org.springframework.stereotype.Component;


@Component("bookService") //相当于xml配置： <bean id="bookService"></bean>
public class BookServiceImpl implements IBookService {
	
	// 记录日志
	//非倾入性的方式为业务类的方法记录日志
	public void buy(String bookName, String username, double price) {
		System.out.println("业务方法buy开始执行......");
		System.out.println("*" + username + " 购买了：" + bookName);
		System.out.println("*" + username + "增加积分：" + (int)(price/10));
		System.out.println("与付款系统交互....");
		System.out.println("业务方法buy执行结束。\n");
		//log()
	}

	
	public void comments(String username, String comment) {
		System.out.println("业务方法comments开始执行......");
		System.out.println("*" + username + " 发表书评：" + comment);
		System.out.println("业务方法comments执行结束。\n");
	}

	public static void main(String[] args) {
		//new BookServiceImpl().buy(bookName, username, price);
		//机票
		
		//第三方，代理机构
	}
}
