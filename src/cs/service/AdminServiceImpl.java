package cs.service;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import cs.dao.AdminDAO;
import cs.dao.SellerDAO;
import cs.dao.UserDAO;
import cs.entity.Admin;
import cs.entity.Combo;
import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Greatseller;
import cs.entity.Greatseller_subtype;
import cs.entity.Greatseller_supertype;
import cs.entity.HelpCenter;
import cs.entity.Keyword;
import cs.entity.Notice;
import cs.entity.Order;
import cs.entity.Order_detail;
import cs.entity.Secondgoods;
import cs.entity.Secondgoods_subtype;
import cs.entity.Secondgoods_supertype;
import cs.entity.Seller;
import cs.entity.Takeout;
import cs.entity.Takeout_subtype;
import cs.entity.Takeout_supertype;
import cs.entity.User;
import cs.vo.PageModel;

public class AdminServiceImpl implements AdminService {
	private UserDAO userDAO;
	private AdminDAO adminDAO;
	private SellerDAO sellerDAO;

/*+++++++++++++login开始++++++++++++++*/
	/**
	 * 登陆
	 */
	public boolean login(String username, String password) {
		Admin u = adminDAO.queryuserbyusername(username);
		System.out.println("Enter AdminServiceImpl");
		if (u == null) {
			System.out.println("user is null");
			return false;
		} else {
			if (u.getPassword().equals(password)) {
				System.out.println("login success!");
				return true;
			} else {
				System.out.println("login failed!");
				return false;
			}
		}
	}
	
/*+++++++++++++login结束++++++++++++++*/
	
	
/*+++++++++++++add开始++++++++++++++*/
	
	/**
	 * 增加用户
	 */
	public List<User> adduser( String username, String password,
			String telephone, String alipaynum, String email, String author,
			String address, String nickname, String qq, String renren,
			String weibo, String sex, String school,String living) {
		List<User> list = new ArrayList<User>();
		list = adminDAO.adduser(username, password,telephone, alipaynum, email,
				author,  address, nickname, qq, renren, weibo, sex,school,living);
		return list;
	}
	
	/**
	 * 增加外卖商家分类
	 */
	public void addsellertype(Integer suptypeid,Integer subtypeid,String name,String savepath,Integer sellerid,String reason){
		adminDAO.addsellertype(suptypeid,subtypeid,name,savepath,sellerid, reason);
	}

	/**
	 * 增加商户
	 */
	public List<Seller> addseller(String username, String password,
			String name, String telephone, String address, String email,
			String alipaynum, String identification, String savepath,
			String author, String content, String reason) {
		List<Seller> list = new ArrayList<Seller>();
		list = adminDAO.addseller(username, password, name, telephone, address,
				email, alipaynum, identification, savepath, author, content , reason);
		return list;
	}

	/**
	 * 增加帮助信息
	 */
	public List<HelpCenter> addhelp(String title,String content){
		List<HelpCenter> list = new ArrayList<HelpCenter>();
		list = adminDAO.addhelp(title, content);
		return list;
	}
	
	/**
	 * 增加keyword
	 */
	public List<Keyword> addkeyword(String title){
		List<Keyword> list = new ArrayList<Keyword>();
		list = adminDAO.addkeyword(title);
		return list;
	}
	
	/**
	 * 增加公告
	 */
	public List<Notice> addnotice(String title,String content){
		List<Notice> list = new ArrayList<Notice>();
		list = adminDAO.addnotice(title, content);
		return list;
	}
	
	
	/**
	 * 增加商品
	 */
	public List<Goods> addgoods(Integer suptypeid, Integer subtypeid,Integer indexx,
			String goodsname, String introduce, double price, double nowprice,
			String savepath, String savepath1, String savepath2,String  savepath3, Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend, String shelves , Integer monthsell , Integer zan, String reason, Integer inventory) {
		List<Goods> list = new ArrayList<Goods>();
		System.out.println("adminServiceimpl indexx"+indexx);
		list = adminDAO.addgoods(suptypeid, subtypeid,indexx, goodsname, introduce,
				price, nowprice, savepath,  savepath1, savepath2, savepath3, newgoods, hot, special, health,
				recommend , shelves , monthsell , zan , reason , inventory);
		return list;
	}
	
