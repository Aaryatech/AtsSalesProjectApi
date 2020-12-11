package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeReport {
	
	@Id
	private int empId;
	
	private String empName;
	
	private int leadCount;
	
	private int inqCount;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getLeadCount() {
		return leadCount;
	}

	public void setLeadCount(int leadCount) {
		this.leadCount = leadCount;
	}

	public int getInqCount() {
		return inqCount;
	}

	public void setInqCount(int inqCount) {
		this.inqCount = inqCount;
	}

	@Override
	public String toString() {
		return "EmployeeLeadInqCoutReport [empId=" + empId + ", empName=" + empName + ", leadCount=" + leadCount
				+ ", inqCount=" + inqCount + "]";
	}
	
	
	
	
	

}
