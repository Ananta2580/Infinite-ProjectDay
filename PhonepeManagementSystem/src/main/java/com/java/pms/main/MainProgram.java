package com.java.pms.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.pms.Phonepe;
import com.java.pms.dao.PhonepeDao;
import com.java.pms.dao.PhonepeDaoImpl;

public class MainProgram {
	
	public static void loginUserMain() {
		Scanner sc = new Scanner(System.in);
		PhonepeDao dao = new PhonepeDaoImpl();
		
		System.out.println("Enter username:");
        String username = sc.nextLine();

        System.out.println("Enter password:");
        String password = sc.nextLine();
        
        try {
			Phonepe phonepe = dao.loginDao(username, password);
			if(phonepe != null) {
				System.out.println("Loggedin Successfully with phone no "+phonepe.getMobNo());
				
				System.out.println("Enter receiver mobile number:");
	            long receiverMobile = sc.nextLong();
	            
	            System.out.println("Enter amount to send:");
	            double amount = sc.nextDouble();
	            
	            boolean send = dao.sendMoneyDao(phonepe.getAccountNo(), receiverMobile, amount);
	            
	            if(send) {
	            	System.out.println(amount + "is sent to "+receiverMobile + " from "+phonepe.getMobNo());
	            }else {
	            	System.out.println("Failed to send money");
	            }
			}
			else {
				System.out.println("User not found");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		loginUserMain();
	}
}
