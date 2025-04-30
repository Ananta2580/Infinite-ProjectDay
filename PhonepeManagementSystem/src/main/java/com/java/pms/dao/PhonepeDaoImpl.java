package com.java.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.pms.Phonepe;
import com.java.pms.util.ConnectionHelper;

public class PhonepeDaoImpl implements PhonepeDao{
	
	Connection connection;
	PreparedStatement ps;

	@Override
	public Phonepe loginDao(String username, String password) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		
		String query = "select * from Accounts where username = ? and passcode = ?";
		ps = connection.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		Phonepe phonepe = null;

	    if (rs.next()) {
	        phonepe = new Phonepe();
	        phonepe.setAccountNo(rs.getInt("AccountNo"));
	        phonepe.setName(rs.getString("AccHolderName"));  
	        phonepe.setUserName(rs.getString("UserName"));
	        phonepe.setPassCode(rs.getString("Passcode"));
	        phonepe.setEmail(rs.getString("Email"));
	        phonepe.setMobNo(rs.getLong("MobileNo"));
	        phonepe.setAmount(rs.getDouble("Amount"));
	    }
	    return phonepe;
	}

	@Override
	public boolean sendMoneyDao(int senderAc, long mobileNo, double amount) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String recquery = "select accountno from accounts where mobileno = ?";
		ps = connection.prepareStatement(recquery);
		ps.setLong(1, mobileNo);
		ResultSet rs = ps.executeQuery();
		
		if(!rs.next()) {
			System.out.println("Reciever not found");
			return false;
		}
		int recAcc = rs.getInt("AccountNo");
		
		
		String senderBalQuery = "select amount from accounts where accountno = ?";
		ps = connection.prepareStatement(senderBalQuery);
		ps.setInt(1, senderAc);
		rs = ps.executeQuery();
		
		if(!rs.next()) {
			System.out.println("Sender not found");
			return false;
		}
		double senderBal = rs.getDouble("amount");
		
		if (senderBal < amount) {
            System.out.println("Insufficient amount.");
            return false;
        }

        
        String senderUpdate = "update accounts set amount = amount - ? where accountno = ?";
        ps = connection.prepareStatement(senderUpdate);
        ps.setDouble(1, amount);
        ps.setInt(2, senderAc);
        ps.executeUpdate();

        
        String receiverUpdate = "update accounts set amount = amount + ? where accountno = ?";
        ps = connection.prepareStatement(receiverUpdate);
        ps.setDouble(1, amount);
        ps.setInt(2, recAcc);
        ps.executeUpdate();

		
		return true;
		
		
	}

}
