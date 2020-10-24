package com.ats.hrmgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.model.Tags;
import com.ats.hrmgt.model.UserLoginData;
import com.ats.hrmgt.repository.TagsRepository;
import com.ats.hrmgt.repository.UserLoginDataRepository;

@RestController
public class UserLoginDataControllerApi {
	
	@Autowired
	UserLoginDataRepository userLoginRepo;
	

	
	

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
	

	

	
	
	
}
