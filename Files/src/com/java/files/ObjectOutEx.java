package com.java.files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ObjectOutEx {
	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("C:\\\\Files\\\\objex.txt");
			ObjectOutputStream ob = new ObjectOutputStream(fout);
			ob.writeObject(new String("Date is "));
			ob.writeObject(new Date());
			ob.close();
			fout.close();
			System.out.println("Objects Stored");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
