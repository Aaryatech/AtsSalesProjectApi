package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {
	
	//Fetch All Records From Channeel Where del_status And is_active Is True
	@Query(value="SELECT * FROM m_channel Where del_status=true AND is_active=true",nativeQuery=true)
	List<Channel> getAllChannelList();

}
