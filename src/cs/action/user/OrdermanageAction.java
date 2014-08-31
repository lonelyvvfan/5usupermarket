package cs.action.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import cs.entity.Order;
import cs.entity.Order_detail;
import cs.service.AdminService;
import cs.service.PagingService;
import cs.service.UserService;
import cs.vo.PageModel;

public class OrdermanageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int id;
	private int orderNo;// 订单序列号
	private String arrivedday;// 到达日期
	private String arrivedtime;// 送达时间
	private double totalamount;// 最终金额
	private String username;// 用户名
	private String truename;// 真实姓名
	private String telephone;// 联系电话
	private String school;// 学校
	private String doorplate;// 寝室楼号
	private String room;// 寝室号
	private String remark;// 备注
	private String payway;// 支付方式
	private int isclosed;// 订单状态
	
	/* 订单详情 */
	private Integer id_detail;
	private Integer orderid;	//订单id	
	private Integer goodsid; 	//商品id
	private double price;		//商品单价
	private Integer number; 	//商品数量
	
	private PageModel orderpage = new PageModel();
	private PagingService pagingService;
	private Integer pagesize = 20;
	private Order order;
	private List<Order> list = new ArrayList<Order>();
	private List<Order_detail> list_detail = new ArrayList<Order_detail>();
	private List<Order_detail> list_detail1 = new ArrayList<Order_detail>();
	private UserService userService;
	
	/**
	 * 根据username,iscloded找到指定订单返回list
	 * 
	 * @return String
	 */
	public String findorderspecial()throws Exception{
		username = ActionContext.getContext().getSession().get("username").toString();
		System.out.println(username);
		//goods_supertypes = adminService.showsuptype();
		//goods_subtypes = adminService.showsubtype();
		System.out.println("username="+username);
	   	System.out.println("isclosed="+isclosed);
    	//分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
   	    String phql="from Order as u where username = ?";
        //this.pageBean = pagingService.queryForPage(phql,2, page); 
   	    
   	    System.out.println(phql);
   	    if ((Object)orderpage.getCurrentPage()==null)
   	    	orderpage.setCurrentPage(1);
   	    orderpage = pagingService.queryorderforpagebyuser(phql,pagesize, orderpage.getCurrentPage(),username);
        List<Integer> list1=new ArrayList<Integer>();
        for (Integer i=orderpage.getCurrentPage()-2;i<=orderpage.getCurrentPage()+2;i++)
        {
        	if (i<=0||i>orderpage.getTotalPage())
        		continue;
        	list1.add(i);
        }
        System.out.println(list1);
        orderpage.setPageList(list1);
        return "findsuccess";
	}
	
	public String altershow() throws Exception{
		order = userService.findorderbyid(id);
		list_detail=userService.findorderdetailbyid(id);
		return "alterShow";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getArrivedday() {
		return arrivedday;
	}

	public void setArrivedday(String arrivedday) {
		this.arrivedday = arrivedday;
	}

	public String getArrivedtime() {
		return arrivedtime;
	}

	public void setArrivedtime(String arrivedtime) {
		this.arrivedtime = arrivedtime;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getDoorplate() {
		return doorplate;
	}

	public void setDoorplate(String doorplate) {
		this.doorplate = doorplate;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPayway() {
		return payway;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}

	public int getIsclosed() {
		return isclosed;
	}

	public void setIsclosed(int isclosed) {
		this.isclosed = isclosed;
	}

	public PageModel getOrderpage() {
		return orderpage;
	}

	public void setOrderpage(PageModel orderpage) {
		this.orderpage = orderpage;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getList() {
		return list;
	}

	public void setList(List<Order> list) {
		this.list = list;
	}

	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public List<Order_detail> getList_detail() {
		return list_detail;
	}

	public void setList_detail(List<Order_detail> list_detail) {
		this.list_detail = list_detail;
	}

	public Integer getId_detail() {
		return id_detail;
	}

	public void setId_detail(Integer id_detail) {
		this.id_detail = id_detail;
	}

	public List<Order_detail> getList_detail1() {
		return list_detail1;
	}

	public void setList_detail1(List<Order_detail> list_detail1) {
		this.list_detail1 = list_detail1;
	}

	
}
