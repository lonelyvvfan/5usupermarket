package cs.service;

import java.util.ArrayList;
import java.util.List;

import cs.dao.AdminDAO;
import cs.dao.OrderDAO;
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

public class OrderServiceImpl implements OrderService {
	private OrderDAO orderDAO;

	/**
	 * 根据id找到help信息，并返回一个helpcenter对象
	 */
	public HelpCenter findhelpbyid(int id){
		HelpCenter help = new HelpCenter();
		help = orderDAO.findhelpbyid(id);
		return help;
	}
	
	/**
	 * 根据id找到notice信息，并返回一个notice对象
	 */
	public Notice findnoticebyid(int id){
		Notice notice = new Notice();
		notice = orderDAO.findnoticebyid(id);
		return notice;
	}

	/**
	 * 增加订单
	 */
	public Order addorder(String arrivedday, String arrivedtime,
			double totalamount, String username, String truename,
			String telephone, String school, String living, String doorplate, String room,
			String remark, String payway, int isclosed, String orderday , String other_address) {
		Order order = new Order();
		order = orderDAO.addorder(arrivedday, arrivedtime, totalamount,
				username, truename, telephone, school, living, doorplate, room, remark,
				payway, isclosed , orderday , other_address);
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
		list = orderDAO.addorder1(arrivedday, arrivedtime, totalamount,
				username, truename, telephone, school, doorplate, room, remark,
				payway, isclosed);
		return list;
	}
	
	/**
	 * 增加订单详情
	 */
	public List<Order> addorderdetail(List<Order_detail> list,Integer id){
		List<Order> orderlist = new ArrayList<Order>();
		orderlist = orderDAO.addorderdetail1(list,id);
		return orderlist;
	}

	/**
	 * 统计商品营业额
	 * @param goodsname
	 * @param startdate
	 * @param enddate
	 * @param isclosed
	 * @return
	 */
	public List<Order_detail> goodscount(String goodsname,String startdate,String enddate,Integer isclosed){
		System.out.print("serviceorder");
		List<Order_detail> goodscountlist = new ArrayList<Order_detail>();
		goodscountlist = orderDAO.goodscount(goodsname, startdate, enddate, isclosed);
		return goodscountlist;
	}
	
	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
/*+++++++++++++add结束++++++++++++++*/
	
	
	
}