package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmploySearch {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ no ");
		int empno = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinitePractice","root","Ananta");
			
			System.out.println("Database Connected..");
			
//			Statement st = conn.createStatement();
			
//			ResultSet rs = st.executeQuery("select * from Employ");
			
			String query = "select * from Employ where Empno=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, empno);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int empNo = rs.getInt("Empno");
				String name = rs.getString("Name");
				String sex = rs.getString("Gender");
				String dept = rs.getString("Dept");
				String designation = rs.getString("Desig");
				double salary = rs.getDouble("Basic");

				System.out.println("EmpNo: " + empNo +
				                   ", Name: " + name +
				                   ", Gender: " + sex +
				                   ", Dept: " + dept +
				                   ", Designation: " + designation +
				                   ", Salary: " + salary);
			}
			else {
				System.out.println("Record not found");
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
