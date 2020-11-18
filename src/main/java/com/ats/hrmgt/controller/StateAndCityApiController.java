package com.ats.hrmgt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.model.Channel;
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

	// To Fetch List Of States Where del_status And is_active =1
	@RequestMapping(value = "/getAllStates", method = RequestMethod.GET)
	public @ResponseBody List<States> getAllStates() {
		List<States> stateList = new ArrayList<States>();

		try {
			stateList = stateRepo.getAllStates();
		} catch (Exception e) {
			// TODO: handle exception
			stateList = new ArrayList<States>();
			System.err.println("Exception Occured!!! In Catch Block Of /getAllStates Mapping");
			e.printStackTrace();
		}

		return stateList;

	}

	@RequestMapping(value = "/getByStateName", method = RequestMethod.POST)
	public @ResponseBody States getAllStates(@Param("stateName") String stateName) {
		States stateList = new States();

		try {
			stateList = stateRepo.findByStateName(stateName);
			if (stateList == null) {
				stateList = new States();
			}
		} catch (Exception e) {
			stateList = new States();
			e.printStackTrace();
		}

		return stateList;

	}

	@RequestMapping(value = "/saveState", method = RequestMethod.POST)
	public @ResponseBody States saveChannel(@RequestBody States states) {
		States res = new States();

		try {
			res = stateRepo.save(states);

		} catch (Exception e) {
			res = new States();
			e.printStackTrace();
		}

		return res;

	}

	// To Fetch List Of Cities Using State Id
	@RequestMapping(value = "/getCitiesByStateId", method = RequestMethod.POST)
	public @ResponseBody List<City> getCitiesByStateId(@RequestParam int stateId) {
		List<City> cityList = new ArrayList<City>();

		try {
			cityList = cityRepo.getCitiesByStateId(stateId);
		} catch (Exception e) {
			// TODO: handle exception
			cityList = new ArrayList<City>();
			System.err.println("Exception Occured!!! In Catch Block Of /getCitiesByStateId Mapping");
			e.printStackTrace();
		}

		return cityList;

	}

	@RequestMapping(value = "/getCitiesByCityName", method = RequestMethod.POST)
	public @ResponseBody City getCitiesByCityName(@RequestParam String cityName) {
		City cityList = new City();

		try {
			cityList = cityRepo.getCitiesByCityName(cityName);
			if (cityList == null) {
				cityList = new City();
			}

		} catch (Exception e) {
			cityList = new City();
			e.printStackTrace();
		}

		return cityList;

	}

	@RequestMapping(value = "/saveCity", method = RequestMethod.POST)
	public @ResponseBody City getCitiesByStateId(@RequestBody City city) {
		City res = new City();

		try {
			res = cityRepo.save(city);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return res;

	}

}
