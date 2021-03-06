package cs.service;

import java.util.List;

import cs.entity.Combo;
import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.vo.PageModel;

public interface ShoppingService {
	public boolean isexist(String username);
	public List<Goods_subtype> showsubtype();
	public List<Goods> queryallgoods(PageModel page);
	public List<Goods> findgoodsspecial(String goodsname,Integer id,Integer typeid);
	public List<Goods_supertype> showsuptype();
	public Goods findgoodsbyid(Integer id);	
	public List<Goods> findGoodsbyid2(int typeid);
	public boolean dianzan(int id);
	public Combo findcombobyid(Integer id);	
}
