package cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cs.entity.GoodsCount;
import cs.entity.Turnover;

public class PagingDAOImpl implements PagingDAO{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	//分页查询
    public List<Object> queryforpage(String hql,final int beginset,final int length,String username){
    	Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if (username!=null)
		query.setString(0, "%"+username+"%");
        query.setFirstResult(beginset);
        query.setMaxResults(length);
		List<Object> list = query.list();	
        return list;
    }
    
    
    //查询所有记录数
    public int queryallrowcount(String hql,String username){
    	//return getHibernateTemplate().find(hql).size();
    	Session session=sessionFactory.getCurrentSession();
    	System.out.println("hql="+hql);
		Query query = session.createQuery(hql);
		System.out.println("username="+username);
		if (username!=null)
		query.setString(0,"%"+username+"%");
		//query.setParameter("username",userpwd.getUsername());
		List list = query.list();
		return list.size();
    }
    
    
    public int querygoodsallrowcount(String hql,int sellerid){
    	Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if (sellerid!=0)
		query.setInteger(0,sellerid);
		//query.setParameter("username",userpwd.getUsername());
		List list = query.list();
		return list.size();
    }
    
    public int querysecgoodsallrowcount(String hql,int userid){
    	Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if (userid!=0)
		query.setInteger(0,userid);
		//query.setParameter("username",userpwd.getUsername());
		List list = query.list();
		return list.size();
    }
    
    
    public int querygoodsallrowcount(String hql,Integer sellerid,Integer suptypeid,Integer subtypeid){
    	//return getHibernateTemplate().find(hql).size();
    	Session session=sessionFactory.getCurrentSession();
		System.out.println("username="+suptypeid);
		Query query = session.createQuery(hql);
		//where u.goodsname like ? and u.id like and u.typeid like ?
		if (suptypeid!=null&&suptypeid!=1){
			hql=hql+" and u.suptypeid="+suptypeid;
			query = session.createQuery(hql);
		}		
		if (subtypeid!=null&&subtypeid!=1){
			hql=hql+" and u.subtypeid ="+subtypeid;
			query = session.createQuery(hql);
		}
		//query.setParameter("username",userpwd.getUsername());
		System.out.println(hql);
		List list = query.list();
		System.out.println(list);
		return list.size();
    }
    
    public int querygoodsallrowcount(String hql,String goodsname){
    	Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if (goodsname!=null)
		{
			query.setParameter(0, "%"+goodsname+"%");
		}
		else{
			query.setParameter(0, "%"+""+"%");
		}
		//query.setParameter("username",userpwd.getUsername());
		System.out.println(hql);
		List list = query.list();
		System.out.println(list);
		return list.size();
    }
    
	public List<Object> querygoodsforpage(String hql,final int beginset,final int length,Integer sellerid,Integer suptypeid,Integer subtypeid){
		Session session=sessionFactory.getCurrentSession();
    	Query query = session.createQuery(hql);
		if (suptypeid!=null&&suptypeid!=1){
			hql=hql+" and u.suptypeid="+suptypeid;
			query = session.createQuery(hql);
		}		
		if (subtypeid!=null&&subtypeid!=1){
			hql=hql+" and u.subtypeid ="+subtypeid;
			query = session.createQuery(hql);
		}
		hql=hql+" order by id desc ";
		query = session.createQuery(hql);
        query.setFirstResult(beginset);
        query.setMaxResults(length);
		List<Object> list = query.list();
		System.out.println(hql);
		System.out.println(list);
        return list;
	}
    
    /** 
     * 分页查询商品
     * @param hql 查询的条件
     * @param beginset 开始记录
     * @param length 一次查询几条记录
     * @return
     */
    public List<Object> querygoodsforpage(String hql,final int beginset,final int length,String goodsname,Integer suptypeid,Integer subtypeid){
    	Session session=sessionFactory.getCurrentSession();
    	Query query = session.createQuery(hql);
		if (suptypeid!=null&&suptypeid!=1){
			hql=hql+" and u.suptypeid="+suptypeid;
			query = session.createQuery(hql);
		}		
		if (subtypeid!=null&&subtypeid!=1){
			hql=hql+" and u.subtypeid ="+subtypeid;
			query = session.createQuery(hql);
		}
		hql=hql+" order by indexx desc, id desc ";
		query = session.createQuery(hql);
		if (goodsname!=null)
		{
			query.setString(0, "%"+goodsname+"%");
		}
		else
			query.setString(0, "%"+""+"%");
        query.setFirstResult(beginset);
        query.setMaxResults(length);
		List<Object> list = query.list();
		System.out.println(hql);
		System.out.println(list);
        return list;
    }
    
