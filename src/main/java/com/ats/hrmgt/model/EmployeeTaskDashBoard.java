package com.ats.hrmgt.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class EmployeeTaskDashBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String empName;
	
	@Transient
	private List<EmpTaskStatusCount> empTaskStatusWiseDetailList;
	
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
	public List<EmpTaskStatusCount> getEmpTaskStatusWiseDetailList() {
		return empTaskStatusWiseDetailList;
	}
	public void setEmpTaskStatusWiseDetailList(List<EmpTaskStatusCount> empTaskStatusWiseDetailList) {
		this.empTaskStatusWiseDetailList = empTaskStatusWiseDetailList;
	}
	@Override
	public String toString() {
		return "EmployeeTaskDashBoard [empId=" + empId + ", empName=" + empName + ", empTaskStatusWiseDetailList="
				+ empTaskStatusWiseDetailList + "]";
	}
	
	

}
