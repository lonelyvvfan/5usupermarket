package cs.service;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

import cs.dao.GoodsDAO;
import cs.dao.SecgoodsDAO;
import cs.dao.TakeoutDAO;
import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Secondgoods;
import cs.entity.Takeout;
import cs.vo.PageModel;

public class TakeoutServiceImpl implements TakeoutService {
	
	private TakeoutDAO takeoutDAO;
	
	/**
	 * 根据id找到goods
	 */
	public Takeout findtakeoutbyid(Integer id){
		Takeout takeout = new Takeout();
		System.out.print("aaasdasdfdgsfdgsgsd="+id);
		takeout = takeoutDAO.findtakeoutbyid(id);
		return takeout;
	}

	public TakeoutDAO getTakeoutDAO() {
		return takeoutDAO;
	}

	public void setTakeoutDAO(TakeoutDAO takeoutDAO) {
		this.takeoutDAO = takeoutDAO;
	}


	
	
	
}
