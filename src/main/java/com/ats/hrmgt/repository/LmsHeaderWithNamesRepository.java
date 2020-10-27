package com.ats.hrmgt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.LmsHeaderWithNames;

public interface LmsHeaderWithNamesRepository  extends JpaRepository<LmsHeaderWithNames, Integer>{
	
	
	//Fetch Lms Header By lms_is And del_status ,is_active is True
	@Query(value="   SELECT\n" + 
			"        lms_header.*,\n" + 
			"        '' AS account_type,\n" + 
			"        m_channel.m_channel_name AS channel_name,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(m_tags.m_tag_name)     \n" + 
			"        FROM\n" + 
			"            m_tags     \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(m_tags.m_tag_id, lms_header.acc_tags)    ) AS tag_names        \n" + 
			"    FROM\n" + 
			"        lms_header,\n" + 
			"        m_channel        \n" + 
			"    WHERE\n" + 
			"        lms_header.del_status=1         \n" + 
			"        AND         lms_header.is_active=1        \n" + 
			"        AND        lms_header.md_acc_type_id=md_acc_type.md_acc_type_id        \n" + 
			"        AND        lms_header.channel_id=m_channel.m_channel_id    \n" + 
			"        AND 		lms_header.lms_id=:lmsId\n" + 
			"    GROUP BY\n" + 
			"        lms_header.lms_id"
			,nativeQuery=true)
	LmsHeaderWithNames getLmsHeaderByLmsId(@Param("lmsId") int lmsId);
	
	
	//To Delete Lms Header Using Lms ID
	@Transactional
	@Modifying
	@Query(value="UPDATE lms_header SET del_status=false WHERE lms_id=:lmsId",nativeQuery=true)
	int deleteLmsHeader(@Param("lmsId") int lmsId);
	
	
	//Te Fetch List Of All LMS Header
	@Query(value="SELECT\n" + 
			"    lms_header.*,\n" + 
			"   '' AS account_type,\n" + 
			"    m_channel.m_channel_name AS channel_name,\n" + 
			"    (SELECT\n" + 
			"        GROUP_CONCAT(m_tags.m_tag_name)\n" + 
			"    FROM\n" + 
			"        m_tags\n" + 
			"    WHERE\n" + 
			"       FIND_IN_SET(m_tags.m_tag_id, lms_header.acc_tags)    ) AS tag_names\n" + 
			"       FROM\n" + 
			"       lms_header,\n" + 
			"       md_acc_type,\n" + 
			"       m_channel\n" + 
			"       WHERE\n" + 
			"       lms_header.del_status=1 \n" + 
			"       AND \n" + 
			"       lms_header.is_active=1\n" + 
			"       AND\n" + 
			"       lms_header.md_acc_type_id=md_acc_type.md_acc_type_id\n" + 
			"       AND\n" + 
			"       lms_header.channel_id=m_channel.m_channel_id\n" + 
			"       GROUP BY\n" + 
			"       lms_header.lms_id",nativeQuery=true)
	List<LmsHeaderWithNames> getListOfAllLmsHeader();
	

}
