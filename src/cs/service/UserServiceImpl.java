package cs.service;

import java.util.ArrayList;
import java.util.List;

import cs.dao.UserDAO;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Greatseller_subtype;
import cs.entity.Greatseller_supertype;
import cs.entity.Order;
import cs.entity.Order_detail;
import cs.entity.Secondgoods;
import cs.entity.Secondgoods_subtype;
import cs.entity.Secondgoods_supertype;
import cs.entity.Takeout_subtype;
import cs.entity.Takeout_supertype;
import cs.entity.User;
import cs.vo.PageModel;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO;
	
	public boolean login(String username,String password){
		User u = userDAO.queryuserbyusername(username);
		System.out.println("Enter UserServiceImpl");
		if (u == null){
			System.out.println("user is null");
			return false;
		}else{
			if(u.getPassword().equals(password)){
				System.out.println("login success!");
				return true;
			}else{
				System.out.println("login failed!");
				return false;
			}
		}
	}
	
	public boolean resetpassword(String username,String telephone){
		User u = userDAO.queryuserbyusername(username);
		System.out.println("Enter UserServiceImpl");
		if (u == null){
			System.out.println("user is null");
			return false;
		}else{
			if(u.getTelephone().equals(telephone)){
				System.out.println("check telephone success!");
				return true;
			}else{
				System.out.println("check telephone failed!");
				return false;
			}
		}
	}
	
	/**
	 * 根据username找到用户 并且返回一个user对象
	 */
	public  User finduserbyusername(String username){	
		return userDAO.finduserbyusername(username);
	}
	
	/**
	 * 增加用户
	 */
	public List<User> adduser(String username, String password, String telephone){
		List<User> list = new ArrayList<User>();
		list = userDAO.adduser(username, password, telephone);
		return list;
	}
	
	/**
	 * 重置用户密码
	 */
	public User alterpassword(Integer id, String password) {
		User user = new User();
		user = userDAO.alterpassword(id, password);
		return user;
	}
	
	/**
	 * 修改用户信息
	 */
	public User alteruser(Integer id, String username, String password,
			String telephone, String alipaynum, String email, String author,
			String address, String nickname, String qq, String renren,
			String weibo, String sex, String school,String living) {
		User user = new User();
		System.out.println("1telephone is "+telephone);
		System.out.println("1email is "+email);
		System.out.println("1alipaynum is "+alipaynum);
		user = userDAO.alteruser(id, username, password, telephone,alipaynum, email,
				author, address, nickname, qq, renren, weibo, sex,school,living);
		return user;
	}
	
	/**
	 * 增加二手商品
	 */
	public List<Secondgoods> addsecgoods(Integer userid,String username,String nickname,Integer suptypeid, Integer subtypeid,
			String goodsname, String introduce, double price, double nowprice,String savepath, String savepath1, 
			String savepath2,String savepath3,  Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend, String shelves, String qq , String telephone ,  String other,Integer recency , String reason, String school, String living) {
		List<Secondgoods> list = new ArrayList<Secondgoods>();
		list = userDAO.addsecgoods(userid,username,nickname,suptypeid,subtypeid, goodsname, introduce, price,
				nowprice, savepath,  savepath1, savepath2, savepath3, newgoods, hot, special, health, recommend ,
				shelves , qq , telephone , other ,recency ,reason , school , living);
		return list;
	}
	
	
	/**
	 * 批量删除secgoods
	 */
	public boolean deletecheckboxsecgoods(int[] arrid){
		boolean r = userDAO.deletecheckboxsecgoods(arrid);
		return r;
	}
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean secupjia(int[] checkout){
		boolean r = userDAO.secupjia(checkout);
		return r;
	}
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean secdownjia(int[] checkout){
		boolean r = userDAO.secdownjia(checkout);
		return r;
	}
	
	/**
	 * 根据id删除二手商品
	 */
	public boolean deletesecgoodsbyid(int id) {
		boolean r = false;
		r = userDAO.deletesecgoodsbyid(id);
		return r;
	}
	
	/**
	 * 找到全部二手商品
	 */
	public List<Secondgoods> queryallsecgoods(PageModel page) {
		List<Secondgoods> list = new ArrayList<Secondgoods>();
		list = userDAO.queryallsecgoods(page);
		return list;
	}
	
	
	/**
	 * 修改二手商品信息
	 */
	public List<Secondgoods> altersecgoods(Integer id,Integer userid,String username,String nickname,Integer suptypeid, Integer subtypeid,
			String goodsname, String introduce, double price, double nowprice,String savepath, String savepath1, 
			String savepath2,String savepath3,  Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend, String shelves, String qq , String telephone ,  String other,Integer recency , String reason, String school, String living) {
		List<Secondgoods> list = new ArrayList<Secondgoods>();
		list = userDAO.altersecgoods(id,userid,username,nickname,suptypeid,subtypeid, goodsname, introduce, price,
				nowprice, savepath,  savepath1, savepath2, savepath3, newgoods, hot, special, health, recommend ,
				shelves , qq , telephone , other ,recency ,reason , school , living);
		return list;
	}
	
	public List<User> queryalluser(PageModel page){
		List<User> list = new ArrayList<User>();
		list = userDAO.queryalluser(page);
		return list;
	}
	
	/**
	 * 增加订单
	 */
	public Order addorder(String arrivedday, String arrivedtime,
			double totalamount, String username, String truename,
			String telephone, String school, String doorplate, String room,
			String remark, String payway, int isclosed) {
		Order order = new Order();
		order = userDAO.addorder(arrivedday, arrivedtime, totalamount,
				username, truename, telephone, school, doorplate, room, remark,
				payway, isclosed);
		return order;
	}
	
	/**
	 * 增加订单详情
	 */
	public List<Order> addorderdetail(List<Order_detail> list,Integer id){
		List<Order> orderlist = new ArrayList<Order>();
		orderlist = userDAO.addorderdetail(list,id);
		return orderlist;
	}
	
	
	/**
	 * 根据id找到二手商品 并且返回一个secondgoods对象
	 */
	public Secondgoods findsecgoodsbyid(int id){
		Secondgoods secondgoods = new Secondgoods();
		secondgoods = userDAO.findsecgoodsbyid(id);
		return secondgoods;
	}
	
	/**
	 * 根据id找到用户 并且返回一个user对象
	 */
	public User finduserbyid(int id) {
		User user = new User();
		user = userDAO.finduserbyid(id);
		return user;
	}
	
	/**
	 * 根据id找到订单 并且返回一个order对象
	 */
	public Order findorderbyid(int id) {
		Order order = new Order();
		order = userDAO.findorderbyid(id);
		return order;
	}
	
	/**
	 * 根据订单id找到订单下的商品 并且返回一个order_detail对象list
	 */
	public List<Order_detail> findorderdetailbyid(Integer id){
		List<Order_detail> orederdetaillist = new ArrayList<Order_detail>();
		orederdetaillist=userDAO.findorderdetailbyid(id);
		return orederdetaillist;
	}
	
	/**
	 * 根据username和isclosed找到order
	 */
	public List<Order> findorderspecial(String username,Integer isclosed) {
		System.out.println("servicefind start");
		List<Order> orderlist = new ArrayList<Order>();
		orderlist = userDAO.findorderspecial(username,isclosed);
		return orderlist;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
/*+++++++++++++showsubtype开始++++++++++++++*/
	

	/**
	 * 查找二手商品所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Secondgoods_subtype> showsecsubtype() {
		List<Secondgoods_subtype> list = new ArrayList<Secondgoods_subtype>();
		list = userDAO.showsecsubtype();
		return list;
	}
	
	
	/*+++++++++++++showsubtype结束++++++++++++++*/	
	
	
	
	/*+++++++++++++showsuptype开始++++++++++++++*/
		

	/**
	 * 查找二手商品所有父类分类返回list
	 * 
	 * @return
	 */
	public List<Secondgoods_supertype> showsecsuptype() {
		List<Secondgoods_supertype> list = new ArrayList<Secondgoods_supertype>();
		list = userDAO.showsecsuptype();
		return list;
	}


	
/*+++++++++++++showsuptype结束++++++++++++++*/	
	
}
