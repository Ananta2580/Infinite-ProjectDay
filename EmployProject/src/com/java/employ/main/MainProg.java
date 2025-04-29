package com.java.employ.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.java.employ.Bal.EmployBal;
import com.java.employ.Exception.EmployException;
import com.java.employ.model.Employ;
import com.java.employ.model.Gender;

public class MainProg {
	
	static Scanner sc;
	static EmployBal employBal;
	
	static {
		sc = new Scanner(System.in);
		employBal = new EmployBal();
	}
	
	public static void addEmployMain() throws EmployException {
		Employ employ = new Employ();
		System.out.println("Enter Employ no");
		employ.setEmpno(sc.nextInt());
		
		System.out.println("Enter Employ name");
		employ.setName(sc.next());
		
		System.out.println("Enter Gender");
		employ.setGender(Gender.valueOf(sc.next()));
		
		System.out.println("Enter Department");
		employ.setDept(sc.next());
		
		System.out.println("Enter Designation");
		employ.setDesig(sc.next());
		
		System.out.println("Enter Basic");
		employ.setBasic(sc.nextDouble());
		System.out.println(employBal.addEmployBal(employ));
	}
	
	public static void showEmployMain() {
		List<Employ> employList = employBal.showEmployBal();
		for (Employ employ : employList) {
			System.out.println(employ);
		}
	}
	
	public static void searchEmployMain() {
		int empno;
		System.out.println("Enter employ Number");
		empno = sc.nextInt();
		Employ empFound = employBal.searchEmployBal(empno);
		if(empFound != null) {
			System.out.println(empFound);
		}
		else {
			System.out.println("Record not found");
		}
	}
	
	public static void removeEmployMain() {
		int empno;
		System.out.println("Enter employ Number");
		empno = sc.nextInt();
		System.out.println(employBal.removeEmployBal(empno));
	}
	public static void updateEmployMain() throws EmployException {
		
		Employ employ = new Employ();
		
		System.out.println("Enter Employ name");
		employ.setName(sc.next());
		
		System.out.println("Enter Gender");
		employ.setGender(Gender.valueOf(sc.next()));
		
		System.out.println("Enter Department");
		employ.setDept(sc.next());
		
		System.out.println("Enter Designation");
		employ.setDesig(sc.next());
		
		System.out.println("Enter Basic");
		employ.setBasic(sc.nextDouble());
		
		System.out.println(employBal.updateEmployBal(employ));
	}
	
	
	public static void writeEmployMain() throws FileNotFoundException, IOException {
		System.out.println(employBal.writeEmployFileBal());
	}
	
	public static void readEmployMain() throws ClassNotFoundException, IOException {
		System.out.println(employBal.readEmployFileBal());
	}
	
	public static void main(String[] args) {
		int choice = 0;
		
		do {
			System.out.println("1. Add Employ");
			System.out.println("2. Show Employ");
			System.out.println("3. Search Employ");
			System.out.println("4. Update Employ");
			System.out.println("5. Delete Employ");
			System.out.println("6. Write Employ");
			System.out.println("7. Read Employ");
			System.out.println("8. exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
				
				try {
					addEmployMain();
				} catch (EmployException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				showEmployMain();
				break;
			case 3:
				searchEmployMain();
				break;
			case 4:
				try {
					updateEmployMain();
				} catch (EmployException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());;
				}
				break;
			case 5:
				removeEmployMain();
				break;
				
			case 6:
				try {
					writeEmployMain();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 7:
				try {
					readEmployMain();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 8:
				return;
			}
		}while(choice != 8);
	}

}
