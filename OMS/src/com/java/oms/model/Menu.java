package com.java.oms.model;

public class Menu {
	private int menuId;
	private String itemName;
	private int price;
	
	
	public Menu(int menuId, String string, int price) {
		super();
		this.menuId = menuId;
		this.itemName = string;
		this.price = price;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", itemName=" + itemName + ", price=" + price + "]";
	}
	
	
	
}
