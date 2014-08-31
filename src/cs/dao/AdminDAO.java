package cs.dao;

import java.util.List;

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

public interface AdminDAO {
/*+++++++++++++login开始++++++++++++++*/
	/**
	 * 根据username找到管理员
	 */
	public Admin queryuserbyusername(String username);

/*+++++++++++++login结束++++++++++++++*/
	
/*+++++++++++++add开始++++++++++++++*/
	
	/**
	 * 增加外卖商家分类
	 */
	public void addsellertype(Integer suptypeid,Integer subtypeid,String name,String savepath,Integer sellerid,String reason);
	
	/**
	 * 增加用户
	 */
	public List<User> adduser( String username, String password,
			String telephone, String alipaynum, String email, String author,
			String address, String nickname, String qq, String renren,
			String weibo, String sex, String school,String living);

	/**
	 * 增加商户
	 */
	public List<Seller> addseller(String username, String password,
			String name, String telephone, String address, String email,
			String alipaynum, String identification, String savepath,
			String author, String content, String reason);

	/**
	 * 增加帮助信息
	 */
	public List<HelpCenter> addhelp(String title,String content);
	
	
	/**
	 * 增加帮助信息
	 */
	public List<Keyword> addkeyword(String title);
	
	/**
	 * 增加公告
	 */
	public List<Notice> addnotice(String title,String content);

	
	/**
	 * 增加商品
	 */
	public List<Goods> addgoods(Integer suptypeid, Integer subtypeid,Integer indexx,
			String goodsname, String introduce, double price, double nowprice,
			String savepath, String savepath1, String savepath2,String savepath3, Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend , String shelves,Integer monthsell , Integer zan, String reason, Integer inventory);
	
	/**
	 * 增加套餐
	 */
	public List<Combo> addcombo(String goodsname, String introduce,double price,double nowprice, String savepath, String savepath1,
			String savepath2,String savepath3,String shelves ,Integer monthsell , Integer zan , String reason, Integer inventory);
	
	/**
	 * 增加二手商品
	 */
	public List<Secondgoods> addsecgoods(Integer userid,String username,String nickname,Integer suptypeid, Integer subtypeid,
			String goodsname, String introduce, double price, double nowprice,
			String savepath, String savepath1, String savepath2,String savepath3, Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend , String shelves, String qq , String telephone ,  String other, String reason, Integer recency, String school,String living);
	
	/**
	 * 增加外卖
	 */
	public List<Takeout> addtakeout(Integer sellerid,String sellername,Integer suptypeid, Integer subtypeid,
			String goodsname, String introduce, double price, double nowprice,
			String savepath, String savepath1, String savepath2,String savepath3, Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend , String shelves, String reason);

	
	/**
	 * 增加推荐商家
	 */
	public List<Greatseller> addgreatseller(Integer suptypeid,
			Integer subtypeid, String name, String content, String telephone,
			String savepath,  String savepath1, String savepath2,String savepath3,String address, String url , String shelves);

	/**
	 * 增加订单
	 */
	public Order addorder(String arrivedday, String arrivedtime,
			double totalamount, String username, String truename,
			String telephone, String school, String doorplate, String room,
			String remark, String payway, int isclosed);
	
	/**
	 * 增加订单
	 */
	public List<Order> addorder1(String arrivedday, String arrivedtime,
			double totalamount, String username, String truename,
			String telephone, String school, String doorplate, String room,
			String remark, String payway, int isclosed);

	/**
	 * 增加订单详情
	 */
	public List<Order> addorderdetail(List<Order_detail> list,Integer id);
	
/*+++++++++++++add结束++++++++++++++*/
	
	
	
	
/*+++++++++++++delete开始++++++++++++++*/
	/**
	 * 根据sellerid删除sellertyoe
	 */
	public boolean deletesellertype(Integer id);
	
	/**
	 * 根据id删除用户
	 */
	public boolean deleteuserbyid(int id);

	/**
	 * 根据id删除商家
	 */
	public boolean deletesellerbyid(int id);


	/**
	 * 根据id删除帮助信息
	 */
	public boolean deletehelpbyid(int id);
	
	
	/**
	 * 根据id删除帮助信息
	 */
	public boolean deletekeywordbyid(int id);
	
