package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.InquiryDetail;

public interface InquiryDetailRepository extends JpaRepository<InquiryDetail, Integer> {
	
	
	//Fetch inquiry Detail Using inq_id
	@Query(value="SELECT * FROM inquiry_detail WHERE inq_id=:inqId AND del_status=1" ,nativeQuery=true)
	List<InquiryDetail> getInqDeatilById(@Param("inqId") int inqId);

}
