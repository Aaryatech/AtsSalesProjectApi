package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class AtsTAskScheduleWithNames {
	
	
	@Id
	private int atsTaskId;
	
	private int mdAccTypeId;
	
	private String taskTittle;
	
	private String taskDesc;
	
	private String taskPriority;
	
	private String taskPts;
	
	private String taskRepType;
	
	private String taskRepDetails;
	
	private String taskStartDate;
	
	private String taskEndDate;
	
	private String taskScheTime;
	
	private String taskApprxTime;
	
	private String taskAllottedTo;
	

	private int isSeperateTask;
	
	private int delStatus;
	
	private int isActive;
	
	private int makerUserId;
	
	private String makerDatetime;
	
	private String exVar1,exVar2;
	
	private int exInt1,exInt2;
	
	private String empName;

	public int getAtsTaskId() {
		return atsTaskId;
	}

	public void setAtsTaskId(int atsTaskId) {
		this.atsTaskId = atsTaskId;
	}

	public int getMdAccTypeId() {
		return mdAccTypeId;
	}

	public void setMdAccTypeId(int mdAccTypeId) {
		this.mdAccTypeId = mdAccTypeId;
	}

	public String getTaskTittle() {
		return taskTittle;
	}

	public void setTaskTittle(String taskTittle) {
		this.taskTittle = taskTittle;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	public String getTaskPts() {
		return taskPts;
	}

	public void setTaskPts(String taskPts) {
		this.taskPts = taskPts;
	}

	public String getTaskRepType() {
		return taskRepType;
	}

	public void setTaskRepType(String taskRepType) {
		this.taskRepType = taskRepType;
	}

	public String getTaskRepDetails() {
		return taskRepDetails;
	}

	public void setTaskRepDetails(String taskRepDetails) {
		this.taskRepDetails = taskRepDetails;
	}

	public String getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(String taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public String getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(String taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public String getTaskScheTime() {
		return taskScheTime;
	}

	public void setTaskScheTime(String taskScheTime) {
		this.taskScheTime = taskScheTime;
	}

	public String getTaskApprxTime() {
		return taskApprxTime;
	}

	public void setTaskApprxTime(String taskApprxTime) {
		this.taskApprxTime = taskApprxTime;
	}

	public String getTaskAllottedTo() {
		return taskAllottedTo;
	}

	public void setTaskAllottedTo(String taskAllottedTo) {
		this.taskAllottedTo = taskAllottedTo;
	}

	public int getIsSeperateTask() {
		return isSeperateTask;
	}

	public void setIsSeperateTask(int isSeperateTask) {
		this.isSeperateTask = isSeperateTask;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getMakerUserId() {
		return makerUserId;
	}

	public void setMakerUserId(int makerUserId) {
		this.makerUserId = makerUserId;
	}

	public String getMakerDatetime() {
		return makerDatetime;
	}

	public void setMakerDatetime(String makerDatetime) {
		this.makerDatetime = makerDatetime;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "AtsTAskScheduleWithNames [atsTaskId=" + atsTaskId + ", mdAccTypeId=" + mdAccTypeId + ", taskTittle="
				+ taskTittle + ", taskDesc=" + taskDesc + ", taskPriority=" + taskPriority + ", taskPts=" + taskPts
				+ ", taskRepType=" + taskRepType + ", taskRepDetails=" + taskRepDetails + ", taskStartDate="
				+ taskStartDate + ", taskEndDate=" + taskEndDate + ", taskScheTime=" + taskScheTime + ", taskApprxTime="
				+ taskApprxTime + ", taskAllottedTo=" + taskAllottedTo + ", isSeperateTask=" + isSeperateTask
				+ ", delStatus=" + delStatus + ", isActive=" + isActive + ", makerUserId=" + makerUserId
				+ ", makerDatetime=" + makerDatetime + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exInt1="
				+ exInt1 + ", exInt2=" + exInt2 + ", empName=" + empName + "]";
	}
	
	
	
	
	
	
	

}
