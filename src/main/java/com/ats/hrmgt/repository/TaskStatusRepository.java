package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.TaskStatus;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Integer> {

	
	
	//To Fetch List Of All TaskStatus Where del_status And is_active Is True
	@Query(value="SELECT * FROM m_task_status WHERE del_status=true AND is_active=true",nativeQuery=true)
	List<TaskStatus> getAllTaskStatusList();
	
	
	
	//To Fetch Records From Task Status By  m_acc_type_id Where del_status And is_active Status is True
	@Query(value="SELECT * FROM m_task_status WHERE md_acc_type_id=:mdAccTypeId AND del_status=true AND is_active=true",nativeQuery=true)
	List<TaskStatus> getAllTaskStatusBymdAccTypeId(@Param("mdAccTypeId") int mdAccTypeId);
	
	
	
}
