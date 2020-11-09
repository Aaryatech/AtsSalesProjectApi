package com.ats.hrmgt.model;

import java.util.List;

public class GetTaskByModuleWise {

	private List<TaskDetailsEmpName> unallocatedList;
	private List<TaskDetailsEmpName> allocatedList;
	private List<TaskDetailsEmpName> pendingList;
	private List<TaskDetailsEmpName> remainingList;
	private List<TaskDetailsEmpName> completedList;
	private ModeludeWiseDashboard modeludeWiseDashboard;

	public List<TaskDetailsEmpName> getUnallocatedList() {
		return unallocatedList;
	}

	public void setUnallocatedList(List<TaskDetailsEmpName> unallocatedList) {
		this.unallocatedList = unallocatedList;
	}

	public List<TaskDetailsEmpName> getAllocatedList() {
		return allocatedList;
	}

	public void setAllocatedList(List<TaskDetailsEmpName> allocatedList) {
		this.allocatedList = allocatedList;
	}

	public List<TaskDetailsEmpName> getPendingList() {
		return pendingList;
	}

	public void setPendingList(List<TaskDetailsEmpName> pendingList) {
		this.pendingList = pendingList;
	}

	public List<TaskDetailsEmpName> getRemainingList() {
		return remainingList;
	}

	public void setRemainingList(List<TaskDetailsEmpName> remainingList) {
		this.remainingList = remainingList;
	}

	public List<TaskDetailsEmpName> getCompletedList() {
		return completedList;
	}

	public void setCompletedList(List<TaskDetailsEmpName> completedList) {
		this.completedList = completedList;
	}

	public ModeludeWiseDashboard getModeludeWiseDashboard() {
		return modeludeWiseDashboard;
	}

	public void setModeludeWiseDashboard(ModeludeWiseDashboard modeludeWiseDashboard) {
		this.modeludeWiseDashboard = modeludeWiseDashboard;
	}

	@Override
	public String toString() {
		return "GetTaskByModuleWise [unallocatedList=" + unallocatedList + ", allocatedList=" + allocatedList
				+ ", pendingList=" + pendingList + ", remainingList=" + remainingList + ", completedList="
				+ completedList + ", modeludeWiseDashboard=" + modeludeWiseDashboard + "]";
	}

}
