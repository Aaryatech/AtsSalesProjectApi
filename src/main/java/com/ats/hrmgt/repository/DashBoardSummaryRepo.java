package com.ats.hrmgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.hrmgt.model.DashBoardSummary;

public interface DashBoardSummaryRepo extends JpaRepository<DashBoardSummary, Integer> {

	@Query(value="SELECT\n" + 
			"    UUID() AS id,(\n" + 
			"    SELECT\n" + 
			"        COUNT('')\n" + 
			"    FROM\n" + 
			"        task_details t\n" + 
			"    WHERE\n" + 
			"        t.task_sche_date =:date AND FIND_IN_SET(:userId, t.task_alloted_to) AND t.this_task_status = 0 and t.del_status=1\n" + 
			") AS today_count,\n" + 
			"(\n" + 
			"    SELECT\n" + 
			"        COUNT('')\n" + 
			"    FROM\n" + 
			"        task_details t\n" + 
			"    WHERE\n" + 
			"        DATE_FORMAT(t.task_done_date, '%Y-%m-%d') =:date  AND t.task_done_by =:userId and t.del_status=1\n" + 
			") AS today_completed,\n" + 
			"(\n" + 
			"    SELECT\n" + 
			"        COUNT('')\n" + 
			"    FROM\n" + 
			"        task_details t\n" + 
			"    WHERE\n" + 
			"        (\n" + 
			"            TIMESTAMPDIFF(MINUTE, NOW(), t.task_sche_time) - TIMESTAMPDIFF(HOUR, NOW(), t.task_sche_time) * 60) < 0 AND t.this_task_status = 0 AND FIND_IN_SET(:userId, t.task_alloted_to) and t.del_status=1) AS pending_count,\n" + 
			"            (\n" + 
			"            SELECT\n" + 
			"                COUNT('')\n" + 
			"            FROM\n" + 
			"                task_details t\n" + 
			"            WHERE\n" + 
			"                (\n" + 
			"                    TIMESTAMPDIFF(MINUTE, NOW(), t.task_sche_time) - TIMESTAMPDIFF(HOUR, NOW(), t.task_sche_time) * 60) > 0 AND t.this_task_status = 0 AND FIND_IN_SET(:userId, t.task_alloted_to) and t.del_status=1) AS remaining_count,\n" + 
			"                    (\n" + 
			"                    SELECT\n" + 
			"                        IFNULL(SUM(t.task_pts),\n" + 
			"                        0)\n" + 
			"                    FROM\n" + 
			"                        task_details t\n" + 
			"                    WHERE\n" + 
			"                        DATE_FORMAT(t.task_done_date, '%Y-%m-%d') =:date AND t.task_done_by =:userId and t.del_status=1\n" + 
			"                ) AS today_completed_pts,\n" + 
			"                (\n" + 
			"                SELECT\n" + 
			"                    IFNULL(SUM(t.task_pts),\n" + 
			"                    0)\n" + 
			"                FROM\n" + 
			"                    task_details t\n" + 
			"                WHERE\n" + 
			"                    (\n" + 
			"                        TIMESTAMPDIFF(MINUTE, NOW(), t.task_sche_time) - TIMESTAMPDIFF(HOUR, NOW(), t.task_sche_time) * 60) < 0 AND t.this_task_status = 0 AND FIND_IN_SET(:userId, t.task_alloted_to) and t.del_status=1) AS pending_pts,\n" + 
			"(SELECT \n" + 
			" 	COUNT('')\n" + 
			" FROM\n" + 
			" 	lms_header h\n" + 
			" WHERE\n" + 
			" 	h.maker_user_id=:userId AND  DATE_FORMAT(h.maker_datetime, '%Y-%m-%d') =:date and h.del_status=1\n" + 
			"\n" + 
			")AS todays_lead_count,\n" + 
			"(SELECT \n" + 
			" 	COUNT('')\n" + 
			" FROM\n" + 
			" 	inquiry_header i\n" + 
			" WHERE\n" + 
			" 	i.maker_user_id=:userId AND  DATE_FORMAT(i.maker_datetime, '%Y-%m-%d') =:date and i.del_status=1\n" + 
			"\n" + 
			")AS todays_inq_count",nativeQuery=true)
	DashBoardSummary getRegularDashboardSummry(int userId, String date);

}
