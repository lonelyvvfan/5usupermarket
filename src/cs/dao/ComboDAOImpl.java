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
import cs.entity.Combo;
import cs.entity.Goods;
import cs.entity.Seller;
import cs.entity.User;
import cs.vo.ComboPage;
import cs.vo.PageModel;
import cs.vo.SellerPage;
import cs.vo.UserPage;

public class ComboDAOImpl implements ComboDAO {
	private SessionFactory sessionFactory;

	public Combo findcombobyid(int id) {
		System.out.println("cccccccccccccccccc"+id);
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Combo.class);
		criteria.add(Restrictions.eq("id", id));
		Combo combo = (Combo) criteria.uniqueResult();
		return combo;
	}
	
	public List<Combo> findcombobyid2(int typeid){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Combo.class);
		criteria.add(Restrictions.eq("typeid", typeid));
		List<Combo> list  = new ArrayList<Combo>();
		list = criteria.list();
		return list;
	}

	public List<Combo> findcombospecial(String goodsname,Integer id,Integer typeid){
		List<Combo> combolist = new ArrayList<Combo>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Combo.class);
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
		combolist = criteria.list();
		return combolist;
	}
	
	
	public boolean dianzan(int id){
		Combo combo = new Combo();
		combo = findcombobyid(id);
		int nowzan = combo.getZan();
		nowzan++;
		combo.setZan(nowzan);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(combo);
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
	public List<Combo> queryallcombo(PageModel page) {
		List<Combo> combolist = new ArrayList<Combo>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Combo.class);
		combolist = c.list();
		return combolist;
	}
	
	public List<Combo> alterComboInventory(Integer goodsid,Integer number){
		System.out.println("22222222222222222222222223");
		Combo combo = new Combo();
		combo = findcombobyid(goodsid);
		//System.out.println("goodsid is " + goodsid + " and number is " + number + " and the old number is " + goods.getInventory());
		Integer number1 = combo.getInventory()-number;
		Integer monthsell1 = combo.getMonthsell()+number;
		combo.setId(goodsid);
		combo.setInventory(number1);
		combo.setMonthsell(monthsell1);
		System.out.println("goodsid is " + goodsid + " and number1 is " + number1 + " and the old number is " + combo.getInventory());
		try{
			Session session = sessionFactory.getCurrentSession();
			session.update(combo);
			System.out.println("session success");
			session.beginTransaction().commit();
		} catch (HibernateException e){
			e.printStackTrace();
		}
		List<Combo> list = new ArrayList<Combo>();
		return list;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
