package cs.action.admin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.action.Narrowimage;
import cs.entity.Takeout;
import cs.entity.Takeout_subtype;
import cs.entity.Takeout_supertype;
import cs.service.AdminService;
import cs.service.PagingService;
import cs.util.UploadPicture;
import cs.vo.PageModel;

public class TakeoutmanageAction extends ActionSupport{
	
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
	private Integer newgoods;	//是否为新品
	private Integer hot;	//是否为热销商品
	private Integer special;	//是否为特价商品
	private Integer health;		//是否为健康商品
	private Integer recommend;	//是否为推荐商品
	private String reason; //推荐理由
	
	private UploadPicture uploadPicture = new  UploadPicture();
	private static final String path = "/images/takeout";
	private File upload;
	private String uploadFileName;
	private File upload1;
	private String uploadFileName1;
	private File upload2;
	private String uploadFileName2;
	private File upload3;
	private String uploadFileName3;
	private String savepath; // 图片路径
	private String savepath1;	//第二张图片路径
	private String savepath2;	//第三张图片路径
	private String savepath3;	//第四张图片路径
	private String shelves;  //商品状态
	private Narrowimage narrowImage = new Narrowimage();
	
	
	
	private AdminService adminService;
	private PageModel takeoutpage = new PageModel(); 
	private PagingService pagingService;
	private Integer pagesize= 15;
	
	private Takeout takeout;
	private List<Takeout> list;
	private List<Takeout_subtype> takeout_subtypes;
	private List<Takeout_supertype> takeout_supertypes;
	private int[] checkbox;
	