	/**
	 * 增加套餐
	 */
	public List<Combo> addcombo(String goodsname, String introduce,double price,double nowprice, String savepath,String savepath1, String savepath2,String  savepath3,
			String shelves,Integer monthsell , Integer zan , String reason, Integer inventory){
		List<Combo> list = new ArrayList<Combo>();
		list = adminDAO.addcombo(goodsname, introduce, price, nowprice, savepath,  savepath1, savepath2, savepath3, shelves , monthsell , zan , reason , inventory);
		return list;
	}
	
	
	/**
	 * 增加二手商品
	 */
	public List<Secondgoods> addsecgoods(Integer userid,String username,String nickname,Integer suptypeid, Integer subtypeid,
			String goodsname, String introduce, double price, double nowprice,
			String savepath, String savepath1, String savepath2,String  savepath3, Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend, String shelves , String qq , String telephone ,  String other, String reason , Integer recency, String school,String living) {
		List<Secondgoods> list = new ArrayList<Secondgoods>();
		list = adminDAO.addsecgoods(userid,username,nickname,suptypeid, subtypeid, goodsname, introduce,
				price, nowprice, savepath, savepath1, savepath2, savepath3,  newgoods, hot, special, health,
				recommend , shelves, qq , telephone , other  , reason, recency , school , living);
		return list;
	}

	/**
	 * 增加外卖
	 */
	public List<Takeout> addtakeout(Integer sellerid,String sellername,Integer suptypeid, Integer subtypeid,
			String goodsname, String introduce, double price, double nowprice,
			String savepath, String savepath1, String savepath2,String  savepath3, Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend, String shelves, String reason){
		List<Takeout> list = new ArrayList<Takeout>();
		list = adminDAO.addtakeout(sellerid,sellername,suptypeid, subtypeid, goodsname, introduce,
				price, nowprice, savepath, savepath1, savepath2, savepath3,  newgoods, hot, special, health,
				recommend , shelves  , reason);
		return list;
	}
	
	/**
	 * 增加推荐商家
	 */
	public List<Greatseller> addgreatseller(Integer suptypeid,
			Integer subtypeid, String name, String content, String telephone,
			String savepath, String savepath1, String savepath2,String  savepath3, String address, String url, String shelves) {
		List<Greatseller> list = new ArrayList<Greatseller>();
		list = adminDAO.addgreatseller(suptypeid, subtypeid, name, content,
				telephone, savepath, savepath1, savepath2, savepath3,  address, url , shelves);
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
		order = adminDAO.addorder(arrivedday, arrivedtime, totalamount,
				username, truename, telephone, school, doorplate, room, remark,
				payway, isclosed);
		return order;
	}
	
	/**
	 * 增加订单
	 */
	public List<Order> addorder1(String arrivedday, String arrivedtime,
			double totalamount, String username, String truename,
			String telephone, String school, String doorplate, String room,
			String remark, String payway, int isclosed) {
		List<Order> list = new ArrayList<Order>();
		list = adminDAO.addorder1(arrivedday, arrivedtime, totalamount,
				username, truename, telephone, school, doorplate, room, remark,
				payway, isclosed);
		return list;
	}
	
	/**
	 * 增加订单详情
	 */
	public List<Order> addorderdetail(List<Order_detail> list,Integer id){
		List<Order> orderlist = new ArrayList<Order>();
		orderlist = adminDAO.addorderdetail(list,id);
		return orderlist;
	}
	
/*+++++++++++++add结束++++++++++++++*/
	
	
	
/*+++++++++++++delete开始++++++++++++++*/
	
	/**
	 * 根据sellerid删除sellertyoe
	 */
	public boolean deletesellertype(Integer id){
		boolean r = false;
		r = adminDAO.deletesellertype(id);
		return r;
		
	}
	
	/**
	 * 根据id删除用户
	 */
	public boolean deleteuserbyid(int id) {
		boolean r = false;
		r = adminDAO.deleteuserbyid(id);
		return r;
	}

	/**
	 * 根据id删除商家
	 */
	public boolean deletesellerbyid(int id) {
		boolean r = false;
		r = adminDAO.deletesellerbyid(id);
		return r;
	}

