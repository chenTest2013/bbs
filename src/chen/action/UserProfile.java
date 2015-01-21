package chen.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chen.entity.User;
import chen.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//用户个人信息
@Scope("request")
@Controller("profileAction")
public class UserProfile extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name="uservice")
    private UserService us;
	
	
	
	public UserProfile() {
		System.out.println("profileAction实例生成"+this);
	}
	@Override
	public String execute() throws Exception {
		User u=(User)ActionContext.getContext().getSession().get("user");
		if(u!=null){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	public UserService getUs() {
		return us;
	}
	public void setUs(UserService us) {
		this.us = us;
	}
 
}
