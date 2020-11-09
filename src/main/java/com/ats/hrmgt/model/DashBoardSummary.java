package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DashBoardSummary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id; 
	private int todayCount; 
	private int todayCompleted;
	private int pendingCount;
	private int remainingCount;
	private int todayCompletedPts;
	private int pendingPts;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTodayCount() {
		return todayCount;
	}
	public void setTodayCount(int todayCount) {
		this.todayCount = todayCount;
	}
	public int getTodayCompleted() {
		return todayCompleted;
	}
	public void setTodayCompleted(int todayCompleted) {
		this.todayCompleted = todayCompleted;
	}
	public int getPendingCount() {
		return pendingCount;
	}
	public void setPendingCount(int pendingCount) {
		this.pendingCount = pendingCount;
	}
	public int getRemainingCount() {
		return remainingCount;
	}
	public void setRemainingCount(int remainingCount) {
		this.remainingCount = remainingCount;
	}
	public int getTodayCompletedPts() {
		return todayCompletedPts;
	}
	public void setTodayCompletedPts(int todayCompletedPts) {
		this.todayCompletedPts = todayCompletedPts;
	}
	public int getPendingPts() {
		return pendingPts;
	}
	public void setPendingPts(int pendingPts) {
		this.pendingPts = pendingPts;
	}
	@Override
	public String toString() {
		return "DashBoardSummary [id=" + id + ", todayCount=" + todayCount + ", todayCompleted=" + todayCompleted
				+ ", pendingCount=" + pendingCount + ", remainingCount=" + remainingCount + ", todayCompletedPts="
				+ todayCompletedPts + ", pendingPts=" + pendingPts + "]";
	}
	
	
	

}
