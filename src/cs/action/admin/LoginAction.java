package cs.action.admin;

import cs.service.AdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String nowpassword;
	
	public String logout() throws Exception {
		ActionContext.getContext().getSession().clear();
		return "logout";
	}
	
	public String alteradmin() throws Exception{
		boolean r = adminService.alteradmin(username,password,nowpassword);
		if(r)
			return "alteradminSuccess";
		else {
			return "alteradminFailure";
		}
	}
	
	public String getNowpassword() {
		return nowpassword;
	}

	public void setNowpassword(String nowpassword) {
		this.nowpassword = nowpassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private AdminService adminService;
	
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	
}
