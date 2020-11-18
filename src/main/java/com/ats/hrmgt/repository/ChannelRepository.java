package com.ats.hrmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {
	
	//Fetch All Records From Channeel Where del_status And is_active Is True
	@Query(value="SELECT * FROM m_channel Where del_status=1 AND is_active=1",nativeQuery=true)
	List<Channel> getAllChannelList();

	@Query(value="SELECT * FROM m_channel Where m_channel_name=:channelName",nativeQuery=true)
	Channel findByChannelName(String channelName);

}
