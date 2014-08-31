package cs.dao;

import java.util.List;

import cs.entity.Admin;
import cs.entity.Combo;
import cs.entity.Seller;
import cs.entity.User;
import cs.vo.PageModel;

public interface ComboDAO {

	public List<Combo> queryallcombo(PageModel page);

	public Combo findcombobyid(int id);
	
	//public List<Combo> findcombobyid2(int typeid);

	public List<Combo> findcombospecial(String goodsname,Integer id,Integer typeid);
	
	public boolean dianzan(int id);
	
	public List<Combo> alterComboInventory(Integer goodsid,Integer number);
}
