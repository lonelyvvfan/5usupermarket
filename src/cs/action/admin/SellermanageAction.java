package cs.action.admin;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Seller;
import cs.service.AdminService;
import cs.service.PagingService;
import cs.util.UploadPicture;
import cs.vo.PageModel;

public class SellermanageAction extends ActionSupport{

	/**
	 *  管理员管理外卖商家
	 */
	
	private static final long serialVersionUID = 1L;
	private Seller seller;
	private List<Seller> list;
	private AdminService adminService;
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
	private String author;		//	权限
	private String content;		//	介绍
	private String reason;  //推荐理由
	
	private Integer[] subtypeid2;
	private Integer[] subtypeid3;
	private Integer[] subtypeid4;
	private UploadPicture uploadPicture = new  UploadPicture();
	private static final String path = "/images/seller";
	private File upload;
	private String uploadFileName;
	private String savepath; // 图片路径
	
	private String keyword="";//搜索关键字
	private PagingService pagingService;
	private Integer pagesize= 15;
	private int[] checkbox;
	/**
	 *  后台显示外卖商家
	 */
	public String showseller(){
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Seller order by id desc";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    System.out.println(phql);
   	    if ((Object)sellerpage.getCurrentPage()==null)
   	    	sellerpage.setCurrentPage(1);
   	    username=null;
   	    sellerpage = pagingService.queryforpage(phql,pagesize, sellerpage.getCurrentPage(),username);
   	    List<Integer> list1=new ArrayList<Integer>();
   	    for (Integer i=sellerpage.getCurrentPage()-5;i<=sellerpage.getCurrentPage()+5;i++)
   	    {
   	    	if (i<=0||i>sellerpage.getTotalPage())
   	    		continue;
   	    		list1.add(i);
   	    }
   	    sellerpage.setPageList(list1);
   	    return "seller";
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
		reslut = adminService.deletecheckboxseller(checkbox);
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
	 * 
	 * 写更新商户照片时候把下面代码加在调用service之前即可
	if(upload != null){
		upload();
		savepath = uploadFileName;
	}
	*/
	
	/**
	 * 上传图片
	 * @throws IOException
	
	private void upload() throws IOException{
		String realPath = ServletActionContext.getServletContext().getRealPath("/images/seller");
		System.out.println(realPath);
		uploadFileName = new SimpleDateFormat("yyMMddHHmmss").format(new Date()) +(int)(Math.random()*10000)+ "."
				+ uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
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
	 *  删除外卖商家
	 */
	public String deletesellerbyid() throws Exception{
		boolean reslut = false;
		System.out.println("delete"+id);
		reslut = adminService.deletesellerbyid(id);
		reslut = adminService.deletesellertype(id);
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
	
	/**
	 * 把页面上修改内容更新到数据库
	 * @return
	 * @throws Exception
	 */
	public String alterseller() throws Exception{   
		if(upload != null){
			savepath = uploadPicture.uploadFile(upload, uploadFileName, path);
			uploadPicture.deleteFile(savepath, path);
		}else{
			uploadFileName = "abc.jpg";
			setSavepath(savepath);
		}
		author = "1";
		adminService.deletesellertype(id);
		if (subtypeid2!=null){
		for (int i=0;i<subtypeid2.length;i++)
			adminService.addsellertype(2,subtypeid2[i],name,savepath,id, reason);
		}
		if (subtypeid3!=null){
		for (int i=0;i<subtypeid3.length;i++)
			adminService.addsellertype(3,subtypeid3[i],name,savepath,id, reason);
		}
		if (subtypeid4!=null){
		for (int i=0;i<subtypeid4.length;i++)
			adminService.addsellertype(4,subtypeid4[i],name,savepath,id, reason);
		}
		list  = adminService.alterseller(id,username,password,name,telephone,email,
				alipaynum,identification,address,savepath,author,content,reason);
		System.out.println("alterseller is ok");
		return "alterSuccess";
	}
	
	/**
	 * 找到指定username的账户 返回list
	 * @param username
	 * @return
	 */
	
	public String findsellerspecial(){
		System.out.println(username);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Seller as u where u.username like ? order by id desc";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    System.out.println(phql);
   	    if ((Object)sellerpage.getCurrentPage()==null)
   	    	sellerpage.setCurrentPage(1);
   	    sellerpage = pagingService.queryforpage(phql,pagesize, sellerpage.getCurrentPage(),username);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=sellerpage.getCurrentPage()-5;i<=sellerpage.getCurrentPage()+5;i++)
        {
        	if (i<=0||i>sellerpage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        sellerpage.setPageList(list1);
        return "findsuccess";
	}
	
	/**
	 * 根据id找到对应的user并且显示到新页面上
	 * @return
	 * @throws Exception
	 */
	public String altershow() throws Exception{  
		seller = adminService.findsellerbyid(id);
		System.out.println(id);
		System.out.println(seller.getUsername());
		System.out.println(seller.getPassword());
		System.out.println(seller.getTelephone());
		return "alterShow";
	}
	
	/**
	 *  增加外卖商家
	 */
	public String addseller() throws Exception{
		System.out.println("addUserstart!");
		//System.out.println("22222222222222"+subtypeid2.length);
		//System.out.println("33333333333333"+subtypeid3.length);
		//System.out.println("44444444444444"+subtypeid4.length);

		if(upload != null){
			savepath = uploadPicture.uploadFile(upload, uploadFileName, path);
			uploadPicture.deleteFile(savepath, path);
		}else{
			uploadFileName = "abc.jpg";
			setSavepath(savepath);
		}
		list = adminService.addseller(username,password,name,telephone,address,
				email,alipaynum,identification,savepath,author,content,reason);
		sellerlistMap.put("list", list);
		Seller seller1=adminService.findsellerbyname(name);
		if (subtypeid2!=null)
		for (int i=0;i<subtypeid2.length;i++)
			adminService.addsellertype(2,subtypeid2[i],name,savepath,seller1.getId(),reason);
		if (subtypeid3!=null)
		for (int i=0;i<subtypeid3.length;i++)
			adminService.addsellertype(3,subtypeid3[i],name,savepath,seller1.getId(),reason);
		if (subtypeid4!=null)
		for (int i=0;i<subtypeid4.length;i++)
			adminService.addsellertype(4,subtypeid4[i],name,savepath,seller1.getId(),reason);
		System.out.println(list);
		return "addSuccess";
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public List<Seller> getList() {
		return list;
	}

	public void setList(List<Seller> list) {
		this.list = list;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
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


	public Integer getPagesize() {
		return pagesize;
	}


	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}


	public int[] getCheckbox() {
		return checkbox;
	}


	public void setCheckbox(int[] checkbox) {
		this.checkbox = checkbox;
	}


	public UploadPicture getUploadPicture() {
		return uploadPicture;
	}


	public void setUploadPicture(UploadPicture uploadPicture) {
		this.uploadPicture = uploadPicture;
	}


	public Integer[] getSubtypeid2() {
		return subtypeid2;
	}


	public void setSubtypeid2(Integer[] subtypeid2) {
		this.subtypeid2 = subtypeid2;
	}


	public Integer[] getSubtypeid3() {
		return subtypeid3;
	}


	public void setSubtypeid3(Integer[] subtypeid3) {
		this.subtypeid3 = subtypeid3;
	}


	public Integer[] getSubtypeid4() {
		return subtypeid4;
	}


	public void setSubtypeid4(Integer[] subtypeid4) {
		this.subtypeid4 = subtypeid4;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}
	public PageModel getSellerpage() {
		return sellerpage;
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
	
}
