package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChannelWiseDetailReport {
	
	@Id
	private String id;
	
	private int mChannelId;
	
	private String mChannelName;
	
	private String customerName;
	
	private String accCompany;
	
	private String cpName;
	
	private String cpMobile;
	
	private String cpEmail;

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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccCompany() {
		return accCompany;
	}

	public void setAccCompany(String accCompany) {
		this.accCompany = accCompany;
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

	public String getCpEmail() {
		return cpEmail;
	}

	public void setCpEmail(String cpEmail) {
		this.cpEmail = cpEmail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ChannelWiseDetailReport [id=" + id + ", mChannelId=" + mChannelId + ", mChannelName=" + mChannelName
				+ ", customerName=" + customerName + ", accCompany=" + accCompany + ", cpName=" + cpName + ", cpMobile="
				+ cpMobile + ", cpEmail=" + cpEmail + "]";
	}

	
	
	
	
	
	
	

}
