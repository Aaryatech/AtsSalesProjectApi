package com.ats.hrmgt.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.CustInfo;

public interface CustInfoRepo extends JpaRepository<CustInfo, Integer> {

	@Query(value="select lms_id as id,acc_company as comp_name,customer_name as cust_name,acc_company_landline as contact, "
			+ "acc_website as link from lms_header where lms_id=:primaryKey",nativeQuery=true)
	CustInfo getCustInfoLms(int primaryKey);

	@Query(value="select inq_id as id,inq_company as comp_name,'' as cust_name,inq_company_landline as contact, "
			+ "inq_website as link from inquiry_header where inq_id=:primaryKey",nativeQuery=true)
	CustInfo getCustInfoInq(int primaryKey);

}
