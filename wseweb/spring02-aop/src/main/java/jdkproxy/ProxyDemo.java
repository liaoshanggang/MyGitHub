package jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.lanqiao.service.BookServiceImpl;
import com.lanqiao.service.IBookService;

public class ProxyDemo {
	public static void main(String[] args) {
		InvocationHandler handle = new BookServiceInvocationHandler(
				new BookServiceImpl());
		IBookService service = (IBookService) Proxy.newProxyInstance(
				IBookService.class.getClassLoader(),
				new Class[] { IBookService.class }, handle);
		// jvm生成的代理实例最多可生成65536个实例， $Proxy0~65535
		System.out.println(service.getClass().getName());
		Method[] methods = service.getClass().getMethods();
		for (Method m : methods) {
			System.out.println(m);
		}
		 service.buy("Spring从入门到放弃", "james", 45.5);
		 service.comments("andy", "Java开发攻城师必读");
	}
}
