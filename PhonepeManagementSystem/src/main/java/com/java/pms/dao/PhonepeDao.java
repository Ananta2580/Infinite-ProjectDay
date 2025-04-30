package com.java.pms.dao;

import java.sql.SQLException;

import com.java.pms.Phonepe;

public interface PhonepeDao {
	Phonepe loginDao(String username, String password) throws ClassNotFoundException, SQLException;
	boolean sendMoneyDao(int senderAc, long mobileNo, double amount) throws ClassNotFoundException, SQLException;
}
