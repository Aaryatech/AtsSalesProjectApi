package com.ats.hrmgt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.Tags;

public interface TagsRepository extends JpaRepository<Tags, Integer> {
	
	@Query(value="SELECT * FROM m_tags WHERE del_status=true",
			nativeQuery=true)
	List<Tags> getAllTAgsByDelStatus();

	@Query(value="select t.m_tag_id,t.m_acc_type_id,t.m_tag_name,t.del_status,t.is_active,t.maker_user_id,t.maker_datetime,t.ex_int1,t.ex_int2,t.ex_var2,acc.md_acc_type_text as ex_var1 from m_tags t,md_acc_type acc where acc.md_acc_type_id=t.m_acc_type_id AND t.del_status=true" 
			,nativeQuery=true)
	List<Tags> getAllTagsWithAccountTypeName();
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_tags SET del_status=false WHERE m_tag_id=:tagId",nativeQuery=true)
	int deleteTagByDelStatus(@Param("tagId") int tagId);
	
	@Query(value="select t.m_tag_id,t.m_acc_type_id,t.m_tag_name,t.del_status,t.is_active,t.maker_user_id,t.maker_datetime,t.ex_int1,t.ex_int2,t.ex_var2,acc.md_acc_type_text as ex_var1 from m_tags t,md_acc_type acc where acc.md_acc_type_id=t.m_acc_type_id AND t.del_status=true AND m_tag_id=:tagId",nativeQuery=true)
	Tags getTagByIdANddelStatus(@Param("tagId") int tagId);


	@Transactional
	@Modifying
	@Query(value="UPDATE m_tags SET m_acc_type_id=:mAccTypeId , m_tag_name=:mTagName WHERE m_tag_id=:mTagId ",
			nativeQuery=true)
	int editTag(@Param("mTagId") int mTagId,
			@Param("mAccTypeId") int mAccTypeId,
			@Param("mTagName") String mTagName
			);
	
	
	
	//To Fetch All Tags By m_acc_type_id Where del_status & is_active Status is True
	@Query(value="SELECT * FROM m_tags WHERE m_acc_type_id=:mAccTypeId AND del_status=true AND is_active=true",nativeQuery=true)
	List<Tags> getTagBymAccTypeId(@Param("mAccTypeId") int mAccTypeId);
	
	@Query(value="SELECT * FROM m_tags WHERE del_status=true AND is_active=true",nativeQuery=true)
	List<Tags> getAllTagsList();
	
	
}
