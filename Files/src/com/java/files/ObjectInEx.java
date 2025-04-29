package com.java.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

public class ObjectInEx {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("C:\\\\Files\\\\objex.txt");
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			String str = (String)oin.readObject();
			Date date = (Date)oin.readObject();
			
			System.out.println(str + date);
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
