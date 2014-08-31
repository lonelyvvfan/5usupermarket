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

import cs.entity.Combo;
import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Secondgoods;
import cs.entity.Secondgoods_subtype;
import cs.entity.Secondgoods_supertype;
import cs.service.AdminService;
import cs.service.AjaxService;
import cs.service.PagingService;
import cs.vo.PageModel;

public class Test1Action extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Integer id;  
	private Integer userid; //发布用户id;
	private String username;    //发布用户名
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
	private PageModel secgoodspage = new PageModel(); 
	private PagingService pagingService;
	private Integer pagesize=8;
	private File upload;
	private String uploadFileName;
	private String currentPage;
	private Secondgoods secondgoods;
	private List<Secondgoods> list;
	private List<Secondgoods_subtype> secgoods_subtypes;
	List<Integer> listb=new ArrayList<Integer>();

	private List<Secondgoods_supertype> secgoods_supertypes;
	
	
	
	
	/**
	 * 根据goodsname找到指定商品 返回list
	 * 
	 * @return String
	 */
	public String findsecgoodsspecial(){
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Secondgoods as u where goodsname like ? and shelves=1";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	 if (getCurrentPage()==null)
	    	setCurrentPage("1");
   	    secgoodspage = pagingService.querysecgoodsforpage(phql,pagesize, Integer.parseInt(getCurrentPage()),goodsname,suptypeid,subtypeid);
        list=secgoodspage.getList();
        return "list";
	}
	
	public String findsecpage(){
		listb.add(0,1);
		listb.add(1,1);
		for (int i=2;i<=6;i++)
		{
			list = ajaxService.findsecgoodsspecial(null,i,subtypeid);
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
	public PageModel getSecgoodspage() {
		return secgoodspage;
	}
	public void setSecgoodspage(PageModel secgoodspage) {
		this.secgoodspage = secgoodspage;
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
	public Secondgoods getSecondgoods() {
		return secondgoods;
	}
	public void setSecondgoods(Secondgoods secondgoods) {
		this.secondgoods = secondgoods;
	}
	public List<Secondgoods> getList() {
		return list;
	}
	public void setList(List<Secondgoods> list) {
		this.list = list;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<Secondgoods_subtype> getSecgoods_subtypes() {
		return secgoods_subtypes;
	}
	
	public void setSecgoods_subtypes(List<Secondgoods_subtype> secgoods_subtypes) {
		this.secgoods_subtypes = secgoods_subtypes;
	}
	
	public List<Secondgoods_supertype> getSecgoods_supertypes() {
		return secgoods_supertypes;
	}
	
	public void setSecgoods_supertypes(
			List<Secondgoods_supertype> secgoods_supertypes) {
		this.secgoods_supertypes = secgoods_supertypes;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