    /** 
     * 分页查询商品 + 上下架查询
     * @param hql 查询的条件
     * @param beginset 开始记录
     * @param length 一次查询几条记录
     * @return
     */
    public List<Object> querygoodsforpage1(String hql,final int beginset,final int length,String goodsname,Integer suptypeid,Integer subtypeid,String shelves){
    	Session session=sessionFactory.getCurrentSession();
    	Query query = session.createQuery(hql);
		if (suptypeid!=null&&suptypeid!=1){
			hql=hql+" and u.suptypeid="+suptypeid;
			query = session.createQuery(hql);
		}		
		if (subtypeid!=null&&subtypeid!=1){
			hql=hql+" and u.subtypeid ="+subtypeid;
			query = session.createQuery(hql);
		}
		System.out.println(shelves);
		if(shelves!=null){
		Integer shelves1 = Integer.parseInt(shelves);
		if (shelves1!=2){
			hql += " and u.shelves= " + shelves1;
			query = session.createQuery(hql);
		}
		}
		hql=hql+" order by indexx desc, id desc ";
		query = session.createQuery(hql);
		if (goodsname!=null)
		{
			query.setString(0, "%"+goodsname+"%");
		}
		else
			query.setString(0, "%"+""+"%");
        query.setFirstResult(beginset);
        query.setMaxResults(length);
		List<Object> list = query.list();
		System.out.println(hql);
		System.out.println(list);
        return list;
    }
    
    /** 
     * 分页查询商品 + 上下架查询
     * @param hql 查询的条件
     * @param beginset 开始记录
     * @param length 一次查询几条记录
     * @return
     */
    public List<Object> querycomboforpage1(String hql,final int beginset,final int length,String goodsname,String shelves){
    	Session session=sessionFactory.getCurrentSession();
    	Query query = session.createQuery(hql);
	
		System.out.println(shelves);
		if(shelves!=null){
		Integer shelves1 = Integer.parseInt(shelves);
		if (shelves1!=2){
			hql += " and u.shelves= " + shelves1;
			query = session.createQuery(hql);
		}
		}
		hql=hql+" order by id desc ";
		query = session.createQuery(hql);
		if (goodsname!=null)
		{
			query.setString(0, "%"+goodsname+"%");
		}
		else
			query.setString(0, "%"+""+"%");
        query.setFirstResult(beginset);
        query.setMaxResults(length);
		List<Object> list = query.list();
		System.out.println(hql);
		System.out.println(list);
        return list;
    }
    
    /** 
     * 分页查询商品
     * @param hql 查询的条件
     * @param beginset 开始记录
     * @param length 一次查询几条记录
     * @return
     */
    public List<Object> querytakeoutforpage(String hql,final int beginset,final int length,String goodsname,Integer suptypeid,Integer subtypeid){
    	Session session=sessionFactory.getCurrentSession();
    	Query query = session.createQuery(hql);
		if (suptypeid!=null&&suptypeid!=1){
			hql=hql+" and u.suptypeid="+suptypeid;
			query = session.createQuery(hql);
		}		
		if (subtypeid!=null&&subtypeid!=1){
			hql=hql+" and u.subtypeid ="+subtypeid;
			query = session.createQuery(hql);
		}
		hql=hql+" order by id desc ";
		query = session.createQuery(hql);
		if (goodsname!=null)
		{
			query.setString(0, "%"+goodsname+"%");
		}
		else
			query.setString(0, "%"+""+"%");
        query.setFirstResult(beginset);
        query.setMaxResults(length);
		List<Object> list = query.list();
		System.out.println(hql);
		System.out.println(list);
        return list;
    }
    
