package chen.dao;

import chen.entity.User;

public interface UserDao extends BaseDao<User>{
  public User findUserByname(String name);
  public User findUserByEmail(String email);	  
 
   
}
