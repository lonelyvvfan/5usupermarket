package cs.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.entity.User;
import cs.service.UserService;

public class UserLoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private int id;
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
	private User user;
	public String userschool;
	private UserService userService;
	
	public String resetpassword(){
		System.out.println("reset password");
		System.out.println(username);
		System.out.println(telephone);
		if( null == username && null == telephone ){
			return "error";
		}else{
			Boolean u = userService.resetpassword(username, telephone);
			if(u) {
				password = "000000";
				setUser(userService.finduserbyusername(username));
				setId(user.getId());
				setUsername(user.getUsername());
				setPassword(password);
				setTelephone(user.getTelephone());
				setAddress(user.getAddress());
				setAlipaynum(user.getAlipaynum());
				setAuthor(user.getAuthor());
				setEmail(user.getEmail());
				setNickname(user.getNickname());
				setQq(user.getQq());
				setRenren(user.getRenren());
				setSex(user.getSex());
				setWeibo(user.getWeibo());
				setSchool(user.getSchool());
				setLiving(user.getLiving());
				System.out.println(password+" is the password before altering");
				userService.alteruser(id, username, password, telephone, alipaynum, email, author, address, nickname, qq, renren, weibo, sex , school , living);
				System.out.println(user.getPassword()+" is the password after altering");
				return "resetok";
			}else{
				System.out.println("username or telephone is wrong");
				return "reseterror";
			}
		}
	}
	
	public String login() {
		System.out.println(username);
		System.out.println(password);
		if(null == username && null == password){
			return "login";
		}else{
			Boolean u = userService.login(username, password);
			if (u) {
				setUser(userService.finduserbyusername(username));
				setId(user.getId());
				nickname = user.getNickname();
				telephone = user.getTelephone();
				userschool = user.getSchool();
				living = user.getLiving();
				ActionContext.getContext().getSession().put("author", "2");
				ActionContext.getContext().getSession().put("id", id);
				ActionContext.getContext().getSession().put("username", username);
				ActionContext.getContext().getSession().put("nickname", nickname);
				ActionContext.getContext().getSession().put("telephone", telephone);
				ActionContext.getContext().getSession().put("userschool", userschool);
				ActionContext.getContext().getSession().put("school", userschool);
				ActionContext.getContext().getSession().put("living", living);
				System.out.println(userschool+"is userschool");
				System.out.println(username+"is username in userlogin");
				System.out.println(living+"is living");
				return "ok";
			}else{
				return "error";
			}
		}
	}
	
	public String turn(){
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlipaynum() {
		return alipaynum;
	}

	public void setAlipaynum(String alipaynum) {
		this.alipaynum = alipaynum;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getRenren() {
		return renren;
	}

	public void setRenren(String renren) {
		this.renren = renren;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getLiving() {
		return living;
	}

	public void setLiving(String living) {
		this.living = living;
	}

	public String getUserschool() {
		return userschool;
	}

	public void setUserschool(String userschool) {
		this.userschool = userschool;
	}

}
