package chen.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.support.AopUtils;

@Aspect
public class TestAspectj {

	@Around("execution(* chen.test.Test.a*(..))")
	public Object testCheck(ProceedingJoinPoint jp) throws Throwable {
		// System.out.println("jp="+jp);
		// System.out.println("jp.getClass="+jp.getClass());
		// System.out.println("jp.getThis()=" + jp.getThis());
		// System.out.println("jp.getTarget()=" + jp.getTarget());
		// boolean a = AopUtils.isAopProxy(jp.getThis()); // ： 是否是代理对象；
		// boolean b = AopUtils.isCglibProxy(jp.getThis()); // ：
		// 是否是CGLIB方式的代理对象；
		// boolean c = AopUtils.isJdkDynamicProxy(jp.getThis());//
		// ：是否是JDK动态代理方式的代理对象；
		// System.out.println("是否是代理对象=" + a);
		// System.out.println("是否是CGLIB方式的代理对象=" + b);
		// System.out.println("是否是JDK动态代理方式的代理对象=" + c);
		System.out.println("testCheck开始执行");
		// Test t=(Test)jp.getTarget();
		System.out.println("切面bean开始调用方法");
		String str = (String) jp.proceed(new String[] { "we" });
		System.out.println("切面bean调用方法结束");
		// System.out.println("返回值str="+str);
		return str;

	}

}
