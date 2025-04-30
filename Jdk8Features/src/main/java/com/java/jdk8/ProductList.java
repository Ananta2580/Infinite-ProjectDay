package com.java.jdk8;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
	public static void main(String[] args) {
		List<Product> productList=new ArrayList<>();
        productList.add(new Product(1,"Samsung A5",17000f));
        productList.add(new Product(3,"Iphone 6S",65000f));
        productList.add(new Product(2,"Sony Xperia",25000f));
        productList.add(new Product(4,"Nokia Lumia",15000f));
        productList.add(new Product(5,"Redmi4 ",26000f));
        productList.add(new Product(6,"Lenevo Vibe",19000f));
        
        System.out.println("Product List is  ");
        productList.forEach(System.out::println);
	}
}
