package com.ats.hrmgt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.CustomerMst;

public interface CustomerMstRepo extends JpaRepository<CustomerMst,Integer> {
	
	@Query(value="SELECT * FROM m_customer WHERE del_status=1 ",nativeQuery=true)
	List<CustomerMst> getAllCustomerList();
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_customer SET del_status=0 WHERE cust_id=:custId",nativeQuery=true)
	int deleteCustMst(@Param("custId") int custId);

	@Query(value="SELECT * FROM m_customer WHERE  del_status=1 AND cust_id=:custId",nativeQuery=true)
	CustomerMst getCustById(@Param("custId") int custId);
	
	
	
}
