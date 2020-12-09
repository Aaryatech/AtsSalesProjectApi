package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChannelReports {

	
	
	@Id
	private int mChannelId;
	
	
	private String mChannelName;
	
	private String mChannelDesc;
	
	
	
	
	private int chnlLeadCount;
	
	private int chnlInqCount;
	
	
	
	
	

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

	public String getmChannelDesc() {
		return mChannelDesc;
	}

	public void setmChannelDesc(String mChannelDesc) {
		this.mChannelDesc = mChannelDesc;
	}



	public int getChnlLeadCount() {
		return chnlLeadCount;
	}

	public void setChnlLeadCount(int chnlLeadCount) {
		this.chnlLeadCount = chnlLeadCount;
	}

	public int getChnlInqCount() {
		return chnlInqCount;
	}

	public void setChnlInqCount(int chnlInqCount) {
		this.chnlInqCount = chnlInqCount;
	}

	@Override
	public String toString() {
		return "ChannelReports [mChannelId=" + mChannelId + ", mChannelName=" + mChannelName + ", mChannelDesc="
				+ mChannelDesc + ", chnlLeadCount=" + chnlLeadCount + ", chnlInqCount=" + chnlInqCount + "]";
	}


	

	
	
	
	
	
	
	
	
}