	/**
	 * 根据id删除帮助信息
	 */
	public boolean deletehelpbyid(int id){
		boolean r = false;
		r = adminDAO.deletehelpbyid(id);
		return r;
	}
	
	/**
	 * 根据id删除keyword
	 */
	public boolean deletekeywordbyid(int id){
		boolean r = false;
		r = adminDAO.deletekeywordbyid(id);
		return r;
	}
	
	/**
	 * 根据id删除公告
	 */
	public boolean deletenoticebyid(int id){
		boolean r = false;
		r = adminDAO.deletenoticebyid(id);
		return r;
	}
	
	/**
	 * 根据id删除商品
	 */
	public boolean deletegoodsbyid(int id) {
		boolean r = false;
		r = adminDAO.deletegoodsbyid(id);
		return r;
	}
	
	/**
	 * 根据id删除套餐
	 */
	public boolean deletecombobyid(int id){
		boolean r = false;
		r = adminDAO.deletecombobyid(id);
		return r;
	}

	/**
	 * 根据id删除二手商品
	 */
	public boolean deletesecgoodsbyid(int id) {
		boolean r = false;
		r = adminDAO.deletesecgoodsbyid(id);
		return r;
	}
	
	/**
	 * 根据id删除外卖
	 */
	public boolean deletetakeoutbyid(int id) {
		boolean r = false;
		r = adminDAO.deletetakeoutbyid(id);
		return r;
	}

	/**
	 * 根据id删除推荐商家
	 */
	public boolean deletegreatsellerbyid(int id) {
		boolean r = false;
		r = adminDAO.deletegreatsellerbyid(id);
		return r;
	}
	
	/**
	 * 根据id删除订单
	 */
	public boolean deleteorderbyid(int id) {
		boolean r = false;
		r = adminDAO.deleteorderbyid(id);
		return r;
	}
	
	/**
	 * 根据id删除订单详情
	 */
	public boolean deleteorderdetailbyid(int id) {
		boolean r = false;
		r = adminDAO.deleteorderdetailbyid(id);
		return r;
	}
	
	
	/**
	 * 批量删除user
	 */
	public boolean deletecheckbox(int[] arrid){
		boolean r = false;
		r = adminDAO.deletecheckbox(arrid);
		return r;
	}
	
	
	/**
	 * 批量删除seller
	 */
	public boolean deletecheckboxseller(int[] arrid){
		boolean r = adminDAO.deletecheckboxseller(arrid);
		return r;
	}
	
	/**
	 * 批量删除combo
	 */
	public boolean deletecheckboxcombo(int[] arrid){
		boolean r = adminDAO.deletecheckboxcombo(arrid);
		return r;
	}
	
	
	/**
	 * 批量删除greatseller
	 */
	public boolean deletecheckboxgreatseller(int[] arrid){
		boolean r = adminDAO.deletecheckboxgreatseller(arrid);
		return r;
	}
	
	/**
	 * 批量删除notice
	 */
	public boolean deletecheckboxnotice(int[] arrid){
		boolean r = adminDAO.deletecheckboxnotice(arrid);
		return r;
	}
	
	/**
	 * 批量删除order
	 */
	public boolean deletecheckboxorder(int[] arrid){
		boolean r = adminDAO.deletecheckboxorder(arrid);
		return r;
	}
	
	/**
	 * 批量删除secgoods
	 */
	public boolean deletecheckboxsecgoods(int[] arrid){
		boolean r = adminDAO.deletecheckboxsecgoods(arrid);
		return r;
	}
	
	/**
	 * 批量删除goods
	 */
	public boolean deletecheckboxgoods(int[] arrid){
		boolean r = adminDAO.deletecheckboxgoods(arrid);
		return r;
	}
	
	/**
	 * 批量删除takeout
	 */
	public boolean deletecheckboxtakeout(int[] arrid){
		boolean r = adminDAO.deletecheckboxtakeout(arrid);
		return r;
	}

	
/*+++++++++++++delete结束++++++++++++++*/
	
	
	
	
	
/*+++++++++++++queryall开始++++++++++++++*/
		
	/**
	 * 找到所有的普通用户
	 */
	public List<User> queryalluser(PageModel page) {
		List<User> list = new ArrayList<User>();
		list = adminDAO.queryalluser(page);
		return list;
	}

