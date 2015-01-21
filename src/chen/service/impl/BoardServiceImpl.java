package chen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import chen.dao.impl.BoardDaoImpl;
import chen.entity.Board;
import chen.service.BoardService;

@Service("boardser")
public class BoardServiceImpl implements BoardService {
	@Resource(name="boarddaoimpl")
	private BoardDaoImpl bdao;
	@Override
	public List<Board> findAllBoard() {
		
		return bdao.find("from Board as b");
	}
	public BoardDaoImpl getBdao() {
		return bdao;
	}
	
	
	public void setBdao(BoardDaoImpl bdao) {
		this.bdao = bdao;
	}
	@Override
	public Board findBoardById(int id) {
		
		return this.bdao.get(Board.class, id);
	}
	//次方法用来获取Spring容器本身
    public ApplicationContext getspringContext(){
    	return this.bdao.getCtx();
    }
}
