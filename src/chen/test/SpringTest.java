package chen.test;

import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chen.service.impl.UserServiceImpl;

public class SpringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean0.xml");

		System.out.println(ctx);
		UserServiceImpl userservi = (UserServiceImpl) ctx.getBean("userser", UserServiceImpl.class);
		
		System.out.println("userservi=="+userservi);
		String[] a = { "读者" };
		Object[] b = { new Date() };
		System.out.println(Locale.getDefault());
		String hello = ctx.getMessage("hello", a, Locale.getDefault());
		String now = ctx.getMessage("now", b, Locale.getDefault());
		System.out.println(hello);
		System.out.println(now);
	}

}
