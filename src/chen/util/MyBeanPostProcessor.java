package chen.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		System.err.println("bean后处理器在初始化之前对"+arg1+"增强处理");
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		System.err.println("bean后处理器在初始化之后对"+arg1+"增强处理");
		return arg0;
	}

}
