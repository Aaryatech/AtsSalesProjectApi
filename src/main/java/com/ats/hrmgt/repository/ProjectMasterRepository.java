package com.ats.hrmgt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.ProjectsMaster;
import com.ats.hrmgt.model.ServerMaster;

public interface ProjectMasterRepository extends JpaRepository<ProjectsMaster,Integer> {
	
	
	
	@Query(value="SELECT * FROM  m_projects WHERE del_status=1",nativeQuery=true)
	List<ProjectsMaster> getAllProjectList();
	
	@Query(value="SELECT * FROM  m_projects WHERE del_status=1 AND project_id=:pId ",nativeQuery=true)
	ProjectsMaster getProjectById(@Param("pId") int pId);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_projects SET del_status=0 WHERE project_id=:pId ",nativeQuery=true)
	int deleteProject(@Param("pId") int pId);
	
	
	

}
