package cs.service;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

import cs.dao.ComboDAO;
import cs.entity.Combo;
import cs.entity.Goods;
import cs.vo.PageModel;

public class ComboServiceImpl implements ComboService {
	
	private ComboDAO comboDAO;
	
	
	public boolean dianzan(int id){
		boolean r = comboDAO.dianzan(id);
		return r;
	}
	
	/**
	 * 找到所有商品
	 * 
	 * @return
	 */
	public List<Combo> queryallcombo(PageModel page) {
		List<Combo> list = new ArrayList<Combo>();
		list = comboDAO.queryallcombo(page);
		return list;
	}
	
	public List<Combo> findcombospecial(String goodsname,Integer id,Integer typeid){
		List<Combo> combolist = new ArrayList<Combo>();
		combolist = comboDAO.findcombospecial(goodsname,id,typeid);
		return combolist;
	}
	
	/**
	 * 根据id找到combo
	 */
	public Combo findcombobyid(Integer id){
		Combo combo = new Combo();
		combo = comboDAO.findcombobyid(id);
		return combo;
	}
	
	public List<Combo> alterComboInventory(Integer goodsid,Integer number){
		System.out.println("2222222222222222222222222");
		List<Combo> list = new ArrayList<Combo>();
		list = comboDAO.alterComboInventory(goodsid, number);
		return list;
	}
	
	/**
	 * 根据typeid找到combo
	 
	public List<Combo> findCombobyid2(int typeid){
		List<Combo> list = new ArrayList<Combo>();
		list = comboDAO.findcombobyid2(typeid);
		return list;
	}
*/
	public ComboDAO getComboDAO() {
		return comboDAO;
	}

	public void setComboDAO(ComboDAO comboDAO) {
		this.comboDAO = comboDAO;
	}

	
	
}
