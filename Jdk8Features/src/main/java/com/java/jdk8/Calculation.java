package com.java.jdk8;

import java.util.Scanner;

public class Calculation {
	
	public static void main(String[] args) {
		int a,b;
		
		System.out.println("Enter two nos ");
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		
		ICalculation o1 = (x,y) -> {
			return x+y;
		};
		ICalculation o2 = (x,y) -> {
			return x-y;
		};
		ICalculation o3 = (x,y) -> {
			return x*y;
		};
		
		System.out.println("Sum is "+o1.calc(a, b));
		System.out.println("Sub is "+o2.calc(a, b));
		System.out.println("Mul is "+o3.calc(a, b));
	}

}