	/**
	 * 根据id删除公告
	 */
	public boolean deletenoticebyid(int id);
	
	
	
	/**
	 * 根据id删除商品
	 */
	public boolean deletegoodsbyid(int id);

	/**
	 * 根据id删除套餐
	 */
	public boolean deletecombobyid(int id);
	
	/**
	 * 根据id删除二手商品
	 */
	public boolean deletesecgoodsbyid(int id);

	/**
	 * 根据id删除外卖
	 */
	public boolean deletetakeoutbyid(int id);

	
	/**
	 * 根据id删除推荐商家
	 */
	public boolean deletegreatsellerbyid(int id);

	/**
	 * 根据id删除订单
	 */
	public boolean deleteorderbyid(int id);
	/**
	 * 根据id删除订单详情
	 */
	public boolean deleteorderdetailbyid(int id);
	
	/**
	 * 批量删除user
	 */
	public boolean deletecheckbox(int[] arrid);
	
	
	/**
	 * 批量删除seller
	 */
	public boolean deletecheckboxseller(int[] arrid);
	
	/**
	 * 批量删除combo
	 */
	public boolean deletecheckboxcombo(int[] arrid);
	
	/**
	 * 批量删除combo
	 */
	public boolean deletecheckboxgreatseller(int[] arrid);
	
	/**
	 * 批量删除notice
	 */
	public boolean deletecheckboxnotice(int[] arrid);
	
	/**
	 * 批量删除order
	 */
	public boolean deletecheckboxorder(int[] arrid);
	
	/**
	 * 批量删除secgoods
	 */
	public boolean deletecheckboxsecgoods(int[] arrid);
	
	/**
	 * 批量删除goods
	 */
	public boolean deletecheckboxgoods(int[] arrid);
	
	/**
	 * 批量删除takeout
	 */
	public boolean deletecheckboxtakeout(int[] arrid);
	
	
/*+++++++++++++delete结束++++++++++++++*/
	
	
	
	
	
/*+++++++++++++queryall开始++++++++++++++*/
	
	
	/**
	 * 找到全部普通用户
	 */
	public List<User> queryalluser(PageModel page);


	
	/**
	 * 找到全部商户
	 */
	public List<Seller> queryallseller(PageModel page);

	/**
	 * 找到全部帮助信息
	 */
	public List<HelpCenter> queryallhelp(PageModel page);
	
	/**
	 * 找到全部帮助信息
	 */
	public List<Keyword> queryallkeyword(PageModel page);
	
	/**
	 * 找到全部公告
	 */
	public List<Notice> queryallnotice(PageModel page);
	
	
	/**
	 * 找到全部商品
	 */
	public List<Goods> queryallgoods(PageModel page);

	/**
	 * 找到全部商品
	 */
	public List<Combo> queryallcombo(PageModel page);

	
	/**
	 * 找到全部二手商品
	 */
	public List<Secondgoods> queryallsecgoods(PageModel page);

	/**
	 * 找到全部外卖
	 */
	public List<Takeout> queryalltakeout(PageModel page);

	
	/**
	 * 找到全部推荐商家
	 */
	public List<Greatseller> queryallgreatseller(PageModel page);

	/**
	 * 找到全部订单
	 */
	public List<Order> queryallorder(PageModel page);


/*+++++++++++++queryall结束++++++++++++++*/
	
	
	
	
/*+++++++++++++find开始++++++++++++++*/
	
	
	/**
	 * 根据id找到用户 并且返回一个user对象
	 */
	public User finduserbyid(int id);
	
	/**
	 * 根据id找到用户 并且返回一个seller对象
	 */
	public Seller findsellerbyid(int id);
	
	/**
	 * 根据id找到用户 并且返回一个seller对象
	 */
	public Seller findsellerbyname(String name);

	/**
	 * 根据id找到help 并且返回一个helpcenter对象
	 */
	public HelpCenter findhelpbyid(int id);
	
	/**
	 * 根据id找到help 并且返回一个helpcenter对象
	 */
	public Keyword findkeywordbyid(Integer id);
	
