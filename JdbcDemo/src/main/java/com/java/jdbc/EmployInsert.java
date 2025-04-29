package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployInsert {
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
			
			String query = "INSERT INTO Employ (Empno, Name, Gender, Dept, Desig, Basic) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, empNo);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setString(4, dept);
			ps.setString(5, desig);
			ps.setDouble(6, basic);
			
			ps.executeUpdate();
			
			System.out.println("....Data inserted successfully....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
