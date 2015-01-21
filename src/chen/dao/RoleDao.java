package chen.dao;

import chen.entity.Role;

public interface RoleDao extends BaseDao<Role>{
 public Role findByName(String name);
}
