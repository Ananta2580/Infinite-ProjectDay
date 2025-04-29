package com.java.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadEmploy {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("C:\\Files\\employ1.txt");
			ObjectInputStream oin = new ObjectInputStream(fin);
			Employ e = (Employ)oin.readObject();
			System.out.println(e);
			oin.close();
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
