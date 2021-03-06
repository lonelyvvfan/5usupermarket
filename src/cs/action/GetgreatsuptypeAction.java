package cs.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Greatseller_supertype;
import cs.entity.Secondgoods_supertype;
import cs.entity.Takeout_supertype;
import cs.service.AdminService;

public class GetgreatsuptypeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer suptypeid;
	private Integer subtypeid;
	private AdminService adminService;
	private List<Greatseller_supertype> list;
	
	public String getsuptype(){
		list = adminService.showgreatsellersuptype();
		System.out.println(list);
		return "list";
	}

	public Integer getSuptypeid() {
		return suptypeid;
	}

	public void setSuptypeid(Integer suptypeid) {
		this.suptypeid = suptypeid;
	}




	public List<Greatseller_supertype> getList() {
		return list;
	}

	public void setList(List<Greatseller_supertype> list) {
		this.list = list;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Integer getSubtypeid() {
		return subtypeid;
	}

	public void setSubtypeid(Integer subtypeid) {
		this.subtypeid = subtypeid;
	}
	
}
