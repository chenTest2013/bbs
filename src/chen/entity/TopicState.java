//帖子状态 //一个帖子仅有一个状态
package chen.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TopicState implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
	 * 
	 */
	
private int id;
private Set<Topic> stopic=new HashSet<Topic>();
private String name;
public TopicState() {
	
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
public Set<Topic> getStopic() {
	return stopic;
}
public void setStopic(Set<Topic> stopic) {
	//if(){
		
//	}
	this.stopic = stopic;
}


}
