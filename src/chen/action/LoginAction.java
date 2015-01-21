package chen.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chen.entity.User;
import chen.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("request")
@Controller("loginaction")
// 指定该bena的名字是userlogin(Strust2中的class要与此名字相同)
public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	@Resource(name = "uservice")//将Spring中对象名字叫uservice赋值给this.userservice
	private UserService userservice;
	private String authcode;

	public LoginAction() {
		System.out.println("LoginAction实例创建成功");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		System.out.println("LoginAction.class参数username开始被赋值");
		this.username = username.trim();
	}

	public String getPassword() {
		return password.trim();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		if (this.username == null && this.password == null) {
			return "login";
		}	
		User u = this.userservice.findUserByName(this.getUsername());

		if (u != null) {
			if (u.getPass().equals(password)) {
				ActionContext.getContext().getSession().put("user", u);
				ActionContext.getContext().getSession().put("userstate",true);
				//将该用户的信息加在session中
				//ActionContext.getContext().getSession().put("uinfo", u.getInfo());
			
				return SUCCESS;
			}
		}
		return ERROR;
	}

	// 用户登录成功后跳转
	public String loginforward() {
		System.out.println("loginforward()方法执行");
		String str = ServletActionContext.getRequest().getRequestURI();
		System.out.println("getRequestURI" + str);
		System.out.println(ServletActionContext.getRequest().getPathInfo());
		return "index";
	}

	// 退出
	public String loginOut() {
		ActionContext.getContext().getSession().remove("user");
		ActionContext.getContext().getSession().put("userstate",false);
		return "out";

	}

	public UserService getUserservice() {
		return userservice;
	}

	
	public void setUserservice(UserService userservice) {
		System.out.println("开始将uservice注入到LoginAction.class");
		this.userservice = userservice;
	}

	public String getAuthcode() {
		return authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	

}
