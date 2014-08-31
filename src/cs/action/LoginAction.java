package cs.action;

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
	
	private AdminService adminService;
	
	public String login() {
		System.out.println(username);
		System.out.println(password);
		if(null == username && null == password){
			return "login";
		}else{
			Boolean u = adminService.login(username, password);
			if (u) {
				ActionContext.getContext().getSession().put("username", username);
				ActionContext.getContext().getSession().put("author", "0");
				return "ok";
			}else{
				return "error";
			}
		}
			

	}
	
	public String logout() throws Exception {
		ActionContext.getContext().getSession().clear();
		return "login";
}

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
