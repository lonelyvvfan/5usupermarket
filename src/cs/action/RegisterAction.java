package cs.action;

import cs.entity.User;
import cs.service.UserService;

import java.sql.Date;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import cs.service.AdminService;
import cs.vo.UserPage;

public class RegisterAction extends ActionSupport{
	private String username;
	private String password;
	private String telephone;//联系电话
	private String email;//电子邮件
	private String alipaynum;//支付宝帐号
	private String author;//权限
	private String address;//地址
	private String nickname;//昵称
	private String qq;//QQ号
	private String renren;//人人号
	private String weibo;//微博号
	private String sex;	//性别
	private String school;
	private String living;
	private AdminService adminService;
	private List<User> list;
	
	/**
	 * 注册的方法，， 检查密码1和2是否相等以及username是否存在
	 * @return
	 * @throws Exception
	 */
	
	public String register() throws Exception{
		System.out.println("register start!");
		if(username!= null && password !=null && password != null && telephone!=null){
			if((adminService.finduserspecial(username)).isEmpty()){
				author = "2";
				list = adminService.adduser(username, password,telephone, alipaynum, email,
						author,  address, nickname, qq, renren, weibo, sex , school , living);
				System.out.println("register success!");
				return "success";
			}
			else {
				System.out.println("register failure username exist!");
				return "failure";
			}
		}else{
			System.out.println("register failure username is null!");
			return "failure";
		}
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	
}

