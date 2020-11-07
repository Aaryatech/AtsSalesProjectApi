package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.LmsHeaderWithNamesAndCustDetail;

public interface LmsHeaderWithCustDetailRepo extends JpaRepository<LmsHeaderWithNamesAndCustDetail, Integer> {
	//to Fetch Customer Details(lms_header.md_acc_type=1)
	@Query(value="    SELECT\n" + 
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
			"        (SELECT\n" + 
			"            GROUP_CONCAT(m_tags.m_tag_name)              \n" + 
			"        FROM\n" + 
			"            m_tags              \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(m_tags.m_tag_id, lms_header.acc_tags)    )) as cp_info,\n" + 
			"            \n" + 
			"            \n" + 
			"            \n" + 
			"            concat(lms_detail.cp_mobile,',',lms_detail.cp_email) as cp_contact,\n" + 
			"            concat(lms_header.acc_company,',',m_domain_type.m_domain_name) as cp_info2\n" + 
			"    FROM\n" + 
			"        lms_header,\n" + 
			"        m_channel,\n" + 
			"        lms_detail,\n" + 
			"        m_designation,\n" + 
			"        m_domain_type\n" + 
			"    WHERE\n" + 
			"        lms_header.del_status=1                  \n" + 
			"        AND         lms_header.is_active=1                 \n" + 
			"        AND        lms_header.channel_id=m_channel.m_channel_id         \n" + 
			"        and lms_header.lms_id=lms_detail.lms_id \n" + 
			"        and lms_detail.cp_primary=1 \n" + 
			"        and m_domain_type.m_domain_id=lms_header.acc_domain_id\n" + 
			"        and m_designation.m_designation_id=lms_detail.cp_designation_id \n" + 
			"        and lms_detail.del_status=1 \n" + 
			"        AND lms_header.md_acc_type_id=1\n" + 
			"        and lms_header.acc_code IS NOT Null\n" + 
			"    GROUP BY\n" + 
			"        lms_header.lms_id",nativeQuery=true)
	List<LmsHeaderWithNamesAndCustDetail> getCustList();
	
	
	
	
	//To Fetch Collabrator(lms_header.md_acc_type=2)
	@Query(value="   SELECT\n" + 
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
			"        (SELECT\n" + 
			"            GROUP_CONCAT(m_tags.m_tag_name)              \n" + 
			"        FROM\n" + 
			"            m_tags              \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(m_tags.m_tag_id, lms_header.acc_tags)    )) as cp_info,\n" + 
			"            \n" + 
			"            \n" + 
			"            \n" + 
			"            concat(lms_detail.cp_mobile,',',lms_detail.cp_email) as cp_contact,\n" + 
			"            concat(lms_header.acc_company,',',m_domain_type.m_domain_name) as cp_info2\n" + 
			"    FROM\n" + 
			"        lms_header,\n" + 
			"        m_channel,\n" + 
			"        lms_detail,\n" + 
			"        m_designation,\n" + 
			"        m_domain_type\n" + 
			"    WHERE\n" + 
			"        lms_header.del_status=1                  \n" + 
			"        AND         lms_header.is_active=1                 \n" + 
			"        AND        lms_header.channel_id=m_channel.m_channel_id         \n" + 
			"        and lms_header.lms_id=lms_detail.lms_id \n" + 
			"        and lms_detail.cp_primary=1 \n" + 
			"        and m_domain_type.m_domain_id=lms_header.acc_domain_id\n" + 
			"        and m_designation.m_designation_id=lms_detail.cp_designation_id \n" + 
			"        and lms_detail.del_status=1 \n" + 
			"        AND lms_header.md_acc_type_id=2\n" + 
			"        and lms_header.acc_code IS NOT Null\n" + 
			"    GROUP BY\n" + 
			"        lms_header.lms_id",nativeQuery=true)
	List<LmsHeaderWithNamesAndCustDetail> getCollabratorList();
	
	
	
	

}