	/**
	 * 根据id找到notice信息，并返回一个notice对象
	 */
	public Notice findnoticebyid(int id);
	
	
	/**
	 * 根据id找到商品 并且返回一个goods对象
	 */
	public Goods findgoodsbyid(int id);

	/**
	 * 根据id找到套餐 并且返回一个combo对象
	 */
	public Combo findcombobyid(int id);
	
	/**
	 * 根据id找到二手商品 并且返回一个secondgoods对象
	 */
	public Secondgoods findsecgoodsbyid(int id);

	/**
	 * 根据id找到外卖 并且返回一个takeout对象
	 */
	public Takeout findtakeoutbyid(int id);
	
	/**
	 * 根据id找到推荐商家 并且返回一个greatseller对象
	 */
	public Greatseller findgreatsellerbyid(Integer id);
	
	/**
	 * 根据orderno找到订单 并且返回一个order对象
	 */
	public Order findorderbyorderno(Integer orderNo);
	
	/**
	 * 根据id找到订单 并且返回一个order对象
	 */
	public Order findorderbyid(int id);
	


	/**
	 * 查找用户返回list
	 * 
	 * @param username
	 * @return
	 */
	public List<User> finduserspecial(String username);

	/**
	 * 查找商家返回list
	 * 
	 * @param username
	 * @return
	 */
	public List<Seller> findsellerspecial(String username);
	
	/**
	 * 查找帮助信息返回list
	 */
	public List<HelpCenter> findhelpspecial(String title);

	/**
	 * 查找公告返回list
	 */
	public List<Notice> findnoticespecial(String title);

	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Goods> findgoodsspecial(String goodsname, Integer suptypeid,
			Integer subtypeid);

	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 * @return
	 */
	public List<Combo> findcombospecial(String goodsname);
	
	/**
	 * 查找二手商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Secondgoods> findsecgoodsspecial(String goodsname, Integer suptypeid,
			Integer subtypeid);

	/**
	 * 查找外卖返回list
	 * 
	 * @param goodsname,suptypeid,subtypeid
	 * @return
	 */
	public List<Takeout> findtakeoutspecial(String goodsname, Integer suptypeid,
			Integer subtypeid);

	/**
	 * 查找推荐商家返回list
	 * 
	 * @param name
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Greatseller> findgreatsellerspecial(String name,
			Integer suptypeid, Integer subtypeid);

	/**
	 *查找订单返回list 
	 * @param username
	 * @param isclosed
	 * @return
	 */	
	public List<Order> findorderspecial(String username,Integer isclosed);
	
	/**
	 * 根据订单id找到订单下的商品 并且返回一个order_detail对象list
	 */
	public List<Order_detail> findorderdetailbyid(Integer id);
	

/*+++++++++++++find结束++++++++++++++*/
	
	
	
/*+++++++++++++alter开始++++++++++++++*/

	/**
	 * 修改用户
	 */
	public List<User> alteruser(Integer id, String username, String password,
			String telephone, String alipaynum, String email, String author,
			String address, String nickname, String qq, String renren,
			String weibo, String sex, String school,String living);

	/**
	 * 修改商家信息
	 */
	public List<Seller> alterseller(Integer id, String username,
			String password, String name, String telephone, String email,
			String alipaynum, String identification, String address,
			String savepath, String author, String content, String reason);
	
	/**
	 * 修改帮助中心内容
	 */
	public List<HelpCenter> alterhelp(int id,String title,String content);
	
	/**
	 * 修改keyword内容
	 */
	public List<Keyword> alterkeyword(int id,String title);

	/**
	 * 修改notice内容
	 */
	public List<Notice> alternotice(int id,String title,String content);

	
	/**
	 * 修改商品信息
	 */
	public List<Goods> altergoods(Integer id, Integer suptypeid,
			Integer subtypeid, Integer indexx,String goodsname, String introduce,
			double price, double nowprice, String savepath,String savepath1,String savepath2,String savepath3, Integer newgoods,
			Integer hot, Integer special, Integer health, Integer recommend, String shelves ,Integer monthsell , Integer zan, String reason, Integer inventory);
	
	/**
	 * 修改套餐信息
	 */
	public List<Combo> altercombo(Integer id,String goodsname, String introduce,double price, double nowprice, String savepath, 
			String savepath1, String savepath2,String savepath3,String shelves ,Integer monthsell , Integer zan , String reason, Integer inventory);
	
