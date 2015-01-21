package chen.action;

import java.io.ByteArrayInputStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chen.util.VerificationCodeUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Scope("request")
@Controller("veriaction")
public class RandomAction extends ActionSupport {
	
	private static final long serialVersionUID = -6498089070719713420L;
	private ByteArrayInputStream inputStream;

	public RandomAction() {
		System.out.println("验证码action实例生成!");
	}

	public String execute() throws Exception {
		VerificationCodeUtil rdnu = VerificationCodeUtil.Instance();
		this.setInputStream(rdnu.getImage());// 取得带有随机字符串的图片
		ActionContext.getContext().getSession().put("random", rdnu.getVerificationCodeValue());// 取得随机字符串放入HttpSession
		return SUCCESS;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
}
