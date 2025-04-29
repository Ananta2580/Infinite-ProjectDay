package com.java.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExamSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Agent Id ");
		int agentId = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","Ananta");

			System.out.println("Database Connected..");
			
			String query = "select * from agent where AgentId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, agentId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int agentId1 = rs.getInt("AgentId");
				String name = rs.getString("Name");
				String city = rs.getString("City");
				String sex = rs.getString("GENDER");
				int mStatus = rs.getInt("MaritalStatus");
				double premium = rs.getDouble("Premium");

				System.out.println("AgentId: " + agentId1 +
				                   ", Name: " + name +
				                   ", City: " + city +
				                   ", Gender: " + sex +
				                   ", Marital Status: " + mStatus +
				                   ", Premium: " + premium);
			}
			else {
				System.out.println("Record not found");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
