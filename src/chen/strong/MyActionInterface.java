package chen.strong;

import com.opensymphony.xwork2.Action;

//此接口增加action的常量字符串,为了return用
public interface MyActionInterface extends Action{
	public static final String REGISTER = "register";
	public static final String INDEX = "index";
	
}