	/**
	 * 找到全部商户
	 */
	public List<Seller> queryallseller(PageModel page) {
		List<Seller> list = new ArrayList<Seller>();
		list = adminDAO.queryallseller(page);
		return list;
	}

	/**
	 * 找到全部帮助信息
	 */
	public List<HelpCenter> queryallhelp(PageModel page){
		List<HelpCenter> list = new ArrayList<HelpCenter>();
		list = adminDAO.queryallhelp(page);
		return list;
	}
	
	/**
	 * 找到全部公告
	 */
	public List<Notice> queryallnotice(PageModel page){
		List<Notice> list = new ArrayList<Notice>();
		list = adminDAO.queryallnotice(page);
		return list;
	}
	
	/**
	 * 找到全部商品
	 * 
	 * @return
	 */
	public List<Goods> queryallgoods(PageModel page) {
		List<Goods> list = new ArrayList<Goods>();
		list = adminDAO.queryallgoods(page);
		return list;
	}

	/**
	 * 找到全部套餐
	 */
	public List<Combo> queryallcombo(PageModel page){
		List<Combo> list = new ArrayList<Combo>();
		list = adminDAO.queryallcombo(page);
		return list;
	}
	
	/**
	 * 找到全部二手商品
	 */
	public List<Secondgoods> queryallsecgoods(PageModel page) {
		List<Secondgoods> list = new ArrayList<Secondgoods>();
		list = adminDAO.queryallsecgoods(page);
		return list;
	}
	
	/**
	 * 找到全部外卖
	 */
	public List<Takeout> queryalltakeout(PageModel page){
		List<Takeout> list = new ArrayList<Takeout>();
		list = adminDAO.queryalltakeout(page);
		return list;
	}

	/**
	 * 找到所有推荐商家
	 * 
	 * @return
	 */
	public List<Greatseller> queryallgreatseller(PageModel page) {
		List<Greatseller> list = new ArrayList<Greatseller>();
		list = adminDAO.queryallgreatseller(page);
		return list;
	}

	/**
	 * 找到所有订单
	 * 
	 * @return
	 */
	public List<Order> queryallorder(PageModel page) {
		System.out.print("serviceorder");
		List<Order> list = new ArrayList<Order>();
		list = adminDAO.queryallorder(page);
		return list;
	}

	
/*+++++++++++++queryall结束++++++++++++++*/
	
	
	
	
/*+++++++++++++find开始++++++++++++++*/
	
	/**
	 * 根据id找到用户 并且返回一个user对象
	 */
	public User finduserbyid(int id) {
		User user = new User();
		user = adminDAO.finduserbyid(id);
		return user;
	}
	
	/**
	 * 根据id找到商家 并且返回一个seller对象
	 */
	public Seller findsellerbyid(int id) {
		Seller seller = new Seller();
		seller = adminDAO.findsellerbyid(id);
		return seller;
	}
	
	/**
	 * 根据id找到商家 并且返回一个seller对象
	 */
	public Seller findsellerbyname(String name) {
		Seller seller = new Seller();
		seller = adminDAO.findsellerbyname(name);
		return seller;
	}

	/**
	 * 根据id找到help信息，并返回一个helpcenter对象
	 */
	public HelpCenter findhelpbyid(int id){
		HelpCenter help = new HelpCenter();
		help = adminDAO.findhelpbyid(id);
		return help;
	}
	
	/**
	 * 根据id找到商品 并且返回一个goods对象
	 */
	public Keyword findkeywordbyid(Integer id){
		Keyword keyword = new Keyword();
		keyword = adminDAO.findkeywordbyid(id);
		return keyword;
	}
	
	/**
	 * 根据id找到notice信息，并返回一个notice对象
	 */
	public Notice findnoticebyid(int id){
		Notice notice = new Notice();
		notice = adminDAO.findnoticebyid(id);
		return notice;
	}
	
	/**
	 * 根据id找到商品 并且返回一个goods对象
	 */
	public Goods findgoodsbyid(Integer id) {
		Goods goods = new Goods();
		goods = adminDAO.findgoodsbyid(id);
		return goods;
	}
	
