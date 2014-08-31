package cs.service;

import java.util.List;

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
import cs.vo.UserPage;

public interface UserService {
	public boolean login(String username,String password);
	public boolean resetpassword(String username , String telephone);
	
	public User alterpassword(Integer id , String password);
	
	public List<User> queryalluser(PageModel page);

	/**
	 * 修改普通用户信息
	 */
	public User alteruser(Integer id, String username, String password,
			String telephone, String alipaynum, String email, String author,
			String address, String nickname, String qq, String renren,
			String weibo, String sex, String school,String living);
	
	/**
	 * 增加订单
	 */
	public Order addorder(String arrivedday, String arrivedtime,
			double totalamount, String username, String truename,
			String telephone, String school, String doorplate, String room,
			String remark, String payway, int isclosed);
	
	/**
	 * 增加订单详情
	 */
	public List<Order> addorderdetail(List<Order_detail> list,Integer id);
	
	
	/**
	 * 找到全部二手商品
	 */
	public List<Secondgoods> queryallsecgoods(PageModel page);
	
	
	/**
	 * 根据订单id找到订单下的商品 并且返回一个order_detail对象list
	 */
	public List<Order_detail> findorderdetailbyid(Integer id);
	
	/**
	 * 根据id找到二手商品 并且返回一个secondgoods对象
	 */
	public Secondgoods findsecgoodsbyid(int id);

	
	/**
	 * 根据id找到用户 并且返回一个user对象
	 */
	public User finduserbyid(int id);
	
	/**
	 * 根据username找到用户 并且返回一个user对象
	 */
	public  User finduserbyusername(String username);
	
	/**
	 * 根据id找到订单 并且返回一个order对象
	 */
	public Order findorderbyid(int id);
	
	/**
	 * 根据username和isclosed找到order
	 */
	public List<Order> findorderspecial(String username,Integer isclosed);
	
	/**
	 * 增加用户
	 */
	public List<User> adduser(String username, String password, String telephone);
	
	/**
	 * 增加二手商品
	 */
	public List<Secondgoods> addsecgoods(Integer userid,String username,String nickname,Integer suptypeid, Integer subtypeid,
			String goodsname, String introduce, double price, double nowprice,String savepath, String savepath1, 
			String savepath2,String savepath3,  Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend, String shelves, String qq , String telephone ,  String other,Integer recency , String reason, String school, String living);
	
	/**
	 * 批量删除secgoods
	 */
	public boolean deletecheckboxsecgoods(int[] arrid);
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean secupjia(int[] checkout);
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean secdownjia(int[] checkout);
	
	
	/**
	 * 根据id删除二手商品
	 */
	public boolean deletesecgoodsbyid(int id);
	
	
	
	/**
	 * 修改二手商品信息
	 */
	 public List<Secondgoods> altersecgoods(Integer id,Integer userid,String username,String nickname,Integer suptypeid, Integer subtypeid,
				String goodsname, String introduce, double price, double nowprice,String savepath, String savepath1, 
				String savepath2,String savepath3,  Integer newgoods, Integer hot, Integer special,
				Integer health, Integer recommend, String shelves, String qq , String telephone ,  String other,Integer recency , String reason, String school , String living);
	 
	 /*+++++++++++++showsubtype开始++++++++++++++*/
		
		
		
		/**
		 * 查找二手商品所有子类分类返回list
		 * 
		 * @return
		 */
		public List<Secondgoods_subtype> showsecsubtype();

		
	/*+++++++++++++showsubtype结束++++++++++++++*/	
		
		
		
	/*+++++++++++++showsuptype开始++++++++++++++*/
		
		
		/**
		 * 查找二手商品所有父类分类返回list
		 * 
		 * @return
		 */
		public List<Secondgoods_supertype> showsecsuptype();

		
	/*+++++++++++++showsuptype结束++++++++++++++*/	
	 
}