	/**
	 * 修改二手商品信息
	 */
	 public List<Secondgoods> altersecgoods(Integer id,Integer userid,String username,String nickname,  Integer suptypeid,
				Integer subtypeid, String goodsname, String introduce,
				double price, double nowprice, String savepath,String savepath1,String savepath2,String savepath3, Integer newgoods,
				Integer hot, Integer special, Integer health, Integer recommend, String shelves, String qq , String telephone ,  String other, String reason , Integer recency, String school,String living);

	 /**
	 * 修改外卖信息
	 */
	 public List<Takeout> altertakeout(Integer id,Integer sellerid,String sellername, Integer suptypeid,
				Integer subtypeid, String goodsname, String introduce,
				double price, double nowprice, String savepath,String savepath1,String savepath2,String savepath3, Integer newgoods,
				Integer hot, Integer special, Integer health, Integer recommend, String shelves, String reason);
	 
	/**
	 * 修改推荐商家信息
	 */
	public List<Greatseller> altergreatseller(Integer id, Integer suptypeid,
			Integer subtypeid, String name, String content, String telephone,
			String savepath,String savepath1,String savepath2,String savepath3, String address, String url, String shelves);

	/**
	 *修改订单信息
	 */
	public List<Order> alterorder(int id,int orderNo,String arrivedday, String arrivedtime,
			double totalamount, String username, String truename,
			String telephone, String school, String doorplate, String room,
			String remark, String payway, int isclosed);
	
	/**
	 *修改订单详情
	 */
	public List<Order> alterorderdetail(List<Order_detail> list_detail);
	
	/**
	 * 修改admin密码
	 */
	public boolean alteradmin(String username, String password,String nowpassword);
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean upjia(int[] checkout);
	
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean downjia(int[] checkout);
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean comboupjia(int[] checkout);
	
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean combodownjia(int[] checkout);
	
	
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
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean takeupjia(int[] checkout);
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean takedownjia(int[] checkout);
	
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean greatsellerupjia(int[] checkout);
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean greatsellerdownjia(int[] checkout);
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean orderupjia(int[] checkout);
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean orderdownjia(int[] checkout);
	
	
/*+++++++++++++alter结束++++++++++++++*/
	
	
	
	
/*+++++++++++++showsubtype开始++++++++++++++*/
	/**
	 * 查找二手商品所有子类分类返回list
	 * @return
	 */
	public List<Secondgoods_subtype> showsecsubtype1(Integer suptypeid);
	/**
	 * 查找所有子类分类返回list
	 * @return
	 */
	public List<Goods_subtype> showsubtype1(Integer suptypeid);
	/**
	 * 查找所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Goods_subtype> showsubtype();

	/**
	 * 查找二手商品所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Secondgoods_subtype> showsecsubtype();

	/**
	 * 查找外卖所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Takeout_subtype> showtakeoutsubtype();

	
	/**
	 * 查找推荐商家所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Greatseller_subtype> showgreatsellersubtype();
	
	/**
	 * 查找推荐商家所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Greatseller_subtype> showgreatsellersubtype1(Integer suptypeid);

	/**
	 * 查找外卖所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Takeout_subtype> showtakeoutsubtype1(Integer suptypeid);

/*+++++++++++++showsubtype结束++++++++++++++*/	
	
	
	
/*+++++++++++++showsuptype开始++++++++++++++*/
	
	/**
	 * 查找所有父类分类返回list
	 * 
	 * @return
	 */
	public List<Goods_supertype> showsuptype();

	/**
	 * 查找二手商品所有父类分类返回list
	 * 
	 * @return
	 */
	public List<Secondgoods_supertype> showsecsuptype();


	/**
	 * 查找外卖所有父类分类返回list
	 * 
	 * @return
	 */
	public List<Takeout_supertype> showtakeoutsuptype();
	
	/**
	 * 查找推荐商家所有父类分类返回list
	 * 
	 * @return
	 */
	public List<Greatseller_supertype> showgreatsellersuptype();

	
/*+++++++++++++showsuptype结束++++++++++++++*/	
}
