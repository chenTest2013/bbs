//帖子类

package chen.entity;



import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import chen.util.FormatDate;


public class Topic implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
	 * 
	 */
	
private int id;
private String title;
private String content;
private Set<Comment> c=new HashSet<Comment>();//用户回复多少就有多少主题
private Date date;
private int view;//有多少人查看

private TopicState state;//0 普通      1 精华 2 置顶  3 4精华+置顶//一个帖子仅有一个状态
private User u;
private Board b;

public Topic() {
	this.view=0;
}
public int getId() {
	return id;
}
public String getTitle() {
	return title;
}
public String getContent() {
	return content;
}

public void setId(int id) {
	this.id = id;
}
public void setTitle(String title) {
	this.title = title;
}
public void setContent(String content) {
	this.content = content;
}



public TopicState getState() {
	
	return state;
}
public void setState(TopicState state) {
	
	
	this.state = state;
}
public User getU() {
	return u;
}
public void setU(User u) {
	this.u = u;
}
public Board getB() {
	return b;
}
public void setB(Board b) {
	this.b = b;
}
public Set<Comment> getC() {
	return c;
}
public void setC(Set<Comment> c) {
	this.c = c;
}

public int getView() {
	return view;
}
public void setView(int view) {
	this.view = view;
}
public Date getDate() {
	//FormatDate(this.date)用于将取出的时间格式化为yyyy-MM-dd
	return new FormatDate(this.date);
}
public void setDate(Date date) {
	
	this.date = date;
}
}
