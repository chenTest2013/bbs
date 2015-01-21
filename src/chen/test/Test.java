package chen.test;

import org.springframework.stereotype.Component;

import chen.myInterface.InjectProxy;

@Component("chentest")
public class Test implements InjectProxy{
	private InjectProxy proxy;

	public Test() {

	}

	public static void main(String[] args) {
		Test t = new Test();
		t.aa("我们");

	}

	public String aa(String str) {
		System.out.println("开始执行aa方法");
		System.out.println("打印aa参数=" + str);
		proxy.ab("aa中调用ab方法");
		System.out.println("aa方法执行结束");
		return str;

	}

	public String ab(String str) {
		System.out.println("开始执行ab方法");
		System.out.println("打印ab参数=" + str);
		System.out.println("ab方法执行结束");
		return str;

	}

	public Object getProxy() {
		return proxy;
	}

	public void setProxy(InjectProxy proxy) {
		this.proxy = proxy;
	}

	@Override//该方法由Bean后处理器执行
	public void setSelfProxy(InjectProxy obj) {
		this.setProxy(obj);
		
	}

}
