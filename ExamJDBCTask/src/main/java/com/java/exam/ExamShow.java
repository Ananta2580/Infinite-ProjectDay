package com.java.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamShow {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","Ananta");
			
			System.out.println("Database Connected..");
			
			String query = "select * from agent";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int agentId = rs.getInt("AgentId");
				String name = rs.getString("Name");
				String city = rs.getString("City");
				String sex = rs.getString("GENDER");
				int mStatus = rs.getInt("MaritalStatus");
				double premium = rs.getDouble("Premium");

				System.out.println("AgentId: " + agentId +
				                   ", Name: " + name +
				                   ", City: " + city +
				                   ", Gender: " + sex +
				                   ", Marital Status: " + mStatus +
				                   ", Premium: " + premium);
			}

			rs.close();
			ps.close();
			conn.close();
			
			
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
