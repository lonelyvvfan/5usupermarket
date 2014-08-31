package cs.action.user;

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

import cs.entity.Secondgoods;
import cs.entity.Secondgoods_subtype;
import cs.entity.Secondgoods_supertype;
import cs.service.AdminService;
import cs.service.PagingService;
import cs.service.UserService;
import cs.util.UploadPicture;
import cs.vo.PageModel;

public class SecgoodsmanageAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private Integer id;  
	private Integer userid; //发布用户id;
	private String username;    //发布用户名
	private String nickname;    //发布者真实姓名
	private Integer subtypeid;   //子类类型id
	private Integer suptypeid;   //父类类型id
	private String goodsname;    //商品名
	private String introduce;    //商品介绍
	private double price;	//单价
	private double nowprice;	//新价
	private String school; //
	private String living;//生活区
	private Integer newgoods;	//是否为新品
	private Integer hot;	//是否为热销商品
	private Integer special;	//是否为特价商品
	private Integer health;		//是否为健康商品
	private Integer recommend;	//是否为推荐商品
	private String reason;//推荐理由
	private String qq;
	private String telephone;
	private String other;
	private Integer recency; //新旧程度
	
	private UploadPicture uploadPicture = new  UploadPicture();
	private static final String path = "/images/secondgoods";
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

	
	private UserService userService;
	private PageModel secgoodspage = new PageModel(); 
	private PagingService pagingService;
	private Integer pagesize=20;
	
	private Secondgoods secondgoods;
	private List<Secondgoods> list;
	private List<Secondgoods_subtype> secgoods_subtypes;

	private List<Secondgoods_supertype> secgoods_supertypes;
	private int[] checkbox;
	
	/**
	 * 显示user用户发布的全部二手商品
	 * @return String
	 */
	public String showsecgoods(){
		userid = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		System.out.println(userid+" is userid in action");
    	
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Secondgoods  where userid = ? order by id desc";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    System.out.println(phql);
   	    if ((Object)secgoodspage.getCurrentPage()==null)
   	    	secgoodspage.setCurrentPage(1);
   	    goodsname=null;
   	    secgoodspage = pagingService.querysecgoodsforpage(phql,pagesize, secgoodspage.getCurrentPage(),userid);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=secgoodspage.getCurrentPage()-5;i<=secgoodspage.getCurrentPage()+5;i++)
        {
        	if (i<=0||i>secgoodspage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        secgoodspage.setPageList(list1);
        return "secgoods";
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
		reslut = userService.deletecheckboxsecgoods(checkbox);
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
		reslut = userService.secupjia(checkbox);
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
		reslut = userService.secdownjia(checkbox);
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
	 * //删除指定id的secondgoods
	 * @return String
	 */
	public String deletesecgoodsbyid() throws Exception {
		boolean reslut = false;
		reslut = userService.deletesecgoodsbyid(id);
		if (reslut) {
			System.out.println("return success");
			return "success";
		} else {
			System.out.println("return success");
			return "failure";
		}
	}
	
	/**
	 * 增加secondgoods
	 * @return String
	 */
	public String addsecgoods() throws Exception {
		System.out.println("addsecgoods");
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
		System.out.println("recency is "+ recency + " and reason is " + reason);
		list = userService.addsecgoods(userid,username, nickname , suptypeid,subtypeid, goodsname, introduce, price,
				nowprice, savepath,  savepath1, savepath2, savepath3, newgoods, hot, special, health, recommend ,
				shelves , qq , telephone , other ,recency ,reason , school , living);
		
		//clear session
		ActionContext.getContext().getSession().remove("sellnickname");
		ActionContext.getContext().getSession().remove("sellgoodsname");
		ActionContext.getContext().getSession().remove("sellprice");
		ActionContext.getContext().getSession().remove("sellreason");
		ActionContext.getContext().getSession().remove("sellqq");
		ActionContext.getContext().getSession().remove("sellintroduce");
		
		return "addSuccess";
	}
	
	/**
	 * 显示子类
	 * @return String
	 */
	public String showsecsubtype() throws Exception{
		userid = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		username = ActionContext.getContext().getSession().get("username").toString();
		System.out.println(id+"id");
		System.out.println(username+"username2222222");
		secgoods_supertypes = userService.showsecsuptype();
		secgoods_subtypes = userService.showsecsubtype();
		System.out.println(secgoods_subtypes+"111111");
		System.out.println(secgoods_supertypes+"2222222");
		return "showsubtype";
	}
	
	/**
	 * 显示父类
	 * @return String
	 */
	public String showsecsuptype() throws Exception{
		secgoods_supertypes = userService.showsecsuptype();
		System.out.println(secgoods_supertypes);
		return "showsupertype";
	}
	
	
	/**
	 * 把页面上修改内容更新到数据库
	 * @return String
	 */
	public String altersecgoods() throws Exception {
		System.out.println("altersecondgoods");
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
		list = userService.altersecgoods(id,userid,username, nickname , suptypeid,subtypeid, goodsname, introduce, price,
				nowprice, savepath,  savepath1, savepath2, savepath3, newgoods, hot, special, health, recommend ,
				shelves , qq , telephone , other ,recency ,reason , school, living);
		return "alterSuccess";
	}
	
	/**
	 * 根据id找到对应的goods并且显示到新页面上
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String altershow() throws Exception {
		userid = Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		secgoods_supertypes = userService.showsecsuptype();
		secgoods_subtypes = userService.showsecsubtype();
		secondgoods = userService.findsecgoodsbyid(id);
		return "alterShow";
	}
	
	public String view() throws Exception {
		secgoods_supertypes = userService.showsecsuptype();
		secgoods_subtypes = userService.showsecsubtype();
		secondgoods = userService.findsecgoodsbyid(id);
		return "view";
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
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Integer getRecency() {
		return recency;
	}

	public void setRecency(Integer recency) {
		this.recency = recency;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(int[] checkbox) {
		this.checkbox = checkbox;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getLiving() {
		return living;
	}

	public void setLiving(String living) {
		this.living = living;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	

}
