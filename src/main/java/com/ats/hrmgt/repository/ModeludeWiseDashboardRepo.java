package com.ats.hrmgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.ModeludeWiseDashboard;

public interface ModeludeWiseDashboardRepo extends JpaRepository<ModeludeWiseDashboard, Integer> {

	
	@Query(value="select \n" + 
			"        UUID() as id,\n" + 
			"        (select count('') from task_details t where FIND_IN_SET(0, t.task_alloted_to) and t.this_task_status=0 and t.md_acc_type_id=1 and t.del_status=1) as lms_unallocated_task,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where FIND_IN_SET(0, t.task_alloted_to) and t.this_task_status=0 and t.md_acc_type_id=1 and t.del_status=1) as lms_unallocated_pts,\n" + 
			"        (select count('') from task_details t where task_alloted_to!=0 and t.this_task_status=0 and t.md_acc_type_id=1 and t.del_status=1) as lms_allocated_task,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where task_alloted_to!=0 and t.this_task_status=0 and t.md_acc_type_id=1 and t.del_status=1) as lms_allocated_pts, \n" + 
			"        (select count('') from task_details t where DATE_FORMAT(t.task_done_date, '%Y-%m-%d')=:date and t.this_task_status=1 and t.md_acc_type_id=1 and t.del_status=1) as lms_today_completed,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where DATE_FORMAT(t.task_done_date, '%Y-%m-%d')=:date and t.this_task_status=1 and t.md_acc_type_id=1 and t.del_status=1) as lms_today_completed_pts, \n" + 
			"        (select count('') from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)<0 and t.this_task_status=0 and t.md_acc_type_id=1 and task_alloted_to!=0 and t.del_status=1) as  lms_pending_count,\n" + 
			"        (select count('') from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)>0 and t.this_task_status=0 and t.md_acc_type_id=1 and task_alloted_to!=0 and t.del_status=1) as  lms_remaining_count,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)<0 and t.this_task_status=0 and t.md_acc_type_id=1 and task_alloted_to!=0 and t.del_status=1) as  lms_pending_pts,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)>0 and t.this_task_status=0 and t.md_acc_type_id=1 and task_alloted_to!=0 and t.del_status=1) as  lms_remaining_pts,\n" + 
			"        \n" + 
			"        (select count('') from task_details t where FIND_IN_SET(0, t.task_alloted_to) and t.this_task_status=0 and t.md_acc_type_id=2 and t.del_status=1 ) as inq_unallocated_task,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where FIND_IN_SET(0, t.task_alloted_to) and t.this_task_status=0 and t.md_acc_type_id=2 and t.del_status=1) as inq_unallocated_pts,\n" + 
			"        (select count('') from task_details t where task_alloted_to!=0 and t.this_task_status=0 and t.md_acc_type_id=2 and t.del_status=1) as inq_allocated_task,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where task_alloted_to!=0 and t.this_task_status=0 and t.md_acc_type_id=2 and t.del_status=1) as inq_allocated_pts, \n" + 
			"        (select count('') from task_details t where DATE_FORMAT(t.task_done_date, '%Y-%m-%d')=:date and t.this_task_status=1 and t.md_acc_type_id=2 and t.del_status=1) as inq_today_completed,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where DATE_FORMAT(t.task_done_date, '%Y-%m-%d')=:date and t.this_task_status=1 and t.md_acc_type_id=2 and t.del_status=1) as inq_today_completed_pts, \n" + 
			"        (select count('') from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)<0 and t.this_task_status=0 and t.md_acc_type_id=2 and task_alloted_to!=0 and t.del_status=1) as inq_pending_count,\n" + 
			"        (select count('') from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)>0 and t.this_task_status=0 and t.md_acc_type_id=2 and task_alloted_to!=0 and t.del_status=1) as \n" + 
			"        inq_remaining_count,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)<0 and t.this_task_status=0 and t.md_acc_type_id=2 and task_alloted_to!=0 and t.del_status=1) as  inq_pending_pts,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)>0 and t.this_task_status=0 and t.md_acc_type_id=2 and task_alloted_to!=0 and t.del_status=1) as  inq_remaining_pts,\n" + 
			"        \n" + 
			"        (select count('') from task_details t where FIND_IN_SET(0, t.task_alloted_to) and t.this_task_status=0 and t.md_acc_type_id=3 and t.del_status=1) as ats_unallocated_task,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where FIND_IN_SET(0, t.task_alloted_to) and t.this_task_status=0 and t.md_acc_type_id=3 and t.del_status=1) as ats_unallocated_pts,\n" + 
			"        (select count('') from task_details t where task_alloted_to!=0 and t.this_task_status=0 and t.md_acc_type_id=3 and t.del_status=1) as ats_allocated_task,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where task_alloted_to!=0 and t.this_task_status=0 and t.md_acc_type_id=3 and t.del_status=1) as ats_allocated_pts, \n" + 
			"        (select count('') from task_details t where DATE_FORMAT(t.task_done_date, '%Y-%m-%d')=:date and t.this_task_status=1 and t.md_acc_type_id=3 and t.del_status=1) as ats_today_completed,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where DATE_FORMAT(t.task_done_date, '%Y-%m-%d')=:date and t.this_task_status=1 and t.md_acc_type_id=3 and t.del_status=1) as ats_today_completed_pts, \n" + 
			"        (select count('') from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)<0 and t.this_task_status=0 and t.md_acc_type_id=3 and task_alloted_to!=0 and t.del_status=1) as \n" + 
			"        ats_pending_count,\n" + 
			"        (select count('') from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)>0 and t.this_task_status=0 and t.md_acc_type_id=3 and task_alloted_to!=0 and t.del_status=1) as \n" + 
			"        ats_remaining_count,\n" + 
			"         (select ifnull(sum(t.task_pts),0) from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)<0 and t.this_task_status=0 and t.md_acc_type_id=3 and task_alloted_to!=0 and t.del_status=1) as  ats_pending_pts,\n" + 
			"        (select ifnull(sum(t.task_pts),0) from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)>0 and t.this_task_status=0 and t.md_acc_type_id=3 and task_alloted_to!=0 and t.del_status=1) as  ats_remaining_pts\n" + 
			"        \n" + 
			"        \n" + 
			"          "
			,nativeQuery=true)
	ModeludeWiseDashboard modulewiseTaskDashboard(String date);

}
