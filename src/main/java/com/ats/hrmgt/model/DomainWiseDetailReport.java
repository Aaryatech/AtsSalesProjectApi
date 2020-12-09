package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class DomainWiseDetailReport {

	
	@Id
	private String id;
	

	private int mDomainId;
	
	private String mDomainName;
	
	private String customerName;
	
	private String accCompany;
	
	private String cpName;
	
	private String cpMobile;
	
	private String cpEmail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getmDomainId() {
		return mDomainId;
	}

	public void setmDomainId(int mDomainId) {
		this.mDomainId = mDomainId;
	}

	public String getmDomainName() {
		return mDomainName;
	}

	public void setmDomainName(String mDomainName) {
		this.mDomainName = mDomainName;
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

	@Override
	public String toString() {
		return "DomainWiseDetailReport [id=" + id + ", mDomainId=" + mDomainId + ", mDomainName=" + mDomainName
				+ ", customerName=" + customerName + ", accCompany=" + accCompany + ", cpName=" + cpName + ", cpMobile="
				+ cpMobile + ", cpEmail=" + cpEmail + "]";
	}
	
	
	
	
	
	
	

}
