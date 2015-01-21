package chen.test;

import org.springframework.stereotype.Component;

@Component("chentest")
public class Test {

	public static void main(String[] args) {
		Test t=new Test();
		t.a("我们");

	}
	public String a(String str){
		this.b("b方法");
		System.out.println(str);
		return str;
		
	}
	public String b(String str){
		System.out.println(str);
		return str;
		
	}
}
