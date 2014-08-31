package cs.action.user;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.bcel.internal.generic.NEW;

import cs.entity.User;
import cs.service.PagingService;
import cs.service.UserService;
import cs.vo.PageModel;


public class UsermanageAction {
	/**
	 *  管理员管理普通用户用户
	 */
	private static final long serialVersionUID = 1L;
	private User user=new User();
	private List<User> list;
	private UserService userService;
	private PageModel userpage=new PageModel();
	Map<String, List<User>> userlistMap = new HashMap<String,List<User>>();
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
	private String school;//学校
	private String living;//生活区
	public String userschool;//
	private String keyword="";//搜索关键字
	private PagingService pagingService;
	private Integer pagesize=5;
	
	/**
	 * 进入后台后直接显示所有的user。默认方法
	 */
	/*
	public String showuser() throws Exception {   
		list = adminService.queryalluser(page);
		return "user";
	}
	*/
	
	
	
	/**
	 * 把页面上修改内容更新到数据库
	 * @return
	 * @throws Exception
	 */
	public String alteruser() throws Exception{   
		System.out.println("2author is "+author);
		System.out.println("telephone is "+telephone);
		System.out.println("email is "+email);
		System.out.println("alipaynum is "+alipaynum);
		user  = userService.alteruser(id, username, password, telephone, alipaynum, email, author, address, nickname, qq, renren, weibo, sex,school,living);
		
		setUser(userService.finduserbyusername(username));
		setId(user.getId());
		nickname = user.getNickname();
		telephone = user.getTelephone();
		userschool = user.getSchool();
		living = user.getLiving();
		ActionContext.getContext().getSession().put("id", id);
		ActionContext.getContext().getSession().put("username", username);
		ActionContext.getContext().getSession().put("nickname", nickname);
		ActionContext.getContext().getSession().put("telephone", telephone);
		ActionContext.getContext().getSession().put("userschool", userschool);
		ActionContext.getContext().getSession().put("school", userschool);
		ActionContext.getContext().getSession().put("living", living);
		
		return "alterSuccess";
	}	

	/**
	 * 
	 * @return
	 */
	public String showuser() throws Exception{
		id = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		System.out.println("3author is "+author);
		user = userService.finduserbyid(id);
        return "user";
    }
	
	/**
	 * 根据id找到对应的user并且显示到新页面上
	 * @return
	 * @throws Exception
	 */
	public String altershow() throws Exception{  
		user = userService.finduserbyid(id);
		System.out.println("1author is "+author);
		System.out.println("id="+id);
		return "alterShow";
	}
	
	
	
	public PagingService getPagingService() {
		return pagingService;
	}

	public void setPagingService(PagingService pagingService) {
		this.pagingService = pagingService;
	}

	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public PageModel getUserpage() {
		return userpage;
	}
	public void setUserpage(PageModel userpage) {
		this.userpage = userpage;
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
