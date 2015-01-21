package chen.strong;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import chen.action.RegAction;

// 注册aspect
@Aspect
public class RegAspectj extends BaseAspectj {
	/**
	 * 
	 */
    private RegAction r;
	@Around("execution(* chen.action.RegAction.userRegistr(..))")
	public Object regcheck(ProceedingJoinPoint jp) throws Throwable {
//		setMessage("在切面bean中设置测试message");//此处设置的message为什么在jsp页面中取不到
//		System.out.println("jp.getKind()="+jp.getKind());
//		System.out.println("jp.toLongString()="+jp.toLongString());
//		System.out.println("jp.toShortString()="+jp.toShortString());
//		System.out.println("jp.getSignature()="+jp.getSignature());
//		System.out.println("jp.getSourceLocation()="+jp.getSourceLocation());
//		System.out.println("jp.getStaticPart()="+jp.getStaticPart());
//		System.out.println("jp.getTarget()="+jp.getTarget());
//		System.out.println("jp.getThis()="+jp.getThis());
		
		r=(RegAction)jp.getTarget();
		
		System.err.println("注册前检查!");
		if (checkReg() && this.checkcode(r.getAuthcode()) && check(r.getUsername(), "u")
				&& check(r.getEmail(), "e")) {
			r.setCodemark(true);//设置验证码访问状态
			return jp.proceed();
		} else {
			// System.out.println("skipstr的值是" + getSkipstr().toString());
			return getSkipstr().toString();
		}
	}


	// 注册前用户状态检查
	private boolean checkReg() {// 只考虑非正常流程
		System.out.println("checkReg开始执行");
//		r.setCodemark(true);//设置验证码访问状态
        boolean mark=true;
		if (!this.useriflogin()) {// 判断是否有用户登录,当用户没有登录的时候
			
			if (this.checkreginfo() ==-1) {// 此处是若绕过js校验后,服务器端的验证
				mark= false;
				System.out.println("两次输入密码不一致");
				// clearActionErrors();//清除actionerror信息
				// addActionMessage("两次输入密码不一致(来自RegAction.message)");
				r.addActionError("两次输入密码不一致(来自addActionError)");
				setSkipstr(ERROR);
				
				
			}
			if (this.checkreginfo() != 5) {
				mark= false;
				//System.out.println("checkreginfo()的值:" + checkreginfo());
				setSkipstr(REGISTER);
				System.out.println("super.setSkipstr()执行102 getSkipstr()=" + getSkipstr());
				
			}
			
		} else {// 当用户登录的时候
			// 当用户登录了,并且又打开了注册页面时,点注册时跳转到出错页
			if (1 <= this.checkreginfo() && this.checkreginfo() <= 5) {
				mark= false;
				r.addActionError("未定义操作!");
				setSkipstr(ERROR);
				System.out.println("checkReg()执行53");
				// System.out.println("119");
				
			} else {
				// 当用户登录,访问注册action时跳转到主页(防止用户在登陆时打开注册页面)
				mark= false;
				setSkipstr(INDEX);
				System.out.println("checkReg()执行58");
				
			}
			
		}
		return mark;

	}

	// 检查输入的注册信息是否合法,正则匹配
		private int checkreginfo() {
			//首先要验证密码是否一致
			if(r.getPwd()==null){
				return 0;
			}
			if (!r.getPwd().equals(r.getPwd2())) {
				return -1;
			}
			int i = checkuserinfo(r.getUsername(), r.getEmail(), r.getPwd(),r.getSex(),
					r.getAuthcode());
			return i;

		}
	
	@Override
	public boolean checkcode(String str) {
		if (!super.checkcode(str)) {
			r.addActionError("验证码错误!");
			setSkipstr(ERROR);
			return false;
		}
		return true;
	}

	@Override
	public boolean check(String... str) {

		if (!super.check(str)) {
			if ("u".equals(str[1])) {
				r.setMessage("用户名已存在");
			} else {
				r.setMessage("该邮箱已注册");
			}
			setSkipstr(ERROR);
			return false;
		}
		return true;
	}
}
