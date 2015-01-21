package chen.strong;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import chen.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//@Aspect
// 增强类的一些基本操作
@Component
public class BaseAspectj extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name = "uservice")
	private UserService us;
	private String message;
	private StringBuffer skipstr;// 跳转标示字符串

	// 获取请求的参数
	public String getRargs(String str){
		Map<String,String[]> map=ServletActionContext.getRequest().getParameterMap();
		String[] value=map.get(str);
		if(value!=null){
			return value[0];
		}
		return null;
		
	}
	
	// 获取请求的参数
	public String getArgs(String str){
		String value=ServletActionContext.getRequest().getParameter(str);
		return value;
		
	}
	
	
	
	// 获取所有请求参数 这个方法有问题
	public String getaRArgs(String str) {
		System.out.println("getaRArgs29");
		ActionContext actionContext = ServletActionContext.getContext();
		
		//ServletActionContext.getContext().get
		System.out.println("getaRArgs31");
		Map<String, Object> map = actionContext.getParameters();
		
		System.out.println("getaRArgs33");
		Set<Entry<String,Object>> entries = map.entrySet();
		 if(entries != null){
			 Iterator<Entry<String, Object>> iterator =entries.iterator();
			 while(iterator.hasNext()){
				Entry<String, Object> entry =iterator.next();
				
				System.out.println(entry.getKey()+"="+entry.getValue());
			 }
		 }
		System.out.println("getaRArgs35");
		return (String) map.get(str);

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

	// 用户信息检查
	public int checkuserinfo(String... args) {
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
			System.out.println("checkreginfo username:" + args[0]);
			mark = mark + 1;
		}

		if (args[1] != null && args[1].matches(emailregex)) {
			System.out.println("checkreginfo email:" + args[1]);
			mark = mark + 1;
		}

		if (args[2] != null && args[2].equals(args[3]) && args[2].matches(pwdregex)) {
			System.out.println("checkreginfo pwd:" + args[2]);
			mark = mark + 1;
		}
		if (args[4] != null && args[4].matches(sexregex)) {
			System.out.println("checkreginfo sex:" + args[4]);
			mark = mark + 1;
		}
		if (args[5] != null && args[5].matches(coderegex)) {
			System.out.println("checkreginfo authcode:" + args[5]);
			mark = mark + 1;
		}
		return mark;

	}

	// 检查用户名或邮箱是否已存在(服务端调用) (关于方法重载后在struts.xml中的method的配置问题)
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
			// System.out.println("已存在");
			this.setMessage("已存在此项");
			this.setSkipstr(ERROR);
			return false;
		}
		// System.out.println("可以使用");
		return true;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	public StringBuffer getSkipstr() {
		return skipstr;
	}

	public void setSkipstr(StringBuffer skipstr) {
		this.skipstr = skipstr;
	}

	// 复写
	public void setSkipstr(String skipstr) {
		if (this.skipstr == null) {
			this.skipstr = new StringBuffer(skipstr);
		} else if (skipstr != null && this.skipstr.length() > 0) {
			this.skipstr = this.skipstr.replace(0, this.skipstr.length(), skipstr);
		}

	}


}