    /** 
     * 分页查询商品
     * @param hql 查询的条件
     * @param beginset 开始记录
     * @param length 一次查询几条记录
     * @return
     */
    public List<Object> querysellertypeforpage(String hql,final int beginset,final int length,String name,Integer suptypeid,Integer subtypeid){
    	Session session=sessionFactory.getCurrentSession();
    	Query query = session.createQuery(hql);
		if (suptypeid!=null&&suptypeid!=1){
			hql=hql+" and u.suptypeid="+suptypeid;
			query = session.createQuery(hql);
		}		
		if (subtypeid!=null&&subtypeid!=1){
			hql=hql+" and u.subtypeid ="+subtypeid;
			query = session.createQuery(hql);
		}
		hql=hql+" order by id desc ";
		query = session.createQuery(hql);
		if (name!=null)
		{
			query.setString(0, "%"+name+"%");
		}
		else
			query.setString(0, "%"+""+"%");
        query.setFirstResult(beginset);
        query.setMaxResults(length);
		List<Object> list = query.list();
		System.out.println(hql);
		System.out.println(list);
        return list;
    }
    
    /** 
     * 分页查询商品
     * @param hql 查询的条件
     * @param beginset 开始记录
     * @param length 一次查询几条记录
     * @return
     */
    public List<Object> querysecgoodsforpage(String hql,final int beginset,final int length,String goodsname,Integer suptypeid,Integer subtypeid){
    	Session session=sessionFactory.getCurrentSession();
    	Query query = session.createQuery(hql);
		if (suptypeid!=null&&suptypeid!=1){
			hql=hql+" and u.suptypeid="+suptypeid;
			query = session.createQuery(hql);
		}		
		if (subtypeid!=null&&subtypeid!=1){
			hql=hql+" and u.subtypeid ="+subtypeid;
			query = session.createQuery(hql);
		}
		hql=hql+" order by id desc ";
		query = session.createQuery(hql);
		if (goodsname!=null)
		{
			query.setString(0, "%"+goodsname+"%");
		}
		else
			query.setString(0, "%"+""+"%");
        query.setFirstResult(beginset);
        query.setMaxResults(length);
		List<Object> list = query.list();
		System.out.println(hql);
		System.out.println(list);
        return list;
    }
    
    
    public List<Object> querygoodsforpage(String hql,final int beginset,final int length,String goodsname){
    	Session session=sessionFactory.getCurrentSession();
    	Query query = session.createQuery(hql);
		if (goodsname!=null)
		{
			query.setParameter(0, "%"+goodsname+"%");
		}
		else{
			query.setParameter(0, "%"+""+"%");
		}
        query.setFirstResult(beginset);
        query.setMaxResults(length);
		List<Object> list = query.list();
		System.out.println(hql);
		System.out.println(list);
        return list;
    }
    
    public List<Object> querygoodsforpage(String hql,final int beginset,final int length,Integer sellerid,String goodsname,Integer suptypeid,Integer subtypeid){
    	Session session=sessionFactory.getCurrentSession();
    	Query query = session.createQuery(hql);
    	hql=hql+" and u.sellerid="+sellerid;
		query = session.createQuery(hql);
		if (suptypeid!=null&&suptypeid!=1){
			hql=hql+" and u.suptypeid="+suptypeid;
			query = session.createQuery(hql);
		}		
		if (subtypeid!=null&&subtypeid!=1){
			hql=hql+" and u.subtypeid ="+subtypeid;
			query = session.createQuery(hql);
		}
		hql=hql+" order by id desc ";
		query = session.createQuery(hql);
		if (goodsname!=null)
		{
			query.setString(0, "%"+goodsname+"%");
		}
		else
			query.setString(0, "%"+""+"%");
        query.setFirstResult(beginset);
        query.setMaxResults(length);
		List<Object> list = query.list();
		System.out.println(hql);
		System.out.println(list);
        return list;
    }
    
    public List<Object> querygoodsforpage(String hql,final int beginset,final int length,Integer sellerid){
    	Session session=sessionFactory.getCurrentSession();
    	Query query = session.createQuery(hql);
    	hql=hql+" order by id desc ";
		query = session.createQuery(hql);
    	if (sellerid!=0){
    		query.setInteger(0,sellerid);
    	}
    		query.setFirstResult(beginset);
            query.setMaxResults(length);
    		List<Object> list = query.list();
    		System.out.println(hql);
    		System.out.println(list);
            return list;
		}
    
    public List<Object> querysecgoodsforpage(String hql,final int beginset,final int length,Integer userid){
    	Session session=sessionFactory.getCurrentSession();
    	Query query = session.createQuery(hql);
    	//hql=hql+" order by id desc ";
		query = session.createQuery(hql);
    	if (userid!=0){
    		query.setInteger(0,userid);
    	}
    		query.setFirstResult(beginset);
            query.setMaxResults(length);
    		List<Object> list = query.list();
    		System.out.println(hql);
    		System.out.println(list);
            return list;
		}
    
