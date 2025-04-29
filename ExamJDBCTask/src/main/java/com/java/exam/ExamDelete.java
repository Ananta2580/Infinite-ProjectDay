package com.java.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExamDelete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Agent Id ");
		int agentId = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","Ananta");

			System.out.println("Database Connected..");
			
			String query = "delete from agent where AgentId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, agentId);
			ps.executeUpdate();
			
			System.out.println("Record Deleted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
