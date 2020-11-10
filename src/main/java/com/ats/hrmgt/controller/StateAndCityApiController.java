package com.ats.hrmgt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.model.City;
import com.ats.hrmgt.model.States;
import com.ats.hrmgt.repository.CityRepository;
import com.ats.hrmgt.repository.StateRepository;

@RestController
public class StateAndCityApiController {

	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;
	
	
	//To Fetch List Of States Where del_status And is_active  =1
	@RequestMapping(value="/getAllStates",method=RequestMethod.GET)
	public @ResponseBody List<States> getAllStates(){
		List<States> stateList=new ArrayList<States>();
		
		try {
			stateList=stateRepo.getAllStates();
		} catch (Exception e) {
			// TODO: handle exception
			stateList=new ArrayList<States>();
			System.err.println("Exception Occured!!! In Catch Block Of /getAllStates Mapping");
			e.printStackTrace();
		}
		
		
		return stateList;
		
	}
	
	
	
	//To Fetch List Of Cities Using State Id
	@RequestMapping(value="/getCitiesByStateId",method=RequestMethod.POST)
	public @ResponseBody List<City> getCitiesByStateId(@RequestParam int stateId){
		List<City> cityList=new ArrayList<City>();
		
		try {
			cityList=cityRepo.getCitiesByStateId(stateId);
		} catch (Exception e) {
			// TODO: handle exception
			cityList=new ArrayList<City>();
			System.err.println("Exception Occured!!! In Catch Block Of /getCitiesByStateId Mapping");
			e.printStackTrace();
		}
		
		return cityList;
		
	}
	
	
	
	
	
}
