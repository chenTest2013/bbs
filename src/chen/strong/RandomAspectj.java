package chen.strong;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import chen.action.RandomAction;
@Aspect
public class RandomAspectj extends BaseAspectj {
	@Around("execution(* chen.action.RandomAction.execute(..))")
	public Object randomCheck(ProceedingJoinPoint jp) throws Throwable{
		RandomAction r=(RandomAction)jp.getTarget();
		if(r.isCodemark()){
			return jp.proceed();
		}
		ServletActionContext.getResponse().sendError(403);
		return ERROR;
		
	}
}
