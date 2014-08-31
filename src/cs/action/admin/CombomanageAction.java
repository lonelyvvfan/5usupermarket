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
import cs.entity.Combo;
import cs.service.AdminService;
import cs.service.PagingService;
import cs.util.UploadPicture;
import cs.vo.PageModel;
import cs.util.UploadPicture;

public class CombomanageAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7797389821241767048L;
	private Integer id;

	private String goodsname;    //套餐名
	private Integer inventory; 	//库存量
	private String introduce;    //套餐介绍
	private double price;	//单价（原价）
	private double nowprice;	//现价
	
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
	private Integer monthsell;
	private Integer zan;
	private String reason; //推荐理由
	private Narrowimage narrowImage = new Narrowimage();
	
	private PagingService pagingService;
	private Integer pagesize=15;
	
	private AdminService adminService;
	private Combo combo;
	private List<Combo> list;

	private PageModel combopage = new PageModel();
	private int[] checkbox;
	/**
	 * 显示子类
	 * @return String
	 */
	public String showsubtype() throws Exception{
		return "showsubtype";
	}
	
	/**
	 * 显示全部套餐
	 * @return String
	 */
	
	
	
	public String showcombo(){
		//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
		String phql = " from Combo order by id desc";
		 //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    System.out.println(phql);
   	    if((Object)combopage.getCurrentPage()==null)
   	    	combopage.setCurrentPage(1);
   	    goodsname=null;
   	    combopage = pagingService.queryforpage(phql, pagesize, combopage.getCurrentPage(), goodsname);
   	    List<Integer> list1 = new ArrayList<Integer>();
   	    for(Integer i = combopage.getCurrentPage()-5;i<=combopage.getCurrentPage()+5;i++)
   	    {
   	    	if(i<=0||i>combopage.getTotalPage())
   	    		continue;
   	    	list1.add(i);
   	    }
   	    combopage.setPageList(list1);
   	    return "combo";
	}
	
	/**
	 * //删除指定id的combo
	 * @return String
	 */
	public String deletecombobyid() throws Exception{
		boolean result = false;
		result = adminService.deletecombobyid(id);
		if(result){
			System.out.println("return success");
			return "success";
		}else{
			System.out.println("return faliure");
			return "failure";
		}
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
		reslut = adminService.deletecheckboxcombo(checkbox);
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
		System.out.println("enter combo upjia");
		String[] arr =(String [])ActionContext.getContext().getParameters().get("checkbox");
		System.out.println("checkbox  = " + arr);
		 if(arr!=null)
		 {
		     int[] arrId = new int[arr.length];
		     for (int i = 0; i < arr.length; i++) {
		         arrId[i] = Integer.parseInt(arr[i]);
		         }       
		boolean reslut = false;
		reslut = adminService.comboupjia(checkbox);
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
		System.out.println("enter combo downjia");
		String[] arr =(String [])ActionContext.getContext().getParameters().get("checkbox");
		System.out.println("checkbox  = " + arr);
		 if(arr!=null)
		 {
		     int[] arrId = new int[arr.length];
		     for (int i = 0; i < arr.length; i++) {
		         arrId[i] = Integer.parseInt(arr[i]);
		         }       
		boolean reslut = false;
		reslut = adminService.combodownjia(checkbox);
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
	 * 增加combo
	 * @return String
	 */
	public String addcombo() throws Exception{
		System.out.println("addcombo");
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
		list = adminService.addcombo(goodsname, introduce, price, nowprice, 
				savepath, savepath1, savepath2, savepath3,shelves,monthsell,zan,reason,inventory);
		return "addSuccess";
	}

	
	/**
	 * 根据goodsname找到指定套餐 返回list
	 * 
	 * @return String
	 */
	public String findcombospecial(){
		System.out.println("combo find start");
		System.out.println("goodsname="+goodsname);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Combo as u where goodsname like ?";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	    if((Object)combopage.getCurrentPage() == null)
   	    	combopage.setCurrentPage(1);
   	    combopage = pagingService.querycomboforpage(phql, pagesize, combopage.getCurrentPage(), goodsname);
   	    List<Integer> list1 = new ArrayList<Integer>();
   	    for(Integer i = combopage.getCurrentPage()-5;i<=combopage.getCurrentPage()+5;i++)
   	    {
   	    	if(i<=0||i>combopage.getTotalPage())
   	    		continue;
   	    	list1.add(i);
   	    }
   	    combopage.setPageList(list1);
   	    return "findsuccess";
	}
	
	/**
	 * 根据id找到对应的套餐并且显示到新页面上
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String altershow() throws Exception{
		combo = adminService.findcombobyid(id);
		return "alterShow";
	}
	
	/**
	 * 根据id找到对应的套餐并且显示到新页面上
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String view() throws Exception{
		combo = adminService.findcombobyid(id);
		return "view";
	}
	
	/**
	 * 更新套餐內容
	 */
	public String altercombo() throws Exception{
		System.out.println("altercombo");
		if(upload != null){
			savepath = uploadPicture.uploadFile(upload, uploadFileName, path);
			@SuppressWarnings("deprecation")
			String rootpath = ServletActionContext.getRequest().getRealPath(
					path);
			String inputFoler= rootpath + savepath;
			String newrootpath = rootpath.replace("\\combo", "\\narrowimages\\combo");
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
		list = adminService.altercombo(id, goodsname, introduce, price, nowprice, 
				savepath , savepath1, savepath2, savepath3,shelves,monthsell,zan,reason,inventory);
		return "alterSuccess";
	}
	
	/**
	 * 根据goodsname找到指定商品 返回list
	 * 
	 * @return String
	 */
	public String findgoodsspecial1(){
		System.out.println("combo find start");
		System.out.println("goodsname="+goodsname);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Combo as u where goodsname like ?";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	    if((Object)combopage.getCurrentPage() == null)
   	    	combopage.setCurrentPage(1);
   	    combopage = pagingService.querycomboforpage1(phql, pagesize, combopage.getCurrentPage(), goodsname ,shelves);
   	    List<Integer> list1 = new ArrayList<Integer>();
   	    for(Integer i = combopage.getCurrentPage()-5;i<=combopage.getCurrentPage()+5;i++)
   	    {
   	    	if(i<=0||i>combopage.getTotalPage())
   	    		continue;
   	    	list1.add(i);
   	    }
   	    combopage.setPageList(list1);
   	    return "findsuccess";
	}
	
	/**
	 * getter and setter
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	public List<Combo> getList() {
		return list;
	}

	public void setList(List<Combo> list) {
		this.list = list;
	}

	public PageModel getCombopage() {
		return combopage;
	}

	public void setCombopage(PageModel combopage) {
		this.combopage = combopage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public static String getPath() {
		return path;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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
