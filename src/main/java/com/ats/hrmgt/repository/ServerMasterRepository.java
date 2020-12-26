package com.ats.hrmgt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.ServerMaster;

public interface ServerMasterRepository  extends JpaRepository<ServerMaster, Integer>{

	
	@Query(value="SELECT * FROM  m_servers WHERE del_status=1",nativeQuery=true)
	List<ServerMaster> getAllServerList();
	
	@Query(value="SELECT * FROM  m_servers WHERE del_status=1 AND server_id=:sId ",nativeQuery=true)
	ServerMaster getServerById(@Param("sId") int sId);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_servers SET del_status=0 WHERE server_id=:sId ",nativeQuery=true)
	int deleteServer(@Param("sId") int sId);
	
	
}
