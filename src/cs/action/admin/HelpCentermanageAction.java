package cs.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;

import com.opensymphony.xwork2.ActionSupport;

import cs.entity.HelpCenter;
import cs.service.AdminService;
import cs.service.PagingService;
import cs.vo.PageModel;

public class HelpCentermanageAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String content;
	
	private HelpCenter helpCenter;
	private PageModel page = new PageModel();
	private PagingService pagingService;
	private Integer pagesize = 15;
	private List<HelpCenter> list = new ArrayList<HelpCenter>();
	private AdminService adminService;
	
	/**
	 * 显示全部帮助信息
	 * @return
	 * @throws Exception
	 */
	public String showhelpcenter() throws Exception{
	    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
	   	    String phql="from HelpCenter order by id desc";
	        //this.pageBean = pagingService.queryForPage(phql,2, page); 
	   	    System.out.println(phql);
	   	    if ((Object)page.getCurrentPage()==null)
	   	    	page.setCurrentPage(1);
	   	    title=null;
	   	    page = pagingService.queryforpage(phql,pagesize, page.getCurrentPage(),title);
	        List<Integer> list1=new ArrayList<Integer>();
	        for (Integer i=page.getCurrentPage()-5;i<=page.getCurrentPage()+5;i++)
	        {
	        	if (i<=0||i>page.getTotalPage())
	        		continue;
	        	list1.add(i);
	        }
	        page.setPageList(list1);
	        return "helplist";
	}
	
	/**
	 *  删除帮助信息
	 */
	public String deletehelpbyid() throws Exception{
		boolean reslut = false;
		reslut = adminService.deletehelpbyid(id);
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
	 * 增加help
	 * @return String
	 */
	public String addhelp() throws Exception {
		System.out.println("addhelp");
		list = adminService.addhelp(title,content);
		return "addSuccess";
	}
	
	/**
	 * 把页面上修改内容更新到数据库
	 * @return
	 * @throws Exception
	 */
	public String alterhelp() throws Exception{   
		System.out.println("asdaasdsa");
		list  = adminService.alterhelp(id,title,content);
		return "alterSuccess";
	}
	
	/**
	 * 根据id找到对应的helpCenter并且显示到新页面上
	 * @return
	 * @throws Exception
	 */
	public String altershow() throws Exception{  
		helpCenter = adminService.findhelpbyid(id);
		return "alterShow";
	}
	
	/**
	 * 根据id找到对应的helpCenter并且显示到新页面上
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception{  
		helpCenter = adminService.findhelpbyid(id);
		return "view";
	}
	
	
	/**
	 * 找到指定title的账户 返回list
	 * @param username
	 * @return
	 */
	
	public String findhelpspecial(){
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from HelpCenter as u where u.title like ? order by id desc";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    System.out.println(phql);
   	    if ((Object)page.getCurrentPage()==null)
   	    	page.setCurrentPage(1);
   	 page = pagingService.queryforpage(phql,pagesize, page.getCurrentPage(),title);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=page.getCurrentPage()-5;i<=page.getCurrentPage()+5;i++)
        {
        	if (i<=0||i>page.getTotalPage())
        		continue;
        	list1.add(i);
        }
        page.setPageList(list1);
        System.out.print("list1=" + list1);
        return "findsuccess";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public HelpCenter getHelpCenter() {
		return helpCenter;
	}
	public void setHelpCenter(HelpCenter helpCenter) {
		this.helpCenter = helpCenter;
	}
	public PageModel getPage() {
		return page;
	}
	public void setPage(PageModel page) {
		this.page = page;
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
	public List<HelpCenter> getList() {
		return list;
	}
	public void setList(List<HelpCenter> list) {
		this.list = list;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
