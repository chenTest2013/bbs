package chen.strong;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import chen.service.UserService;

import com.opensymphony.xwork2.ActionContext;

@Scope("request")
// 不加这两个此类配置的action只执行一次
@Component
// 增强类的一些基本操作,切面bean都用到的东西放在这里面(继承MyAspectj方便return)
// 注意这个类不是切面bean
public class BaseAspectj extends MyAspectj {
	/**
	 * 
	 */
	@Resource(name = "uservice")
	private UserService us;
	private StringBuffer skipstr;// 跳转标示字符串
	private static String[] regex; // 正则表达式字符串数组
	private boolean checkcode;// 这个用来检验验证码是否正确
	private boolean exitname;// 这个用来验证用户名是否存在的标志
	private boolean existemail;// 这个用来标示email是否存在

	private String username;// 接受从客服端传来的参数,检验用户名是否存在时使用
	private String email;// 接受从客服端传来的参数,检验email是否存在时所使用
	private String authcode; // 接受从客服端传来的参数,检验验证码是否正确时使用
	//private static String[] aa;

	public BaseAspectj() {
//		aa = new String[5];
//		aa[0] = "[^_][\\w\u4e00-\u9fa5]{2,8}";
//		aa[1] = "([a-zA-Z0-9]{3,25}@([a-z]{2,25}|[0-9]{3,25}).com)";
//		aa[2] = "[\\w]{6,15}";
//		aa[3] = "[男女保密]{1,2}";
//		aa[4] = "[a-zA-Z0-9]{1,4}";
		System.out.println("regex在构造方法中开始初始化");
		regex = new String[5];
		// 由数字字母下划线汉字组成的名字,首字符不是下划线,且范围长度在3-8,包括边界
		// 注意这个{2,8},因为这个占一位置[^_]
		regex[0] = "[^_][\\w\u4e00-\u9fa5]{2,8}";
		// email验证@后面要么是数字要么是是字母
		regex[1] = "([a-zA-Z0-9]{3,25}@([a-z]{2,25}|[0-9]{3,25}).com)";
		// 密码验证
		regex[2] = "[\\w]{6,15}";
		// 4个汉字中的一个或者两个(男,女,保密)
		regex[3] = "[男女保密]{1,2}";

		regex[4] = "[a-zA-Z0-9]{1,4}";
		
		
	}

	// 获取请求的参数
	public String getArgs(String str) {
		String value = ServletActionContext.getRequest().getParameter(str);
		System.out.println("输入的参数是:" + str + ",得到的值是:" + value);
		return value;

	}

	// 检查用户登录状态
	public boolean useriflogin() {

		Object obj = ActionContext.getContext().getSession().get("user");
		if (obj != null) {
			ActionContext.getContext().getSession().put("userstate", true);
			System.out.println("用户已登陆");
			return true;
		}
		return false;
	}

	// 检验验证码方法 (客服端用)
	public String checkcode() {
		// System.out.println("BaseAspectj.checkcode65");
		if (checkcode(getArgs("authcode"))) {
			setCheckcode(true);
		} else {
			setCheckcode(false);
		}
		// System.out.println("BaseAspectj.checkcode72");
		return "success";

	}

	// 方便客服端调用检查,配置成action(客服端调用)
	public String checkname() {
		System.err.println("checkname");
		String result = ERROR;
		if (!this.useriflogin() && getArgs("username") != null) {// 若用户登录不允许调用次方法
			System.out.println("checkname开始执行");
			result = SUCCESS;
			if (this.check(getArgs("username"), "u")) {
				System.out.println("恭喜,该用户名可用!");
				this.setExitname(true);
			} else {
				System.out.println("用户名已存在!");
				this.setExitname(false);
			}
		}
		// else{
		// //若用户已经登录直接显示错误信息
		// this.setMessage("未定义操作!");
		// }
		return result;
	}

