package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.ChannelReports;

public interface ChannelReportsRepository extends JpaRepository<ChannelReports, Integer>{
	
	
			@Query(value="SELECT\n" + 
					"    a.m_channel_id,\n" + 
					"    COALESCE(a.m_channel_name, 0) AS m_channel_name,\n" + 
					"    COALESCE(a.m_channel_desc, 0) AS m_channel_desc,\n" + 
					"	COALESCE(b.chnl_lead_count, 0) AS chnl_lead_count,\n" + 
					"    COALESCE(c.chnl_inq_count, 0) AS chnl_inq_count\n" + 
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
					"    SELECT\n" + 
					"        channel_id,\n" + 
					"        COUNT('') AS chnl_lead_count\n" + 
					"    FROM\n" + 
					"        lms_header\n" + 
					"    WHERE\n" + 
					"        del_status = 1 AND maker_datetime BETWEEN :fromDate AND :toDate\n" + 
					"    GROUP BY\n" + 
					"        channel_id\n" + 
					") b\n" + 
					"ON\n" + 
					"    b.channel_id = a.m_channel_id\n" + 
					"LEFT JOIN(\n" + 
					"    SELECT\n" + 
					"        channel_id,\n" + 
					"        COUNT('') AS chnl_inq_count\n" + 
					"    FROM\n" + 
					"        inquiry_header\n" + 
					"    WHERE\n" + 
					"        del_status = 1 AND maker_datetime BETWEEN :fromDate AND :toDate\n" + 
					"    GROUP BY\n" + 
					"        channel_id\n" + 
					") c\n" + 
					"ON\n" + 
					"    c.channel_id = a.m_channel_id",nativeQuery=true)
			List<ChannelReports> getChannelLMSandINQCount(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	

}
