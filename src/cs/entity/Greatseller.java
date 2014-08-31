package cs.entity;


public class Greatseller {
	private Integer id;
	private String name;	//推广商家名
	private Integer subtypeid;	//小分类id
	private Integer suptypeid;	//大分类id
	private String savepath;	//主图片路径
	private String savepath1;	//第二张图片路径
	private String savepath2;	//第三张图片路径
	private String savepath3;	//第四张图片路径
	private String content;		//商家介绍
	private String telephone;	//电话
	private String address;		//地址
	private String url;		//商家链接
	private String shelves;  //商品状态
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	
}
