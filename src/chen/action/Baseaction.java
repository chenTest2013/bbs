package chen.action;
import chen.strong.MyActionInterface;

/*
1.所有action都用到的东西放在这
2.此处的属性其他所有action(是这个类的子类)也可以共用
*/
import com.opensymphony.xwork2.ActionSupport;


public class Baseaction extends ActionSupport implements MyActionInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String message;
    private static boolean codemark;//这个控制验证码action能否执行的标志，只有打开了主页（indexaction执行）或者
    //打开注册页面（regaction执行）的情况下才能执行，防止验证码被恶意点击！
    
	public String getMessage() {
		System.out.println("有人取用message");
		return message;
	}
	public void setMessage(String message) {
		System.out.println("有人设置message="+message);
		this.message = message;
		
	}
	public boolean isCodemark() {
		return Baseaction.codemark;
	}
	public void setCodemark(boolean codemark) {
		Baseaction.codemark = codemark;
	}
}
