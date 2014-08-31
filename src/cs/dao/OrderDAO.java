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

public interface OrderDAO {
/*+++++++++++++login开始++++++++++++++*/
	
	/**
	 * 根据id找到help 并且返回一个helpcenter对象
	 */
	public HelpCenter findhelpbyid(int id);
	
	
	/**
	 * 根据id找到notice信息，并返回一个notice对象
	 */
	public Notice findnoticebyid(int id);
	
	
	/**
	 * 增加订单
	 */
	public Order addorder(String arrivedday, String arrivedtime,
			double totalamount, String username, String truename,
			String telephone, String school, String living, String doorplate, String room,
			String remark, String payway, int isclosed, String orderday, String other_address);
	
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
	
	/**
	 * 增加订单详情
	 */
	public List<Order> addorderdetail1(List<Order_detail> list,Integer id);
	
/*+++++++++++++add结束++++++++++++++*/
	/**
	 * 根据orderno找到订单 并且返回一个order对象
	 */
	public Order findorderbyorderno(Integer orderNo);
	
	/**
	 * 找到全部订单
	 */
	public List<Order> queryallorder(PageModel page);
	
	/**
	 * 统计商品营业额
	 * @param goodsname
	 * @param startdate
	 * @param enddate
	 * @param isclosed
	 * @return
	 */
	public List<Order_detail> goodscount(String goodsname,String startdate,String enddate,Integer isclosed); 
	
}
