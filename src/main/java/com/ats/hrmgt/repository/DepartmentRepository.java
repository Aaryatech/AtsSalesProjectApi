package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	
	
	//Fetch All Department Where del_status=true And is_active=true
	@Query(value="SELECT * FROM m_department WHERE del_status=true AND is_active=true",nativeQuery=true)
	List<Department> getAllDepartment();
	

}
