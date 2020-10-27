package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.DomainType;

public interface DomainTypeRepository extends JpaRepository<DomainType, Integer> {
	
	//Fetch All Record From m_domain_type Where del_staus And is_active = TRUE
	@Query(value="SELECT * FROM m_domain_type WHERE del_status=true AND is_active=true",nativeQuery=true)
	List<DomainType> getAllDomainTypelist();

}
