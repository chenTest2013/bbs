package chen.strong;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.opensymphony.xwork2.ActionContext;


// 注册aspect
@Aspect
public class RegAspectj extends BaseAspectj{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  
    private boolean resstr;// 这个用来验证用户名是否存在的标志
	private boolean existemail;// 这个用来标示email是否存在
	private boolean checkcode;// 这个用来检验code是否正确
   
	
	@Around("execution(* chen.action.RegAction.userRegistr(..))")
	public Object regcheck(ProceedingJoinPoint jp) throws Throwable{
		
		System.err.println("注册前检查!");
		if (checkReg() && check(getArgs("username"), "u") && check(getArgs("email"), "e")) {
			return jp.proceed();
		} else {
			return this.getSkipstr().toString();
		}

	}
	
	
	// 方便客服端调用检查,配置成action(客服端调用)
		public String checkemail() {
			System.err.println("checkemail");
			String result = ERROR;
			if (!this.useriflogin()&&getArgs("email")!= null) {//若用户登录不允许调用次方法
				System.out.println("checkemail开始执行");
				result = SUCCESS;
				if (this.check(getArgs("email"), "e")) {
					this.setExistemail(true);
				} else {
					System.out.println("该邮箱已被注册!");
					this.setMessage("该邮箱已被注册!");
					this.setExistemail(false);
				}
			}
			else{
				this.setMessage("未定义操作!");
				ActionContext.getContext().getSession().put("message", this.getMessage());
			}
			return result;

		}
	// 方便客服端调用检查,配置成action(客服端调用)
	public String checkname() {
		System.err.println("checkname");
		String result = ERROR;
	
		if (!this.useriflogin()&&getArgs("username") != null) {//若用户登录不允许调用次方法
			System.out.println("checkname开始执行");
			result = SUCCESS;
			if (this.check(getArgs("username"), "u")) {
				System.out.println("恭喜,该用户名可用!");
				this.setResstr(true);
			} else {
				this.setMessage("用户名已存在!");
				this.setResstr(false);
				System.out.println("用户名已存在!");
			}
		}else{
			this.setMessage("未定义操作!");
			ActionContext.getContext().getSession().put("message", this.getMessage());
		}
		return result;
	}
	
	
	// 检验验证码方法
	private boolean checkcode(String str) {

		// 从session中取出RandomAction.java 中生成的验证码random
		Object arandom = (ActionContext.getContext().getSession().get("random"));
		
        if(arandom==null||str==null){
        	return false;
        }
		
		
		// 下面就是将session中保存验证码字符串与客户输入的验证码字符串对比了
		if (str.equals(((String)arandom).toLowerCase())) {
			// System.out.println("127");
			return true;

		} else {
			this.setMessage("验证码错误");
			System.out.println("132");
			this.setSkipstr(ERROR);
			return false;
		}
	}
		
		// 检查输入的注册信息是否合法,正则匹配
		private int checkreginfo() {
			int i=checkuserinfo(getArgs("username"),getArgs("email"),getArgs("pwd"),getArgs("pwd2"),getArgs("sex"),getArgs("authcode"));
			return i;

		}
		
		// 注册前用户状态检查
		private boolean checkReg() {//只考虑非正常流程
			if(!checkcode(getArgs("authcode"))){//检验验证码是否正确
				this.setSkipstr("register");
				return false;
			}
			if (!this.useriflogin()) {// 判断是否有用户登录
				if (this.checkreginfo() != 5) {
					this.setSkipstr("register");
					//System.out.println("161");
					return false;
				}

			} else {
				// 当用户登录了,并且又打开了注册页面时,点注册时跳转到出错页
				if (1 <= this.checkreginfo() && this.checkreginfo() <= 5) {
					this.setMessage("未定义操作!");
					this.setSkipstr(ERROR);
					ActionContext.getContext().getSession().put("message", this.getMessage());
					System.out.println("169");

				} else {
					// 当用户登录,访问注册action时跳转到主页(防止用户在登陆时打开注册页面)
					this.setSkipstr("index");

				}
				return false;
			}
			return true;

		}

		public boolean isResstr() {
			return resstr;
		}

		public void setResstr(boolean resstr) {
			this.resstr = resstr;
		}

		public boolean isExistemail() {
			return existemail;
		}

		public void setExistemail(boolean existemail) {
			this.existemail = existemail;
		}

		public boolean isCheckcode() {
			return checkcode;
		}

		public void setCheckcode(boolean checkcode) {
			this.checkcode = checkcode;
		}
		
		
		
		
		//@Before("execution(* chen.service.impl.*.*(..))")
//		public void say() {
//			System.out.println("@Before你好,我是Test,我出来检查");
//		}
	//
//		// @AfterReturning(returning = "str", pointcut =
//		// "execution(* chen.service.impl.*.*(..))")
//		public void eat(Object str) {
//			System.out.println("@AfterReturning获取目标方法返回值==" + str);
//			this.setName("eat方法");
//			System.out.println("@AfterReturning你好,我叫" + this.name);
//		}
	//
//		// @AfterThrowing(throwing="ex",pointcut="execution(* chen.service.impl.*.*(..))")
//		public void errorp(Throwable ex) {
//			System.out.println("@AfterThrowing获取目标方法抛出的异常==" + ex);
//			System.out.println("@AfterThrowing模拟异常处理");
	//
//		}
	//
//		public String getName() {
//			return name;
//		}
	//
//		public void setName(String name) {
//			this.name = name;
//		}
	//

		
}
