package jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BookServiceInvocationHandler implements InvocationHandler {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
	Object target;
	
	/**
	 * @param target 目标对象
	 */
	public BookServiceInvocationHandler(Object target) {
		super();
		this.target = target;
	}
	/**
	 * 调用目标方法
	 * @param proxy 代理对象
	 * @param method 目标方法，此处：buy(), comment()
	 * @param args 目标方法的参数
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//在调用目标方法前我们有机会做一些其它事情
		System.out.println("[系统日记]"+sdf.format(new Date())
		+"调用了"+method.getName()+"("+Arrays.toString(args).replace("[", "").replace("]", "")+")");		
		Object returnValue = method.invoke(target, args);
		//这里还可以记录日志
		return returnValue;
	}

}
