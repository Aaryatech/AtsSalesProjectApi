package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InquiryDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int inqDetailId;
	
	private int inqId;
	
	private int cpDesignationId;
	
	private String cpName;
	
	private String cpMobile;
	
	private String cpMobile2;
	
	private String cpEmail;
	
	private int cpPrimary;
	
	private String cpRemarks;
	
	private int exInt1,exInt2;
	
	private String exVar1,exVar2;

	public int getInqDetailId() {
		return inqDetailId;
	}

	public void setInqDetailId(int inqDetailId) {
		this.inqDetailId = inqDetailId;
	}

	public int getInqId() {
		return inqId;
	}

	public void setInqId(int inqId) {
		this.inqId = inqId;
	}

	public int getCpDesignationId() {
		return cpDesignationId;
	}

	public void setCpDesignationId(int cpDesignationId) {
		this.cpDesignationId = cpDesignationId;
	}

	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public String getCpMobile() {
		return cpMobile;
	}

	public void setCpMobile(String cpMobile) {
		this.cpMobile = cpMobile;
	}

	public String getCpMobile2() {
		return cpMobile2;
	}

	public void setCpMobile2(String cpMobile2) {
		this.cpMobile2 = cpMobile2;
	}

	public String getCpEmail() {
		return cpEmail;
	}

	public void setCpEmail(String cpEmail) {
		this.cpEmail = cpEmail;
	}

	public int getCpPrimary() {
		return cpPrimary;
	}

	public void setCpPrimary(int cpPrimary) {
		this.cpPrimary = cpPrimary;
	}

	public String getCpRemarks() {
		return cpRemarks;
	}

	public void setCpRemarks(String cpRemarks) {
		this.cpRemarks = cpRemarks;
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
		return "InquiryDetail [inqDetailId=" + inqDetailId + ", inqId=" + inqId + ", cpDesignationId=" + cpDesignationId
				+ ", cpName=" + cpName + ", cpMobile=" + cpMobile + ", cpMobile2=" + cpMobile2 + ", cpEmail=" + cpEmail
				+ ", cpPrimary=" + cpPrimary + ", cpRemarks=" + cpRemarks + ", exInt1=" + exInt1 + ", exInt2=" + exInt2
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	
	
	
	
	
	
	
}
