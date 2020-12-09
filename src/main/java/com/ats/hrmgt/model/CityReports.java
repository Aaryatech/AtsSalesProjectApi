package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class CityReports {
	
	
	@Id
	private int mCityId;
	
	private int mStateId;
	
	
	private String mCityName;
	
	
	
	
	private int  cityLeadCount;
	
	private int cityInqCount;

	public int getmCityId() {
		return mCityId;
	}

	public void setmCityId(int mCityId) {
		this.mCityId = mCityId;
	}

	public int getmStateId() {
		return mStateId;
	}

	public void setmStateId(int mStateId) {
		this.mStateId = mStateId;
	}

	public String getmCityName() {
		return mCityName;
	}

	public void setmCityName(String mCityName) {
		this.mCityName = mCityName;
	}

	public int getCityLeadCount() {
		return cityLeadCount;
	}

	public void setCityLeadCount(int cityLeadCount) {
		this.cityLeadCount = cityLeadCount;
	}

	public int getCityInqCount() {
		return cityInqCount;
	}

	public void setCityInqCount(int cityInqCount) {
		this.cityInqCount = cityInqCount;
	}

	@Override
	public String toString() {
		return "CityReports [mCityId=" + mCityId + ", mStateId=" + mStateId + ", mCityName=" + mCityName
				+ ", cityLeadCount=" + cityLeadCount + ", cityInqCount=" + cityInqCount + "]";
	}
	
	
	

}
