package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLoginData {
	
	@Id
	private int empId;
	
	private String mdAccTypeId;
	
	private String empDept;
	
	private String empName;
	
	private String empUsername;
	
	private String empMobile;
	
	private String empPassword;
	
	private int empAccessId;
	
	private boolean delStatus;
	
	private boolean isActive;
	
	private int makerUserId;
	
	private String makerDatetime;
	
	private int userTypeId;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	
	public String getMdAccTypeId() {
		return mdAccTypeId;
	}

	public void setMdAccTypeId(String mdAccTypeId) {
		this.mdAccTypeId = mdAccTypeId;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpUsername() {
		return empUsername;
	}

	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}

	public String getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public int getEmpAccessId() {
		return empAccessId;
	}

	public void setEmpAccessId(int empAccessId) {
		this.empAccessId = empAccessId;
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

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	@Override
	public String toString() {
		return "UserLoginData [empId=" + empId + ", mdAccTypeId=" + mdAccTypeId + ", empDept=" + empDept + ", empName="
				+ empName + ", empUsername=" + empUsername + ", empMobile=" + empMobile + ", empPassword=" + empPassword
				+ ", empAccessId=" + empAccessId + ", delStatus=" + delStatus + ", isActive=" + isActive
				+ ", makerUserId=" + makerUserId + ", makerDatetime=" + makerDatetime + ", userTypeId=" + userTypeId
				+ "]";
	}



	
	
	
	
	
	
	
	
	

}
