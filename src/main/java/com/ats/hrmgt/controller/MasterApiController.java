package com.ats.hrmgt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.model.Channel;
import com.ats.hrmgt.model.Employee;
import com.ats.hrmgt.model.Tags;
import com.ats.hrmgt.model.TaskStatus;
import com.ats.hrmgt.repository.ChannelRepository;
import com.ats.hrmgt.repository.EmployeeRepository;
import com.ats.hrmgt.repository.TagsRepository;
import com.ats.hrmgt.repository.TaskStatusRepository;

@RestController
public class MasterApiController {

	
	
	@Autowired
	TagsRepository tagsRepo;	
	
	
	@Autowired
	TaskStatusRepository taskStatusRepo;
	
	
	@Autowired
	ChannelRepository channelRepo;
	
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	
	//To Fetch All Tags By m_acc_type_id Where del_status & is_active Status is True
	@RequestMapping(value="/getTagBymAccTypeId",method=RequestMethod.POST)
	public @ResponseBody List<Tags> getTagBymAccTypeId(@RequestParam int mAccTypeId){
		List<Tags> tagResponse=new ArrayList<Tags>();
		try {
			tagResponse=tagsRepo.getTagBymAccTypeId(mAccTypeId);
		} catch (Exception e) {
			// TODO: handle exception
			tagResponse=new ArrayList<Tags>();
			System.err.println("Some Exception Occurs In Catch Block Of /getTagBymAccTypeId Mapping");
			e.printStackTrace();
		}
		
		
		
		return tagResponse;
	}
	
	//To Fetch All Tags Where del_status And is_active Is True
	@RequestMapping(value="/getAllTagsList",method=RequestMethod.POST)
	public @ResponseBody List<Tags> getAllTagsList(){
		List<Tags> tagResponse=new ArrayList<Tags>();
		try {
			tagResponse=tagsRepo.getAllTagsList();
		} catch (Exception e) {
			// TODO: handle exception
			tagResponse=new ArrayList<Tags>();
			System.err.println("Exception Occurs In Catch Block Of /getAllTagsList Mapping");
			e.printStackTrace();
		}
		
		
		return tagResponse;
		
	}
	
	
	
	
	//To Fetch List Of All TaskStatus Where del_status And is_active Is True
	@RequestMapping(value="/getAllTaskStatusList",method=RequestMethod.POST)
	public @ResponseBody List<TaskStatus>  getAllTaskStatusList(){
		List<TaskStatus> taskStatuslistResp=new ArrayList<TaskStatus>();
		
		try {
			taskStatuslistResp=taskStatusRepo.getAllTaskStatusList();
			System.err.println("Response For  getAllTaskStatusList Is"+"\n"+taskStatuslistResp);
		} catch (Exception e) {
			// TODO: handle exception
			taskStatuslistResp=new ArrayList<TaskStatus>();
			System.err.println("Exception Occurs!!!  In Catch Block Of /getAllTaskStatusList  Mapping");
			e.printStackTrace();
		}
			return taskStatuslistResp;
	}
	
	
	
	//To Fetch Records From Task Status By  m_acc_type_id Where del_status And is_active Status is True
	@RequestMapping(value="/getAllTaskStatusBymdAccTypeId",method=RequestMethod.POST)
	public @ResponseBody List<TaskStatus> getAllTaskStatusBymdAccTypeId(@RequestParam int mdAccTypeId){
		List<TaskStatus> BymdAccTypeIdResp=new ArrayList<TaskStatus>();
		//System.err.println("m_acc_type_id="+mAccTypeId);
		try {
			BymdAccTypeIdResp=taskStatusRepo.getAllTaskStatusBymdAccTypeId(mdAccTypeId);
			System.err.println("Response For  /getAllTaskStatusByMaccTypeId Is"+"\n"+BymdAccTypeIdResp);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occur!!! In Catch Block Of /getAllTaskStatusBymdAccTypeId Mapping");
			BymdAccTypeIdResp=new ArrayList<TaskStatus>();
			e.printStackTrace();
		}
		
		
		
		return BymdAccTypeIdResp;
	}
	
	
	
	//Fetch All Records From Channeel Where del_status And is_active Is True
	@RequestMapping(value="/getAllChannelList",method=RequestMethod.POST )
	public @ResponseBody List<Channel> getAllChannelList(){
		List<Channel> allChannelList=new ArrayList<Channel>();
		
		
		try {
			allChannelList=channelRepo.getAllChannelList();
			System.err.println("Response Of /getAllChannelList is"+"\n"+allChannelList);
		} catch (Exception e) {
			// TODO: handle exception
			allChannelList=new ArrayList<Channel>();
			System.err.println("Exception Occured!!! In Catch Block Of /getAllChannelList Mapping");
			e.printStackTrace();
		}
		
		
		return allChannelList;
		
	}
	
	
	
	
	
	//To Fetch All Records From m_employee Where del_status And is_active Is True
	@RequestMapping(value="/getAllEmployeeList",method=RequestMethod.POST)
	public @ResponseBody List<Employee> getAllEmployeeList(){
		List<Employee> AllEmployeeRsp=new ArrayList<Employee>();
		
		try {
			AllEmployeeRsp=empRepo.getAllEmployeeList();
			System.err.println("Response Of /getAllEmployeeList Is"+"\n"+AllEmployeeRsp);
		} catch (Exception e) {
			// TODO: handle exception
			AllEmployeeRsp=new ArrayList<Employee>();
			System.err.println("Exception Occured!!! In Catch Block Of /getAllEmployeeList Mapping");
			e.printStackTrace();
		}
		
		
		
		
		return AllEmployeeRsp;
	}
	
	
	
	
	//To Find Record Where md_acc_type_id Is Matched(Using FIND_IN_SET)
	@RequestMapping(value="/findEmployeeBymdAccTypeId",method=RequestMethod.POST)
	public @ResponseBody List<Employee>  findEmployeeBymdAccTypeId(@RequestParam String mdAccTypeId){
		List<Employee> EmpListByAccTypeId=new ArrayList<Employee>();
		
		try {
				EmpListByAccTypeId=empRepo.findEmployeeBymdAccTypeId(mdAccTypeId);
				System.err.println("Response From /findEmployeeBymdAccTypeId Is"+"\n"+EmpListByAccTypeId);
		} catch (Exception e) {
			// TODO: handle exception
			EmpListByAccTypeId=new ArrayList<Employee>();
			System.err.println("Exception Occuered!!! In Catch Block Of /findEmployeeBymdAccTypeId Mapping");
			e.printStackTrace();
		}
		
		
		return EmpListByAccTypeId;
		
	}
	
	
	
}
