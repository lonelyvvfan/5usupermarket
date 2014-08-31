package cs.dao;

import java.nio.channels.SeekableByteChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import sun.net.www.content.audio.wav;
import cs.entity.Admin;
import cs.entity.Combo;
import cs.entity.Goods;
import cs.entity.Goods_subtype;
import cs.entity.Goods_supertype;
import cs.entity.Greatseller;
import cs.entity.Greatseller_subtype;
import cs.entity.Greatseller_supertype;
import cs.entity.HelpCenter;
import cs.entity.Keyword;
import cs.entity.Notice;
import cs.entity.Order;
import cs.entity.Order_detail;
import cs.entity.Secondgoods;
import cs.entity.Secondgoods_subtype;
import cs.entity.Secondgoods_supertype;
import cs.entity.Seller;
import cs.entity.Sellertype;
import cs.entity.Takeout;
import cs.entity.Takeout_subtype;
import cs.entity.Takeout_supertype;
import cs.entity.User;
import cs.vo.GoodsPage;
import cs.vo.GreatsellerPage;
import cs.vo.PageModel;
import cs.vo.SellerPage;
import cs.vo.UserPage;

public class AdminDAOImpl implements AdminDAO {
	private SessionFactory sessionFactory;

	/*
	 * 具体注视在AdminDAO中(non-Javadoc)
	 * 
	 * @see cs.dao.AdminDAO#queryUserByUsername(java.lang.String)
	 */
	
/*+++++++++++++login开始++++++++++++++*/
	/**
	 * 根据username找到用户
	 */
	public Admin queryuserbyusername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Admin as u where u.username = ?");
		query.setString(0, username);
		Admin u = (Admin) query.uniqueResult();
		return u;
	}
	
	
	