    /** 
     * 查询商品所有记录数
     * @param hql 查询的条件
     * @return 总记录数
     */
    public int querygoodsallrowcount(String hql,String goodsname,Integer suptypeid,Integer subtypeid){
    	//return getHibernateTemplate().find(hql).size();
    	Session session=sessionFactory.getCurrentSession();
		System.out.println("username="+suptypeid);
		Query query = session.createQuery(hql);
		//where u.goodsname like ? and u.id like and u.typeid like ?
		if (suptypeid!=null&&suptypeid!=1){
			hql=hql+" and u.suptypeid="+suptypeid;
			query = session.createQuery(hql);
		}		
		if (subtypeid!=null&&subtypeid!=1){
			hql=hql+" and u.subtypeid ="+subtypeid;
			query = session.createQuery(hql);
		}
		if (goodsname!=null)
		{
			query.setString(0, "%"+goodsname+"%");
		}
		else
			query.setString(0, "%"+""+"%");
		//query.setParameter("username",userpwd.getUsername());
		System.out.println(hql);
		List list = query.list();
		System.out.println(list);
		return list.size();
    }
    
    /** 
     * 查询商品所有记录数 + 上下架
     * @param hql 查询的条件
     * @return 总记录数
     */
    public int querygoodsallrowcount1(String hql,String goodsname,Integer suptypeid,Integer subtypeid,String shelves){
    	//return getHibernateTemplate().find(hql).size();
    	Session session=sessionFactory.getCurrentSession();
		System.out.println("username="+suptypeid);
		Query query = session.createQuery(hql);
		//where u.goodsname like ? and u.id like and u.typeid like ?
		if (suptypeid!=null&&suptypeid!=1){
			hql=hql+" and u.suptypeid="+suptypeid;
			query = session.createQuery(hql);
		}		
		if (subtypeid!=null&&subtypeid!=1){
			hql=hql+" and u.subtypeid ="+subtypeid;
			query = session.createQuery(hql);
		}
		if(shelves!=null){
		System.out.println(shelves);
		Integer shelves1 = Integer.parseInt(shelves);
		if (shelves1!=2){
			hql += " and u.shelves = " + shelves1;
			query = session.createQuery(hql);
		}
		}
		if (goodsname!=null)
		{
			query.setString(0, "%"+goodsname+"%");
		}
		else
			query.setString(0, "%"+""+"%");
		//query.setParameter("username",userpwd.getUsername());
		System.out.println(hql);
		List list = query.list();
		System.out.println(list);
		return list.size();
    }
    
    /** 
     * 查询combo所有记录数 + 上下架
     * @param hql 查询的条件
     * @return 总记录数
     */
    public int querycomboallrowcount1(String hql,String goodsname,String shelves){
    	//return getHibernateTemplate().find(hql).size();
    	Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		//where u.goodsname like ? and u.id like and u.typeid like ?
		if(shelves!=null){
		System.out.println(shelves);
		Integer shelves1 = Integer.parseInt(shelves);
		if (shelves1!=2){
			hql += " and u.shelves = " + shelves1;
			query = session.createQuery(hql);
		}
		}
		if (goodsname!=null)
		{
			query.setString(0, "%"+goodsname+"%");
		}
		else
			query.setString(0, "%"+""+"%");
		//query.setParameter("username",userpwd.getUsername());
		System.out.println(hql);
		List list = query.list();
		System.out.println(list);
		return list.size();
    }
    
    public int querygoodsallrowcount1(String hql,Integer sellerid,String goodsname,Integer suptypeid,Integer subtypeid){
    	//return getHibernateTemplate().find(hql).size();
    	Session session=sessionFactory.getCurrentSession();
		System.out.println("username="+suptypeid);
		Query query = session.createQuery(hql);
		//where u.goodsname like ? and u.id like and u.typeid like ?
		hql=hql+" and u.sellerid="+sellerid;
		query = session.createQuery(hql);
		if (suptypeid!=1){
			hql=hql+" and u.suptypeid="+suptypeid;
			query = session.createQuery(hql);
		}		
		if (subtypeid!=1){
			hql=hql+" and u.subtypeid ="+subtypeid;
			query = session.createQuery(hql);
		}
		if (goodsname!=null)
		{
			query.setString(0, "%"+goodsname+"%");
		}
		else
			query.setString(0, "%"+""+"%");
		//query.setParameter("username",userpwd.getUsername());
		System.out.println(hql);
		List list = query.list();
		System.out.println(list);
		return list.size();
    }
    
