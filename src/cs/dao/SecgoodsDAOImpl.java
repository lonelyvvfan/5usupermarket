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
import cs.entity.User;
import cs.vo.GoodsPage;
import cs.vo.PageModel;
import cs.vo.SellerPage;
import cs.vo.UserPage;

public class SecgoodsDAOImpl implements SecgoodsDAO {
	private SessionFactory sessionFactory;

	public Secondgoods findsecgoodsbyid(int id) {
		System.out.print("aaasdasdfdgsfdgsgsd="+id);
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Secondgoods.class);
		criteria.add(Restrictions.eq("id", id));
		Secondgoods secgoods = (Secondgoods) criteria.uniqueResult();
		return secgoods;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