	/**
	 * 根据id找到套餐 并且返回一个combo对象
	 */
	public Combo findcombobyid(Integer id){
		Combo combo = new Combo();
		combo = adminDAO.findcombobyid(id);
		return combo;
	}
	
	
	/**
	 * 根据id找到二手商品 并且返回一个secondgoods对象
	 */
	public Secondgoods findsecgoodsbyid(int id){
		Secondgoods secondgoods = new Secondgoods();
		secondgoods = adminDAO.findsecgoodsbyid(id);
		return secondgoods;
	}
	
	/**
	 * 根据id找到外卖 并且返回一个takeout对象
	 */
	public Takeout findtakeoutbyid(int id){
		Takeout takeout = new Takeout();
		takeout = adminDAO.findtakeoutbyid(id);
		return takeout;
	}

	/**
	 * 根据id找到推荐商家 并且返回一个greatseller对象
	 */
	public Greatseller findgreatsellerbyid(Integer id) {
		Greatseller greatseller = new Greatseller();
		greatseller = adminDAO.findgreatsellerbyid(id);
		return greatseller;
	}
	
	/**
	 * 根据id找到订单 并且返回一个order对象
	 */
	public Order findorderbyid(int id) {
		Order order = new Order();
		order = adminDAO.findorderbyid(id);
		return order;
	}
	


	
	/**
	 * 查找指定用户返回list（）
	 */
	public List<User> finduserspecial(String username) {
		System.out.println("servicefind start");
		List<User> userlist = new ArrayList<User>();
		userlist = adminDAO.finduserspecial(username);
		return userlist;
	}

	/**
	 * 查找指定商家返回list（）
	 */
	public List<Seller> findsellerspecial(String username) {
		System.out.println("servicefind start");
		List<Seller> sellerlist = new ArrayList<Seller>();
		sellerlist = adminDAO.findsellerspecial(username);
		return sellerlist;
	}

	/**
	 * 查找帮助信息返回list
	 */
	public List<HelpCenter> findhelpspecial(String title){
		List<HelpCenter> list = new ArrayList<HelpCenter>();
		list = adminDAO.findhelpspecial(title);
		return list;
	}

	/**
	 * 查找公告返回list
	 */
	public List<Notice> findnoticespecial(String title){
		List<Notice> list = new ArrayList<Notice>();
		list = adminDAO.findnoticespecial(title);
		return list;
	}
	
	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Goods> findgoodsspecial(String goodsname, Integer suptypeid,
			Integer subtypeid) {
		List<Goods> goodslist = new ArrayList<Goods>();
		goodslist = adminDAO.findgoodsspecial(goodsname, suptypeid, subtypeid);
		return goodslist;
	}
	
	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Combo> findcombospecial(String goodsname){
		List<Combo> combolist = new ArrayList<Combo>();
		combolist = adminDAO.findcombospecial(goodsname);
		return combolist;
	}
	
	/**
	 * 查找二手商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Secondgoods> findsecgoodsspecial(String goodsname, Integer suptypeid,
			Integer subtypeid){
		List<Secondgoods> list = new ArrayList<Secondgoods>();
		list = adminDAO.findsecgoodsspecial(goodsname, suptypeid, subtypeid);
		return list;
		
	}
	
	/**
	 * 查找外卖返回list
	 * 
	 * @param goodsname,suptypeid,subtypeid
	 * @return
	 */
	public List<Takeout> findtakeoutspecial(String goodsname, Integer suptypeid,
			Integer subtypeid){
				List<Takeout> list = new ArrayList<Takeout>();
				list = adminDAO.findtakeoutspecial(goodsname, suptypeid, subtypeid);
				return list;
				
			}

	/**
	 * 查找推荐商家返回list
	 * 
	 * @param name
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Greatseller> findgreatsellerspecial(String name,
			Integer suptypeid, Integer subtypeid) {
		List<Greatseller> greatsellerlist = new ArrayList<Greatseller>();
		greatsellerlist = adminDAO.findgreatsellerspecial(name, suptypeid,
				subtypeid);
		return greatsellerlist;
	}

	/**
	 * 根据订单id找到订单下的商品 并且返回一个order_detail对象list
	 */
	public List<Order_detail> findorderdetailbyid(Integer id){
		List<Order_detail> orederdetaillist = new ArrayList<Order_detail>();
		orederdetaillist=adminDAO.findorderdetailbyid(id);
		return orederdetaillist;
	}
	