    /** 
     * 分页查询套餐
     * @param hql 查询的条件
     * @param beginset 开始记录
     * @param length 一次查询几条记录
     * @return
     */
    public List<Object> querycomboforpage(String hql,final int beginset,final int length,String goodsname){
    	Session session=sessionFactory.getCurrentSession();
	Query query = session.createQuery(hql);
	
	hql=hql+" order by id desc ";
	query = session.createQuery(hql);
	if (goodsname!=null)
	{
		query.setString(0, "%"+goodsname+"%");
	}
	else
		query.setString(0, "%"+""+"%");
    query.setFirstResult(beginset);
    query.setMaxResults(length);
	List<Object> list = query.list();
	System.out.println(hql);
	System.out.println(list);
    return list;
	}


    /** 
     * 查询套餐所有记录数
     * @param hql 查询的条件
     * @return 总记录数
     */
    public int querycomboallrowcount(String hql,String goodsname){
    	//return getHibernateTemplate().find(hql).size();
    	Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		//where u.goodsname like ? and u.id like and u.typeid like ?
		if (goodsname!=null)
		{
			query.setString(0, "%"+goodsname+"%");
		}
		else
			query.setString(0, "%"+""+"%");
		//query.setParameter("username",userpwd.getUsername());
		System.out.println(hql);
		List list = query.list();
		System.out.println(list);
		return list.size();
    }
    
    
    /** 
     * 分页查询订单+ startdate and enddate
     * @param hql 查询的条件
     * @param beginset 开始记录
     * @param length 一次查询几条记录
     * @return
     */
    public List<Object> queryorderforpage(String hql,final int beginset,final int length,String username,Integer orderNo,String startdate,String enddate,Integer isclosed){
    	Session session=sessionFactory.getCurrentSession();
		Query query ;	
		if(isclosed != 2){
			hql += " and u.isclosed = " + isclosed;
			
		}
		if(orderNo==null){
			orderNo = 0;
		}
		if(orderNo !=0){
			hql += " and u.orderNo like '%" + orderNo + "%'";
			
		}
		if(username !=null){
			hql += " and u.username like '%" + username + "%'";
			
		}
		if(startdate.equals("")){
		System.out.println(startdate+" is startdate1 in pagingImpl");}
		if(startdate != null && !startdate.equals("") ){
			System.out.println("enter counting");
			hql += " and u.orderday >= '"+startdate+"' ";
		}
		System.out.println(enddate+" is hql in pagingImpl");
		if(enddate != null && !enddate.equals("")){
			hql += "  and u.orderday <= '"+enddate+"' ";
		}
		
		hql = hql + " order by id desc";
		query = session.createQuery(hql);
		
		System.out.println(hql+" is hql in pagingImpl");
		 query.setFirstResult(beginset);
	     query.setMaxResults(length);
	     List<Object> list = query.list();
		System.out.println(list);
        return list;
    }

