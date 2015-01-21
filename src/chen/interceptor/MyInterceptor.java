package chen.interceptor;

import chen.action.RegAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String excludeActionName;//剔除的拦截方法
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("拦截器开始工作");
		
		//System.out.println("invocation.invoke()="+invocation.invoke());
		
		System.out.println("invocation.getAction().class="+invocation.getAction().getClass());
		
		System.out.println("invocation.getProxy().class="+invocation.getProxy().getClass());
		
		System.out.println("invocation.getProxy().getActionName()="+invocation.getProxy().getActionName());
		
		//System.out.println("invocation.getResult().class="+invocation.getResult().getClass());
		
		//System.out.println("invocation.getResultCode()="+invocation.getResultCode());
		
		System.out.println(invocation.getAction() instanceof RegAction );
		
		RegAction r=(RegAction)invocation.getAction();
		//invocation.getAction().
		System.err.println("执行action");
		invocation.invoke();//执行action
		//r.addActionMessage("拦截器中设置");
		
		//r.e
		//r.setMessage("拦截器中设置message");
		
		
		return "index";
	}

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getExcludeActionName() {
		return excludeActionName;
	}

	public void setExcludeActionName(String excludeActionName) {
		this.excludeActionName = excludeActionName;
	}

//	@Override
//	public void setExcludeMethods(String excludeMethods) {
//		// TODO Auto-generated method stub
//		super.setExcludeMethods(excludeMethods);
//	}
//
//	@Override
//	public Set<String> getExcludeMethodsSet() {
//		// TODO Auto-generated method stub
//		return super.getExcludeMethodsSet();
//	}
//
//	@Override
//	public void setIncludeMethods(String includeMethods) {
//		// TODO Auto-generated method stub
//		super.setIncludeMethods(includeMethods);
//	}
//
//	@Override
//	public Set<String> getIncludeMethodsSet() {
//		// TODO Auto-generated method stub
//		return super.getIncludeMethodsSet();
//	}

}
