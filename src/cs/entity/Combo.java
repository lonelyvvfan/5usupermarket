package cs.entity;

public class Combo {
	private Integer id;
	private String goodsname;    //套餐名
	private Integer inventory; 	//库存量
	private String introduce;    //套餐介绍
	private double price;	//单价（原价）
	private double nowprice;	//现价
	private String savepath;	//主图片路径
	private String savepath1;	//第二张图片路径
	private String savepath2;	//第三张图片路径
	private String savepath3;	//第四张图片路径
	private String shelves;  //商品状态
	private String reason; //推荐理由
	private Integer monthsell;
	private Integer zan;
	
	public String getSavepath1() {
		return savepath1;
	}
	public void setSavepath1(String savepath1) {
		this.savepath1 = savepath1;
	}
	public String getSavepath2() {
		return savepath2;
	}
	public void setSavepath2(String savepath2) {
		this.savepath2 = savepath2;
	}
	public String getSavepath3() {
		return savepath3;
	}
	public void setSavepath3(String savepath3) {
		this.savepath3 = savepath3;
	}
	public String getShelves() {
		return shelves;
	}
	public void setShelves(String shelves) {
		this.shelves = shelves;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getNowprice() {
		return nowprice;
	}
	public void setNowprice(double nowprice) {
		this.nowprice = nowprice;
	}
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	public Integer getMonthsell() {
		return monthsell;
	}
	public void setMonthsell(Integer monthsell) {
		this.monthsell = monthsell;
	}
	public Integer getZan() {
		return zan;
	}
	public void setZan(Integer zan) {
		this.zan = zan;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
}
