package com.ats.hrmgt.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.LeadConversionTimeReport;

public interface LeadConversionTimeReportRepository extends JpaRepository<LeadConversionTimeReport, Integer> {
	
	
	@Query(value="SELECT\n" + 
			"        lms_header.lms_id,\n" + 
			"        lms_header.customer_name,\n" + 
			"        lms_header.acc_company,\n" + 
			"        (     SELECT\n" + 
			"            m_task_status_name     \n" + 
			"        FROM\n" + 
			"            task_details t,\n" + 
			"            m_task_status mt     \n" + 
			"        WHERE\n" + 
			"            t.md_acc_type_id = 1 \n" + 
			"            AND mt.m_task_status_id = t.task_final_status \n" + 
			"            AND t.del_status = 1 \n" + 
			"            AND lms_header.lms_id = t.pri_key     \n" + 
			"        ORDER BY\n" + 
			"            task_id     DESC LIMIT 0,\n" + 
			"            1 ) AS status_name,\n" + 
			"        (     SELECT\n" + 
			"            task_sche_date     \n" + 
			"        FROM\n" + 
			"            task_details t,\n" + 
			"            m_task_status mt     \n" + 
			"        WHERE\n" + 
			"            t.md_acc_type_id = 1 \n" + 
			"            AND mt.m_task_status_id = t.task_final_status \n" + 
			"            AND t.del_status = 1 \n" + 
			"            AND lms_header.lms_id = t.pri_key     \n" + 
			"        ORDER BY\n" + 
			"            task_id     DESC LIMIT 0,\n" + 
			"            1 ) AS task_sche_date,\n" + 
			"    COALESCE(DATEDIFF(CURRENT_DATE ,\n" + 
			"        (SELECT\n" + 
			"            task_sche_date     \n" + 
			"        FROM\n" + 
			"            task_details t,\n" + 
			"            m_task_status mt     \n" + 
			"        WHERE\n" + 
			"            t.md_acc_type_id = 1 \n" + 
			"            AND mt.m_task_status_id = t.task_final_status \n" + 
			"            AND t.del_status = 1 \n" + 
			"            AND lms_header.lms_id = t.pri_key     \n" + 
			"        ORDER BY\n" + 
			"            task_id     DESC LIMIT 0,\n" + 
			"            1 )),0) AS days,\n" + 
			"        m_domain_type.m_domain_name,\n" + 
			"        m_channel.m_channel_name \n" + 
			"    FROM\n" + 
			"        lms_header,\n" + 
			"        m_domain_type,\n" + 
			"        m_channel \n" + 
			"    WHERE\n" + 
			"        lms_header.del_status = 1      \n" + 
			"        AND lms_header.maker_datetime BETWEEN :fromDate AND :toDate      \n" + 
			"        AND lms_header.acc_domain_id = m_domain_type.m_domain_id      \n" + 
			"        AND m_channel.m_channel_id = lms_header.channel_id  ORDER BY m_channel.m_channel_id",nativeQuery=true)
	List<LeadConversionTimeReport> getLeadConTymReportList(@Param("fromDate") String fromDate,
																	@Param("toDate") String toDate);

}
