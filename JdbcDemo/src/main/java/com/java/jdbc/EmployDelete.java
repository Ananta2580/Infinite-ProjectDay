package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployDelete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ no ");
		int empno = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitePractice","root","Ananta");
			
			System.out.println("Database Connected..");
			
			String query = "delete from Employ where Empno = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, empno);
			
			ps.executeUpdate();
			System.out.println("....Record Deleted....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
