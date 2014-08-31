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

import cs.entity.Sellertype;
import cs.entity.Takeout;
import cs.entity.Takeout_subtype;
import cs.entity.Takeout_supertype;
import cs.service.AdminService;
import cs.service.AjaxService;
import cs.service.PagingService;
import cs.vo.PageModel;

public class Test4Action extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6253297714868920120L;
	private Integer id;
	private String name;
	private Integer suptypeid;
	private Integer subtypeid;
	private Integer sellerid;
	private String savepath;
	private AjaxService ajaxService;
	private AdminService adminService;
	private PageModel sellertypepage = new PageModel(); 
	private PagingService pagingService;
	private Integer pagesize=8;
	private File upload;
	private String uploadFileName;
	private String currentPage;
	private Sellertype sellertype;
	private List<Sellertype> list;
	List<Integer> listb=new ArrayList<Integer>();
	
	
	/**
	 * 根据goodsname找到指定商品 返回list
	 * 
	 * @return String
	 */
	public String findsellertypespecial(){
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Sellertype as u where name like ? ";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	 if (getCurrentPage()==null)
	    	setCurrentPage("1");
   	 	sellertypepage = pagingService.querysellertypeforpage(phql,pagesize, Integer.parseInt(getCurrentPage()),name,suptypeid,subtypeid);
        list=sellertypepage.getList();
        for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j).getSellerid()==list.get(i).getSellerid()) {
					list.remove(j);
				}
			}
		}
        return "list";
	}
	
	public String findsellertypepage(){
		listb.add(0,1);
		listb.add(1,1);
		for (int i=2;i<=4;i++)
		{
			list = ajaxService.findsellertypespecial(null,i,subtypeid);
			for (int k = 0; k < list.size() - 1; k++) {
				for (int j = list.size() - 1; j > k; j--) {
					if (list.get(j).getSellerid()==list.get(k).getSellerid()) {
						list.remove(j);
					}
				}
			}
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

	public Integer getSuptypeid() {
		return suptypeid;
	}

	public void setSuptypeid(Integer suptypeid) {
		this.suptypeid = suptypeid;
	}

	public Integer getSubtypeid() {
		return subtypeid;
	}

	public void setSubtypeid(Integer subtypeid) {
		this.subtypeid = subtypeid;
	}

	public Integer getSellerid() {
		return sellerid;
	}

	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}

	public String getSavepath() {
		return savepath;
	}

	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}

	public AjaxService getAjaxService() {
		return ajaxService;
	}

	public void setAjaxService(AjaxService ajaxService) {
		this.ajaxService = ajaxService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public PageModel getSellertypepage() {
		return sellertypepage;
	}

	public void setSellertypepage(PageModel sellertypepage) {
		this.sellertypepage = sellertypepage;
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

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public Sellertype getSellertype() {
		return sellertype;
	}

	public void setSellertype(Sellertype sellertype) {
		this.sellertype = sellertype;
	}

	public List<Sellertype> getList() {
		return list;
	}

	public void setList(List<Sellertype> list) {
		this.list = list;
	}

	public List<Integer> getListb() {
		return listb;
	}

	public void setListb(List<Integer> listb) {
		this.listb = listb;
	}

	
}
