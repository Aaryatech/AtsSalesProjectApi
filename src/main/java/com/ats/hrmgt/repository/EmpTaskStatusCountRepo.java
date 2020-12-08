package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.EmpTaskStatusCount; 

public interface EmpTaskStatusCountRepo extends JpaRepository<EmpTaskStatusCount, Integer>{

	@Query(value=" select\n" + 
			"            uuid() as id,\n" + 
			"            count('') as task_count,\n" + 
			"            t.task_final_status as status,sum(t.task_pts) as task_pts\n" + 
			"        from\n" + 
			"            task_details t \n" + 
			"        where \n" + 
			"        t.this_task_status=0\n" + 
			"        and FIND_IN_SET(:empId, t.task_alloted_to) and t.md_acc_type_id=:moduleId and t.del_status=1\n" + 
			"    group by task_final_status",nativeQuery=true)
	List<EmpTaskStatusCount> getempTaskStatusWiseDetail(int empId,int moduleId);

	
}
