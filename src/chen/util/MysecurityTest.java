package chen.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MysecurityTest {
	private static String[] HEX = { "A", "B", "C", "D", "E", "F" };

	public static void main(String[] args) throws Exception {
		String myinfo = "我的测试信息";
		byte[] m = myinfo.getBytes();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");

			System.err.println("myinfo.getBytes().length=" + myinfo.getBytes().length);
			// System.out.println("myinfo.hashCode()="+myinfo.hashCode());

			for (int i = 0; i < m.length; i++) {
				System.out.println("m[" + i + "]=" + m[i]);
			}
			messageDigest.update(myinfo.getBytes("unicode"));

			byte[] digesta = messageDigest.digest();

			System.err.println("digesta.length=" + digesta.length);
			for (byte b : digesta) {
				System.out.println("digesta=" + b);
			}
			String str = new String(digesta);
			System.out.println("str=" + str);
			byte[] b = { -115 };
			System.out.println("本信息摘要是byte2hex:" + byte2hex(digesta));


			System.out.println("本信息摘要是toHexString:" + toHexString(digesta));

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String temp = new String(m, "UTF-8");

			System.out.println("temp=" + temp);

			System.err.println("temp.getBytes().length=" + temp.getBytes("unicode").length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.getProperties().list(System.out);

		// String test = URLEncoder.encode("我的测试信息", "UTF-8");

		// System.out.println("test="+test);

		// System.out.println(URLDecoder.decode(test,"UTF-8"));
	}

	public static String byte2hex(byte[] b) // 字节转16进制
	{
		System.err.println("字节的长度=" + b.length);
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			//System.out.println(stmp);
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			if (n < b.length - 1)
				// hs=hs+":"
				hs = hs + " ";
		}
		return hs.toUpperCase();
	}

	public static String toHexString(String s) // 将字符串转换为16进制
	{
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str.toUpperCase();
	}

	public static String toHexString(byte[] by) // 将字节转换为16进制
	{
		StringBuffer str = new StringBuffer();
		String temp = "";
		for (int i = 0; i < by.length; i++) {
			int a=  by[i] / 16;
			int b = by[i] % 16;
			String stra=inttoString(a);
			String strb=inttoString(b);
			temp=temp+stra+strb;
			
           System.out.println("a="+a);

			//str = str.append(a);
		}
		System.err.println("16进制="+temp);
		//System.err.println("16进制="+str);
		return temp;
	}
	public static String inttoString(int i){
		String str="";
		if(i<10){
			return i+"";
		}
		switch (i) {
		case 10:
            str=HEX[0];
			break;
		case 11:
			str=HEX[1];
			break;
		case 12:
			str=HEX[2];
			break;
		case 13:
			str=HEX[3];
			break;
		case 14:
			str=HEX[4];
			break;
		case 15:
			str=HEX[5];
			break;
		default:
			
			break;
		}
		return str;
		
	}

}
