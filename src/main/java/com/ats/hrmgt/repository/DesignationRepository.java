package com.ats.hrmgt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ats.hrmgt.model.Designation;
import com.ats.hrmgt.model.Info;

public interface DesignationRepository 	extends JpaRepository<Designation, Integer> {
	
	
	//To Fetch All Records From designation Where del_staus And is_active is TRUE
	@Query(value="SELECT * FROM  m_designation WHERE del_status=true AND is_active=true",nativeQuery=true)
	List<Designation> getAllDesignation();

	@Query(value="SELECT * FROM  m_designation WHERE m_designation_name=:desigName",nativeQuery=true)
	Designation getDesignationBydesName(@Param("desigName") String desigName);
	
	@Query(value="SELECT * FROM m_designation WHERE m_designation_id=:desgId AND del_status=true AND is_active=true",nativeQuery=true)
	Designation getDesignationByIdAndDelstatus(@Param("desgId") int desgId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_designation SET m_designation_name=:desgName WHERE m_designation_id=:desgId AND del_status=true AND is_active=true ",nativeQuery=true)
	int editDesignation(@Param("desgId") int desgId,@Param("desgName") String desgName);
	
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_designation SET del_status=false,maker_user_id=:makerId,maker_datetime=:makerDtTime  WHERE m_designation_id=:desgId",nativeQuery=true)
	int deleteDesignation(@Param("desgId") int desgId,@Param("makerId") int makerId,@Param("makerDtTime") String makerDtTime);
	
	
	  

}
