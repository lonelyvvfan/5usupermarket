package cs.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;

import com.opensymphony.xwork2.ActionSupport;

import cs.entity.HelpCenter;
import cs.entity.Keyword;
import cs.service.AdminService;
import cs.service.PagingService;
import cs.vo.PageModel;

public class KeywordmanageAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	
	private Keyword keyword;
	private PageModel page = new PageModel();
	private PagingService pagingService;
	private Integer pagesize = 15;
	private List<Keyword> list = new ArrayList<Keyword>();
	private AdminService adminService;
	
	/**
	 * 显示全部帮助信息
	 * @return
	 * @throws Exception
	 */
	public String showkeyword() throws Exception{
	    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
	   	    String phql="from Keyword order by id desc";
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
	        return "keywordlist";
	}
	
	/**
	 *  删除帮助信息
	 */
	public String deletekeywordbyid() throws Exception{
		boolean reslut = false;
		reslut = adminService.deletekeywordbyid(id);
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
	public String addkeyword() throws Exception {
		System.out.println("addhelp");
		list = adminService.addkeyword(title);
		return "addSuccess";
	}
	
	/**
	 * 把页面上修改内容更新到数据库
	 * @return
	 * @throws Exception
	 */
	public String alterkeyword() throws Exception{   
		System.out.println("asdaasdsa");
		list  = adminService.alterkeyword(id,title);
		return "alterSuccess";
	}
	
	/**
	 * 根据id找到对应的helpCenter并且显示到新页面上
	 * @return
	 * @throws Exception
	 */
	public String altershow() throws Exception{  
		keyword = adminService.findkeywordbyid(id);
		return "alterShow";
	}
	
	/**
	 * 根据id找到对应的helpCenter并且显示到新页面上
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception{  
		keyword = adminService.findkeywordbyid(id);
		return "view";
	}
	
	
	/**
	 * 找到指定title的账户 返回list
	 * @param username
	 * @return
	 */
	
	public String findkeywordspecial(){
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Keyword as u where u.title like ? order by id desc";
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
	public List<Keyword> getList() {
		return list;
	}
	public void setList(List<Keyword> list) {
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

	public Keyword getKeyword() {
		return keyword;
	}

	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}
	
	

}
