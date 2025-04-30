package com.java.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployTest {
	
	@Test
	public void testToString() {
		Employ employ = new Employ(1, "Ananta", Gender.MALE, "CSE", 33943, "Developer");
		String result = "Employ [empno=1, name=Ananta, gender=MALE, dept=CSE, basic=33943.0, desig=Developer]";
		assertEquals(result, employ.toString());
	}
	
	@Test
	public void testGetterSetter() {
		Employ employ = new Employ();
		employ.setEmpno(1);
		employ.setName("Ananta");
		employ.setGender(Gender.MALE);
		employ.setDept("CSE");
		employ.setBasic(33943);
		employ.setDesig("Developer");
		
		assertEquals(1, employ.getEmpno());
		assertEquals("Ananta", employ.getName());
		assertEquals(Gender.MALE, employ.getGender());
		assertEquals("CSE", employ.getDept());
		assertEquals(33943, employ.getBasic(),2);
		assertEquals("Developer", employ.getDesig());
	}

	@Test
	public void testConstructor() {
		Employ obj = new Employ();
		assertNotNull(obj);
		Employ employ = new Employ(1, "Ananta", Gender.MALE, "CSE", 33943, "Developer");
		assertEquals(1, employ.getEmpno());
		assertEquals("Ananta", employ.getName());
		assertEquals(Gender.MALE, employ.getGender());
		assertEquals("CSE", employ.getDept());
		assertEquals(33943, employ.getBasic(),2);
		assertEquals("Developer", employ.getDesig());
	}

}
