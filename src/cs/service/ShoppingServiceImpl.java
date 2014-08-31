package cs.service;

import java.util.ArrayList;
import java.util.List;

import cs.dao.ComboDAO;
import cs.dao.GoodsDAO;
import cs.dao.UserDAO;
import cs.entity.Combo;
import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.vo.PageModel;

public class ShoppingServiceImpl implements ShoppingService {
	
	private GoodsDAO goodsDAO;
	private ComboDAO comboDAO;
	private UserDAO userDAO;
	public List<Goods_subtype> showsubtype(){
		List<Goods_subtype> list= new ArrayList<Goods_subtype>();
		list = goodsDAO.showsubtype();
		return list;
	}
	
	public List<Goods_supertype> showsuptype(){
		List<Goods_supertype> list = new ArrayList<Goods_supertype>();
		list = goodsDAO.showsuptype();
		return list;
	}
	
	public boolean dianzan(int id){
		boolean r = goodsDAO.dianzan(id);
		return r;
	}
	
	public boolean isexist(String username){
		boolean r = false;
		if (userDAO.queryuserbyusername(username)==null)
		{
			r = true;
		}
		return r;
	}
	
	/**
	 * 找到所有商品
	 * 
	 * @return
	 */
	public List<Goods> queryallgoods(PageModel page) {
		List<Goods> list = new ArrayList<Goods>();
		list = goodsDAO.queryallgoods(page);
		return list;
	}
	
	public List<Goods> findgoodsspecial(String goodsname,Integer id,Integer typeid){
		List<Goods> goodslist = new ArrayList<Goods>();
		goodslist = goodsDAO.findgoodsspecial(goodsname,id,typeid);
		return goodslist;
	}
	
	/**
	 * 根据id找到goods
	 */
	public Goods findgoodsbyid(Integer id){
		Goods goods = new Goods();
		goods = goodsDAO.findgoodsbyid(id);
		return goods;
	}
	
	/**
	 * 根据id找到combo
	 */
	public Combo findcombobyid(Integer id){
		System.out.println("bbbbbbbbbbbbbbbbbbbb"+id);;
		Combo combo = new Combo();
		combo = comboDAO.findcombobyid(id);
		return combo;
	}
	/**
	 * 根据typeid找到goods
	 */
	public List<Goods> findGoodsbyid2(int typeid){
		List<Goods> list = new ArrayList<Goods>();
		list = goodsDAO.findgoodsbyid2(typeid);
		return list;
	}

	public GoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}
	
	public ComboDAO getComboDAO() {
		return comboDAO;
	}

	public void setComboDAO(ComboDAO comboDAO) {
		this.comboDAO = comboDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
