package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.AtsTAskScheduleWithNames;

public interface AtsTAskScheduleWithNamesRepository
		extends JpaRepository<AtsTAskScheduleWithNames, Integer>{
	
	
	@Query(value="SELECT\n" + 
			"    ats_task_schedule.*,\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        GROUP_CONCAT(m_employee.emp_name)\n" + 
			"    FROM\n" + 
			"        m_employee\n" + 
			"    WHERE\n" + 
			"        FIND_IN_SET(\n" + 
			"            m_employee.emp_id,\n" + 
			"            ats_task_schedule.task_allotted_to\n" + 
			"        ) ) AS emp_name\n" + 
			"    FROM\n" + 
			"        ats_task_schedule\n" + 
			"    WHERE\n" + 
			"        ats_task_schedule.del_status = 1 AND ats_task_schedule.is_active = 1",nativeQuery=true)
	List<AtsTAskScheduleWithNames> getAllAtsTAskScheduleWithNames();

}
