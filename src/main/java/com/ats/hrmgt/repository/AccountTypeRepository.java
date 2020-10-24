package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.AccountTpye;

public interface AccountTypeRepository extends JpaRepository<AccountTpye, Integer> {
	
	@Query(value="SELECT * FROM md_acc_type WHERE del_status=1 "
			,nativeQuery=true)
	List<AccountTpye> getAllAccountTypeByDelStatus();

}
