package cs.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Greatseller_subtype;
import cs.entity.Secondgoods_subtype;
import cs.entity.Takeout_subtype;
import cs.service.AdminService;

public class GetgreatsubtypeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String suptypeid;
	private Integer subtypeid;
	private AdminService adminService;
	private List<Greatseller_subtype> list;
	
	public String getsubtype(){
		list = adminService.showgreatsellersubtype1(Integer.parseInt(suptypeid));
		System.out.println(list);
		return "list";
	}

	public String getSuptypeid() {
		return suptypeid;
	}

	public void setSuptypeid(String suptypeid) {
		this.suptypeid = suptypeid;
	}



	public List<Greatseller_subtype> getList() {
		return list;
	}

	public void setList(List<Greatseller_subtype> list) {
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
