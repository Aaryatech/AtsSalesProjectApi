package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.TaskDetailsWithMsg;

public interface TaskDetailWithMsgRepository  extends JpaRepository<TaskDetailsWithMsg, Integer>
{
	
	
	//To Fetch Records With Client Profiling AS Message By pri_key And md_acc_type_id 
	@Query(value="SELECT\n" + 
			"        task_details.task_id,\n" + 
			"        task_details.maker_datetime as task_done_date,\n" + 
			"        (Select\n" + 
			"            m_employee.emp_name \n" + 
			"        FROM\n" + 
			"            m_employee \n" + 
			"        WHERE\n" + 
			"            m_employee.emp_id=task_details.maker_user_id) as emp_name,\n" + 
			"        task_details.task_client_profiling AS message \n" + 
			"    FROM\n" + 
			"        task_details \n" + 
			"    WHERE\n" + 
			"        task_details.md_acc_type_id=:mdAccTypeId  \n" + 
			"        AND     task_details.pri_key=:priKey\n" + 
			"        and task_details.task_client_profiling!=''",nativeQuery=true)
	List<TaskDetailsWithMsg> getTaskDetailsClientProfiling(@Param("priKey") int priKey,
																@Param("mdAccTypeId") int mdAccTypeId);

	
	//To Fetch Records With Client Questions AS Message By pri_key And md_acc_type_id
	@Query(value="SELECT\n" + 
			"   task_details.task_id,\n" + 
			"   task_details.maker_datetime as task_done_date,\n" + 
			"   (Select m_employee.emp_name FROM m_employee WHERE m_employee.emp_id=task_details.maker_user_id) as emp_name,\n" + 
			"    task_details.task_though_questions AS message\n" + 
			"FROM\n" + 
			"    task_details\n" + 
			"WHERE\n" + 
			"	task_details.md_acc_type_id=:mdAccTypeId\n" + 
			"	AND\n" + 
			"    task_details.pri_key=:priKey and task_details.task_though_questions!=''\n" + 
			" ",nativeQuery=true)
	List<TaskDetailsWithMsg> getTaskDetailsClientQuestions(@Param("priKey") int priKey,
			@Param("mdAccTypeId") int mdAccTypeId);
	
	
	
	
	
	//To Fetch Records With  What Went Wrong AS Message By pri_key And md_acc_type_id
	@Query(value="SELECT\n" + 
			"   task_details.task_id,\n" + 
			"   task_details.maker_datetime as task_done_date,\n" + 
			"   (Select m_employee.emp_name FROM m_employee WHERE m_employee.emp_id=task_details.maker_user_id) as emp_name,\n" + 
			"    task_details.task_what_went_wrong AS message\n" + 
			"FROM\n" + 
			"    task_details\n" + 
			"WHERE\n" + 
			"	task_details.md_acc_type_id=:mdAccTypeId\n" + 
			"	AND\n" + 
			"    task_details.pri_key=:priKey and task_details.task_what_went_wrong!=''",nativeQuery=true)
	List<TaskDetailsWithMsg> getTaskDetailsClientWentWrong(@Param("priKey") int priKey,
			@Param("mdAccTypeId") int mdAccTypeId);
	
}