    /**
     * 分页统计商品销售额 + goodsname + startdate and enddate +isclosed
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
    public List<GoodsCount> querygoodscountforpage(String goodsname,String startdate,String enddate,Integer isclosed){
    	Session session=sessionFactory.getCurrentSession();
		Query query ;	
		
		String sql = "select goodsname,sum(number) number,sum(total) total ,isclosed from cs_order_detail where 1=1 ";
		

		if(isclosed != 2){
			System.out.println("isclosed in pagingImpl");
			
			sql += " and isclosed = " + isclosed;
		}
		if(goodsname!=null){
			System.out.println("goodsname in pagingImpl");
			
			sql += " and goodsname like '%" + goodsname + "%'";
		}
		if(startdate.equals("")){
			System.out.println(startdate+" is startdate2 in pagingImpl");}
		if(startdate != null && !startdate.equals("") ){
			System.out.println("enter counting");
			
			sql += " and orderday >= '"+startdate+"' ";
		}
		System.out.println(enddate+" is hql in pagingImpl");
		if(enddate != null && !enddate.equals("")){
			
			sql += "  and orderday <= '"+enddate+"' ";
		}
		
	
		sql += " group by goodsid";
		
		
		//Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Order_detail.class);
		//int sum = (Integer)criteria.setProjection(Projection.sum("total")).uniqueResult();
		
		SQLQuery query2 = session.createSQLQuery(sql).addEntity(GoodsCount.class);
		List<GoodsCount> list2 = query2.list();
		System.out.println("list2.size is "+list2.size()+" in the pagingdaoimpl and list2.first total is" + list2 + " and query2 "+query2);

		System.out.println(sql+" sql!");


        return list2;
    }

    /**
     * 分页统计商品销售额 + goodsname + startdate and enddate +isclosed
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
    public List<Turnover> queryturnoverforpage(String startdate,String enddate,Integer isclosed){
    	Session session=sessionFactory.getCurrentSession();
		Query query ;	
		
		String sql = "select sum(number) number,sum(total) total ,isclosed from cs_order_detail where 1=1 ";
		

		if(isclosed != 2){
			System.out.println("isclosed in pagingImpl");
			
			sql += " and isclosed = " + isclosed;
		}

		if(startdate.equals("")){
			System.out.println(startdate+" is startdate2 in pagingImpl");}
		if(startdate != null && !startdate.equals("") ){
			System.out.println("enter counting");
			
			sql += " and orderday >= '"+startdate+"' ";
		}
		System.out.println(enddate+" is hql in pagingImpl");
		if(enddate != null && !enddate.equals("")){
			
			sql += "  and orderday <= '"+enddate+"' ";
		}
	
		sql += " group by isclosed ";
		
		
		//Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Order_detail.class);
		//int sum = (Integer)criteria.setProjection(Projection.sum("total")).uniqueResult();
		
		SQLQuery query2 = session.createSQLQuery(sql).addEntity(Turnover.class);
		List<Turnover> list2 = query2.list();
		System.out.println("list2.size is "+list2.size()+" in the pagingdaoimpl and list2.first total is" + list2 + " and query2 "+query2);

		System.out.println(sql+" sql!");


        return list2;
    }
    
    /** 
     * 普通会员分页查询订单
     * @param hql 查询的条件
     * @param beginset 开始记录
     * @param length 一次查询几条记录
     * @return
     */
    public List<Object> queryorderforpagebyuser(String hql,final int beginset,final int length,String username){
    	Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);	
		hql=hql+" order by id desc ";
		query = session.createQuery(hql);
		query.setString(0, username);
        query.setFirstResult(beginset);
        query.setMaxResults(length);
		List<Object> list = query.list();
		System.out.println(hql);
		System.out.println(list);
        return list;
    }
    
    /** 
     * 查询订单所有记录数 + startdate and enddate
     * @param hql 查询的条件
     * @return 总记录数
     */
    public int queryorderallrowcount(String hql,String username,Integer orderNo,String startdate,String enddate,Integer isclosed){
    	//return getHibernateTemplate().find(hql).size();
    	Session session=sessionFactory.getCurrentSession();
		System.out.println("username="+username);
		Query query;
		
		
		
		if(isclosed != 2){
			hql += " and u.isclosed = " + isclosed;
			
		}
		if(orderNo==null){
			orderNo = 0;
		}
		if(orderNo !=0){
			hql += " and u.orderNo like '%" + orderNo + "%'";
			
		}
		if(username!=null){
			hql += " and u.username like '%" + username + "%'";
		}
		if(startdate.equals("")){
			System.out.println(startdate+" is startdate2 in pagingImpl");}
		if(startdate != null && !startdate.equals("") ){
			System.out.println("enter counting");
			hql += " and u.orderday >= '"+startdate+"' ";
		}
		System.out.println(enddate+" is hql in pagingImpl");
		if(enddate != null && !enddate.equals("")){
			hql += "  and u.orderday <= '"+enddate+"' ";
		}
		
		hql = hql + " order by id desc";
		query = session.createQuery(hql);
		
		System.out.println(hql+" is hql in pagingImpl");
		
		List list = query.list();
		System.out.println(list);
		return list.size();
    }
    
    /** 
     * 分页统计商品销售额 + goodsname + startdate and enddate +isclosed
     * @param hql 查询的条件
     * @return 总记录数
     */
    public int querygoodscountforpage(String hql,String goodsname,String startdate,String enddate,Integer isclosed){
    	//return getHibernateTemplate().find(hql).size();
    	Session session=sessionFactory.getCurrentSession();
		System.out.println("goodsname="+goodsname);
		Query query;
		
		String sql = "select goodsname,sum(number) number,sum(total) total ,isclosed from cs_order_detail where 1=1 ";
		
		
		if(isclosed != 2){
			System.out.println("isclosed in pagingImpl");
			hql += " and u.isclosed = " + isclosed;
			sql += " and isclosed = " + isclosed;
		}
		if(goodsname!=null){
			System.out.println("goodsname in pagingImpl");
			hql += " and u.goodsname like '%" + goodsname + "%'";
			sql += " and goodsname like '%" + goodsname + "%'";
		}
		if(startdate.equals("")){
			System.out.println(startdate+" is startdate2 in pagingImpl");}
		if(startdate != null && !startdate.equals("") ){
			System.out.println("enter counting");
			hql += " and u.orderday >= '"+startdate+"' ";
			sql += " and orderday >= '"+startdate+"' ";
		}
		System.out.println(enddate+" is hql in pagingImpl");
		if(enddate != null && !enddate.equals("")){
			hql += "  and u.orderday <= '"+enddate+"' ";
			sql += "  and orderday <= '"+enddate+"' ";
		}
		
		hql = hql + " order by id desc";
		sql += " group by goodsname";
		query = session.createQuery(hql);
		
		SQLQuery query2 = session.createSQLQuery(sql).addEntity(GoodsCount.class);
		List<GoodsCount> list2 = query2.list();
		System.out.println("list2.size is "+list2.size()+" in the pagingdaoimpl and list2.first total is" + list2 + " and query2 "+query2);
		System.out.println(list2.get(0).getGoodsname());
		System.out.println(hql+" is hql in pagingImpl");
		System.out.println(sql+" sql!");
		List list = query.list();
		System.out.println(list);
		return list.size();
    }
    
    
    /** 
     * 普通会员查询订单所有记录数
     * @param hql 查询的条件
     * @return 总记录数
     */
    public int queryorderallrowcountbyuser(String hql,String username){
    	//return getHibernateTemplate().find(hql).size();
    	Session session=sessionFactory.getCurrentSession();
		System.out.println("username="+username);
		Query query = session.createQuery(hql);
		query.setString(0, username);
		System.out.println(hql+" is hql in pagingImpl");
		List list = query.list();
		System.out.println(list);
		return list.size();
    }
    
    /** 
     * 分页查询推荐商家
     * @param hql 查询的条件
     * @param beginset 开始记录
     * @param length 一次查询几条记录
     * @return
     */
    public List<Object> querygreatsellerforpage(String hql,final int beginset,final int length,String name,Integer suptypeid,Integer subtypeid){
    	Session session=sessionFactory.getCurrentSession();
    	Query query = session.createQuery(hql);
    	if (suptypeid!=null&&suptypeid!=1){
    		hql=hql+" and u.suptypeid="+suptypeid;
    		query = session.createQuery(hql);
    	}		
    	if (subtypeid!=null&&subtypeid!=1){
    		hql=hql+" and u.subtypeid ="+subtypeid;
    		query = session.createQuery(hql);
    	}
    	hql=hql+" order by id desc ";
    	query = session.createQuery(hql);
    	if (name!=null)
    	{
    		query.setString(0, "%"+name+"%");
    	}
    	else
    		query.setString(0, "%"+""+"%");
    	query.setFirstResult(beginset);
    	query.setMaxResults(length);
    	List<Object> list = query.list();
    	System.out.println(hql);
    	System.out.println(list);
    	return list;
    }
    
    /** 
     * 查询所有推荐商家记录数
     * @param hql 查询的条件
     * @return 总记录数
     */
    public int querygreatsellerallrowcount(String hql,String name,Integer suptypeid,Integer subtypeid){
    	//return getHibernateTemplate().find(hql).size();
    	Session session=sessionFactory.getCurrentSession();
		System.out.println("username="+suptypeid);
		Query query = session.createQuery(hql);
		//where u.goodsname like ? and u.id like and u.typeid like ?
		if (suptypeid!=null&&suptypeid!=1){
			hql=hql+" and u.suptypeid="+suptypeid;
			query = session.createQuery(hql);
		}		
		if (subtypeid!=null&&subtypeid!=1){
			hql=hql+" and u.subtypeid ="+subtypeid;
			query = session.createQuery(hql);
		}
		if (name!=null)
		{
			query.setString(0, "%"+name+"%");
		}
		else
			query.setString(0, "%"+""+"%");
		//query.setParameter("username",userpwd.getUsername());
		System.out.println(hql);
		List list = query.list();
		System.out.println(list);
		return list.size();
    }
}
