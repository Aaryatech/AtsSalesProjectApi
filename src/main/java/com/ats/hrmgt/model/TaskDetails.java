package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskDetails {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskId;
	
	private int mdAccTypeId;
	
	private int priKey;
	
	private String taskTittle;
	
	private int taskTypeId;
	
	private String taskRepType;
	
	private String taskEntryType;
	
	private String taskScheDate;
	
	private String taskScheTime;
	
	private String taskAllotedTo;
	
	private int taskAllottedBy;
	
	private String taskAllotmentInstructions;
	
	private String taskClientDiscussion;
	
	
	private String taskClientProfiling;
	
	private String taskThoughQuestions;
	
	private String taskWhatWentWrong;
	
	private boolean thisTaskStatus;
	
	private boolean  taskFinalStatus;
	
	private boolean taskPriority;
	
	private int taskPts;
	
	private String taskDoneDate;
	
	private int taskDoneBy;
	
	
	private boolean delStatus;
	
	private boolean isActive;
	
	private int makerUserId;
	
	private String makerDatetime;
	
	private int allocatedById;
	
	private String allocatedDatetime;
	
	private int  exInt1,exInt2;
	
	private String exVar1,exVar2;
	
	
	
	
	public int getTaskDoneBy() {
		return taskDoneBy;
	}

	public void setTaskDoneBy(int taskDoneBy) {
		this.taskDoneBy = taskDoneBy;
	}


	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getMdAccTypeId() {
		return mdAccTypeId;
	}

	public void setMdAccTypeId(int mdAccTypeId) {
		this.mdAccTypeId = mdAccTypeId;
	}

	public int getPriKey() {
		return priKey;
	}

	public void setPriKey(int priKey) {
		this.priKey = priKey;
	}

	public String getTaskTittle() {
		return taskTittle;
	}

	public void setTaskTittle(String taskTittle) {
		this.taskTittle = taskTittle;
	}

	public int getTaskTypeId() {
		return taskTypeId;
	}

	public void setTaskTypeId(int taskTypeId) {
		this.taskTypeId = taskTypeId;
	}

	public String getTaskRepType() {
		return taskRepType;
	}

	public void setTaskRepType(String taskRepType) {
		this.taskRepType = taskRepType;
	}

	public String getTaskEntryType() {
		return taskEntryType;
	}

	public void setTaskEntryType(String taskEntryType) {
		this.taskEntryType = taskEntryType;
	}

	public String getTaskScheDate() {
		return taskScheDate;
	}

	public void setTaskScheDate(String taskScheDate) {
		this.taskScheDate = taskScheDate;
	}

	public String getTaskScheTime() {
		return taskScheTime;
	}

	public void setTaskScheTime(String taskScheTime) {
		this.taskScheTime = taskScheTime;
	}

	public String getTaskAllotedTo() {
		return taskAllotedTo;
	}

	public void setTaskAllotedTo(String taskAllotedTo) {
		this.taskAllotedTo = taskAllotedTo;
	}

	public int getTaskAllottedBy() {
		return taskAllottedBy;
	}

	public void setTaskAllottedBy(int taskAllottedBy) {
		this.taskAllottedBy = taskAllottedBy;
	}

	public String getTaskAllotmentInstructions() {
		return taskAllotmentInstructions;
	}

	public void setTaskAllotmentInstructions(String taskAllotmentInstructions) {
		this.taskAllotmentInstructions = taskAllotmentInstructions;
	}

	public String getTaskClientDiscussion() {
		return taskClientDiscussion;
	}

	public void setTaskClientDiscussion(String taskClientDiscussion) {
		this.taskClientDiscussion = taskClientDiscussion;
	}

	public String getTaskClientProfiling() {
		return taskClientProfiling;
	}

	public void setTaskClientProfiling(String taskClientProfiling) {
		this.taskClientProfiling = taskClientProfiling;
	}

	public String getTaskThoughQuestions() {
		return taskThoughQuestions;
	}

	public void setTaskThoughQuestions(String taskThoughQuestions) {
		this.taskThoughQuestions = taskThoughQuestions;
	}

	public String getTaskWhatWentWrong() {
		return taskWhatWentWrong;
	}

	public void setTaskWhatWentWrong(String taskWhatWentWrong) {
		this.taskWhatWentWrong = taskWhatWentWrong;
	}

	public boolean isThisTaskStatus() {
		return thisTaskStatus;
	}

	public void setThisTaskStatus(boolean thisTaskStatus) {
		this.thisTaskStatus = thisTaskStatus;
	}

	public boolean isTaskFinalStatus() {
		return taskFinalStatus;
	}

	public void setTaskFinalStatus(boolean taskFinalStatus) {
		this.taskFinalStatus = taskFinalStatus;
	}

	public boolean isTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(boolean taskPriority) {
		this.taskPriority = taskPriority;
	}

	public int getTaskPts() {
		return taskPts;
	}

	public void setTaskPts(int taskPts) {
		this.taskPts = taskPts;
	}

	public String getTaskDoneDate() {
		return taskDoneDate;
	}

	public void setTaskDoneDate(String taskDoneDate) {
		this.taskDoneDate = taskDoneDate;
	}

	public boolean isDelStatus() {
		return delStatus;
	}

	public void setDelStatus(boolean delStatus) {
		this.delStatus = delStatus;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
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

	public int getAllocatedById() {
		return allocatedById;
	}

	public void setAllocatedById(int allocatedById) {
		this.allocatedById = allocatedById;
	}

	public String getAllocatedDatetime() {
		return allocatedDatetime;
	}

	public void setAllocatedDatetime(String allocatedDatetime) {
		this.allocatedDatetime = allocatedDatetime;
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

	@Override
	public String toString() {
		return "TaskDetails [taskId=" + taskId + ", mdAccTypeId=" + mdAccTypeId + ", priKey=" + priKey + ", taskTittle="
				+ taskTittle + ", taskTypeId=" + taskTypeId + ", taskRepType=" + taskRepType + ", taskEntryType="
				+ taskEntryType + ", taskScheDate=" + taskScheDate + ", taskScheTime=" + taskScheTime
				+ ", taskAllotedTo=" + taskAllotedTo + ", taskAllottedBy=" + taskAllottedBy
				+ ", taskAllotmentInstructions=" + taskAllotmentInstructions + ", taskClientDiscussion="
				+ taskClientDiscussion + ", taskClientProfiling=" + taskClientProfiling + ", taskThoughQuestions="
				+ taskThoughQuestions + ", taskWhatWentWrong=" + taskWhatWentWrong + ", thisTaskStatus="
				+ thisTaskStatus + ", taskFinalStatus=" + taskFinalStatus + ", taskPriority=" + taskPriority
				+ ", taskPts=" + taskPts + ", taskDoneDate=" + taskDoneDate + ", taskDoneBy=" + taskDoneBy
				+ ", delStatus=" + delStatus + ", isActive=" + isActive + ", makerUserId=" + makerUserId
				+ ", makerDatetime=" + makerDatetime + ", allocatedById=" + allocatedById + ", allocatedDatetime="
				+ allocatedDatetime + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2="
				+ exVar2 + "]";
	}




	
	
	
	
	
	
}
