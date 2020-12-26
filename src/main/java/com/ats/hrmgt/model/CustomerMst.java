package com.ats.hrmgt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_customer")
public class CustomerMst {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int custId;
	
	private String customerName;
	
	private String customerEmail;
	
	private String cpName;
	
	private String cpMobile;
	
	@Column(name="cp_mobile_2")
	private String cpMobile2;
	
	private String cpEmail;
	
	private int isActive;
	
	private int delStatus;
	
	private int exInt1,exInt2;
	
	private String exVar1,exVar2;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
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

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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
		return "CustomerMst [custId=" + custId + ", customerName=" + customerName + ", customerEmail=" + customerEmail
				+ ", cpName=" + cpName + ", cpMobile=" + cpMobile + ", cpMobile2=" + cpMobile2 + ", cpEmail=" + cpEmail
				+ ", isActive=" + isActive + ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	
	
	

}
