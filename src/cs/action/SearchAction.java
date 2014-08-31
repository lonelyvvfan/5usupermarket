package cs.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Goods;
import cs.service.PagingService;
import cs.vo.PageModel;

public class SearchAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer typeid; // 类型id
	private String goodsname; // 商品名
	private String introduce; // 商品介绍
	private double price; // 单价
	private double nowprice; // 新价
	private String savepath; // 图片路径
	private Integer newgoods; // 是否为新品
	private Integer hot; // 是否为热销商品
	private Integer special; // 是否为特价商品
	private Integer health; // 是否为健康商品
	private Integer recommend; // 是否为推荐商品
	private Integer monthsell;
	private Integer zan;
	private PagingService pagingService;
	private Integer pagesize=6;
	
	private Goods goods;
	private PageModel goodspage=new PageModel();
	private PageModel secgoodspage=new PageModel();
	private PageModel combopage=new PageModel();
	private PageModel takeoutpage=new PageModel();
	
	public String search() throws Exception{
		ActionContext.getContext().getSession().put("findgoodsname", goodsname);
		 String phql="from Goods goods where goods.goodsname like ?";
	        //this.pageBean = pagingService.queryForPage(phql,2, page); 
	   	    
	   	    System.out.println(phql);
	   	    if ((Object)goodspage.getCurrentPage()==null)
	   	    	goodspage.setCurrentPage(1);
	   	    goodspage = pagingService.querygoodsforpage(phql,pagesize, goodspage.getCurrentPage(),goodsname);
	        List<Integer> list1=new ArrayList<Integer>();
	        for (Integer i=goodspage.getCurrentPage()-2;i<=goodspage.getCurrentPage()+2;i++)
	        {
	        	if (i<=0||i>goodspage.getTotalPage())
	        		continue;
	        	list1.add(i);
	        }
	        goodspage.setPageList(list1);
	        
	        String phql1="from Secondgoods secondgoods where secondgoods.goodsname like ?";
	        //this.pageBean = pagingService.queryForPage(phql,2, page); 
	   	    
	   	    System.out.println(phql);
	   	    if ((Object)secgoodspage.getCurrentPage()==null)
	   	    	secgoodspage.setCurrentPage(1);
	   	    secgoodspage = pagingService.querygoodsforpage(phql1,pagesize, secgoodspage.getCurrentPage(),goodsname);
	        List<Integer> list2=new ArrayList<Integer>();
	        for (Integer i=secgoodspage.getCurrentPage()-2;i<=secgoodspage.getCurrentPage()+2;i++)
	        {
	        	if (i<=0||i>secgoodspage.getTotalPage())
	        		continue;
	        	list2.add(i);
	        }
	        secgoodspage.setPageList(list2);
	        
	        
	        String phql2="from Combo combo where combo.goodsname like ?";
	        //this.pageBean = pagingService.queryForPage(phql,2, page); 
	   	    System.out.println(phql);
	   	    if ((Object)combopage.getCurrentPage()==null)
	   	    	combopage.setCurrentPage(1);
	   	    combopage = pagingService.querygoodsforpage(phql2,pagesize, combopage.getCurrentPage(),goodsname);
	        List<Integer> list3=new ArrayList<Integer>();
	        for (Integer i=combopage.getCurrentPage()-2;i<=combopage.getCurrentPage()+2;i++)
	        {
	        	if (i<=0||i>combopage.getTotalPage())
	        		continue;
	        	list3.add(i);
	        }
	        combopage.setPageList(list3);
	        
	        String phql3="from Takeout takeout where takeout.goodsname like ?";
	        //this.pageBean = pagingService.queryForPage(phql,2, page); 
	   	    System.out.println(phql);
	   	    if ((Object)takeoutpage.getCurrentPage()==null)
	   	    	takeoutpage.setCurrentPage(1);
	   	 takeoutpage = pagingService.querygoodsforpage(phql3,pagesize, takeoutpage.getCurrentPage(),goodsname);
	        List<Integer> list4=new ArrayList<Integer>();
	        for (Integer i=takeoutpage.getCurrentPage()-2;i<=takeoutpage.getCurrentPage()+2;i++)
	        {
	        	if (i<=0||i>takeoutpage.getTotalPage())
	        		continue;
	        	list4.add(i);
	        }
	        takeoutpage.setPageList(list4);
	        
	        return "findsuccess";
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getNowprice() {
		return nowprice;
	}
	public void setNowprice(double nowprice) {
		this.nowprice = nowprice;
	}
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	public Integer getNewgoods() {
		return newgoods;
	}
	public void setNewgoods(Integer newgoods) {
		this.newgoods = newgoods;
	}
	public Integer getHot() {
		return hot;
	}
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	public Integer getSpecial() {
		return special;
	}
	public void setSpecial(Integer special) {
		this.special = special;
	}
	public Integer getHealth() {
		return health;
	}
	public void setHealth(Integer health) {
		this.health = health;
	}
	public Integer getRecommend() {
		return recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	public Integer getMonthsell() {
		return monthsell;
	}
	public void setMonthsell(Integer monthsell) {
		this.monthsell = monthsell;
	}
	public Integer getZan() {
		return zan;
	}
	public void setZan(Integer zan) {
		this.zan = zan;
	}
	public PagingService getPagingService() {
		return pagingService;
	}
	public void setPagingService(PagingService pagingService) {
		this.pagingService = pagingService;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public PageModel getGoodspage() {
		return goodspage;
	}
	public void setGoodspage(PageModel goodspage) {
		this.goodspage = goodspage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PageModel getSecgoodspage() {
		return secgoodspage;
	}

	public void setSecgoodspage(PageModel secgoodspage) {
		this.secgoodspage = secgoodspage;
	}

	public PageModel getCombopage() {
		return combopage;
	}

	public void setCombopage(PageModel combopage) {
		this.combopage = combopage;
	}

	public PageModel getTakeoutpage() {
		return takeoutpage;
	}


	public void setTakeoutpage(PageModel takeoutpage) {
		this.takeoutpage = takeoutpage;
	}
	

}
