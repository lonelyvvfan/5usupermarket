package cs.action.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Seller;
import cs.entity.User;
import cs.service.SellerService;
import cs.service.UserService;

public class UserLoginAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private User user;

	private UserService userService;
	
	
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("id");
		ActionContext.getContext().getSession().remove("username");
		ActionContext.getContext().getSession().remove("nickname");
		ActionContext.getContext().getSession().remove("telephone");
		ActionContext.getContext().getSession().remove("userschool");
		ActionContext.getContext().getSession().remove("living");
		ActionContext.getContext().getSession().remove("user");
		ActionContext.getContext().getSession().clear();
		return "logout";
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}