	// 方便客服端调用检查,配置成action(客服端调用)
	public String checkemail() {
		System.err.println("checkemail");
		String result = ERROR;
		if (!this.useriflogin() && getArgs("email") != null) {// 若用户登录不允许调用次方法
			System.out.println("checkemail开始执行");
			result = SUCCESS;
			if (this.check(getArgs("email"), "e")) {
				System.out.println("该邮箱可用");
				this.setExistemail(true);
			} else {
				System.out.println("该邮箱已被注册!");
				this.setExistemail(false);
			}
		}
		// else{//若用户已经登录直接显示错误信息
		// this.setMessage("未定义操作!");
		// }
		return result;

	}

	// 检验验证码方法 (服务端用)
	public boolean checkcode(String str) {
		// 从session中取出RandomAction.java 中生成的验证码random
		Object random = (ActionContext.getContext().getSession().get("random"));
		if (str == null || random == null) {
			System.out.println("输入的验证码="+str);
			System.out.println("取出的验证码="+random);
			return false;
		}
		if (str.equals(((String) random).toLowerCase())) {
			// System.out.println("127");
			return true;
		}
		return false;
	}

	// 检查用户名或邮箱是否已存在(服务端用) (关于方法重载后在struts.xml中的method的配置问题)
	// 第一个参数:email或者用户名字的字符串,第二个参数要查询类型(email,name)
	public boolean check(String... str) {
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
			System.out.println("已存在");
			return false;
		}
		System.out.println("可以使用");
		return true;

	}

	// str字符串,i用第几个正则表达式
	public boolean checkuserinfo(String str, int i) {
		if (i > 4) {
			System.err.println("超出索引");
			return false;
		}
		int mark = checkuserinfo(str, "" + i);
		if (mark == 1) {
			return true;
		}
		return false;

	}

	// 用户信息检查 这个方法待优化
	public int checkuserinfo(String... args) {
		int mark = 0;
		if (args.length == 2) {
			System.out.println("参数的长度为2");
			int temp = Integer.parseInt(args[1]);
			if (args[0].matches(getRegex()[temp])) {
				mark = mark + 1;
			}
		}
		if (args.length == 5) {
			System.out.println("参数的长度为5");
			for (int i = 0; i < args.length; i++) {
				if (args[i] == null) {
					return 0;
				}
				System.out.println("开始正则判断");
				if (args[i].matches(getRegex()[i])) {
					mark = mark + 1;
				}
			}
		}

		return mark;

	}

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	public StringBuffer getSkipstr() {
		System.out.println("BaseAspectj.getSkipstr=" + this.skipstr);
		return this.skipstr;
	}

	public void setSkipstr(StringBuffer skipstr) {
		this.skipstr = skipstr;
	}

	// 复写
	public void setSkipstr(String skipstr) {
		if (this.skipstr == null) {
			System.out.println("BaseAspectj.setSkipstr执行,skipstr=null开始初始化");
			this.skipstr = new StringBuffer(skipstr);
		} else if (skipstr != null && this.skipstr.length() > 0) {
			System.out.println("BaseAspectj.setSkipstr执行,skipstr不为空,开始赋值");
			this.skipstr = this.skipstr.replace(0, this.skipstr.length(), skipstr);
		}

	}

	public String[] getRegex() {
	
		return BaseAspectj.regex;
	}

	public void setRegex(String[] regex) {
		if (regex != null) {
			BaseAspectj.regex = regex;
		}
	}

	public boolean isCheckcode() {

		return checkcode;
	}

	public void setCheckcode(boolean checkcode) {
		this.checkcode = checkcode;
	}

	public String getAuthcode() {
		return authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	public boolean isExitname() {
		return exitname;
	}

	public void setExitname(boolean exitname) {
		this.exitname = exitname;
	}

	public boolean isExistemail() {
		return existemail;
	}

	public void setExistemail(boolean existemail) {
		this.existemail = existemail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
