package com.java.oms.model;

import java.util.Date;

public class OrderInfo {
	private int orderId;
	private int customerId;
	private int menuId;
	private String itemName;
	private Date orderDate;
	private double price;
	private int quantity;
	private double billAmount;
	private String orderComments;
	
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int custoomerId) {
		this.customerId = custoomerId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public String getOrderComments() {
		return orderComments;
	}
	public void setOrderComments(String orderComments) {
		this.orderComments = orderComments;
	}
	
	
	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", custoomerId=" + customerId + ", menuId=" + menuId + ", itemName="
				+ itemName + ", orderDate=" + orderDate + ", price=" + price + ", quantity=" + quantity
				+ ", billAmount=" + billAmount + ", orderComments=" + orderComments + "]";
	}
	
	
	
}
