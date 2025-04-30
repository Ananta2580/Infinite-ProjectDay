package com.java.jdk8;

public class HelloImpl {
	public static void main(String[] args) {
		IHello o1 = () -> {
			System.out.println("Welcome to java");
		};
		
		IHello o2 = () -> {
			System.out.println("From Ananta");
		};
		
		IHello o3 = () -> {
			System.out.println("To the world");
		};
		
		o1.show();
		o2.show();
		o3.show();
	}
	
	
	
}
