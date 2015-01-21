package chen.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chen.entity.Information;
import chen.entity.Role;
import chen.entity.User;
import chen.service.RoleService;
import chen.service.UserService;

import com.opensymphony.xwork2.ActionContext;

@Scope("request")
@Controller("userreg")
public class RegAction extends Baseaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private String message;
	private String username;
	private String pwd;
	private String pwd2;
	private String email;
	private String authcode;
	private String sex;
	@Resource(name = "uservice")
	private UserService us;
	@Resource(name = "roleser")
	private RoleService rs;

	public RegAction() {
		System.out.println("RegAction实例创建成功" + this);
	}

	@Override
	public String execute() throws Exception {
		System.out.println("execute开始执行");
		return SUCCESS;

	}

	// 此方法是注册
	public String userRegistr() throws Exception {
		// 这个方法为什么不能增强处理,好像是因为这个方法在execute方法里面调用,
		// 增强了execute方法后,无法增强方法里面调用的其他方法了.(已解决)

		// System.err.println("this.username:" + this.username);
		// System.out.println("email:" + this.email);
		// System.out.println("pwd:" + this.pwd);
		// System.err.println("pwd2:" + this.pwd2);
		// System.out.println("sex:" + this.sex);
		// System.out.println("authcode:" + this.authcode);

		System.out.println("userRegistr开始执行");
		User u = new User(this.username);
		Role r = rs.findById(5);
		if (r != null) {
			u.setRole(r);
		}

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

	// @Before
	// public void a(){
	// System.out.println("Before action");
	//
	//
	// }

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

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public RoleService getRs() {
		return rs;
	}

	public void setRs(RoleService rs) {
		this.rs = rs;
	}

	// public void setRequest(HttpServletRequest request) {
	// this.request = request;
	// }

}
