package cs.action.user;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;

import com.opensymphony.xwork2.ActionSupport;

import cs.entity.HelpCenter;
import cs.service.OrderService;
import cs.service.PagingService;
import cs.vo.PageModel;

public class HelpAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String content;
	
	private HelpCenter helpCenter;
	private PageModel page = new PageModel();
	private PagingService pagingService;
	private Integer pagesize = 5;
	private List<HelpCenter> list = new ArrayList<HelpCenter>();
	private OrderService orderService;
	
	/**
	 * 根据id找到对应的helpCenter并且显示到新页面上
	 * @return
	 * @throws Exception
	 */
	public String altershow() throws Exception{  
		System.out.println(id);
		helpCenter = orderService.findhelpbyid(id);
		System.out.println(title+"11111");
		System.out.println(content+"22222");
		return "alterShow";
	}
	
	/**
	 * 根据id找到对应的helpCenter并且显示到新页面上
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception{  
		helpCenter = orderService.findhelpbyid(id);
		return "view";
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	

}
