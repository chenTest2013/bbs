//权限类，某个用户访问某个版区的权限，回复某个帖子的权限
package chen.entity;

import java.io.Serializable;

public class Authority implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private Board board;
	private Topic topic;
	private User u;
	private int user_boardstate;// 0 可访问,版区访问权限
	private int user_topicstate;// 0 可回复,帖子访问权限
  
	public Authority() {

	}

	public Authority(Board bid, Topic tid, int bstate, int tstate) {
		
		this.board = bid;
		this.topic = tid;
		this.setUser_boardstate(bstate);//这两个顺序不能换
		this.setUser_topicstate(tstate);
	}

	



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_boardstate() {
		return user_boardstate;
	}

	public int getUser_topicstate() {
		return user_topicstate;
	}

	
	public void setUser_boardstate(int user_boardstate) {
		this.user_boardstate = user_boardstate;
	}

	public void setUser_topicstate(int user_topicstate) {
		boolean exist=getTopic().getB().getId()==getBoard().getId();//判断当前帖子是否在当前版区内，
		boolean access=getUser_boardstate()==1;//判断用户访问当前的版区的权限
			if(exist&&access){
				this.user_topicstate=1;
					System.out.println("设置帖子访问权限无效,用户对当前版区无访问权,且帖子在当前版区内");
				
			}
			else {//其他情况,user_topicstate才生效
				this.user_topicstate = user_topicstate;
			}
		}
		

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}


}
