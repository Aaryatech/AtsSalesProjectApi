package com.ats.hrmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ModeludeWiseDashboard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private int lmsUnallocatedTask;
	private int lmsUnallocatedPts;
	private int lmsAllocatedTask;
	private int lmsAllocatedPts;
	private int lmsTodayCompleted;
	private int lmsTodayCompleted_pts;
	private int lmsPendingCount;
	private int lmsRemainingCount;
	private int lmsPendingPts;
	private int lmsRemainingPts;

	private int inqUnallocatedTask;
	private int inqUnallocatedPts;
	private int inqAllocatedTask;
	private int inqAllocatedPts;
	private int inqTodayCompleted;
	private int inqTodayCompleted_pts;
	private int inqPendingCount;
	private int inqRemainingCount;
	private int inqPendingPts;
	private int inqRemainingPts;

	private int atsUnallocatedTask;
	private int atsUnallocatedPts;
	private int atsAllocatedTask;
	private int atsAllocatedPts;
	private int atsTodayCompleted;
	private int atsTodayCompleted_pts;
	private int atsPendingCount;
	private int atsRemainingCount;
	private int atsPendingPts;
	private int atsRemainingPts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLmsUnallocatedTask() {
		return lmsUnallocatedTask;
	}

	public void setLmsUnallocatedTask(int lmsUnallocatedTask) {
		this.lmsUnallocatedTask = lmsUnallocatedTask;
	}

	public int getLmsUnallocatedPts() {
		return lmsUnallocatedPts;
	}

	public void setLmsUnallocatedPts(int lmsUnallocatedPts) {
		this.lmsUnallocatedPts = lmsUnallocatedPts;
	}

	public int getLmsAllocatedTask() {
		return lmsAllocatedTask;
	}

	public void setLmsAllocatedTask(int lmsAllocatedTask) {
		this.lmsAllocatedTask = lmsAllocatedTask;
	}

	public int getLmsAllocatedPts() {
		return lmsAllocatedPts;
	}

	public void setLmsAllocatedPts(int lmsAllocatedPts) {
		this.lmsAllocatedPts = lmsAllocatedPts;
	}

	public int getLmsTodayCompleted() {
		return lmsTodayCompleted;
	}

	public void setLmsTodayCompleted(int lmsTodayCompleted) {
		this.lmsTodayCompleted = lmsTodayCompleted;
	}

	public int getLmsTodayCompleted_pts() {
		return lmsTodayCompleted_pts;
	}

	public void setLmsTodayCompleted_pts(int lmsTodayCompleted_pts) {
		this.lmsTodayCompleted_pts = lmsTodayCompleted_pts;
	}

	public int getLmsPendingCount() {
		return lmsPendingCount;
	}

	public void setLmsPendingCount(int lmsPendingCount) {
		this.lmsPendingCount = lmsPendingCount;
	}

	public int getLmsRemainingCount() {
		return lmsRemainingCount;
	}

	public void setLmsRemainingCount(int lmsRemainingCount) {
		this.lmsRemainingCount = lmsRemainingCount;
	}

	public int getLmsPendingPts() {
		return lmsPendingPts;
	}

	public void setLmsPendingPts(int lmsPendingPts) {
		this.lmsPendingPts = lmsPendingPts;
	}

	public int getLmsRemainingPts() {
		return lmsRemainingPts;
	}

	public void setLmsRemainingPts(int lmsRemainingPts) {
		this.lmsRemainingPts = lmsRemainingPts;
	}

	public int getInqUnallocatedTask() {
		return inqUnallocatedTask;
	}

	public void setInqUnallocatedTask(int inqUnallocatedTask) {
		this.inqUnallocatedTask = inqUnallocatedTask;
	}

	public int getInqUnallocatedPts() {
		return inqUnallocatedPts;
	}

	public void setInqUnallocatedPts(int inqUnallocatedPts) {
		this.inqUnallocatedPts = inqUnallocatedPts;
	}

	public int getInqAllocatedTask() {
		return inqAllocatedTask;
	}

	public void setInqAllocatedTask(int inqAllocatedTask) {
		this.inqAllocatedTask = inqAllocatedTask;
	}

	public int getInqAllocatedPts() {
		return inqAllocatedPts;
	}

	public void setInqAllocatedPts(int inqAllocatedPts) {
		this.inqAllocatedPts = inqAllocatedPts;
	}

	public int getInqTodayCompleted() {
		return inqTodayCompleted;
	}

	public void setInqTodayCompleted(int inqTodayCompleted) {
		this.inqTodayCompleted = inqTodayCompleted;
	}

	public int getInqTodayCompleted_pts() {
		return inqTodayCompleted_pts;
	}

	public void setInqTodayCompleted_pts(int inqTodayCompleted_pts) {
		this.inqTodayCompleted_pts = inqTodayCompleted_pts;
	}

	public int getInqPendingCount() {
		return inqPendingCount;
	}

	public void setInqPendingCount(int inqPendingCount) {
		this.inqPendingCount = inqPendingCount;
	}

	public int getInqRemainingCount() {
		return inqRemainingCount;
	}

	public void setInqRemainingCount(int inqRemainingCount) {
		this.inqRemainingCount = inqRemainingCount;
	}

	public int getInqPendingPts() {
		return inqPendingPts;
	}

	public void setInqPendingPts(int inqPendingPts) {
		this.inqPendingPts = inqPendingPts;
	}

	public int getInqRemainingPts() {
		return inqRemainingPts;
	}

	public void setInqRemainingPts(int inqRemainingPts) {
		this.inqRemainingPts = inqRemainingPts;
	}

	public int getAtsUnallocatedTask() {
		return atsUnallocatedTask;
	}

	public void setAtsUnallocatedTask(int atsUnallocatedTask) {
		this.atsUnallocatedTask = atsUnallocatedTask;
	}

	public int getAtsUnallocatedPts() {
		return atsUnallocatedPts;
	}

	public void setAtsUnallocatedPts(int atsUnallocatedPts) {
		this.atsUnallocatedPts = atsUnallocatedPts;
	}

	public int getAtsAllocatedTask() {
		return atsAllocatedTask;
	}

	public void setAtsAllocatedTask(int atsAllocatedTask) {
		this.atsAllocatedTask = atsAllocatedTask;
	}

	public int getAtsAllocatedPts() {
		return atsAllocatedPts;
	}

	public void setAtsAllocatedPts(int atsAllocatedPts) {
		this.atsAllocatedPts = atsAllocatedPts;
	}

	public int getAtsTodayCompleted() {
		return atsTodayCompleted;
	}

	public void setAtsTodayCompleted(int atsTodayCompleted) {
		this.atsTodayCompleted = atsTodayCompleted;
	}

	public int getAtsTodayCompleted_pts() {
		return atsTodayCompleted_pts;
	}

	public void setAtsTodayCompleted_pts(int atsTodayCompleted_pts) {
		this.atsTodayCompleted_pts = atsTodayCompleted_pts;
	}

	public int getAtsPendingCount() {
		return atsPendingCount;
	}

	public void setAtsPendingCount(int atsPendingCount) {
		this.atsPendingCount = atsPendingCount;
	}

	public int getAtsRemainingCount() {
		return atsRemainingCount;
	}

	public void setAtsRemainingCount(int atsRemainingCount) {
		this.atsRemainingCount = atsRemainingCount;
	}

	public int getAtsPendingPts() {
		return atsPendingPts;
	}

	public void setAtsPendingPts(int atsPendingPts) {
		this.atsPendingPts = atsPendingPts;
	}

	public int getAtsRemainingPts() {
		return atsRemainingPts;
	}

	public void setAtsRemainingPts(int atsRemainingPts) {
		this.atsRemainingPts = atsRemainingPts;
	}

	@Override
	public String toString() {
		return "ModeludeWiseDashboard [id=" + id + ", lmsUnallocatedTask=" + lmsUnallocatedTask + ", lmsUnallocatedPts="
				+ lmsUnallocatedPts + ", lmsAllocatedTask=" + lmsAllocatedTask + ", lmsAllocatedPts=" + lmsAllocatedPts
				+ ", lmsTodayCompleted=" + lmsTodayCompleted + ", lmsTodayCompleted_pts=" + lmsTodayCompleted_pts
				+ ", lmsPendingCount=" + lmsPendingCount + ", lmsRemainingCount=" + lmsRemainingCount
				+ ", lmsPendingPts=" + lmsPendingPts + ", lmsRemainingPts=" + lmsRemainingPts + ", inqUnallocatedTask="
				+ inqUnallocatedTask + ", inqUnallocatedPts=" + inqUnallocatedPts + ", inqAllocatedTask="
				+ inqAllocatedTask + ", inqAllocatedPts=" + inqAllocatedPts + ", inqTodayCompleted=" + inqTodayCompleted
				+ ", inqTodayCompleted_pts=" + inqTodayCompleted_pts + ", inqPendingCount=" + inqPendingCount
				+ ", inqRemainingCount=" + inqRemainingCount + ", inqPendingPts=" + inqPendingPts + ", inqRemainingPts="
				+ inqRemainingPts + ", atsUnallocatedTask=" + atsUnallocatedTask + ", atsUnallocatedPts="
				+ atsUnallocatedPts + ", atsAllocatedTask=" + atsAllocatedTask + ", atsAllocatedPts=" + atsAllocatedPts
				+ ", atsTodayCompleted=" + atsTodayCompleted + ", atsTodayCompleted_pts=" + atsTodayCompleted_pts
				+ ", atsPendingCount=" + atsPendingCount + ", atsRemainingCount=" + atsRemainingCount
				+ ", atsPendingPts=" + atsPendingPts + ", atsRemainingPts=" + atsRemainingPts + "]";
	}

}
