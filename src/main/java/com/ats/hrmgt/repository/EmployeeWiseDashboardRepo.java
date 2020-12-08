package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.EmployeeWiseDashboard;

public interface EmployeeWiseDashboardRepo extends JpaRepository<EmployeeWiseDashboard, Integer> {

	@Query(value="select e.emp_id,e.emp_name,\n" + 
			"(select count('') from task_details t where  FIND_IN_SET(e.emp_id, t.task_alloted_to) and t.this_task_status=0 and t.del_status=1) as allocate_task,\n" + 
			"(select ifnull(sum(t.task_pts),0) from task_details t where  FIND_IN_SET(e.emp_id, t.task_alloted_to) and t.this_task_status=0 and t.del_status=1) as allocate_pts,\n" + 
			"(select count('') from task_details t where DATE_FORMAT(t.task_done_date, '%Y-%m-%d')=:date and t.task_done_by=e.emp_id and t.this_task_status=1 and t.del_status=1) as completed_task,\n" + 
			"(select ifnull(sum(t.task_pts),0) from task_details t where DATE_FORMAT(t.task_done_date, '%Y-%m-%d')=:date and t.task_done_by=e.emp_id and t.this_task_status=1 and t.del_status=1) as completed_pts,\n" + 
			"(select count('') from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)<0 and t.this_task_status=0 and FIND_IN_SET(e.emp_id, t.task_alloted_to) and t.del_status=1) as  pending_count,\n" + 
			"(select ifnull(sum(t.task_pts),0) from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)<0 and t.this_task_status=0 and FIND_IN_SET(e.emp_id, t.task_alloted_to) and t.del_status=1) as  pending_pts,\n" + 
			"(select count('') from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)>0 and t.this_task_status=0 and FIND_IN_SET(e.emp_id, t.task_alloted_to) and t.del_status=1) as \n" + 
			"        remaining_count,\n" + 
			"(select ifnull(sum(t.task_pts),0) from task_details t where (TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60)>0 and t.this_task_status=0 and FIND_IN_SET(e.emp_id, t.task_alloted_to) and t.del_status=1) as \n" + 
			"        remaining_pts from m_employee e",nativeQuery=true)
	List<EmployeeWiseDashboard> getEmployeeWiseDashboardList(String date);

}
