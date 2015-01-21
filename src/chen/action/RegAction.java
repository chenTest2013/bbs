package chen.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chen.entity.Information;
import chen.entity.User;
import chen.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("request")
@Controller("userreg")
public class RegAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private StringBuffer skipstr;// 跳转标示
	private String username;
	private String pwd;
	private String pwd2;
	private String email;
	private String authcode;
	private String sex;
	@Resource(name = "uservice")
	private UserService us;
	private boolean resstr;// 这个用来验证用户名是否存在的标志
	private boolean existemail;// 这个用来标示email是否存在
	private boolean checkcode;// 这个用来检验code是否正确

	public RegAction() {
		System.out.println("RegAction实例创建成功" + this);
	}

	@Override
	public String execute() throws Exception {

		// System.err.println("this.username:" + this.username);
		// System.err.println("this.getUsername:" + this.getUsername());
		// System.out.println("email:" + this.email);
		// System.out.println("pwd:" + this.pwd);
		// System.out.println("sex:" + this.sex);
		this.setSkipstr(SUCCESS);// 初始值
		// this.checkReg() 注意要放在前面
		if (checkReg() && checkcode(authcode) && check(username, "u") && check(email, "e")) {
			return this.userRegistr();
		} else {
			return this.skipstr.toString();
		}

	}

	// 此方法是注册
	private String userRegistr(String...args) throws Exception {
		//这个方法为什么不能增强处理,好像是因为这个方法在execute方法里面调用,
		//增强了execute方法后,无法增强方法里面调用的其他方法了.

		// System.err.println("this.username:" + this.username);
		// System.err.println("this.getUsername:" + this.getUsername());
		// System.out.println("email:" + this.email);
		// System.out.println("pwd:" + this.pwd);
		// System.out.println("sex:" + this.sex);

		User u = new User(this.username);
		u.setEmail(this.email);
		u.setName(this.username);
		u.setPass(this.pwd);
		u.setSex(this.sex);
		Information info = new Information(this.username);
		u.setInfo(info);
		try {
			us.saveUser(u);

			ActionContext.getContext().getSession().put("userstate", true);
			ActionContext.getContext().getSession().put("user", u);
			// 用户信息类加入session
			ActionContext.getContext().getSession().put("uinfo", u.getInfo());
		} catch (Exception e) {
			e.printStackTrace();

		}

		return SUCCESS;

	}

	// 检查输入的注册信息是否合法,正则匹配
	private int checkreginfo() {
		
		return this.checkreginfo(username,email,pwd,pwd2,sex,authcode);

	}

	private int checkreginfo(String... args) {
		int mark = 0;
		// 由数字字母下划线汉字组成的名字,首字符不是下划线,且范围长度在3-8,包括边界
		// 注意这个{2,8},因为这个占一位置[^_]
		String nameregex = "[^_][\\w\u4e00-\u9fa5]{2,8}";
		// email验证@后面要么是数字要么是是字母
		String emailregex = "([a-zA-Z0-9]{3,25}@([a-z]{2,25}|[0-9]{3,25}).com)";
		// 密码验证
		String pwdregex = "[\\w]{6,15}";
		// 4个汉字中的一个或者两个(男,女,保密)
		String sexregex = "[男女保密]{1,2}";

		String coderegex = "[a-zA-Z0-9]{1,4}";

		if (args[0] != null && args[0].matches(nameregex)) {
			System.out.println("checkreginfo username:" + username);
			mark = mark + 1;
		}

		if (args[1] != null && args[1].matches(emailregex)) {
			System.out.println("checkreginfo email:" + email);
			mark = mark + 1;
		}

		if (args[2] != null && args[2].equals(args[3]) && args[2].matches(pwdregex)) {
			System.out.println("checkreginfo pwd:" + pwd);
			mark = mark + 1;
		}
		if (args[4] != null && args[4].matches(sexregex)) {
			System.out.println("checkreginfo sex:" + sex);
			mark = mark + 1;
		}
		if (args[5] != null && args[5].matches(coderegex)) {
			System.out.println("checkreginfo authcode:" + authcode);
			mark = mark + 1;
		}
		return mark;

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
			System.out.println("132master?");
			this.setSkipstr(ERROR);
			return false;
		}
	}

	//  注册前用户状态检查
	private boolean checkReg() {//只考虑非正常流程
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
				ActionContext.getContext().getSession().put("message", this.message);

				System.out.println("169");

				


			} else {
				// 当用户登录,访问注册action时跳转到主页(防止用户在登陆时打开注册页面)
				this.setSkipstr("index");

			}
			return false;
		}
		return true;

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
			this.setSkipstr(ERROR);
			return false;
		}
		// System.out.println("可以使用");
		return true;

	}

	// 方便客服端调用检查,配置成action(客服端调用)
	public String checkname() {
		System.err.println("checkname");
		String result = ERROR;
		if (!this.useriflogin()&&this.username != null) {//若用户登录不允许调用次方法
			System.out.println("checkname开始执行");
			result = SUCCESS;
			if (this.check(this.username, "u")) {
				System.out.println("恭喜,该用户名可用!");
				this.setResstr(true);
			} else {
				this.setMessage("用户名已存在!");
				this.setResstr(false);
				System.out.println("用户名已存在!");
			}
		}else{
			this.setMessage("未定义操作!");
			ActionContext.getContext().getSession().put("message", this.message);
		}
		return result;
	}

	// 方便客服端调用检查,配置成action(客服端调用)
	public String checkemail() {
		System.err.println("checkemail");
		String result = ERROR;
		if (!this.useriflogin()&&this.email != null) {//若用户登录不允许调用次方法
			System.out.println("checkemail开始执行");
			result = SUCCESS;
			if (this.check(this.email, "e")) {
				this.setExistemail(true);
			} else {
				System.out.println("该邮箱已被注册!");
				this.setMessage("该邮箱已被注册!");
				this.setExistemail(false);

			}

		}
		else{
			this.setMessage("未定义操作!");
			ActionContext.getContext().getSession().put("message", this.message);
		}
		return result;

	}

	// 客服端调用
	public String checkcode() {
		System.err.println("checkcode");
//		if(this.authcode == null){
//			return null;
//		}
		if (checkcode(this.authcode)) {
			this.checkcode = true;
		} else {
			this.checkcode = false;
		}
		return SUCCESS;
	}

	// 检查用户登录状态
	public boolean useriflogin() {
		Object obj = ActionContext.getContext().getSession().get("user");
		if (obj != null) {
			ActionContext.getContext().getSession().put("userstate", true);
			return true;
		}
		return false;
	}

	// 能不能将这个方法配置成action
	// public boolean test(){
	// System.out.println("it just a test");
	// return true;
	//
	// }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		System.out.println("username开始赋值");
		this.username = username.trim();
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim();
	}

	public String getAuthcode() {
		return authcode;
	}

	// 不区分大小写
	public void setAuthcode(String authcode) {
		this.authcode = authcode.trim().toLowerCase();
	}

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex.trim();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StringBuffer getSkipstr() {

		return skipstr;
	}

	public void setSkipstr(StringBuffer skipstr) {
		this.skipstr = skipstr;
	}

	// 复写
	public void setSkipstr(String skipstr) {
		if(this.skipstr==null){
			this.skipstr=new StringBuffer(skipstr);
		}
		else if(skipstr!=null&&this.skipstr.length()>0){
			this.skipstr = this.skipstr.replace(0, this.skipstr.length(), skipstr);
		}
		
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

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	// public void setRequest(HttpServletRequest request) {
	// this.request = request;
	// }
	
	public String allargs(String... args){
		
		return SUCCESS;
		
	}

}
