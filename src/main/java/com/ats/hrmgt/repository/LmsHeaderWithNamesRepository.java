package com.ats.hrmgt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.LmsHeaderWithNames;

public interface LmsHeaderWithNamesRepository  extends JpaRepository<LmsHeaderWithNames, Integer>{
	
	
	//Fetch Lms Header By lms_id And del_status ,is_active is True
	@Query(value="   SELECT\n" + 
			"        lms_header.*,\n" + 
			"        '' AS account_type,\n" + 
			"        m_channel.m_channel_name AS channel_name,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(m_tags.m_tag_name)     \n" + 
			"        FROM\n" + 
			"            m_tags     \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(m_tags.m_tag_id, lms_header.acc_tags)    ) AS tag_names,'' as cp_info,'' as mail,'' as current_status       \n" + 
			"    FROM\n" + 
			"        lms_header,\n" + 
			"        m_channel        \n" + 
			"    WHERE\n" + 
			"        lms_header.del_status=1         \n" + 
			"        AND         lms_header.is_active=1        \n" + 
			/*"        AND        lms_header.md_acc_type_id=md_acc_type.md_acc_type_id\n" +*/ 
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
			"        lms_header.*,\n" + 
			"        '' AS account_type,\n" + 
			"        m_channel.m_channel_name AS channel_name,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(m_tags.m_tag_name)              \n" + 
			"        FROM\n" + 
			"            m_tags              \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(m_tags.m_tag_id, lms_header.acc_tags)    ) AS tag_names,\n" + 
			"        concat(lms_detail.cp_name,\n" + 
			"        ', ',\n" + 
			"        m_designation.m_designation_name,\n" + 
			"        ', ',\n" + 
			"        lms_detail.cp_mobile) as cp_info,\n" + 
			"        lms_detail.cp_email as mail,\n" + 
			"        (select mt.m_task_status_name from task_details t,m_task_status mt where t.pri_key=lms_header.lms_id and t.md_acc_type_id=1 and mt.m_task_status_id=t.task_final_status and t.del_status=1 ORDER BY task_id DESC LIMIT 0, 1 ) as current_status\n" + 
			"    FROM\n" + 
			"        lms_header,\n" + 
			"        m_channel,\n" + 
			"        lms_detail,\n" + 
			"        m_designation \n" + 
			"    WHERE\n" + 
			"        lms_header.del_status=1                  \n" + 
			"        AND         lms_header.is_active=1                 \n" + 
			"        AND        lms_header.channel_id=m_channel.m_channel_id         \n" + 
			"        and lms_header.lms_id=lms_detail.lms_id \n" + 
			"        and lms_detail.cp_primary=1 \n" + 
			"        and m_designation.m_designation_id=lms_detail.cp_designation_id \n" + 
			"        and lms_detail.del_status=1     \n" + 
			"    GROUP BY\n" + 
			"        lms_header.lms_id",nativeQuery=true)
	List<LmsHeaderWithNames> getListOfAllLmsHeader();
	

}
