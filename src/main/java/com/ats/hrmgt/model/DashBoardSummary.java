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
	private int todaysLeadCount;
	private int todaysInqCount;
	private int scheDemoCnt;
	private int monthlyLeadCount;
	private int monthScheDemo;
	private int monthlyInqCount;
	
	
	
	
	
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
	public int getTodaysLeadCount() {
		return todaysLeadCount;
	}
	public void setTodaysLeadCount(int todaysLeadCount) {
		this.todaysLeadCount = todaysLeadCount;
	}
	public int getTodaysInqCount() {
		return todaysInqCount;
	}
	public void setTodaysInqCount(int todaysInqCount) {
		this.todaysInqCount = todaysInqCount;
	}
	public int getScheDemoCnt() {
		return scheDemoCnt;
	}
	public void setScheDemoCnt(int scheDemoCnt) {
		this.scheDemoCnt = scheDemoCnt;
	}
	public int getMonthlyLeadCount() {
		return monthlyLeadCount;
	}
	public void setMonthlyLeadCount(int monthlyLeadCount) {
		this.monthlyLeadCount = monthlyLeadCount;
	}
	public int getMonthScheDemo() {
		return monthScheDemo;
	}
	public void setMonthScheDemo(int monthScheDemo) {
		this.monthScheDemo = monthScheDemo;
	}
	public int getMonthlyInqCount() {
		return monthlyInqCount;
	}
	public void setMonthlyInqCount(int monthlyInqCount) {
		this.monthlyInqCount = monthlyInqCount;
	}
	@Override
	public String toString() {
		return "DashBoardSummary [id=" + id + ", todayCount=" + todayCount + ", todayCompleted=" + todayCompleted
				+ ", pendingCount=" + pendingCount + ", remainingCount=" + remainingCount + ", todayCompletedPts="
				+ todayCompletedPts + ", pendingPts=" + pendingPts + ", todaysLeadCount=" + todaysLeadCount
				+ ", todaysInqCount=" + todaysInqCount + ", scheDemoCnt=" + scheDemoCnt + ", monthlyLeadCount="
				+ monthlyLeadCount + ", monthScheDemo=" + monthScheDemo + ", monthlyInqCount=" + monthlyInqCount + "]";
	}
	
	
	

	
	
	
	
	
	
	
	
	

}
