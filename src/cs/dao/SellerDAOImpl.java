package cs.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.hibernate.criterion.Restrictions;

import cs.entity.Seller;
import cs.entity.Takeout;
import cs.entity.Takeout_subtype;
import cs.entity.Takeout_supertype;
import cs.entity.User;
import cs.vo.PageModel;
import cs.vo.SellerPage;


public class SellerDAOImpl implements SellerDAO {
	private SessionFactory sessionFactory;
	/**
	 *  通过用户名查找外卖商家
	 */
	public Seller querysellerbyusername(String username) {
		System.out.println(username+"is username in SellerDaoImpl");

		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Seller as u where u.username = ?");
		query.setString(0, username);
		Seller u = (Seller) query.uniqueResult();
		return u;
	}
	
	/**
	 * 增加外卖
	 */
	public List<Takeout> addtakeout(Integer sellerid,String sellername,Integer suptypeid, Integer subtypeid,
			String goodsname, String introduce, double price, double nowprice,
			String savepath,String savepath1, String savepath2,String  savepath3, Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend, String shelves , String reason){
				List<Takeout> list = new ArrayList<Takeout>();
				Takeout takeout = new Takeout();
				takeout.setSellerid(sellerid);
				takeout.setSellername(sellername);
				takeout.setSubtypeid(subtypeid);
				takeout.setSuptypeid(suptypeid);
				takeout.setGoodsname(goodsname);
				takeout.setIntroduce(introduce);
				takeout.setPrice(price);
				takeout.setNowprice(nowprice);
				takeout.setSavepath(savepath);
				takeout.setSavepath1(savepath1);
				takeout.setSavepath2(savepath2);
				takeout.setSavepath3(savepath3);
				takeout.setShelves(shelves);
				takeout.setNewgoods(newgoods);
				takeout.setHot(hot);
				takeout.setSpecial(special);
				takeout.setHealth(health);
				takeout.setRecommend(recommend);
				takeout.setReason(reason);
				try {
					Session session = sessionFactory.getCurrentSession();
					session.save(takeout);
					session.beginTransaction().commit();
				} catch (HibernateException e) {
					e.printStackTrace();
				}
				PageModel page = new PageModel();
				list = findtakeoutbyid(sellerid);
				return list;
			}
	
