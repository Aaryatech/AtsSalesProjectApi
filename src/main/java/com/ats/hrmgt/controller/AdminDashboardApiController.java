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

import com.ats.hrmgt.model.EmpTaskStatusCount;
import com.ats.hrmgt.model.EmployeeTaskDashBoard;
import com.ats.hrmgt.model.EmployeeWiseDashboard;
import com.ats.hrmgt.model.GetTaskByModuleWise;
import com.ats.hrmgt.model.ModeludeWiseDashboard;
import com.ats.hrmgt.model.TaskDetailsEmpName;
import com.ats.hrmgt.repository.EmpTaskStatusCountRepo;
import com.ats.hrmgt.repository.EmployeeTaskDashBoardRepo;
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

	@Autowired
	EmployeeTaskDashBoardRepo employeeTaskDashBoardRepo;

	@Autowired
	EmpTaskStatusCountRepo empTaskStatusCountRepo;

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

			List<TaskDetailsEmpName> unallocatedList = new ArrayList<>();
			List<TaskDetailsEmpName> allocatedList = new ArrayList<>();
			List<TaskDetailsEmpName> pendingList = new ArrayList<>();
			List<TaskDetailsEmpName> remainingList = new ArrayList<>();
			List<TaskDetailsEmpName> completedList = new ArrayList<>();

			if (moduleId == 0) {
				unallocatedList = taskDetailEmpRepo.unallocatedListAll();
				allocatedList = taskDetailEmpRepo.allocatedListAll();
				pendingList = taskDetailEmpRepo.pendingListAll();
				remainingList = taskDetailEmpRepo.remainingListAll();
				completedList = taskDetailEmpRepo.completedListAll(sf.format(dt));
			} else {
				unallocatedList = taskDetailEmpRepo.unallocatedList(moduleId);
				allocatedList = taskDetailEmpRepo.allocatedList(moduleId);
				pendingList = taskDetailEmpRepo.pendingList(moduleId);
				remainingList = taskDetailEmpRepo.remainingList(moduleId);
				completedList = taskDetailEmpRepo.completedList(moduleId, sf.format(dt));
			}

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

	@RequestMapping(value = "/employeewiseTaskwiseList", method = RequestMethod.POST)
	public @ResponseBody List<EmployeeTaskDashBoard> employeewiseTaskwiseList(@RequestParam("moduleId") int moduleId) {
		List<EmployeeTaskDashBoard> list = new ArrayList<>();

		try {

			list = employeeTaskDashBoardRepo.employeewiseTaskwiseList();

			for (int i = 0; i < list.size(); i++) {
				List<EmpTaskStatusCount> empTaskStatusWiseDetail = empTaskStatusCountRepo
						.getempTaskStatusWiseDetail(list.get(i).getEmpId(), moduleId);
				list.get(i).setEmpTaskStatusWiseDetailList(empTaskStatusWiseDetail);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = "/getTaskByStatusWiseList", method = RequestMethod.POST)
	public @ResponseBody GetTaskByModuleWise getTaskByStatusWiseList(@RequestParam int moduleId,
			@RequestParam int status) {
		GetTaskByModuleWise getTaskByModuleWise = new GetTaskByModuleWise();

		try {

			Date dt = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

			List<TaskDetailsEmpName> unallocatedList = new ArrayList<>();

			if (status == 0) {
				unallocatedList = taskDetailEmpRepo.getTaskByStatusWiseList(moduleId);

			} else {
				unallocatedList = taskDetailEmpRepo.getTaskByStatusWiseList(moduleId, status);

			}

			getTaskByModuleWise.setUnallocatedList(unallocatedList);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return getTaskByModuleWise;

	}
}
