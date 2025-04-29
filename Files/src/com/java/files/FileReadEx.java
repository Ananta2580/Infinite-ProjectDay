package com.java.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadEx {
	public static void main(String[] args) {
		File file = new File("C:\\JavaTraining\\ProjectDay\\EmployProject\\src\\com\\java\\employ\\model\\Employ.java");
		
		try {
			FileReader fr = new FileReader(file);
			int ch;
			while((ch = fr.read()) != -1) {
				System.out.print((char)ch);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