	/**
	 * 根据username和isclosed找到order
	 */
	public List<Order> findorderspecial(String username,Integer isclosed) {
		System.out.println("servicefind start");
		List<Order> orderlist = new ArrayList<Order>();
		orderlist = adminDAO.findorderspecial(username,isclosed);
		return orderlist;
	}
	
/*+++++++++++++find结束++++++++++++++*/
	
	
/*+++++++++++++alter开始++++++++++++++*/
	
	/**
	 * 修改用户信息
	 */
	public List<User> alteruser(Integer id, String username, String password,
			String telephone, String alipaynum, String email, String author,
			String address, String nickname, String qq, String renren,
			String weibo, String sex, String school,String living) {
		List<User> list = new ArrayList<User>();
		list = adminDAO.alteruser(id, username, password,telephone, alipaynum, email,
				author,  address, nickname, qq, renren, weibo, sex,school,living);
		return list;
	}

	/**
	 * 修改商家信息
	 */
	public List<Seller> alterseller(Integer id, String username,
			String password, String name, String telephone, String email,
			String alipaynum, String identification, String address,
			String savepath, String author, String content, String reason) {
		List<Seller> list = new ArrayList<Seller>();
		list = adminDAO.alterseller(id, username, password, name, telephone,
				email, alipaynum, identification, address, savepath, author,
				content, reason);
		return list;
	}

	/**
	 * 修改help内容
	 */
	public List<HelpCenter> alterhelp(int id,String title,String content){
		List<HelpCenter> list = new ArrayList<HelpCenter>();
		list = adminDAO.alterhelp(id, title, content);
		return list;
	}
	
	/**
	 * 修改keyword内容
	 */
	public List<Keyword> alterkeyword(int id,String title){
		List<Keyword> list = new ArrayList<Keyword>();
		list = adminDAO.alterkeyword(id, title);
		return list;
	}
	
	/**
	 * 修改notice内容
	 */
	public List<Notice> alternotice(int id,String title,String content){
		List<Notice> list = new ArrayList<Notice>();
		list = adminDAO.alternotice(id, title, content);
		return list;
	}
	
	/**
	 * 修改商品信息
	 */
	public List<Goods> altergoods(Integer id, Integer suptypeid,
			Integer subtypeid,Integer indexx, String goodsname, String introduce,
			double price, double nowprice, String savepath,String savepath1,String savepath2,String savepath3, Integer newgoods,
			Integer hot, Integer special, Integer health, Integer recommend, String shelves ,Integer monthsell , Integer zan , String reason, Integer inventory) {
		List<Goods> goods = new ArrayList<Goods>();
		System.out.println("adminServiceimpl indexx"+indexx);
		goods = adminDAO.altergoods(id, suptypeid, subtypeid, indexx,goodsname,
				introduce, price, nowprice, savepath,savepath1, savepath2, savepath3, newgoods, hot, special,
				health, recommend , shelves , monthsell , zan  , reason , inventory);
		return goods;
	}

	/**
	 * 修改套餐信息
	 */
	public List<Combo> altercombo(Integer id,  String goodsname, String introduce,double price, double nowprice, String savepath,String savepath1,String savepath2,String savepath3,
			String shelves ,Integer monthsell , Integer zan , String reason , Integer inventory) {
				List<Combo> combo = new ArrayList<Combo>();
				System.out.println("adminServiceimpl");
				combo = adminDAO.altercombo(id, goodsname,
						introduce, price, nowprice, savepath,savepath1, savepath2, savepath3, shelves , monthsell , zan , reason , inventory);
				return combo;
			}
	
	
	/**
	 * 修改二手商品信息
	 */
	public List<Secondgoods> altersecgoods(Integer id,Integer userid,String username,String nickname,  Integer suptypeid,
			Integer subtypeid, String goodsname, String introduce,
			double price, double nowprice, String savepath,String savepath1,String savepath2,String savepath3,  Integer newgoods,
			Integer hot, Integer special, Integer health, Integer recommend , String shelves, String qq , String telephone ,
			String other , String reason , Integer recency, String school,String living) {
		List<Secondgoods> list = new ArrayList<Secondgoods>();
		list = adminDAO.altersecgoods(id,userid,username, nickname, suptypeid, subtypeid, goodsname,
				introduce, price, nowprice, savepath,savepath1, savepath2, savepath3, newgoods, hot, special,
				health, recommend , shelves, qq , telephone , other , reason , recency , school , living);
		return list;
	}
	
