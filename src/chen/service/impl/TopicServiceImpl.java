package chen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import chen.dao.impl.TopicDaoImpl;
import chen.entity.Topic;
import chen.service.TopicService;

@Service("topicser")
public class TopicServiceImpl implements TopicService{
	
	private TopicDaoImpl tdao;

	@Override
	public void saveTopic(Topic u) {
		tdao.save(u);
		
	}

	@Override
	public void updateTopic(Topic u) {
		tdao.update(u);
		
	}

	@Override
	public Topic findTopicById(int id) {
		
		return tdao.get(Topic.class, id);
	}

	@Override
	public void deleteTopic(Topic u) {
		tdao.delete(u);
		
	}

	@Override
	public List<Topic> findAllList() {
		
		return tdao.find("from Topic as t");
	}

	@Override
	public Topic findTopicByTitle(String title) {
		
		return tdao.findTopicByTitle(title);
	}

	public TopicDaoImpl getTdao() {
		return tdao;
	}
	@Resource(name="topicdaoimpl")
	public void setTdao(TopicDaoImpl tdao) {
		this.tdao = tdao;
	}

	@Override
	public List<Topic> findTopicPart(Object[] param, Integer page, Integer rows) {
		String hql="select t from Topic as t";
		return tdao.find(hql, param, page, rows);
	}

	@Override
	public List<Topic> findTopicPartByBoardId(int id, Object[] param,Integer page, Integer rows) {
		
		String str="select t from Topic as t where t.b.id='"+id+"'";
		return tdao.find(str, param, page, rows);
	}

	@Override
	public List<Topic> findTopicPartByUserId(int id, Object[] param, Integer page, Integer rows) {
		String hql="select t from Topic as t where t.u.id='"+id+"'";	
		return tdao.find(hql, param, page, rows);
	}
	

}
