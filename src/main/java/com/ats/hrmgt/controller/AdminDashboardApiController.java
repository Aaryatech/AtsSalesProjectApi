package com.ats.hrmgt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.model.EmployeeWiseDashboard;
import com.ats.hrmgt.model.GetTaskByModuleWise;
import com.ats.hrmgt.model.ModeludeWiseDashboard;
import com.ats.hrmgt.model.TaskDetailsEmpName;
import com.ats.hrmgt.repository.EmployeeWiseDashboardRepo;
import com.ats.hrmgt.repository.ModeludeWiseDashboardRepo;
import com.ats.hrmgt.repository.TaskDetailEmpNameRepo;

@RestController
public class AdminDashboardApiController {

	@Autowired
	EmployeeWiseDashboardRepo employeeWiseDashboardRepo;

	@Autowired
	ModeludeWiseDashboardRepo modeludeWiseDashboardRepo;

	@Autowired
	TaskDetailEmpNameRepo taskDetailEmpRepo;

	@RequestMapping(value = "/getEmployeeWiseDashboardList", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeWiseDashboard> getEmployeeWiseDashboardList() {
		List<EmployeeWiseDashboard> list = new ArrayList<EmployeeWiseDashboard>();

		try {
			Date dt = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			list = employeeWiseDashboardRepo.getEmployeeWiseDashboardList(sf.format(dt));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = "/modulewiseTaskDashboard", method = RequestMethod.GET)
	public @ResponseBody ModeludeWiseDashboard modulewiseTaskDashboard() {
		ModeludeWiseDashboard modeludeWiseDashboard = new ModeludeWiseDashboard();

		try {
			Date dt = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			modeludeWiseDashboard = modeludeWiseDashboardRepo.modulewiseTaskDashboard(sf.format(dt));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modeludeWiseDashboard;

	}

	@RequestMapping(value = "/getTaskByModuleWise", method = RequestMethod.POST)
	public @ResponseBody GetTaskByModuleWise getTaskDetailWithEmpNameByEmpid(@RequestParam int moduleId) {
		GetTaskByModuleWise getTaskByModuleWise = new GetTaskByModuleWise();

		try {

			Date dt = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			List<TaskDetailsEmpName> unallocatedList = taskDetailEmpRepo.unallocatedList(moduleId);
			List<TaskDetailsEmpName> allocatedList = taskDetailEmpRepo.allocatedList(moduleId);
			List<TaskDetailsEmpName> pendingList = taskDetailEmpRepo.pendingList(moduleId);
			List<TaskDetailsEmpName> remainingList = taskDetailEmpRepo.remainingList(moduleId);
			List<TaskDetailsEmpName> completedList = taskDetailEmpRepo.completedList(moduleId, sf.format(dt));

			ModeludeWiseDashboard modeludeWiseDashboard = modeludeWiseDashboardRepo
					.modulewiseTaskDashboard(sf.format(dt));

			getTaskByModuleWise.setAllocatedList(allocatedList);
			getTaskByModuleWise.setUnallocatedList(unallocatedList);
			getTaskByModuleWise.setCompletedList(completedList);
			getTaskByModuleWise.setPendingList(pendingList);
			getTaskByModuleWise.setRemainingList(remainingList);
			getTaskByModuleWise.setModeludeWiseDashboard(modeludeWiseDashboard);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return getTaskByModuleWise;

	}
}
