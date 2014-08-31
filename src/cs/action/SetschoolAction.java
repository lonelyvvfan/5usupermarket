package cs.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Cart;

public class SetschoolAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	public String setschool(){
		Map session=ActionContext.getContext().getSession();
		if (id==0)
		{
		session.put("school", "0");
		}
		else if (id==1)
		{
		session.put("school", "1");
		}
		else if (id==2)
		{
		session.put("school", "2");
		}
		else if (id==3)
		{
		session.put("school", "3");
		}
		else if (id==4)
		{
		session.put("school", "4");
		}
		else if (id==5)
		{
		session.put("school", "5");
		}
		else if (id==6)
		{
		session.put("school", "6");
		}
		else if (id==7)
		{
		session.put("school", "7");
		}
		System.out.println(session.get("school"));
		return "setsuccess";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
