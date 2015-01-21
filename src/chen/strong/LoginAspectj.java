package chen.strong;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import chen.action.LoginAction;

@Aspect
// 登陆aspect
public class LoginAspectj extends BaseAspectj {

	/**
	 * 
	 */
	private LoginAction l;

	@Around("execution(* chen.action.LoginAction.execute(..))")
	public Object logincheck(ProceedingJoinPoint jp) throws Throwable {
		l = (LoginAction) jp.getTarget();
		System.err.println("登陆前检查");
		if (this.useriflogin()) {
			return INDEX;
		} else if (getArgs("username") == null || getArgs("password") == null) {
			return LOGIN;
		} else if (!checkname("username") || !checkpass("password")){// 若不符合正则返回错误
			System.out.println("不符合正则!");
			//l.addActionError("未定义操作");//直接前台显示用户名或密码错误
			l.addActionError("用户名或密码错误!");
			return ERROR;
		}else  {
			l.setCodemark(true);//设置验证码访问状态
			return jp.proceed();
		} 
	
	}
	@Around("execution(* chen.action.LoginAction.loginOut(..))")
	public Object outcheck(ProceedingJoinPoint jp) throws Throwable {
		System.err.println("outcheck开始执行");
		if(!this.useriflogin()){
			return INDEX;
		}
		return jp.proceed();
		
	}
	
	
	// 检查输入的用户名是否符合正则(防止sql注入)
	public boolean checkname(String str) {
		return checkinput(str, 0);

	}

	// 检查输入的密码是否符合正则(防止sql注入)
	public boolean checkpass(String str) {

		return checkinput(str, 2);

	}

	// 检查输入的用户名和密码是否符合正则(防止sql注入)
	public boolean checkinput(String str, int i) {

		if (checkuserinfo(getArgs(str), i)) {
			return true;
		}
		return false;

	}

}
