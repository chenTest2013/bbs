//版区类
package chen.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Board implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id;
private String name;
private BoardMaster bm;//版主
private Set<Topic> stopic=new HashSet<Topic>();
public Board() {
	
}
public Board(String name) {
	this.name=name;
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
public BoardMaster getBm() {
	return bm;
}
public void setBm(BoardMaster bm) {
	this.bm = bm;
}
public Set<Topic> getStopic() {
	
	return stopic;
}
public void setStopic(Set<Topic> stopic) {
	this.stopic = stopic;
}



}
