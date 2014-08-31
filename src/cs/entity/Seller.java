package cs.entity;

public class Seller {
	private Integer id;	
	private String username;	//	外卖商家用户名
	private String password;	//	外卖商家密码
	private String name;	//	外卖商家名
	private String telephone;	//	联系电话
	private String address;		//	地址
	private String email;		//	电子邮件
	private String alipaynum;		//	支付宝帐号
	private String identification;		//	身份证号
	private String savepath;	//	图片路径
	private String author;		//	权限
	private String content;		//	介绍
	private String reason; 	//推荐理由
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAlipaynum() {
		return alipaynum;
	}
	public void setAlipaynum(String alipaynum) {
		this.alipaynum = alipaynum;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
