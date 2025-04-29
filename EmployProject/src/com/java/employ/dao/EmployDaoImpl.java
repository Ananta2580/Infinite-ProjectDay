package com.java.employ.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.java.employ.model.Employ;

public class EmployDaoImpl implements EmployDao{
	
	static List<Employ> employList;
	
	static {
		employList = new ArrayList<Employ>();
	}

	@Override
	public List<Employ> showEmployDao() {
		// TODO Auto-generated method stub
		return employList;
	}

	@Override
	public String addEmployDao(Employ employ) {
		// TODO Auto-generated method stub
		employList.add(employ);
		return "Employ record inserted";
	}

	@Override
	public Employ searchEmployDao(int empno) {
		Employ employFound = null;
		for (Employ employ : employList) {
			if(employ.getEmpno() == empno) {
				employFound = employ;
				break;
			}
		}
		
		return employFound;
	}

	@Override
	public String removeEmployDao(int empno) {
		// TODO Auto-generated method stub
		
		Employ employFound = searchEmployDao(empno);
		if(employFound != null) {
			employList.remove(employFound);
			return "Employ record deleted";
		}
		return "Employ record not deleted";
	}

	@Override
	public String updateEmployDao(Employ employ) {
		Employ empFound = searchEmployDao(employ.getEmpno());
		
		if(empFound != null) {
			empFound.setName(employ.getName());
			empFound.setGender(employ.getGender());
			empFound.setDept(employ.getDept());
			empFound.setDesig(employ.getDesig());
			empFound.setBasic(employ.getBasic());
		}
		return "Employ record updated";
	}

	@Override
	public String writeEmployFileDao() throws IOException {
		FileOutputStream fout = new FileOutputStream("C:\\Files\\employProject.txt");
		
		ObjectOutputStream os = new ObjectOutputStream(fout);
		os.writeObject(employList);
		os.close();
		fout.close();
		
		return "Data stored succesfully";
	}

	@Override
	public String readEmployFileDao() throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream("C:\\Files\\employProject.txt");
		ObjectInputStream oin = new ObjectInputStream(fin);
		
		employList = (List<Employ>)oin.readObject();
		
		
		
		return "Objects Restored from File";
	}
	
}
