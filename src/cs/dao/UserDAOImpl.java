package cs.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import cs.entity.Order;
import cs.entity.Order_detail;
import cs.entity.Secondgoods;
import cs.entity.Secondgoods_subtype;
import cs.entity.Secondgoods_supertype;
import cs.entity.User;
import cs.vo.PageModel;
import cs.vo.UserPage;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;
	
	public User queryuserbyusername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User as u where u.username = ?");
		query.setString(0, username);
		User u = (User) query.uniqueResult();
		return u;
	}
	
	/**
	 * 根据username找到订单 并且返回一个user对象
	 */
	public User finduserbyusername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery(
		"from User as u where u.username = ?");
		query.setString(0, username);
		User u = (User) query.uniqueResult();
		return u;
	}
	
	/**
	 * 找到所有的user
	 */
	public List<User> queryalluser(PageModel page){
		List<User> userlist  = new ArrayList<User>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
		userlist = c.list();
		return userlist;
	}
	
	/**
	 * 增加用户
	 */
	public List<User> adduser(String username, String password, String telephone) {
		List<User> userlist = new ArrayList<User>();
		User user = new User();
		// user.setId(id);
		user.setUsername(username);
		user.setTelephone(telephone);
		user.setPassword(password);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(user);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		UserPage page = new UserPage();
		userlist = queryalluser(page);
		return userlist;
	}
	
	/**
	 * 修改用户
	 */
	public User alterpassword(Integer id,String password) {
		User user = new User();
		user.setId(id);
		user.setUsername(user.getUsername());
		user.setPassword(password);
		user.setTelephone(user.getTelephone());
		user.setAddress(user.getAddress());
		user.setAlipaynum(user.getAlipaynum());
		user.setAuthor(user.getAuthor());
		user.setEmail(user.getEmail());
		user.setNickname(user.getNickname());
		user.setQq(user.getQq());
		user.setRenren(user.getRenren());
		user.setSex(user.getSex());
		user.setWeibo(user.getWeibo());
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(user);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 修改用户
	 */
	public User alteruser(Integer id, String username, String password,
			String telephone, String alipaynum, String email, String author,
			String address, String nickname, String qq, String renren,
			String weibo, String sex, String school,String living) {
		System.out.println("2telephone is "+telephone);
		System.out.println("2email is "+email);
		System.out.println("2alipaynum is "+alipaynum);
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setTelephone(telephone);
		user.setAddress(address);
		user.setAlipaynum(alipaynum);
		user.setAuthor(author);
		user.setEmail(email);
		user.setNickname(nickname);
		user.setQq(qq);
		user.setRenren(renren);
		user.setSex(sex);
		user.setWeibo(weibo);
		user.setSchool(school);
		user.setLiving(living);
		System.out.println("3telephone is "+telephone);
		System.out.println("3email is "+email);
		System.out.println("3alipaynum is "+alipaynum);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(user);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 增加二手商品
	 */
	public List<Secondgoods> addsecgoods(Integer userid,String username,String nickname,Integer suptypeid, Integer subtypeid,
			String goodsname, String introduce, double price, double nowprice,String savepath, String savepath1, 
			String savepath2,String savepath3,  Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend, String shelves, String qq , String telephone ,  String other,Integer recency , String reason, String school, String living){
		List<Secondgoods> list = new ArrayList<Secondgoods>();
		Secondgoods secgoods = new Secondgoods();
		secgoods.setUserid(userid);
		secgoods.setUsername(username);
		secgoods.setNickname(nickname);
		secgoods.setSubtypeid(subtypeid);
		secgoods.setSuptypeid(suptypeid);
		secgoods.setGoodsname(goodsname);
		secgoods.setIntroduce(introduce);
		secgoods.setPrice(price);
		secgoods.setNowprice(nowprice);
		secgoods.setSavepath(savepath);
		secgoods.setSavepath1(savepath1);
		secgoods.setSavepath2(savepath2);
		secgoods.setSavepath3(savepath3);
		secgoods.setNewgoods(newgoods);
		secgoods.setHot(hot);
		secgoods.setSpecial(special);
		secgoods.setHealth(health);
		secgoods.setRecommend(recommend);
		secgoods.setShelves(shelves);
		secgoods.setQq(qq);
		secgoods.setTelephone(telephone);
		secgoods.setOther(other);
		secgoods.setRecency(recency);
		secgoods.setReason(reason);
		secgoods.setSchool(school);
		secgoods.setLiving(living);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(secgoods);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		PageModel page = new PageModel();
		list = queryallsecgoods(page);
		return list;
	}
	
	/**
	 * 找到全部二手商品
	 */
	public List<Secondgoods> queryallsecgoods(PageModel page){
		List<Secondgoods> list = new ArrayList<Secondgoods>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Secondgoods.class);
		list = c.list();
		return list;
	}
	
	
	/**
	 * 根据id找到用户 并且返回一个user对象
	 */
	public User finduserbyid(int id) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				User.class);
		criteria.add(Restrictions.eq("id", id));
		User user = (User) criteria.uniqueResult();
		return user;
	}
	
	/**
	 * 根据id找到二手商品 并且返回一个secondgoods对象
	 */
	public Secondgoods findsecgoodsbyid(int id){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Secondgoods.class);
		criteria.add(Restrictions.eq("id", id));
		Secondgoods secgoods = (Secondgoods) criteria.uniqueResult();
		return secgoods;
	}
	
	/**
	 * 批量删除secgoods
	 */
	public boolean deletecheckboxsecgoods(int[] arrid){
		Session session = null;
		try {
			for (int i=0;i<arrid.length;i++)
			{
				session = sessionFactory.getCurrentSession();
				Secondgoods secondgoods = findsecgoodsbyid(arrid[i]);
				session.delete(secondgoods);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
		
	}
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean secupjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.getCurrentSession();
				Secondgoods secondgoods = findsecgoodsbyid(checkout[i]);
				secondgoods.setShelves("1");
				session.update(secondgoods);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean secdownjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.getCurrentSession();
				Secondgoods secondgoods = findsecgoodsbyid(checkout[i]);
				secondgoods.setShelves("0");
				session.update(secondgoods);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	/**
	 * 根据id删除二手商品
	 */
	public boolean deletesecgoodsbyid(int id){
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.delete(findsecgoodsbyid(id));
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 修改二手商品信息
	 */
	 public List<Secondgoods> altersecgoods(Integer id,Integer userid,String username,String nickname,Integer suptypeid, Integer subtypeid,
				String goodsname, String introduce, double price, double nowprice,String savepath, String savepath1, 
				String savepath2,String savepath3,  Integer newgoods, Integer hot, Integer special,
				Integer health, Integer recommend, String shelves, String qq , String telephone ,  String other,Integer recency , String reason, String school, String living){
		 List<Secondgoods> list = new ArrayList<Secondgoods>();
		 	Secondgoods secgoods = new Secondgoods();
		 	secgoods.setId(id);
			secgoods.setUserid(userid);
			secgoods.setUsername(username);
			secgoods.setNickname(nickname);
		 	secgoods.setGoodsname(goodsname);
			secgoods.setHealth(health);
			secgoods.setHot(hot);
			secgoods.setIntroduce(introduce);
			secgoods.setNewgoods(newgoods);
			secgoods.setNowprice(nowprice);
			secgoods.setPrice(price);
			secgoods.setRecommend(recommend);
			secgoods.setSavepath(savepath);
			secgoods.setSavepath1(savepath1);
			secgoods.setSavepath2(savepath2);
			secgoods.setSavepath3(savepath3);
			secgoods.setSpecial(special);
			secgoods.setSubtypeid(subtypeid);
			secgoods.setSuptypeid(suptypeid);
			secgoods.setShelves(shelves);
			secgoods.setQq(qq);
			secgoods.setTelephone(telephone);
			secgoods.setOther(other);
			secgoods.setRecency(recency);
			secgoods.setSchool(school);
			secgoods.setLiving(living);
			try {
				Session session = sessionFactory.getCurrentSession();
				session.update(secgoods);
				System.out.println("Session Success?");
				session.beginTransaction().commit();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PageModel page = new PageModel();
			list = queryallsecgoods(page);
			return list;
	 }
	 
	 /**
		 * 增加订单
		 */
	 	public Order addorder(String arrivedday, String arrivedtime,
				double totalamount, String username, String truename,
				String telephone, String school, String doorplate, String room,
				String remark, String payway, int isclosed){
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
			order=findorderbyorderno(n);
			return order;
		}
		
		/**
		 * 增加订单详情
		 */
		public List<Order> addorderdetail(List<Order_detail> list,Integer id){
			for (int i=0;i<list.size();i++){
			Order_detail order_detail=list.get(i);
			order_detail.setOrderid(id);
			try {
				Session session = sessionFactory.getCurrentSession();
				session.save(order_detail);
				session.beginTransaction().commit();
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
		 * 根据id找到订单 并且返回一个order对象
		 */
		public Order findorderbyid(int id){
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
					Order.class);
			criteria.add(Restrictions.eq("id", id));
			Order order = (Order) criteria.uniqueResult();
			return order;
		}
		
		/**
		 *查找订单返回list 
		 * @param username
		 * @param isclosed
		 * @return
		 */	
		public List<Order> findorderspecial(String username,Integer isclosed){
			List<Order> orderlist = new ArrayList<Order>();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
					Order.class);
			if (username!=null)
			{
				String sring = "%" + username + "%";
				criteria.add(Restrictions.ilike("username", sring));
			}
			if (isclosed!=null&&isclosed!=2)
			{
			Integer sring1 =isclosed;
			criteria.add(Restrictions.eq("isclosed", sring1));	
			}
			orderlist = criteria.list();
			return orderlist;
		}
		
		/**
		 * 根据订单id找到订单下的商品 并且返回一个order_detail对象list
		 */
		public List<Order_detail> findorderdetailbyid(Integer id){
			List<Order_detail> ordertaillist = new ArrayList<Order_detail>();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
					Order_detail.class);
			criteria.add(Restrictions.eq("orderid", id));
			ordertaillist = criteria.list();
			return ordertaillist;
		}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	/**
	 * 查找二手商品所有子类分类返回list
	 * @return
	 */
	public List<Secondgoods_subtype> showsecsubtype(){
		List<Secondgoods_subtype> list = new ArrayList<Secondgoods_subtype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Secondgoods_subtype.class);
		list = c.list();
		System.out.println("secsub" + list);
		return list;
	}
	
	/**
	 * 查找二手商品所有父类分类返回list
	 * @return
	 */
	public List<Secondgoods_supertype> showsecsuptype(){
		List<Secondgoods_supertype> list = new ArrayList<Secondgoods_supertype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Secondgoods_supertype.class);
		list = c.list();
		System.out.println("secsup" + list);
		return list;
	}
	
}
