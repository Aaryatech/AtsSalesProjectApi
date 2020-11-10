package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class States {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mStateId;
	
	private String mStateName;
	
	private int delStatus;
	
	private int isActive;
	
	private int exInt1,exInt2;
	
	private String exVar1,exVar2;

	public int getmStateId() {
		return mStateId;
	}

	public void setmStateId(int mStateId) {
		this.mStateId = mStateId;
	}

	public String getmStateName() {
		return mStateName;
	}

	public void setmStateName(String mStateName) {
		this.mStateName = mStateName;
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
		return "States [mStateId=" + mStateId + ", mStateName=" + mStateName + ", delStatus=" + delStatus
				+ ", isActive=" + isActive + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1
				+ ", exVar2=" + exVar2 + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
