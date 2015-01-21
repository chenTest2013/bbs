package chen.service;

import java.io.Serializable;

import chen.entity.Role;

public interface RoleService {
 public Role findByName(String name);
 public Serializable save(Role r);
 public Role findById(int id);
}
