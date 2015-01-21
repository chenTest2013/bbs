package chen.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private int id;
	private String name;
	private String pass;
	private int grade;//等级,1 2 3 4 5 
	private int state;//1用户仅可登陆，不能发布帖子，0用户可正常操作。相当于刚注册没激活.
	private int point;//分数
	private String sex;
	private String email;
	private Role role;//角色,一系列权限的集合,MangerType是他的子类.(to do),一个用户只有一个角色
	private Information info;//用户信息类(组件)
	private Set<Comment> scomm=new HashSet<Comment>();
	private Set<Topic> stop=new HashSet<Topic>();
	
	
	public User() {
		
	}
public User(String name) {
		this.name=name;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
	public int getGrade() {
		return grade;
	}
	public int getState() {
		return state;
	}
	public String getSex() {
		return sex;
	}
	public String getEmail() {
		return email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public Set<Comment> getScomm() {
		return scomm;
	}
	public void setScomm(Set<Comment> scomm) {
		this.scomm = scomm;
	}
	public Set<Topic> getStop() {
		return stop;
	}
	public void setStop(Set<Topic> stop) {
		this.stop = stop;
	}
	public Information getInfo() {
		return info;
	}
	public void setInfo(Information info) {
		this.info = info;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
