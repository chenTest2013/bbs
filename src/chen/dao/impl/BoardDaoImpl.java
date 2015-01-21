package chen.dao.impl;

import org.springframework.stereotype.Repository;

import chen.dao.BoardDao;
import chen.entity.Board;
@Repository("boarddaoimpl")
public class BoardDaoImpl extends BaseDaoImpl<Board> implements BoardDao {
	
	

	public BoardDaoImpl() {
		System.out.println("BoardDaoImpl实例boarddaoimpl创建成功");
	}

	

}
