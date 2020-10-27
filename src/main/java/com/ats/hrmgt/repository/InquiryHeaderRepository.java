package com.ats.hrmgt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.InquiryHeader;

public interface InquiryHeaderRepository  extends JpaRepository<InquiryHeader, Integer >{
	
	
	//To Fetch All inquiryHeader
	@Query(value="SELECT * FROM inquiry_header WHERE del_status=true AND is_active=true",nativeQuery=true)
	List<InquiryHeader> getAllInquiryHeaderList();

	
	//To Delete Inquiry Header
	@Transactional
	@Modifying
	@Query(value="UPDATE inquiry_header SET del_status=false WHERE inq_id=:inqId",nativeQuery=true)
	int deleteInquiryHeaderByInqId(@Param("inqId") Integer inqId);
	
	
}
