package chen.service;

import java.util.List;

import chen.entity.Role;
import chen.entity.User;

public interface UserService {
	public void saveUser(User u);

	public void updateUser(User u);

	public User findUserById(int id);

	public void deleteUser(User u);

	public List<User> findAllList();
	
   public User findUserByName(String name);
   public User findUserByEmail(String email);
  
}
