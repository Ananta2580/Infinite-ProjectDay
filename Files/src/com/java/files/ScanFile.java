package com.java.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScanFile {
	public static void main(String[] args) {
		File file = new File("C:\\JavaTraining\\ProjectDay\\EmployProject\\src\\com\\java\\employ\\model\\Employ.java");
		try {
			Scanner sc = new Scanner(file);
			
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
