package cs.service;

import java.util.ArrayList;
import java.util.List;

import cs.dao.SellerDAO;
import cs.dao.UserDAO;
import cs.entity.Seller;
import cs.entity.Takeout;
import cs.entity.Takeout_subtype;
import cs.entity.Takeout_supertype;
import cs.entity.User;
import cs.vo.PageModel;

public class SellerServiceImpl implements SellerService{
	private SellerDAO sellerDAO;
	/**
	 *  外卖商家登录验证
	 */
	public boolean login(String username,String password){
		System.out.println(username+"is username in SellerServiceImpl");
		Seller u = sellerDAO.querysellerbyusername(username);
		System.out.println("Enter SellerServiceImpl");
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
	
	public boolean resetpassword(String username , String telephone , String identification){
		Seller u = sellerDAO.querysellerbyusername(username);
		System.out.println("Enter SellerServiceImpl");
		if( u == null ){
			System.out.println("seller is null");
			return false;
		}else{
			if(u.getTelephone().equals(telephone)&&u.getIdentification().equals(identification)){
				System.out.println("check telephone and identification success!");
				return true;
			}else{
				System.out.println("check telephone and identification failed!");
				return false;
			}
		}
	}
	
	
	/**
	 * 根据id找到商家 并且返回一个seller对象
	 */
	public Seller findsellerbyid(int id) {
		Seller seller = new Seller();
		seller = sellerDAO.findsellerbyid(id);
		return seller;
	}
	
	/**
	 * 修改商家信息
	 */
	public Seller alterseller(Integer id, String username,
			String password, String name, String telephone, String email,
			String alipaynum, String identification, String address,
			String savepath, String author, String content, String reason) {
		Seller seller = new Seller();
		seller = sellerDAO.alterseller(id, username, password, name, telephone,
				email, alipaynum, identification, address, savepath, author,
				content,reason);
		return seller;
	}
	
	
	/**
	 * 批量删除takeout
	 */
	public boolean deletecheckboxtakeout(int[] arrid){
		boolean r = sellerDAO.deletecheckboxtakeout(arrid);
		return r;
	}
	
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean takeupjia(int[] checkout){
		boolean r = sellerDAO.takeupjia(checkout);
		return r;
	}
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean takedownjia(int[] checkout){
		boolean r = sellerDAO.takedownjia(checkout);
		return r;
	}
	
	/**
	 * 根据username找到seller
	 */
	public Seller findsellerbyuername(String username){
		Seller u = sellerDAO.querysellerbyusername(username);
		return u;
	}
	
	/**
	 * 根据id找到外卖 并且返回一个takeout对象
	 */
	public Takeout findtakeoutbyid1(int id){
		Takeout takeout = sellerDAO.findtakeoutbyid1(id);
		return takeout;
	}
	
	
	/**
	 * 增加外卖
	 */
	public List<Takeout> addtakeout(Integer sellerid,String sellername,Integer suptypeid, Integer subtypeid,
			String goodsname, String introduce, double price, double nowprice,
			String savepath, String savepath1, String savepath2,String  savepath3, Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend, String shelves, String reason){
		List<Takeout> list = new ArrayList<Takeout>();
		list = sellerDAO.addtakeout(sellerid,sellername,suptypeid, subtypeid, goodsname, introduce,
				price, nowprice, savepath,savepath1, savepath2, savepath3, newgoods, hot, special, health,
				recommend, shelves, reason);
		return list;
	}
	
	/**
	 * 根据id删除外卖
	 */
	public boolean deletetakeoutbyid(int id) {
		boolean r = false;
		r = sellerDAO.deletetakeoutbyid(id);
		return r;
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
				list = sellerDAO.findtakeoutspecial(goodsname, suptypeid, subtypeid);
				return list;
				
			}
	
	/**
	 * 修改外卖信息
		 */
	public List<Takeout> altertakeout(Integer id,Integer sellerid,String sellername, Integer suptypeid,
					Integer subtypeid, String goodsname, String introduce,
					double price, double nowprice, String savepath, String savepath1, String savepath2,String  savepath3, Integer newgoods,
					Integer hot, Integer special, Integer health, Integer recommend, String shelves, String reason){
						List<Takeout> list = new ArrayList<Takeout>();
						list = sellerDAO.altertakeout(id, sellerid,sellername,suptypeid, subtypeid, goodsname,
								introduce, price, nowprice, savepath,savepath1, savepath2, savepath3, newgoods, hot, special,
								health, recommend, shelves, reason);
						return list;
					}
	
	
	
	/**
	 * 根据id找到外卖 并且返回一个list对象
	 */
	public List<Takeout> findtakeoutbyid(int id){
		List<Takeout> list = new ArrayList<Takeout>();
		list = sellerDAO.findtakeoutbyid(id);
		return list;
	}
	
	/**
	 * 查找外卖所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Takeout_subtype> showtakeoutsubtype(){
		List<Takeout_subtype> list = new ArrayList<Takeout_subtype>();
		list = sellerDAO.showtakeoutsubtype();
		return list;
	}
	
	/**
	 * 查找外卖所有父类分类返回list
	 * 
	 * @return
	 */
	public List<Takeout_supertype> showtakeoutsuptype(){
		List<Takeout_supertype> list = new ArrayList<Takeout_supertype>();
		list = sellerDAO.showtakeoutsuptype();
		return list;
	}
	
	public int findidbyusername(String username){
		int id = sellerDAO.findidbyusername(username);
		return id;
	}
	

	public SellerDAO getSellerDAO() {
		return sellerDAO;
	}

	public void setSellerDAO(SellerDAO sellerDAO) {
		this.sellerDAO = sellerDAO;
	}


	
	
}
