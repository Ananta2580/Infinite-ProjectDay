package com.java.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataTest {
	
	static Data data;
	
	
	@Before
	public void testBefore() {
		System.out.println("Before Test Case Called");
	}
	
	@After
	public void testAfter() {
		System.out.println("After Test Case Called");
	}
	
	@BeforeClass
	public static void setEnv() {
		data = new Data();
		System.out.println("BeforeClass Method Called");
	}
	
	@AfterClass
	public static void cleanUp() {
		data = null;
		System.out.println("AfterClass Method Called");
	}
	
	@Test
	public void testEvenOdd() {
//		Data data = new Data();
		assertTrue(data.evenOdd(12));
		assertFalse(data.evenOdd(13));
	}
	
	@Test
	public void testPosNeg() {
//		Data data = new Data();
		assertTrue(data.posNeg(2));
		assertFalse(data.posNeg(-2));
	}
	
	
	@Test
	public void testNull() {
		Data obj = null;
		assertNull(obj);
	}
	
	@Test
	public void testArrayEquals() {
		int []a = new int[] {1,2,3,4};
		int []b = new int[] {1,2,3,4};
		assertArrayEquals(a, b);
	}
	
	@Test
	public void testMax3() {
//		Data data = new Data();
		assertEquals(12, data.max3(12, 2, 3));
		assertEquals(12, data.max3(3, 12, 2));
		assertEquals(12, data.max3(3, 2, 12));
	}
	
	
	@Test
	public void testSum() {
//		Data data = new Data();
		assertEquals(5, data.sum(2, 3));
	}

	@Test
	public void testSayHello() {
//		Data data = new Data();
		assertEquals("Welcome Ananta to Junit Testing", data.sayHello());
	}

}
