package cs.entity;

public class GoodsCount {
	private int number;//数量
	private double total;//总价一
	private String goodsname;//商品名
	private Integer isclosed;//订单状态
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getTotal() {
		return total;
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
	public Integer getIsclosed() {
		return isclosed;
	}
	public void setIsclosed(Integer isclosed) {
		this.isclosed = isclosed;
	}
	

}
