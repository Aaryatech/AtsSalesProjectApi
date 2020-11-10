package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.City;

public interface CityRepository  extends JpaRepository<City, Integer>{
	
	
	
	//To Fetch List Of Cities Where del_status And is_active =1
	@Query(value="SELECT * FROM m_city WHERE del_status=1 AND is_active=1",nativeQuery=true)
	List<City> getAllCitiesList();
	
	//To Fetch Single City Using CityId
	@Query(value="SELECT * FROM m_city WHERE del_status=1 AND is_active=1 AND m_city_id=:cityId",nativeQuery=true)
	City getCityBycityId(@Param("cityId") int cityId);
	
	
	
	//To Fetch List Of Cities Using State Id
	@Query(value="SELECT * FROM m_city WHERE del_status=1 AND is_active=1 AND m_state_id=:stateId",nativeQuery=true)
	List<City> getCitiesByStateId(@Param("stateId") int stateId);
	

}
