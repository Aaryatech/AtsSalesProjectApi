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
import com.ats.hrmgt.model.Info;
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
			//System.err.println("Exception Occured!!! In Catch Block Of /getAllStates Mapping");
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
	
	
	@RequestMapping(value="/getStateByStateId",method=RequestMethod.POST)
	public @ResponseBody States  getStateByStateId(@RequestParam int stateId){
		States stateResp=new States();
		
		try {
			stateResp=stateRepo.getStateById(stateId);
		} catch (Exception e) {
			// TODO: handle exception
			stateResp=new States();
			//System.err.println("Exception Occured In /getStateByStateId");
			e.printStackTrace();
		}
		
		return stateResp;
	}
	
	
	
	
	@RequestMapping(value="/EditState",method=RequestMethod.POST)
	public @ResponseBody Info EditState(@RequestParam String stateName,@RequestParam int stateId) {
		Info info=new Info();
		int Flag=0;
		
		try {
			Flag=stateRepo.EditState(stateName, stateId);
			if(Flag>0) {
				info.setError(false);
				info.setMsg("State Updated!!!");
				
			}else {
				info.setError(true);
				info.setMsg("Unable To Update State!!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			info.setError(true);
			info.setMsg("Unable To Update State Exception Occuered!");
			//System.err.println("Exception Occured In /EditState");
			e.printStackTrace();
		}
		
		
		return info;
		
	}
	
	@RequestMapping(value="/DeleteState",method=RequestMethod.POST)
	public @ResponseBody Info DeleteState(@RequestParam int stateId) {
		Info info=new Info();
		int Flag=0;
		try {
			Flag=stateRepo.DeleteState(stateId);
			if(Flag>0) {
				info.setError(false);
				info.setMsg("State Deleted!!!");
				
			}else {
				info.setError(true);
				info.setMsg("Unable To Delete State!!!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			info.setError(true);
			info.setMsg("Unable To Delete State Exception Occuered!");
			//System.err.println("Exception Occured In /DeleteState");
			e.printStackTrace();
		}
		
		
		
		return info;
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
			//System.err.println("Exception Occured!!! In Catch Block Of /getCitiesByStateId Mapping");
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

	
	
	@RequestMapping(value="/getAllCitiesListWithStateName",method=RequestMethod.GET)
	public @ResponseBody List<City> getAllCitiesListWithStateName(){
		List<City> cityListResp=new ArrayList<City>();
		
		try {
			cityListResp=cityRepo.getAllCitiesListWithStateName();
			
		} catch (Exception e) {
			// TODO: handle exception
			cityListResp=new ArrayList<City>();
			//System.err.println("Exception Ocuered In /getAllCitiesList ");
			e.printStackTrace();
		}
		
		
		
		return cityListResp;
 	}
	
		@RequestMapping(value="/getCityBycityId",method=RequestMethod.POST)
		public @ResponseBody  City getCityBycityId(@RequestParam int cityId){
			City cityResp=new City();
			
			try {
				cityResp =cityRepo.getCityBycityId(cityId);
			} catch (Exception e) {
				// TODO: handle exception
				cityResp=new City();
				//System.err.println("Exception Occuered In /getCityBycityId ");
				e.printStackTrace();
			}
		
			return cityResp;
		}
		
	
		@RequestMapping(value="/editCity",method=RequestMethod.POST)
		public @ResponseBody Info editCity(@RequestBody City city) {
			Info info=new Info();
			int flag=0;
			try {
				
				flag=cityRepo.editCity(city.getmCityId(), city.getmCityName(), city.getmStateId());
				if(flag==0) {
					info.setError(true);
					info.setMsg("Unable To Update City");
				}else {
					info.setError(false);
					info.setMsg("City Updated!!! ");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				info.setError(true);
				info.setMsg("Unable To Update City Exception Occuerred!!");
				//System.err.println("Exception Occuerred In /editCity");
				e.printStackTrace();
			}
			
			
			return info;
		}
		
		
		
		@RequestMapping(value="/DeleteCity",method=RequestMethod.POST)
		public @ResponseBody Info DeleteCity(@RequestParam int cityId){
			Info info=new Info();
			int flag=0;
			try {
				flag=cityRepo.DeleteCity(cityId);
				if(flag==0) {
					info.setError(true);
					info.setMsg("Unable To Delete City");
				}else {
					info.setError(false);
					info.setMsg("City Deleted!!! ");
				}
			} catch (Exception e) {
				// TODO: handle exception
				info.setError(true);
				info.setMsg("Unable To Delete City Exception Occuerred!!");
				//System.err.println("Exception Occuerred In /DeleteCity");
				e.printStackTrace();
			}
			
			
			return info;
			
		}
		
		
		
	
}
