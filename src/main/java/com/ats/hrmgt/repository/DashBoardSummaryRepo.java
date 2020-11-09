package com.ats.hrmgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.DashBoardSummary;

public interface DashBoardSummaryRepo extends JpaRepository<DashBoardSummary, Integer> {

	@Query(value="select \n" + 
			"        UUID() as id,\n" + 
			"        (select count('') from task_details t where t.task_sche_date=:date and FIND_IN_SET(:userId, t.task_alloted_to) and t.this_task_status=0 ) as today_count,\n" + 
			"        (select count('') from task_details t where DATE_FORMAT(t.task_done_date, '%Y-%m-%d')=:date and t.task_done_by=:userId) as today_completed,\n" + 
			"        (select count('') from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)<0 and t.this_task_status=0 and FIND_IN_SET(:userId, t.task_alloted_to)) as \n" + 
			"        pending_count,\n" + 
			"        (select count('') from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)>0 and t.this_task_status=0 and FIND_IN_SET(:userId, t.task_alloted_to)) as \n" + 
			"        remaining_count,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where   DATE_FORMAT(t.task_done_date, '%Y-%m-%d') =:date and t.task_done_by=:userId) as today_completed_pts,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)<0 and t.this_task_status=0 and FIND_IN_SET(:userId, t.task_alloted_to)) as pending_pts",nativeQuery=true)
	DashBoardSummary getRegularDashboardSummry(int userId, String date);

}
