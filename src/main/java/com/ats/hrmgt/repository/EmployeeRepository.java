package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
	
	
	//To Fetch All Records From m_employee Where del_status And is_active Is True
	@Query(value="SELECT * FROM m_employee WHERE del_Status=true AND is_active=true",nativeQuery=true)
	List<Employee> getAllEmployeeList();
	
	
	
	
	//To Find Record Where md_acc_type_id Is Matched(Using FIND_IN_SET)
	@Query(value="SELECT * FROM `m_employee` WHERE FIND_IN_SET(:mdAccTypeId,md_acc_type_id)",nativeQuery=true)
	List<Employee> findEmployeeBymdAccTypeId(@Param("mdAccTypeId") String mdAccTypeId);

}
