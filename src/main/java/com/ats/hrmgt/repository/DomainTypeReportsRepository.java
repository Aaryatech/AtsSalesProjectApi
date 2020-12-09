package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.DomainTypeReports;
import com.ats.hrmgt.model.DomainWiseDetailReport;

public interface DomainTypeReportsRepository extends JpaRepository<DomainTypeReports, Integer> {

	
	
	
	@Query(value="SELECT\n" + 
			"    a.m_domain_id,\n" + 
			"    COALESCE(a.m_domain_name, 0) AS m_domain_name,\n" + 
			"    COALESCE(b.domain_lead_count, 0) AS domain_lead_count,\n" + 
			"    COALESCE(c.domain_inq_count, 0) AS domain_inq_count\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        *\n" + 
			"    FROM\n" + 
			"        m_domain_type\n" + 
			"    WHERE\n" + 
			"        del_status = 1\n" + 
			") a\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        acc_domain_id,\n" + 
			"        COUNT('') AS domain_lead_count\n" + 
			"    FROM\n" + 
			"        lms_header\n" + 
			"    WHERE\n" + 
			"        del_status = 1 AND maker_datetime BETWEEN :fromDate AND :toDate\n" + 
			"    GROUP BY\n" + 
			"        acc_domain_id\n" + 
			") b\n" + 
			"ON\n" + 
			"    b.acc_domain_id = a.m_domain_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        inq_domain_id,\n" + 
			"        COUNT('') AS domain_inq_count\n" + 
			"    FROM\n" + 
			"        inquiry_header\n" + 
			"    WHERE\n" + 
			"        del_status = 1 AND maker_datetime BETWEEN :fromDate AND :toDate\n" + 
			"    GROUP BY\n" + 
			"        inq_domain_id\n" + 
			") c\n" + 
			"ON\n" + 
			"    c.inq_domain_id = a.m_domain_id",nativeQuery=true)
	List<DomainTypeReports> getDomainWiseLMSandInqCount(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
}
