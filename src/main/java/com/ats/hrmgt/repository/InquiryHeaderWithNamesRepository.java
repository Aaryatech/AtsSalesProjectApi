package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.InquiryHeaderWithNames;

public interface InquiryHeaderWithNamesRepository  extends JpaRepository<InquiryHeaderWithNames, Integer>{
	//To Fetch All Records From Inquiry Header With Channel Name And Tag Names 
	@Query(value="  SELECT\n" + 
			"        inquiry_header.*,\n" + 
			"       \n" + 
			"        m_channel.m_channel_name AS channel_Name,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(m_tags.m_tag_name)     \n" + 
			"        FROM\n" + 
			"            m_tags     \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(m_tags.m_tag_id, inquiry_header.inq_tags)    ) AS tag_names        \n" + 
			"    FROM\n" + 
			"        inquiry_header,\n" + 
			"        \n" + 
			"        m_channel        \n" + 
			"    WHERE\n" + 
			"        inquiry_header.del_status=1         \n" + 
			"        AND         inquiry_header.is_active=1        \n" + 
			"             \n" + 
			"        AND        inquiry_header.channel_id=m_channel.m_channel_id        \n" + 
			"    GROUP BY\n" + 
			"        inquiry_header.inq_id\n" + 
			"",nativeQuery=true)
	List<InquiryHeaderWithNames> getAllInquiryHeaderWithName();
	
	
	//To Fetch Single Inquiry Header With Channel Name And Tag Names Using inq_id
	@Query(value="    SELECT\n" + 
			"        inquiry_header.*,\n" + 
			"       \n" + 
			"        m_channel.m_channel_name AS channel_Name,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(m_tags.m_tag_name)     \n" + 
			"        FROM\n" + 
			"            m_tags     \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(m_tags.m_tag_id, inquiry_header.inq_tags)    ) AS tag_names        \n" + 
			"    FROM\n" + 
			"        inquiry_header,\n" + 
			"        \n" + 
			"        m_channel        \n" + 
			"    WHERE\n" + 
			"        inquiry_header.del_status=1         \n" + 
			"        AND         inquiry_header.is_active=1        \n" + 
			"             \n" + 
			"        AND        inquiry_header.channel_id=m_channel.m_channel_id      \n" + 
			"        AND inquiry_header.inq_id=:inqId\n" + 
			"    GROUP BY\n" + 
			"        inquiry_header.inq_id\n" + 
			"",nativeQuery=true)
	InquiryHeaderWithNames getInqHeaderWithNameById(@Param("inqId") int inqId);

}
