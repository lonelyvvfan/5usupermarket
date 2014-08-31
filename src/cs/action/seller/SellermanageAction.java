package cs.action.seller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Seller;
import cs.entity.Takeout;
import cs.entity.Takeout_subtype;
import cs.entity.Takeout_supertype;
import cs.service.PagingService;
import cs.service.SellerService;
import cs.util.UploadPicture;
import cs.vo.PageModel;

public class SellermanageAction extends ActionSupport{

	/**
	 *  管理员管理外卖商家
	 */
	
	private Takeout takeout;
	private List<Takeout> list;
	private List<Takeout_subtype> takeout_subtypes;
	private List<Takeout_supertype> takeout_supertypes;
	
	
	private static final long serialVersionUID = 1L;
	private Seller seller;
	private SellerService sellerService;
	

	private PageModel sellerpage=new PageModel();
	Map<String, List<Seller>> sellerlistMap = new HashMap<String,List<Seller>>();
	private Integer id;	
	private String username;	//	外卖商家用户名
	private String password;	//	外卖商家密码
	private String name;	//	外卖商家名
	private String telephone;	//	联系电话
	private String address;		//	地址
	private String email;		//	电子邮件
	private String alipaynum;		//	支付宝帐号
	private String identification;		//	身份证号
	private String reason;			//推荐理由
	private String author;		//	权限
	private String content;		//	介绍
	private String keyword="";//搜索关键字
	private PagingService pagingService;
	private Integer pagesize=20;
	private PageModel takeoutpage = new PageModel();
	
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
	
	
	private UploadPicture uploadPicture = new  UploadPicture();
	private static final String path = "/images/takeout";
	private static final String path1 = "/images/seller";
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
	private int[] checkbox;
	
	/** 上
	 * @return
	 * @throws Exception
	 */
	
	
	
	public String showseller() throws Exception{
		id = Integer.parseInt(ActionContext.getContext().getSession().get("sellerid").toString());
		System.out.println(id+" is id in ");
		seller = sellerService.findsellerbyid(id);
		return "showseller";
	}
	
	
	/**
	 * 把页面上修改内容更新到数据库
	 * @return
	 * @throws Exception
	 */
	public String alterseller() throws Exception{   
		System.out.println("2author is "+author);
		System.out.println("telephone is "+telephone);
		System.out.println("email is "+email);
		System.out.println("alipaynum is "+alipaynum);
		if(upload != null){
			savepath = uploadPicture.uploadFile(upload, uploadFileName, path1);
			uploadPicture.deleteFile(savepath, path);
		}else{
			setSavepath(savepath);
		}
		seller  = sellerService.alterseller(id, username, password, name, telephone,
				email, alipaynum, identification, address, savepath, author,
				content,reason);
		return "alterSuccess";
	}
	
