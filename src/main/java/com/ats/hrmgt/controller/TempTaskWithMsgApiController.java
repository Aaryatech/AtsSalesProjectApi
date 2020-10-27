package com.ats.hrmgt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.model.Department;
import com.ats.hrmgt.model.Designation;
import com.ats.hrmgt.model.DomainType;
import com.ats.hrmgt.model.TaskDetailsWithMsg;
import com.ats.hrmgt.repository.DepartmentRepository;
import com.ats.hrmgt.repository.DesignationRepository;
import com.ats.hrmgt.repository.DomainTypeRepository;
import com.ats.hrmgt.repository.TaskDetailWithMsgRepository;

@RestController
public class TempTaskWithMsgApiController {

	
	
	@Autowired
	TaskDetailWithMsgRepository taskDetailWithMsgRepo;
	
	@Autowired
	DepartmentRepository deptRepo;
	
	@Autowired
	DesignationRepository designationRepo;
	
	
	@Autowired
	DomainTypeRepository domainTypeRepo;
	
	
	//To Fetch Records With Client Profiling AS Message By pri_key And md_acc_type_id 
	@RequestMapping(value="/getTaskDetailsClientProfiling",method=RequestMethod.POST)
	public @ResponseBody List<TaskDetailsWithMsg>  getTaskDetailsClientProfiling(@RequestParam int priKey,
																				@RequestParam int mdAccTypeId ){
		List<TaskDetailsWithMsg> taskDetailList=new ArrayList<TaskDetailsWithMsg>();
		
		try {
			taskDetailList=taskDetailWithMsgRepo.getTaskDetailsClientProfiling(priKey, mdAccTypeId);
			System.err.println("Response From /getTaskDetailsClientProfiling Is"+"\n"+taskDetailList);
		} catch (Exception e) {
			taskDetailList=new ArrayList<TaskDetailsWithMsg>();
			System.err.println("Exception Occured!!! In Catch Block Of /getTaskDetailsClientProfiling Mappimg");
			e.printStackTrace();
			// TODO: handle exception
		}
	
	return taskDetailList;
	}
	
	
	
	
	
	
	//To Fetch Records With Client Questions AS Message By pri_key And md_acc_type_id
	@RequestMapping(value="/getTaskDetailsClientQuestions",method=RequestMethod.POST)
	public @ResponseBody List<TaskDetailsWithMsg>  getTaskDetailsClientQuestions(@RequestParam int priKey,
																				@RequestParam int mdAccTypeId ){
		List<TaskDetailsWithMsg> taskDetailList=new ArrayList<TaskDetailsWithMsg>();
		
		try {
			taskDetailList=taskDetailWithMsgRepo.getTaskDetailsClientQuestions(priKey, mdAccTypeId);
			System.err.println("Response From /getTaskDetailsClientQuestions Is"+"\n"+taskDetailList);
		} catch (Exception e) {
			taskDetailList=new ArrayList<TaskDetailsWithMsg>();
			System.err.println("Exception Occured!!! In Catch Block Of /getTaskDetailsClientQuestions Mappimg");
			e.printStackTrace();
			// TODO: handle exception
		}
	
	return taskDetailList;
	}
	
	
	
	
	//To Fetch Records With  What Went Wrong AS Message By pri_key And md_acc_type_id
	@RequestMapping(value="/getTaskDetailsClientWentWrong",method=RequestMethod.POST)
	public @ResponseBody List<TaskDetailsWithMsg>  getTaskDetailsClientWentWrong(@RequestParam int priKey,
																				@RequestParam int mdAccTypeId ){
		List<TaskDetailsWithMsg> taskDetailList=new ArrayList<TaskDetailsWithMsg>();
		
		try {
			taskDetailList=taskDetailWithMsgRepo.getTaskDetailsClientWentWrong(priKey, mdAccTypeId);
			System.err.println("Response From /getTaskDetailsClientWentWrong Is"+"\n"+taskDetailList);
		} catch (Exception e) {
			taskDetailList=new ArrayList<TaskDetailsWithMsg>();
			System.err.println("Exception Occured!!! In Catch Block Of /getTaskDetailsClientWentWrong Mappimg");
			e.printStackTrace();
			// TODO: handle exception
		}
	
	return taskDetailList;
	}
	
	//Fetch All Department Where del_status=true And is_active=true
	@RequestMapping(value="/getAllDepartment",method=RequestMethod.GET)
	public @ResponseBody List<Department> getAllDepartment(){
		List<Department> AlldeptList=new ArrayList<Department>();
		
		try {
			AlldeptList=deptRepo.getAllDepartment();
			System.err.println("Response From /getAllDepartment ="+"\n"+AlldeptList);
		} catch (Exception e) {
			AlldeptList=new ArrayList<Department>();
			System.err.println("Exception Occured!! In catch Block Of /getAllDepartment Mapping");
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return AlldeptList;
	}
	
	//To Fetch All Records From designation Where del_staus And is_active is TRUE
	@RequestMapping(value="/getAllDesignation",method=RequestMethod.GET)
	public @ResponseBody List<Designation> getAllDesignation(){
			List<Designation> AllDesignationList=new ArrayList<Designation>();
			
			try {
				AllDesignationList=designationRepo.getAllDesignation();
			} catch (Exception e) {
				AllDesignationList=new ArrayList<Designation>();
				System.err.println("Exception Occured!!! In Catch Block /getAllDesignation Mapping");
				e.printStackTrace();
				// TODO: handle exception
			}
			
			return AllDesignationList;
	}
	
	
	//Fetch All Record From m_domain_type Where del_staus And is_active = TRUE
	@RequestMapping(value="/getAllDomainTypelist",method=RequestMethod.GET)
	public @ResponseBody List<DomainType> getAllDomainTypelist(){
		List<DomainType> AllDomainTypeList=new ArrayList<DomainType>();
		try {
			AllDomainTypeList=domainTypeRepo.getAllDomainTypelist();
			System.err.println("Response From /getAllDomainTypelist ="+"\n"+AllDomainTypeList);
		} catch ( Exception e) {
			AllDomainTypeList=new ArrayList<DomainType>();
			System.err.println("Exception Occured!!! In Catch Block Of /getAllDomainTypelist Mapping ");
			e.printStackTrace();
			// TODO: handle exception
		}
		return AllDomainTypeList;
	}
	
	
	
}
