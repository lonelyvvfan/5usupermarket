package cs.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Combo;
import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Keyword;
import cs.entity.Notice;
import cs.entity.Secondgoods;
import cs.service.AdminService;
import cs.service.AjaxService;
import cs.service.PagingService;
import cs.vo.PageModel;

public class TestAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer subtypeid;   //子类类型id
	private Integer suptypeid;   //父类类型id
	private Integer indexx;
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
	private Integer pagesize=8;
	private String title;

	private String currentPage;
	private AjaxService ajaxService;
	private Goods goods;
	private List<Goods> list;
	private List<Combo> listc;
	private List<Keyword> listk;
	List<Integer> listb=new ArrayList<Integer>();
	private List<Goods_subtype> goods_subtypes;
	private List<Goods_supertype> goods_supertypes;
	List<Notice> listt=new ArrayList<Notice>();


	private PageModel goodspage=new PageModel();

	/**
	 * 根据goodsname找到指定商品 返回list
	 * 
	 * @return String
	 */
	public String findgoodsspecial(){
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Goods as u where goodsname like ? and shelves=1";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	    if (getCurrentPage()==null)
   	    	setCurrentPage("1");
   	    goodspage = pagingService.querygoodsforpage(phql,pagesize,Integer.parseInt(getCurrentPage()),goodsname,suptypeid,subtypeid);
        list=goodspage.getList();
        return "list";
	}
	
	public String findpage(){
		listb.add(0,1);
		listb.add(1,1);
		for (int i=2;i<=8;i++)
		{
			list = ajaxService.findgoodsspecial(null,i,subtypeid);
			System.out.println("hhhhhhhh"+list.size());
			if (list==null) listb.add(i,1);
			else listb.add(i,list.size());
		}
		System.out.println("aaaaaaaa"+listb);
        return "list";
	}
	
	public String findkeyword(){
		listk=ajaxService.alterkeyword();
		return "list";
	}
	
	public String findnotice(){
		listt=ajaxService.queryallnotice();
		return "list";
	}
	
	public String findrecommend(){
		list=ajaxService.findrecommend();
		return "list";
	}
	
	public String findhealth(){
		list=ajaxService.findhealth();
		return "list";
	}
	
	public String findhot(){
		list=ajaxService.findhot();
		return "list";
	}
	
	public String findspecial(){
		list=ajaxService.findspecial();
		return "list";
	}
	
	public String findnewgoods(){
		list=ajaxService.findnewgoods();
		return "list";
	}
	
	public String findcombo(){
		System.out.println("combo");
		listc=ajaxService.findcombo();
		System.out.println(listc);
		return "list";
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSubtypeid() {
		return subtypeid;
	}

	public void setSubtypeid(Integer subtypeid) {
		this.subtypeid = subtypeid;
	}

	public Integer getSuptypeid() {
		return suptypeid;
	}

	public void setSuptypeid(Integer suptypeid) {
		this.suptypeid = suptypeid;
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

	

	public AjaxService getAjaxService() {
		return ajaxService;
	}

	public void setAjaxService(AjaxService ajaxService) {
		this.ajaxService = ajaxService;
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

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public List<Combo> getListc() {
		return listc;
	}

	public void setListc(List<Combo> listc) {
		this.listc = listc;
	}

	public List<Integer> getListb() {
		return listb;
	}

	public void setListb(List<Integer> listb) {
		this.listb = listb;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Keyword> getListk() {
		return listk;
	}

	public void setListk(List<Keyword> listk) {
		this.listk = listk;
	}

	public List<Notice> getListt() {
		return listt;
	}

	public void setListt(List<Notice> listt) {
		this.listt = listt;
	}

	public Integer getIndexx() {
		return indexx;
	}

	public void setIndexx(Integer indexx) {
		this.indexx = indexx;
	}
	
	
}

