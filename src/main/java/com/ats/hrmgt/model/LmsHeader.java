package com.ats.hrmgt.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class LmsHeader {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lmsId;
	
	private int mdAccTypeId;
	
	private int channelId;
	
	private String accCode;
	
	private int accRefCode;
	
	private int accDomainId;
	
	private String accDomainOther;
	
	private String accTags;
	
	private String accCompany;
	
	private String  accWebsite;
	
	
	private String accTurnover;
	
	private int accEmpCount;
	
	private String accScaleDesc;
	
	private String accAtsRating;
	
	private String accCompanyLandline;
	
	private boolean accStatus;
	
	private String accRemark;
	
	private boolean delStatus;
	
	private boolean isActive;
	
	private int makerUserId;
	
	private String makerDatetime;
	
	private int exInt1,exInt2;
	
	private String exVar1,exVar2;
	
	
	
	@Transient
    private	List<LmsDetail> lmsDetailList;

	
	
	
	public List<LmsDetail> getLmsDetailList() {
		return lmsDetailList;
	}

	public void setLmsDetailList(List<LmsDetail> lmsDetailList) {
		this.lmsDetailList = lmsDetailList;
	}

	public int getLmsId() {
		return lmsId;
	}

	public void setLmsId(int lmsId) {
		this.lmsId = lmsId;
	}

	public int getMdAccTypeId() {
		return mdAccTypeId;
	}

	public void setMdAccTypeId(int mdAccTypeId) {
		this.mdAccTypeId = mdAccTypeId;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	public int getAccRefCode() {
		return accRefCode;
	}

	public void setAccRefCode(int accRefCode) {
		this.accRefCode = accRefCode;
	}

	public int getAccDomainId() {
		return accDomainId;
	}

	public void setAccDomainId(int accDomainId) {
		this.accDomainId = accDomainId;
	}

	public String getAccDomainOther() {
		return accDomainOther;
	}

	public void setAccDomainOther(String accDomainOther) {
		this.accDomainOther = accDomainOther;
	}

	public String getAccTags() {
		return accTags;
	}

	public void setAccTags(String accTags) {
		this.accTags = accTags;
	}

	public String getAccCompany() {
		return accCompany;
	}

	public void setAccCompany(String accCompany) {
		this.accCompany = accCompany;
	}

	public String getAccWebsite() {
		return accWebsite;
	}

	public void setAccWebsite(String accWebsite) {
		this.accWebsite = accWebsite;
	}

	public String getAccTurnover() {
		return accTurnover;
	}

	public void setAccTurnover(String accTurnover) {
		this.accTurnover = accTurnover;
	}

	public int getAccEmpCount() {
		return accEmpCount;
	}

	public void setAccEmpCount(int accEmpCount) {
		this.accEmpCount = accEmpCount;
	}

	public String getAccScaleDesc() {
		return accScaleDesc;
	}

	public void setAccScaleDesc(String accScaleDesc) {
		this.accScaleDesc = accScaleDesc;
	}

	public String getAccAtsRating() {
		return accAtsRating;
	}

	public void setAccAtsRating(String accAtsRating) {
		this.accAtsRating = accAtsRating;
	}

	public String getAccCompanyLandline() {
		return accCompanyLandline;
	}

	public void setAccCompanyLandline(String accCompanyLandline) {
		this.accCompanyLandline = accCompanyLandline;
	}

	public boolean isAccStatus() {
		return accStatus;
	}

	public void setAccStatus(boolean accStatus) {
		this.accStatus = accStatus;
	}

	public String getAccRemark() {
		return accRemark;
	}

	public void setAccRemark(String accRemark) {
		this.accRemark = accRemark;
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
		return "LmsHeader [lmsId=" + lmsId + ", mdAccTypeId=" + mdAccTypeId + ", channelId=" + channelId + ", accCode="
				+ accCode + ", accRefCode=" + accRefCode + ", accDomainId=" + accDomainId + ", accDomainOther="
				+ accDomainOther + ", accTags=" + accTags + ", accCompany=" + accCompany + ", accWebsite=" + accWebsite
				+ ", accTurnover=" + accTurnover + ", accEmpCount=" + accEmpCount + ", accScaleDesc=" + accScaleDesc
				+ ", accAtsRating=" + accAtsRating + ", accCompanyLandline=" + accCompanyLandline + ", accStatus="
				+ accStatus + ", accRemark=" + accRemark + ", delStatus=" + delStatus + ", isActive=" + isActive
				+ ", makerUserId=" + makerUserId + ", makerDatetime=" + makerDatetime + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", lmsDetailList="
				+ lmsDetailList + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}