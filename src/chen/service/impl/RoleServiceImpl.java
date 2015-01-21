package chen.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import chen.dao.RoleDao;
import chen.entity.Role;
import chen.service.RoleService;
@Service("roleser")
public class RoleServiceImpl implements RoleService{

	@Resource(name="roledaoimpl")
	private RoleDao rdao;
	@Override
	public Role findByName(String name) {
		
		return rdao.findByName(name);
	}
	@Override
	public Serializable save(Role r) {
		return rdao.save(r);
		
	}
	@Override
	public Role findById(int id) {
		
		return rdao.get(Role.class, id);
	}

}
