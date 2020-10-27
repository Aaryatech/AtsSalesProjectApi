package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskDetailsWithMsg {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskId;
	
	
	private String taskDoneDate;
	
	
	
	private String Message;


	private String empName;


	public int getTaskId() {
		return taskId;
	}


	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}


	public String getTaskDoneDate() {
		return taskDoneDate;
	}


	public void setTaskDoneDate(String taskDoneDate) {
		this.taskDoneDate = taskDoneDate;
	}


	public String getMessage() {
		return Message;
	}


	public void setMessage(String message) {
		Message = message;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	@Override
	public String toString() {
		return "TaskDetailsWithMsg [taskId=" + taskId + ", taskDoneDate=" + taskDoneDate + ", Message=" + Message
				+ ", empName=" + empName + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
