package chen.action;

import javax.annotation.Resource;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chen.entity.Board;
import chen.service.BoardService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Scope("request")
@Controller("boardaction")
public class BoardAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5579601592552105632L;
	@Resource(name="boardser")
    private BoardService bs;
    private List<Board> blist;
    
    
    
    
    
	public BoardAction() {
		System.out.println("BoardAction 实例创建成功");
	}

	@Override
	public String execute() throws Exception {
		this.blist=this.bs.findAllBoard();
		ActionContext.getContext().getSession().put("blist", this.blist);
	
		System.out.println("BoardAction 板块列表加载成功");
		return super.execute();
	}
	
	public List<Board> getBlist() {
		return blist;
	}
	public void setBlist(List<Board> blist) {
		this.blist = blist;
	}

	public BoardService getBs() {
		return bs;
	}

	public void setBs(BoardService bs) {
		this.bs = bs;
	}
	

}
