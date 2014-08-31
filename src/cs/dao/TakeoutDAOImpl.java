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
import cs.entity.Secondgoods;
import cs.entity.Seller;
import cs.entity.Takeout;
import cs.entity.User;
import cs.vo.GoodsPage;
import cs.vo.PageModel;
import cs.vo.SellerPage;
import cs.vo.UserPage;

public class TakeoutDAOImpl implements TakeoutDAO {
	private SessionFactory sessionFactory;

	public Takeout findtakeoutbyid(int id) {
		System.out.print("aaasdasdfdgsfdgsgsd="+id);
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Takeout.class);
		criteria.add(Restrictions.eq("id", id));
		Takeout takeout = (Takeout) criteria.uniqueResult();
		return takeout;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
