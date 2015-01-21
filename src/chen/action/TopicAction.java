package chen.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chen.entity.Board;
import chen.entity.Topic;
import chen.entity.User;
import chen.service.BoardService;
import chen.service.TopicService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Scope("request")
@Controller("topicaction")
public class TopicAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name="topicser")
	private TopicService ts;
	private List<Topic> blist;//根据版区ID查询的帖子
	private List<Topic> ulist;//根据用户ID查询的帖子
    private int bid;//版区ID
    private int tid;
    @Resource(name="boardser")
    private BoardService bs;
	public TopicAction() {
		System.out.println("TopicAction 实例生成");
	}

	@Override
	public String execute() throws Exception {
		
		this.blist=this.ts.findTopicPart(null, 1, 5);//分页查询
		ActionContext.getContext().getSession().put("tlist",this.blist);
		System.out.println("分页查询topic成功");
		return super.execute();
	}
    //根据版区ID分页查找帖子
	public String findTopicListByBoardId(){
		Board b=this.bs.findBoardById(this.bid);
		ActionContext.getContext().getSession().put("b",b);
		this.blist=this.ts.findTopicPartByBoardId(this.bid,null, 1, 3);
		//这个也可以Set<Topic> list=b.getStopic();之所以不用这个是因为这个得到是该版区的所有帖子,当帖子数非常多这不是一个好的方法
		ActionContext.getContext().getSession().put("blist",blist);
		System.out.println("根据版区ID分页查询topic成功");
		return SUCCESS;
		
	}
	//根据用户Id查找帖子
	public String findTopicByUid(){
		
		User u=(User)ActionContext.getContext().getSession().get("user");
		
		if(u!=null){				
			//System.err.println("findTByUserId用户测试"+u.getId());
			this.ulist=this.ts.findTopicPartByUserId(u.getId(),null, 1, 3);
			if(this.ulist!=null){
				ActionContext.getContext().getSession().put("ulist",this.ulist);
				System.out.println("根据用户id分页查询topic成功");
			}
			
		  return SUCCESS;
		}
		return ERROR;
		
		
		
	}
	
	public String singletopic(){
		
		ActionContext.getContext().getSession().put("t",this.ts.findTopicById(this.tid));
		System.out.println("根据id查询topic成功");
		
		//this.t=this.ts.findTopicById(this.tid);
		//将t加入session
		
		//将此话题的user加入session
		//ActionContext.getContext().getSession().put("u",this.t.getU());
		//将此话题的评论加入session
		//ActionContext.getContext().getSession().put("c",this.t.getC());
	
		
		
		return "singletopic";
	}
	
	
	public TopicService getTs() {
		return ts;
	}

	public void setTs(TopicService ts) {
		this.ts = ts;
	}

	public List<Topic> getTlist() {
		return blist;
	}

	public void setTlist(List<Topic> tlist) {
		this.blist = tlist;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public BoardService getBs() {
		return bs;
	}

	public void setBs(BoardService bs) {
		this.bs = bs;
	}

	public List<Topic> getUlist() {
		return ulist;
	}

	public void setUlist(List<Topic> ulist) {
		this.ulist = ulist;
	}

}
