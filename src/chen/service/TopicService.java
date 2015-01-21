package chen.service;

import java.util.List;

import chen.entity.Topic;

public interface TopicService {
	public void saveTopic(Topic u);

	public void updateTopic(Topic u);

	public Topic findTopicById(int id);

	public void deleteTopic(Topic u);

	public List<Topic> findAllList();
	
    public Topic findTopicByTitle(String title);
    
    //分页查询
    public List<Topic> findTopicPart(Object[] param, Integer page, Integer rows);
   
     //分页查询,根据版区ID查询帖子
    public List<Topic> findTopicPartByBoardId(int id, Object[] param,Integer page, Integer rows);
   
    //根据用户ID查询帖子
    public List<Topic> findTopicPartByUserId(int id, Object[] param,Integer page, Integer rows);
    
}
