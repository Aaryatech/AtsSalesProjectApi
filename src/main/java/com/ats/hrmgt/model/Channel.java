package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Channel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mChannelId;
	
	private String mChannelName;
	
	private String mChannelDesc;
	
	private int delStatus;
	
	private int isActive;
	
	private int makerUserId;
	
	private String makerDatetime;
	
	private int exInt1,exInt2;
	
	private String exVar1,exVar2;

	public int getmChannelId() {
		return mChannelId;
	}

	public void setmChannelId(int mChannelId) {
		this.mChannelId = mChannelId;
	}

	public String getmChannelName() {
		return mChannelName;
	}

	public void setmChannelName(String mChannelName) {
		this.mChannelName = mChannelName;
	}

	public String getmChannelDesc() {
		return mChannelDesc;
	}

	public void setmChannelDesc(String mChannelDesc) {
		this.mChannelDesc = mChannelDesc;
	}

	public int isDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int isActive() {
		return isActive;
	}

	public void setActive(int isActive) {
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

	public String getExVAr2() {
		return exVar2;
	}

	public void setExVAr2(String exVar2) {
		this.exVar2 = exVar2;
	}

	@Override
	public String toString() {
		return "Channel [mChannelId=" + mChannelId + ", mChannelName=" + mChannelName + ", mChannelDesc=" + mChannelDesc
				+ ", delStatus=" + delStatus + ", isActive=" + isActive + ", makerUserId=" + makerUserId
				+ ", makerDatetime=" + makerDatetime + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1="
				+ exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