	/**
	 * 根据id找到对应的user并且显示到新页面上
	 * @return
	 * @throws Exception
	 */
	public String altershow() throws Exception{  
		seller = sellerService.findsellerbyid(id);
		System.out.println(id);
		System.out.println(seller.getUsername());
		System.out.println(seller.getPassword());
		System.out.println(seller.getTelephone());
		return "alterShow";
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
		reslut = sellerService.deletecheckboxtakeout(checkbox);
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
		reslut = sellerService.takeupjia(checkbox);
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
		reslut = sellerService.takedownjia(checkbox);
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
	
	
	
	
	public String takeoutshow() throws IOException{
		sellerid = Integer.parseInt(ActionContext.getContext().getSession().get("sellerid").toString());
		takeout_supertypes = sellerService.showtakeoutsuptype();
		takeout_subtypes = sellerService.showtakeoutsubtype();
		list = sellerService.findtakeoutbyid(sellerid);
		 for(int i=0;i<list.size();i++){
	  		    (list.get(i)).setGoodsname((list.get(i)).getGoodsname().replace("  ├─", ""));//为了把多余的前缀去除
	  	    }
	    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
	   	    String phql="from Takeout as u where u.sellerid = ?";
	        //this.pageBean = pagingService.queryForPage(phql,2, page); 
	   	    
	   	    System.out.println(phql);
	   	    if ((Object)takeoutpage.getCurrentPage()==null)
	   	    	takeoutpage.setCurrentPage(1);
	   	    takeoutpage = pagingService.querygoodsforpage(phql,pagesize, takeoutpage.getCurrentPage(),sellerid);
	        List<Integer> list1=new ArrayList<Integer>();
	        for (Integer i=takeoutpage.getCurrentPage()-5;i<=takeoutpage.getCurrentPage()+5;i++)
	        {
	        	if (i<=0||i>takeoutpage.getTotalPage())
	        		continue;
	        	list1.add(i);
	        }
	        takeoutpage.setPageList(list1);
	        return "takeshow";
		}
		
	
	/**
	 * 增加takeout
	 * @return String
	 */
	public String addtakeout() throws Exception {
		takeout_supertypes = sellerService.showtakeoutsuptype();
		takeout_subtypes = sellerService.showtakeoutsubtype();
		System.out.println("addtakeout");
		if(upload != null){
			savepath = uploadPicture.uploadFile(upload, uploadFileName, path);
			uploadPicture.deleteFile(savepath, path);
		}else{
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
		list = sellerService.addtakeout(sellerid,sellername,suptypeid,subtypeid, goodsname, introduce, price,
				nowprice, savepath,  savepath1, savepath2, savepath3,newgoods, hot, special, health, recommend ,shelves , reason);
		return "addSuccess";
	}
	
	/**
	 * //删除指定id的takeout
	 * @return String
	 */
	public String deletetakeoutbyid() throws Exception {
		System.out.println("enter delete");
		boolean reslut = false;
		reslut = sellerService.deletetakeoutbyid(id);
		if (reslut) {
			takeout_supertypes = sellerService.showtakeoutsuptype();
			takeout_subtypes = sellerService.showtakeoutsubtype();
			list = sellerService.findtakeoutbyid(sellerid);
			System.out.println("return success");
			return "takeoutdel";
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
		takeout_supertypes = sellerService.showtakeoutsuptype();
		takeout_subtypes = sellerService.showtakeoutsubtype();
		System.out.println(takeout_subtypes+"111111");
		System.out.println(takeout_supertypes+"2222222");
		return "showsubtype";
	}
	
	/**
	 * 根据goodsname找到指定商品 返回list
	 * 
	 * @return String
	 */
	public String findtakeoutspecial(){
		System.out.println(goodsname);
		takeout_supertypes = sellerService.showtakeoutsuptype();
		takeout_subtypes = sellerService.showtakeoutsubtype();
		System.out.println("goodsname="+goodsname);
	   	System.out.println("id="+id);
	   	System.out.println("suptypeid="+suptypeid);
	   	System.out.println("subtypeid="+subtypeid);
		list = sellerService.findtakeoutspecial(goodsname,suptypeid,subtypeid);
   	    for(int i=0;i<list.size();i++){
  		    (list.get(i)).setGoodsname((list.get(i)).getGoodsname().replace("  ├─", ""));//为了把多余的前缀去除
  	    }
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Takeout as u where goodsname like ?";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	    if ((Object)takeoutpage.getCurrentPage()==null)
   	    	takeoutpage.setCurrentPage(1);
   	    takeoutpage = pagingService.querygoodsforpage(phql,pagesize, takeoutpage.getCurrentPage(),sellerid,goodsname,suptypeid,subtypeid);
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
	 * 把页面上修改内容更新到数据库
	 * @return String
	 */
	public String altertakeout() throws Exception {
		takeout_supertypes = sellerService.showtakeoutsuptype();
		takeout_subtypes = sellerService.showtakeoutsubtype();
		System.out.println("altertakeout");
		if(upload != null){
			savepath = uploadPicture.uploadFile(upload, uploadFileName, path);
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
		list = sellerService.altertakeout(id,sellerid,sellername, suptypeid,subtypeid, goodsname, introduce, price,
				nowprice, savepath, savepath1, savepath2, savepath3,   newgoods, hot, special, health, recommend  ,shelves, reason);
		list = sellerService.findtakeoutbyid(sellerid);
		return "altertakeSuccess";
	}
	
	/**
	 * 根据id找到对应的goods并且显示到新页面上
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String altertakeoutshow() throws Exception {
		takeout_supertypes = sellerService.showtakeoutsuptype();
		takeout_subtypes = sellerService.showtakeoutsubtype();
		takeout = sellerService.findtakeoutbyid1(id);
		return "altertakeShow";
	}
	
	
	public String view() throws Exception{
		takeout_subtypes = sellerService.showtakeoutsubtype();
		takeout_supertypes = sellerService.showtakeoutsuptype();
		takeout = sellerService.findtakeoutbyid1(id);
		return "view";
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

	public SellerService getSellerService() {
		return sellerService;
	}

	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	
	public PageModel getSellerpage() {
		return sellerpage;
	}
	
	public PageModel getTakeoutpage() {
		return takeoutpage;
	}


	public void setTakeoutpage(PageModel takeoutpage) {
		this.takeoutpage = takeoutpage;
	}


	public void setSellerpage(PageModel sellerpage) {
		this.sellerpage = sellerpage;
	}

	public PagingService getPagingService() {
		return pagingService;
	}

	public void setPagingService(PagingService pagingService) {
		this.pagingService = pagingService;
	}


	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}


	public Map<String, List<Seller>> getSellerlistMap() {
		return sellerlistMap;
	}

	public void setSellerlistMap(Map<String, List<Seller>> sellerlistMap) {
		this.sellerlistMap = sellerlistMap;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlipaynum() {
		return alipaynum;
	}

	public void setAlipaynum(String alipaynum) {
		this.alipaynum = alipaynum;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getSavepath() {
		return savepath;
	}

	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Takeout getTakeout() {
		return takeout;
	}


	public void setTakeout(Takeout takeout) {
		this.takeout = takeout;
	}


	public List<Takeout_subtype> getTakeout_subtypes() {
		return takeout_subtypes;
	}


	public void setTakeout_subtypes(List<Takeout_subtype> takeout_subtypes) {
		this.takeout_subtypes = takeout_subtypes;
	}


	public List<Takeout_supertype> getTakeout_supertypes() {
		return takeout_supertypes;
	}


	public void setTakeout_supertypes(List<Takeout_supertype> takeout_supertypes) {
		this.takeout_supertypes = takeout_supertypes;
	}


	public void setList(List<Takeout> list) {
		this.list = list;
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


	public List<Takeout> getList() {
		return list;
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


	public static String getPath1() {
		return path1;
	}
	
	
	
}
