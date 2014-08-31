package cs.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import sun.org.mozilla.javascript.internal.regexp.SubString;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Cart;
import cs.entity.Combo;
import cs.entity.Goods;
import cs.entity.Order_detail;
import cs.service.ShoppingService;

public class AjaxshoppingAction extends ActionSupport{
	
	private String username;
	private Integer goodsid;
	private Integer number;
	private ShoppingService shoppingService;
	private List<Object> list=new ArrayList<Object>();
	private List<Integer> list1=new ArrayList<Integer>();
	private Cart cart;
	private Integer isclosed;// 订单状态
	private String orderday;  //下单时间
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String buyone(){
		isclosed = 1;
		SimpleDateFormat df = new SimpleDateFormat("yyMMdd");//设置日期格式
		orderday =  df.format(new Date()) ;
		Goods goods=shoppingService.findgoodsbyid(goodsid);
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
		session.put("cart",cart);
		return "list";
	}
	
	public String buycombo(){
		isclosed = 1;
		SimpleDateFormat df = new SimpleDateFormat("yyMMdd");//设置日期格式
		orderday =  df.format(new Date()) ;
		int id=goodsid;
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
		Map session=ActionContext.getContext().getSession();
		cart=(Cart)session.get("cart");
		if(cart==null){
			cart=new Cart();
		}
		cart.addGoods(id, orderitem);
		session.put("cart",cart);
		return "list";
	}
	
	public String checkusername(){
		boolean r=shoppingService.isexist(username);
		list.add(0, r);
		return "list";
	}
	
	public String updategoods() throws Exception{
		Map session=ActionContext.getContext().getSession();
		cart=(Cart)session.get("cart");
		list1.clear();
		if (goodsid<=10000){
			list1.add(shoppingService.findgoodsbyid(goodsid).getInventory());
		}else{
			list1.add(shoppingService.findcombobyid(goodsid).getInventory());
		}
		cart.updateCart(goodsid, number);
		String totalprice = cart.getTotalPrice();
		String after = totalprice.substring(totalprice.lastIndexOf("."),1);
		System.out.println(cart.getTotalPrice()+" is the totalprice in the ajaxaction"+after+"2222223");
		session.put("cart", cart);
		list.add(0, cart.getTotalPrice());
		int i=0;
		for (Integer key : cart.getItems().keySet()) {
				i++;
				list.add(i, cart.getItems().get(key));
			}
		return "list";
	}
	
	public String delete() throws Exception{
		Map session=ActionContext.getContext().getSession();
		cart= (Cart) session.get("cart");
		cart.items.remove(goodsid);
		return "list";
	}
	
	public Integer getIsclosed() {
		return isclosed;
	}

	public void setIsclosed(Integer isclosed) {
		this.isclosed = isclosed;
	}

	public String getOrderday() {
		return orderday;
	}

	public void setOrderday(String orderday) {
		this.orderday = orderday;
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
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Integer> getList1() {
		return list1;
	}

	public void setList1(List<Integer> list1) {
		this.list1 = list1;
	}

	
}
