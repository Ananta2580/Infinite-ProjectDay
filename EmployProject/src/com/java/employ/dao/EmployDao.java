package com.java.employ.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.java.employ.model.Employ;

public interface EmployDao {
	List<Employ> showEmployDao();
	String addEmployDao(Employ employ);
	Employ searchEmployDao(int empno);
	String updateEmployDao(Employ employ);
	String removeEmployDao(int empno);
	String writeEmployFileDao() throws FileNotFoundException, IOException;
	String readEmployFileDao() throws IOException, ClassNotFoundException, FileNotFoundException;
}
