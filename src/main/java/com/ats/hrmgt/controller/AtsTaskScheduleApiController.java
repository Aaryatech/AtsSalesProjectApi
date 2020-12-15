package com.ats.hrmgt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.model.AtsTAskScheduleWithNames;
import com.ats.hrmgt.model.AtsTaskSchedule;
import com.ats.hrmgt.model.Info;
import com.ats.hrmgt.repository.AtsTAskScheduleWithNamesRepository;
import com.ats.hrmgt.repository.AtsTaskScheduleRepository;

@RestController
@Scope("session")
public class AtsTaskScheduleApiController {

	@Autowired
	AtsTaskScheduleRepository AtsTaskScheduleRepo;
	
	
	@Autowired
	AtsTAskScheduleWithNamesRepository atsTaskWithNAmesRepo;
	
	
	
	@RequestMapping(value="/getAllAtsTaskSchedule",method=RequestMethod.GET)
	public @ResponseBody List<AtsTaskSchedule> getAllAtsTaskSchedule(){
		List<AtsTaskSchedule> atsTaskList=new ArrayList<AtsTaskSchedule>();
		
		try {
			atsTaskList=AtsTaskScheduleRepo.getAllAtsTaskSchedule();
			if(atsTaskList.size()==0) {
				System.err.println("No Record Found In ats_task_schedule");
				atsTaskList=new ArrayList<AtsTaskSchedule>();
			}
		} catch (Exception e) {
			// TODO: handle exception
			atsTaskList=new ArrayList<AtsTaskSchedule>();
			System.err.println("Exception Occured!!! In Catch Block Of /getAllAtsTaskSchedule Mapping ");
			e.printStackTrace();
		}
		
		return atsTaskList;
		
	}
	
	@RequestMapping(value="/saveAtsTask",method=RequestMethod.POST)
	public @ResponseBody AtsTaskSchedule saveAtsTask(@RequestBody AtsTaskSchedule atsTask) {
		//Info info=new Info();
		AtsTaskSchedule flag ;
		try {
			flag=AtsTaskScheduleRepo.save(atsTask);
			if(flag.getAtsTaskId()==0) {
				//info.setError(true);
				//info.setMsg("Unable To Save Record Please Try Later");
				flag= new AtsTaskSchedule();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			//info.setError(true);
			//info.setMsg("Exception Occur Unable To Save New Record");
			flag= new AtsTaskSchedule();
			System.err.println("Exception Occured!!! In Catch Block Of /saveAtsTask Mapping");
			e.printStackTrace();
		}
		
		
		
		return flag;
	}
	
	
	
	//To Delete Ats TAsk Using Ats Task Id 
	@RequestMapping(value="/deleteAtsTask",method=RequestMethod.POST)
	public @ResponseBody Info deleteAtsTask(@RequestParam int atsTaskId) {
		Info info= new Info();
		int flag=0;
		try {
			flag= AtsTaskScheduleRepo.deleteAtsTask(atsTaskId);
				if(flag==0) {
					info.setError(true);
					info.setMsg("Unable To Delete Ats Task");
				}else {
					info.setError(false);
					info.setMsg("Ats Task Deleted SuccessFully!!!");
				}
			} catch (Exception e) {
			// TODO: handle exception
				info.setError(true);
				info.setMsg("Exception Occured Unable To Delete Ats Task");
				System.err.println("Exception Occured!!! In CAtch Block Of /@deleteAtsTask Mapping ");
		}
		
		return info;
		
	}
	
	
	
	//To Fetch Single Record Using atsTaskId
	@RequestMapping(value="/getAtsTaskById",method=RequestMethod.POST)
	public @ResponseBody AtsTaskSchedule getAtsTaskById(@RequestParam int atsTaskId) {
		AtsTaskSchedule atsTaskResp=new AtsTaskSchedule();
		
		try {
			atsTaskResp=AtsTaskScheduleRepo.getAtsTaskById(atsTaskId);
			if(atsTaskResp==null) {
				System.err.println("No Record Found!!!");
				atsTaskResp=new AtsTaskSchedule();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			atsTaskResp=new AtsTaskSchedule();
			System.err.println("Exception Occured!!! In Catch Block Of /getAtsTaskById Mapping");
			e.printStackTrace();
		}
		
		return atsTaskResp;
	}
	
	
	
	
	
	
	@RequestMapping(value="/getAllAtsTaskScheduleWithNames",method=RequestMethod.GET)
	public @ResponseBody List<AtsTAskScheduleWithNames> getAllAtsTaskScheduleWithNames(){
		List<AtsTAskScheduleWithNames> atsTaskList=new ArrayList<AtsTAskScheduleWithNames>();
		
		try {
			atsTaskList=atsTaskWithNAmesRepo.getAllAtsTAskScheduleWithNames();
			if(atsTaskList.size()==0) {
				System.err.println("No Record Found In ats_task_schedule");
				atsTaskList=new ArrayList<AtsTAskScheduleWithNames>();
			}
		} catch (Exception e) {
			// TODO: handle exception
			atsTaskList=new ArrayList<AtsTAskScheduleWithNames>();
			System.err.println("Exception Occured!!! In Catch Block Of /getAllAtsTaskSchedule Mapping ");
			e.printStackTrace();
		}
		
		return atsTaskList;
		
	}
	
	
}
