package cs.entity;

public class Secondgoods {
	private Integer id;  
	private Integer userid; //发布用户id;
	private String username;    //发布用户名
	private String nickname;    //发布者真实姓名
	private Integer subtypeid;   //子类类型id
	private Integer suptypeid;   //父类类型id
	private String goodsname;    //商品名
	private String introduce;    //商品介绍
	private double price;	//单价
	private double nowprice;	//新价
	private String school;//学校
	private String living;//生活区
	private String savepath;	//主图片路径
	private String savepath1;	//第二张图片路径
	private String savepath2;	//第三张图片路径
	private String savepath3;	//第四张图片路径
	private Integer newgoods;	//是否为新品
	private Integer hot;	//是否为热销商品
	private Integer special;	//是否为特价商品
	private Integer health;		//是否为健康商品
	private Integer recommend;	//是否为推荐商品
	private String shelves;  //商品状态
	private String qq;
	private String telephone;
	private String other;
	private String reason; //推荐理由
	private Integer recency; //新旧程度
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

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
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
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
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getRecency() {
		return recency;
	}
	public void setRecency(Integer recency) {
		this.recency = recency;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getLiving() {
		return living;
	}
	public void setLiving(String living) {
		this.living = living;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
