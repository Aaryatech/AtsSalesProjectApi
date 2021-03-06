package com.ats.hrmgt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.LmsHeader;
import com.ats.hrmgt.model.LmsHeaderWithNames;

public interface LmsHeaderRepository extends JpaRepository<LmsHeader, Integer> {

	// To Delete Lms Header Using Lms ID
	@Transactional
	@Modifying
	@Query(value = "UPDATE lms_header SET del_status=false WHERE lms_id=:lmsId", nativeQuery = true)
	int deleteLmsHeader(@Param("lmsId") int lmsId);

	// Fetch Lms Header By lms_id And del_status ,is_active is True
	@Query(value = "SELECT * FROM lms_header WHERE lms_id=:lmsId", nativeQuery = true)
	LmsHeader getLmsHeaderByLmsId(@Param("lmsId") int lmsId);

	@Query(value = "SELECT * FROM lms_header WHERE acc_company=:compName", nativeQuery = true)
	LmsHeader checkCompanyName(String compName);

	@Query(value = "select ifnull(max(acc_code),0) as maxnum from lms_header where md_acc_type_id=:type", nativeQuery = true)
	int getmaxcount(int type);

	@Transactional
	@Modifying
	@Query(value = "UPDATE lms_header SET acc_code=:maxcount WHERE lms_id=:lmsId", nativeQuery = true)
	int updateAccCodeInLms(int maxcount, String lmsId);



	@Query(value="SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    lms_header\n" + 
			"WHERE\n" + 
			"    maker_user_id =:userId AND maker_datetime like %:cDate% AND del_status = 1 AND is_active = 1",nativeQuery=true)
	List<LmsHeader> getLmsByUserIdAndDate(@Param("userId") int userId,@Param("cDate") String cDate);



}
