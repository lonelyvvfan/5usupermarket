package cs.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.service.AdminService;

public class GetsubtypeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String suptypeid;
	private Integer subtypeid;
	private AdminService adminService;
	private List<Goods_subtype> list;
	
	public String getsubtype(){
		list = adminService.showsubtype1(Integer.parseInt(suptypeid));
		System.out.println(list);
		return "list";
	}

	public String getSuptypeid() {
		return suptypeid;
	}

	public void setSuptypeid(String suptypeid) {
		this.suptypeid = suptypeid;
	}



	public List<Goods_subtype> getList() {
		return list;
	}

	public void setList(List<Goods_subtype> list) {
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
