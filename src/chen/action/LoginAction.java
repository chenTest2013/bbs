package chen.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chen.entity.User;
import chen.service.UserService;

import com.opensymphony.xwork2.ActionContext;

@Scope("request")
@Controller("loginaction")
// 指定该bean的名字是userlogin(Strust2中的class要与此名字相同)
public class LoginAction extends Baseaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String authcode;
	private String remember;
	@Resource(name = "uservice")
	// 将Spring中对象名字叫uservice赋值给this.userservice
	private UserService userservice;

	public LoginAction() {
		System.out.println("LoginAction实例创建成功");
	}


	@Override
	public String execute() throws Exception {
		System.out.println("LoginAction.execute()执行");
		User u = this.userservice.findUserByName(this.getUsername());
		if (u != null) {
			if (u.getPass().equals(this.password)) {
				if (checkcode(this.authcode)) { //checkcode(this.authcode)
					ActionContext.getContext().getSession().put("user", u);
					ActionContext.getContext().getSession().put("userstate", true);
					//Cookie c=new Cookie("rember", authcode);
					//c.setMaxAge(86400);
					//ServletActionContext.getResponse().addCookie(c);
					// 将该用户的信息加在session中
					ActionContext.getContext().getSession().put("uinfo", u.getInfo());
					System.out.println("getMethod="+ServletActionContext.getRequest().getMethod());
					return SUCCESS;
				} else {	
					addActionError("验证码错误!");
					return ERROR;
				}
			}
		}
		
		addActionError("用户名或密码错误!");// 不管用户为空还是密码错误都显示这个，这个方法是在jsp页面显示错误信息
		return ERROR;
	}
	
	
	
	
	
	// 检验验证码方法 (服务端用)
	public boolean checkcode(String str) {
		System.out.println("输入验证码="+this.authcode);
		// 从session中取出RandomAction.java 中生成的验证码random
		Object random = (ActionContext.getContext().getSession().get("random"));
		
		if (str==null||random == null) {
			System.err.println("输入的验证码="+str);
			System.err.println("session中的验证码="+random);
			return false;
		}
		// 下面就是将session中保存验证码字符串与客户输入的验证码字符串对比了
		if (str.equals(((String) random).toLowerCase())) {
			// System.out.println("127");
			return true;

		} else {
			return false;
		}
	}

	

	// 退出
	public String loginOut() {
		System.out.println("loginOut开始执行");
		ActionContext.getContext().getSession().remove("user");
		ActionContext.getContext().getSession().put("userstate", false);
		return INDEX;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		//System.out.println("LoginAction.class参数username开始被赋值");
		this.username = username.trim();
	}

	public String getPassword() {
		return password.trim();
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		//System.out.println("开始将uservice注入到LoginAction.class");
		this.userservice = userservice;
	}

	public String getAuthcode() {
		return authcode.toLowerCase();
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	public String getRemember() {
		return remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}

}
