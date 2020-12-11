package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.TaskDetailsEmpName;

public interface TaskDetailEmpNameRepo extends  JpaRepository<TaskDetailsEmpName, Integer>{
 
	//Fetch All Task Details With Employee Name As Extra Field From task_details
	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from ( SELECT\n" + 
			"    t.*,t.task_sche_time as time,\n" + 
			"    GROUP_CONCAT(emp.emp_name) AS employee_name,"
			+ " case when TIMESTAMPDIFF(DAY,NOW(),t.task_sche_time)>0 then 1\n" + 
			"            else 0  \n" + 
			"        end  as sts,\n" + 
			"        TIMESTAMPDIFF(DAY,NOW(),t.task_sche_time) as day,\n" + 
			"        TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)-TIMESTAMPDIFF(DAY,NOW(),t.task_sche_time)*24 AS hour,\n" + 
			"        TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60 AS minutes,"
			+ "acc.md_acc_type_text,(SELECT count('') FROM task_details WHERE task_details.del_status=1  AND task_details.is_active=1 and t.pri_key=task_details.pri_key and t.md_acc_type_id=task_details.md_acc_type_id and task_details.this_task_status=1) as completed"
			+ "FROM\n" + 
			"    task_details t,\n" + 
			"    m_employee emp,md_acc_type acc\n" + 
			"WHERE\n" + 
			"     t.del_status=1 AND t.is_active=1 AND  FIND_IN_SET(emp.emp_id, t.task_alloted_to) and t.md_acc_type_id=acc.md_acc_type_id \n" + 
			"    GROUP by t.task_id) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id  ",nativeQuery=true)
	List<TaskDetailsEmpName> getAllTaskWithEmpNAme();
	
	
	//To Fetch  Records Using empId From task_details With Employee Name
	@Query(value=" select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n"
			+ "IFNULL(\n" + 
			"    CASE WHEN a.md_acc_type_id = 1 THEN(\n" + 
			"        CONCAT(\n" + 
			"           \n" + 
			"            c.acc_company_landline\n" + 
			"        )\n" + 
			"    ) WHEN a.md_acc_type_id = 2 THEN(\n" + 
			"        CONCAT(\n" + 
			"            \n" + 
			"            b.inq_company_landline\n" + 
			"        )\n" + 
			"    ) ELSE 0\n" + 
			"END,\n" + 
			"0\n" + 
			") AS company_contact," + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"        t.*,\n" + 
			"        t.task_sche_time as time,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(DISTINCT (emp.emp_name))                   \n" + 
			"        FROM\n" + 
			"            m_employee emp                  \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(emp.emp_id, t.task_alloted_to)    ) as employee_name,\n" + 
			"        case \n" + 
			"            when TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)>0 || (TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24)>0 || (TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60)>0 then 1             \n" + 
			"            else 0           \n" + 
			"        end  as sts,\n" + 
			"        ifnull(TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time),\n" + 
			"        0) as day,\n" + 
			"        ifnull(TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24,\n" + 
			"        0) AS hour,\n" + 
			"        ifnull(TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60,\n" + 
			"        0) AS minutes,\n" + 
			"        acc.md_acc_type_text,\n" + 
			"        (SELECT\n" + 
			"            count('') \n" + 
			"        FROM\n" + 
			"            task_details \n" + 
			"        WHERE\n" + 
			"            task_details.del_status=1  \n" + 
			"            AND task_details.is_active=1 \n" + 
			"            and t.pri_key=task_details.pri_key \n" + 
			"            and t.md_acc_type_id=task_details.md_acc_type_id \n" + 
			"            and task_details.this_task_status=1) as completed     \n" + 
			"    FROM\n" + 
			"        task_details t,\n" + 
			"        md_acc_type acc      \n" + 
			"    WHERE\n" + 
			"        t.del_status=1          \n" + 
			"        AND t.is_active=1          \n" + 
			"        and FIND_IN_SET(:empId, t.task_alloted_to) \n" + 
			"        and t.md_acc_type_id=acc.md_acc_type_id \n" + 
			"        and t.this_task_status=0 order by t.task_sche_time) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header where del_status=1 \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header where del_status=1\n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	List<TaskDetailsEmpName> getTaskDetailWithEmpNameByEmpid(@Param("empId") int empId);
	
	
	
	//To Fetch Record Using TaskId From TaskDetails With Employee Name
	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"    t.*,t.task_sche_time as time,\n" + 
			"    GROUP_CONCAT(emp.emp_name ) AS employee_name,"
			+ " case when TIMESTAMPDIFF(DAY,NOW(),t.task_sche_time)>0 then 1\n" + 
			"            else 0  \n" + 
			"        end  as sts,\n" + 
			"        TIMESTAMPDIFF(DAY,NOW(),t.task_sche_time) as day,\n" + 
			"        TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)-TIMESTAMPDIFF(DAY,NOW(),t.task_sche_time)*24 AS hour,\n" + 
			"        TIMESTAMPDIFF(MINUTE,NOW(),t.task_sche_time)-TIMESTAMPDIFF(HOUR,NOW(),t.task_sche_time)*60 AS minutes,acc.md_acc_type_text,"
			+ "(SELECT count('') FROM task_details WHERE task_details.del_status=1  AND task_details.is_active=1 and t.pri_key=task_details.pri_key and t.md_acc_type_id=task_details.md_acc_type_id and task_details.this_task_status=1) as completed FROM\n" + 
			"    task_details t,\n" + 
			"    m_employee emp,md_acc_type acc\n" + 
			"WHERE     t.del_status=1 AND t.is_active=1 AND  \n" + 
			"FIND_IN_SET(emp.emp_id,t.task_alloted_to)\n" + 
			"AND t.task_id=:taskId and t.md_acc_type_id=acc.md_acc_type_id) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	TaskDetailsEmpName getTaskdetailsEmpnameByTaskId(@Param("taskId") int taskId);


	@Query(value="SELECT\n" + 
			"        a.*,\n" + 
			"        b.emp_name as employee_name,0 as domain_id,0 as m_state_id,0 as m_city_id,'' as company_info,'' as channel_name \n" + 
			"    from\n" + 
			"        (SELECT\n" + 
			"            t.*,\n" + 
			"            t.task_sche_time as time, \n" + 
			"            0  as sts,\n" + 
			"            0 as day,\n" + 
			"            0 AS hour,\n" + 
			"            0 AS minutes,\n" + 
			"            '' as md_acc_type_text,\n" + 
			"            0 as completed               \n" + 
			"        FROM\n" + 
			"            task_details t              \n" + 
			"        WHERE\n" + 
			"            t.del_status=1                            \n" + 
			"            AND t.is_active=1                           \n" + 
			"            and t.pri_key =:primaryKey                        \n" + 
			"            and t.md_acc_type_id=:type                           \n" + 
			"            and t.this_task_status=1) a     \n" + 
			"    left join\n" + 
			"        (\n" + 
			"            SELECT\n" + 
			"                emp.emp_name,\n" + 
			"                emp.emp_id                                     \n" + 
			"            FROM\n" + 
			"                m_employee emp                                      \n" + 
			"        )b \n" + 
			"            on b.emp_id=a.task_done_by",nativeQuery=true)
	List<TaskDetailsEmpName> getTaskPreviousLog(int type, int primaryKey);


	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"        t.*,\n" + 
			"        t.task_sche_time as time,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(DISTINCT (emp.emp_name))                            \n" + 
			"        FROM\n" + 
			"            m_employee emp                           \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(emp.emp_id, t.task_alloted_to)    ) as employee_name,\n" + 
			"        case              \n" + 
			"            when TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)>0 || (TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*24)>0 || (TIMESTAMPDIFF(MINUTE,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*60)>0 then 1                          \n" + 
			"            else 0                    \n" + 
			"        end  as sts,\n" + 
			"        ifnull(TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time),\n" + 
			"        0) as day,\n" + 
			"        ifnull(TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24,\n" + 
			"        0) AS hour,\n" + 
			"        ifnull(TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60,\n" + 
			"        0) AS minutes,\n" + 
			"        acc.md_acc_type_text,\n" + 
			"        (SELECT\n" + 
			"            count('')          \n" + 
			"        FROM\n" + 
			"            task_details          \n" + 
			"        WHERE\n" + 
			"            task_details.del_status=1               \n" + 
			"            AND task_details.is_active=1              \n" + 
			"            and t.pri_key=task_details.pri_key              \n" + 
			"            and t.md_acc_type_id=task_details.md_acc_type_id              \n" + 
			"            and task_details.this_task_status=1) as completed"
			+ " FROM\n" + 
			"        task_details t,\n" + 
			"        md_acc_type acc           \n" + 
			"    WHERE\n" + 
			"        t.del_status=1                   \n" + 
			"        AND t.is_active=1          \n" + 
			"        and t.md_acc_type_id=acc.md_acc_type_id          \n" + 
			"        and t.this_task_status=0\n" + 
			"        and t.md_acc_type_id=:moduleId\n" + 
			"        and task_alloted_to=0\n" + 
			"    order by\n" + 
			"        t.task_sche_time) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	List<TaskDetailsEmpName> unallocatedList(int moduleId);


	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"        t.*,\n" + 
			"        t.task_sche_time as time,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(DISTINCT (emp.emp_name))                            \n" + 
			"        FROM\n" + 
			"            m_employee emp                           \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(emp.emp_id, t.task_alloted_to)    ) as employee_name,\n" + 
			"        case              \n" + 
			"            when TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)>0 || (TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*24)>0 || (TIMESTAMPDIFF(MINUTE,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*60)>0 then 1                          \n" + 
			"            else 0                    \n" + 
			"        end  as sts,\n" + 
			"        ifnull(TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time),\n" + 
			"        0) as day,\n" + 
			"        ifnull(TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24,\n" + 
			"        0) AS hour,\n" + 
			"        ifnull(TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60,\n" + 
			"        0) AS minutes,\n" + 
			"        acc.md_acc_type_text,\n" + 
			"        (SELECT\n" + 
			"            count('')          \n" + 
			"        FROM\n" + 
			"            task_details          \n" + 
			"        WHERE\n" + 
			"            task_details.del_status=1               \n" + 
			"            AND task_details.is_active=1              \n" + 
			"            and t.pri_key=task_details.pri_key              \n" + 
			"            and t.md_acc_type_id=task_details.md_acc_type_id              \n" + 
			"            and task_details.this_task_status=1) as completed "
			+ "FROM\n" + 
			"        task_details t,\n" + 
			"        md_acc_type acc           \n" + 
			"    WHERE\n" + 
			"        t.del_status=1                   \n" + 
			"        AND t.is_active=1          \n" + 
			"        and t.md_acc_type_id=acc.md_acc_type_id          \n" + 
			"        and t.this_task_status=0\n" + 
			"        and t.md_acc_type_id=:moduleId\n" + 
			"        and task_alloted_to!=0\n" + 
			"    order by\n" + 
			"        t.task_sche_time) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	List<TaskDetailsEmpName> allocatedList(int moduleId);

	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"        t.*,\n" + 
			"        t.task_sche_time as time,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(DISTINCT (emp.emp_name))                            \n" + 
			"        FROM\n" + 
			"            m_employee emp                           \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(emp.emp_id, t.task_alloted_to)    ) as employee_name,\n" + 
			"        case              \n" + 
			"            when TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)>0 || (TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*24)>0 || (TIMESTAMPDIFF(MINUTE,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*60)>0 then 1                          \n" + 
			"            else 0                    \n" + 
			"        end  as sts,\n" + 
			"        ifnull(TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time),\n" + 
			"        0) as day,\n" + 
			"        ifnull(TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24,\n" + 
			"        0) AS hour,\n" + 
			"        ifnull(TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60,\n" + 
			"        0) AS minutes,\n" + 
			"        acc.md_acc_type_text,\n" + 
			"        (SELECT\n" + 
			"            count('')          \n" + 
			"        FROM\n" + 
			"            task_details          \n" + 
			"        WHERE\n" + 
			"            task_details.del_status=1               \n" + 
			"            AND task_details.is_active=1              \n" + 
			"            and t.pri_key=task_details.pri_key              \n" + 
			"            and t.md_acc_type_id=task_details.md_acc_type_id              \n" + 
			"            and task_details.this_task_status=1) as completed "
			+ "FROM\n" + 
			"        task_details t,\n" + 
			"        md_acc_type acc           \n" + 
			"    WHERE\n" + 
			"        t.del_status=1                   \n" + 
			"        AND t.is_active=1          \n" + 
			"        and t.md_acc_type_id=acc.md_acc_type_id          \n" + 
			"        and t.this_task_status=0\n" + 
			"        and t.md_acc_type_id=:moduleId \n" + 
			"        and (TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60)<0\n" + 
			"        and task_alloted_to!=0\n" + 
			"    order by\n" + 
			"        t.task_sche_time) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	List<TaskDetailsEmpName> pendingList(int moduleId);

	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"        t.*,\n" + 
			"        t.task_sche_time as time,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(DISTINCT (emp.emp_name))                            \n" + 
			"        FROM\n" + 
			"            m_employee emp                           \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(emp.emp_id, t.task_alloted_to)    ) as employee_name,\n" + 
			"        case              \n" + 
			"            when TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)>0 || (TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*24)>0 || (TIMESTAMPDIFF(MINUTE,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*60)>0 then 1                          \n" + 
			"            else 0                    \n" + 
			"        end  as sts,\n" + 
			"        ifnull(TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time),\n" + 
			"        0) as day,\n" + 
			"        ifnull(TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24,\n" + 
			"        0) AS hour,\n" + 
			"        ifnull(TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60,\n" + 
			"        0) AS minutes,\n" + 
			"        acc.md_acc_type_text,\n" + 
			"        (SELECT\n" + 
			"            count('')          \n" + 
			"        FROM\n" + 
			"            task_details          \n" + 
			"        WHERE\n" + 
			"            task_details.del_status=1               \n" + 
			"            AND task_details.is_active=1              \n" + 
			"            and t.pri_key=task_details.pri_key              \n" + 
			"            and t.md_acc_type_id=task_details.md_acc_type_id              \n" + 
			"            and task_details.this_task_status=1) as completed "
			+ "FROM\n" + 
			"        task_details t,\n" + 
			"        md_acc_type acc           \n" + 
			"    WHERE\n" + 
			"        t.del_status=1                   \n" + 
			"        AND t.is_active=1          \n" + 
			"        and t.md_acc_type_id=acc.md_acc_type_id          \n" + 
			"        and t.this_task_status=0\n" + 
			"        and t.md_acc_type_id=:moduleId \n" + 
			"        and (TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60)>0\n" + 
			"        and task_alloted_to!=0\n" + 
			"    order by\n" + 
			"        t.task_sche_time) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	List<TaskDetailsEmpName> remainingList(int moduleId);


	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"        t.*,\n" + 
			"        t.task_sche_time as time,\n" + 
			"        (SELECT\n" + 
			"             emp.emp_name                           \n" + 
			"        FROM\n" + 
			"            m_employee emp                           \n" + 
			"        WHERE\n" + 
			"            emp.emp_id=t.task_done_by) as employee_name,\n" + 
			"        case              \n" + 
			"            when TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)>0 || (TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*24)>0 || (TIMESTAMPDIFF(MINUTE,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*60)>0 then 1                          \n" + 
			"            else 0                    \n" + 
			"        end  as sts,\n" + 
			"        ifnull(TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time),\n" + 
			"        0) as day,\n" + 
			"        ifnull(TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24,\n" + 
			"        0) AS hour,\n" + 
			"        ifnull(TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60,\n" + 
			"        0) AS minutes,\n" + 
			"        acc.md_acc_type_text,\n" + 
			"        (SELECT\n" + 
			"            count('')          \n" + 
			"        FROM\n" + 
			"            task_details          \n" + 
			"        WHERE\n" + 
			"            task_details.del_status=1               \n" + 
			"            AND task_details.is_active=1              \n" + 
			"            and t.pri_key=task_details.pri_key              \n" + 
			"            and t.md_acc_type_id=task_details.md_acc_type_id              \n" + 
			"            and task_details.this_task_status=1) as completed "
			+ "FROM\n" + 
			"        task_details t,\n" + 
			"        md_acc_type acc           \n" + 
			"    WHERE\n" + 
			"        t.del_status=1                   \n" + 
			"        AND t.is_active=1          \n" + 
			"        and t.md_acc_type_id=acc.md_acc_type_id          \n" + 
			"        and t.this_task_status=1\n" + 
			"        and t.md_acc_type_id=:moduleId \n" + 
			"        and DATE_FORMAT(t.task_done_date, '%Y-%m-%d')=:date\n" + 
			"    order by\n" + 
			"        t.task_sche_time) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	List<TaskDetailsEmpName> completedList(int moduleId, String date);


	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"        t.*,\n" + 
			"        t.task_sche_time as time,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(DISTINCT (emp.emp_name))                            \n" + 
			"        FROM\n" + 
			"            m_employee emp                           \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(emp.emp_id, t.task_alloted_to)    ) as employee_name,\n" + 
			"        case              \n" + 
			"            when TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)>0 || (TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*24)>0 || (TIMESTAMPDIFF(MINUTE,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*60)>0 then 1                          \n" + 
			"            else 0                    \n" + 
			"        end  as sts,\n" + 
			"        ifnull(TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time),\n" + 
			"        0) as day,\n" + 
			"        ifnull(TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24,\n" + 
			"        0) AS hour,\n" + 
			"        ifnull(TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60,\n" + 
			"        0) AS minutes,\n" + 
			"        acc.md_acc_type_text,\n" + 
			"        (SELECT\n" + 
			"            count('')          \n" + 
			"        FROM\n" + 
			"            task_details          \n" + 
			"        WHERE\n" + 
			"            task_details.del_status=1               \n" + 
			"            AND task_details.is_active=1              \n" + 
			"            and t.pri_key=task_details.pri_key              \n" + 
			"            and t.md_acc_type_id=task_details.md_acc_type_id              \n" + 
			"            and task_details.this_task_status=1) as completed "
			+ "FROM\n" + 
			"        task_details t,\n" + 
			"        md_acc_type acc           \n" + 
			"    WHERE\n" + 
			"        t.del_status=1                   \n" + 
			"        AND t.is_active=1          \n" + 
			"        and t.md_acc_type_id=acc.md_acc_type_id          \n" + 
			"        and t.this_task_status=0 and task_alloted_to=0\n" + 
			"    order by\n" + 
			"        t.task_sche_time) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	List<TaskDetailsEmpName> unallocatedListAll();


	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"        t.*,\n" + 
			"        t.task_sche_time as time,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(DISTINCT (emp.emp_name))                            \n" + 
			"        FROM\n" + 
			"            m_employee emp                           \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(emp.emp_id, t.task_alloted_to)    ) as employee_name,\n" + 
			"        case              \n" + 
			"            when TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)>0 || (TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*24)>0 || (TIMESTAMPDIFF(MINUTE,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*60)>0 then 1                          \n" + 
			"            else 0                    \n" + 
			"        end  as sts,\n" + 
			"        ifnull(TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time),\n" + 
			"        0) as day,\n" + 
			"        ifnull(TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24,\n" + 
			"        0) AS hour,\n" + 
			"        ifnull(TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60,\n" + 
			"        0) AS minutes,\n" + 
			"        acc.md_acc_type_text,\n" + 
			"        (SELECT\n" + 
			"            count('')          \n" + 
			"        FROM\n" + 
			"            task_details          \n" + 
			"        WHERE\n" + 
			"            task_details.del_status=1               \n" + 
			"            AND task_details.is_active=1              \n" + 
			"            and t.pri_key=task_details.pri_key              \n" + 
			"            and t.md_acc_type_id=task_details.md_acc_type_id              \n" + 
			"            and task_details.this_task_status=1) as completed "
			+ "FROM\n" + 
			"        task_details t,\n" + 
			"        md_acc_type acc           \n" + 
			"    WHERE\n" + 
			"        t.del_status=1                   \n" + 
			"        AND t.is_active=1          \n" + 
			"        and t.md_acc_type_id=acc.md_acc_type_id          \n" + 
			"        and t.this_task_status=0 and task_alloted_to!=0\n" + 
			"    order by\n" + 
			"        t.task_sche_time) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	List<TaskDetailsEmpName> allocatedListAll();

	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"        t.*,\n" + 
			"        t.task_sche_time as time,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(DISTINCT (emp.emp_name))                            \n" + 
			"        FROM\n" + 
			"            m_employee emp                           \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(emp.emp_id, t.task_alloted_to)    ) as employee_name,\n" + 
			"        case              \n" + 
			"            when TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)>0 || (TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*24)>0 || (TIMESTAMPDIFF(MINUTE,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*60)>0 then 1                          \n" + 
			"            else 0                    \n" + 
			"        end  as sts,\n" + 
			"        ifnull(TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time),\n" + 
			"        0) as day,\n" + 
			"        ifnull(TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24,\n" + 
			"        0) AS hour,\n" + 
			"        ifnull(TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60,\n" + 
			"        0) AS minutes,\n" + 
			"        acc.md_acc_type_text,\n" + 
			"        (SELECT\n" + 
			"            count('')          \n" + 
			"        FROM\n" + 
			"            task_details          \n" + 
			"        WHERE\n" + 
			"            task_details.del_status=1               \n" + 
			"            AND task_details.is_active=1              \n" + 
			"            and t.pri_key=task_details.pri_key              \n" + 
			"            and t.md_acc_type_id=task_details.md_acc_type_id              \n" + 
			"            and task_details.this_task_status=1) as completed "
			+ "FROM\n" + 
			"        task_details t,\n" + 
			"        md_acc_type acc           \n" + 
			"    WHERE\n" + 
			"        t.del_status=1                   \n" + 
			"        AND t.is_active=1          \n" + 
			"        and t.md_acc_type_id=acc.md_acc_type_id          \n" + 
			"        and t.this_task_status=0 and (TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60)<0\n" + 
			"        and task_alloted_to!=0\n" + 
			"    order by\n" + 
			"        t.task_sche_time) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	List<TaskDetailsEmpName> pendingListAll();

	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"        t.*,\n" + 
			"        t.task_sche_time as time,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(DISTINCT (emp.emp_name))                            \n" + 
			"        FROM\n" + 
			"            m_employee emp                           \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(emp.emp_id, t.task_alloted_to)    ) as employee_name,\n" + 
			"        case              \n" + 
			"            when TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)>0 || (TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*24)>0 || (TIMESTAMPDIFF(MINUTE,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*60)>0 then 1                          \n" + 
			"            else 0                    \n" + 
			"        end  as sts,\n" + 
			"        ifnull(TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time),\n" + 
			"        0) as day,\n" + 
			"        ifnull(TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24,\n" + 
			"        0) AS hour,\n" + 
			"        ifnull(TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60,\n" + 
			"        0) AS minutes,\n" + 
			"        acc.md_acc_type_text,\n" + 
			"        (SELECT\n" + 
			"            count('')          \n" + 
			"        FROM\n" + 
			"            task_details          \n" + 
			"        WHERE\n" + 
			"            task_details.del_status=1               \n" + 
			"            AND task_details.is_active=1              \n" + 
			"            and t.pri_key=task_details.pri_key              \n" + 
			"            and t.md_acc_type_id=task_details.md_acc_type_id              \n" + 
			"            and task_details.this_task_status=1) as completed "
			+ "FROM\n" + 
			"        task_details t,\n" + 
			"        md_acc_type acc           \n" + 
			"    WHERE\n" + 
			"        t.del_status=1                   \n" + 
			"        AND t.is_active=1          \n" + 
			"        and t.md_acc_type_id=acc.md_acc_type_id          \n" + 
			"        and t.this_task_status=0 and (TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60)>0\n" + 
			"        and task_alloted_to!=0\n" + 
			"    order by\n" + 
			"        t.task_sche_time) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	List<TaskDetailsEmpName> remainingListAll();

	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"        t.*,\n" + 
			"        t.task_sche_time as time,\n" + 
			"        (SELECT\n" + 
			"             emp.emp_name                           \n" + 
			"        FROM\n" + 
			"            m_employee emp                           \n" + 
			"        WHERE\n" + 
			"            emp.emp_id=t.task_done_by) as employee_name,\n" + 
			"        case              \n" + 
			"            when TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)>0 || (TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*24)>0 || (TIMESTAMPDIFF(MINUTE,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*60)>0 then 1                          \n" + 
			"            else 0                    \n" + 
			"        end  as sts,\n" + 
			"        ifnull(TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time),\n" + 
			"        0) as day,\n" + 
			"        ifnull(TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24,\n" + 
			"        0) AS hour,\n" + 
			"        ifnull(TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60,\n" + 
			"        0) AS minutes,\n" + 
			"        acc.md_acc_type_text,\n" + 
			"        (SELECT\n" + 
			"            count('')          \n" + 
			"        FROM\n" + 
			"            task_details          \n" + 
			"        WHERE\n" + 
			"            task_details.del_status=1               \n" + 
			"            AND task_details.is_active=1              \n" + 
			"            and t.pri_key=task_details.pri_key              \n" + 
			"            and t.md_acc_type_id=task_details.md_acc_type_id              \n" + 
			"            and task_details.this_task_status=1) as completed "
			+ "FROM\n" + 
			"        task_details t,\n" + 
			"        md_acc_type acc           \n" + 
			"    WHERE\n" + 
			"        t.del_status=1                   \n" + 
			"        AND t.is_active=1          \n" + 
			"        and t.md_acc_type_id=acc.md_acc_type_id          \n" + 
			"        and t.this_task_status=1 and DATE_FORMAT(t.task_done_date, '%Y-%m-%d')=:date\n" + 
			"    order by\n" + 
			"        t.task_sche_time) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	List<TaskDetailsEmpName> completedListAll(String date);


	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"        t.*,\n" + 
			"        t.task_sche_time as time,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(DISTINCT (emp.emp_name))                            \n" + 
			"        FROM\n" + 
			"            m_employee emp                           \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(emp.emp_id, t.task_alloted_to)    ) as employee_name,\n" + 
			"        case              \n" + 
			"            when TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)>0 || (TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*24)>0 || (TIMESTAMPDIFF(MINUTE,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*60)>0 then 1                          \n" + 
			"            else 0                    \n" + 
			"        end  as sts,\n" + 
			"        ifnull(TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time),\n" + 
			"        0) as day,\n" + 
			"        ifnull(TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24,\n" + 
			"        0) AS hour,\n" + 
			"        ifnull(TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60,\n" + 
			"        0) AS minutes,\n" + 
			"        acc.md_acc_type_text,\n" + 
			"        (SELECT\n" + 
			"            count('')          \n" + 
			"        FROM\n" + 
			"            task_details          \n" + 
			"        WHERE\n" + 
			"            task_details.del_status=1               \n" + 
			"            AND task_details.is_active=1              \n" + 
			"            and t.pri_key=task_details.pri_key              \n" + 
			"            and t.md_acc_type_id=task_details.md_acc_type_id              \n" + 
			"            and task_details.this_task_status=1) as completed "
			+ "FROM\n" + 
			"        task_details t,\n" + 
			"        md_acc_type acc           \n" + 
			"    WHERE\n" + 
			"        t.del_status=1                   \n" + 
			"        AND t.is_active=1          \n" + 
			"        and t.md_acc_type_id=acc.md_acc_type_id          \n" + 
			"        and t.this_task_status=0\n" + 
			"        and t.md_acc_type_id=:moduleId\n" + 
			"         and t.task_final_status=:status\n" + 
			"    order by\n" + 
			"        t.task_sche_time) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	List<TaskDetailsEmpName> getTaskByStatusWiseList(int moduleId, int status);


	@Query(value="select a.*, \n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_city_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_city_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_city_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.m_state_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.m_state_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as m_state_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (c.acc_domain_id)             \n" + 
			"            when a.md_acc_type_id=2 then (b.inq_domain_id)             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as domain_id,\n" + 
			"ifnull(case                                        \n" + 
			"            when a.md_acc_type_id=1 then (concat(c.acc_company,'-',c.acc_company_landline))             \n" + 
			"            when a.md_acc_type_id=2 then (concat(b.inq_company,'-',b.inq_company_landline))             \n" + 
			"            else 0                                      \n" + 
			"        end,\n" + 
			"        0)  as company_info,\n" + 
			"        ifnull(case                                                     \n" + 
			"            when a.md_acc_type_id=1 then (select m_channel_name from m_channel where m_channel_id=c.channel_id)                          \n" + 
			"            when a.md_acc_type_id=2 then (select m_channel_name from m_channel where m_channel_id=b.channel_id)                          \n" + 
			"            else 0                                               \n" + 
			"        end,\n" + 
			"        0)  as channel_name\n" + 
			"from (SELECT\n" + 
			"        t.*,\n" + 
			"        t.task_sche_time as time,\n" + 
			"        (SELECT\n" + 
			"            GROUP_CONCAT(DISTINCT (emp.emp_name))                            \n" + 
			"        FROM\n" + 
			"            m_employee emp                           \n" + 
			"        WHERE\n" + 
			"            FIND_IN_SET(emp.emp_id, t.task_alloted_to)    ) as employee_name,\n" + 
			"        case              \n" + 
			"            when TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)>0 || (TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*24)>0 || (TIMESTAMPDIFF(MINUTE,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"            NOW(),\n" + 
			"            t.task_sche_time)*60)>0 then 1                          \n" + 
			"            else 0                    \n" + 
			"        end  as sts,\n" + 
			"        ifnull(TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time),\n" + 
			"        0) as day,\n" + 
			"        ifnull(TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(DAY,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*24,\n" + 
			"        0) AS hour,\n" + 
			"        ifnull(TIMESTAMPDIFF(MINUTE,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)-TIMESTAMPDIFF(HOUR,\n" + 
			"        NOW(),\n" + 
			"        t.task_sche_time)*60,\n" + 
			"        0) AS minutes,\n" + 
			"        acc.md_acc_type_text,\n" + 
			"        (SELECT\n" + 
			"            count('')          \n" + 
			"        FROM\n" + 
			"            task_details          \n" + 
			"        WHERE\n" + 
			"            task_details.del_status=1               \n" + 
			"            AND task_details.is_active=1              \n" + 
			"            and t.pri_key=task_details.pri_key              \n" + 
			"            and t.md_acc_type_id=task_details.md_acc_type_id              \n" + 
			"            and task_details.this_task_status=1) as completed "
			+ "FROM\n" + 
			"        task_details t,\n" + 
			"        md_acc_type acc           \n" + 
			"    WHERE\n" + 
			"        t.del_status=1                   \n" + 
			"        AND t.is_active=1          \n" + 
			"        and t.md_acc_type_id=acc.md_acc_type_id          \n" + 
			"        and t.this_task_status=0\n" + 
			"        and t.md_acc_type_id=:moduleId "
			+ " order by\n" + 
			"        t.task_sche_time) a\n" + 
			"left join (\n" + 
			"        select\n" + 
			"                * \n" + 
			"            from\n" + 
			"                inquiry_header \n" + 
			"\n" + 
			")b on a.pri_key=b.inq_id\n" + 
			"left join (\n" + 
			"            select\n" + 
			"                *\n" + 
			"            from\n" + 
			"                lms_header \n" + 
			"                )c on a.pri_key=c.lms_id",nativeQuery=true)
	List<TaskDetailsEmpName> getTaskByStatusWiseList(int moduleId);
	
	
}
