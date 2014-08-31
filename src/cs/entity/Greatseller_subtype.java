package cs.entity;

public class Greatseller_subtype {
	private Integer id;
	private Integer supertype;	//商品大分类
	private String typename;	//分类名
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSupertype() {
		return supertype;
	}
	public void setSupertype(Integer supertype) {
		this.supertype = supertype;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
}
