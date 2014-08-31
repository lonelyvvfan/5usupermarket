package cs.service;

import java.util.List;

import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Secondgoods;
import cs.entity.Takeout;
import cs.vo.PageModel;

public interface TakeoutService {
	public Takeout findtakeoutbyid(Integer id);	
}
