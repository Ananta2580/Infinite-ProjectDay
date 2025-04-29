package com.java.employ.model;

import java.io.Serializable;

public class Employ implements Serializable{
	private int empno;
	private String name;
	private Gender gender;
	private String desig;
	private String dept;
	private double basic;
	
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	@Override
	public String toString() {
		return "Employ [empno=" + empno + ", name=" + name + ", gender=" + gender + ", desig=" + desig + ", dept="
				+ dept + ", basic=" + basic + "]";
	}
	
	
	
	
	
	
}
