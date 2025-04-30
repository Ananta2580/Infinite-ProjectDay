package com.java.lms.Dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.java.lms.model.LeaveDetails;import com.java.lms.model.LeaveStatus;

public class LeaveDaoImpl implements LeaveDao{
	
	static List<LeaveDetails> leaveList;
	
	static {
		leaveList = new ArrayList<LeaveDetails>();
	}


	@Override
	public List<LeaveDetails> showLeaveDao() {
		return leaveList;
	}

	@Override
	public String addLeaveDetailsDao(LeaveDetails leave) {
		leave.setLeaveStatus(LeaveStatus.PENDING);
		leaveList.add(leave);
		return "Leave details inserted";
	}

	@Override
	public LeaveDetails searchLeaveDao(int leaveid) {
		LeaveDetails found = null;
		for (LeaveDetails leaveDetails : leaveList) {
			if(leaveDetails.getLeaveId() == leaveid) {
				found = leaveDetails;
				break;
			}
		}
		return found;
	}

	@Override
	public String updateLeaveDao(LeaveDetails leaveDetails) {
		LeaveDetails found = searchLeaveDao(leaveDetails.getEmpId());
		
		if(found != null) {
			found.setLeaveStartDate(leaveDetails.getLeaveStartDate());
			found.setLeaveEndDate(leaveDetails.getLeaveEndDate());
			found.setLeaveReason(leaveDetails.getLeaveReason());
			found.setLeaveType(leaveDetails.getLeaveType());
		}
		
		return "Employ record Updated...";
	}

	@Override
	public String removeLeaveDao(int empid) {
		LeaveDetails found = searchLeaveDao(empid);
		
		if(found != null) {
			leaveList.remove(found);
			return "Leave Removed";
		}
		return "Leave not removed";
	}

	@Override
	public String writeLeaveDao() throws IOException {
		FileOutputStream fout = new FileOutputStream("C:\\Files\\leaveProject.txt");
		ObjectOutputStream os = new ObjectOutputStream(fout);
		
		os.writeObject(leaveList);
		os.close();
		fout.close();
		
		return "Data Stored Successfully";
	}

	@Override
	public String readLeaveDao() throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream("C:\\Files\\leaveProject.txt");
		ObjectInputStream oin = new ObjectInputStream(fin);
		
		leaveList = (List<LeaveDetails>)oin.readObject();
		
		return "Objects restored from the file";
	}
	
}
