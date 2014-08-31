package cs.service;

import java.util.List;

import cs.entity.Combo;
import cs.entity.Goods;
import cs.entity.Greatseller;
import cs.entity.Keyword;
import cs.entity.Notice;
import cs.entity.Secondgoods;
import cs.entity.Sellertype;
import cs.entity.Takeout;

public interface AjaxService {
	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Goods> findgoodsspecial(String goodsname, Integer suptypeid,
			Integer subtypeid);
	public List<Notice> queryallnotice();
	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Greatseller> findgreatsellerspecial(String name, Integer suptypeid,
			Integer subtypeid);
	
	/**
	 * 修改keyword内容
	 */
	public List<Keyword> alterkeyword();
	
	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Secondgoods> findsecgoodsspecial(String goodsname, Integer suptypeid,
			Integer subtypeid);
	
	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Takeout> findtakeoutspecial(Integer sellerid, Integer suptypeid,
			Integer subtypeid);
	
	/**
	 * 查找商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Sellertype> findsellertypespecial(String name, Integer suptypeid,
			Integer subtypeid);
	
	/**
	 * 找到推荐商品
	 */
	public List<Goods> findrecommend();
	
	/**
	 * 找到健康商品
	 */
	public List<Goods> findhealth();
	
	/**
	 * 找到特价商品
	 */
	public List<Goods> findspecial();
	
	/**
	 * 找到热卖商品
	 */
	public List<Goods> findhot();
	
	/**
	 * 找到新商品
	 */
	public List<Goods> findnewgoods();
	
	/**
	 * 找到新商品
	 */
	public List<Combo> findcombo();
}
