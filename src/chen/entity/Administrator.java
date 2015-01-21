package chen.entity;
//管理员
import chen.entity.User;



public class Administrator extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrator() {
	
	}
	public Administrator(String name) {
		this.setName(name);
	}
	
	public void setMangertype(MangerType mt){
		super.setRole(mt);
	}
	
	public MangerType getMangertype(){
		return (MangerType)super.getRole();
	}
}