	/**
	 * 显示全部二手商品
	 * @return String
	 */
	public String showtakeout(){
		System.out.println("11111111111111111");
		takeout_supertypes = adminService.showtakeoutsuptype();
		System.out.println("11111111111111112");
		takeout_subtypes = adminService.showtakeoutsubtype();
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Takeout order by id desc";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    System.out.println(phql);
   	    if ((Object)takeoutpage.getCurrentPage()==null)
   	    	takeoutpage.setCurrentPage(1);
   	    goodsname=null;
   	    takeoutpage = pagingService.queryforpage(phql,pagesize, takeoutpage.getCurrentPage(),goodsname);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=takeoutpage.getCurrentPage()-5;i<=takeoutpage.getCurrentPage()+5;i++)
        {
        	if (i<=0||i>takeoutpage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        takeoutpage.setPageList(list1);
        return "takeout";
    }
	
	
	public String deletecheckbox() throws Exception{
		String[] arr =(String [])ActionContext.getContext().getParameters().get("checkbox");
		System.out.println("checkbox  = " + arr);
		 if(arr!=null)
		 {
		     int[] arrId = new int[arr.length];
		     for (int i = 0; i < arr.length; i++) {
		         arrId[i] = Integer.parseInt(arr[i]);
		         }       
		boolean reslut = false;
		reslut = adminService.deletecheckboxtakeout(checkbox);
		if(reslut)
		{
			System.out.println("return success");
		return "success";
		}
		else {
			System.out.println("return success");
			return "failure";
		}
		 }
		 else
			 return "failure";
	}	
	
	
	public String upjia() throws Exception{
		String[] arr =(String [])ActionContext.getContext().getParameters().get("checkbox");
		System.out.println("checkbox  = " + arr);
		 if(arr!=null)
		 {
		     int[] arrId = new int[arr.length];
		     for (int i = 0; i < arr.length; i++) {
		         arrId[i] = Integer.parseInt(arr[i]);
		         }       
		boolean reslut = false;
		reslut = adminService.takeupjia(checkbox);
		if(reslut)
		{
			System.out.println("return success");
		return "success";
		}
		else {
			System.out.println("return success");
			return "failure";
		}
		 }
		 else
			 return "failure";
	}
	
	
	public String downjia() throws Exception{
		String[] arr =(String [])ActionContext.getContext().getParameters().get("checkbox");
		System.out.println("checkbox  = " + arr);
		 if(arr!=null)
		 {
		     int[] arrId = new int[arr.length];
		     for (int i = 0; i < arr.length; i++) {
		         arrId[i] = Integer.parseInt(arr[i]);
		         }       
		boolean reslut = false;
		reslut = adminService.takedownjia(checkbox);
		if(reslut)
		{
			System.out.println("return success");
		return "success";
		}
		else {
			System.out.println("return success");
			return "failure";
		}
		 }
		 else
			 return "failure";
	}
	
	/**
	 * //删除指定id的takeout
	 * @return String
	 */
	public String deletetakeoutbyid() throws Exception {
		System.out.println("id is"+id);
		boolean reslut = false;
		reslut = adminService.deletetakeoutbyid(id);
		if (reslut) {
			System.out.println("return success");
			return "success";
		} else {
			System.out.println("return success");
			return "failure";
		}
	}
	
	
	/**
	 * 根据goodsname找到指定商品 返回list
	 * 
	 * @return String
	 */
	public String findtakeoutspecial(){
		System.out.println(goodsname);
		takeout_supertypes = adminService.showtakeoutsuptype();
		takeout_subtypes = adminService.showtakeoutsubtype();
		System.out.println("goodsname="+goodsname);
	   	System.out.println("id="+id);
	   	System.out.println("suptypeid="+suptypeid);
	   	System.out.println("subtypeid="+subtypeid);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Takeout as u where goodsname like ?";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	    if ((Object)takeoutpage.getCurrentPage()==null)
   	    	takeoutpage.setCurrentPage(1);
   	    takeoutpage = pagingService.querytakeoutgoodsforpage(phql,pagesize, takeoutpage.getCurrentPage(),goodsname,suptypeid,subtypeid);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=takeoutpage.getCurrentPage()-5;i<=takeoutpage.getCurrentPage()+5;i++)
        {
        	if (i<=0||i>takeoutpage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        takeoutpage.setPageList(list1);
        return "findsuccess";
	}
	
	
	/**
	 * 显示子类
	 * @return String
	 */
	public String showsubtype() throws Exception{
		takeout_supertypes = adminService.showtakeoutsuptype();
		takeout_subtypes = adminService.showtakeoutsubtype();
		System.out.println(takeout_subtypes+"111111");
		System.out.println(takeout_supertypes+"2222222");
		return "showsubtype";
	}
	
	/**
	 * 显示父类
	 * @return String
	 */
	public String showtakeoutsuptype() throws Exception{
		takeout_supertypes = adminService.showtakeoutsuptype();
		System.out.println(takeout_supertypes);
		return "showsupertype";
	}
	
	/**
	 * 增加takeout
	 * @return String
	 */
	public String addtakeout() throws Exception {
		System.out.println("addtakeout");
		
		if(upload != null){
			savepath = uploadPicture.uploadFile(upload, uploadFileName, path);
			@SuppressWarnings("deprecation")
			String rootpath = ServletActionContext.getRequest().getRealPath(
					path);
			String inputFoler= rootpath + savepath;
			String newrootpath = rootpath.replace("\\takeout", "\\narrowimages\\takeout");
			if (!new File(newrootpath).exists()) {
				new File(newrootpath).mkdirs();
			}
			String outputFolder = newrootpath + savepath;
			System.out.println(outputFolder);
			narrowImage.writeHighQuality(narrowImage.zoomImage(inputFoler), outputFolder);
			uploadPicture.deleteFile(savepath, path);
		}else{
			uploadFileName = "abc.jpg";
			setSavepath(savepath);
		}
		
		if(upload1 != null){
			savepath1 = uploadPicture.uploadFile(upload1, uploadFileName, path);
			uploadPicture.deleteFile(savepath1, path);
		}else{
			setSavepath1(savepath1);
		}
		
		if(upload2 != null){
			savepath2 = uploadPicture.uploadFile(upload2, uploadFileName, path);
			uploadPicture.deleteFile(savepath2, path);
		}else{
			setSavepath2(savepath2);
		}
		
		if(upload3 != null){
			savepath3 = uploadPicture.uploadFile(upload3, uploadFileName, path);
			uploadPicture.deleteFile(savepath3, path);
		}else{
			setSavepath3(savepath3);
		}
		list = adminService.addtakeout(sellerid,sellername,suptypeid,subtypeid, goodsname, introduce, price,
				nowprice, savepath, savepath1, savepath2, savepath3,  newgoods, hot, special, health, recommend ,shelves ,reason);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		return "addSuccess";
	}
	
	
	/**
	 * 根据id找到对应的goods并且显示到新页面上
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String altershow() throws Exception {
		takeout_supertypes = adminService.showtakeoutsuptype();
		takeout_subtypes = adminService.showtakeoutsubtype();
		takeout = adminService.findtakeoutbyid(id);
		return "alterShow";
	}
	
	/**
	 * 根据id找到对应的takeout并且显示到新页面上
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String view() throws Exception {
		takeout_supertypes = adminService.showtakeoutsuptype();
		takeout_subtypes = adminService.showtakeoutsubtype();
		takeout = adminService.findtakeoutbyid(id);
		return "view";
	}
	
	
	/**
	 * 把页面上修改内容更新到数据库
	 * @return String
	 */
	public String altertakeout() throws Exception {
		System.out.println("altertakeout");
		if(upload != null){
			savepath = uploadPicture.uploadFile(upload, uploadFileName, path);
			@SuppressWarnings("deprecation")
			String rootpath = ServletActionContext.getRequest().getRealPath(
					path);
			String inputFoler= rootpath + savepath;
			String newrootpath = rootpath.replace("\\takeout", "\\narrowimages\\takeout");
			if (!new File(newrootpath).exists()) {
				new File(newrootpath).mkdirs();
			}
			String outputFolder = newrootpath + savepath;
			System.out.println(outputFolder);
			narrowImage.writeHighQuality(narrowImage.zoomImage(inputFoler), outputFolder);
			uploadPicture.deleteFile(savepath, path);
		}else{
			uploadFileName = "abc.jpg";
			setSavepath(savepath);
		}
		
		if(upload1 != null){
			savepath1 = uploadPicture.uploadFile(upload1, uploadFileName, path);
			uploadPicture.deleteFile(savepath1, path);
		}else{
			setSavepath1(savepath1);
		}
		
		if(upload2 != null){
			savepath2 = uploadPicture.uploadFile(upload2, uploadFileName, path);
			uploadPicture.deleteFile(savepath2, path);
		}else{
			setSavepath2(savepath2);
		}
		if(upload3 != null){
			savepath3 = uploadPicture.uploadFile(upload3, uploadFileName, path);
			uploadPicture.deleteFile(savepath3, path);
		}else{
			setSavepath3(savepath3);
		}
		list = adminService.altertakeout(id,sellerid,sellername, suptypeid,subtypeid, goodsname, introduce, price,
				nowprice, savepath,savepath1, savepath2, savepath3, newgoods, hot, special, health, recommend ,shelves ,reason);
		return "alterSuccess";
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

	public UploadPicture getUploadPicture() {
		return uploadPicture;
	}

	public void setUploadPicture(UploadPicture uploadPicture) {
		this.uploadPicture = uploadPicture;
	}

	public File getUpload1() {
		return upload1;
	}

	public void setUpload1(File upload1) {
		this.upload1 = upload1;
	}

	public String getUploadFileName1() {
		return uploadFileName1;
	}

	public void setUploadFileName1(String uploadFileName1) {
		this.uploadFileName1 = uploadFileName1;
	}

	public File getUpload2() {
		return upload2;
	}

	public void setUpload2(File upload2) {
		this.upload2 = upload2;
	}

	public String getUploadFileName2() {
		return uploadFileName2;
	}

	public void setUploadFileName2(String uploadFileName2) {
		this.uploadFileName2 = uploadFileName2;
	}

	public File getUpload3() {
		return upload3;
	}

	public void setUpload3(File upload3) {
		this.upload3 = upload3;
	}

	public String getUploadFileName3() {
		return uploadFileName3;
	}

	public void setUploadFileName3(String uploadFileName3) {
		this.uploadFileName3 = uploadFileName3;
	}

	public String getSavepath1() {
		return savepath1;
	}

	public void setSavepath1(String savepath1) {
		this.savepath1 = savepath1;
	}

	public String getSavepath2() {
		return savepath2;
	}

	public void setSavepath2(String savepath2) {
		this.savepath2 = savepath2;
	}

	public String getSavepath3() {
		return savepath3;
	}

	public void setSavepath3(String savepath3) {
		this.savepath3 = savepath3;
	}

	public String getShelves() {
		return shelves;
	}

	public void setShelves(String shelves) {
		this.shelves = shelves;
	}


	public int[] getCheckbox() {
		return checkbox;
	}


	public void setCheckbox(int[] checkbox) {
		this.checkbox = checkbox;
	}


	public static String getPath() {
		return path;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public Narrowimage getNarrowImage() {
		return narrowImage;
	}


	public void setNarrowImage(Narrowimage narrowImage) {
		this.narrowImage = narrowImage;
	}
	
	

}
