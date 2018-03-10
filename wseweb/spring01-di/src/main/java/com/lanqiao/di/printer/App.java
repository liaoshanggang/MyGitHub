package com.lanqiao.di.printer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Hello world!
 *
 */
@ContextConfiguration("classpath:di.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class App {
	// public static void main( String[] args )
	// {
	// ApplicationContext context = new
	// ClassPathXmlApplicationContext("di.xml");
	// Printer printer = (Printer) context.getBean("a4ColorPrinter");
	// printer.print("打印机功能的实现依赖于 墨盒 和 纸张");
	// }
	//
	@Autowired
	// 自动装配bean, 按照bean id与装配对象的属性来进行自动装配
	Printer b5GrayPrinter;
	@Test
	public void test(){
		b5GrayPrinter.print("打印机功能的实现依赖于 墨盒 和 纸张");
	}
}
