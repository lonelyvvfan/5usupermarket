package cs.service;

	import java.util.ArrayList;
import java.util.List;

import cs.dao.PagingDAO;
import cs.entity.GoodsCount;
import cs.entity.Turnover;
import cs.vo.PageModel;

	public class PagingServiceImpl implements PagingService{

		  //通过applicationContext.xml配置文件注入PagingDao的值
	    private PagingDAO pagingDAO;
	    public void setPagingDAO(PagingDAO pagingDAO) {
	        this.pagingDAO = pagingDAO;
	    }
	    public PagingDAO getPagingDAO(){
	    	return this.pagingDAO;
	    }
	    
	    /** *//**
	     * 分页查询
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    public PageModel queryforpage(String phql,int pageSize,int page,String username){

	        if (pageSize<=0)
	        	pageSize=5;
	    	final String hql = phql;        //查询的表
	        int allRow = pagingDAO.queryallrowcount(hql,username);    //总记录数
	        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
	        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
	        final int length = pageSize;    //每页记录数
	        final int currentPage = PageModel.countCurrentPage(page);
	        List<Object> list = pagingDAO.queryforpage(hql,beginset, length,username);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pageSize);    
	        pagem.setCurrentPage(currentPage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    
	    /** *//**
	     * 分页查询
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    /*
	    public PageModel queryforpagebyid(String phql,int pageSize,int page,int typeid){

	        if (pageSize<=0)
	        	pageSize=5;
	    	final String hql = phql;        //查询的表
	        int allRow = pagingDAO.queryallrowcountbyid(hql,typeid);    //总记录数
	        int totalPage = UserPage.countTotalPage(pageSize, allRow);    //总页数
	        final int beginset = UserPage.countBeginset(pageSize, page);    //当前页开始记录
	        final int length = pageSize;    //每页记录数
	        final int currentPage = PageModel.countCurrentPage(page);
	        List<Object> list = pagingDAO.queryforpagebyid(hql,beginset, length,typeid);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pageSize);    
	        pagem.setCurrentPage(currentPage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    */
	    
	    /** *//**
	     * 分页查询商品 + 是否上下架
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    public PageModel querygoodsforpage(String phql,int pageSize,int page,String goodsname,Integer suptypeid,Integer subtypeid){

	        if (pageSize<=0)
	        	pageSize=5;
	    	final String hql = phql;        //查询的表
	        int allRow = pagingDAO.querygoodsallrowcount(hql,goodsname,suptypeid,subtypeid);    //总记录数
	        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
	        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
	        final int length = pageSize;    //每页记录数
	        final int currentPage = PageModel.countCurrentPage(page);
	        List<Object> list = pagingDAO.querygoodsforpage(hql,beginset, length,goodsname,suptypeid,subtypeid);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pageSize);    
	        pagem.setCurrentPage(currentPage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    
	    /** *//**
	     * 分页查询商品 + 是否上下架
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    public PageModel querygoodsforpage1(String phql,int pageSize,int page,String goodsname,Integer suptypeid,Integer subtypeid,String shelves){

	        if (pageSize<=0)
	        	pageSize=5;
	    	final String hql = phql;        //查询的表
	        int allRow = pagingDAO.querygoodsallrowcount1(hql,goodsname,suptypeid,subtypeid,shelves);    //总记录数
	        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
	        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
	        final int length = pageSize;    //每页记录数
	        final int currentPage = PageModel.countCurrentPage(page);
	        List<Object> list = pagingDAO.querygoodsforpage1(hql,beginset, length,goodsname,suptypeid,subtypeid,shelves);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pageSize);    
	        pagem.setCurrentPage(currentPage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    
	    /** *//**
	     * 分页查询商品
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    public PageModel querysellertypeforpage(String phql,int pageSize,int page,String name,Integer suptypeid,Integer subtypeid){

	        if (pageSize<=0)
	        	pageSize=5;
	    	final String hql = phql;        //查询的表
	        int allRow = pagingDAO.querygoodsallrowcount(hql,name,suptypeid,subtypeid);    //总记录数
	        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
	        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
	        final int length = pageSize;    //每页记录数
	        final int currentPage = PageModel.countCurrentPage(page);
	        List<Object> list = pagingDAO.querysellertypeforpage(hql,beginset, length,name,suptypeid,subtypeid);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pageSize);    
	        pagem.setCurrentPage(currentPage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    
	    /** *//**
	     * 分页查询商品
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    public PageModel querysecgoodsforpage(String phql,int pageSize,int page,String goodsname,Integer suptypeid,Integer subtypeid){

	        if (pageSize<=0)
	        	pageSize=5;
	    	final String hql = phql;        //查询的表
	        int allRow = pagingDAO.querygoodsallrowcount(hql,goodsname,suptypeid,subtypeid);    //总记录数
	        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
	        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
	        final int length = pageSize;    //每页记录数
	        final int currentPage = PageModel.countCurrentPage(page);
	        List<Object> list = pagingDAO.querysecgoodsforpage(hql,beginset, length,goodsname,suptypeid,subtypeid);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pageSize);    
	        pagem.setCurrentPage(currentPage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    
	    
	    public PageModel querygoodsforpage(String phql,int pageSize,int page,String goodsname){
	    	if (pageSize<=0)
	        	pageSize=5;
	    	final String hql = phql;        //查询的表
	        int allRow = pagingDAO.querygoodsallrowcount(hql,goodsname);    //总记录数
	        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
	        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
	        final int length = pageSize;    //每页记录数
	        final int currentPage = PageModel.countCurrentPage(page);
	        List<Object> list = pagingDAO.querygoodsforpage(hql,beginset, length,goodsname);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pageSize);    
	        pagem.setCurrentPage(currentPage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    
	    
	    public PageModel querygoodsforpage(String phql,int pageSize,int page,Integer  sellerid,Integer suptypeid,Integer subtypeid){
	    	 if (pageSize<=0)
		        	pageSize=5;
		    	final String hql = phql;        //查询的表
		        int allRow = pagingDAO.querygoodsallrowcount(hql,sellerid,suptypeid,subtypeid);    //总记录数
		        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
		        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
		        final int length = pageSize;    //每页记录数
		        final int currentPage = PageModel.countCurrentPage(page);
		        List<Object> list = pagingDAO.querygoodsforpage(hql,beginset, length,sellerid,suptypeid,subtypeid);        //"一页"的记录
		        List<Integer> pageList = new ArrayList<Integer>();
		        for(int i=1;i<=totalPage;i++){
		        	pageList.add(i);
		        }
		        //把分页信息保存到Bean中
		        PageModel pagem = new PageModel();
		        pagem.setPageSize(pageSize);    
		        pagem.setCurrentPage(currentPage);
		        pagem.setAllRow(allRow);
		        pagem.setTotalPage(totalPage);
		        pagem.setList(list);
		        pagem.setPageList(pageList);
		        pagem.init();
		        return pagem;
	    }
	    
	    
	    public PageModel querygoodsforpage(String phql,int pageSize,int page,Integer sellerid){
	    	 if (pageSize<=0)
		        	pageSize=5;
		    	final String hql = phql;        //查询的表
		        int allRow = pagingDAO.querygoodsallrowcount(hql,sellerid);    //总记录数
		        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
		        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
		        final int length = pageSize;    //每页记录数
		        final int currentPage = PageModel.countCurrentPage(page);
		        List<Object> list = pagingDAO.querygoodsforpage(hql,beginset,length,sellerid);        //"一页"的记录
		        List<Integer> pageList = new ArrayList<Integer>();
		        for(int i=1;i<=totalPage;i++){
		        	pageList.add(i);
		        }
		        //把分页信息保存到Bean中
		        PageModel pagem = new PageModel();
		        pagem.setPageSize(pageSize);    
		        pagem.setCurrentPage(currentPage);
		        pagem.setAllRow(allRow);
		        pagem.setTotalPage(totalPage);
		        pagem.setList(list);
		        pagem.setPageList(pageList);
		        pagem.init();
		        return pagem;
	    }
	    
	    /**
	     * 分页查询二手商品
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    public PageModel querysecgoodsforpage(String phql,int pageSize,int page,Integer userid){
	    	 if (pageSize<=0)
		        	pageSize=5;
	    	 	System.out.println(userid+"is userid in pageimpl");
		    	final String hql = phql;        //查询的表
		        int allRow = pagingDAO.querysecgoodsallrowcount(hql,userid);    //总记录数
		        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
		        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
		        final int length = pageSize;    //每页记录数
		        final int currentPage = PageModel.countCurrentPage(page);
		        List<Object> list = pagingDAO.querysecgoodsforpage(hql,beginset,length,userid);        //"一页"的记录
		        List<Integer> pageList = new ArrayList<Integer>();
		        for(int i=1;i<=totalPage;i++){
		        	pageList.add(i);
		        }
		        //把分页信息保存到Bean中
		        PageModel pagem = new PageModel();
		        pagem.setPageSize(pageSize);    
		        pagem.setCurrentPage(currentPage);
		        pagem.setAllRow(allRow);
		        pagem.setTotalPage(totalPage);
		        pagem.setList(list);
		        pagem.setPageList(pageList);
		        pagem.init();
		        return pagem;
	    }
	    
	    /**
	     * 分页查询seller的外卖
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
	    public PageModel querygoodsforpage(String phql,int pageSize,int page,Integer sellerid,String goodsname,Integer suptypeid,Integer subtypeid){
	    	if (pageSize<=0)
	        	pageSize=5;
	    	final String hql = phql;        //查询的表
	    	int allRow = pagingDAO.querygoodsallrowcount1(hql,sellerid,goodsname,suptypeid,subtypeid);    //总记录数
	        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
	        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
	        final int length = pageSize;    //每页记录数
	        final int currentPage = PageModel.countCurrentPage(page);
	        List<Object> list = pagingDAO.querygoodsforpage(hql,beginset, length,sellerid,goodsname,suptypeid,subtypeid);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pageSize);    
	        pagem.setCurrentPage(currentPage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    
	    
	    /** 
	     * 分页查询套餐
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    public PageModel querycomboforpage(String phql,int pageSize,int page,String goodsname){

	        if (pageSize<=0)
	        	pageSize=5;
	    	final String hql = phql;        //查询的表
	        int allRow = pagingDAO.querycomboallrowcount(hql,goodsname);    //总记录数
	        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
	        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
	        final int length = pageSize;    //每页记录数
	        final int currentPage = PageModel.countCurrentPage(page);
	        List<Object> list = pagingDAO.querycomboforpage(hql,beginset, length,goodsname);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pageSize);    
	        pagem.setCurrentPage(currentPage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    
	    /** 
	     * 分页查询套餐
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    public PageModel querycomboforpage1(String phql,int pageSize,int page,String goodsname,String shelves){

	        if (pageSize<=0)
	        	pageSize=5;
	    	final String hql = phql;        //查询的表
	        int allRow = pagingDAO.querycomboallrowcount1(hql,goodsname,shelves);    //总记录数
	        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
	        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
	        final int length = pageSize;    //每页记录数
	        final int currentPage = PageModel.countCurrentPage(page);
	        List<Object> list = pagingDAO.querycomboforpage1(hql,beginset, length,goodsname,shelves);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pageSize);    
	        pagem.setCurrentPage(currentPage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    
	    /** *//**
	     * 分页查询推荐商家
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    public PageModel querygreatsellerforpage(String phql,int pageSize,int page,String name,Integer suptypeid,Integer subtypeid){

	        if (pageSize<=0)
	        	pageSize=5;
	    	final String hql = phql;        //查询的表
	        int allRow = pagingDAO.querygreatsellerallrowcount(hql,name,suptypeid,subtypeid);    //总记录数
	        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
	        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
	        final int length = pageSize;    //每页记录数
	        final int currentPage = PageModel.countCurrentPage(page);
	        List<Object> list = pagingDAO.querygreatsellerforpage(hql,beginset, length,name,suptypeid,subtypeid);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pageSize);    
	        pagem.setCurrentPage(currentPage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    
	    /**
	     * 管理员分页查询订单 + startdate and enddate
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
	    public PageModel queryorderforpage(String phql,int pageSize,int page,String username,Integer orderNo,String startdate,String enddate,Integer isclosed){
	    	if (pageSize<=0)
	        	pageSize=5;
	    	final String hql = phql;        //查询的表
	        int allRow = pagingDAO.queryorderallrowcount(hql,username,orderNo,startdate,enddate,isclosed);    //总记录数
	        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
	        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
	        final int length = pageSize;    //每页记录数
	        final int currentPage = PageModel.countCurrentPage(page);
	        List<Object> list = pagingDAO.queryorderforpage(hql,beginset, length, username ,orderNo,startdate,enddate, isclosed);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pageSize);    
	        pagem.setCurrentPage(currentPage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    
	    /**
	     * 分页统计商品销售额 + goodsname + startdate and enddate +isclosed
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
	
	    
	    /**
	     * 普通会员分页查询订单
	     * @param currentPage 当前第几页
	     * @param pageSize 每页大小
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     */
	    //public PageModel queryforpagebyid(String phql,int pageSize,int currentPage,int typeid);
	    public PageModel queryorderforpagebyuser(String phql,int pageSize,int page,String username){
	    	if (pageSize<=0)
	        	pageSize=5;
	    	final String hql = phql;        //查询的表
	        int allRow = pagingDAO.queryorderallrowcountbyuser(hql,username);    //总记录数
	        int totalPage = PageModel.countTotalPage(pageSize, allRow);    //总页数
	        final int beginset = PageModel.countBeginset(pageSize, page);    //当前页开始记录
	        final int length = pageSize;    //每页记录数
	        final int currentPage = PageModel.countCurrentPage(page);
	        List<Object> list = pagingDAO.queryorderforpagebyuser(hql,beginset, length, username);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pageSize);    
	        pagem.setCurrentPage(currentPage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    
	    
	    public PageModel querytakeoutgoodsforpage(String phql, Integer pagesize,
				Integer currentPage, String goodsname, Integer suptypeid,
				Integer subtypeid){
	    	if (pagesize<=0)
	    		pagesize=5;
	    	final String hql = phql;        //查询的表
	    	int allRow = pagingDAO.querygoodsallrowcount(hql,goodsname,suptypeid,subtypeid);    //总记录数
	        int totalPage = PageModel.countTotalPage(pagesize, allRow);    //总页数
	        final int beginset = PageModel.countBeginset(pagesize, currentPage);    //当前页开始记录
	        final int length = pagesize;    //每页记录数
	        final int currentpage = PageModel.countCurrentPage(currentPage);
	        List<Object> list = pagingDAO.querytakeoutforpage(hql,beginset, length,goodsname,suptypeid,subtypeid);        //"一页"的记录
	        List<Integer> pageList = new ArrayList<Integer>();
	        for(int i=1;i<=totalPage;i++){
	        	pageList.add(i);
	        }
	        //把分页信息保存到Bean中
	        PageModel pagem = new PageModel();
	        pagem.setPageSize(pagesize);    
	        pagem.setCurrentPage(currentpage);
	        pagem.setAllRow(allRow);
	        pagem.setTotalPage(totalPage);
	        pagem.setList(list);
	        pagem.setPageList(pageList);
	        pagem.init();
	        return pagem;
	    }
	    
	    
		@Override
		public List<GoodsCount> querygoodscountforpage(String goodsname,
				String startdate, String enddate, Integer isclosed) {
			// TODO Auto-generated method stub
			 List<GoodsCount> list = pagingDAO.querygoodscountforpage(goodsname,startdate,enddate, isclosed); 
			return list;
		}
		
		@Override
		public List<Turnover> queryturnoverforpage(String startdate,String enddate,Integer isclosed) {
			// TODO Auto-generated method stub
			 List<Turnover> list = pagingDAO.queryturnoverforpage(startdate, enddate, isclosed);
			return list;
		}
}
