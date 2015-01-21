package chen.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import chen.dao.TopicDao;
import chen.entity.Topic;


@Repository("topicdaoimpl")
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements TopicDao {

	public TopicDaoImpl() {
		System.out.println("TopicDaoImpl实例topicdaoimpl创建成功");
	}
	public Topic findTopicByTitle(String title) {
		List<Topic> l=super.find("select t from Topic as t where t.title='"+title+"'");
		if(l.size()==0){
			System.out.println("l.isEmpty()=="+l.isEmpty());
			return null;
		}
		else {
			return (Topic)l.get(0);
		}
		
		
	}

}
