package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployUpdate {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter EmpNo: ");
		int empNo = sc.nextInt();
		sc.nextLine(); // consume newline

		System.out.print("Enter Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Gender (MALE/FEMALE): ");
		String gender = sc.nextLine();

		System.out.print("Enter Department: ");
		String dept = sc.nextLine();

		System.out.print("Enter Designation: ");
		String desig = sc.nextLine();

		System.out.print("Enter Basic Salary: ");
		double basic = sc.nextDouble();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitePractice","root","Ananta");
			
			System.out.println("Database Connected..");
			
			String query = "update Employ set Name = ?, Gender = ?, Dept = ?, Desig = ?, Basic = ? where Empno = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setString(3, dept);
			ps.setString(4, desig);
			ps.setDouble(5, basic);
			ps.setInt(6, empNo);
			
			ps.executeUpdate();
			
			System.out.println("....Data updated successfully....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
