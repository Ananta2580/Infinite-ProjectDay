package com.java.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmploySort {
	
	public static void main(String[] args) {
		List<Employ> employList = new ArrayList<Employ>();
		employList.add(new Employ(1, "Ananta", 74653));
		employList.add(new Employ(2, "Sampark", 74654));
		employList.add(new Employ(3, "Amit", 74655));
		employList.add(new Employ(4, "Amiya", 74656));
		employList.add(new Employ(5, "Anamika", 74657));
		employList.add(new Employ(6, "Abhilipsa", 74658));
		
		System.out.println("Sort by Name-wise");
		
		Collections.sort(employList,(e1,e2) -> {
			return e1.getName().compareTo(e2.getName());
		});
		
		employList.forEach(System.out::println);
	}

}
