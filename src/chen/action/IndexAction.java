package chen.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import chen.service.BoardService;

import com.opensymphony.xwork2.ActionContext;

@Scope("request")
@Controller("index")
public class IndexAction extends Baseaction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*虽然此处注入的是BoardServiceImpl的实例,但是不能调用BoardServiceImpl
	中未实现BoardService接口中的方法*/
	@Resource(name = "boardser")
	private BoardService bs;// 注意此处是接口
	
	public IndexAction() {
		System.out.println("IndexAction实例化成功");
	}

	@Override
	public String execute() throws Exception {

		System.out.println("IndexAction.execute() 执行");
		
		//this.blist = this.bs.findAllBoard();
		//将bolist加在ActionContext对象中,在jsp页面可用${bolist}，${request.bolist}，${requestScope.bolist}
		//<s:iterator value="bolist" var="board" status="st" />访问
		ActionContext.getContext().put("bolist", this.bs.findAllBoard());
		
		
		//加在session中
		//ActionContext.getContext().getSession().put("bolist", this.bs.findAllBoard());
		return INDEX;

	}

	// 用户点击index后跳转
	public String clickforward() {
		System.out.println("loginforward()方法执行");

		return INDEX;
	}

	public BoardService getBs() {
		return bs;
	}

	public void setBs(BoardService bs) {
		this.bs = bs;
	}
}
