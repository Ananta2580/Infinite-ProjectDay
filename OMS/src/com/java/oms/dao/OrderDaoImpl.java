package com.java.oms.dao;

import java.util.ArrayList;
import java.util.List;

import com.java.oms.model.OrderInfo;

public class OrderDaoImpl implements OrderDao{
	static List<OrderInfo> orderList;
	private static double billAmount;
	
	static {
		orderList = new ArrayList<OrderInfo>();
	}
	
	public int generateOrderId() {
		if(orderList.size() == 0) {
			return 1;
		}
		else {
			return orderList.get(orderList.size()-1).getOrderId()+1;
		}
	}

	@Override
	public String placeOrder(OrderInfo order) {
		order.setOrderId(generateOrderId());
		billAmount = order.getPrice()*order.getQuantity();
		order.setBillAmount(billAmount);
		orderList.add(order);
		
		return "Order placed Successfully";
	}

	@Override
	public List<OrderInfo> showOrder(int custId) {
		List<OrderInfo> result = new ArrayList<>();

	    for (OrderInfo order : orderList) {
	        if (order.getCustomerId() == custId) {
	            result.add(order);
	        }
	    }
	    
	    return result;
	    
	}

	@Override
	public OrderInfo searchOrder(int custId) {
		OrderInfo found = null;
		for (OrderInfo orderInfo : orderList) {
			if(orderInfo.getCustomerId() == custId) {
				found = orderInfo;
				break;
			}
		}
		
		return found;
	}

	@Override
	public String editOrder(OrderInfo order) {
		OrderInfo found = searchOrder(order.getCustomerId());
		
		if(found != null) {
			found.setItemName(order.getItemName());
			found.setOrderDate(order.getOrderDate());
			found.setMenuId(order.getMenuId());
			found.setPrice(order.getPrice());
			found.setQuantity(order.getQuantity());
			billAmount = order.getPrice()*order.getQuantity();
			found.setBillAmount(billAmount);
			found.setOrderComments(order.getOrderComments());
		}
		
		return "Order list updated";
	}

	@Override
	public String removeOrder(int custId) {
		OrderInfo found = searchOrder(custId);
		
		if(found != null ) {
			orderList.remove(found);
			return "Order removed";
		}
		return "Order not removed";
	}
	
	
}
