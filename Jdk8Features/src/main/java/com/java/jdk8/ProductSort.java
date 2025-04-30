package com.java.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductSort {
	public static void main(String[] args) {
		List<Product> productList=new ArrayList<>();
        productList.add(new Product(1,"Samsung A5",17000f));
        productList.add(new Product(3,"Iphone 6S",65000f));
        productList.add(new Product(2,"Sony Xperia",25000f));
        productList.add(new Product(4,"Nokia Lumia",15000f));
        productList.add(new Product(5,"Redmi4 ",26000f));
        productList.add(new Product(6,"Lenevo Vibe",19000f));
        
        Collections.sort(productList,(e1,e2) -> {
        	return e1.getName().compareTo(e2.getName());
        });
        
        System.out.println("Sorted product list by name ");
        
        productList.forEach(System.out::println);
        
        Collections.sort(productList,(e1,e2) -> {
        	return (int) (e1.getPrice()-e2.getPrice());
        });
        
        System.out.println("Sorted product list by Price ");
        
        productList.forEach(System.out::println);
	}
}
