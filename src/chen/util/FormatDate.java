package chen.util;

//该类用来用来格式化当前时间成YYYY-mm-dd形式
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate extends Date {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8413915338376597299L;
	private SimpleDateFormat tempDate;
	private String str;

	public FormatDate() {
		this(null);
	}

	public FormatDate(Date date) {
		if (date == null) {
			date = new Date();
		}
		this.tempDate = new SimpleDateFormat("yyyy-MM-dd");
		this.str = tempDate.format(date);
	}

	@Override
	public String toString() {
		return getStr();
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
