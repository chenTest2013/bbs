package chen.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import chen.dao.RoleDao;
import chen.entity.Role;
@Repository("roledaoimpl")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	@Override
	public Role findByName(String name) {
		List<Role> l=super.find("select u from Role as u where u.name='"+name+"'");
		if(l.size()==0){
			System.out.println("l.isEmpty()=="+l.isEmpty());
			return null;
		}
		else {
			return (Role)l.get(0);
		}
	}


}
