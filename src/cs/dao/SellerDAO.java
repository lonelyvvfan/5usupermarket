package cs.dao;

import java.util.List;

import cs.entity.Seller;
import cs.entity.Takeout;
import cs.entity.Takeout_subtype;
import cs.entity.Takeout_supertype;
import cs.entity.User;
import cs.vo.PageModel;
import cs.vo.UserPage;

public interface SellerDAO {
	/**
	 *  通过用户名查找外卖商家
	 */
	public Seller querysellerbyusername(String username);
	
	/**
	 * 根据id找到商家 并且返回一个seller对象
	 */
	public Seller findsellerbyid(int id);
	
	/**
	 * 修改商家信息
	 */
	public Seller alterseller(Integer id, String username,
			String password, String name, String telephone, String email,
			String alipaynum, String identification, String address,
			String savepath, String author, String content, String reason);
	
	/**
	 * 增加外卖
	 */
	public List<Takeout> addtakeout(Integer sellerid,String sellername,Integer suptypeid, Integer subtypeid,
			String goodsname, String introduce, double price, double nowprice,
			String savepath,String savepath1, String savepath2,String  savepath3, Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend, String shelves, String reason);
	
	/**
	 * 根据id找到外卖 并且返回一个list对象
	 */
	public List<Takeout> findtakeoutbyid(int sellerid);
	
	public int findidbyusername(String username);
	
	/**
	 * 根据id删除外卖
	 */
	public boolean deletetakeoutbyid(int id);
	
	
	/**
	 * 批量删除takeout
	 */
	public boolean deletecheckboxtakeout(int[] arrid);
	
	
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
	 * 根据id找到外卖 并且返回一个takeout对象
	 */
	public Takeout findtakeoutbyid1(int id);
	
	/**
	 * 查找外卖返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Takeout> findtakeoutspecial(String goodsname, Integer suptypeid,
			Integer subtypeid);
	
	/**
	 * 修改外卖信息
	 */
	 public List<Takeout> altertakeout(Integer id,Integer sellerid,String sellername, Integer suptypeid,
				Integer subtypeid, String goodsname, String introduce,
				double price, double nowprice, String savepath,String savepath1, String savepath2,String  savepath3, Integer newgoods,
				Integer hot, Integer special, Integer health, Integer recommend, String shelves, String reason);
	 
	 /**
		 * 查找外卖所有子类分类返回list
		 * 
		 * @return
		 */
		public List<Takeout_subtype> showtakeoutsubtype();
		
		/**
		 * 查找外卖所有父类分类返回list
		 * 
		 * @return
		 */
		public List<Takeout_supertype> showtakeoutsuptype();
	
}
