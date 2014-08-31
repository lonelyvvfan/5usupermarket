package cs.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import sun.net.www.content.audio.wav;
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
import cs.vo.GoodsPage;
import cs.vo.GreatsellerPage;
import cs.vo.PageModel;
import cs.vo.SellerPage;
import cs.vo.UserPage;

public class OrderDAOImpl implements OrderDAO {
	private SessionFactory sessionFactory;
	
	/**
	 * 根据id找到help 并且返回一个helpcenter对象
	 */
	public HelpCenter findhelpbyid(int id){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				HelpCenter.class);
		criteria.add(Restrictions.eq("id", id));
		HelpCenter help = (HelpCenter) criteria.uniqueResult();
		return help;
	}
	
	/**
	 * 根据id找到notice信息，并返回一个notice对象
	 */
	public Notice findnoticebyid(int id){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Notice.class);
		criteria.add(Restrictions.eq("id", id));
		Notice notice = (Notice) criteria.uniqueResult();
		return notice;
	}
	
	/**
	 * 增加订单
	 */
	public Order addorder(String arrivedday, String arrivedtime,
			double totalamount, String username, String truename,
			String telephone, String school, String living, String doorplate, String room,
			String remark, String payway, int isclosed, String orderday, String other_address){
		SimpleDateFormat df = new SimpleDateFormat("MMddmmss");//设置日期格式
		Order  order = new Order();
		String ram = "" +(int)Math.random()*100;
		order.setOrderNo(Integer.parseInt(df.format(new Date()) + ram));
		int n=order.getOrderNo();
		order.setArrivedday(arrivedday);
		order.setArrivedtime(arrivedtime);
		order.setDoorplate(doorplate);
		order.setIsclosed(isclosed);
		order.setPayway(payway);
		order.setRemark(remark);
		order.setRoom(room);
		order.setSchool(school);
		order.setLiving(living);
		order.setTelephone(telephone);
		order.setTotalamount(totalamount);
		order.setTruename(truename);
		order.setUsername(username);
		order.setOrderday(orderday);
		order.setOther_address(other_address);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(order);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		order=findorderbyorderno(n);
		return order;
	}
	
	/**
	 * 增加订单
	 */
	public List<Order> addorder1(String arrivedday, String arrivedtime,
			double totalamount, String username, String truename,
			String telephone, String school, String doorplate, String room,
			String remark, String payway, int isclosed){
		SimpleDateFormat df = new SimpleDateFormat("MMddmmss");//设置日期格式
		Order  order = new Order();
		String ram = "" +(int)Math.random()*100;
		order.setOrderNo(Integer.parseInt(df.format(new Date()) + ram));
		order.setArrivedday(arrivedday);
		order.setArrivedtime(arrivedtime);
		order.setDoorplate(doorplate);
		order.setIsclosed(isclosed);
		order.setPayway(payway);
		order.setRemark(remark);
		order.setRoom(room);
		order.setSchool(school);
		order.setTelephone(telephone);
		order.setTotalamount(totalamount);
		order.setTruename(truename);
		order.setUsername(username);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(order);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		PageModel page = new PageModel();
		List<Order> list = new ArrayList<Order>();
		list = queryallorder(page);
		return list;
	}
	
	public Goods findgoodsbyid(int id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Goods.class);
		criteria.add(Restrictions.eq("id", id));
		Goods goods = (Goods) criteria.uniqueResult();
		return goods;
	}
	
	public Combo findcombobyid(int id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Combo.class);
		criteria.add(Restrictions.eq("id", id));
		Combo goods = (Combo) criteria.uniqueResult();
		return goods;
	}
	
	/**
	 * 增加订单详情
	 */
	public List<Order> addorderdetail(List<Order_detail> list,Integer id){
		
		for (int i=0;i<list.size();i++){
		Order_detail order_detail=list.get(i);
		int goodsid = order_detail.getGoodsid();
		Goods goods = findgoodsbyid(goodsid);
		int monthsell = goods.getMonthsell();
		monthsell++;
		goods.setMonthsell(monthsell);
		order_detail.setOrderid(id);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(order_detail);
			session.beginTransaction().commit();
			Session session1 = sessionFactory.getCurrentSession();
			session1.update(goods);
			session1.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		}
		PageModel page = new PageModel();
		List<Order> orderlist = new ArrayList<Order>();
		orderlist = queryallorder(page);
		return orderlist;
	}
	
	/**
	 * 增加订单详情
	 */
	public List<Order> addorderdetail1(List<Order_detail> list,Integer id){
		
	for (int i=0;i<list.size();i++){
		Order_detail order_detail=list.get(i);
		int goodsid = order_detail.getGoodsid();
		if (goodsid<=10000){
		Goods goods = findgoodsbyid(goodsid);
		int monthsell = goods.getMonthsell();
		System.out.print("monthsell before " + goods.getMonthsell());
		monthsell += 1;
		System.out.print("monthsell after " + monthsell );
		goods.setMonthsell(monthsell-1);
		order_detail.setOrderid(id);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(order_detail);
			session.beginTransaction().commit();
			Session session1 = sessionFactory.getCurrentSession();
			session1.update(goods);
			session1.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			}
		}
		else{
			Combo goods = findcombobyid(goodsid);
			int monthsell = goods.getMonthsell();
			System.out.print("combo monthsell before " + goods.getMonthsell());
			monthsell += 1;
			System.out.print("combo monthsell after " + monthsell );
			goods.setMonthsell(monthsell-1);
			order_detail.setOrderid(id);
			try {
				Session session = sessionFactory.getCurrentSession();
				session.save(order_detail);
				session.beginTransaction().commit();
				Session session1 = sessionFactory.getCurrentSession();
				session1.update(goods);
				session1.beginTransaction().commit();
			} catch (HibernateException e) {
				e.printStackTrace();
				}
		}
		}
		PageModel page = new PageModel();
		List<Order> orderlist = new ArrayList<Order>();
		orderlist = queryallorder(page);
		return orderlist;
	}
	
/*+++++++++++++add结束++++++++++++++*/
	/**
	 * 找到全部订单
	 */
	public List<Order> queryallorder(PageModel page){
		System.out.print("daoorder");
		List<Order> list  = new ArrayList<Order>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Order.class);
		list = c.list();
		return list;
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
		System.out.print("daoorder");
		List<Order_detail> list  = new ArrayList<Order_detail>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Order_detail.class);
		list = c.list();
		return list;
	}
	
	/**
	 * 根据orderno找到商品 并且返回一个order对象
	 */
	public Order findorderbyorderno(Integer orderNo) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Order.class);
		criteria.add(Restrictions.eq("orderNo", orderNo));
		Order order = (Order) criteria.uniqueResult();
		return order;
	}
	
	
/**
 * getter and setter
 * @return
 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
