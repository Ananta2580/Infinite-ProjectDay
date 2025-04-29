package com.java.files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteEmploy {
	public static void main(String[] args) {
		Employ employ = new Employ(1,"Ananta",354325);
		
		try {
			FileOutputStream fout = new FileOutputStream("C:\\Files\\employ1.txt");
			ObjectOutputStream os = new ObjectOutputStream(fout);
			
			os.writeObject(employ);
			
			os.close();
			fout.close();
			System.out.println("Data Saved");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
