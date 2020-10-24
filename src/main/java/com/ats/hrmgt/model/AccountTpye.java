package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountTpye {

	@Id
	private int mdAccTypeId;
	
	private String mdAccTypeText;
	
	private String mdAccTypeShortName;
	
	private boolean delStatus;
	
	private boolean isActive;
	
	private int makerUserId;
	
	private String makerDatetime;
	
	private String exVar1,exVar2;
	
	private int exInt1,exInt2;

	public int getMdAccTypeId() {
		return mdAccTypeId;
	}

	public void setMdAccTypeId(int mdAccTypeId) {
		this.mdAccTypeId = mdAccTypeId;
	}

	public String getMdAccTypeText() {
		return mdAccTypeText;
	}

	public void setMdAccTypeText(String mdAccTypeText) {
		this.mdAccTypeText = mdAccTypeText;
	}

	public String getMdAccTypeShortName() {
		return mdAccTypeShortName;
	}

	public void setMdAccTypeShortName(String mdAccTypeShortName) {
		this.mdAccTypeShortName = mdAccTypeShortName;
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

	@Override
	public String toString() {
		return "AccountTpye [mdAccTypeId=" + mdAccTypeId + ", mdAccTypeText=" + mdAccTypeText + ", mdAccTypeShortName="
				+ mdAccTypeShortName + ", delStatus=" + delStatus + ", isActive=" + isActive + ", makerUserId="
				+ makerUserId + ", makerDatetime=" + makerDatetime + ", exVar1=" + exVar1 + ", exVar2=" + exVar2
				+ ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
