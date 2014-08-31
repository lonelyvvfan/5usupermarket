package cs.service;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

import cs.dao.GoodsDAO;
import cs.dao.SecgoodsDAO;
import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Secondgoods;
import cs.vo.PageModel;

public class SecgoodsServiceImpl implements SecgoodsService {
	
	private SecgoodsDAO secgoodsDAO;
	
	/**
	 * 根据id找到goods
	 */
	public Secondgoods findsecgoodsbyid(Integer id){
		Secondgoods secgoods = new Secondgoods();
		System.out.print("aaasdasdfdgsfdgsgsd="+id);
		secgoods = secgoodsDAO.findsecgoodsbyid(id);
		return secgoods;
	}

	public SecgoodsDAO getSecgoodsDAO() {
		return secgoodsDAO;
	}

	public void setSecgoodsDAO(SecgoodsDAO secgoodsDAO) {
		this.secgoodsDAO = secgoodsDAO;
	}
	
	
	
}
