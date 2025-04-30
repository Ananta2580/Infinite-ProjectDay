package com.java.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class OptionalEx2 {
	
	static List<Employ> employList;
	
	static {
		employList = new ArrayList<Employ>();
		employList.add(new Employ(1, "Himanshu", 56789));
		employList.add(new Employ(2, "Ananta", 56756));
		employList.add(new Employ(3, "Kabita", 567878));
		employList.add(new Employ(4, "Divya", 567823));
	}
	
	public Employ searchEmp(int empno) {
		Employ empFound = null;
		for (Employ e : employList) {
			empFound = e;
		}
		return empFound;
	}
	
	public static void main(String[] args) {
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ no  ");
		empno = sc.nextInt();
		OptionalEx2 obj1 = new OptionalEx2();
		Optional<Employ> empData = Optional.ofNullable(obj1.searchEmp(empno));
		
		if(empData.isPresent()) {
			System.out.println(empData);
		}
		else {
			System.out.println("Record not found");
		}
	}

}
