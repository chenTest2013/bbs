package chen.test;

public class Testforreturn {

	public static void main(String[] args) {
		String s1=null,s2=null,s3=null;
		args=new String[]{s1,s2,s3};
		Testforreturn t=new Testforreturn();
		System.out.println(t.a(args));

	}
	
	public int a(String[] args ){
		System.out.println("开始");
		if (args.length == 3) {
			System.out.println("参数的长度为3");
			for (int i = 0; i < args.length; i++) {
				if(args[i]==null){
					return 3;
				}
			}
			System.out.println("for循环已结束");
		}
		System.out.println("if判断已结束");
		return 0;
	}

}
