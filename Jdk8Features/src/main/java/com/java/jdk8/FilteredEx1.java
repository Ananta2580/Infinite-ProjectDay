package com.java.jdk8;

import java.util.ArrayList;
import java.util.List;

public class FilteredEx1 {
	public static void main(String[] args) {
		List<Employ> employList = new ArrayList<Employ>();
		employList.add(new Employ(1, "Ananta", 74653));
		employList.add(new Employ(2, "Sampark", 74654));
		employList.add(new Employ(3, "Amit", 74655));
		employList.add(new Employ(4, "Amiya", 74656));
		employList.add(new Employ(5, "Anamika", 74657));
		employList.add(new Employ(6, "Abhilipsa", 74658));
		
		System.out.println("Employ List Records are whose sal > 74655");
		
		employList.stream().filter(x -> x.getBasic() >= 74655).forEach(System.out::println);
		System.out.println("Employ List whose name starts with 'A' ");
		employList.stream().filter(x -> x.getName().startsWith("A")).forEach(System.out::println);
	}
}
