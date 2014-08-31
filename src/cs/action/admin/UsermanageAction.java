package cs.action.admin;



import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cs.entity.User;

import java.util.HashMap;
import java.util.List;



import cs.service.AdminService;
import cs.service.PagingService;
import cs.service.UserService;
import cs.vo.PageModel;


public class UsermanageAction {
	/**
	 *  管理员管理普通用户用户
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private List<User> list;
	private AdminService adminService;
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
	private String keyword="";//搜索关键字
	private PagingService pagingService;
	private Integer pagesize= 15;
	private int[] checkbox;
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
	 * //删除指定id的user
	 */
	public String deleteuserbyid() throws Exception{  
		boolean reslut = false;
		reslut = adminService.deleteuserbyid(id);
		if(reslut)
		{
			System.out.println("return success");
		return "success";
		}
		else {
			System.out.println("return success");
			return "failure";
		}
	}
	
	public String deletecheckbox() throws Exception{
		System.out.println("checkbox  = " + checkbox.length);
		for (int i = 0; i < checkbox.length; i++) {
			System.out.println(checkbox[i]);
		}
		String[] arr =(String [])ActionContext.getContext().getParameters().get("checkbox");
		System.out.println("checkbox  = " + arr);
		 if(arr!=null)
		 {
		     int[] arrId = new int[arr.length];
		     for (int i = 0; i < arr.length; i++) {
		         arrId[i] = Integer.parseInt(arr[i]);
		         }       
		boolean reslut = false;
		reslut = adminService.deletecheckbox(arrId);
		if(reslut)
		{
			System.out.println("return success");
		return "success";
		}
		else {
			System.out.println("return success");
			return "failure";
		}
		 }
		 else
			 return "failure";
	}	
	
	
	
	/**
	 *  //输入账号.密码.电话号码，增加user
	 */
	public String adduser() throws Exception{  
		list = adminService.adduser(username, password,telephone, alipaynum, email,
				author,  address, nickname, qq, renren, weibo, sex,school,living);
		userlistMap.put("list", list);
		return "addSuccess";
	}
	
	
	/**
	 * 把页面上修改内容更新到数据库
	 * @return
	 * @throws Exception
	 */
	public String alteruser() throws Exception{   
		System.out.println("asdaasdsa");
		author = "2";
		list  = adminService.alteruser(id, username, password,telephone, alipaynum, email,
				author,  address, nickname, qq, renren, weibo, sex,school,living);
		return "alterSuccess";
	}
	
	/**
	 * 找到指定username的账户 返回list
	 * @param username
	 * @return
	 */
	
	public String finduserspecial(){
		System.out.println(username);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from User as u where u.username like ? order by id desc";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    System.out.println(phql);
   	    if ((Object)userpage.getCurrentPage()==null)
   	    	userpage.setCurrentPage(1);
        userpage = pagingService.queryforpage(phql,pagesize, userpage.getCurrentPage(),username);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=userpage.getCurrentPage()-5;i<=userpage.getCurrentPage()+5;i++)
        {
        	if (i<=0||i>userpage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        userpage.setPageList(list1);
        return "findsuccess";
	}
	
	
	/**
	 * 根据id找到对应的user并且显示到新页面上
	 * @return
	 * @throws Exception
	 */
	public String altershow() throws Exception{  
		user = adminService.finduserbyid(id);
		System.out.println(id);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getTelephone());
		return "alterShow";
	}
	
	/**
	 * 
	 * @return
	 */
	public String showuser(){
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from User order by id desc";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    System.out.println(phql);
   	    if ((Object)userpage.getCurrentPage()==null)
   	    	userpage.setCurrentPage(1);
   	    username=null;
        userpage = pagingService.queryforpage(phql,pagesize, userpage.getCurrentPage(),username);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=userpage.getCurrentPage()-5;i<=userpage.getCurrentPage()+5;i++)
        {
        	if (i<=0||i>userpage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        userpage.setPageList(list1);
        return "user";
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
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
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

	public Map<String, List<User>> getUserlistMap() {
		return userlistMap;
	}

	public void setUserlistMap(Map<String, List<User>> userlistMap) {
		this.userlistMap = userlistMap;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public int[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(int[] checkbox) {
		this.checkbox = checkbox;
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


}
