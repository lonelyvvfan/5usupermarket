package cs.service;

import java.util.ArrayList;
import java.util.List;

import cs.dao.AdminDAO;
import cs.dao.AjaxDAO;
import cs.entity.Combo;
import cs.entity.Goods;
import cs.entity.Greatseller;
import cs.entity.Keyword;
import cs.entity.Notice;
import cs.entity.Secondgoods;
import cs.entity.Sellertype;
import cs.entity.Takeout;
import cs.vo.PageModel;

public class AjaxServiceImpl implements AjaxService{
	private AjaxDAO ajaxDAO;
	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Goods> findgoodsspecial(String goodsname, Integer suptypeid,
			Integer subtypeid) {
		List<Goods> goodslist = new ArrayList<Goods>();
		goodslist = ajaxDAO.findgoodsspecial(goodsname, suptypeid, subtypeid);
		return goodslist;
	}
	
	/**
	 * 找到全部公告
	 */
	public List<Notice> queryallnotice(){
		List<Notice> list = new ArrayList<Notice>();
		list = ajaxDAO.queryallnotice();
		return list;
	}
	
	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Greatseller> findgreatsellerspecial(String name, Integer suptypeid,
			Integer subtypeid) {
		List<Greatseller> greatsellerlist = new ArrayList<Greatseller>();
		greatsellerlist = ajaxDAO.findgreatsellerspecial(name, suptypeid, subtypeid);
		return greatsellerlist;
	}
	
	/**
	 * 修改keyword内容
	 */
	public List<Keyword> alterkeyword(){
		List<Keyword> list = new ArrayList<Keyword>();
		list = ajaxDAO.alterkeyword();
		return list;
	}
	
	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Takeout> findtakeoutspecial(Integer sellerid, Integer suptypeid,
			Integer subtypeid) {
		List<Takeout> goodslist = new ArrayList<Takeout>();
		goodslist = ajaxDAO.findtakeoutspecial(sellerid, suptypeid, subtypeid);
		return goodslist;
	}
	
	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Sellertype> findsellertypespecial(String name, Integer suptypeid,
			Integer subtypeid) {
		List<Sellertype> sellertypelist = new ArrayList<Sellertype>();
		sellertypelist = ajaxDAO.findsellertypespecial(name, suptypeid, subtypeid);
		return sellertypelist;
	}
	
	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Secondgoods> findsecgoodsspecial(String goodsname, Integer suptypeid,
			Integer subtypeid) {
		List<Secondgoods> secgoodslist = new ArrayList<Secondgoods>();
		secgoodslist = ajaxDAO.findsecgoodsspecial(goodsname, suptypeid, subtypeid);
		return secgoodslist;
	}
	public AjaxDAO getAjaxDAO() {
		return ajaxDAO;
	}
	public void setAjaxDAO(AjaxDAO ajaxDAO) {
		this.ajaxDAO = ajaxDAO;
	}
	
	/**
	 * 找到推荐商品
	 */
	public List<Goods> findrecommend(){
		List<Goods> list=ajaxDAO.findrecommend();
		return list;
	}
	
	/**
	 * 找到健康商品
	 */
	public List<Goods> findhealth(){
		List<Goods> list=ajaxDAO.findhealth();
		return list;
	}
	
	/**
	 * 找到特价商品
	 */
	public List<Goods> findspecial(){
		List<Goods> list=ajaxDAO.findspecial();
		return list;
	}
	
	/**
	 * 找到热卖商品
	 */
	public List<Goods> findhot(){
		List<Goods> list=ajaxDAO.findhot();
		return list;
	}
	
	/**
	 * 找到新商品
	 */
	public List<Goods> findnewgoods(){
		List<Goods> list=ajaxDAO.findnewgoods();
		return list;
	}
	
	/**
	 * 找到套餐商品
	 */
	public List<Combo> findcombo(){
		List<Combo> list=ajaxDAO.findcombo();
		return list;
	}
}

