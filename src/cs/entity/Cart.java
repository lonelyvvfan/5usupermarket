package cs.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Cart {
	public Map<Integer,Order_detail> items;
	public Cart(){
	if(items==null) {
		items=new HashMap<Integer,Order_detail>();
		}
	}
	
	public void addGoods(Integer goodsid,Order_detail orderitem){
		if(items.containsKey(goodsid)){
			Order_detail _orderitem=items.get(goodsid);
			_orderitem.setNumber(_orderitem.getNumber()+orderitem.getNumber());
			_orderitem.setTotal(Double.parseDouble(String.format("%.2f",_orderitem.getNumber()*_orderitem.getPrice())));
			items.put(goodsid, _orderitem);
		}
		else{
			items.put(goodsid, orderitem);
		}
		}
	
	public void updateCart(Integer id,int number){
			Order_detail orderitem=items.get(id);
			orderitem.setNumber(number);
			System.out.println(number);
			items.put(id, orderitem);
		}
		
	public String getTotalPrice(){
		double totalPrice=0;
		System.out.println("size is"+items.values().size());
		for(Iterator it=items.values().iterator();it.hasNext();){
			Order_detail orderitem=(Order_detail)it.next();
			totalPrice+=orderitem.getTotal();
			System.out.println("number is "+orderitem.getNumber());
			System.out.println("price is "+orderitem.getPrice());
			System.out.println("total is "+orderitem.getTotal());
		}
		if (totalPrice<19.0)
			totalPrice+=2.0;
		return String.format("%.2f", totalPrice);
	}

	public Map<Integer, Order_detail> getItems() {
		return items;
	}

	public void setItems(Map<Integer, Order_detail> items) {
		this.items = items;
	}
		
		
}
