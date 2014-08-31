package cs.action.user;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.service.AdminService;
import cs.service.GoodsService;
import cs.service.PagingService;
import cs.vo.PageModel;

public class GoodsAction extends ActionSupport {
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
	private PagingService pagingService;
	private Integer pagesize=5;

	private GoodsService goodsService;
	private Goods goods;
	private List<Goods> list;
	private List<Goods_subtype> goods_subtypes;
	private List<Goods_supertype> goods_supertypes;
	private Integer monthsell;
	private Integer zan;


	private PageModel goodspage=new PageModel();

	
	/**
	 * 显示全部商品
	 * @return String
	 */
	public String showgoods(){
		goods_supertypes = goodsService.showsuptype();
		goods_subtypes = goodsService.showsubtype();
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Goods";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    System.out.println(phql);
   	    if ((Object)goodspage.getCurrentPage()==null)
   	    	goodspage.setCurrentPage(1);
   	    goodsname=null;
   	    goodspage = pagingService.queryforpage(phql,pagesize, goodspage.getCurrentPage(),goodsname);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=goodspage.getCurrentPage()-2;i<=goodspage.getCurrentPage()+2;i++)
        {
        	if (i<=0||i>goodspage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        goodspage.setPageList(list1);
        return "goods";
    }
	
	
	public String dianzan() throws Exception{
		boolean r = false;
		r = goodsService.dianzan(id);
		altershow();
		if(r)
			return "alterShow";
		else 
			return "failure";
	}
	
	/**
	 * 显示子类
	 * @return String
	 */
	public String showsubtype() throws Exception{
		goods_subtypes = goodsService.showsubtype();
		System.out.println(goods_subtypes);
		return "showsubtype";
	}
	
	public String showsuptype() throws Exception{
		goods_supertypes = goodsService.showsuptype();
		System.out.println(goods_supertypes);
		return "showsupertype";
	}

	/**
	 * 根据goodsname找到指定商品 返回list
	 * 
	 * @return String
	 */
	public String findgoodsspecial(){
		System.out.println(goodsname);
		goods_supertypes = goodsService.showsuptype();
		goods_subtypes = goodsService.showsubtype();
		System.out.println("goodsname="+goodsname);
	   	System.out.println("id="+id);
	   	System.out.println("typeid="+typeid);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Goods as u where goodsname like ?";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	    if ((Object)goodspage.getCurrentPage()==null)
   	    	goodspage.setCurrentPage(1);
   	    goodspage = pagingService.querygoodsforpage(phql,pagesize, goodspage.getCurrentPage(),goodsname,id,typeid);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=goodspage.getCurrentPage()-2;i<=goodspage.getCurrentPage()+2;i++)
        {
        	if (i<=0||i>goodspage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        goodspage.setPageList(list1);
        return "findsuccess";
	}
	
	/*
	public String findgoodstype(){
		goods_supertypes = goodsService.showsuptype();
		goods_subtypes = goodsService.showsubtype();
		list = goodsService.findGoodsbyid2(typeid);
   	    for(int i=0;i<list.size();i++){
  		    (list.get(i)).setGoodsname((list.get(i)).getGoodsname().replace("  ├─", ""));//为了把多余的前缀去除
  	    }
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Goods as u where u.typeid = ?";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    System.out.println(phql);
   	    if ((Object)goodspage.getCurrentPage()==null)
   	    	goodspage.setCurrentPage(1);
   	    goodspage = pagingService.queryforpagebyid(phql,pagesize, goodspage.getCurrentPage(),typeid);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=goodspage.getCurrentPage()-2;i<=goodspage.getCurrentPage()+2;i++)
        {
        	if (i<=0||i>goodspage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        goodspage.setPageList(list1);
        return "findsuccess";
	}
	*/

	/**
	 * 根据id找到对应的goods并且显示到新页面上
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String altershow() throws Exception {
		goods = goodsService.findgoodsbyid(id);
		System.out.println("aaaaaaaaaaaaaaaaa="+goods.getGoodsname());
		return "alterShow";
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

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<Goods> getList() {
		return list;
	}

	public void setList(List<Goods> list) {
		this.list = list;
	}

	public PageModel getGoodspage() {
		return goodspage;
	}

	public void setGoodspage(PageModel goodspage) {
		this.goodspage = goodspage;
	}
	

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public List<Goods_subtype> getGoods_subtypes() {
		return goods_subtypes;
	}

	public void setGoods_subtypes(List<Goods_subtype> goods_subtypes) {
		this.goods_subtypes = goods_subtypes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public PagingService getPagingService() {
		return pagingService;
	}

	public void setPagingService(PagingService pagingService) {
		this.pagingService = pagingService;
	}
	
	public List<Goods_supertype> getGoods_supertypes() {
		return goods_supertypes;
	}

	public void setGoods_supertypes(List<Goods_supertype> goods_supertypes) {
		this.goods_supertypes = goods_supertypes;
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
	
	

}
