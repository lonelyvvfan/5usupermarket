package cs.service;

import cs.vo.PageModel;
import cs.vo.UserPage;
import cs.entity.GoodsCount;
import cs.entity.Turnover;

import java.util.List;

public interface PagingService {

	 /** *//**
     * 分页查询商品
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    public PageModel querysellertypeforpage(String phql,int pageSize,int page,String name,Integer suptypeid,Integer subtypeid);
	 /** *//**
     * 分页查询商品
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    public PageModel querysecgoodsforpage(String phql,int pageSize,int page,String goodsname,Integer suptypeid,Integer subtypeid);
     /**
     * 分页查询
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    public PageModel queryforpage(String phql,int pageSize,int currentPage,String username);
    
    /**
     * 分页查询商品
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
    public PageModel querygoodsforpage(String phql,int pageSize,int page,String goodsname,Integer suptypeid,Integer subtypeid);
    
    /**
     * 分页查询商品 + 是否上下架
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
    public PageModel querygoodsforpage1(String phql,int pageSize,int page,String goodsname,Integer suptypeid,Integer subtypeid,String shelves);
    
    public PageModel querygoodsforpage(String phql,int pageSize,int page,String goodsname);
    
    public PageModel querygoodsforpage(String phql,int pageSize,int page,Integer  sellerid,Integer suptypeid,Integer subtypeid);
    
    public PageModel querygoodsforpage(String phql,int pageSize,int page,Integer sellerid);

    /**
     * 分页查询二手商品
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    public PageModel querysecgoodsforpage(String phql,int pageSize,int page,Integer userid);

    
    /**
     * 分页查询seller的外卖
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
    public PageModel querygoodsforpage(String phql,int pageSize,int page,Integer sellerid,String goodsname,Integer suptypeid,Integer subtypeid);

    
    
    /**
     * 分页查询套餐
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
    public PageModel querycomboforpage(String phql,int pageSize,int page,String goodsname);

    /**
     * 分页查询套餐
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
    public PageModel querycomboforpage1(String phql,int pageSize,int page,String goodsname,String shelves);

    
    /**
     * 分页查询推荐商家
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
    public PageModel querygreatsellerforpage(String phql,int pageSize,int page,String name,Integer suptypeid,Integer subtypeid);
    
    /**
     * 分页查询订单 + startdate and enddate
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
    public PageModel queryorderforpage(String phql,int pageSize,int page,String username,Integer orderNo,String startdate,String enddate,Integer isclosed);
    
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
     * 片桃花源分页查询订单
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
    public PageModel queryorderforpagebyuser(String phql,int pageSize,int page,String username);
	public PageModel querytakeoutgoodsforpage(String phql, Integer pagesize,
			Integer currentPage, String goodsname, Integer suptypeid,
			Integer subtypeid);
}
