//用户信息类
//这个不是实体,作为组件
package chen.entity;

import java.io.Serializable;
import java.util.Date;

public class Information implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nickname;
	// 注册时间
	private Date regdate;
	// 最后一次登录时间
	private Date logindate;

	public Information() {
		this.regdate = new Date();
		this.logindate = new Date();
	}

	public Information(String nick) {
		this();
		this.nickname = nick;
		
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getRegdate() {

		return regdate;
	}

	public void setRegdate(Date regdate) {

		this.regdate = regdate;
	}

	public Date getLogindate() {
		return logindate;
	}

	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}

}