	 /**
	 * 修改外卖信息
		 */
	public List<Takeout> altertakeout(Integer id,Integer sellerid,String sellername, Integer suptypeid,
					Integer subtypeid, String goodsname, String introduce,
					double price, double nowprice, String savepath,String savepath1,String savepath2,String savepath3, 
					Integer newgoods,Integer hot, Integer special, Integer health, Integer recommend , String shelves , String reason){
						List<Takeout> list = new ArrayList<Takeout>();
						list = adminDAO.altertakeout(id, sellerid,sellername,suptypeid, subtypeid, goodsname,
								introduce, price, nowprice, savepath,savepath1, savepath2, savepath3, newgoods, hot, special,
								health, recommend , shelves  , reason);
						return list;
					}
	
	/**
	 * 修改推荐商家信息
	 */
	public List<Greatseller> altergreatseller(Integer id, Integer suptypeid,
			Integer subtypeid, String name, String content, String telephone,
			String savepath, String savepath1,String savepath2,String savepath3, 
			String address, String url , String shelves) {
		List<Greatseller> greatseller = new ArrayList<Greatseller>();
		System.out.println("adminServiceimpl");
		greatseller = adminDAO.altergreatseller(id, suptypeid, subtypeid, name,
				content, telephone, savepath,savepath1, savepath2, savepath3, address, url , shelves);
		return greatseller;
	}

	/**
	 *修改订单详情
	 */
	public List<Order> alterorderdetail(List<Order_detail> list_detail){
		List<Order> list = new ArrayList<Order>();
		list = adminDAO.alterorderdetail(list_detail);
		return list;
	}
	
	/**
	 * 修改订单信息
	 */
	public List<Order> alterorder(int id, int orderNo, String arrivedday,
			String arrivedtime, double totalamount, String username,
			String truename, String telephone, String school, String doorplate,
			String room, String remark, String payway, int isclosed) {
		List<Order> list = new ArrayList<Order>();
		list = adminDAO.alterorder(id, orderNo, arrivedday, arrivedtime,
				totalamount, username, truename, telephone, school, doorplate,
				room, remark, payway, isclosed);
		return list;
	}
	
