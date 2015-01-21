package chen.strong;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import chen.entity.User;
import chen.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


// 此类暂时没作为切面bean,需要时出掉注释
@Aspect
public class RegAspectj extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String message;
    @Resource(name = "uservice")
	private UserService us;
    
	//@Before("execution(* chen.service.impl.*.*(..))")
	public void say() {
		System.out.println("@Before你好,我是Test,我出来检查");
	}

	// @AfterReturning(returning = "str", pointcut =
	// "execution(* chen.service.impl.*.*(..))")
	public void eat(Object str) {
		System.out.println("@AfterReturning获取目标方法返回值==" + str);
		this.setName("eat方法");
		System.out.println("@AfterReturning你好,我叫" + this.name);
	}

	// @AfterThrowing(throwing="ex",pointcut="execution(* chen.service.impl.*.*(..))")
	public void errorp(Throwable ex) {
		System.out.println("@AfterThrowing获取目标方法抛出的异常==" + ex);
		System.out.println("@AfterThrowing模拟异常处理");

	}

	//@Around("execution(* chen.service.impl.*.*(..))")
	public Object aroundTest(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("@Around执行目标方法之前");
		System.out.println("@Around获取目标方法参数" + jp.getArgs());
		Object s = jp.proceed();//执行目标方法
		System.out.println("@Around执行目标方法之后的返回值==" + s);
		return s;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 这个用来每次用户注册,保存用户登录状态
	//@Around("execution(void chen.service.impl.UserServiceImpl.saveUser(..))")
	public Object userState(ProceedingJoinPoint jp) throws Throwable{
		//System.out.println("@Around获取目标方法参数" + jp.getArgs());
		
		ActionContext.getContext().getSession().remove("userstate");
		ActionContext.getContext().getSession().put("userstate", true);
		System.out.println("i just test it!");
		System.err.println("i just test it!");
		return true;

	}
	@Around("execution(* chen.action.RegAction.set*(..))")
	public Object usercheck(ProceedingJoinPoint jp) throws Throwable{
		
		System.err.println("开始增强处理!");
		Object[] obj=jp.getArgs();
		if(obj!=null){
			for(Object o:obj){
				System.err.println("参数:"+o);
			}
		}else{
			System.err.println("没有参数");
		}
		System.out.println("jp.getKind()="+jp.getKind());
		System.out.println("jp.toLongString()="+jp.toLongString());
		System.out.println("jp.toShortString()="+jp.toShortString());
		System.out.println("jp.getSignature()="+jp.getSignature());
		System.out.println("jp.getSourceLocation()="+jp.getSourceLocation());
		System.out.println("jp.getStaticPart()="+jp.getStaticPart());
		System.out.println("jp.getTarget()="+jp.getTarget());
		System.out.println("jp.getThis()="+jp.getThis());
		//System.out.println("jp.getThis()="+jp.);
		Object s = jp.proceed();//执行目标方法
		System.err.println("@Around执行目标方法之后的返回值==" + s);
		return s;
	

	}
	// 检查用户名或邮箱是否已存在(服务端调用) (关于方法重载后在struts.xml中的method的配置问题)
	// 第一个参数:email或者用户名字的字符串,第二个参数要查询类型(email,name)
	private boolean check(String... str) {
		// 返回true可以使用
		Object obj = null;
		if (str != null && str.length > 1) {
			if (str[1].equals("u")) {
				obj = us.findUserByName(str[0]);
			} else if (str[1].equals("e")) {
				obj = us.findUserByEmail(str[0]);
			}
		}
		if (obj != null) {
			// System.out.println("已存在");
			this.message = "已存在此项";
			//this.setSkipstr(ERROR);
			return false;
		}
		// System.out.println("可以使用");
		return true;

	}

	// 方便客服端调用检查,配置成action(客服端调用)
//	public String checkname() {
//		System.err.println("checkname");
//		String result = ERROR;
//		if (!this.useriflogin()&&this.username != null) {//若用户登录不允许调用次方法
//			System.out.println("checkname开始执行");
//			result = SUCCESS;
//			if (this.check(this.username, "u")) {
//				System.out.println("恭喜,该用户名可用!");
//				this.setResstr(true);
//			} else {
//				this.setMessage("用户名已存在!");
//				this.setResstr(false);
//				System.out.println("用户名已存在!");
//			}
//		}else{
//			this.setMessage("未定义操作!");
//			ActionContext.getContext().getSession().put("message", this.message);
//		}
//		
//		return result;
//
//	}
	// 检查用户登录状态
	public boolean useriflogin() {
		Object obj = ActionContext.getContext().getSession().get("user");
		if (obj != null) {
			ActionContext.getContext().getSession().put("userstate", true);
			return true;
		}
		return false;
	}
	
		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
}
