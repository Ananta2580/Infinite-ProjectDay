package com.java.bank.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.bank.Accounts;
import com.java.bank.dao.BankDao;
import com.java.bank.dao.BankDaoImpl;

public class MainProgram {
	
	public static void createAccountMain() {
		Accounts accounts = new Accounts();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter FirstName");
		accounts.setFirstName(sc.next());
		
		System.out.println("Enter LastName");
		accounts.setLastName(sc.next());
		
		System.out.println("Enter City");
		accounts.setCity(sc.next());
		
		System.out.println("Enter State");
		accounts.setState(sc.next());
		
		System.out.println("Enter Amount");
		accounts.setAmount(sc.nextDouble());
		
		System.out.println("Enter CheqFacil(Yes/No)");
		accounts.setCheqFacil(sc.next());
		
		System.out.println("Enter Account type");
		accounts.setAccountType(sc.next());
		
		BankDao dao = new BankDaoImpl();
		try {
			System.out.println(dao.createAccount(accounts));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void searchAccountMain() {
		int accountNo;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account no");
		accountNo = sc.nextInt();
		
		BankDao dao = new BankDaoImpl();
		
		try {
			Accounts accounts = dao.searchAccount(accountNo);
			if(accounts != null) {
				System.out.println(accounts);
			}
			else {
				System.out.println("Account not found");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void depositAmountMain() {
		int accountNo;
		double depositAmount;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account no");
		accountNo = sc.nextInt();
		System.out.println("Enter DepositAmount");
		depositAmount = sc.nextDouble();
		
		BankDao dao = new BankDaoImpl();
		try {
			System.out.println(dao.depositAccount(accountNo, depositAmount));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void withdrawAmountMain() {
		int accountNo;
		double withdrawAmount;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account no");
		accountNo = sc.nextInt();
		System.out.println("Enter DepositAmount");
		withdrawAmount = sc.nextDouble();
		
		BankDao dao = new BankDaoImpl();
		
		try {
			System.out.println(dao.withdrawAmount(accountNo, withdrawAmount));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		createAccountMain();
//		searchAccountMain();
//		depositAmountMain();
		withdrawAmountMain();
	}
}
