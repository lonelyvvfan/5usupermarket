package cs.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Secondgoods;
import cs.entity.Secondgoods_subtype;
import cs.entity.Secondgoods_supertype;
import cs.entity.Seller;
import cs.entity.Takeout;
import cs.entity.Takeout_subtype;
import cs.entity.Takeout_supertype;
import cs.service.AdminService;
import cs.service.GoodsService;
import cs.service.PagingService;
import cs.service.SecgoodsService;
import cs.service.SellerService;
import cs.service.TakeoutService;
import cs.vo.PageModel;

public class TakeoutAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Integer id;	
	private Integer sellerid;
	private Integer suptypeid;
	private Integer subtypeid;
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
	private PagingService pagingService;
	private Integer pagesize=5;

	private SellerService sellerService;
	private TakeoutService takeoutService;
	private Seller seller;
	private Takeout	takeout;



	private PageModel goodspage=new PageModel();

	/**
	 * 根据id找到对应的goods并且显示到新页面上
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String altershow() throws Exception {
		System.out.print("aaasdasdfdgsfdgsgsd="+sellerid);
		seller = sellerService.findsellerbyid(sellerid);
		return "alterShow";
	}
	
	/**
	 * 根据id找到对应的goods并且显示到新页面上
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String showtakeout() throws Exception {
		takeout = takeoutService.findtakeoutbyid(id);
		System.out.println("aaaaaaaaaaaaaaaaa="+takeout.getGoodsname());
		return "showtakeout";
	}

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

	public PagingService getPagingService() {
		return pagingService;
	}

	public void setPagingService(PagingService pagingService) {
		this.pagingService = pagingService;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public SellerService getSellerService() {
		return sellerService;
	}

	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	public Takeout getTakeout() {
		return takeout;
	}

	public void setTakeout(Takeout takeout) {
		this.takeout = takeout;
	}

	public PageModel getGoodspage() {
		return goodspage;
	}

	public void setGoodspage(PageModel goodspage) {
		this.goodspage = goodspage;
	}

	public Integer getSellerid() {
		return sellerid;
	}

	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}

	public Integer getSuptypeid() {
		return suptypeid;
	}

	public void setSuptypeid(Integer suptypeid) {
		this.suptypeid = suptypeid;
	}

	public Integer getSubtypeid() {
		return subtypeid;
	}

	public void setSubtypeid(Integer subtypeid) {
		this.subtypeid = subtypeid;
	}

	public TakeoutService getTakeoutService() {
		return takeoutService;
	}

	public void setTakeoutService(TakeoutService takeoutService) {
		this.takeoutService = takeoutService;
	}
	
	
}
