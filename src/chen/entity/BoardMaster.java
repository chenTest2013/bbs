//版主

package chen.entity;

import java.util.HashSet;
import java.util.Set;



public class BoardMaster extends User {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Set<Board> boards=new HashSet<Board>();

public BoardMaster() {
	
}

public Set<Board> getBoards() {
	return boards;
}

public void setBoards(Set<Board> boards) {
	this.boards = boards;
}


}
