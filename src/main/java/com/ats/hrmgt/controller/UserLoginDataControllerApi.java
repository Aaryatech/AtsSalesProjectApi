package com.ats.hrmgt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.model.Employee;
import com.ats.hrmgt.model.Info;
import com.ats.hrmgt.model.Tags;
import com.ats.hrmgt.model.UserLoginData;
import com.ats.hrmgt.repository.EmployeeRepository;
import com.ats.hrmgt.repository.TagsRepository;
import com.ats.hrmgt.repository.UserLoginDataRepository;

@RestController
public class UserLoginDataControllerApi {
	
	@Autowired
	UserLoginDataRepository userLoginRepo;
	
	@Autowired	
	EmployeeRepository empRepo;
	

	@RequestMapping(value="/getUserByUsernameAndPassword",method=RequestMethod.POST)
	public @ResponseBody UserLoginData getUserByUsernameAndPAssword(@RequestParam String userName,
																		@RequestParam String password) {
		try {
			return userLoginRepo.getUserByUsernameAndPAssword(userName, password); 
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception In Catch Block Of Restcontrollers /getUserByUsernameAndPassword mapping");
			e.printStackTrace();
			return null;
		}
	
		
	}
	
	
	@RequestMapping(value="/findEmployeeByUsername",method=RequestMethod.POST)
	public @ResponseBody Employee findEmployeeByUsername(@RequestParam String userName) {
		Employee empResp=new Employee();
		
		try {
			empResp=empRepo.findEmployeeByUsername(userName);
		} catch (Exception e) {
			// TODO: handle exception
			empResp=new Employee();
			System.err.println("Exception Occured!!! In Catch Block Of /findEmployeeByUsername Mapping.");
			e.printStackTrace();
		}
		
		return empResp;
		
	}

	
	@RequestMapping(value="/resetPassword",method=RequestMethod.POST)
	public @ResponseBody Info resetPassword(@RequestParam int empId,@RequestParam String passWord) {
	Info info=new Info();
	int flag=0;
	try {
		flag=empRepo.resetPassword(empId, passWord);
		if(flag>0) {
			info.setError(false);
			info.setMsg("Password Changed Successfully");
			
		}else {
			info.setError(true);
			info.setMsg("Unable To Change Password");
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		info.setError(true);
		info.setMsg("Exception Occoerd In /resetPassword Mapping");
		System.err.println("Exception Occoerd In /resetPassword Mapping");
		e.printStackTrace();
	}
	
	return info;
	
	}


	
	
}
