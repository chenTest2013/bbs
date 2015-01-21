package chen.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chen.entity.Board;
import chen.service.BoardService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("request")
@Controller("index")
public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8323989820215474962L;

	/*虽然此处注入的是BoardServiceImpl的实例,但是不能调用BoardServiceImpl
	中未实现BoardService接口中的方法*/
	@Resource(name = "boardser")
	private BoardService bs;// 注意此处是接口
	private List<Board> blist;
	private boolean userlogin;
	
	
	
	public IndexAction() {
		System.out.println("IndexAction实例化成功");
	}

	@Override
	public String execute() throws Exception {
		
		
		
		
		System.out.println("IndexAction.execute() 执行");
		
		this.useriflogin();// 判断用户是否已登陆,
		
		
		this.blist = this.bs.findAllBoard();
		//将版区列表加入session
		ActionContext.getContext().getSession().put("bolist", this.blist);
		
		
		return "index";

	}

	// 用户登录成功后跳转
	public String loginforward() {
		System.out.println("loginforward()方法执行");

		return "index";
	}

	public BoardService getBs() {
		return bs;
	}

	public void setBs(BoardService bs) {
		this.bs = bs;
	}

	public List<Board> getBlist() {
		return blist;
	}

	public void setBlist(List<Board> blist) {
		this.blist = blist;
	}

	// 判断用户是否登陆
	public boolean useriflogin() {

		Object obj = ActionContext.getContext().getSession().get("user");

		if (obj != null) {
			this.userlogin = true;
		} else {
			this.userlogin = false;
		}
		
		//System.out.println(ServletActionContext.getRequest().getLocalName());
		ActionContext.getContext().getSession().put("userstate", this.userlogin);// 将用户登陆状态存在session中
		return userlogin;

	}

	public boolean isUserlogin() {

		return userlogin;
	}

	public void setUserlogin(boolean userlogin) {

		this.userlogin = userlogin;
	}

}
