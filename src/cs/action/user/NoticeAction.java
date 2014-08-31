package cs.action.user;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Notice;
import cs.service.OrderService;
import cs.service.PagingService;
import cs.vo.PageModel;

public class NoticeAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String content;
	
	private Notice notice;
	private PageModel page = new PageModel();
	private PagingService pagingService;
	private Integer pagesize = 5;
	private List<Notice> list = new ArrayList<Notice>();
	private OrderService orderService;
	private int[] checkbox;
	
	
	/**
	 * 根据id找到对应的notice并且显示到新页面上
	 * @return
	 * @throws Exception
	 */
	public String altershow() throws Exception{  
		notice = orderService.findnoticebyid(id);
		return "alterShow";
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int[] getCheckbox() {
		return checkbox;
	}


	public void setCheckbox(int[] checkbox) {
		this.checkbox = checkbox;
	}


	public OrderService getOrderService() {
		return orderService;
	}


	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
}
