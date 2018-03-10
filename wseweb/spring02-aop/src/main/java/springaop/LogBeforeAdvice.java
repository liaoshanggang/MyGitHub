package springaop;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;
@Component //组件，spring会在它自身的容器内创建一个bean id=logBeforeAdvice的bean实例
public class LogBeforeAdvice implements MethodBeforeAdvice {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		//在调用目标方法前我们有机会做一些其它事情
				System.out.println("[系统日志]" + sdf.format(new Date()) + " 调用了" + method.getName() 
						+ "(" + Arrays.toString(args).replace("[", "").replace("]", "") + ")");
	}
}
