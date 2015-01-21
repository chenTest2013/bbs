package chen.strong;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import chen.action.IndexAction;
@Aspect
public class IndexAspectj extends BaseAspectj {
	
	@Around("execution(* chen.action.IndexAction.execute(..))")
	public Object indexCheck(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("indexCheck开始执行");
		IndexAction i=(IndexAction)jp.getTarget();
		
		System.out.println("用户登录了吗？="+this.useriflogin());//判断用户登录，将用户登陆状态信息存入session
		i.setCodemark(true);//设置验证码访问状态
		return jp.proceed();
		
	}

}
