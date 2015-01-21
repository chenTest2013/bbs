package chen.util;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import chen.myInterface.InjectProxy;
import chen.test.ImplInjectProxy;

public class MyBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {

	private ApplicationContext context;
	
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		//System.err.println("bean后处理器在初始化之前对"+arg1+"增强处理");
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		if(!(arg0 instanceof InjectProxy)){
			System.err.println("25");
			return arg0;
		}
//		if(AopUtils.isAopProxy(arg0)){
//			System.err.println("28");
//			if(AopUtils.isCglibProxy(arg0)){//将代理对象注入
//				System.err.println("30");
//				((ImplInjectProxy)arg0).setSelfProxy(this.context.getBean(arg1));
//			}
//			if(AopUtils.isJdkDynamicProxy(arg0)){
//				System.err.println("暂未实现该代理类型的注入！");
//			}
//		}
		
		((InjectProxy)arg0).setSelfProxy((InjectProxy)this.context.getBean(arg1));
//		 boolean a = AopUtils.isAopProxy(arg0); // ： 是否是代理对象；
//		 boolean b = AopUtils.isCglibProxy(arg0); // 是否是CGLIB方式的代理对象；
//		 boolean c = AopUtils.isJdkDynamicProxy(arg0);// ：是否是JDK动态代理方式的代理对象；
		 //System.err.println("传进的参数是="+arg1);
		// System.err.println("是否是代理对象=" + AopUtils.isAopProxy(this.context.getBean(arg1)));
//		 System.out.println("是否是CGLIB方式的代理对象=" + b);
//		 System.out.println("是否是JDK动态代理方式的代理对象=" + c);
		
		System.err.println("bean后处理器在初始化之后对"+arg1+"增强处理");
		return arg0;
	}

	@Override//设置Spring容器
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.setContext(applicationContext);
		System.out.println("自定义Bean后处理器设置Spring容器成功");
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

}
