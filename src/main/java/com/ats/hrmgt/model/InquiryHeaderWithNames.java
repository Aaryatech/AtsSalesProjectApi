package com.ats.hrmgt.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

//To Fetch Data With Channel Names And Tag Names

@Entity
public class InquiryHeaderWithNames {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int inqId;
	
	private int channelId;
	
	private int mdAccTypeId;
	
	private String pmCode;
	
	private int inqRefCode;
	
	private int inqDomainId;
	
	private String inqDomainOther;
	
	private String inqTags;
	
	private String inquiryTittle;
	
	private String inqCompany;
	
	private String inqWebsite;
	
	private String inqTurnover;
	
	
	private String inqEmpCount;
	
	private String inqScaleDesc;
	
	private String inqAtsRating;
	
	private String inqCompanyLandline;
	
	private int inqStatus;
	
	private String inqRemark;
	
	private int delStatus;
	
	private int isActive;
	
	private int makerUserId;
	
	private String makerDatetime;
	
	
	private int exInt1,exInt2;
	
	private String exVar1,exVar2;
	
	@Transient
	List<InquiryDetail> inqDetailList;
	
	private String channelName;
	
	private String mdAccName;
	
	private String tagNames;

	public int getInqId() {
		return inqId;
	}

	public void setInqId(int inqId) {
		this.inqId = inqId;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getPmCode() {
		return pmCode;
	}

	public void setPmCode(String pmCode) {
		this.pmCode = pmCode;
	}

	public int getInqRefCode() {
		return inqRefCode;
	}

	public void setInqRefCode(int inqRefCode) {
		this.inqRefCode = inqRefCode;
	}

	public int getInqDomainId() {
		return inqDomainId;
	}

	public void setInqDomainId(int inqDomainId) {
		this.inqDomainId = inqDomainId;
	}

	public String getInqDomainOther() {
		return inqDomainOther;
	}

	public void setInqDomainOther(String inqDomainOther) {
		this.inqDomainOther = inqDomainOther;
	}

	public String getInqTags() {
		return inqTags;
	}

	public void setInqTags(String inqTags) {
		this.inqTags = inqTags;
	}

	public String getInqCompany() {
		return inqCompany;
	}

	public void setInqCompany(String inqCompany) {
		this.inqCompany = inqCompany;
	}

	public String getInqWebsite() {
		return inqWebsite;
	}

	public void setInqWebsite(String inqWebsite) {
		this.inqWebsite = inqWebsite;
	}

	public String getInqTurnover() {
		return inqTurnover;
	}

	public void setInqTurnover(String inqTurnover) {
		this.inqTurnover = inqTurnover;
	}

	public String getInqEmpCount() {
		return inqEmpCount;
	}

	public void setInqEmpCount(String inqEmpCount) {
		this.inqEmpCount = inqEmpCount;
	}

	public String getInqScaleDesc() {
		return inqScaleDesc;
	}

	public void setInqScaleDesc(String inqScaleDesc) {
		this.inqScaleDesc = inqScaleDesc;
	}

	public String getInqAtsRating() {
		return inqAtsRating;
	}

	public void setInqAtsRating(String inqAtsRating) {
		this.inqAtsRating = inqAtsRating;
	}

	public String getInqCompanyLandline() {
		return inqCompanyLandline;
	}

	public void setInqCompanyLandline(String inqCompanyLandline) {
		this.inqCompanyLandline = inqCompanyLandline;
	}

	public int getInqStatus() {
		return inqStatus;
	}

	public void setInqStatus(int inqStatus) {
		this.inqStatus = inqStatus;
	}

	public String getInqRemark() {
		return inqRemark;
	}

	public void setInqRemark(String inqRemark) {
		this.inqRemark = inqRemark;
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

	public List<InquiryDetail> getInqDetailList() {
		return inqDetailList;
	}

	public void setInqDetailList(List<InquiryDetail> inqDetailList) {
		this.inqDetailList = inqDetailList;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getTagNames() {
		return tagNames;
	}

	public void setTagNames(String tagNames) {
		this.tagNames = tagNames;
	}

	public int getMdAccTypeId() {
		return mdAccTypeId;
	}

	public void setMdAccTypeId(int mdAccTypeId) {
		this.mdAccTypeId = mdAccTypeId;
	}

	public String getMdAccName() {
		return mdAccName;
	}

	public void setMdAccName(String mdAccName) {
		this.mdAccName = mdAccName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getInquiryTittle() {
		return inquiryTittle;
	}

	public void setInquiryTittle(String inquiryTittle) {
		this.inquiryTittle = inquiryTittle;
	}

	@Override
	public String toString() {
		return "InquiryHeaderWithNames [inqId=" + inqId + ", channelId=" + channelId + ", mdAccTypeId=" + mdAccTypeId
				+ ", pmCode=" + pmCode + ", inqRefCode=" + inqRefCode + ", inqDomainId=" + inqDomainId
				+ ", inqDomainOther=" + inqDomainOther + ", inqTags=" + inqTags + ", inquiryTittle=" + inquiryTittle
				+ ", inqCompany=" + inqCompany + ", inqWebsite=" + inqWebsite + ", inqTurnover=" + inqTurnover
				+ ", inqEmpCount=" + inqEmpCount + ", inqScaleDesc=" + inqScaleDesc + ", inqAtsRating=" + inqAtsRating
				+ ", inqCompanyLandline=" + inqCompanyLandline + ", inqStatus=" + inqStatus + ", inqRemark=" + inqRemark
				+ ", delStatus=" + delStatus + ", isActive=" + isActive + ", makerUserId=" + makerUserId
				+ ", makerDatetime=" + makerDatetime + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1="
				+ exVar1 + ", exVar2=" + exVar2 + ", inqDetailList=" + inqDetailList + ", channelName=" + channelName
				+ ", mdAccName=" + mdAccName + ", tagNames=" + tagNames + "]";
	}



	
	
	
	
	
	

}
