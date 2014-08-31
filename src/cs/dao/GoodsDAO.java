package cs.dao;

import java.util.List;

import cs.entity.Admin;
import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Seller;
import cs.entity.User;
import cs.vo.PageModel;

public interface GoodsDAO {

	public List<Goods> queryallgoods(PageModel page);

	public Goods findgoodsbyid(int id);
	
	public List<Goods> findgoodsbyid2(int typeid);

	public List<Goods> findgoodsspecial(String goodsname,Integer id,Integer typeid);
	
	public List<Goods_subtype> showsubtype();
	
	public List<Goods_supertype> showsuptype();
	
	public boolean dianzan(int id);
	
	public List<Goods> alterInventory(Integer goodsid,Integer number);
}
