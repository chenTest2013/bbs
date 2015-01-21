package chen.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import chen.entity.Board;

public interface BoardService {
public	List<Board> findAllBoard();
public Board findBoardById(int id);

//此方法用来获取Spring容器本身
public ApplicationContext getspringContext();
}
