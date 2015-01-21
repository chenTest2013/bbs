package chen.test;


public class Teststr {

	public static void main(String[] args) {
		String stregex = "(?=.*?[0-9])(?=.*?[A-Z])(?=.*?[a-z])[0-9A-Za-z!)-]{1,}";
		String reg = "^(?:([a-z])|([A-Z])|([0-9])|(.)){6,}|(.)+$";
		String sex="[男女保密]{1,2}";
		String str="[^_][\\w\u4e00-\u9fa5]{2,10}";
		String a="([A-Z]+)([0-9]+)|([0-9]+)([A-Z]+)";
		String emailregex = "([a-zA-Z0-9]{3,25}@([a-z]{2,25}|[0-9]{3,25}).com)";
		//System.out.println("123@123.com".matches(emailregex));
		//System.out.println(str.length());
		//System.out.println(a.length());
		
		//String emailregex="([a-zA-Z0-9]{3,25}@([a-z]{3,25}|[0-9]{3,25}).com)";
		//Pattern.compile("");
		//System.out.println(reg);
		//System.out.println(reg.length());
		//System.out.println(Pattern.matches("([a-zA-Z0-9\u4e00-\u9fa5]){3,8}", reg));
		//System.out.println(Pattern.matches("[\u4e00-\u9fa5]", "我"));
		//System.out.println(Pattern.matches(emailregex, "7664298222222222222225812345@163.com"));
		//System.out.println(reg.length());
		StringBuffer sb=new StringBuffer("tesa");
		sb.append("we");
		sb.replace(0, sb.length(), "hh");
		System.out.println(sb);
		
		
		
	}

}
