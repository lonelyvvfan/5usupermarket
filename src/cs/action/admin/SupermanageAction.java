package cs.action.admin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cs.action.Narrowimage;








import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.service.AdminService;
import cs.service.PagingService;
import cs.vo.PageModel;
import cs.util.UploadPicture;

public class SupermanageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer subtypeid;   //子类类型id
	private Integer suptypeid;   //父类类型id
	private Integer indexx; 
	private Integer inventory; 	//库存量
	private String goodsname; // 商品名
	private String introduce; // 商品介绍
	private double price; // 单价
	private double nowprice; // 新价
	private Integer newgoods; // 是否为新品
	private Integer hot; // 是否为热销商品
	private Integer special; // 是否为特价商品
	private Integer health; // 是否为健康商品
	private Integer recommend; // 是否为推荐商品
	private Integer monthsell;
	private Integer zan;
	private String reason; //推荐理由
	
	
	
	
	private UploadPicture uploadPicture = new  UploadPicture();
	private static final String path = "/images/goods";
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
	
	private PagingService pagingService;
	private Integer pagesize= 15;
	

	private AdminService adminService;
	private Goods goods;
	private List<Goods> list;
	private List<Goods_subtype> goods_subtypes;
	private List<Goods_supertype> goods_supertypes;



	private PageModel goodspage=new PageModel();
	private int[] checkbox;
	
	/**
	 * 显示全部商品
	 * @return String
	 */
	public String showgoods(){
		goods_supertypes = adminService.showsuptype();
		goods_subtypes = adminService.showsubtype();
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Goods order by indexx desc , id desc";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    System.out.println(phql);
   	    if ((Object)goodspage.getCurrentPage()==null)
   	    	goodspage.setCurrentPage(1);
   	    goodsname=null;
   	    goodspage = pagingService.queryforpage(phql,pagesize, goodspage.getCurrentPage(),goodsname);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=goodspage.getCurrentPage()-5;i<=goodspage.getCurrentPage()+5;i++)
        {
        	if (i<=0||i>goodspage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        goodspage.setPageList(list1);
        return "goods";
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
		reslut = adminService.deletecheckboxgoods(checkbox);
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
		reslut = adminService.upjia(checkbox);
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
		reslut = adminService.downjia(checkbox);
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
	 * 置顶商品
	 */
	

	
	
	/**
	 * //删除指定id的goods
	 * @return String
	 */
	public String deletegoodsbyid() throws Exception {
		boolean reslut = false;
		reslut = adminService.deletegoodsbyid(id);
		if (reslut) {
			System.out.println("return success");
			return "success";
		} else {
			System.out.println("return failure");
			return "failure";
		}
	}
	
	/**
	 * 显示子类
	 * @return String
	 */
	public String showsubtype() throws Exception{
		goods_subtypes = adminService.showsubtype();
		goods_supertypes = adminService.showsuptype();
		System.out.println(goods_subtypes);
		return "showsubtype";
	}
	
	public String showsuptype() throws Exception{
		goods_supertypes = adminService.showsuptype();
		System.out.println(goods_supertypes);
		return "showsupertype";
	}

	/**
	 * 增加goods
	 * @return String
	 */
	public String addgoods() throws Exception {
		System.out.println("addgoods");
		
		
		if(upload != null){
			savepath = uploadPicture.uploadFile(upload, uploadFileName, path);
			@SuppressWarnings("deprecation")
			String rootpath = ServletActionContext.getRequest().getRealPath(
					path);
			String inputFoler= rootpath + savepath;
			String newrootpath = rootpath.replace("\\goods", "\\narrowimages\\goods");
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
		
		/**
		if(upload != null){
			upload();
			savepath = uploadFileName;
			System.out.println(uploadFileName);
		}
		
		
		if(upload1 != null){
			System.out.println("1111111111111111111111");
			upload();
			savepath1 = uploadFileName;
			System.out.println(uploadFileName);
			
		}
		if(upload2 != null){
			upload2();
			System.out.println("2222222222222222222222");
			savepath2 = uploadFileName;
			System.out.println(uploadFileName);
		}
		*/
		System.out.println("savepath = "+savepath);
		//zan = 0;
		//monthsell = 0;
		System.out.println("qwertyuiopasdfghjklzxcvbnm"+indexx);
		list = adminService.addgoods(suptypeid,subtypeid,indexx, goodsname, introduce, price,
				nowprice, savepath, savepath1, savepath2, savepath3, newgoods, hot, special, health,
				recommend,shelves,monthsell,zan,reason,inventory);
		return "addSuccess";
	}

	/**
	 * 把页面上修改内容更新到数据库
	 * @return String
	 */
	public String altergoods() throws Exception {
		System.out.println("altergoods");
		if(upload != null){
			savepath = uploadPicture.uploadFile(upload, uploadFileName, path);
			@SuppressWarnings("deprecation")
			String rootpath = ServletActionContext.getRequest().getRealPath(
					path);
			String inputFoler= rootpath + savepath;
			String newrootpath = rootpath.replace("\\goods", "\\narrowimages\\goods");
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
		System.out.println("qwertyuiopasdfghjklzxcvbnm"+indexx);
		list = adminService.altergoods(id, suptypeid,subtypeid,indexx, goodsname, introduce, price,
				nowprice, savepath, savepath1, savepath2, savepath3, newgoods, hot, special, health,
				recommend,shelves,monthsell,zan,reason,inventory);
		return "alterSuccess";
	}

	/**
	 * 上传图片
	 * @throws IOException
	 * @return void
	
	private void upload() throws IOException{
		String realPath = ServletActionContext.getServletContext().getRealPath("/images/goods");
		System.out.println(realPath);
		uploadFileName = new SimpleDateFormat("yyMMddHHmmss").format(new Date()) +(int)(Math.random()*10000)+ "."
				+ uploadFileName.substring(uploadFileName.lastindexxOf(".") + 1);
		if(upload != null){
			File saveFile = new File(new File(realPath), uploadFileName);
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(upload, saveFile);
		}
	}
	
 */

	/**
	 * 根据goodsname找到指定商品 返回list
	 * 
	 * @return String
	 */
	public String findgoodsspecial(){
		goods_supertypes = adminService.showsuptype();
		goods_subtypes = adminService.showsubtype();
		System.out.println("goodsname="+goodsname);
	   	System.out.println("suptypeid="+suptypeid);
	   	System.out.println("subtypeid="+subtypeid);
	   	System.out.println("shelves is =" + shelves);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Goods as u where goodsname like ?";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	    if ((Object)goodspage.getCurrentPage()==null)
   	    	goodspage.setCurrentPage(1);
   	    goodspage = pagingService.querygoodsforpage(phql,pagesize, goodspage.getCurrentPage(),goodsname,suptypeid,subtypeid);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=goodspage.getCurrentPage()-5;i<=goodspage.getCurrentPage()+5;i++)
        {
        	if (i<=0||i>goodspage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        goodspage.setPageList(list1);
        return "findsuccess";
	}
	
	/**
	 * 根据goodsname找到指定商品 返回list
	 * 
	 * @return String
	 */
	public String findgoodsspecial1(){
		goods_supertypes = adminService.showsuptype();
		goods_subtypes = adminService.showsubtype();
		System.out.println("goodsname="+goodsname);
	   	System.out.println("suptypeid="+suptypeid);
	   	System.out.println("subtypeid="+subtypeid);
	   	System.out.println("shelves is =" + shelves);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Goods as u where goodsname like ?";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	    if ((Object)goodspage.getCurrentPage()==null)
   	    	goodspage.setCurrentPage(1);
   	    goodspage = pagingService.querygoodsforpage1(phql,pagesize, goodspage.getCurrentPage(),goodsname,suptypeid,subtypeid,shelves);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=goodspage.getCurrentPage()-5;i<=goodspage.getCurrentPage()+5;i++)
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
		goods_supertypes = adminService.showsuptype();
		goods_subtypes = adminService.showsubtype();
		list = adminService.findGoodsbyid2(typeid);
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
		goods_subtypes = adminService.showsubtype();
		goods_supertypes = adminService.showsuptype();
		goods = adminService.findgoodsbyid(id);
		System.out.println(goodsname+","+zan+","+monthsell);
		return "alterShow";
	}
	
	public String view() throws Exception {
		goods = adminService.findgoodsbyid(id);
		return "view";
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

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
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

	public String getShelves() {
		return shelves;
	}

	public void setShelves(String shelves) {
		this.shelves = shelves;
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

	public UploadPicture getUploadPicture() {
		return uploadPicture;
	}

	public void setUploadPicture(UploadPicture uploadPicture) {
		this.uploadPicture = uploadPicture;
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

	public String getSavepath3() {
		return savepath3;
	}

	public void setSavepath3(String savepath3) {
		this.savepath3 = savepath3;
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



	public Integer getIndexx() {
		return indexx;
	}



	public void setIndexx(Integer indexx) {
		this.indexx = indexx;
	}



	public Integer getInventory() {
		return inventory;
	}



	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}



	public Narrowimage getNarrowImage() {
		return narrowImage;
	}



	public void setNarrowImage(Narrowimage narrowImage) {
		this.narrowImage = narrowImage;
	}
	
	


	
}
