package com.ats.hrmgt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Designation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mDesignationId;
	
	private String mDesignationName;
	
	private boolean delStatus;
	
	private boolean isActive;
	
	@Column(name="maker_user_id")
	private int makerUserID;
	
	private String makerDatetime;
	
	private int exInt1,exInt2;
	
	private String exVar1,exVar2;

	public int getmDesignationId() {
		return mDesignationId;
	}

	public void setmDesignationId(int mDesignationId) {
		this.mDesignationId = mDesignationId;
	}

	public String getmDesignationName() {
		return mDesignationName;
	}

	public void setmDesignationName(String mDesignationName) {
		this.mDesignationName = mDesignationName;
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

	public int getMakerUserID() {
		return makerUserID;
	}

	public void setMakerUserID(int makerUserID) {
		this.makerUserID = makerUserID;
	}


	public String getMakerDatetime() {
		return makerDatetime;
	}

	public void setMakerDatetime(String makerDatetime) {
		this.makerDatetime = makerDatetime;
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
		return "Designation [mDesignationId=" + mDesignationId + ", mDesignationName=" + mDesignationName
				+ ", delStatus=" + delStatus + ", isActive=" + isActive + ", makerUserID=" + makerUserID
				+ ", makerDatetime=" + makerDatetime + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1="
				+ exVar1 + ", exVar2=" + exVar2 + "]";
	}

	
	
	
	
}
