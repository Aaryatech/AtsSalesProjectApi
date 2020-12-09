package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CityWiseDetailReport {
	
@Id
	private String id;
	
	private int mCityId;
	
	private String mCityName;
	
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

	public int getmCityId() {
		return mCityId;
	}

	public void setmCityId(int mCityId) {
		this.mCityId = mCityId;
	}

	public String getmCityName() {
		return mCityName;
	}

	public void setmCityName(String mCityName) {
		this.mCityName = mCityName;
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
		return "CityWiseDetailReport [id=" + id + ", mCityId=" + mCityId + ", mCityName=" + mCityName
				+ ", customerName=" + customerName + ", accCompany=" + accCompany + ", cpName=" + cpName + ", cpMobile="
				+ cpMobile + ", cpEmail=" + cpEmail + "]";
	}
	
	
	
	
	
	

}
