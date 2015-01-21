package chen.action;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import chen.util.VerificationCodeUtil;
@Scope("request")
@Controller("veriaction")
public class RandomAction extends Baseaction implements DisposableBean{
	
	private static final long serialVersionUID = -6498089070719713420L;
	private ByteArrayInputStream inputStream;
    private long d;
	public RandomAction() {
		System.out.println("验证码action实例生成!");
	}

	public String execute() throws Exception {
	
//		System.out.println("path="+ServletActionContext.getRequest().getContextPath());
//		System.out.println("getRemoteUser= "+ServletActionContext.getRequest().getRemoteUser());
//		System.out.println("getPathInfo= "+ServletActionContext.getRequest().getPathInfo());
//		System.out.println("getPathTranslated= "+ServletActionContext.getRequest().getPathTranslated());
//		System.out.println("getRequestURI= "+ServletActionContext.getRequest().getRequestURI());
//		System.out.println("getServerName="+ServletActionContext.getRequest().getServerName());
//		System.out.println("getServletPath="+ServletActionContext.getRequest().getServletPath());
//		System.out.println("getRemoteAddr="+ServletActionContext.getRequest().getRemoteAddr());
		VerificationCodeUtil rdnu = VerificationCodeUtil.Instance();
		this.setInputStream(rdnu.getImage());// 取得带有随机字符串的图片
		ActionContext.getContext().getSession().put("random", rdnu.getVerificationCodeValue());
		//System.out.println("ActionContext.getContext().get()="+ActionContext.getContext().get("random"));
		return SUCCESS;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public long getD() {
		return d;
	}

	public void setD(long d) {
		this.d = d;
	}

	@Override//设置验证码访问状态,暂时不用
	public void destroy() throws Exception {
		//setCodemark(false);
		
	}
}
