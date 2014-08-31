package cs.dao;
	import java.util.List;

import cs.entity.GoodsCount;
import cs.entity.Turnover;
import cs.vo.PageModel;

	public interface PagingDAO {
		 /** 
	     * 分页查询商品
	     * @param hql 查询的条件
	     * @param beginset 开始记录
	     * @param length 一次查询几条记录
	     * @return
	     */
	    public List<Object> querytakeoutforpage(String hql,final int beginset,final int length,String goodsname,Integer suptypeid,Integer subtypeid);
		 /** 
	     * 分页查询商品
	     * @param hql 查询的条件
	     * @param beginset 开始记录
	     * @param length 一次查询几条记录
	     * @return
	     */
	    public List<Object> querysellertypeforpage(String hql,final int beginset,final int length,String name,Integer suptypeid,Integer subtypeid);
	    
		 /** 
	     * 分页查询商品
	     * @param hql 查询的条件
	     * @param beginset 开始记录
	     * @param length 一次查询几条记录
	     * @return
	     */
	    public List<Object> querysecgoodsforpage(String hql,final int beginset,final int length,String goodsname,Integer suptypeid,Integer subtypeid);
		/** *//**
	     * 分页查询
	     * @param hql 查询的条件
	     * @param beginset 开始记录
	     * @param length 一次查询几条记录
	     * @return
	     */
	    public List<Object> queryforpage(String hql,final int beginset,final int length,String username);
	    
	    /** *//**
	     * 查询所有记录数
	     * @param hql 查询的条件
	     * @return 总记录数
	     */
	    public int queryallrowcount(String hql,String username);
	    
	    
	    public int querygoodsallrowcount(String hql,int sellerid);
	    
	    
	    public int querygoodsallrowcount(String hql,String goodsname);
	    
	    
	    public int querysecgoodsallrowcount(String hql,int userid);
	    
	    /** 
	     * 分页查询商品
	     * @param hql 查询的条件
	     * @param beginset 开始记录
	     * @param length 一次查询几条记录
	     * @return
	     */
	    public List<Object> querygoodsforpage(String hql,final int beginset,final int length,String goodsname,Integer suptypeid,Integer subtypeid);
	    
	    /** 
	     * 分页查询商品 + 上下架查询
	     * @param hql 查询的条件
	     * @param beginset 开始记录
	     * @param length 一次查询几条记录
	     * @return
	     */
	    public List<Object> querygoodsforpage1(String hql,final int beginset,final int length,String goodsname,Integer suptypeid,Integer subtypeid,String shelves);
	    
	    /** 
	     * 分页查询combo + 上下架查询
	     * @param hql 查询的条件
	     * @param beginset 开始记录
	     * @param length 一次查询几条记录
	     * @return
	     */
	    public List<Object> querycomboforpage1(String hql,final int beginset,final int length,String goodsname,String shelves);
	    
	    
	    public List<Object> querygoodsforpage(String hql,final int beginset,final int length,String goodsname);
	    
	    public List<Object> querygoodsforpage(String hql,final int beginset,final int length,Integer sellerid);
	    
	    public List<Object> querysecgoodsforpage(String hql,final int beginset,final int length,Integer userid);
	    
	    /**
	     * 分页查询seller的外卖
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
	    
	public int querygoodsallrowcount1(String phql,Integer sellerid,String goodsname,Integer suptypeid,Integer subtypeid);
	
	
	public int querygoodsallrowcount(String phql,Integer sellerid,Integer suptypeid,Integer subtypeid);
	    
	public List<Object> querygoodsforpage(String hql,final int beginset,final int length,Integer sellerid,Integer suptypeid,Integer subtypeid);    
	    /** 
	     * 查询商品所有记录数
	     * @param hql 查询的条件
	     * @return 总记录数
	     */
	    public int querygoodsallrowcount(String hql,String goodsname,Integer suptypeid,Integer subtypeid);
	    
	    /** 
	     * 查询商品所有记录数 + 是否上下架
	     * @param hql 查询的条件
	     * @return 总记录数
	     */
	    public int querygoodsallrowcount1(String hql,String goodsname,Integer suptypeid,Integer subtypeid,String shelves);
	    
	    /** 
	     * 查询combo所有记录数 + 是否上下架
	     * @param hql 查询的条件
	     * @return 总记录数
	     */
	    public int querycomboallrowcount1(String hql,String goodsname,String shelves);
	    
	    /** 
	     * 分页查询套餐
	     * @param hql 查询的条件
	     * @param beginset 开始记录
	     * @param length 一次查询几条记录
	     * @return
	     */
	    public List<Object> querycomboforpage(String hql,final int beginset,final int length,String goodsname);
	    
	    public List<Object> querygoodsforpage(String hql,final int beginset,final int length,Integer sellerid,String goodsname,Integer suptypeid,Integer subtypeid);
	    /** 
	     * 查询套餐所有记录数
	     * @param hql 查询的条件
	     * @return 总记录数
	     */
	    public int querycomboallrowcount(String hql,String goodsname);
	    
	    /** 
	     * 分页查询所有推荐商家
	     * @param hql 查询的条件
	     * @param beginset 开始记录
	     * @param length 一次查询几条记录
	     * @return
	     */
	    public List<Object> querygreatsellerforpage(String hql,final int beginset,final int length,String name,Integer suptypeid,Integer subtypeid);
	    
	    /** 
	     * 查询所有推荐商家记录数
	     * @param hql 查询的条件
	     * @return 总记录数
	     */
	    public int querygreatsellerallrowcount(String hql,String name,Integer suptypeid,Integer subtypeid);
	    
	    /** 
	     * 分页订单查询 + startdate and enddate
	     * @param hql 查询的条件
	     * @param beginset 开始记录
	     * @param length 一次查询几条记录
	     * @return
	     */
	    public List<Object> queryorderforpage(String hql,final int beginset,final int length,String username,Integer orderNo,String startdate,String enddate,Integer isclosed);
	    
	    /**
	     * 分页统计商品销售额 + goodsname + startdate and enddate +isclosed
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
	    public List<GoodsCount> querygoodscountforpage(String goodsname,String startdate,String enddate,Integer isclosed);
	    
	    /**
	     * 统计营业额额 +  startdate and enddate +isclosed
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
	    public List<Turnover> queryturnoverforpage(String startdate,String enddate,Integer isclosed);

	    
	    /** 
	     * 分页统计商品销售额 + goodsname + startdate and enddate +isclosed
	     * @param hql 查询的条件
	     * @return 总记录数
	     */
	    public int querygoodscountforpage(String hql,String goodsname,String startdate,String enddate,Integer isclosed);

	    /** 
	     * 查询所有订单记录数 + startdate and enddate
	     * @param hql 查询的条件
	     * @return 总记录数
	     */
	    public int queryorderallrowcount(String hql,String username,Integer orderNo,String startdate,String enddate,Integer isclosed);

	    
	    /** 
	     * 普通会员分页订单查询
	     * @param hql 查询的条件
	     * @param beginset 开始记录
	     * @param length 一次查询几条记录
	     * @return
	     */
	    public List<Object> queryorderforpagebyuser(String hql,final int beginset,final int length,String username);
	    
	    
	    /** 
	     * 普通会员查询所有订单记录数
	     * @param hql 查询的条件
	     * @return 总记录数
	     */
	    public int queryorderallrowcountbyuser(String hql,String username);

	
	}
