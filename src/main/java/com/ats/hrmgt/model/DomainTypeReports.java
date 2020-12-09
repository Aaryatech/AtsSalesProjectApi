package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DomainTypeReports {
	
	
	@Id
	private int mDomainId;
	
	private String mDomainName;
	
	private int domainLeadCount;
	
	private int domainInqCount;

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

	public int getDomainLeadCount() {
		return domainLeadCount;
	}

	public void setDomainLeadCount(int domainLeadCount) {
		this.domainLeadCount = domainLeadCount;
	}

	public int getDomainInqCount() {
		return domainInqCount;
	}

	public void setDomainInqCount(int domainInqCount) {
		this.domainInqCount = domainInqCount;
	}

	@Override
	public String toString() {
		return "DomainTypeReports [mDomainId=" + mDomainId + ", mDomainName=" + mDomainName + ", domainLeadCount="
				+ domainLeadCount + ", domainInqCount=" + domainInqCount + "]";
	}
	
	
	
	
	
	
	
	

}
