package cs.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Secondgoods;
import cs.entity.Secondgoods_subtype;
import cs.entity.Secondgoods_supertype;
import cs.service.AdminService;
import cs.service.GoodsService;
import cs.service.PagingService;
import cs.service.SecgoodsService;
import cs.vo.PageModel;

public class SecgoodsAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Integer id;  
	private Integer userid; //发布用户id;
	private String username;    //发布用户名
	private Integer subtypeid;   //子类类型id
	private Integer suptypeid;   //父类类型id
	private String goodsname;    //商品名
	private String introduce;    //商品介绍
	private double price;	//单价
	private double nowprice;	//新价
	private String school; //school
	private Integer newgoods;	//是否为新品
	private Integer hot;	//是否为热销商品
	private Integer special;	//是否为特价商品
	private Integer health;		//是否为健康商品
	private Integer recommend;	//是否为推荐商品
	private String reason;//
	private String living;
	private String telephone;
	private String qq;
	private String nickname;
	private String sellnickname;
	private String sellgoodsname;    //商品名
	private double sellprice;	//单价
	private String sellreason;
	private String sellqq;
	private String sellintroduce;
	private String userschool;
	private PagingService pagingService;
	private Integer pagesize=5;

	private SecgoodsService secgoodsService;
	private Secondgoods secondgoods;
	private List<Secondgoods> list;
	private List<Secondgoods_subtype> goods_subtypes;
	private List<Secondgoods_supertype> goods_supertypes;



	private PageModel goodspage=new PageModel();

	/**
	 * 根据id找到对应的goods并且显示到新页面上
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String altershow() throws Exception {
		System.out.print("aaasdasdfdgsfdgsgsd="+id);
		secondgoods = secgoodsService.findsecgoodsbyid(id);
		System.out.println("aaaaaaaaaaaaaaaaa="+secondgoods.getGoodsname());
		return "alterShow";
	}
	
	public String add() throws Exception{

		ActionContext.getContext().getSession().put("sellnickname", nickname);
		ActionContext.getContext().getSession().put("sellgoodsname", goodsname);
		ActionContext.getContext().getSession().put("sellprice", price);
		ActionContext.getContext().getSession().put("sellreason", reason);
		ActionContext.getContext().getSession().put("userschool", school);
		ActionContext.getContext().getSession().put("living", living);
		ActionContext.getContext().getSession().put("sellqq", qq);
		ActionContext.getContext().getSession().put("telephone", telephone);
		ActionContext.getContext().getSession().put("sellintroduce", introduce);
		return "add";
	}

	public String getLiving() {
		return living;
	}

	public void setLiving(String living) {
		this.living = living;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getSubtypeid() {
		return subtypeid;
	}

	public void setSubtypeid(Integer subtypeid) {
		this.subtypeid = subtypeid;
	}

	public Integer getSuptypeid() {
		return suptypeid;
	}

	public void setSuptypeid(Integer suptypeid) {
		this.suptypeid = suptypeid;
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

	public Integer getNewgoods() {
		return newgoods;
	}

	public void setNewgoods(Integer newgoods) {
		this.newgoods = newgoods;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Integer getSpecial() {
		return special;
	}

	public void setSpecial(Integer special) {
		this.special = special;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public String getSellreason() {
		return sellreason;
	}

	public void setSellreason(String sellreason) {
		this.sellreason = sellreason;
	}

	public String getSellqq() {
		return sellqq;
	}

	public void setSellqq(String sellqq) {
		this.sellqq = sellqq;
	}

	public String getSellintroduce() {
		return sellintroduce;
	}

	public void setSellintroduce(String sellintroduce) {
		this.sellintroduce = sellintroduce;
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

	public SecgoodsService getSecgoodsService() {
		return secgoodsService;
	}

	public void setSecgoodsService(SecgoodsService secgoodsService) {
		this.secgoodsService = secgoodsService;
	}

	public Secondgoods getSecondgoods() {
		return secondgoods;
	}

	public void setSecondgoods(Secondgoods secondgoods) {
		this.secondgoods = secondgoods;
	}

	public List<Secondgoods> getList() {
		return list;
	}

	public void setList(List<Secondgoods> list) {
		this.list = list;
	}

	public List<Secondgoods_subtype> getGoods_subtypes() {
		return goods_subtypes;
	}

	public void setGoods_subtypes(List<Secondgoods_subtype> goods_subtypes) {
		this.goods_subtypes = goods_subtypes;
	}

	public List<Secondgoods_supertype> getGoods_supertypes() {
		return goods_supertypes;
	}

	public void setGoods_supertypes(List<Secondgoods_supertype> goods_supertypes) {
		this.goods_supertypes = goods_supertypes;
	}

	public PageModel getGoodspage() {
		return goodspage;
	}

	public void setGoodspage(PageModel goodspage) {
		this.goodspage = goodspage;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSellnickname() {
		return sellnickname;
	}

	public void setSellnickname(String sellnickname) {
		this.sellnickname = sellnickname;
	}

	public String getSellgoodsname() {
		return sellgoodsname;
	}

	public void setSellgoodsname(String sellgoodsname) {
		this.sellgoodsname = sellgoodsname;
	}

	public double getSellprice() {
		return sellprice;
	}

	public void setSellprice(double sellprice) {
		this.sellprice = sellprice;
	}

	public String getUserschool() {
		return userschool;
	}

	public void setUserschool(String userschool) {
		this.userschool = userschool;
	}

	
}
