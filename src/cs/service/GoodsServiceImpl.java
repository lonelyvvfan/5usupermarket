package cs.service;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

import cs.dao.GoodsDAO;
import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.vo.PageModel;

public class GoodsServiceImpl implements GoodsService {
	
	private GoodsDAO goodsDAO;
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
	 * 根据typeid找到goods
	 */
	public List<Goods> findGoodsbyid2(int typeid){
		List<Goods> list = new ArrayList<Goods>();
		list = goodsDAO.findgoodsbyid2(typeid);
		return list;
	}
	
	public List<Goods> alterInventory(Integer goodsid,Integer number){
		System.out.println("2222222222222222222222222");
		List<Goods> list = new ArrayList<Goods>();
		list = goodsDAO.alterInventory(goodsid, number);
		return list;
	}

	public GoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}
	
}
