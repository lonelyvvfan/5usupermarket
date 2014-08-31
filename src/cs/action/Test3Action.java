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

import cs.entity.Greatseller;
import cs.entity.Greatseller_subtype;
import cs.entity.Greatseller_supertype;
import cs.service.AdminService;
import cs.service.AjaxService;
import cs.service.PagingService;
import cs.vo.PageModel;

public class Test3Action extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 796095487709726762L;
	private Integer id;
	private String name;	//推广商家名
	private Integer subtypeid;	//小分类id
	private Integer suptypeid;	//大分类id
	private String savepath;	//图片路径
	private String content;		//商家介绍
	private String telephone;	//电话
	private String address;		//地址
	private String url;		//商家链接
	private AjaxService ajaxService;
	private PageModel greatsellerpage=new PageModel();
	private PagingService pagingService;
	private Integer pagesize=8;
	private File upload;
	private String uploadFileName;

	
	private Greatseller greatseller;
	private List<Greatseller> list;
	private List<Greatseller_subtype> greatseller_subtypes;
	private List<Greatseller_supertype> greatseller_supertypes;
	List<Integer> listb=new ArrayList<Integer>();
	private String currentPage;

	/**
	 * 根据goodsname找到指定商品 返回list
	 * 
	 * @return String
	 */
	public String findgreatsellerspecial(){
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Greatseller as u where name like ? and shelves=1";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	 if (getCurrentPage()==null)
	    	setCurrentPage("1");
   	greatsellerpage = pagingService.querygreatsellerforpage(phql,pagesize, Integer.parseInt(getCurrentPage()),name,suptypeid,subtypeid);
        list=greatsellerpage.getList();
        return "list";
	}
	
	public String findgreatsellerpage(){
		listb.add(0,1);
		listb.add(1,1);
		for (int i=2;i<=9;i++)
		{
			list = ajaxService.findgreatsellerspecial(null,i,subtypeid);
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

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
