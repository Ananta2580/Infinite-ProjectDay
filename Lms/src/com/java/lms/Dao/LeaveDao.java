package com.java.lms.Dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.java.lms.model.LeaveDetails;



public interface LeaveDao {
	String addLeaveDetailsDao(LeaveDetails leave);
	List<LeaveDetails> showLeaveDao();
	LeaveDetails searchLeaveDao(int leaveid);
	String updateLeaveDao(LeaveDetails leaveDetails);
	String removeLeaveDao(int empid);
	String writeLeaveDao() throws FileNotFoundException, IOException;
	String readLeaveDao() throws FileNotFoundException, IOException, ClassNotFoundException;
}
