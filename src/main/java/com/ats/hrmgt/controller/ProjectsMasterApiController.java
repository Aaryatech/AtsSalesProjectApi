package com.ats.hrmgt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.model.Info;
import com.ats.hrmgt.model.ProjectsMaster;
import com.ats.hrmgt.model.ServerMaster;
import com.ats.hrmgt.repository.ProjectMasterRepository;

@RestController
public class ProjectsMasterApiController {
	
	@Autowired
	ProjectMasterRepository projMstRepo;
	
	
	@RequestMapping(value="/getAllProjectsList",method=RequestMethod.GET)
	public @ResponseBody List<ProjectsMaster> getAllProjectsList(){
		List<ProjectsMaster> projctsList=new ArrayList<>();
		
		try {
			projctsList=projMstRepo.getAllProjectList();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occuered In /getAllProjectsList");
			e.printStackTrace();
		}
		
		return projctsList;
	}
	
	
	
	@RequestMapping(value="/addProject",method=RequestMethod.POST)
	public @ResponseBody ProjectsMaster addProject(@RequestBody ProjectsMaster project) {
		ProjectsMaster projectResp=new ProjectsMaster();
		
		try {
			projectResp=projMstRepo.save(project);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occuered In /addProject");
			e.printStackTrace();
		}
		
		return projectResp;
	}
	
	@RequestMapping(value="/deleteProject",method=RequestMethod.POST)
	public @ResponseBody Info deleteProject(@RequestParam int pId) {
		Info info=new Info();
		int flag=0;
		
		
		try {
			flag=projMstRepo.deleteProject(pId);
			if(flag==0) {
				info.setError(true);
				info.setMsg("Unable To Delete Project");
			}else {
				info.setError(false);
				info.setMsg("Project Deleted");
			}
		} catch (Exception e) {
			// TODO: handle exception
			info.setError(true);
			info.setMsg("Unable To Delete Project Exception Occuered");
			System.err.println("Exception Occuered In /deleteProject");
			e.printStackTrace();
		}
		return info;
	}
	
	
	@RequestMapping(value="/getProjectById",method=RequestMethod.POST)
	public @ResponseBody ProjectsMaster getProjectById(@RequestParam int pId) {
		ProjectsMaster projResp=new ProjectsMaster();
		
		try {
			projResp=projMstRepo.getProjectById(pId);
			if(projResp==null) {
				projResp=new ProjectsMaster();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occuered In /getProjectById");
			e.printStackTrace();
		}
		return projResp;
	}
	
	
	
	
	

}
