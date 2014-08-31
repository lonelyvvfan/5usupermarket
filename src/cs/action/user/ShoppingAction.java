package cs.action.user;

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
	private String orderday;  //下单时间
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
	private String other_address;//其它地址
	private String remark;// 备注
	private String payway;// 支付方式
	private Integer isclosed;// 订单状态
	private Cart cart;
	private Integer goodsid;
	private Integer number;
	private double price;
	private ShoppingService shoppingService;
	private UserService userservice;
	private OrderService orderService;
	private GoodsService goodsService;
	private ComboService comboService;
	private List<Goods> goodslist = new ArrayList<Goods>();
	private List<Combo> combolist = new ArrayList<Combo>();
	private String orderNo;
	private String total;
	private Goods goods;
	private Combo combo;
	
	public String addToCart() throws Exception{
		System.out.println("enter addgoods");
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
		System.out.println("isclosed is "+isclosed+" in addgoods");
		System.out.println("orderday is "+orderday+" in addgoods");
		Map session=ActionContext.getContext().getSession();
		cart=(Cart)session.get("cart");
		if(cart==null){
			cart=new Cart();
		}
		cart.addGoods(goodsid, orderitem);
		System.out.println("llll"+cart.getTotalPrice()+cart.getItems().get(isclosed));
		System.out.println("isclosed is "+isclosed+" in addgoods");
		System.out.println("orderday is "+orderday+" in addgoods");
		session.put("cart",cart);
			return "addsuccess";
	}	
	
	public String addCombo() throws Exception{
		System.out.println("enter addgoods");
		int id=goodsid;
		isclosed = 3;
		SimpleDateFormat df = new SimpleDateFormat("yyMMdd");//设置日期格式
		orderday =  df.format(new Date()) ;
		System.out.println("orderday="+orderday);
		Combo combo=shoppingService.findcombobyid(id);
		Order_detail orderitem=new Order_detail();
		orderitem.setSavepath(combo.getSavepath());
		orderitem.setGoodsname(combo.getGoodsname());
		orderitem.setGoodsid(combo.getId());
		orderitem.setNumber(number);
		orderitem.setPrice(combo.getNowprice());
		orderitem.setTotal(Double.parseDouble(String.format("%.2f", number*combo.getNowprice())));
		orderitem.setIsclosed(isclosed);
		orderitem.setOrderday(orderday);
		System.out.println("isclosed is "+isclosed+" in addcombo");
		System.out.println("orderday is "+orderday+" in addcombo");
		Map session=ActionContext.getContext().getSession();
		cart=(Cart)session.get("cart");
		if(cart==null){
			cart=new Cart();
		}
		cart.addGoods(id, orderitem);
		System.out.println("mmmmmmmmmmm"+cart.getTotalPrice());
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
		if(payway.equals("0")&&username==null){
			return "failure";
		}
		else {
			
		
		System.out.println("username"+username);
		Map session=ActionContext.getContext().getSession();
		cart= (Cart) session.get("cart");
		if (cart==null) return "error";
		List<Order_detail> list_detail1 = new ArrayList<Order_detail>();
		for(Iterator it=cart.items.values().iterator();it.hasNext();){
			Order_detail orderitem=(Order_detail)it.next();
			list_detail1.add(orderitem);
			System.out.println("+++++++++++++++++++++"+list_detail1.get(0).getIsclosed()+" " + list_detail1.get(0).getOrderday());
		}
		
		//set username
		//username = ActionContext.getContext().getSession().get("username").toString();
		
		//set isclosed
		isclosed = 3;
		SimpleDateFormat df = new SimpleDateFormat("yyMMdd");//设置日期格式
		//username由String类型的youke加上yymmdd的日期加上随机生成的6位整数组成
		orderday =  df.format(new Date()) ;
		System.out.println("orderday="+orderday);
		
		totalamount=cart.getTotalPrice();
		System.out.println("number and price and totalamount="+ number + " " + price + " " + totalamount + " and the old monthsell is ");
		
		
		Order order=orderService.addorder(arrivedday, arrivedtime,  Double.parseDouble(totalamount), username, truename, telephone, school, living, doorplate, room, remark, payway, isclosed , orderday , other_address);
		Integer id = order.getId();
		System.out.println("isclosed in the list_detail is "+list_detail1.get(0).getIsclosed());
		orderService.addorderdetail(list_detail1, id);
		System.out.println(list_detail1.size()+" 种商品"+list_detail1.get(0).getGoodsid()+" is the first goodsid and the number is "+list_detail1.get(0).getNumber());
		for(int i = 0 ; i < list_detail1.size();i++){
			if(list_detail1.get(i).getGoodsid()<10000){
			alterInventory(list_detail1.get(i).getGoodsid(), list_detail1.get(i).getNumber());
		}else{
			alterComboInventory(list_detail1.get(i).getGoodsid(), list_detail1.get(i).getNumber());
		}
		}
		
		
		Integer ordernum = order.getOrderNo();
		orderNo = ordernum.toString();
		total = new String(totalamount);
		System.out.println(ordernum+"   orderNo!!!");
		ActionContext.getContext().getSession().put("orderNo", orderNo);
		ActionContext.getContext().getSession().put("total", total);
		ActionContext.getContext().getSession().put("ordernum", ordernum);
		ActionContext.getContext().getSession().remove("cart");
		if(payway.equals("1")){
		return "subsuccess";
		}
		else{
			System.out.println(payway + "asdasjlasjflaksjflasjflas");
			return "alipay";
		}
		}
	}
	
	public String delete() throws Exception{
		Map session=ActionContext.getContext().getSession();
		cart= (Cart) session.get("cart");
		cart.items.remove(goodsid);
		return "deleteall";
	}
	
	
	public String alterInventory(Integer goodsid,Integer number){
		goodslist= goodsService.alterInventory(goodsid, number);
		System.out.println("alterinventory invoke success");
		return "alterinventorysuccess";
	}
	
	public String alterComboInventory(Integer goodsid,Integer number){
		combolist = comboService.alterComboInventory(goodsid, number);
		return "altercomboinventorysuccess";
	}
	
	public String deleteall() throws Exception{
		ActionContext.getContext().getSession().remove("cart");
		return "deleteall";
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

	public List<Goods> getGoodslist() {
		return goodslist;
	}

	public void setGoodslist(List<Goods> goodslist) {
		this.goodslist = goodslist;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getLiving() {
		return living;
	}

	public void setLiving(String living) {
		this.living = living;
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

	public String getOrderday() {
		return orderday;
	}

	public void setOrderday(String orderday) {
		this.orderday = orderday;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public List<Combo> getCombolist() {
		return combolist;
	}

	public void setCombolist(List<Combo> combolist) {
		this.combolist = combolist;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getOther_address() {
		return other_address;
	}

	public void setOther_address(String other_address) {
		this.other_address = other_address;
	}


	
	
}
