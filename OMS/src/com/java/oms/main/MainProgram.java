package com.java.oms.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.java.oms.Exception.OrderException;
import com.java.oms.bal.OrderBal;
import com.java.oms.model.Menu;
import com.java.oms.model.OrderInfo;

public class MainProgram {
	
	static Scanner sc;
	static OrderBal orderBal;
	static List<Menu> menuList;
	
	static {
		sc = new Scanner(System.in);
		orderBal = new OrderBal();
		menuList = new ArrayList<Menu>();
	}
	
	public static void placeOrderMain() throws OrderException {
		OrderInfo order = new OrderInfo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("Enter CustomerId ");
		order.setCustomerId(sc.nextInt());
		
		System.out.println("Enter MenuId ");
	    int menuId = sc.nextInt();
	    order.setMenuId(menuId);

	    Menu selectedMenu = null;
	    for (Menu menu : menuList) {
	        if (menu.getMenuId() == menuId) {
	            selectedMenu = menu;
	            break;
	        }
	    }

	    if (selectedMenu == null) {
	        System.out.println("Invalid MenuId.");
	        return;
	    }

	    order.setItemName(selectedMenu.getItemName());
	    order.setPrice(selectedMenu.getPrice());
		
		System.out.println("Enter Date(yyyy-MM-dd) ");
		try {
			Date date = sdf.parse(sc.next());
			order.setOrderDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		System.out.println("Enter Quantity ");
		order.setQuantity(sc.nextInt());	
		
		System.out.println("Give Some Comments ");
		order.setOrderComments(sc.next());
		
		System.out.println(orderBal.placeOrderBal(order));
		
	}
	
	public static void showOrderMain() {
		System.out.println("Enter CustomerId ");
		int custId = sc.nextInt();
		List<OrderInfo> order = orderBal.showOrderBal(custId);
		
		for (OrderInfo orderInfo : order) {
			System.out.println(orderInfo);
		}
		
	}
	
	public static void searchOrderMain() {
		System.out.println("Enter CustomerId ");
		int custId = sc.nextInt();
		OrderInfo found = orderBal.searchOrderBal(custId);
		
		if(found != null) {
			System.out.println(found);
		}
		else {
			System.out.println("Record not found");
		}
	}
	
	public static void editOrderMain() throws OrderException {
		OrderInfo order = new OrderInfo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("Enter Customer ID");
	    order.setCustomerId(sc.nextInt());
		
	    System.out.println("Enter MenuId ");
	    int menuId = sc.nextInt();
	    order.setMenuId(menuId);

	    Menu selectedMenu = null;
	    for (Menu menu : menuList) {
	        if (menu.getMenuId() == menuId) {
	            selectedMenu = menu;
	            break;
	        }
	    }

	    if (selectedMenu == null) {
	        System.out.println("Invalid MenuId.");
	        return;
	    }

	    order.setItemName(selectedMenu.getItemName());
	    order.setPrice(selectedMenu.getPrice());
		
		System.out.println("Enter Date(yyyy-MM-dd) ");
		try {
			Date date = sdf.parse(sc.next());
			order.setOrderDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		System.out.println("Enter Quantity ");
		order.setQuantity(sc.nextInt());	
		
		System.out.println("Give Some Comments ");
		order.setOrderComments(sc.next());
		
		System.out.println(orderBal.editOrderBal(order));
		
	}
	
	public static void removeOrderMain() {
		System.out.println("Enter customer id");
		int custId = sc.nextInt();
		System.out.println(orderBal.removeOrderBal(custId));
	}
	
	public static void main(String[] args) {
		int choice;
		
		menuList.add(new Menu(1, "Veg Biryani", 100));
		menuList.add(new Menu(2, "Fried Rice", 120));
		menuList.add(new Menu(3, "Chicken Masala", 90));
		menuList.add(new Menu(4, "Paneer Butter Masala", 100));
		menuList.add(new Menu(5, "Chicken Biryani", 200));
		menuList.add(new Menu(6, "Pakhala", 300));
		
		
		do {
			
			for (Object ob : menuList) {
				System.out.println(ob);
			}
			
			System.out.println("1. Place Order ");
            System.out.println("2. Show Customer Orders");
            System.out.println("3. Search Order");
            System.out.println("4. Edit Order");
            System.out.println("5. Delete Order");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice) {
            	case 1:
            		
            		try {
            			placeOrderMain();
            		} catch (OrderException e) {
            			// TODO Auto-generated catch block
            			System.err.println(e.getMessage());
            		}
            		break;
				
            	case 2:
            		showOrderMain();
            		break;
            		
            	case 3:
            		searchOrderMain();
            		break;
            		
            	case 4:
            		try {
            			editOrderMain();
            		} catch (OrderException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
            		break;
            		
            	case 5:
            		removeOrderMain();
            		break;
            		
            	case 6:
            		return;
            	
            }
			
		}
		while(choice != 6);
	}
}
