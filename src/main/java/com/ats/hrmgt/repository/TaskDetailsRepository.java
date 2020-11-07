package com.ats.hrmgt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.TaskDetails;

public interface TaskDetailsRepository extends JpaRepository<TaskDetails, Integer> {
	
	
	
	//To Delete Task From task_details Using task_id
	@Transactional
	@Modifying
	@Query(value="UPDATE task_details set del_status=false WHERE task_id=:taskId",nativeQuery=true)
	int deleteTaskDetailsByTaskId(@Param("taskId") int taskId) ;

	@Query(value="select * from task_details WHERE task_id=:taskId",nativeQuery=true)
	TaskDetails finByTaskId(int taskId);

}
