package chen.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * @author john
 * 
 * 评论类
 *
 */
public class Comment implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**
	 * 
	 */
	

private int id ;

private User user;
private String content;
private Topic t;
private Date date;

public Comment() {
	this.date=new Date();
}
public int getId() {
	return id;
}

public String getContent() {
	return content;
}
public void setId(int id) {
	this.id = id;
}


public void setContent(String content) {
	this.content = content;
}

public Topic getT() {
	return t;
}
public void setT(Topic t) {
	this.t = t;
}

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

}
