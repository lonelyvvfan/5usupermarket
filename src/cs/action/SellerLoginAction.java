package cs.action;

import cs.entity.Seller;
import cs.service.SellerService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SellerLoginAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String username;	//	外卖商家用户名
	private String password;	//	外卖商家密码
	private String name;	//	外卖商家名
	private String telephone;	//	联系电话
	private String address;		//	地址
	private String email;		//	电子邮件
	private String alipaynum;		//	支付宝帐号
	private String identification;		//	身份证号
	private String reason;			//推荐理由
	private String author;		//	权限
	private String content;		//	介绍
	private String savepath;    //logo
	private Seller seller;
	private SellerService sellerService;
	
	public String resetpassword(){
		System.out.println("reset password");
		System.out.println(username);
		System.out.println(telephone);
		System.out.println(identification);
		if( null == username && null == telephone && null == identification ){
			return "error";
		}else{
			Boolean u = sellerService.resetpassword(username, telephone, identification);
			if(u){
				password = "000000";
				setSeller(sellerService.findsellerbyuername(username));
				setId(seller.getId());
				setUsername(seller.getUsername());
				setName(seller.getName());
				setTelephone(seller.getTelephone());
				setAddress(seller.getAddress());
				setEmail(seller.getEmail());
				setAlipaynum(seller.getAlipaynum());
				setIdentification(seller.getIdentification());
				setReason(seller.getReason());
				setAuthor(seller.getAuthor());
				setContent(seller.getContent());
				setSavepath(seller.getSavepath());
				System.out.println(password+" is the password before altering");
				sellerService.alterseller(id, username, password, name, telephone, email, alipaynum, identification, address, savepath, author, content , reason);
				return "resetok";
			}else{
				System.out.println("username or telephone is wrong");
				return "reseterror";
			}
		}
	}
	
	public String sellerlogin() {
		System.out.println(username);
		System.out.println(password);
		if(null == username && null == password){
			return "login";
		}else{
			boolean u = sellerService.login(username, password);
			System.out.println(username+" return to the login action");
			if (u) {
				seller = sellerService.findsellerbyuername(username);
				setId(seller.getId());
				String sellername = seller.getName();
				ActionContext.getContext().getSession().put("author", "1");
				ActionContext.getContext().getSession().put("sellerid", id);
				ActionContext.getContext().getSession().put("username", username);
				ActionContext.getContext().getSession().put("sellername", sellername);
				return "ok";
			}else{
				return "error";
			}
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public SellerService getSellerService() {
		return sellerService;
	}

	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
	public void setId(Integer id) {
		this.id = id;
	}

	public String getSavepath() {
		return savepath;
	}

	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}

}
