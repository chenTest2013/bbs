package chen.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chen.myInterface.InjectProxy;

public class AspectJTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		System.out.println("chentest="+ctx.containsLocalBean("chentest"));

		//System.out.println("ctx.getBean(Test.class)=" + ctx.getBean(Test.class));
		// System.out.println("ctx.getBean(Test.class)="+ctx.);
		Object obj= ctx.getBean("chentest");
		
//		boolean a = AopUtils.isAopProxy(obj); // ： 是否是代理对象；
//		 boolean b = AopUtils.isCglibProxy(obj); // 是否是CGLIB方式的代理对象；
//		 boolean c = AopUtils.isJdkDynamicProxy(obj);// ：是否是JDK动态代理方式的代理对象；
//		 System.err.println("传进的参数是="+obj);
//		 System.err.println("是否是代理对象=" +a);
//		 System.out.println("是否是CGLIB方式的代理对象=" + b);
//		 System.out.println("是否是JDK动态代理方式的代理对象=" + c);
//		 System.out.println("InjectProxy="+(obj instanceof InjectProxy));
//		
//		System.out.println("ImplInjectProxy="+(obj instanceof ImplInjectProxy));
		((InjectProxy)obj).aa("我们来啦");
		
		//t.aa("我们来啦");

		// System.out.println(ctx.containsLocalBean("testAspectj"));
	}

}
