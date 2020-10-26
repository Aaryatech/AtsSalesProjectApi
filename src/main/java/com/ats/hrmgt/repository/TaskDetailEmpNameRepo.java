package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.TaskDetailsEmpName;

public interface TaskDetailEmpNameRepo extends  JpaRepository<TaskDetailsEmpName, Integer>{

	
	
	//Fetch All Task Details With Employee Name As Extra Field From task_details
	@Query(value="SELECT\n" + 
			"    t.*,\n" + 
			"    GROUP_CONCAT(emp.emp_name) AS employee_name\n" + 
			"FROM\n" + 
			"    task_details t,\n" + 
			"    m_employee emp\n" + 
			"WHERE\n" + 
			"     t.del_status=1 AND t.is_active=1 AND  FIND_IN_SET(emp.emp_id, t.task_alloted_to) \n" + 
			"    GROUP by t.task_id  ",nativeQuery=true)
	List<TaskDetailsEmpName> getAllTaskWithEmpNAme();
	
	
	//To Fetch  Records Using empId From task_details With Employee Name
	@Query(value="SELECT\n" + 
			"        t.*, \n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(DISTINCT (emp.emp_name))          \n" + 
			"        FROM\n" + 
			"            m_employee emp         \n" + 
			"        WHERE\n" + 
			"                FIND_IN_SET(emp.emp_id, t.task_alloted_to)    ) as employee_name\n" + 
			"    FROM\n" + 
			"        task_details t \n" + 
			"    WHERE\n" + 
			"        t.del_status=1 \n" + 
			"        AND t.is_active=1 \n" + 
			"        and FIND_IN_SET(:empId, t.task_alloted_to)",nativeQuery=true)
	List<TaskDetailsEmpName> getTaskDetailWithEmpNameByEmpid(@Param("empId") int empId);
	
	
	
	//To Fetch Record Using TaskId From TaskDetails With Employee Name
	@Query(value="SELECT\n" + 
			"    t.*,\n" + 
			"    GROUP_CONCAT(emp.emp_name ) AS employee_name \n" + 
			"FROM\n" + 
			"    task_details t,\n" + 
			"    m_employee emp\n" + 
			"WHERE     t.del_status=1 AND t.is_active=1 AND  \n" + 
			"FIND_IN_SET(emp.emp_id,t.task_alloted_to)\n" + 
			"AND t.task_id=:taskId  \n" + 
			"",nativeQuery=true)
	TaskDetailsEmpName getTaskdetailsEmpnameByTaskId(@Param("taskId") int taskId);
	
	
}
