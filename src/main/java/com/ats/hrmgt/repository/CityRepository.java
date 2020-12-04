package com.ats.hrmgt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.City;

public interface CityRepository  extends JpaRepository<City, Integer>{
	
	
	
	//To Fetch List Of Cities Where del_status And is_active =1 With State Name As ex_var1
	@Query(value="SELECT\n" + 
			"    c.m_city_id,\n" + 
			"    c.m_state_id,\n" + 
			"    c.m_city_name,\n" + 
			"    c.del_status,\n" + 
			"    c.is_active,\n" + 
			"    c.ex_int1,\n" + 
			"    c.ex_int2,\n" + 
			"    c.ex_var2,\n" + 
			"    s.m_state_name AS ex_var1\n" + 
			"FROM\n" + 
			"    m_city c,\n" + 
			"    m_states s\n" + 
			"WHERE\n" + 
			"    c.m_state_id = s.m_state_id AND c.del_status = 1 AND c.is_active = 1",nativeQuery=true)
	List<City> getAllCitiesListWithStateName();
	
	//To Fetch Single City Using CityId
	@Query(value="SELECT * FROM m_city WHERE del_status=1 AND is_active=1 AND m_city_id=:cityId",nativeQuery=true)
	City getCityBycityId(@Param("cityId") int cityId);
	
	
	
	//To Fetch List Of Cities Using State Id
	@Query(value="SELECT * FROM m_city WHERE del_status=1 AND is_active=1 AND m_state_id=:stateId",nativeQuery=true)
	List<City> getCitiesByStateId(@Param("stateId") int stateId);

	
	//To Fetch List Of Cities Using City Name 
	@Query(value="SELECT * FROM m_city WHERE m_city_name=:cityName",nativeQuery=true)
	City getCitiesByCityName(String cityName);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_city SET m_city_name=:cityName,m_state_id=:stateId WHERE m_city_id=:cityId",nativeQuery=true)
	int editCity(@Param("cityId") int cityId,@Param("cityName") String cityName,@Param("stateId") int stateId);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_city SET del_status=false WHERE m_city_id=:cityId",nativeQuery=true)
	int DeleteCity(@Param("cityId") int cityId);
	
	
	

}
