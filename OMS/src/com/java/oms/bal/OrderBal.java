package com.java.oms.bal;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.java.oms.Exception.OrderException;
import com.java.oms.dao.OrderDao;
import com.java.oms.dao.OrderDaoImpl;
import com.java.oms.model.OrderInfo;

public class OrderBal {
	
	static StringBuilder sb;
	static OrderDao orderDao;
	
	static {
		sb = new StringBuilder();
		orderDao = new OrderDaoImpl();
	}
	
	
	public static String placeOrderBal(OrderInfo order) throws OrderException {
		if(validateOrder(order)) {
			return orderDao.placeOrder(order);
		}
		throw new OrderException(sb.toString());
	}
	
	public static List<OrderInfo> showOrderBal(int customerId){
		return orderDao.showOrder(customerId);
	}
	
	public static OrderInfo searchOrderBal(int custId) {
		return orderDao.searchOrder(custId);
	}
	
	public static String editOrderBal(OrderInfo orderInfo) throws OrderException {
		if(validateOrder(orderInfo) == true) {
			return orderDao.editOrder(orderInfo);
		}
		throw new OrderException(sb.toString());
	}
	
	public static String removeOrderBal(int custId) {
		return orderDao.removeOrder(custId);
	}
	
	public static boolean validateOrder(OrderInfo order) {
		boolean isValid = true;
		
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date today = calendar.getTime();
        
        if(order.getOrderDate().before(today)) {
        	sb.append("You have entered yesterday's date.");
        	isValid = false;
        }
        
        return isValid;
        
        
	}
	
}
