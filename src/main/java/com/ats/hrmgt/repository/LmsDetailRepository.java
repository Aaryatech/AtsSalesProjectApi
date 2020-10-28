package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.LmsDetail;

public interface LmsDetailRepository extends JpaRepository<LmsDetail, Integer> {
	
	
	
	//Fetch Records By Lms Id
	@Query(value="SELECT * FROM lms_detail WHERE lms_id=:lmsId and del_status=1",nativeQuery=true)
	List<LmsDetail> getLmsDetailByLmsId(@Param("lmsId") int lmsId);
	

}
