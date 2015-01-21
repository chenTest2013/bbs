package chen.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test.xml");
		System.out.println(ctx.containsLocalBean("chentest"));
		Test t=(Test)ctx.getBean("chentest");
		t.a("我们来啦");
		
		System.out.println(ctx.containsLocalBean("regAspectj"));
	}

}
