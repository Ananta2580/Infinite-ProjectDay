package com.java.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOutput {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("C:\\JavaTraining\\ProjectDay\\Files\\src\\com\\java\\files\\FileEx1.java");
			FileOutputStream fop = new FileOutputStream("C:\\Files\\Filenew.java");
			
			int ch;
			while((ch=fin.read()) != -1) {
				fop.write((char)ch);
			}
			fin.close();
			fop.close();
			System.out.println("File Copied");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
