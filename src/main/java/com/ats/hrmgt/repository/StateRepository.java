package com.ats.hrmgt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.States;

public interface StateRepository extends JpaRepository<States, Integer> {
	
	//To Fetch List Of States Where del_status And is_active  =1
	@Query(value="SELECT * FROM m_states WHERE del_status=1 AND is_active=1",nativeQuery=true)
	List<States> getAllStates();

	
	//To Fetch Single State By m_state_id And Where  del_status And is_active =1
	@Query(value="SELECT * FROM m_states WHERE del_status=1 AND is_active=1 AND m_state_id=:stateId",nativeQuery=true)
	States getStateById(@Param("stateId") int stateId);


	@Query(value="SELECT * FROM m_states WHERE m_state_name=:stateName",nativeQuery=true)
	States findByStateName(String stateName);
	
	//To Update State Name
	@Transactional
	@Modifying
	@Query(value="UPDATE m_states SET m_state_name=:stateName WHERE  m_state_id=:stateId",nativeQuery=true)
	int EditState(@Param("stateName") String stateName,@Param("stateId") int stateId);
	
	
	//To Delete State
	@Transactional
	@Modifying
	@Query(value="UPDATE m_states SET del_status=false WHERE  m_state_id=:stateId",nativeQuery=true)
	int DeleteState(@Param("stateId") int stateId);
	
	
	
	
	
	
}
