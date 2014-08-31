package cs.dao;

import java.util.List;

import cs.entity.Admin;
import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Secondgoods;
import cs.entity.Seller;
import cs.entity.User;
import cs.vo.PageModel;

public interface SecgoodsDAO {



	public Secondgoods findsecgoodsbyid(int id);
	
	
}
