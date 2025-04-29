package com.java.files;

import java.io.File;

public class FileEx1 {
	public static void main(String[] args) {
		File file = new File("C:\\JavaTraining\\ProjectDay\\EmployProject\\src\\com\\java\\employ\\model\\Employ.java");
		System.out.println("File Name "+ file.getName());
		System.out.println("Parent "+file.getParent());
		System.out.println("Path "+file.getPath());
	}
}
