package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.Designation;

public interface DesignationRepository 	extends JpaRepository<Designation, Integer> {
	
	
	//To Fetch All Records From designation Where del_staus And is_active is TRUE
	@Query(value="SELECT * FROM  m_designation WHERE del_status=true AND is_active=true",nativeQuery=true)
	List<Designation> getAllDesignation();
	
	
	

}
