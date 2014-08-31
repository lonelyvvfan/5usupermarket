package cs.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Takeout;
import cs.entity.Takeout_subtype;
import cs.entity.Takeout_supertype;
import cs.service.AdminService;
import cs.service.AjaxService;
import cs.service.PagingService;
import cs.vo.PageModel;

public class Test2Action extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6253297714868920120L;
	private Integer id;  
	private Integer sellerid; //发布商家id
	private String sellername;    //发布商家名
	private Integer subtypeid;   //子类类型id
	private Integer suptypeid;   //父类类型id
	private String goodsname;    //商品名
	private String introduce;    //商品介绍
	private double price;	//单价
	private double nowprice;	//新价
	private String savepath;	//图片路径
	private Integer newgoods;	//是否为新品
	private Integer hot;	//是否为热销商品
	private Integer special;	//是否为特价商品
	private Integer health;		//是否为健康商品
	private Integer recommend;	//是否为推荐商品
	private AjaxService ajaxService;
	private AdminService adminService;
	private PageModel takeoutpage = new PageModel(); 
	private PagingService pagingService;
	private Integer pagesize=8;
	private File upload;
	private String uploadFileName;
	private String currentPage;
	private Takeout takeout;
	private List<Takeout> list;
	private List<Takeout_subtype> takeout_subtypes;
	private List<Takeout_supertype> takeout_supertypes;
	List<Integer> listb=new ArrayList<Integer>();
	
	
	/**
	 * 根据goodsname找到指定商品 返回list
	 * 
	 * @return String
	 */
	public String findtakeoutspecial(){
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Takeout as u where goodsname like ? and shelves=1";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	 if (getCurrentPage()==null)
	    	setCurrentPage("1");
   	 	takeoutpage = pagingService.querygoodsforpage(phql,pagesize, Integer.parseInt(getCurrentPage()),goodsname,suptypeid,subtypeid);
        list=takeoutpage.getList();
        return "list";
	}
	
	
	public String findtakeoutspecial2(){
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Takeout as u where u.sellerid="+sellerid;
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	 if (getCurrentPage()==null)
	    	setCurrentPage("1");
   	 	takeoutpage = pagingService.querygoodsforpage(phql,pagesize, Integer.parseInt(getCurrentPage()),sellerid,suptypeid,subtypeid);
        list=takeoutpage.getList();
        return "list";
	}
	
	public String findtakeoutpage(){
		listb.add(0,1);
		listb.add(1,1);
		for (int i=2;i<=4;i++)
		{
			list = ajaxService.findtakeoutspecial(sellerid,i,subtypeid);
			System.out.println("hhhhhhhh"+list.size());
			if (list==null) listb.add(i,1);
			else listb.add(i,list.size());
		}
		System.out.println("aaaaaaaa"+listb);
        return "list";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSellerid() {
		return sellerid;
	}

	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
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

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public PageModel getTakeoutpage() {
		return takeoutpage;
	}

	public void setTakeoutpage(PageModel takeoutpage) {
		this.takeoutpage = takeoutpage;
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

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Takeout getTakeout() {
		return takeout;
	}

	public void setTakeout(Takeout takeout) {
		this.takeout = takeout;
	}

	public List<Takeout> getList() {
		return list;
	}

	public void setList(List<Takeout> list) {
		this.list = list;
	}

	public List<Takeout_subtype> getTakeout_subtypes() {
		return takeout_subtypes;
	}

	public void setTakeout_subtypes(List<Takeout_subtype> takeout_subtypes) {
		this.takeout_subtypes = takeout_subtypes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<Takeout_supertype> getTakeout_supertypes() {
		return takeout_supertypes;
	}

	public void setTakeout_supertypes(List<Takeout_supertype> takeout_supertypes) {
		this.takeout_supertypes = takeout_supertypes;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public AjaxService getAjaxService() {
		return ajaxService;
	}

	public void setAjaxService(AjaxService ajaxService) {
		this.ajaxService = ajaxService;
	}

	public List<Integer> getListb() {
		return listb;
	}

	public void setListb(List<Integer> listb) {
		this.listb = listb;
	}

	
	
}
