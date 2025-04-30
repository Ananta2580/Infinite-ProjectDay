package com.java.jdk8;

import java.util.ArrayList;
import java.util.List;

public class ProdMaxMin {
	public static void main(String[] args) {
		List<Product> productList=new ArrayList<>();
        productList.add(new Product(1,"Samsung A5",17000f));
        productList.add(new Product(3,"Iphone 6S",65000f));
        productList.add(new Product(2,"Sony Xperia",25000f));
        productList.add(new Product(4,"Nokia Lumia",15000f));
        productList.add(new Product(5,"Redmi4 ",26000f));
        productList.add(new Product(6,"Lenevo Vibe",19000f));
        
        Product p1= productList.stream().max((m1,m2) -> 
        	m1.getPrice() > m2.getPrice() ? 1: -1
        ).get();
        
        System.out.println(p1);
        
        Product p2= productList.stream().min((m1,m2) -> 
    	m1.getPrice() > m2.getPrice() ? 1: -1
        ).get();
    
        System.out.println(p2);
	}
}
