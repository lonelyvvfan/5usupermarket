package cs.entity;

public class Order_detail {
	private int id;
	private int orderid;//订单id
	private int goodsid;//商品id
	private double price;//现价
	private int number;//数量
	private double total;//总价一
	private String goodsname;//商品名
	private Integer isclosed;//订单状态
	private String orderday; //下单时间
	private String savepath;//图片路径
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public double getTotal() {
		return this.price*this.number;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
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
	
}
