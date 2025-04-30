package com.java.jdk8;

import java.util.Optional;

public class OptionalEx1 {
	public static void main(String[] args) {
//		int []a = {1,2,3,4,5};
		
		String []str = new String[10];
//		System.out.println(a[10]);
		
		str[0] = "Ananta";
		str[1] = "Anshu";
		str[2] = "Sulekha";
		str[3] = "Lakhsmikant";
		
		
		Optional<String> check = Optional.ofNullable(str[3]);
		
		if(check.isPresent()) {
			System.out.println(str[3].toUpperCase());
		}
		else {
			System.out.println("Value is not present");
		}
	}
}