/*+++++++++++++login结束++++++++++++++*/
	
	
/*+++++++++++++add开始++++++++++++++*/
	/**
	 * 增加外卖商家分类
	 */
	public void addsellertype(Integer suptypeid,Integer subtypeid,String name,String savepath,Integer sellerid,String reason){
		Sellertype sellertype=new Sellertype();
		sellertype.setName(name);
		sellertype.setSavepath(savepath);
		sellertype.setSellerid(sellerid);
		sellertype.setSubtypeid(subtypeid);
		sellertype.setSuptypeid(suptypeid);
		sellertype.setReason(reason);
		try {
			Session session = sessionFactory.openSession();
			session.save(sellertype);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 增加用户
	 */
	public List<User> adduser( String username, String password,
			String telephone, String alipaynum, String email, String author,
			String address, String nickname, String qq, String renren,
			String weibo, String sex, String school,String living) {
		List<User> userlist = new ArrayList<User>();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setTelephone(telephone);
		user.setAddress(address);
		user.setAlipaynum(alipaynum);
		user.setAuthor(author);
		user.setEmail(email);
		user.setNickname(nickname);
		user.setQq(qq);
		user.setRenren(renren);
		user.setSex(sex);
		user.setWeibo(weibo);
		user.setSchool(school);
		user.setLiving(living);
		try {
			Session session = sessionFactory.openSession();
			session.save(user);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		UserPage page = new UserPage();
		userlist = queryalluser(page);
		return userlist;
	}
	
	/**
	 * 增加商户
	 */
	public List<Seller> addseller(String username,String password,String name,String telephone,String address,
			String email,String alipaynum,String identification,String savepath,String author,String content, String reason) {
		List<Seller> sellerlist = new ArrayList<Seller>();
		Seller seller = new Seller();
		// user.setId(id);
		seller.setUsername(username);
		seller.setPassword(password);
		seller.setName(name);
		seller.setTelephone(telephone);
		seller.setEmail(email);
		seller.setAlipaynum(alipaynum);
		seller.setIdentification(identification);
		seller.setAddress(address);
		seller.setSavepath(savepath);
		seller.setAuthor(author);
		seller.setContent(content);
		seller.setReason(reason);
		try {
			Session session = sessionFactory.openSession();
			session.save(seller);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		SellerPage page = new SellerPage();
		sellerlist = queryallseller(page);
		return sellerlist;
	}

	/**
	 * 增加帮助信息
	 */
	public List<HelpCenter> addhelp(String title,String content){
		List<HelpCenter> list = new ArrayList<HelpCenter>();
		HelpCenter help  = new HelpCenter();
		help.setContent(content);
		help.setTitle(title);
		try {
			Session session = sessionFactory.openSession();
			session.save(help);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		PageModel page = new PageModel();
		list = queryallhelp(page);
		return list;
		
	}
	
	/**
	 * 增加keyword
	 */
	public List<Keyword> addkeyword(String title){
		List<Keyword> list = new ArrayList<Keyword>();
		Keyword keyword  = new Keyword();
		keyword.setTitle(title);
		try {
			Session session = sessionFactory.openSession();
			session.save(keyword);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		PageModel page = new PageModel();
		list = queryallkeyword(page);
		return list;
	}
	
	/**
	 * 增加公告
	 */
	public List<Notice> addnotice(String title,String content){
		List<Notice> list = new ArrayList<Notice>();
		Notice notice  = new Notice();
		notice.setContent(content);
		notice.setTitle(title);
		try {
			Session session = sessionFactory.openSession();
			session.save(notice);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		PageModel page = new PageModel();
		list = queryallnotice(page);
		return list;
		
	}
	
	/**
	 * 增加商品
	 */
	public List<Goods> addgoods(Integer suptypeid,Integer subtypeid,Integer indexx,String goodsname,String introduce,double price,double nowprice,
			String savepath,String savepath1, String savepath2,String savepath3,
			Integer newgoods,Integer hot,Integer special,Integer health,Integer recommend, String shelves ,Integer monthsell , Integer zan , String reason, Integer inventory) {
		List<Goods> goodslist = new ArrayList<Goods>();
		System.out.println("adminDAO indexx"+indexx);
		Goods goods = new Goods();
		goods.setSubtypeid(subtypeid);
		goods.setSuptypeid(suptypeid);
		goods.setIndexx(indexx);
		goods.setGoodsname(goodsname);
		goods.setIntroduce(introduce);
		goods.setPrice(price);
		goods.setNowprice(nowprice);
		goods.setSavepath(savepath);
		goods.setSavepath1(savepath1);
		goods.setSavepath2(savepath2);
		goods.setSavepath3(savepath3);
		goods.setNewgoods(newgoods);
		goods.setHot(hot);
		goods.setSpecial(special);
		goods.setHealth(health);
		goods.setRecommend(recommend);
		goods.setShelves(shelves);
		goods.setMonthsell(monthsell);
		goods.setZan(zan);
		goods.setReason(reason);
		goods.setInventory(inventory);
		try {
			Session session = sessionFactory.openSession();
			session.save(goods);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		GoodsPage page = new GoodsPage();
		goodslist = queryallgoods(page);
		return goodslist;
	}
	
	/**
	 * 增加套餐
	 */
	public List<Combo> addcombo(String goodsname, String introduce,double price,double nowprice,String savepath,
			String savepath1, String savepath2,String savepath3, String shelves,Integer monthsell , Integer zan , String reason, Integer inventory){
		List<Combo> combolist = new ArrayList<Combo>();
		Combo combo = new Combo();
		combo.setGoodsname(goodsname);
		combo.setIntroduce(introduce);
		combo.setNowprice(nowprice);
		combo.setPrice(price);
		combo.setSavepath(savepath);
		combo.setSavepath1(savepath1);
		combo.setSavepath2(savepath2);
		combo.setSavepath3(savepath3);
		combo.setShelves(shelves);
		combo.setMonthsell(monthsell);
		combo.setZan(zan);
		combo.setReason(reason);
		combo.setInventory(inventory);
		try{
			Session session = sessionFactory.openSession();
			session.save(combo);
			session.beginTransaction().commit();
		}catch (HibernateException e){
			e.printStackTrace();
		}
		PageModel page = new PageModel();
		combolist = queryallcombo(page);
		return combolist;
	
	}
	
	/**
	 * 增加二手商品
	 */
	public List<Secondgoods> addsecgoods(Integer userid,String username,String nickname,Integer suptypeid, Integer subtypeid,
			String goodsname, String introduce, double price, double nowprice,
			String savepath,String savepath1, String savepath2,String savepath3, Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend, String shelves, String qq , String telephone ,  String other, String reason, Integer recency, String school,String living){
		List<Secondgoods> list = new ArrayList<Secondgoods>();
		Secondgoods secgoods = new Secondgoods();
		secgoods.setUserid(userid);
		secgoods.setUsername(username);
		secgoods.setNickname(nickname);
		secgoods.setSubtypeid(subtypeid);
		secgoods.setSuptypeid(suptypeid);
		secgoods.setGoodsname(goodsname);
		secgoods.setIntroduce(introduce);
		secgoods.setPrice(price);
		secgoods.setNowprice(nowprice);
		secgoods.setSavepath(savepath);
		secgoods.setSavepath1(savepath1);
		secgoods.setSavepath2(savepath2);
		secgoods.setSavepath3(savepath3);
		secgoods.setNewgoods(newgoods);
		secgoods.setHot(hot);
		secgoods.setSpecial(special);
		secgoods.setHealth(health);
		secgoods.setRecommend(recommend);
		secgoods.setShelves(shelves);
		secgoods.setQq(qq);
		secgoods.setTelephone(telephone);
		secgoods.setOther(other);
		secgoods.setReason(reason);
		secgoods.setRecency(recency);
		secgoods.setSchool(school);
		secgoods.setLiving(living);
		try {
			Session session = sessionFactory.openSession();
			session.save(secgoods);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		PageModel page = new PageModel();
		list = queryallsecgoods(page);
		return list;
	}

	/**
	 * 增加外卖
	 */
	public List<Takeout> addtakeout(Integer sellerid,String sellername,Integer suptypeid, Integer subtypeid,
			String goodsname, String introduce, double price, double nowprice,
			String savepath,String savepath1, String savepath2,String savepath3, Integer newgoods, Integer hot, Integer special,
			Integer health, Integer recommend, String shelves, String reason){
				List<Takeout> list = new ArrayList<Takeout>();
				Takeout takeout = new Takeout();
				takeout.setSellerid(sellerid);
				takeout.setSellername(sellername);
				takeout.setSubtypeid(subtypeid);
				takeout.setSuptypeid(suptypeid);
				takeout.setGoodsname(goodsname);
				takeout.setIntroduce(introduce);
				takeout.setPrice(price);
				takeout.setNowprice(nowprice);
				takeout.setSavepath(savepath);
				takeout.setSavepath1(savepath1);
				takeout.setSavepath2(savepath2);
				takeout.setSavepath3(savepath3);
				takeout.setNewgoods(newgoods);
				takeout.setHot(hot);
				takeout.setSpecial(special);
				takeout.setHealth(health);
				takeout.setRecommend(recommend);
				takeout.setShelves(shelves);
				takeout.setReason(reason);
				try {
					Session session = sessionFactory.openSession();
					session.save(takeout);
					session.beginTransaction().commit();
				} catch (HibernateException e) {
					e.printStackTrace();
				}
				PageModel page = new PageModel();
				list = queryalltakeout(page);
				return list;
			}
	
	/**
	 * 增加推荐商家
	 */
	public List<Greatseller> addgreatseller(Integer suptypeid,Integer subtypeid,String name,String content,String telephone,
			String savepath,String savepath1, String savepath2,String savepath3,String address,String url, String shelves) {
		List<Greatseller> greatsellerlist = new ArrayList<Greatseller>();
		Greatseller greatseller = new Greatseller();
		greatseller.setSubtypeid(subtypeid);
		greatseller.setSuptypeid(suptypeid);
		greatseller.setName(name);
		greatseller.setContent(content);
		greatseller.setTelephone(telephone);
		greatseller.setSavepath(savepath);
		greatseller.setSavepath1(savepath1);
		greatseller.setSavepath2(savepath2);
		greatseller.setSavepath3(savepath3);
		greatseller.setAddress(address);
		greatseller.setUrl(url);
		greatseller.setShelves(shelves);
		try {
			Session session = sessionFactory.openSession();
			session.save(greatseller);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		GreatsellerPage page = new GreatsellerPage();
		greatsellerlist = queryallgreatseller(page);
		return greatsellerlist;
	}
	
	/**
	 * 增加订单
	 */
	public Order addorder(String arrivedday, String arrivedtime,
			double totalamount, String username, String truename,
			String telephone, String school, String doorplate, String room,
			String remark, String payway, int isclosed){
		SimpleDateFormat df = new SimpleDateFormat("MMddmmss");//设置日期格式
		Order  order = new Order();
		String ram = "" +(int)Math.random()*100;
		order.setOrderNo(Integer.parseInt(df.format(new Date()) + ram));
		int n=order.getOrderNo();
		order.setArrivedday(arrivedday);
		order.setArrivedtime(arrivedtime);
		order.setDoorplate(doorplate);
		order.setIsclosed(isclosed);
		order.setPayway(payway);
		order.setRemark(remark);
		order.setRoom(room);
		order.setSchool(school);
		order.setTelephone(telephone);
		order.setTotalamount(totalamount);
		order.setTruename(truename);
		order.setUsername(username);
		try {
			Session session = sessionFactory.openSession();
			session.save(order);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		order=findorderbyorderno(n);
		return order;
	}
	
	/**
	 * 增加订单
	 */
	public List<Order> addorder1(String arrivedday, String arrivedtime,
			double totalamount, String username, String truename,
			String telephone, String school, String doorplate, String room,
			String remark, String payway, int isclosed){
		SimpleDateFormat df = new SimpleDateFormat("MMddmmss");//设置日期格式
		Order  order = new Order();
		String ram = "" +(int)Math.random()*100;
		order.setOrderNo(Integer.parseInt(df.format(new Date()) + ram));
		order.setArrivedday(arrivedday);
		order.setArrivedtime(arrivedtime);
		order.setDoorplate(doorplate);
		order.setIsclosed(isclosed);
		order.setPayway(payway);
		order.setRemark(remark);
		order.setRoom(room);
		order.setSchool(school);
		order.setTelephone(telephone);
		order.setTotalamount(totalamount);
		order.setTruename(truename);
		order.setUsername(username);
		try {
			Session session = sessionFactory.openSession();
			session.save(order);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		PageModel page = new PageModel();
		List<Order> list = new ArrayList<Order>();
		list = queryallorder(page);
		return list;
	}
	
	/**
	 * 增加订单详情
	 */
	public List<Order> addorderdetail(List<Order_detail> list,Integer id){
		for (int i=0;i<list.size();i++){
		Order_detail order_detail=list.get(i);
		order_detail.setOrderid(id);
		try {
			Session session = sessionFactory.openSession();
			session.save(order_detail);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		}
		PageModel page = new PageModel();
		List<Order> orderlist = new ArrayList<Order>();
		orderlist = queryallorder(page);
		return orderlist;
	}
	
/*+++++++++++++add结束++++++++++++++*/
	
	
	
/*+++++++++++++delete开始++++++++++++++*/
	
	/**
	 * 根据sellerid删除sellertyoe
	 */
	public boolean deletesellertype(Integer id){
		List<Sellertype> sellertype=findsellertypebyid(id);
		Session session = null;
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		for (int i=0;i<sellertype.size();i++)
		try {
			System.out.println("dfsdfsdsdfdasdasdsfdsgfdsdasfsadfasd"+i);
			session = sessionFactory.openSession();	
			session.delete(sellertype.get(i));
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 根据id删除用户
	 */
	public boolean deleteuserbyid(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.delete(finduserbyid(id));
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}

	/**
	 * 根据id删除商家
	 */
	public boolean deletesellerbyid(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.delete(findsellerbyid(id));
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}

	/**
	 * 根据id删除帮助信息
	 */
	public boolean deletehelpbyid(int id){
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.delete(findhelpbyid(id));
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 根据id删除帮助信息
	 */
	public boolean deletekeywordbyid(int id){
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.delete(findkeywordbyid(id));
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 根据id删除公告
	 */
	public boolean deletenoticebyid(int id){
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.delete(findnoticebyid(id));
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	/**
	 * 根据id删除商品
	 */
	public boolean deletegoodsbyid(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.delete(findgoodsbyid(id));
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 根据id删除套餐
	 */
	public boolean deletecombobyid(int id){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.delete(findcombobyid(id));
			session.beginTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 根据id删除二手商品
	 */
	public boolean deletesecgoodsbyid(int id){
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.delete(findsecgoodsbyid(id));
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 根据id删除外卖
	 */
	public boolean deletetakeoutbyid(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.delete(findtakeoutbyid(id));
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}

	
	/**
	 * 根据id删除推荐商家
	 */
	public boolean deletegreatsellerbyid(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.delete(findgreatsellerbyid(id));
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 根据id删除订单
	 */
	public boolean deleteorderbyid(int id){
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Order order = findorderbyid(id);
			deleteorderdetailbyid(order.getId());
			session.delete(findorderbyid(id));
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 根据id删除订单详情
	 */
	public boolean deleteorderdetailbyid(int id){
		Session session = null;
		try {
			session = sessionFactory.openSession();
			List<Order_detail> list=findorderdetailbyid(id);	
			for (int i=0;i<list.size();i++)
			{
				session.delete(list.get(i));
			}
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 批量删除user
	 */
	public boolean deletecheckbox(int[] arrid){
		Session session = null;
		try {
			for (int i=0;i<arrid.length;i++)
			{
				session = sessionFactory.openSession();
				User user = finduserbyid(arrid[i]);
				session.delete(user);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	/**
	 * 批量删除seller
	 */
	public boolean deletecheckboxseller(int[] arrid){
		Session session = null;
		try {
			for (int i=0;i<arrid.length;i++)
			{
				session = sessionFactory.openSession();
				Seller seller = findsellerbyid(arrid[i]);
				session.delete(seller);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	/**
	 * 批量删除combo
	 */
	public boolean deletecheckboxcombo(int[] arrid){
		Session session = null;
		try {
			for (int i=0;i<arrid.length;i++)
			{
				session = sessionFactory.openSession();
				Combo combo = findcombobyid(arrid[i]);
				session.delete(combo);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
		
	}
	
	
	/**
	 * 批量删除greatseller
	 */
	public boolean deletecheckboxgreatseller(int[] arrid){
		Session session = null;
		try {
			for (int i=0;i<arrid.length;i++)
			{
				session = sessionFactory.openSession();
				Greatseller greatseller = findgreatsellerbyid(arrid[i]);
				session.delete(greatseller);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
		
	}
	
	/**
	 * 批量删除notice
	 */
	public boolean deletecheckboxnotice(int[] arrid){
		Session session = null;
		try {
			for (int i=0;i<arrid.length;i++)
			{
				session = sessionFactory.openSession();
				Notice notice = findnoticebyid(arrid[i]);
				session.delete(notice);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
		
	}
	
	/**
	 * 批量删除order
	 */
	public boolean deletecheckboxorder(int[] arrid){
		Session session = null;
		try {
			for (int i=0;i<arrid.length;i++)
			{
				session = sessionFactory.openSession();
				Order order = findorderbyid(arrid[i]);
				session.delete(order);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
		
	}
	
	/**
	 * 批量删除secgoods
	 */
	public boolean deletecheckboxsecgoods(int[] arrid){
		Session session = null;
		try {
			for (int i=0;i<arrid.length;i++)
			{
				session = sessionFactory.openSession();
				Secondgoods secondgoods = findsecgoodsbyid(arrid[i]);
				session.delete(secondgoods);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
		
	}
	
	/**
	 * 批量删除goods
	 */
	public boolean deletecheckboxgoods(int[] arrid){
		Session session = null;
		try {
			for (int i=0;i<arrid.length;i++)
			{
				session = sessionFactory.openSession();
				Goods goods = findgoodsbyid(arrid[i]);
				session.delete(goods);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
		
	}
	
	/**
	 * 批量删除takeout
	 */
	public boolean deletecheckboxtakeout(int[] arrid){
		Session session = null;
		try {
			for (int i=0;i<arrid.length;i++)
			{
				session = sessionFactory.openSession();
				Takeout takeout = findtakeoutbyid(arrid[i]);
				session.delete(takeout);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
		
	}
	
	
/*+++++++++++++delete结束++++++++++++++*/
	
	
	
/*+++++++++++++queryall开始++++++++++++++*/

	/**
	 * 找到全部普通用户
	 */
	public List<User> queryalluser(PageModel page) {
		List<User> userlist = new ArrayList<User>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				User.class);
		userlist = c.list();
		return userlist;
	}
	
	/**
	 * 找到全部商户
	 */
	public List<Seller> queryallseller(PageModel page) {
		List<Seller> sellerlist = new ArrayList<Seller>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Seller.class);
		sellerlist = c.list();
		return sellerlist;
	}

	/**
	 * 找到全部帮助信息
	 */
	public List<HelpCenter> queryallhelp(PageModel page){
		List<HelpCenter> list = new ArrayList<HelpCenter>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				HelpCenter.class);
		list = c.list();
		return list;
	}
	
	/**
	 * 找到全部帮助信息
	 */
	public List<Keyword> queryallkeyword(PageModel page){
		List<Keyword> list = new ArrayList<Keyword>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Keyword.class);
		list = c.list();
		return list;
	}
	
	/**
	 * 找到全部公告
	 */
	public List<Notice> queryallnotice(PageModel page){
		List<Notice> list = new ArrayList<Notice>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Notice.class);
		list = c.list();
		return list;
	}
	
	
	/**
	 * 找到全部商品
	 */
	public List<Goods> queryallgoods(PageModel page) {
		List<Goods> goodslist = new ArrayList<Goods>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Goods.class);
		c.addOrder(Property.forName("indexx").asc());
		c.addOrder(Property.forName("id").desc());
		goodslist = c.list();
		return goodslist;
	}
	
	/**
	 * 找到全部商品
	 */
	public List<Combo> queryallcombo(PageModel page){
		List<Combo> combolist = new ArrayList<Combo>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Combo.class);
		combolist = c.list();
		return combolist;
	}

	
	/**
	 * 找到全部二手商品
	 */
	public List<Secondgoods> queryallsecgoods(PageModel page){
		List<Secondgoods> list = new ArrayList<Secondgoods>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Secondgoods.class);
		list = c.list();
		return list;
	}
	
	/**
	 * 找到全部外卖
	 */
	public List<Takeout> queryalltakeout(PageModel page){
		List<Takeout> list = new ArrayList<Takeout>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Takeout.class);
		list = c.list();
		return list;
	}

	/**
	 * 找到全部推荐商家
	 */
	public List<Greatseller> queryallgreatseller(PageModel page) {
		List<Greatseller> greatsellerlist = new ArrayList<Greatseller>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Greatseller.class);
		greatsellerlist = c.list();
		return greatsellerlist;
	}
	
	/**
	 * 找到全部订单
	 */
	public List<Order> queryallorder(PageModel page){
		System.out.print("daoorder");
		List<Order> list  = new ArrayList<Order>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Order.class);
		c.addOrder(Property.forName("id").desc());
		list = c.list();
		return list;
	}

/*+++++++++++++queryall结束++++++++++++++*/
	
	
	
	
/*+++++++++++++find开始++++++++++++++*/
	
	
	/**
	 * 根据id找到用户 并且返回一个user对象
	 */
	public User finduserbyid(int id) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.openSession().createCriteria(
				User.class);
		criteria.add(Restrictions.eq("id", id));
		User user = (User) criteria.uniqueResult();
		return user;
	}
	
	/**
	 * 根据id找到用户 并且返回一个user对象
	 */
	public Seller findsellerbyid(int id) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Seller.class);
		criteria.add(Restrictions.eq("id", id));
		Seller seller = (Seller) criteria.uniqueResult();
		return seller;
	}
	
	/**
	 * 根据id找到用户 并且返回一个user对象
	 */
	public Seller findsellerbyname(String name) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Seller.class);
		criteria.add(Restrictions.eq("name", name));
		Seller seller = (Seller) criteria.uniqueResult();
		return seller;
	}
	
	/**
	 * 根据id找到help 并且返回一个helpcenter对象
	 */
	public HelpCenter findhelpbyid(int id){
		Criteria criteria = sessionFactory.openSession().createCriteria(
				HelpCenter.class);
		criteria.add(Restrictions.eq("id", id));
		HelpCenter help = (HelpCenter) criteria.uniqueResult();
		return help;
	}
	
	/**
	 * 根据id找到help 并且返回一个helpcenter对象
	 */
	public Keyword findkeywordbyid(Integer id){
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Keyword.class);
		criteria.add(Restrictions.eq("id", id));
		Keyword keyword = (Keyword) criteria.uniqueResult();
		return keyword;
	}
	
	/**
	 * 根据id找到notice信息，并返回一个notice对象
	 */
	public Notice findnoticebyid(int id){
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Notice.class);
		criteria.add(Restrictions.eq("id", id));
		Notice notice = (Notice) criteria.uniqueResult();
		return notice;
	}
	
	/**
	 * 根据id找到商品 并且返回一个goods对象
	 */
	public Goods findgoodsbyid(int id) {
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Goods.class);
		criteria.add(Restrictions.eq("id", id));
		Goods goods = (Goods) criteria.uniqueResult();
		return goods;
	}
	
	/**
	 * 根据id找到套餐 并且返回一个combo对象
	 */
	public Combo findcombobyid(int id){
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Combo.class);
		criteria.add(Restrictions.eq("id", id));
		Combo combo = (Combo) criteria.uniqueResult();
		return combo;
	}
	
	/**
	 * 根据id找到套餐 并且返回一个combo对象
	 */
	public List<Sellertype> findsellertypebyid(int id){
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Sellertype.class);
		criteria.add(Restrictions.eq("sellerid", id));
		List<Sellertype> sellertype = (List<Sellertype>) criteria.list();
		System.out.print("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"+sellertype.size());
		return sellertype;
	}
	
	/**
	 * 根据id找到二手商品 并且返回一个secondgoods对象
	 */
	public Secondgoods findsecgoodsbyid(int id){
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Secondgoods.class);
		criteria.add(Restrictions.eq("id", id));
		Secondgoods secgoods = (Secondgoods) criteria.uniqueResult();
		return secgoods;
	}
	
	/**
	 * 根据id找到外卖 并且返回一个takeout对象
	 */
	public Takeout findtakeoutbyid(int id){
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Takeout.class);
		criteria.add(Restrictions.eq("id", id));
		Takeout takeout = (Takeout) criteria.uniqueResult();
		return takeout;
	}
	
	/**
	 * 根据id找到推荐商家 并且返回一个greatseller对象
	 */
	public Greatseller findgreatsellerbyid(Integer id) {
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Greatseller.class);
		criteria.add(Restrictions.eq("id", id));
		Greatseller greatseller = (Greatseller) criteria.uniqueResult();
		return greatseller;
	}
	
	/**
	 * 根据orderno找到商品 并且返回一个order对象
	 */
	public Order findorderbyorderno(Integer orderNo) {
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Order.class);
		criteria.add(Restrictions.eq("orderNo", orderNo));
		Order order = (Order) criteria.uniqueResult();
		return order;
	}
	
	/**
	 * 根据id找到订单 并且返回一个order对象
	 */
	public Order findorderbyid(int id){
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Order.class);
		criteria.add(Restrictions.eq("id", id));
		Order order = (Order) criteria.uniqueResult();
		return order;
	}
	
	/**
	 * 根据id找到订单详情 并且返回一个orderdetail对象
	*/
	public Order_detail findorderdetailbyid1(int id){
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Order_detail.class);
		criteria.add(Restrictions.eq("orderid", id));
		Order_detail order_detail = (Order_detail) criteria.uniqueResult();
		return order_detail;
	} 
	
	
	/**
	 * 查找用户返回list
	 * 
	 * @param username
	 * @return
	 */
	public List<User> finduserspecial(String username) {
		System.out.println("daofindstart");
		List<User> userlist = new ArrayList<User>();
		String sring = username ;
		Criteria criteria = sessionFactory.openSession().createCriteria(
				User.class);
		criteria.add(Restrictions.ilike("username", sring));
		userlist = criteria.list();
		System.out.println("daofindlist");
		System.out.println(userlist);
		return userlist;
	}
	
	/**
	 * 查找商家返回list
	 * 
	 * @param username
	 * @return
	 */
	public List<Seller> findsellerspecial(String username) {
		System.out.println("daofindstart");
		List<Seller> sellerlist = new ArrayList<Seller>();
		String sring = "%" + username + "%";
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Seller.class);
		criteria.add(Restrictions.ilike("username", sring));
		sellerlist = criteria.list();
		System.out.println("daofindlist");
		System.out.println(sellerlist);
		return sellerlist;
	}

	/**
	 * 查找帮助信息返回list
	 */
	public List<HelpCenter> findhelpspecial(String title){
		List<HelpCenter> list = new ArrayList<HelpCenter>();
		String sring = "%" + title + "%";
		Criteria criteria = sessionFactory.openSession().createCriteria(HelpCenter.class);
		criteria.add(Restrictions.ilike("title", sring));
		list = criteria.list();
		return list;
		
	}
	
	/**
	 * 查找公告返回list
	 */
	public List<Notice> findnoticespecial(String title){
		List<Notice> list = new ArrayList<Notice>();
		String sring = "%" + title + "%";
		Criteria criteria = sessionFactory.openSession().createCriteria(Notice.class);
		criteria.add(Restrictions.ilike("title", sring));
		list = criteria.list();
		return list;
		
	}
	
	/**
	 * 查找商品返回list
	 * @param goodsname,suptypeid,subtypeid
	 * @return
	 */
	public List<Goods> findgoodsspecial(String goodsname,Integer suptypeid,Integer subtypeid){
		List<Goods> goodslist = new ArrayList<Goods>();
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Goods.class);
		if (goodsname!=null)
		{
			String sring = "%" + goodsname + "%";
			criteria.add(Restrictions.ilike("goodsname", sring));
		}
		if (suptypeid!=1)
		{
		Integer sring1 =suptypeid;
		criteria.add(Restrictions.eq("suptypeid", sring1));	
		}
		if (subtypeid!=1)
		{
		Integer sring2 = subtypeid ;
		criteria.add(Restrictions.eq("subtypeid", sring2));
		}
		goodslist = criteria.list();
		return goodslist;
	}
	
	/**
	 * 查找套餐返回list
	 * @param goodsname
	 * @return
	 */
	public List<Combo> findcombospecial(String goodsname){
		List<Combo> combolist = new ArrayList<Combo>();
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Combo.class);
		if(goodsname != null){
			String sring = "%" + goodsname + "%";
			criteria.add(Restrictions.ilike("goodsname", sring));
		}
		combolist = criteria.list();
		return combolist;
	}
	
	/**
	 * 查找二手商品返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Secondgoods> findsecgoodsspecial(String goodsname, Integer suptypeid,
			Integer subtypeid){
		List<Secondgoods> list = new ArrayList<Secondgoods>();
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Secondgoods.class);
		if (goodsname!=null)
		{
			String sring = "%" + goodsname + "%";
			criteria.add(Restrictions.ilike("goodsname", sring));
		}
		if (suptypeid!=1)
		{
		Integer sring1 =suptypeid;
		criteria.add(Restrictions.eq("suptypeid", sring1));	
		}
		if (subtypeid!=1)
		{
		Integer sring2 = subtypeid ;
		criteria.add(Restrictions.eq("subtypeid", sring2));
		}
		list = criteria.list();
		return list;
	}
	
	/**
	 * 查找外卖返回list
	 * 
	 * @param goodsname
	 *            ,suptypeid,subtypeid
	 * @return
	 */
	public List<Takeout> findtakeoutspecial(String goodsname, Integer suptypeid,
			Integer subtypeid){
		List<Takeout> list = new ArrayList<Takeout>();
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Takeout.class);
		if (goodsname!=null)
		{
			String sring = "%" + goodsname + "%";
			criteria.add(Restrictions.ilike("goodsname", sring));
		}
		if (suptypeid!=1)
		{
		Integer sring1 =suptypeid;
		criteria.add(Restrictions.eq("suptypeid", sring1));	
		}
		if (subtypeid!=1)
		{
		Integer sring2 = subtypeid ;
		criteria.add(Restrictions.eq("subtypeid", sring2));
		}
		list = criteria.list();
		return list;
	}
	
	/**
	 * 查找推荐商家返回list
	 * @param goodsname,suptypeid,subtypeid
	 * @return
	 */
	public List<Greatseller> findgreatsellerspecial(String name,Integer suptypeid,Integer subtypeid){
		List<Greatseller> greatsellerlist = new ArrayList<Greatseller>();
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Greatseller.class);
		if (name!=null)
		{
			String sring = "%" + name + "%";
			criteria.add(Restrictions.ilike("name", sring));
		}
		if (suptypeid!=1)
		{
		Integer sring1 =suptypeid;
		criteria.add(Restrictions.eq("suptypeid", sring1));	
		}
		if (subtypeid!=1)
		{
		Integer sring2 = subtypeid ;
		criteria.add(Restrictions.eq("subtypeid", sring2));
		}
		greatsellerlist = criteria.list();
		return greatsellerlist;
	}
	
	
	/**
	 *查找订单返回list 
	 * @param username
	 * @param isclosed
	 * @return
	 */	
	public List<Order> findorderspecial(String username,Integer isclosed){
		List<Order> orderlist = new ArrayList<Order>();
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Order.class);
		if (username!=null)
		{
			String sring = "%" + username + "%";
			criteria.add(Restrictions.ilike("username", sring));
		}
		if (isclosed!=2)
		{
		Integer sring1 =isclosed;
		criteria.add(Restrictions.eq("isclosed", sring1));	
		}
		orderlist = criteria.list();
		return orderlist;
	}
	
	/**
	 * 根据订单id找到订单下的商品 并且返回一个order_detail对象list
	 */
	public List<Order_detail> findorderdetailbyid(Integer id){
		List<Order_detail> ordertaillist = new ArrayList<Order_detail>();
		Criteria criteria = sessionFactory.openSession().createCriteria(
				Order_detail.class);
		criteria.add(Restrictions.eq("orderid", id));
		ordertaillist = criteria.list();
		return ordertaillist;
	}


/*+++++++++++++find结束++++++++++++++*/
	
	
	
/*+++++++++++++alter开始++++++++++++++*/
	
	/**
	 * 修改用户
	 */
	public List<User> alteruser(Integer id, String username, String password,
			String telephone, String alipaynum, String email, String author,
			String address, String nickname, String qq, String renren,
			String weibo, String sex, String school,String living) {
		List<User> userlist = new ArrayList<User>();
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setTelephone(telephone);
		user.setAddress(address);
		user.setAlipaynum(alipaynum);
		user.setAuthor(author);
		user.setEmail(email);
		user.setNickname(nickname);
		user.setQq(qq);
		user.setRenren(renren);
		user.setSex(sex);
		user.setWeibo(weibo);
		user.setSchool(school);
		user.setLiving(living);
		try {
			Session session = sessionFactory.openSession();
			session.update(user);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserPage page = new UserPage();
		userlist = queryalluser(page);
		return userlist;
	}

	/**
	 * 修改商家
	 */
	public List<Seller> alterseller(Integer id, String username,
			String password, String name, String telephone, String email,
			String alipaynum, String identification, String address,
			String savepath, String author, String content, String reason) {
		List<Seller> sellerlist = new ArrayList<Seller>();
		Seller seller = new Seller();
		seller.setId(id);
		seller.setUsername(username);
		seller.setPassword(password);
		seller.setName(name);
		seller.setTelephone(telephone);
		seller.setEmail(email);
		seller.setAlipaynum(alipaynum);
		seller.setIdentification(identification);
		seller.setAddress(address);
		seller.setSavepath(savepath);
		seller.setAuthor(author);
		seller.setContent(content);
		seller.setReason(reason);
		try {
			Session session = sessionFactory.openSession();
			session.update(seller);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SellerPage page = new SellerPage();
		sellerlist = queryallseller(page);
		return sellerlist;
	}
	
	/**
	 * 修改帮助中心内容
	 */
	public List<HelpCenter> alterhelp(int id,String title,String content){
		List<HelpCenter> list = new ArrayList<HelpCenter>();
		HelpCenter help = new HelpCenter();
		help.setContent(content);
		help.setId(id);
		help.setTitle(title);
		try {
			Session session = sessionFactory.openSession();
			session.update(help);
			System.out.println("Session Success?");
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageModel page = new PageModel();
		list = queryallhelp(page);
		return list;
		}
	
	/**
	 * 修改keyword内容
	 */
	public List<Keyword> alterkeyword(int id,String title){
		List<Keyword> list = new ArrayList<Keyword>();
		Keyword keyword = new Keyword();
		keyword.setId(id);
		keyword.setTitle(title);
		try {
			Session session = sessionFactory.openSession();
			session.update(keyword);
			System.out.println("Session Success?");
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageModel page = new PageModel();
		list = queryallkeyword(page);
		return list;
	}
	
	
	
	/**
	 * 修改notice内容
	 */
	public List<Notice> alternotice(int id,String title,String content){
		List<Notice> list = new ArrayList<Notice>();
		Notice notice = new Notice();
		notice.setContent(content);
		notice.setId(id);
		notice.setTitle(title);
		try {
			Session session = sessionFactory.openSession();
			session.update(notice);
			System.out.println("Session Success?");
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageModel page = new PageModel();
		list = queryallnotice(page);
		return list;
		}
	
	/**
	 *修改商品信息
	 */
	public List<Goods> altergoods(Integer id,Integer suptypeid, Integer subtypeid,Integer indexx, String goodsname,
			String introduce, double price, double nowprice, String savepath,String savepath1,String savepath2,String savepath3,
			Integer newgoods, Integer hot, Integer special, Integer health,
			Integer recommend , String shelves ,Integer monthsell , Integer zan, String reason, Integer inventory) {
		List<Goods> goodslist = new ArrayList<Goods>();
		System.out.println("adminDAO indexx"+indexx);
		Goods goods = new Goods();
		goods.setId(id);
		goods.setIndexx(indexx);
		goods.setGoodsname(goodsname);
		goods.setHealth(health);
		goods.setHot(hot);
		goods.setIntroduce(introduce);
		goods.setNewgoods(newgoods);
		goods.setNowprice(nowprice);
		goods.setPrice(price);
		goods.setRecommend(recommend);
		goods.setSavepath(savepath);
		goods.setSavepath1(savepath1);
		goods.setSavepath2(savepath2);
		goods.setSavepath3(savepath3);
		goods.setSpecial(special);
		goods.setSubtypeid(subtypeid);
		goods.setSuptypeid(suptypeid);
		goods.setShelves(shelves);
		goods.setZan(zan);
		goods.setMonthsell(monthsell);
		goods.setReason(reason);
		goods.setInventory(inventory);
		try {
			Session session = sessionFactory.openSession();
			session.update(goods);
			System.out.println("Session Success?");
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsPage page = new GoodsPage();
		goodslist = queryallgoods(page);
		return goodslist;
	}

	/**
	 * 修改套餐信息
	 */
	public List<Combo> altercombo(Integer id,String goodsname, String introduce,double price, double nowprice, String savepath,
			String savepath1,String savepath2,String savepath3, String shelves ,Integer monthsell , Integer zan , String reason, Integer inventory){
				List<Combo> combolist = new ArrayList<Combo>();
				Combo combo = new Combo();
				combo.setId(id);
				combo.setGoodsname(goodsname);
				combo.setIntroduce(introduce);
				combo.setNowprice(nowprice);
				combo.setPrice(price);
				combo.setSavepath(savepath);
				combo.setSavepath1(savepath1);
				combo.setSavepath2(savepath2);
				combo.setSavepath3(savepath3);
				combo.setShelves(shelves);
				combo.setMonthsell(monthsell);
				combo.setZan(zan);
				combo.setReason(reason);
				combo.setInventory(inventory);
				try {
					Session session = sessionFactory.openSession();
					session.update(combo);
					System.out.println("Session Success?");
					session.beginTransaction().commit();
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				GoodsPage page = new GoodsPage();
				combolist = queryallcombo(page);
				return combolist;
			}

	
	/**
	 * 修改二手商品信息
	 */
	 public List<Secondgoods> altersecgoods(Integer id,Integer userid,String username,String nickname,  Integer suptypeid,
				Integer subtypeid, String goodsname, String introduce,
				double price, double nowprice, String savepath,String savepath1, String savepath2,String savepath3, Integer newgoods,
				Integer hot, Integer special, Integer health, Integer recommend, String shelves, String qq , String telephone ,  
				String other, String reason, Integer recency, String school,String living){
		 List<Secondgoods> list = new ArrayList<Secondgoods>();
		 	Secondgoods secgoods = new Secondgoods();
		 	secgoods.setId(id);
		 	secgoods.setUserid(userid);
		 	secgoods.setUsername(username);
		 	secgoods.setNickname(nickname);
			secgoods.setGoodsname(goodsname);
			secgoods.setHealth(health);
			secgoods.setHot(hot);
			secgoods.setIntroduce(introduce);
			secgoods.setNewgoods(newgoods);
			secgoods.setNowprice(nowprice);
			secgoods.setPrice(price);
			secgoods.setRecommend(recommend);
			secgoods.setSavepath(savepath);
			secgoods.setSavepath1(savepath1);
			secgoods.setSavepath2(savepath2);
			secgoods.setSavepath3(savepath3);
			secgoods.setShelves(shelves);
			secgoods.setQq(qq);
			secgoods.setTelephone(telephone);
			secgoods.setOther(other);
			secgoods.setSpecial(special);
			secgoods.setSubtypeid(subtypeid);
			secgoods.setSuptypeid(suptypeid);
			secgoods.setReason(reason);
			secgoods.setRecency(recency);
			secgoods.setSchool(school);
			secgoods.setLiving(living);
			try {
				Session session = sessionFactory.openSession();
				session.update(secgoods);
				System.out.println("Session Success?");
				session.beginTransaction().commit();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PageModel page = new PageModel();
			list = queryallsecgoods(page);
			return list;
	 }

	 /**
	 * 修改外卖信息
	 */
	 public List<Takeout> altertakeout(Integer id,Integer sellerid,String sellername, Integer suptypeid,
				Integer subtypeid, String goodsname, String introduce,
				double price, double nowprice, String savepath,String savepath1, String savepath2,String savepath3, Integer newgoods,
				Integer hot, Integer special, Integer health, Integer recommend, String shelves, String reason){
					 List<Takeout> list = new ArrayList<Takeout>();
					 Takeout takeout = new Takeout();
					 	takeout.setId(id);
					 	takeout.setSellerid(sellerid);
					 	takeout.setSellername(sellername);
						takeout.setGoodsname(goodsname);
						takeout.setHealth(health);
						takeout.setHot(hot);
						takeout.setIntroduce(introduce);
						takeout.setNewgoods(newgoods);
						takeout.setNowprice(nowprice);
						takeout.setPrice(price);
						takeout.setRecommend(recommend);
						takeout.setSavepath(savepath);
						takeout.setSavepath1(savepath1);
						takeout.setSavepath2(savepath2);
						takeout.setSavepath3(savepath3);
						takeout.setShelves(shelves);
						takeout.setSpecial(special);
						takeout.setSubtypeid(subtypeid);
						takeout.setSuptypeid(suptypeid);
						takeout.setReason(reason);
						try {
							Session session = sessionFactory.openSession();
							session.update(takeout);
							System.out.println("Session Success?");
							session.beginTransaction().commit();
						} catch (HibernateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						PageModel page = new PageModel();
						list = queryalltakeout(page);
						return list;
				 }
	 
	/**
	 *修改推荐商家信息
	 */
	public List<Greatseller> altergreatseller(Integer id,Integer suptypeid,Integer subtypeid,String name,String content,String telephone,
			String savepath,String savepath1, String savepath2,String savepath3,String address,String url, String shelves) {
		List<Greatseller> greatsellerlist = new ArrayList<Greatseller>();
		Greatseller greatseller = new Greatseller();
		greatseller.setId(id);
		greatseller.setSubtypeid(subtypeid);
		greatseller.setSuptypeid(suptypeid);
		greatseller.setName(name);
		greatseller.setContent(content);
		greatseller.setTelephone(telephone);
		greatseller.setSavepath(savepath);
		greatseller.setSavepath1(savepath1);
		greatseller.setSavepath2(savepath2);
		greatseller.setSavepath3(savepath3);
		greatseller.setShelves(shelves);
		greatseller.setAddress(address);
		greatseller.setUrl(url);
		try {
			Session session = sessionFactory.openSession();
			session.update(greatseller);
			System.out.println("Session Success?");
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GreatsellerPage page = new GreatsellerPage();
		greatsellerlist = queryallgreatseller(page);
		return greatsellerlist;
	}
	
	
	/**
	 *修改订单信息
	 */
	public List<Order> alterorder(int id,int orderNo,String arrivedday, String arrivedtime,
			double totalamount, String username, String truename,
			String telephone, String school, String doorplate, String room,
			String remark, String payway, int isclosed){
		Order  order = new Order();
		order.setArrivedday(arrivedday);
		order.setArrivedtime(arrivedtime);
		order.setDoorplate(doorplate);
		order.setIsclosed(isclosed);
		order.setPayway(payway);
		order.setRemark(remark);
		order.setRoom(room);
		order.setSchool(school);
		order.setTelephone(telephone);
		order.setTotalamount(totalamount);
		order.setTruename(truename);
		order.setUsername(username);
		order.setOrderNo(orderNo);
		order.setId(id);
		try {
			Session session = sessionFactory.openSession();
			session.update(order);
			System.out.println("Session Success?");
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageModel page = new PageModel();
		List<Order> list = new ArrayList<Order>();
		list = queryallorder(page);
		return list;
	}
	
	/**
	 *修改订单详情
	 */
	public List<Order> alterorderdetail(List<Order_detail> list_detail){
		List<Order> orderlist = new ArrayList<Order>();
		for (int i=0;i<list_detail.size();i++){
		Order_detail order_detail = list_detail.get(i);
		try {
			Session session = sessionFactory.openSession();
			session.update(order_detail);
			System.out.println("Session Success?");
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		PageModel page = new PageModel();
		orderlist = queryallorder(page);
		return orderlist;
	}
	
	/**
	 * 修改admin密码
	 */
	public boolean alteradmin(String username, String password,String nowpassword){
		Admin admin = new Admin();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Admin as u where u.username = ?");
		query.setString(0, username);
		Admin u = (Admin) query.uniqueResult();
		if((u.getPassword()).equals(password)){
			int d = u.getId();
			admin.setId(d);
			admin.setPassword(nowpassword);
			admin.setUsername(username);
			try {
				Session session = sessionFactory.openSession();
				session.update(admin);
				System.out.println("Session Success?");
				session.beginTransaction().commit();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean upjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.openSession();
				Goods goods = findgoodsbyid(checkout[i]);
				goods.setShelves("1");
				session.update(goods);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean downjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.openSession();
				Goods goods = findgoodsbyid(checkout[i]);
				goods.setShelves("0");
				session.update(goods);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean comboupjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.openSession();
				Combo combo = findcombobyid(checkout[i]);
				combo.setShelves("1");
				session.update(combo);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean combodownjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.openSession();
				Combo combo = findcombobyid(checkout[i]);
				combo.setShelves("0");
				session.update(combo);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean secupjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.openSession();
				Secondgoods secondgoods = findsecgoodsbyid(checkout[i]);
				secondgoods.setShelves("1");
				session.update(secondgoods);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean secdownjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.openSession();
				Secondgoods secondgoods = findsecgoodsbyid(checkout[i]);
				secondgoods.setShelves("0");
				session.update(secondgoods);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean takeupjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.openSession();
				Takeout takeout = findtakeoutbyid(checkout[i]);
				takeout.setShelves("1");
				session.update(takeout);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean takedownjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.openSession();
				Takeout takeout = findtakeoutbyid(checkout[i]);
				takeout.setShelves("0");
				session.update(takeout);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean greatsellerupjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.openSession();
				Greatseller greatseller = findgreatsellerbyid(checkout[i]);
				greatseller.setShelves("1");
				session.update(greatseller);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean greatsellerdownjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.openSession();
				Greatseller greatseller = findgreatsellerbyid(checkout[i]);
				greatseller.setShelves("0");
				session.update(greatseller);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	/**
	 * 批量上架
	 * @param checkout
	 * @return
	 */
	public boolean orderupjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.openSession();
				Order order = findorderbyid(checkout[i]);
				order.setIsclosed(0);
				
				
				List<Order_detail> order_detail = findorderdetailbyid(checkout[i]);
				for(int j=0;j<order_detail.size();j++){
					order_detail.get(j).setIsclosed(0);
					session.update(order_detail.get(j));
				}
				
				session.update(order);
				session.beginTransaction().commit();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	/**
	 * 批量下架
	 * @param checkout
	 * @return
	 */
	public boolean orderdownjia(int[] checkout){
		Session session = null;
		try {
			for (int i=0;i<checkout.length;i++)
			{
				session = sessionFactory.openSession();
				Order order = findorderbyid(checkout[i]);
				order.setIsclosed(1);
				
				List<Order_detail> order_detail = findorderdetailbyid(checkout[i]);
				for(int j=0;j<order_detail.size();j++){
					order_detail.get(j).setIsclosed(1);
					session.update(order_detail.get(j));
				}
				
				session.update(order);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	
/*+++++++++++++alter结束++++++++++++++*/
	
	
	
	
/*+++++++++++++showsubtype开始++++++++++++++*/
	

	/**
	 * 查找所有子类分类返回list
	 * @return
	 */
	public List<Goods_subtype> showsubtype(){
		List<Goods_subtype> list = new ArrayList<Goods_subtype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Goods_subtype.class);
		list = c.list();
		return list;
		
	}
	
	/**
	 * 查找所有子类分类返回list
	 * @return
	 */
	public List<Goods_subtype> showsubtype1(Integer suptypeid){
		List<Goods_subtype> list = new ArrayList<Goods_subtype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Goods_subtype.class);
		c.add(Restrictions.eq("supertype", suptypeid));
		list = c.list();
		return list;
		
	}
	
	/**
	 * 查找二手商品所有子类分类返回list
	 * @return
	 */
	public List<Secondgoods_subtype> showsecsubtype(){
		List<Secondgoods_subtype> list = new ArrayList<Secondgoods_subtype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Secondgoods_subtype.class);
		list = c.list();
		System.out.println("secsub" + list);
		return list;
	}
	
	/**
	 * 查找二手商品所有子类分类返回list
	 * @return
	 */
	public List<Secondgoods_subtype> showsecsubtype1(Integer suptypeid){
		List<Secondgoods_subtype> list = new ArrayList<Secondgoods_subtype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Secondgoods_subtype.class);
		c.add(Restrictions.eq("supertype", suptypeid));
		list = c.list();
		System.out.println("secsub" + list);
		return list;
	}
	
	/**
	 * 查找外卖所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Takeout_subtype> showtakeoutsubtype(){
		List<Takeout_subtype> list = new ArrayList<Takeout_subtype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Takeout_subtype.class);
		list = c.list();
		System.out.println("Takeout_subtype" + list);
		return list;
	}
	
	/**
	 * 查找外卖所有子类分类返回list
	 * 
	 * @return
	 */
	public List<Takeout_subtype> showtakeoutsubtype1(Integer suptypeid){
		List<Takeout_subtype> list = new ArrayList<Takeout_subtype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Takeout_subtype.class);
		c.add(Restrictions.eq("supertype", suptypeid));
		list = c.list();
		System.out.println("Takeout_subtype" + list);
		return list;
	}


	/**
	 * 查找推荐商家所有子类分类返回list
	 * @return
	 */
	public List<Greatseller_subtype> showgreatsellersubtype(){
		List<Greatseller_subtype> list = new ArrayList<Greatseller_subtype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Greatseller_subtype.class);
		list = c.list();
		System.out.println("greatsellersub" + list);
		return list;
		
	}
	
	/**
	 * 查找推荐商家所有子类分类返回list
	 * @return
	 */
	public List<Greatseller_subtype> showgreatsellersubtype1(Integer suptypeid){
		List<Greatseller_subtype> list = new ArrayList<Greatseller_subtype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Greatseller_subtype.class);
		c.add(Restrictions.eq("supertype", suptypeid));
		list = c.list();
		System.out.println("greatsellersub" + list);
		return list;
		
	}
	
/*+++++++++++++showsubtype结束++++++++++++++*/	
	
	
	
/*+++++++++++++showsuptype开始++++++++++++++*/
	
	
	/**
	 * 查找所有父类分类返回list
	 * @return
	 */
	public List<Goods_supertype> showsuptype(){
		List<Goods_supertype> list = new ArrayList<Goods_supertype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Goods_supertype.class);
		list = c.list();
		return list;
	}
	
	/**
	 * 查找二手商品所有父类分类返回list
	 * @return
	 */
	public List<Secondgoods_supertype> showsecsuptype(){
		List<Secondgoods_supertype> list = new ArrayList<Secondgoods_supertype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Secondgoods_supertype.class);
		list = c.list();
		System.out.println("secsup" + list);
		return list;
	}
	
	/**
	 * 查找外卖所有父类分类返回list
	 * 
	 * @return
	 */
	public List<Takeout_supertype> showtakeoutsuptype(){
		List<Takeout_supertype> list = new ArrayList<Takeout_supertype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Takeout_supertype.class);
		list = c.list();
		System.out.println("Takeout_supertype" + list);
		return list;
	}
	
	
	/**
	 * 查找推荐商家所有父类分类返回list
	 * @return
	 */
	public List<Greatseller_supertype> showgreatsellersuptype(){
		List<Greatseller_supertype> list = new ArrayList<Greatseller_supertype>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Greatseller_supertype.class);
		list = c.list();
		System.out.println("greatsellersup" + list);
		return list;
	}
	
/*+++++++++++++showsuptype结束++++++++++++++*/	
	
	
/**
 * getter and setter
 * @return
 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
