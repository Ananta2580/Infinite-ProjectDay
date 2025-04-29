package com.java.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.bank.Accounts;
import com.java.bank.util.ConnectionHelper;

public class BankDaoImpl implements BankDao{
	Connection connection;
	PreparedStatement ps;
	
	public int generateAccountNo() throws ClassNotFoundException, SQLException {
		String query = "select case when max(accountNo) is null then 1 " +
				"else max(accountno) + 1 end accno from accounts";
		
		connection = ConnectionHelper.getConnection();
		ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		return rs.getInt("accno");
	}
	
	
	@Override
	public String createAccount(Accounts accounts) throws ClassNotFoundException, SQLException {
		int id = generateAccountNo();
		accounts.setAccountNo(id);
		String query = "insert into accounts(Accountno, firstname, Lastname, City, state,"+""
				+ "Amount, CheqFacil, AccountType) values(?,?,?,?,?,?,?,?)";
		
		connection = ConnectionHelper.getConnection();
		ps = connection.prepareStatement(query);
		
		ps.setInt(1, accounts.getAccountNo());
		ps.setString(2, accounts.getFirstName());
		ps.setString(3, accounts.getLastName());
		ps.setString(4, accounts.getCity());
		ps.setString(5, accounts.getState());
		ps.setDouble(6, accounts.getAmount());
		ps.setString(7, accounts.getCheqFacil());
		ps.setString(8, accounts.getAccountType());
		
		ps.executeUpdate();
		
		return "Record inserted successfully with account no "+id;
		
	}


	@Override
	public Accounts searchAccount(int accountNo) throws ClassNotFoundException, SQLException {
		Accounts accounts = null;
		String query = "select * from accounts where accountno = ?";
		connection = ConnectionHelper.getConnection();
		ps = connection.prepareStatement(query);
		
		ps.setInt(1, accountNo);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			accounts = new Accounts();
			accounts.setAccountNo(rs.getInt("AccountNo"));
			accounts.setFirstName(rs.getString("FirstName"));
			accounts.setLastName(rs.getString("LastName"));
			accounts.setCity(rs.getString("City"));
			accounts.setState(rs.getString("State"));
			accounts.setAmount(rs.getDouble("Amount"));
			accounts.setCheqFacil(rs.getString("CheqFacil"));
			accounts.setAccountType(rs.getString("AccountType"));
		}
		
		return accounts;
		
	}


	@Override
	public String depositAccount(int accountno, double depositAmount) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		Accounts accounts = searchAccount(accountno);
		
		if(accounts != null) {
			String query = "update accounts set Amount = Amount+ ? where Accountno = ?";
			ps = connection.prepareStatement(query);
			ps.setDouble(1, depositAmount);
			ps.setInt(2, accountno);
			ps.executeUpdate();
			
			query = "insert into Trans(Accountno, TransAmount, TransType) values(?,?,?)";
			ps = connection.prepareStatement(query);
			ps.setInt(1, accountno);
			ps.setDouble(2, depositAmount);
			ps.setString(3, "C");
			ps.executeUpdate();
		}
		
		return "Amount deposited successfully";
	}


	@Override
	public String withdrawAmount(int accountno, double withdrawAmount) throws ClassNotFoundException, SQLException {
		Accounts accounts = searchAccount(accountno);
		
		if(accounts != null) {
			double balance = accounts.getAmount();
			
			if(balance-withdrawAmount < 0) {
				return "Insufficient Funds..";
			}
			
			String query = "Update Accounts set Amount = Amount - ? where accountno = ?";
			ps=connection.prepareStatement(query);
			ps.setDouble(1, withdrawAmount);
			ps.setInt(2, accountno);
			ps.executeUpdate();
			
			query = "insert into Trans(Accountno, TransAmount, TransType) values(?,?,?)";
			ps=connection.prepareStatement(query);
			ps.setInt(1, accountno);
			ps.setDouble(2, withdrawAmount);
			ps.setString(3, "D");
			ps.executeUpdate();
		}
		return "Amount debited Successfully";
	}

}
