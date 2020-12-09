package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LeadConversionTimeReport {

@Id
private int lmsId;

private String customerName;

private String accCompany;

private String statusName;

private String taskScheDate;

private int days;

private String mDomainName;

private String mChannelName;

public int getLmsId() {
	return lmsId;
}

public void setLmsId(int lmsId) {
	this.lmsId = lmsId;
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

public String getStatusName() {
	return statusName;
}

public void setStatusName(String statusName) {
	this.statusName = statusName;
}

public String getTaskScheDate() {
	return taskScheDate;
}

public void setTaskScheDate(String taskScheDate) {
	this.taskScheDate = taskScheDate;
}

public int getDays() {
	return days;
}

public void setDays(int days) {
	this.days = days;
}

public String getmDomainName() {
	return mDomainName;
}

public void setmDomainName(String mDomainName) {
	this.mDomainName = mDomainName;
}

public String getmChannelName() {
	return mChannelName;
}

public void setmChannelName(String mChannelName) {
	this.mChannelName = mChannelName;
}

@Override
public String toString() {
	return "LeadConversionTimeReport [lmsId=" + lmsId + ", customerName=" + customerName + ", accCompany=" + accCompany
			+ ", statusName=" + statusName + ", taskScheDate=" + taskScheDate + ", days=" + days + ", mDomainName="
			+ mDomainName + ", mChannelName=" + mChannelName + "]";
}










	
}
