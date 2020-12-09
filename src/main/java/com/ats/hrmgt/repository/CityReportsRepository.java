package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.CityReports;

public interface CityReportsRepository extends JpaRepository<CityReports, Integer>{
	
	
@Query(value="SELECT\n" + 
		"    a.m_city_id,\n" + 
		"    a.m_state_id,\n" + 
		"    COALESCE(a.m_city_name, 0) AS m_city_name,\n" + 
		"	 COALESCE(b.city_lead_count, 0) AS city_lead_count,\n" + 
		"      COALESCE(c.city_inq_count, 0) AS city_inq_count\n" + 
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
		"    SELECT m_city_id,\n" + 
		"        COUNT('') AS city_lead_count\n" + 
		"    FROM\n" + 
		"        lms_header\n" + 
		"    WHERE\n" + 
		"        del_status = 1 AND maker_datetime BETWEEN :fromDate AND :toDate\n" + 
		"    GROUP BY\n" + 
		"        m_city_id\n" + 
		") b\n" + 
		"ON\n" + 
		"    b.m_city_id = a.m_city_id\n" + 
		"    LEFT JOIN(\n" + 
		"    SELECT m_city_id,\n" + 
		"        COUNT('') AS city_inq_count\n" + 
		"    FROM\n" + 
		"        inquiry_header\n" + 
		"    WHERE\n" + 
		"        del_status = 1 AND maker_datetime BETWEEN :fromDate AND :toDate\n" + 
		"    GROUP BY\n" + 
		"        m_city_id\n" + 
		") c\n" + 
		"ON\n" + 
		"    c.m_city_id = a.m_city_id",nativeQuery=true)
List<CityReports> getCityWiseLMSAndINQCount(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
}