	/**
	 * 修改admin密码
	 */
	public boolean alteradmin(String username, String password,String nowpassword){
		boolean r = adminDAO.alteradmin(username, password, nowpassword);
		return r;
	}
	
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean upjia(int[] checkout){
		boolean r = adminDAO.upjia(checkout);
		return r;
	}
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean downjia(int[] checkout){
		boolean r = adminDAO.downjia(checkout);
		return r;
	}
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean comboupjia(int[] checkout){
		boolean r = adminDAO.comboupjia(checkout);
		return r;
	}
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean combodownjia(int[] checkout){
		boolean r = adminDAO.combodownjia(checkout);
		return r;
	}
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean secupjia(int[] checkout){
		boolean r = adminDAO.secupjia(checkout);
		return r;
	}
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean secdownjia(int[] checkout){
		boolean r = adminDAO.secdownjia(checkout);
		return r;
	}
	
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean takeupjia(int[] checkout){
		boolean r = adminDAO.takeupjia(checkout);
		return r;
	}
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean takedownjia(int[] checkout){
		boolean r = adminDAO.takedownjia(checkout);
		return r;
	}
	
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean greatsellerupjia(int[] checkout){
		boolean r = adminDAO.greatsellerupjia(checkout);
		return r;
	}
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean greatsellerdownjia(int[] checkout){
		boolean r = adminDAO.greatsellerdownjia(checkout);
		return r;
	}
	
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean orderupjia(int[] checkout){
		boolean r = adminDAO.orderupjia(checkout);
		return r;
	}
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean orderdownjia(int[] checkout){
		boolean r = adminDAO.orderdownjia(checkout);
		return r;
	}
	
/*+++++++++++++alter结束++++++++++++++*/
	
	
	
/*+++++++++++++showsubtype开始++++++++++++++*/
	
	
	/**
	 * 查找所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Goods_subtype> showsubtype() {
		List<Goods_subtype> list = new ArrayList<Goods_subtype>();
		list = adminDAO.showsubtype();
		return list;
	}
	
	/**
	 * 查找所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Goods_subtype> showsubtype1(Integer suptypeid) {
		List<Goods_subtype> list = new ArrayList<Goods_subtype>();
		list = adminDAO.showsubtype1(suptypeid);
		return list;
	}

	/**
	 * 查找二手商品所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Secondgoods_subtype> showsecsubtype() {
		List<Secondgoods_subtype> list = new ArrayList<Secondgoods_subtype>();
		list = adminDAO.showsecsubtype();
		return list;
	}
	
	/**
	 * 查找二手商品所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Secondgoods_subtype> showsecsubtype1(Integer suptypeid) {
		List<Secondgoods_subtype> list = new ArrayList<Secondgoods_subtype>();
		list = adminDAO.showsecsubtype1(suptypeid);
		return list;
	}

	/**
	 * 查找外卖所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Takeout_subtype> showtakeoutsubtype(){
		List<Takeout_subtype> list = new ArrayList<Takeout_subtype>();
		list = adminDAO.showtakeoutsubtype();
		return list;
	}
	
	/**
	 * 查找外卖所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Takeout_subtype> showtakeoutsubtype1(Integer suptypeid){
		List<Takeout_subtype> list = new ArrayList<Takeout_subtype>();
		list = adminDAO.showtakeoutsubtype1(suptypeid);
		return list;
	}
	
	/**
	 * 查找所有推荐商家子类分类返回list
	 * 
	 * @return
	 */
	public List<Greatseller_subtype> showgreatsellersubtype() {
		List<Greatseller_subtype> list = new ArrayList<Greatseller_subtype>();
		list = adminDAO.showgreatsellersubtype();
		return list;
	}
	
	/**
	 * 查找所有推荐商家子类分类返回list
	 * 
	 * @return
	 */
	public List<Greatseller_subtype> showgreatsellersubtype1(Integer suptypeid) {
		List<Greatseller_subtype> list = new ArrayList<Greatseller_subtype>();
		list = adminDAO.showgreatsellersubtype1(suptypeid);
		return list;
	}
	
	
	/*+++++++++++++showsubtype结束++++++++++++++*/	
	
	
	
	/*+++++++++++++showsuptype开始++++++++++++++*/
		
	
	/**
	 * 查找所有父类分类返回list
	 * 
	 * @return
	 */
	public List<Goods_supertype> showsuptype() {
		List<Goods_supertype> list = new ArrayList<Goods_supertype>();
		list = adminDAO.showsuptype();
		return list;
	}

	/**
	 * 查找二手商品所有父类分类返回list
	 * 
	 * @return
	 */
	public List<Secondgoods_supertype> showsecsuptype() {
		List<Secondgoods_supertype> list = new ArrayList<Secondgoods_supertype>();
		list = adminDAO.showsecsuptype();
		return list;
	}

	/**
	 * 查找外卖所有父类分类返回list
	 * 
	 * @return
	 */
	public List<Takeout_supertype> showtakeoutsuptype(){
		List<Takeout_supertype> list = new ArrayList<Takeout_supertype>();
		list = adminDAO.showtakeoutsuptype();
		return list;
	}

	/**
	 * 查找所有推荐商家父类分类返回list
	 * 
	 * @return
	 */
	public List<Greatseller_supertype> showgreatsellersuptype() {
		List<Greatseller_supertype> list = new ArrayList<Greatseller_supertype>();
		list = adminDAO.showgreatsellersuptype();
		return list;
	}
	
/*+++++++++++++showsuptype结束++++++++++++++*/	
	
/**
 * getter and setter
 * @return
 */

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public SellerDAO getSellerDAO() {
		return sellerDAO;
	}

	public void setSellerDAO(SellerDAO sellerDAO) {
		this.sellerDAO = sellerDAO;
	}
}
