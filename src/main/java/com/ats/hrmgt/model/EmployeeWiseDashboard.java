package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeWiseDashboard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId; 
	private String empName; 
	private int allocateTask; 
	private int allocatePts;
	private int completedTask;
	private int completedPts; 
	
	private int pendingCount; 
	private int pendingPts;
	private int remainingCount;
	private int remainingPts;
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
	public int getAllocateTask() {
		return allocateTask;
	}
	public void setAllocateTask(int allocateTask) {
		this.allocateTask = allocateTask;
	}
	public int getAllocatePts() {
		return allocatePts;
	}
	public void setAllocatePts(int allocatePts) {
		this.allocatePts = allocatePts;
	}
	public int getCompletedTask() {
		return completedTask;
	}
	public void setCompletedTask(int completedTask) {
		this.completedTask = completedTask;
	}
	public int getCompletedPts() {
		return completedPts;
	}
	public void setCompletedPts(int completedPts) {
		this.completedPts = completedPts;
	}
	public int getPendingCount() {
		return pendingCount;
	}
	public void setPendingCount(int pendingCount) {
		this.pendingCount = pendingCount;
	}
	public int getPendingPts() {
		return pendingPts;
	}
	public void setPendingPts(int pendingPts) {
		this.pendingPts = pendingPts;
	}
	public int getRemainingCount() {
		return remainingCount;
	}
	public void setRemainingCount(int remainingCount) {
		this.remainingCount = remainingCount;
	}
	public int getRemainingPts() {
		return remainingPts;
	}
	public void setRemainingPts(int remainingPts) {
		this.remainingPts = remainingPts;
	}
	@Override
	public String toString() {
		return "EmployeeWiseDashboard [empId=" + empId + ", empName=" + empName + ", allocateTask=" + allocateTask
				+ ", allocatePts=" + allocatePts + ", completedTask=" + completedTask + ", completedPts=" + completedPts
				+ ", pendingCount=" + pendingCount + ", pendingPts=" + pendingPts + ", remainingCount=" + remainingCount
				+ ", remainingPts=" + remainingPts + "]";
	} 
	
	
	

}
