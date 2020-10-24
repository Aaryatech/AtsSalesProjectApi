package com.ats.hrmgt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskStatus {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mTaskStatusId;
	
	private int mdAccTypeId;
	
	@Column(name="m_task_ status_sequence")
	private int mTaskStatusSequence;
	
	private String mTaskStatusName;
	
	private String mTaskStatusDesc;
	
	private boolean mTaskIsClosed;
	
	private boolean delStatus;
	
	private boolean isActive;
	
	private int makerUserId;
	
	private String makerDatetime;
	
	private int exInt1,exInt2;
	
	private String exVar1,exVar2;

	public int getmTaskStatusId() {
		return mTaskStatusId;
	}

	public int getmTaskStatusSequence() {
		return mTaskStatusSequence;
	}

	public void setmTaskStatusSequence(int mTaskStatusSequence) {
		this.mTaskStatusSequence = mTaskStatusSequence;
	}

	public void setmTaskStatusId(int mTaskStatusId) {
		this.mTaskStatusId = mTaskStatusId;
	}

	public int getMdAccTypeId() {
		return mdAccTypeId;
	}

	public void setMdAccTypeId(int mdAccTypeId) {
		this.mdAccTypeId = mdAccTypeId;
	}


	public String getmTaskStatusName() {
		return mTaskStatusName;
	}

	public void setmTaskStatusName(String mTaskStatusName) {
		this.mTaskStatusName = mTaskStatusName;
	}

	public String getmTaskStatusDesc() {
		return mTaskStatusDesc;
	}

	public void setmTaskStatusDesc(String mTaskStatusDesc) {
		this.mTaskStatusDesc = mTaskStatusDesc;
	}

	public boolean ismTaskIsClosed() {
		return mTaskIsClosed;
	}

	public void setmTaskIsClosed(boolean mTaskIsClosed) {
		this.mTaskIsClosed = mTaskIsClosed;
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
		return "TaskStatus [mTaskStatusId=" + mTaskStatusId + ", mdAccTypeId=" + mdAccTypeId + ", mTaskStatusSequence="
				+ mTaskStatusSequence + ", mTaskStatusName=" + mTaskStatusName + ", mTaskStatusDesc=" + mTaskStatusDesc
				+ ", mTaskIsClosed=" + mTaskIsClosed + ", delStatus=" + delStatus + ", isActive=" + isActive
				+ ", makerUserId=" + makerUserId + ", makerDatetime=" + makerDatetime + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
