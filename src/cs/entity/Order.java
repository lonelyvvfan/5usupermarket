package cs.entity;

public class Order {
	private int id;
	private Integer orderNo;//订单序列号
	
	private String arrivedday;//到达日期
	private String arrivedtime;//送达时间
	
	private double totalamount;//最终金额
	
	private String username;//用户名
	private String truename;//真实姓名
	private String telephone;//联系电话
	private String school;//学校
	private String living;//生活区
	private String doorplate;//寝室楼号
	private String room;//寝室号
	private String other_address;//其它地址
	private String remark;//备注
	private String payway;//支付方式
	private Integer isclosed;//订单状态
	private String orderday;//下单时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
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
	public Integer getIsclosed() {
		return isclosed;
	}
	public void setIsclosed(Integer isclosed) {
		this.isclosed = isclosed;
	}
	public String getLiving() {
		return living;
	}
	public void setLiving(String living) {
		this.living = living;
	}
	public String getOrderday() {
		return orderday;
	}
	public void setOrderday(String orderday) {
		this.orderday = orderday;
	}
	public String getOther_address() {
		return other_address;
	}
	public void setOther_address(String other_address) {
		this.other_address = other_address;
	}

	
}
