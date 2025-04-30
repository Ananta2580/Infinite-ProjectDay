package com.java.lms.Bal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.java.lms.Dao.LeaveDao;
import com.java.lms.Dao.LeaveDaoImpl;
import com.java.lms.Exception.LeaveException;
import com.java.lms.model.LeaveDetails;
/**
 * Validations:
 * 1. LeaveStartDate can't be in the past.
 * 2. LeaveEndDate can't be in the past.
 * 3. LeaveStartDate can't be greater than LeaveEndDate.
 */
public class LeaveBal {
    
    static LeaveDao leaveDao;
    static StringBuilder sb;
    
    static {
        leaveDao = new LeaveDaoImpl();
        sb = new StringBuilder();
    }

    public String addLeaveBal(LeaveDetails leave) throws LeaveException {
        if (validateLeave(leave)) {
            return leaveDao.addLeaveDetailsDao(leave);
        }
        
        throw new LeaveException(sb.toString());
    }
    
    public List<LeaveDetails> showLeaveBal(){
    	return leaveDao.showLeaveDao();
    }
    
    public LeaveDetails searchLeaveBal(int leaveid) {
    	return leaveDao.searchLeaveDao(leaveid);
    }
    
    public String updateLeaveBal(LeaveDetails leaveDetails) throws LeaveException {
    	if(validateLeave(leaveDetails) == true) {
    		return leaveDao.updateLeaveDao(leaveDetails);
    	}
    	
    	throw new LeaveException();
    }
    
    public String removeLeaveDetails(int empid) {
    	return leaveDao.removeLeaveDao(empid);
    }
    
    public String writeLeaveBal() throws FileNotFoundException, IOException {
    	return leaveDao.writeLeaveDao();
    }
    
    public String readLeaveBal() throws FileNotFoundException, ClassNotFoundException, IOException {
    	return leaveDao.readLeaveDao();
    }

    public static boolean validateLeave(LeaveDetails leave) {
        boolean isValid = true;
        
        // Set time to midnight for both today's date and leave dates to ignore time component
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date today = calendar.getTime();
        
        // Check if the leave start date is before today's date
        if (leave.getLeaveStartDate().before(today)) {
            sb.append("Leave start date cannot be in the past\n");
            isValid = false;
        }
        
        // Check if the leave end date is before today's date
        if (leave.getLeaveEndDate().before(today)) {
            sb.append("Leave end date cannot be in the past\n");
            isValid = false;
        }
        
        // Check if leave start date is after leave end date
        if (leave.getLeaveStartDate().after(leave.getLeaveEndDate())) {
            sb.append("Leave start date cannot be greater than leave end date\n");
            isValid = false;
        }
        
        long diff = leave.getLeaveEndDate().getTime() - leave.getLeaveStartDate().getTime();
    	int noOfDays = (int)(diff/(1000 * 60 * 60 * 24))+1;
    	leave.setNoOfDays(noOfDays);
    
        
        return isValid;
    }
}
