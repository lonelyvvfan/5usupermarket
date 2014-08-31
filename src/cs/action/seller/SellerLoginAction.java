package cs.action.seller;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Seller;
import cs.entity.Takeout;
import cs.service.SellerService;

public class SellerLoginAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private Seller seller;

	private SellerService sellerService;
	private List<Takeout> list;
	
	public String logout() throws Exception {
		ActionContext.getContext().getSession().clear();
		return "logout";
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
