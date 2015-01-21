package chen.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import chen.util.FormatDate;


public class TestDate {

	public static void main(String[] args) {
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		Date d=new Date();
		String regiesterTime = tempDate.format(d);
		System.out.println(System.getProperty("user.timezone"));
		System.out.println(regiesterTime);
		
		System.out.println(new FormatDate());
		
		
	}

}
