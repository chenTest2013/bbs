//角色
package chen.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
	 * 
	 */
	
private int id;
private String name;
private Set<User> u=new HashSet<User>();

public Role() {
	
}
public Role(String str) {
	this.name=str;
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}

public void setId(int id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public Set<User> getU() {
	return u;
}
public void setU(Set<User> u) {
	this.u = u;
}



}
