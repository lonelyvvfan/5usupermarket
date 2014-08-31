package cs.action;

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

import cs.entity.Combo;
import cs.service.ComboService;
import cs.service.PagingService;
import cs.util.UploadPicture;
import cs.vo.PageModel;
import cs.util.UploadPicture;

public class ComboAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4703554673772577114L;

	private Integer id;

	private String goodsname;    //套餐名
	private String introduce;    //套餐介绍
	private double price;	//单价（原价）
	private double nowprice;	//现价
	
	private UploadPicture uploadPicture = new  UploadPicture();
	private static final String path = "/images/combo";
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
	
	
	
	private PagingService pagingService;
	private Integer pagesize=5;
	
	private ComboService comboService;
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
   	    for(Integer i = combopage.getCurrentPage()-2;i<=combopage.getCurrentPage()+2;i++)
   	    {
   	    	if(i<=0||i>combopage.getTotalPage())
   	    		continue;
   	    	list1.add(i);
   	    }
   	    combopage.setPageList(list1);
   	    return "combo";
	}
	
	public String dianzan() throws Exception{
		boolean r = false;
		r = comboService.dianzan(id);
		altershow();
		if(r)
			return "alterShow";
		else 
			return "failure";
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
   	    for(Integer i = combopage.getCurrentPage()-2;i<=combopage.getCurrentPage()+2;i++)
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
		combo = comboService.findcombobyid(id);
		return "alterShow";
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


	public ComboService getComboService() {
		return comboService;
	}

	public void setComboService(ComboService comboService) {
		this.comboService = comboService;
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
	
}
