package cs.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Order;
import cs.service.AdminService;
import cs.service.OrderService;
import cs.vo.PageModel;

/**
 * Created by m2mbob on 2014/8/28.
 */
public class LunxunAction extends  ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Object> list=new ArrayList<Object>();
	private AdminService adminService;
	public String hasNewOrder(){
		PageModel page=new PageModel();
		List<Order> list1=adminService.queryallorder(page);
		if (list1.get(0).getIsclosed()==3)
			list.add(true);
		return "list";
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
		
}
