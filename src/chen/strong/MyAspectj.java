package chen.strong;

//此类待开发
public abstract class  MyAspectj implements MyActionInterface{

	@Override
	public String execute() throws Exception {
		return SUCCESS;
		
	}
	//@Around("execution(* chen.action.RegAction.userRegistr(..))")
	//public Object regcheck(ProceedingJoinPoint jp) throws Throwable;
	
}
