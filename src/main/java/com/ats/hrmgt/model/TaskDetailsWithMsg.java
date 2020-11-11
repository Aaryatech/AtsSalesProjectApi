package com.ats.hrmgt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TaskDetailsWithMsg {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;

	private Date taskDoneDate;

	private String message;

	private String empName;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	@JsonFormat(locale = "Locale.ENGLISH", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy hh:mm:ss a")
	public Date getTaskDoneDate() {
		return taskDoneDate;
	}

	public void setTaskDoneDate(Date taskDoneDate) {
		this.taskDoneDate = taskDoneDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "TaskDetailsWithMsg [taskId=" + taskId + ", taskDoneDate=" + taskDoneDate + ", message=" + message
				+ ", empName=" + empName + "]";
	}

}
