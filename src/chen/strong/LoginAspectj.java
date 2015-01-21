package chen.strong;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect//登陆aspect
public class LoginAspectj extends BaseAspectj{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Around("execution(* chen.action.LoginAction.execute(..))")
	public Object regcheck(ProceedingJoinPoint jp) throws Throwable{
		System.err.println("登陆前检查");
		if(this.useriflogin()){
			setSkipstr("index");
			return getSkipstr().toString();
		}
		
		return jp.proceed();
		
	}
//	public 
}
