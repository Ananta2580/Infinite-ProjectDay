package com.java.jdk8;


class Calc{
	public int sum(int x, int y) {
		return x+y;
	}
	
	public int sub(int x, int y) {
		return x-y;
	}
	public int mul(int x, int y) {
		return x*y;
	}
}
public class MethodRefEx {
	public static void main(String[] args) {
		Calc o1= new Calc();
		ICalculation c1 = o1::sum;
		System.out.println("Sum is  "+ c1.calc(23, 34));
		
		ICalculation c2 = o1::sub;
		System.out.println("Sub is  "+ c2.calc(23, 34));
		
		ICalculation c3 = o1::mul;
		System.out.println("Sum is  "+ c3.calc(23, 34));
	}
}


