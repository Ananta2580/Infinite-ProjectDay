package com.java.jdk8;

class StrOps{
	public int strLen(String str) {
		int len = 0;
		char [] ch = str.toCharArray();
		for (char c : ch) {
			len++;
		}
		return len;
	}
}

public class MethodRefEx2 {
	public static void main(String[] args) {
		StrOps o1 = new StrOps();
		IStrEx i1 = o1::strLen;
		
		System.out.println("Length  "+i1.length("Welcome to java"));
	}
}
