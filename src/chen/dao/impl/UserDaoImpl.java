package chen.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import chen.dao.UserDao;
import chen.entity.User;

@Repository("userdaoimpl")//
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	public UserDaoImpl(){
		System.out.println("UserDaoImpl实例创建成功");
		
	}

	@Override//此方法需改善
	public User findUserByname(String name) {
		List<User> l=super.find("select u from User as u where u.name='"+name+"'");
		if(l.size()==0){
			System.out.println("l.isEmpty()=="+l.isEmpty());
			return null;
		}
		else {
			return (User)l.get(0);
		}
	}

	@Override//此方法需改善
	public User findUserByEmail(String email) {
		List<User> l=super.find("select u from User as u where u.email='"+email+"'");
		if(l.size()==0){
			System.out.println("l.isEmpty()=="+l.isEmpty());
			return null;
		}
		else {
			return (User)l.get(0);
		}
	}
	
	
	

}
