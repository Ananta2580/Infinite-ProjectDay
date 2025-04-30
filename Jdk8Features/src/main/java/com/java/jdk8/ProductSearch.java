package com.java.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductSearch {
    
    static List<Product> productList;
    
    static {
        productList = new ArrayList<Product>();  
        
        
        productList.add(new Product(1,"Samsung A5",17000f));
        productList.add(new Product(3,"Iphone 6S",65000f));
        productList.add(new Product(2,"Sony Xperia",25000f));
        productList.add(new Product(4,"Nokia Lumia",15000f));
        productList.add(new Product(5,"Redmi4 ",26000f));
        productList.add(new Product(6,"Lenevo Vibe",19000f));
    }
    
    
    public Product searchProduct(int pId) {
        Product found = null;
        for (Product product : productList) {
            if(product.getId() == pId) {
                found = product;
                break; 
            }
        }
        return found;
    }
    
    public static void main(String[] args) {
        
        int pId;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Product id ");
        pId = sc.nextInt();
        
        ProductSearch ps = new ProductSearch();
        
        Optional<Product> prodData = Optional.ofNullable(ps.searchProduct(pId));
        
        if(prodData.isPresent()) {
            System.out.println(prodData.get());  
        } else {
            System.out.println("No products found");
        }
    }
}
