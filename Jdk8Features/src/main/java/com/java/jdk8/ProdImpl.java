package com.java.jdk8;


class StrImpl{
	
	public String toLower(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32)); 
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
	
	public String toUpper(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32)); 
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
	
}
public class ProdImpl {
	
	public static void main(String[] args) {
		StrImpl s = new StrImpl();
		Istr1 i1 = s::toLower;
        Istr2 i2 = s::toUpper;

        String input = "Ananta is a good boy";

        System.out.println("Original:   " + input);
        System.out.println("LowerCase:  " + i1.toLower(input));
        System.out.println("UpperCase:  " + i2.toUpper(input));
	}
	
}
