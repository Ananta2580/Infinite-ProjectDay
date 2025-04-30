package com.java.oms.dao;

import java.util.List;

import com.java.oms.model.OrderInfo;

public interface OrderDao {
	String placeOrder(OrderInfo order);
	List<OrderInfo> showOrder(int custId);
	OrderInfo searchOrder(int custId);
	String editOrder(OrderInfo order);
	String removeOrder(int custId);
}
