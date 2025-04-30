package com.java.jdk8;

import java.util.ArrayList;
import java.util.List;

public class MaxMin {
	public static void main(String[] args) {
		List<Employ> employList = new ArrayList<>();
        employList.add(new Employ(1, "Ananta", 74653));
        employList.add(new Employ(2, "Sampark", 74654));
        employList.add(new Employ(3, "Amit", 74655));
        employList.add(new Employ(4, "Amiya", 74656));
        employList.add(new Employ(5, "Anamika", 74657));
        employList.add(new Employ(6, "Abhilipsa", 74658));
        
        Employ employ1 = employList.stream().max((m1,m2) -> 
        	m1.getBasic() > m2.getBasic() ?1 : -1).get();
        
        System.out.println(employ1);
        
        Employ employ2 = employList.stream().min((m1,m2) -> 
    	m1.getBasic() > m2.getBasic() ?1 : -1).get();
    
        System.out.println(employ2);
	}
}
