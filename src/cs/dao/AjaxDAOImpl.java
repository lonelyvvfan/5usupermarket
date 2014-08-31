package cs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import cs.entity.Admin;
import cs.entity.Combo;
import cs.entity.Goods;
import cs.entity.Greatseller;
import cs.entity.Keyword;
import cs.entity.Notice;
import cs.entity.Secondgoods;
import cs.entity.Sellertype;
import cs.entity.Takeout;
import cs.entity.User;
import cs.service.AjaxService;
import cs.vo.PageModel;

public class AjaxDAOImpl implements AjaxDAO{
	private SessionFactory sessionFactory;
	/**
	 * 查找商品返回list
	 * @param goodsname,suptypeid,subtypeid
	 * @return
	 */
	public List<Goods> findgoodsspecial(String goodsname,Integer suptypeid,Integer subtypeid){
		
		List<Goods> goodslist = new ArrayList<Goods>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Goods.class);
		if (goodsname!=null)
		{
			String sring = "%" + goodsname + "%";
			criteria.add(Restrictions.ilike("goodsname", sring));
		}
		if (suptypeid!=null&&suptypeid!=1)
		{
		Integer sring1 =suptypeid;
		criteria.add(Restrictions.eq("suptypeid", sring1));	
		}
		if (subtypeid!=null&&subtypeid!=1)
		{
		Integer sring2 = subtypeid ;
		criteria.add(Restrictions.eq("subtypeid", sring2));
		}
		criteria.add(Restrictions.eqOrIsNull("shelves", "1"));
		goodslist = criteria.list();
		return goodslist;
	}
	
	/**
	 * 找到全部公告
	 */
	public List<Notice> queryallnotice(){
		List<Notice> list = new ArrayList<Notice>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Notice.class);
		c.addOrder(Property.forName("id").desc());
		list = c.list();
		return list;
	}
	
	/**
	 * 查找商品返回list
	 * @param goodsname,suptypeid,subtypeid
	 * @return
	 */
	public List<Greatseller> findgreatsellerspecial(String name,Integer suptypeid,Integer subtypeid){
		
		List<Greatseller> greatsellerlist = new ArrayList<Greatseller>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Greatseller.class);
		if (name!=null)
		{
			String sring = "%" + name + "%";
			criteria.add(Restrictions.ilike("name", sring));
		}
		if (suptypeid!=null&&suptypeid!=1)
		{
		Integer sring1 =suptypeid;
		criteria.add(Restrictions.eq("suptypeid", sring1));	
		}
		if (subtypeid!=null&&subtypeid!=1)
		{
		Integer sring2 = subtypeid ;
		criteria.add(Restrictions.eq("subtypeid", sring2));
		}
		criteria.add(Restrictions.eqOrIsNull("shelves", "1"));
		greatsellerlist = criteria.list();
		return greatsellerlist;
	}
	
	/**
	 * 查找商品返回list
	 * @param goodsname,suptypeid,subtypeid
	 * @return
	 */
	public List<Takeout> findtakeoutspecial(Integer sellerid,Integer suptypeid,Integer subtypeid){
		
		List<Takeout> takeoutlist = new ArrayList<Takeout>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Takeout.class);
		if (sellerid!=null)
		{
			Integer sring = sellerid;
			criteria.add(Restrictions.eq("sellerid", sellerid));
		}
		if (suptypeid!=null&&suptypeid!=1)
		{
		Integer sring1 =suptypeid;
		criteria.add(Restrictions.eq("suptypeid", sring1));	
		}
		if (subtypeid!=null&&subtypeid!=1)
		{
		Integer sring2 = subtypeid ;
		criteria.add(Restrictions.eq("subtypeid", sring2));
		}
		criteria.add(Restrictions.eqOrIsNull("shelves", "1"));
		takeoutlist = criteria.list();
		return takeoutlist;
	}
	
	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Sellertype> findsellertypespecial(String name, Integer suptypeid,
			Integer subtypeid){
		List<Sellertype> sellertypelist = new ArrayList<Sellertype>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Sellertype.class);
		if (name!=null)
		{
			String sring = "%" + name + "%";
			criteria.add(Restrictions.ilike("name", sring));
		}
		if (suptypeid!=null&&suptypeid!=1)
		{
		Integer sring1 =suptypeid;
		criteria.add(Restrictions.eq("suptypeid", sring1));	
		}
		if (subtypeid!=null&&subtypeid!=1)
		{
		Integer sring2 = subtypeid ;
		criteria.add(Restrictions.eq("subtypeid", sring2));
		}
		sellertypelist = criteria.list();
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();  
		for (int i=0;i<sellertypelist.size();i++)
		{
			if (!map.containsValue(sellertypelist.get(i).getSellerid())){
				map.put(i, sellertypelist.get(i).getSellerid());
			}
			else
				sellertypelist.remove(i);
		}
		return sellertypelist;
	}
	
	/**
	 * 查找商品返回list
	 * @param goodsname,suptypeid,subtypeid
	 * @return
	 */
	public List<Secondgoods> findsecgoodsspecial(String goodsname,Integer suptypeid,Integer subtypeid){
		
		List<Secondgoods> secgoodslist = new ArrayList<Secondgoods>();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Secondgoods.class);
		if (goodsname!=null)
		{
			String sring = "%" + goodsname + "%";
			criteria.add(Restrictions.ilike("goodsname", sring));
		}
		if (suptypeid!=null&&suptypeid!=1)
		{
		Integer sring1 =suptypeid;
		criteria.add(Restrictions.eq("suptypeid", sring1));	
		}
		if (subtypeid!=null&&subtypeid!=1)
		{
		Integer sring2 = subtypeid ;
		criteria.add(Restrictions.eq("subtypeid", sring2));
		}
		criteria.add(Restrictions.eqOrIsNull("shelves", "1"));
		secgoodslist = criteria.list();
		return secgoodslist;
	}
	
	/**
	 * 找到推荐商品
	 */
	public List<Goods> findrecommend(){
		Query query = sessionFactory.getCurrentSession().createQuery(
		"from Goods as u where u.recommend = 1 and u.shelves="+"1");
		//query.setString(0, username);
		 List<Goods> list=query.list();
		return list;
	}
	
	/**
	 * 找到健康商品
	 */
	public List<Goods> findhealth(){
		Query query = sessionFactory.getCurrentSession().createQuery(
		"from Goods as u where u.health = 1  and u.shelves="+"1");
		//query.setString(0, username);
		 List<Goods> list=query.list();
		return list;
	}
	
	/**
	 * 找到特价商品
	 */
	public List<Goods> findspecial(){
		Query query = sessionFactory.getCurrentSession().createQuery(
		"from Goods as u where u.special = 1 and u.shelves="+"1");
		//query.setString(0, username);
		 List<Goods> list=query.list();
		return list;
	}
	
	/**
	 * 找到健康商品
	 */
	public List<Goods> findhot(){
		Query query = sessionFactory.getCurrentSession().createQuery(
		"from Goods as u where u.hot = 1 and u.shelves="+"1");
		//query.setString(0, username);
		 List<Goods> list=query.list();
		return list;
	}
	
	/**
	 * 找到新商品
	 */
	public List<Goods> findnewgoods(){
		Query query = sessionFactory.getCurrentSession().createQuery(
		"from Goods as u where u.newgoods = 1 and u.shelves="+"1");
		//query.setString(0, username);
		 List<Goods> list=query.list();
		return list;
	}
	
	/**
	 * 找到套餐
	 */
	public List<Combo> findcombo(){
		List<Combo> list = new ArrayList<Combo>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				" from Combo as u where u.shelves ="+"1");
		list = query.list();
		//Criteria c = sessionFactory.getCurrentSession().createCriteria(
			//	Combo.class);
		//list = c.list();
		System.out.println(list);
		return list;
	}
	
	/**
	 * 修改keyword内容
	 */
	public List<Keyword> alterkeyword(){
		List<Keyword> list = new ArrayList<Keyword>();
		PageModel page = new PageModel();
		list = queryallkeyword(page);
		return list;
	}
	
	/**
	 * 找到全部帮助信息
	 */
	public List<Keyword> queryallkeyword(PageModel page){
		List<Keyword> list = new ArrayList<Keyword>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Keyword.class);
		list = c.list();
		return list;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
