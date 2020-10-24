package com.ats.hrmgt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.model.Tags;
import com.ats.hrmgt.model.TaskStatus;
import com.ats.hrmgt.repository.TagsRepository;
import com.ats.hrmgt.repository.TaskStatusRepository;

@RestController
public class MasterApiController {

	
	
	@Autowired
	TagsRepository tagsRepo;	
	
	@Autowired
	TaskStatusRepository taskStatusRepo;
	
	
	
	
	
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
	
	
	
	
}
