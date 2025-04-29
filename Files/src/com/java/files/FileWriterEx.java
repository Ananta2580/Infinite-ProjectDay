package com.java.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
	public static void main(String[] args) {
		File src = new File("C:\\JavaTraining\\ProjectDay\\EmployProject\\src\\com\\java\\employ\\model\\Employ.java");
		File tar = new File("C:\\Files\\Employ.txt");
		
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(tar);
			
			int ch;
			while((ch = fr.read())!=-1) {
				fw.write((char)ch);
			}
			
			fr.close();
			fw.close();
			System.out.println("File copied");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
