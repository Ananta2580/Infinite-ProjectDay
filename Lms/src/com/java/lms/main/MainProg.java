package com.java.lms.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import com.java.lms.Bal.LeaveBal;
import com.java.lms.Exception.LeaveException;
import com.java.lms.model.LeaveDetails;
import com.java.lms.model.LeaveStatus;
import com.java.lms.model.LeaveType;

public class MainProg {
	
	static Scanner sc;
	static LeaveBal leaveBal;
	
	static {
		sc = new Scanner(System.in);
		leaveBal = new LeaveBal();
	}
	
	public static void addLeaveMain() throws LeaveException {
		LeaveDetails leave = new LeaveDetails();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("Enetr leave Id");
		leave.setLeaveId(sc.nextInt());
		
		System.out.println("Enetr emp Id");
		leave.setEmpId(sc.nextInt());
		
		sc.nextLine();
		
		try {
			System.out.println("Enetr leave startdate (yyyy-MM-dd)");
			String startDateStr = sc.next();
			Date startDate = sdf.parse(startDateStr);
			leave.setLeaveStartDate(startDate);
			
			System.out.println("Enetr leave enddate (yyyy-MM-dd)");
			String endDateStr = sc.next();
	        Date endDate = sdf.parse(endDateStr);
	        leave.setLeaveEndDate(endDate);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		sc.nextLine();
		
		System.out.println("Enter leave reason");
		leave.setLeaveReason(sc.next());
		
		System.out.println("Enetr leave type (EL,PL,ML)");
		leave.setLeaveType(LeaveType.valueOf(sc.next()));
		
		System.out.println("Enetr leave status (PENDING,ACCEPTED,REJECTED)");
		leave.setLeaveStatus(LeaveStatus.valueOf(sc.next()));
		
		System.out.println(leaveBal.addLeaveBal(leave));
	}
	
	public static void showLeaveMain() {
		List<LeaveDetails> l = leaveBal.showLeaveBal();
		for (LeaveDetails leaveDetails : l) {
			System.out.println(leaveDetails);
		}
	}
	
	public static void searchLeaveMain() {
		int leaveid;
		System.out.println("Enter employ id");
		leaveid = sc.nextInt();
		LeaveDetails found = leaveBal.searchLeaveBal(leaveid);
		if(found != null) {
			System.out.println(found);
		}
		else {
			System.out.println("Record not found");
		}
	}
	
	
	public static void updateLeaveMain() throws LeaveException {
		
		LeaveDetails leave = new LeaveDetails();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			System.out.println("Enetr leave startdate (yyyy-MM-dd)");
			String startDateStr = sc.next();
			Date startDate = sdf.parse(startDateStr);
			leave.setLeaveStartDate(startDate);
			System.out.println("Enetr leave enddate (yyyy-MM-dd)");
			String endDateStr = sc.next();
			Date endDate = sdf.parse(endDateStr);
			leave.setLeaveEndDate(endDate);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Enetr leave reason");
		leave.setLeaveReason(sc.next());
		
		System.out.println("Enetr leave type (EL,PL,ML)");
		leave.setLeaveType(LeaveType.valueOf(sc.next()));
		
		
		System.out.println(leaveBal.updateLeaveBal(leave));
	}
	
	
	public static void removeLeaveMain() {
		int empid;
		System.out.println("Enter employ id");
		empid = sc.nextInt();
		System.out.println(leaveBal.removeLeaveDetails(empid));
	}
	
	
	public static void writeLeaveMain() throws FileNotFoundException, IOException {
		System.out.println(leaveBal.writeLeaveBal());
	}
	
	public static void readLeaveMain() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println(leaveBal.readLeaveBal());
	}
	public static void main(String[] args) {
		int choice = 0;
		
		do {
			System.out.println("1. Add Leave");
			System.out.println("2. Show Leave");
			System.out.println("3. Search Leave");
			System.out.println("4. Update Leave");
			System.out.println("5. Delete Leave");
			System.out.println("6. Write Leave");
			System.out.println("7. Read Leave");
			System.out.println("8. exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
				try {
					addLeaveMain();
				} catch (LeaveException e) {
					System.err.println(e.getMessage());
				}
				break;
				
			case 2:
				showLeaveMain();
				break;
				
			case 3:
				searchLeaveMain();
				break;
			case 4:
				try {
					updateLeaveMain();
				} catch (LeaveException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 5:
				removeLeaveMain();
				break;
				
			case 6:
				try {
					writeLeaveMain();
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
					readLeaveMain();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
