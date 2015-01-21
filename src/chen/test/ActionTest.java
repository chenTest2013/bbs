package chen.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class ActionTest extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(){
		System.out.println("AAAAAAAA");
		@SuppressWarnings("unchecked")
		Map<String, Object> map=(Map<String, Object>) ActionContext.getContext().get("request");
		Set<Entry<String, Object>> entries = map.entrySet();
		 if(entries != null){
			 Iterator<Entry<String, Object>> iterator =entries.iterator();
			 while(iterator.hasNext()){
				Entry<String, Object> entry =iterator.next();
				System.out.println(entry.getKey()+"="+entry.getValue());
			 }
		 }
	    System.out.println("BBBBBBBB");
		return SUCCESS;
	}

}
