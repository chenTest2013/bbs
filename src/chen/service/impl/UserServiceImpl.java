package chen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import chen.dao.UserDao;
import chen.entity.Role;
import chen.entity.User;
import chen.service.UserService;

@Service("uservice")
public class UserServiceImpl implements UserService {

	@Resource(name="userdaoimpl")//此处是将UserDao的实现类的对象userdao赋值给this.userDao
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
	//System.out.println("userDao.getClass()==="+userDao.getClass());
	//此处的的userDao是UserServiceImpl的实例,为啥不能使用UserServiceImpl的父类中getCtx()方法呢??
	System.out.println("开始将userdaoimpl注入到UserServiceImpl.class");
		this.userDao = userDao;
	}

	public UserServiceImpl() {
		System.out.println("UserServiceImpl实例创建成功");
	}

	@Override
	public void saveUser(User u) {
		//System.out.println("开始保存用户");
		userDao.save(u);
		//System.out.println("保存用户结束");

	}

	@Override
	public void updateUser(User u) {
		userDao.update(u);
	}

	@Override
	public User findUserById(int id) {
		
		return userDao.get(User.class, id);
	}

	@Override
	public void deleteUser(User u) {
		userDao.delete(u);

	}

	@Override
	public List<User> findAllList() {
		return userDao.find("from User as u");
	}

	@Override
	public User findUserByName(String name) {
	
		System.out.println("UserServiceImpl.findUserByName()开始执行");
		return userDao.findUserByname(name);
	
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findUserByEmail(email);
	}

	
}
