package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmpTaskStatusCount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private int taskCount;
	private int status;
	private int taskPts;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTaskCount() {
		return taskCount;
	}
	public void setTaskCount(int taskCount) {
		this.taskCount = taskCount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTaskPts() {
		return taskPts;
	}
	public void setTaskPts(int taskPts) {
		this.taskPts = taskPts;
	}
	@Override
	public String toString() {
		return "EmpTaskStatusCount [id=" + id + ", taskCount=" + taskCount + ", status=" + status + ", taskPts="
				+ taskPts + "]";
	}
	
	
	
}
