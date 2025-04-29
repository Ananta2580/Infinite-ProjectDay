package com.java.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExamInsert {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter AgentId: ");
		int agentId = sc.nextInt();
		sc.nextLine(); // consume newline

		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter City: ");
		String city = sc.nextLine();

		System.out.print("Enter Gender (MALE/FEMALE): ");
		String gender = sc.nextLine();

		System.out.print("Enter Marital Status: ");
		String mStatus = sc.nextLine();

		System.out.print("Enter Premium: ");
		double premium = sc.nextDouble();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","Ananta");
			
			System.out.println("Database Connected..");
			
			String query = "INSERT INTO agent (AgentId, Name, City, Gender, MaritalStatus, Premium) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, agentId);
			ps.setString(2, name);
			ps.setString(3, city);
			ps.setString(4, gender);
			ps.setString(5, mStatus);
			ps.setDouble(6, premium);
			
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
