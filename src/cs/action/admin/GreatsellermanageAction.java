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
import cs.entity.Greatseller;
import cs.entity.Greatseller_subtype;
import cs.entity.Greatseller_supertype;
import cs.service.AdminService;
import cs.service.PagingService;
import cs.util.UploadPicture;
import cs.vo.PageModel;

public class GreatsellermanageAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 796095487709726762L;
	private Integer id;
	private String name;	//推广商家名
	private Integer subtypeid;	//小分类id
	private Integer suptypeid;	//大分类id
	private String content;		//商家介绍
	private String telephone;	//电话
	private String address;		//地址
	private String url;		//商家链接
	
	
	private UploadPicture uploadPicture = new  UploadPicture();
	private static final String path = "/images/greatseller";
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
	
	
	private AdminService adminService;
	private PageModel greatsellerpage=new PageModel();
	private PagingService pagingService;
	private Integer pagesize= 15;
	
	private Greatseller greatseller;
	private List<Greatseller> list;
	private List<Greatseller_subtype> greatseller_subtypes;
	private List<Greatseller_supertype> greatseller_supertypes;
	private int[] checkbox;
	private Narrowimage narrowImage = new Narrowimage();


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
		reslut = adminService.deletecheckboxgreatseller(checkbox);
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
		reslut = adminService.greatsellerupjia(checkbox);
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
		reslut = adminService.greatsellerdownjia(checkbox);
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
	 * 显示全部推荐商家
	 * @return String
	 */
	public String showgreatseller(){
		greatseller_supertypes = adminService.showgreatsellersuptype();
		greatseller_subtypes = adminService.showgreatsellersubtype();
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Greatseller order by id desc";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    System.out.println(phql);
   	    if ((Object)greatsellerpage.getCurrentPage()==null)
   	    	greatsellerpage.setCurrentPage(1);
   	    name=null;
   	    greatsellerpage = pagingService.queryforpage(phql,pagesize, greatsellerpage.getCurrentPage(),name);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=greatsellerpage.getCurrentPage()-5;i<=greatsellerpage.getCurrentPage()+5;i++)
        {
        	if (i<=0||i>greatsellerpage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        greatsellerpage.setPageList(list1);
        return "greatseller";
    }

	/**
	 * //删除指定id的greatseller
	 * @return String
	 */
	public String deletegreatsellerbyid() throws Exception {
		System.out.println("id is"+id);
		boolean reslut = false;
		reslut = adminService.deletegreatsellerbyid(id);
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
	public String showgreatsellersubtype() throws Exception{
		greatseller_supertypes = adminService.showgreatsellersuptype();
		greatseller_subtypes = adminService.showgreatsellersubtype();
		System.out.println(greatseller_subtypes+"3333333");
		System.out.println(greatseller_supertypes+"4444444");
		return "showsubtype";
	}
	
	public String showgreatsellersuptype() throws Exception{
		greatseller_supertypes = adminService.showgreatsellersuptype();
		System.out.println(greatseller_supertypes);
		return "showsupertype";
	}

	/**
	 * 增加greatseller
	 * @return String
	 */
	public String addgreatseller() throws Exception {
		System.out.println("addgreatseller");
		if(upload != null){
			savepath = uploadPicture.uploadFile(upload, uploadFileName, path);
			@SuppressWarnings("deprecation")
			String rootpath = ServletActionContext.getRequest().getRealPath(
					path);
			String inputFoler= rootpath + savepath;
			String newrootpath = rootpath.replace("\\greatseller", "\\narrowimages\\greatseller");
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
		list = adminService.addgreatseller(suptypeid,subtypeid, name, content, telephone,
				 savepath,savepath1, savepath2, savepath3,  address, url ,shelves);
		return "addSuccess";
	}

	/**
	 * 把页面上修改内容更新到数据库
	 * @return String
	 */
	public String altergreatseller() throws Exception {
		System.out.println("altergreatseller");
		
		if(upload != null){
			savepath = uploadPicture.uploadFile(upload, uploadFileName, path);
			@SuppressWarnings("deprecation")
			String rootpath = ServletActionContext.getRequest().getRealPath(
					path);
			String inputFoler= rootpath + savepath;
			String newrootpath = rootpath.replace("\\greatseller", "\\narrowimages\\greatseller");
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
		list = adminService.altergreatseller(id, suptypeid,subtypeid, name, content, telephone,
				 savepath,savepath1, savepath2, savepath3,  address, url ,shelves);
		return "alterSuccess";
	}

	/**
	 * 上传图片
	 * @throws IOException
	 * @return void
	 */
	private void upload() throws IOException{
		String realPath = ServletActionContext.getServletContext().getRealPath("/images/greatseller");
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


	/**
	 * 根据name找到指定商品 返回list
	 * 
	 * @return String
	 */
	public String findgreatsellerspecial(){
		System.out.println(name);
		greatseller_supertypes = adminService.showgreatsellersuptype();
		greatseller_subtypes = adminService.showgreatsellersubtype();
		System.out.println("name="+name);
	   	System.out.println("id="+id);
	   	System.out.println("suptypeid="+suptypeid);
	   	System.out.println("subtypeid="+subtypeid);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Greatseller as u where name like ?";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	    if ((Object)greatsellerpage.getCurrentPage()==null)
   	    	greatsellerpage.setCurrentPage(1);
   	    greatsellerpage = pagingService.querygreatsellerforpage(phql,pagesize, greatsellerpage.getCurrentPage(),name,suptypeid,subtypeid);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=greatsellerpage.getCurrentPage()-5;i<=greatsellerpage.getCurrentPage()+5;i++)
        {
        	if (i<=0||i>greatsellerpage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        greatsellerpage.setPageList(list1);
        return "findsuccess";
	}
	
	/*
	public String findgreatsellertype(){
		greatseller_supertypes = adminService.showsuptype();
		greatseller_subtypes = adminService.showsubtype();
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
	 * 根据id找到对应的greatseller并且显示到新页面上
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String altershow() throws Exception {
		greatseller_supertypes = adminService.showgreatsellersuptype();
		greatseller_subtypes = adminService.showgreatsellersubtype();
		greatseller = adminService.findgreatsellerbyid(id);
		return "alterShow";
	}
	
	/**
	 * 根据id找到对应的greatseller并且显示到新页面上
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String view() throws Exception {
		greatseller = adminService.findgreatsellerbyid(id);
		return "view";
	}
	
	
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSavepath() {
		return savepath;
	}

	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public Greatseller getGreatseller() {
		return greatseller;
	}

	public void setGreatseller(Greatseller greatseller) {
		this.greatseller = greatseller;
	}

	public List<Greatseller> getList() {
		return list;
	}

	public void setList(List<Greatseller> list) {
		this.list = list;
	}

	public List<Greatseller_subtype> getGreatseller_subtypes() {
		return greatseller_subtypes;
	}

	public void setGreatseller_subtypes(
			List<Greatseller_subtype> greatseller_subtypes) {
		this.greatseller_subtypes = greatseller_subtypes;
	}

	public List<Greatseller_supertype> getGreatseller_supertypes() {
		return greatseller_supertypes;
	}

	public void setGreatseller_supertypes(
			List<Greatseller_supertype> greatseller_supertypes) {
		this.greatseller_supertypes = greatseller_supertypes;
	}

	public PageModel getGreatsellerpage() {
		return greatsellerpage;
	}

	public void setGreatsellerpage(PageModel greatsellerpage) {
		this.greatsellerpage = greatsellerpage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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


	public Narrowimage getNarrowImage() {
		return narrowImage;
	}


	public void setNarrowImage(Narrowimage narrowImage) {
		this.narrowImage = narrowImage;
	}

	
}