	/**
	 * 根据id删除外卖
	 */
	public boolean deletetakeoutbyid(int id) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.delete(findtakeoutbyid1(id));
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
	 * 批量删除takeout
	 */
	public boolean deletecheckboxtakeout(int[] arrid){
		Session session = null;
		try {
			for (int i=0;i<arrid.length;i++)
			{
				session = sessionFactory.getCurrentSession();
				Takeout takeout = findtakeoutbyid1(arrid[i]);
				session.delete(takeout);
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
	public boolean takeupjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.getCurrentSession();
				Takeout takeout = findtakeoutbyid1(checkout[i]);
				takeout.setShelves("1");
				session.update(takeout);
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
	public boolean takedownjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.getCurrentSession();
				Takeout takeout = findtakeoutbyid1(checkout[i]);
				takeout.setShelves("0");
				session.update(takeout);
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
	 * 根据id找到外卖 并且返回一个takeout对象
	 */
	public Takeout findtakeoutbyid1(int id){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Takeout.class);
		criteria.add(Restrictions.eq("id", id));
		Takeout takeout = (Takeout) criteria.uniqueResult();
		return takeout;
	}
	
	/**
	 * 根据id找到外卖 并且返回一个list对象
	 */
	public List<Takeout> findtakeoutbyid(int sellerid){
		List<Takeout> list = new ArrayList<Takeout>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Takeout.class);
		criteria.add(Restrictions.eq("sellerid", sellerid));
		list =  criteria.list();
		System.out.println(list);
		return list;
	}
	
	/**
	 * 根据id找到用户 并且返回一个user对象
	 */
	public Seller findsellerbyid(int id) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Seller.class);
		criteria.add(Restrictions.eq("id", id));
		Seller seller = (Seller) criteria.uniqueResult();
		return seller;
	}
	
	public int findidbyusername(String username){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Seller.class);
		criteria.add(Restrictions.eq("username", username));
		Seller seller = (Seller) criteria.uniqueResult();
		int id = seller.getId();
		return id;
	}
	
	/**
	 * 修改商家
	 */
	public Seller alterseller(Integer id, String username,
			String password, String name, String telephone, String email,
			String alipaynum, String identification, String address,
			String savepath, String author, String content, String reason) {
		Seller seller = new Seller();
		seller.setId(id);
		seller.setUsername(username);
		seller.setPassword(password);
		seller.setName(name);
		seller.setTelephone(telephone);
		seller.setEmail(email);
		seller.setAlipaynum(alipaynum);
		seller.setIdentification(identification);
		seller.setAddress(address);
		seller.setSavepath(savepath);
		seller.setAuthor(author);
		seller.setContent(content);
		seller.setReason(reason);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(seller);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seller;
	}
	
	/**
	 * 查找外卖返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Takeout> findtakeoutspecial(String goodsname, Integer suptypeid,
			Integer subtypeid){
		List<Takeout> list = new ArrayList<Takeout>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Takeout.class);
		if (goodsname!=null)
		{
			String sring = "%" + goodsname + "%";
			criteria.add(Restrictions.ilike("goodsname", sring));
		}
		if (suptypeid!=1)
		{
		Integer sring1 =suptypeid;
		criteria.add(Restrictions.eq("suptypeid", sring1));	
		}
		if (subtypeid!=1)
		{
		Integer sring2 = subtypeid ;
		criteria.add(Restrictions.eq("subtypeid", sring2));
		}
		list = criteria.list();
		return list;
	}
	
	/**
	 * 修改外卖信息
	 */
	 public List<Takeout> altertakeout(Integer id,Integer sellerid,String sellername, Integer suptypeid,
				Integer subtypeid, String goodsname, String introduce,
				double price, double nowprice, String savepath,String savepath1, String savepath2,String  savepath3,  Integer newgoods,
				Integer hot, Integer special, Integer health, Integer recommend, String shelves, String reason){
					 List<Takeout> list = new ArrayList<Takeout>();
					 Takeout takeout = new Takeout();
					 	takeout.setId(id);
					 	takeout.setSellerid(sellerid);
					 	takeout.setSellername(sellername);
						takeout.setGoodsname(goodsname);
						takeout.setHealth(health);
						takeout.setHot(hot);
						takeout.setIntroduce(introduce);
						takeout.setNewgoods(newgoods);
						takeout.setNowprice(nowprice);
						takeout.setPrice(price);
						takeout.setRecommend(recommend);
						takeout.setSavepath(savepath);
						takeout.setSavepath(savepath);
						takeout.setSavepath1(savepath1);
						takeout.setSavepath2(savepath2);
						takeout.setSavepath3(savepath3);
						takeout.setShelves(shelves);
						takeout.setSpecial(special);
						takeout.setSubtypeid(subtypeid);
						takeout.setSuptypeid(suptypeid);
						takeout.setReason(reason);
						try {
							Session session = sessionFactory.getCurrentSession();
							session.update(takeout);
							System.out.println("Session Success?");
							session.beginTransaction().commit();
						} catch (HibernateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						PageModel page = new PageModel();
						list = findtakeoutbyid(id);
						return list;
				 }
	 
	 /**
		 * 查找外卖所有子类分类返回list
		 * 
		 * @return
		 */
		public List<Takeout_subtype> showtakeoutsubtype(){
			List<Takeout_subtype> list = new ArrayList<Takeout_subtype>();
			Criteria c = sessionFactory.getCurrentSession().createCriteria(
					Takeout_subtype.class);
			list = c.list();
			System.out.println("Takeout_subtype" + list);
			return list;
		}
		
		/**
		 * 查找外卖所有父类分类返回list
		 * 
		 * @return
		 */
		public List<Takeout_supertype> showtakeoutsuptype(){
			List<Takeout_supertype> list = new ArrayList<Takeout_supertype>();
			Criteria c = sessionFactory.getCurrentSession().createCriteria(
					Takeout_supertype.class);
			list = c.list();
			System.out.println("Takeout_supertype" + list);
			return list;
		}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
