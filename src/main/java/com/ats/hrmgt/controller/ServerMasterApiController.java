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
import com.ats.hrmgt.model.ServerMaster;
import com.ats.hrmgt.repository.ServerMasterRepository;


//Akhilesh 2020-12-26
@RestController
public class ServerMasterApiController {
	
	
	@Autowired
	ServerMasterRepository serverRepo;
	
	
	
	
	@RequestMapping(value="/getAllServerList",method=RequestMethod.GET)
	public @ResponseBody List<ServerMaster> getAllServerList(){
		List<ServerMaster> serverList=new ArrayList<>();
		
		try {
			serverList=serverRepo.getAllServerList();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occuered In /getAllServerList");
			e.printStackTrace();
		}
		
		return serverList;
	}
	
	
	
	@RequestMapping(value="/addServer",method=RequestMethod.POST)
	public @ResponseBody ServerMaster addServer(@RequestBody ServerMaster server) {
		ServerMaster serverResp=new ServerMaster();
		
		try {
			serverResp=serverRepo.save(server);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occuered In /addServer");
			e.printStackTrace();
		}
		
		return serverResp;
	}
	
	@RequestMapping(value="/deleteServer",method=RequestMethod.POST)
	public @ResponseBody Info deleteServer(@RequestParam int sId) {
		Info info=new Info();
		int flag=0;
		
		
		try {
			flag=serverRepo.deleteServer(sId);
			if(flag==0) {
				info.setError(true);
				info.setMsg("Unable To Delete Server");
			}else {
				info.setError(false);
				info.setMsg("Server Deleted");
			}
		} catch (Exception e) {
			// TODO: handle exception
			info.setError(true);
			info.setMsg("Unable To Delete Server Exception Occuered");
			System.err.println("Exception Occuered In /deleteServer");
			e.printStackTrace();
		}
		return info;
	}
	
	
	@RequestMapping(value="/getServerById",method=RequestMethod.POST)
	public @ResponseBody ServerMaster getServerById(@RequestParam int sId) {
		ServerMaster serverResp=new ServerMaster();
		
		try {
			serverResp=serverRepo.getServerById(sId);
			if(serverResp==null) {
				serverResp=new ServerMaster();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occuered In /getServerById");
			e.printStackTrace();
		}
		return serverResp;
	}
	
	
	
	
	
	
	
	
	

}
