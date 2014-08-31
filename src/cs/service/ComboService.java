package cs.service;

import java.util.List;

import cs.entity.Combo;
import cs.entity.Goods;
import cs.vo.PageModel;

public interface ComboService {
	public List<Combo> queryallcombo(PageModel page);
	public List<Combo> findcombospecial(String goodsname,Integer id,Integer typeid);
	public Combo findcombobyid(Integer id);	
	//public List<Combo> findGoodsbyid2(int typeid);
	public boolean dianzan(int id);
	
	public List<Combo> alterComboInventory(Integer goodsid,Integer number);
}
