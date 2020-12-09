package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ats.hrmgt.model.CityWiseDetailReport;

public interface CityWiseDetailReportRepository extends JpaRepository<CityWiseDetailReport, String> {
	
	
	
	@Query(value="SELECT\n" + 
			"    UUID() AS id, \n" + 
			"    a.m_city_id,\n" + 
			"    COALESCE(a.m_city_name, 0) AS m_city_name,\n" + 
			"    COALESCE(b.customer_name, 0) AS customer_name,\n" + 
			"    COALESCE(b.acc_company, 0) AS acc_company,\n" + 
			"    COALESCE(c.cp_name, 0) AS cp_name,\n" + 
			"    COALESCE(c.cp_mobile, 0) AS cp_mobile,\n" + 
			"    COALESCE(c.cp_email, 0) AS cp_email\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        *\n" + 
			"    FROM\n" + 
			"        m_city\n" + 
			"    WHERE\n" + 
			"        del_status = 1\n" + 
			") a\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT lms_id,\n" + 
			"        m_city_id,\n" + 
			"        customer_name,\n" + 
			"        acc_company\n" + 
			"    FROM\n" + 
			"        lms_header\n" + 
			"    WHERE\n" + 
			"        del_status = 1 AND maker_datetime BETWEEN :fromDate AND :toDate\n" + 
			") b\n" + 
			"ON\n" + 
			"    b.m_city_id = a.m_city_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT lms_id,\n" + 
			"        cp_name,\n" + 
			"        cp_mobile,\n" + 
			"        cp_email\n" + 
			"    FROM\n" + 
			"        lms_detail\n" + 
			"    WHERE\n" + 
			"        del_status = 1\n" + 
			") c\n" + 
			"ON\n" + 
			"    b.lms_id = c.lms_id\n" + 
			"ORDER BY m_city_name ASC,acc_company",nativeQuery=true)
	List<CityWiseDetailReport> getAllCityWiseDetailLeadReport(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
	
	@Query(value="SELECT\n" + 
			"    UUID() AS id, \n" + 
			"    a.m_city_id,\n" + 
			"    COALESCE(a.m_city_name, 0) AS m_city_name,\n" + 
			"    COALESCE(b.inquiry_tittle, 0) AS customer_name,\n" + 
			"    COALESCE(b.inq_company, 0) AS acc_company,\n" + 
			"    COALESCE(c.cp_name, 0) AS cp_name,\n" + 
			"    COALESCE(c.cp_mobile, 0) AS cp_mobile,\n" + 
			"    COALESCE(c.cp_email, 0) AS cp_email\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        *\n" + 
			"    FROM\n" + 
			"        m_city\n" + 
			"    WHERE\n" + 
			"        del_status = 1\n" + 
			") a\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT inq_id,\n" + 
			"        m_city_id,\n" + 
			"        inquiry_tittle,\n" + 
			"        inq_company\n" + 
			"    FROM\n" + 
			"       inquiry_header\n" + 
			"    WHERE\n" + 
			"        del_status = 1 AND maker_datetime BETWEEN :fromDate AND :toDate\n" + 
			") b\n" + 
			"ON\n" + 
			"    b.m_city_id = a.m_city_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT inq_id,\n" + 
			"        cp_name,\n" + 
			"        cp_mobile,\n" + 
			"        cp_email\n" + 
			"    FROM\n" + 
			"        inquiry_detail\n" + 
			"    WHERE\n" + 
			"        del_status = 1\n" + 
			") c\n" + 
			"ON\n" + 
			"    b.inq_id = c.inq_id\n" + 
			"ORDER BY m_city_name ASC,acc_company",nativeQuery=true)
	List<CityWiseDetailReport> getAllCityWiseDetailInqReport(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
	
	
}
