package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_servers")
public class ServerMaster {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int serverId;	

private int custId;

private String serviceProviderName;

private String serviceProviderUsername;

private String custSupportNumber;

private int pinNumber;

private String mobNoForVerification;

private String serverIp;

private String serverName;

private String serverExpDate;

private String serverUsername;

private String serverPassword;

private String cpanelIpWithPortNo;

private String cpanelUsername;

private String cpanelPassword;

private String remarks;

private int isActive;

private int delStatus;

private int exInt1,exInt2;

private String exVar1,exVar2;

public int getServerId() {
	return serverId;
}

public void setServerId(int serverId) {
	this.serverId = serverId;
}

public int getCustId() {
	return custId;
}

public void setCustId(int custId) {
	this.custId = custId;
}

public String getServiceProviderName() {
	return serviceProviderName;
}

public void setServiceProviderName(String serviceProviderName) {
	this.serviceProviderName = serviceProviderName;
}

public String getServiceProviderUsername() {
	return serviceProviderUsername;
}

public void setServiceProviderUsername(String serviceProviderUsername) {
	this.serviceProviderUsername = serviceProviderUsername;
}


public String getCustSupportNumber() {
	return custSupportNumber;
}

public void setCustSupportNumber(String custSupportNumber) {
	this.custSupportNumber = custSupportNumber;
}

public int getPinNumber() {
	return pinNumber;
}

public void setPinNumber(int pinNumber) {
	this.pinNumber = pinNumber;
}


public String getMobNoForVerification() {
	return mobNoForVerification;
}

public void setMobNoForVerification(String mobNoForVerification) {
	this.mobNoForVerification = mobNoForVerification;
}

public String getServerIp() {
	return serverIp;
}

public void setServerIp(String serverIp) {
	this.serverIp = serverIp;
}

public String getServerName() {
	return serverName;
}

public void setServerName(String serverName) {
	this.serverName = serverName;
}

public String getServerExpDate() {
	return serverExpDate;
}

public void setServerExpDate(String serverExpDate) {
	this.serverExpDate = serverExpDate;
}

public String getServerUsername() {
	return serverUsername;
}

public void setServerUsername(String serverUsername) {
	this.serverUsername = serverUsername;
}

public String getServerPassword() {
	return serverPassword;
}

public void setServerPassword(String serverPassword) {
	this.serverPassword = serverPassword;
}

public String getCpanelIpWithPortNo() {
	return cpanelIpWithPortNo;
}

public void setCpanelIpWithPortNo(String cpanelIpWithPortNo) {
	this.cpanelIpWithPortNo = cpanelIpWithPortNo;
}

public String getCpanelUsername() {
	return cpanelUsername;
}

public void setCpanelUsername(String cpanelUsername) {
	this.cpanelUsername = cpanelUsername;
}

public String getCpanelPassword() {
	return cpanelPassword;
}

public void setCpanelPassword(String cpanelPassword) {
	this.cpanelPassword = cpanelPassword;
}

public String getRemarks() {
	return remarks;
}

public void setRemarks(String remarks) {
	this.remarks = remarks;
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
	return "ServerMaster [serverId=" + serverId + ", custId=" + custId + ", serviceProviderName=" + serviceProviderName
			+ ", serviceProviderUsername=" + serviceProviderUsername + ", custSupportNumber=" + custSupportNumber
			+ ", pinNumber=" + pinNumber + ", mobNoForVerification=" + mobNoForVerification + ", serverIp=" + serverIp
			+ ", serverName=" + serverName + ", serverExpDate=" + serverExpDate + ", serverUsername=" + serverUsername
			+ ", serverPassword=" + serverPassword + ", cpanelIpWithPortNo=" + cpanelIpWithPortNo + ", cpanelUsername="
			+ cpanelUsername + ", cpanelPassword=" + cpanelPassword + ", remarks=" + remarks + ", isActive=" + isActive
			+ ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1
			+ ", exVar2=" + exVar2 + "]";
}













	
	
	

}
