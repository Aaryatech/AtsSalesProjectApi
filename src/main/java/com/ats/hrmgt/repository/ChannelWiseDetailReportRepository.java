package com.ats.hrmgt.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.ChannelWiseDetailReport;

public interface ChannelWiseDetailReportRepository extends JpaRepository<ChannelWiseDetailReport, String> {
	
	
	
	
	@Query(value="SELECT\n" + 
				"   uuid() AS id,    \n"+
			"    a.m_channel_id,\n" + 
			"    COALESCE(a.m_channel_name, 0) AS m_channel_name ,\n" + 
			"  	COALESCE(b.customer_name, 0) AS customer_name,\n" + 
			"    COALESCE(b.acc_company, 0) AS acc_company,\n" + 
			"    COALESCE(c.cp_name, 0) AS cp_name,\n" + 
			"    COALESCE(c.cp_mobile, 0) AS cp_mobile,\n" + 
			"    COALESCE(c.cp_email, 0) AS cp_email\n" + 
			"     \n" + 
			"FROM\n" + 
			"      (\n" + 
			"    SELECT\n" + 
			"        *\n" + 
			"    FROM\n" + 
			"        m_channel\n" + 
			"    WHERE\n" + 
			"        del_status = 1 \n" + 
			") a LEFT JOIN(\n" + 
			"    \n" + 
			"    SELECT\n" + 
			"  \n" + 
			"    		lms_id,\n" + 
			"    		channel_id,\n" + 
			"       		customer_name,\n" + 
			"    		acc_company\n" + 
			"    FROM\n" + 
			"        lms_header\n" + 
			"    WHERE\n" + 
			"        del_status = 1 AND maker_datetime BETWEEN :fromDate AND :toDate\n" + 
			"   \n" + 
			"       \n" + 
			") b\n" + 
			"ON\n" + 
			"    b.channel_id = a.m_channel_id\n" + 
			"    LEFT JOIN\n" + 
			"    (  SELECT \n" + 
			"     	lms_id,\n" + 
			"     	cp_name,\n" + 
			"     	cp_mobile,\n" + 
			"     	cp_email\n" + 
			"     FROM\n" + 
			"     lms_detail\n" + 
			"       WHERE\n" + 
			"        del_status = 1 \n" + 
			"     \n" + 
			"    )c\n" + 
			"    ON\n" + 
			"    b.lms_id = c.lms_id  ORDER BY m_channel_name,acc_company",nativeQuery=true)
	List<ChannelWiseDetailReport> getChannelWiseDetailLeadReport(@Param("fromDate") String fromDate,
															@Param("toDate") String toDate);
	
	
	
	
	@Query(value="SELECT\n" + 
			"    UUID() AS id, \n" + 
			"    a.m_channel_id,\n" + 
			"    COALESCE(a.m_channel_name, 0) AS m_channel_name,\n" + 
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
			"        m_channel\n" + 
			"    WHERE\n" + 
			"        del_status = 1\n" + 
			") a\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT inq_id,\n" + 
			"        channel_id,\n" + 
			"        inquiry_tittle,\n" + 
			"        inq_company\n" + 
			"    FROM\n" + 
			"        inquiry_header\n" + 
			"    WHERE\n" + 
			"        del_status = 1 AND maker_datetime BETWEEN :fromDate AND :toDate\n" + 
			") b\n" + 
			"ON\n" + 
			"    b.channel_id = a.m_channel_id\n" + 
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
			"ORDER BY\n" + 
			"    m_channel_name ASC,\n" + 
			"    acc_company",nativeQuery=true)
	List<ChannelWiseDetailReport> getChannelWiseDetailINQReport(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
	
	

}
