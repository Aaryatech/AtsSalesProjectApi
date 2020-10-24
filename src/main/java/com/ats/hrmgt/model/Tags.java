package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_tags")
public class Tags {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int mTagId;

private int mAccTypeId;

private String mTagName;

private boolean delStatus;

private boolean isActive;

private int makerUserId;

private String makerDatetime;


private int exInt1,exInt2;

private String exVar1,exVar2;










public int getmTagId() {
	return mTagId;
}

public void setmTagId(int mTagId) {
	this.mTagId = mTagId;
}

public int getmAccTypeId() {
	return mAccTypeId;
}

public void setmAccTypeId(int mAccTypeId) {
	this.mAccTypeId = mAccTypeId;
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

public String getmTagName() {
	return mTagName;
}

public void setmTagName(String mTagName) {
	this.mTagName = mTagName;
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

@Override
public String toString() {
	return "Tags [mTagId=" + mTagId + ", mAccTypeId=" + mAccTypeId + ", mTagName=" + mTagName + ", delStatus="
			+ delStatus + ", isActive=" + isActive + ", makerUserId=" + makerUserId + ", makerDatetime=" + makerDatetime
			+ ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
}













	
	
}
