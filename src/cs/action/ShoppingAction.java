package cs.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Cart;
import cs.entity.Combo;
import cs.entity.Goods;
import cs.entity.Order;
import cs.entity.Order_detail;
import cs.service.ComboService;
import cs.service.GoodsService;
import cs.service.OrderService;
import cs.service.ShoppingService;
import cs.service.UserService;

public class ShoppingAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String arrivedday;// 到达日期
	private String arrivedtime;// 送达时间
	private String totalamount;// 最终金额
	private String username;// 用户名
	private String truename;// 真实姓名
	private String telephone;// 联系电话
	private String school;// 学校
	private String living;//生活区
	private String doorplate;// 寝室楼号
	private String room;// 寝室号
	private String other_address;
	private String remark;// 备注
	private String payway;// 支付方式
	private Integer isclosed=3;// 订单状态
	private Cart cart;
	private Integer goodsid;
	private Integer number;
	private double price;
	private String orderday;
	private ShoppingService shoppingService;
	private UserService userservice;
	private OrderService orderService;
	
	
	public String addToCart() throws Exception{
		Goods goods=shoppingService.findgoodsbyid(goodsid);
		isclosed = 3;
		SimpleDateFormat df = new SimpleDateFormat("yyMMdd");//设置日期格式
		orderday =  df.format(new Date()) ;
		Order_detail orderitem=new Order_detail();
		orderitem.setSavepath(goods.getSavepath());
		orderitem.setGoodsname(goods.getGoodsname());
		orderitem.setGoodsid(goods.getId());
		orderitem.setNumber(number);
		orderitem.setPrice(goods.getNowprice());
		orderitem.setTotal(Double.parseDouble(String.format("%.2f", number*goods.getNowprice())));
		orderitem.setIsclosed(isclosed);
		orderitem.setOrderday(orderday);
		Map session=ActionContext.getContext().getSession();
		cart=(Cart)session.get("cart");
		if(cart==null){
			cart=new Cart();
		}
		cart.addGoods(goodsid, orderitem);
		System.out.println("aaaaaaaaaaaaaaa"+cart.getTotalPrice());
		session.put("cart",cart);
			return "addsuccess";
	}	
	
	public String addCombo() throws Exception{
		System.out.println("aaaaaaaaaaaaaaaaaa"+goodsid);
		int id=goodsid;
		Combo combo=shoppingService.findcombobyid(id);
		isclosed = 3;
		SimpleDateFormat df = new SimpleDateFormat("yyMMdd");//设置日期格式
		orderday =  df.format(new Date()) ;
		Order_detail orderitem=new Order_detail();
		orderitem.setSavepath(combo.getSavepath());
		orderitem.setGoodsname(combo.getGoodsname());
		orderitem.setGoodsid(combo.getId());
		orderitem.setNumber(number);
		orderitem.setPrice(combo.getNowprice());
		orderitem.setTotal(Double.parseDouble(String.format("%.2f", number*combo.getNowprice())));
		orderitem.setIsclosed(isclosed);
		orderitem.setOrderday(orderday);
		Map session=ActionContext.getContext().getSession();
		cart=(Cart)session.get("cart");
		if(cart==null){
			cart=new Cart();
		}
		cart.addGoods(id, orderitem);
		System.out.println("aaaaaaaaaaaaaaa"+cart.getTotalPrice());
		session.put("cart",cart);
			return "addsuccess";
	}
	
	public String updateCart() throws Exception{
		Map session=ActionContext.getContext().getSession();
		cart=(Cart)session.get("cart");
		cart.updateCart(goodsid, number);
		session.put("cart", cart);
		return SUCCESS;
	}
	/*
	public String checkout() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Cart cart=(Cart)session.get("cart");
		if(user==null || cart==null)
		return ERROR;
		Order order=new Order();
		userservice.addorder(arrivedday, arrivedtime, totalamount, username, truename, telephone, school, doorplate, room, remark, payway, isclosed);
		userservice.addorderdetail(list, id);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("order",order);
		return SUCCESS;
		};
	*/
	
	public String checkout() throws Exception{
		Map session=ActionContext.getContext().getSession();
		cart= (Cart) session.get("cart");
		if (cart==null) return "error";
		List<Order_detail> list_detail1 = new ArrayList<Order_detail>();
		for(Iterator it=cart.items.values().iterator();it.hasNext();){
			Order_detail orderitem=(Order_detail)it.next();
			list_detail1.add(orderitem);
		}
		
		//set name
		SimpleDateFormat df = new SimpleDateFormat("yyMMdd");//设置日期格式
		//username由String类型的youke加上yymmdd的日期加上随机生成的6位整数组成
		username = "youke" + df.format(new Date()) + (int)(Math.random()*100000);
		System.out.println("1username="+username);
		
		//set isclosed
		isclosed = 3;
		
		totalamount=cart.getTotalPrice();
		Order order=orderService.addorder(arrivedday, arrivedtime,  Double.parseDouble(totalamount), username, truename, telephone, school, living, doorplate, room, remark, payway, isclosed , orderday, other_address);
		orderService.addorderdetail(list_detail1,order.getId());
		Integer ordernum = order.getOrderNo();
		System.out.println(ordernum+"   orderNo!!!");
		ActionContext.getContext().getSession().put("ordernum", ordernum);
		ActionContext.getContext().getSession().remove("cart");
		return "subsuccess";
	}
	
	public String delete() throws Exception{
		Map session=ActionContext.getContext().getSession();
		cart= (Cart) session.get("cart");
		cart.items.remove(goodsid);
		return "deleteall";
	}
	
	public String deleteall() throws Exception{
		ActionContext.getContext().getSession().remove("cart");
		return "deleteall";
	}



	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}



	public ShoppingService getShoppingService() {
		return shoppingService;
	}

	public void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
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

	public String getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(String totalamount) {
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

	public Integer getIsclosed() {
		return isclosed;
	}

	public void setIsclosed(Integer isclosed) {
		this.isclosed = isclosed;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getLiving() {
		return living;
	}

	public void setLiving(String living) {
		this.living = living;
	}

	public String getOther_address() {
		return other_address;
	}

	public void setOther_address(String other_address) {
		this.other_address = other_address;
	}


	
	
}
