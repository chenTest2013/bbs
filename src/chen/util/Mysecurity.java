package chen.util;

import java.security.MessageDigest;

public class Mysecurity {

	public static void main(String[] args) throws Exception {
		Mysecurity m = new Mysecurity();

		String myinfo = "我的测试信息";

		MessageDigest messageDigest = MessageDigest.getInstance("MD5");

		messageDigest.update(myinfo.getBytes());

		
		
		byte[] digesta = messageDigest.digest();

		System.out.println("本信息摘要是byteTohex:" + m.byteTohex(digesta));

	}

	public String byteTohex(byte[] b) // 字节转16进制
	{
		// System.err.println("字节的长度=" + b.length);
		StringBuffer str = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			// System.out.println(stmp);
			if (stmp.length() == 1)
				str = str.append("0").append(stmp);
			else
				str = str.append(stmp);
		}
		return str.toString().toUpperCase();
	}

	public String stringToHex(String s) // 将字符串转换为16进制
	{
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str.append(s4);
		}
		return str.toString().toUpperCase();
	}

}
