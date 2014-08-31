package cs.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Notice;
import cs.service.AdminService;
import cs.service.PagingService;
import cs.vo.PageModel;

public class NoticemanageAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String content;
	
	private Notice notice;
	private PageModel page = new PageModel();
	private PagingService pagingService;
	private Integer pagesize = 15;
	private List<Notice> list = new ArrayList<Notice>();
	private AdminService adminService;
	private int[] checkbox;
	/**
	 * 显示全部帮助信息
	 * @return
	 * @throws Exception
	 */
	public String shownotice() throws Exception{
	    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
	   	    String phql="from Notice order by id desc";
	        //this.pageBean = pagingService.queryForPage(phql,2, page); 
	   	    System.out.println(phql);
	   	    System.out.println("111111111111111x");
	   	    if ((Object)page.getCurrentPage()==null)
	   	    	page.setCurrentPage(1);
	   	    title=null;
	   	    System.out.println("1111111111111112");
	   	    page = pagingService.queryforpage(phql,pagesize, page.getCurrentPage(),title);
	        List<Integer> list1=new ArrayList<Integer>();
	        System.out.println("1111111111111113");
	        for (Integer i=page.getCurrentPage()-5;i<=page.getCurrentPage()+5;i++)
	        {
	        	if (i<=0||i>page.getTotalPage())
	        		continue;
	        	list1.add(i);
	        }
	        page.setPageList(list1);
	        System.out.println("111111111111111");
	        return "noticelist";
	}
	
	
	public String deletecheckbox() throws Exception{
		System.out.println("checkbox  = " + checkbox.length);
		for (int i = 0; i < checkbox.length; i++) {
			System.out.println(checkbox[i]);
		}
		String[] arr =(String [])ActionContext.getContext().getParameters().get("checkbox");
		System.out.println("checkbox  = " + arr);
		 if(arr!=null)
		 {
		     int[] arrId = new int[arr.length];
		     for (int i = 0; i < arr.length; i++) {
		         arrId[i] = Integer.parseInt(arr[i]);
		         }       
		boolean reslut = false;
		reslut = adminService.deletecheckboxnotice(checkbox);
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
	 *  删除帮助信息
	 */
	public String deletenoticebyid() throws Exception{
		boolean reslut = false;
		reslut = adminService.deletenoticebyid(id);
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
	 * 增加notice
	 * @return String
	 */
	public String addnotice() throws Exception {
		System.out.println("addnotice");
		list = adminService.addnotice(title,content);
		return "addSuccess";
	}
	
	/**
	 * 把页面上修改内容更新到数据库
	 * @return
	 * @throws Exception
	 */
	public String alternotice() throws Exception{   
		System.out.println("asdaasdsa");
		list  = adminService.alternotice(id,title,content);
		return "alterSuccess";
	}
	
	/**
	 * 根据id找到对应的notice并且显示到新页面上
	 * @return
	 * @throws Exception
	 */
	public String altershow() throws Exception{  
		notice = adminService.findnoticebyid(id);
		return "alterShow";
	}
	
	/**
	 * 根据id找到对应的notice并且显示到新页面上
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception{  
		notice = adminService.findnoticebyid(id);
		return "view";
	}
	
	
	/**
	 * 找到指定title的账户 返回list
	 * @param username
	 * @return
	 */
	
	public String findnoticespecial(){
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Notice as u where u.title like ? order by id desc";
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
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
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
	public List<Notice> getList() {
		return list;
	}
	public void setList(List<Notice> list) {
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


	public int[] getCheckbox() {
		return checkbox;
	}


	public void setCheckbox(int[] checkbox) {
		this.checkbox = checkbox;
	}
	
	

}
