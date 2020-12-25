package com.ats.hrmgt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.hrmgt.model.Hardware;

public interface HardwareRepo extends JpaRepository<Hardware, Integer> {

	List<Hardware> findByDelStatusOrderByHardwareIdDesc(int del);
	
	Hardware findByHardwareId(int hardwareId);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE `m_hardware` SET del_status=0 WHERE hardware_id=:hardwareId",nativeQuery=true)
	public int deleteHardware(@Param("hardwareId") int hardwareId);
}
