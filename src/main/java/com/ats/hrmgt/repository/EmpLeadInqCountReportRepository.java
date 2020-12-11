package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.EmployeeReport;

public interface EmpLeadInqCountReportRepository  extends  JpaRepository<EmployeeReport, Integer>{
	
	
	
	@Query(value="SELECT\n" + 
			"    a.emp_id,\n" + 
			"    a.emp_name,\n" + 
			" 	COALESCE(b.lead_count, 0) AS lead_count,\n" + 
			"    COALESCE(c.inq_count, 0) AS inq_count\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        *\n" + 
			"    FROM\n" + 
			"        m_employee\n" + 
			"    WHERE\n" + 
			"        del_status = 1\n" + 
			") a\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT maker_user_id,\n" + 
			"        COUNT('') AS lead_count\n" + 
			"    FROM\n" + 
			"        lms_header\n" + 
			"    WHERE\n" + 
			"        del_status = 1 AND maker_datetime BETWEEN :fromDate AND :toDate\n" + 
			"    GROUP BY\n" + 
			"        maker_user_id\n" + 
			") b\n" + 
			"ON\n" + 
			"    b.maker_user_id = a.emp_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT maker_user_id,\n" + 
			"        COUNT('') AS inq_count\n" + 
			"    FROM\n" + 
			"        inquiry_header\n" + 
			"    WHERE\n" + 
			"        del_status = 1 AND maker_datetime BETWEEN :fromDate AND :toDate\n" + 
			"    GROUP BY\n" + 
			"        maker_user_id\n" + 
			") c\n" + 
			"ON\n" + 
			"   c.maker_user_id = a.emp_id",nativeQuery=true)
	List<EmployeeReport> getEmpWiseLMSIMScount(@Param("fromDate") String fromDate,
														@Param("toDate") String toDate);

}
