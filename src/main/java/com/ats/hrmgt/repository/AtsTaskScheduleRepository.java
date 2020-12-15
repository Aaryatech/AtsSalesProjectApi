package com.ats.hrmgt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.AtsTaskSchedule;

public interface AtsTaskScheduleRepository extends JpaRepository<AtsTaskSchedule, Integer> {

	
	
	//To Fetch All Records From ats_task_schedule Where del_status And is_active =1
	@Query(value="SELECT * FROM ats_task_schedule WHERE del_status=1 AND is_active=1" ,nativeQuery=true)
	List<AtsTaskSchedule> getAllAtsTaskSchedule();
	
	//To Delete Ats TAsk Using Ats Task Id 
	@Transactional
	@Modifying
	@Query(value="UPDATE ats_task_schedule SET del_status=0 WHERE ats_task_id=:atsTaskId",nativeQuery=true)
	int deleteAtsTask(@Param("atsTaskId") int atsTaskId);
	
	
	
	//To Fetch Single Record Using atsTaskId
	@Query(value="SELECT * FROM ats_task_schedule WHERE del_status=1 AND is_active=1 AND ats_task_id=:atsTaskId",nativeQuery=true)
	AtsTaskSchedule getAtsTaskById(@Param("atsTaskId") int atsTAskId);
	
	
	
}
