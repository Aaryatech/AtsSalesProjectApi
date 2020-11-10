package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
	
	
	
	
}
