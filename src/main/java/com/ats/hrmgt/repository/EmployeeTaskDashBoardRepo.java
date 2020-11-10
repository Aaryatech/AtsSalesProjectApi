package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.EmployeeTaskDashBoard;

public interface EmployeeTaskDashBoardRepo extends JpaRepository<EmployeeTaskDashBoard, Integer>{

	@Query(value=" select e.emp_id, e.emp_name from  m_employee e where e.del_status=1 and e.is_active=1",nativeQuery=true)
	List<EmployeeTaskDashBoard> employeewiseTaskwiseList();

}
