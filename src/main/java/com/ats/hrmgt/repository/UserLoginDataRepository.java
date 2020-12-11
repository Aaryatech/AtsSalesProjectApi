package com.ats.hrmgt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.UserLoginData;

public interface UserLoginDataRepository extends JpaRepository<UserLoginData, Integer> {
	
	@Query(value="SELECT emp_id,  md_acc_type_id,  emp_dept,  emp_name,  emp_username,  emp_mobile,  emp_password,  emp_access_id, del_status, is_active, maker_user_id,maker_datetime ,user_type_id,ex_var1 AS email FROM m_employee WHERE emp_username=:empUsername AND emp_password=:empPassword  AND del_status = 1 ",
			nativeQuery=true)
	UserLoginData getUserByUsernameAndPAssword(@Param("empUsername") String empUsername,
												@Param("empPassword") String empPassword);

}
