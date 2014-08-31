package cs.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import sun.launcher.resources.launcher;
import cs.entity.Admin;
import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Seller;
import cs.entity.User;
import cs.vo.GoodsPage;
import cs.vo.PageModel;
import cs.vo.SellerPage;
import cs.vo.UserPage;

public class GoodsDAOImpl implements GoodsDAO {
	private SessionFactory sessionFactory;

	public Goods findgoodsbyid(int id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Goods.class);
		criteria.add(Restrictions.eq("id", id));
		Goods goods = (Goods) criteria.uniqueResult();
		return goods;
	}
	
	public List<Goods> findgoodsbyid2(int typeid){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Goods.class);
		criteria.add(Restrictions.eq("typeid", typeid));
		List<Goods> list  = new ArrayList<Goods>();
		list = criteria.list();
		return list;
	}

	public List<Goods> findgoodsspecial(String goodsname,Integer id,Integer typeid){
		List<Goods> goodslist = new ArrayList<Goods>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Goods.class);
		if (goodsname!=null)
		{
			String sring = "%" + goodsname + "%";
			criteria.add(Restrictions.ilike("goodsname", sring));
		}
		if (id!=1)
		{
		Integer sring1 =id;
		criteria.add(Restrictions.eq("id", sring1));	
		}
		if (typeid!=1)
		{
		Integer sring2 = typeid ;
		criteria.add(Restrictions.eq("typeid", sring2));
		}
		goodslist = criteria.list();
		return goodslist;
	}
	
	
	public boolean dianzan(int id){
		Goods goods = new Goods();
		goods = findgoodsbyid(id);
		int nowzan = goods.getZan();
		nowzan++;
		goods.setZan(nowzan);
		try {
			Session session = sessionFactory.openSession();
			session.update(goods);
			System.out.println("Session Success?");
			session.beginTransaction().commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * 找到全部商品
	 */
	public List<Goods> queryallgoods(PageModel page) {
		List<Goods> goodslist = new ArrayList<Goods>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Goods.class);
		goodslist = c.list();
		return goodslist;
	}
	
	public List<Goods_subtype> showsubtype(){
		List<Goods_subtype> list = new ArrayList<Goods_subtype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Goods_subtype.class);
		list = c.list();
		return list;
		
	}
	
	public List<Goods_supertype> showsuptype(){
		List<Goods_supertype> list = new ArrayList<Goods_supertype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Goods_supertype.class);
		list = c.list();
		return list;
	}

	public List<Goods> alterInventory(Integer goodsid,Integer number){
		System.out.println("22222222222222222222222223");
		Goods goods = new Goods();
		goods = findgoodsbyid(goodsid);
		//System.out.println("goodsid is " + goodsid + " and number is " + number + " and the old number is " + goods.getInventory());
		Integer number1 = goods.getInventory()-number;
		Integer monthsell1 = goods.getMonthsell()+number;
		goods.setId(goodsid);
		goods.setInventory(number1);
		goods.setMonthsell(monthsell1);
		System.out.println("goodsid is " + goodsid + " and number1 is " + number1 + " and the old number is " + goods.getInventory());
		try{
			Session session = sessionFactory.openSession();
			session.update(goods);
			System.out.println("session success");
			session.beginTransaction().commit();
		} catch (HibernateException e){
			e.printStackTrace();
		}
		List<Goods> list = new ArrayList<Goods>();
		return list;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
