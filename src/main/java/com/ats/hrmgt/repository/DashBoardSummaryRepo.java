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
			"        t.task_sche_date = :date AND FIND_IN_SET(:userId, t.task_alloted_to) AND t.this_task_status = 0 AND t.del_status = 1\n" + 
			") AS today_count,\n" + 
			"(\n" + 
			"    SELECT\n" + 
			"        COUNT('')\n" + 
			"    FROM\n" + 
			"        task_details t\n" + 
			"    WHERE\n" + 
			"        DATE_FORMAT(t.task_done_date, '%Y-%m-%d') = :date AND t.task_done_by = :userId AND t.del_status = 1\n" + 
			") AS today_completed,\n" + 
			"(\n" + 
			"    SELECT\n" + 
			"        COUNT('')\n" + 
			"    FROM\n" + 
			"        task_details t\n" + 
			"    WHERE\n" + 
			"        (\n" + 
			"            TIMESTAMPDIFF(\n" + 
			"                MINUTE,\n" + 
			"                NOW(), t.task_sche_time) - TIMESTAMPDIFF(HOUR, NOW(), t.task_sche_time) * 60) < 0 AND t.this_task_status = 0 AND FIND_IN_SET(:userId, t.task_alloted_to) AND t.del_status = 1\n" + 
			"            ) AS pending_count,\n" + 
			"            (\n" + 
			"            SELECT\n" + 
			"                COUNT('')\n" + 
			"            FROM\n" + 
			"                task_details t\n" + 
			"            WHERE\n" + 
			"                (\n" + 
			"                    TIMESTAMPDIFF(\n" + 
			"                        MINUTE,\n" + 
			"                        NOW(), t.task_sche_time) - TIMESTAMPDIFF(HOUR, NOW(), t.task_sche_time) * 60) > 0 AND t.this_task_status = 0 AND FIND_IN_SET(:userId, t.task_alloted_to) AND t.del_status = 1\n" + 
			"                    ) AS remaining_count,\n" + 
			"                    (\n" + 
			"                    SELECT\n" + 
			"                        IFNULL(SUM(t.task_pts),\n" + 
			"                        0)\n" + 
			"                    FROM\n" + 
			"                        task_details t\n" + 
			"                    WHERE\n" + 
			"                        DATE_FORMAT(t.task_done_date, '%Y-%m-%d') = :date AND t.task_done_by = :userId AND t.del_status = 1\n" + 
			"                ) AS today_completed_pts,\n" + 
			"                (\n" + 
			"                SELECT\n" + 
			"                    IFNULL(SUM(t.task_pts),\n" + 
			"                    0)\n" + 
			"                FROM\n" + 
			"                    task_details t\n" + 
			"                WHERE\n" + 
			"                    (\n" + 
			"                        TIMESTAMPDIFF(\n" + 
			"                            MINUTE,\n" + 
			"                            NOW(), t.task_sche_time) - TIMESTAMPDIFF(HOUR, NOW(), t.task_sche_time) * 60) < 0 AND t.this_task_status = 0 AND FIND_IN_SET(:userId, t.task_alloted_to) AND t.del_status = 1\n" + 
			"                        ) AS pending_pts,\n" + 
			"                        (\n" + 
			"                        SELECT\n" + 
			"                            COUNT('')\n" + 
			"                        FROM\n" + 
			"                            lms_header h\n" + 
			"                        WHERE\n" + 
			"                            h.maker_user_id = :userId AND DATE_FORMAT(h.maker_datetime, '%Y-%m-%d') = :date AND h.del_status = 1\n" + 
			"                    ) AS todays_lead_count,\n" + 
			"                    (\n" + 
			"                    SELECT\n" + 
			"                        COUNT('')\n" + 
			"                    FROM\n" + 
			"                        inquiry_header i\n" + 
			"                    WHERE\n" + 
			"                        i.maker_user_id = :userId AND DATE_FORMAT(i.maker_datetime, '%Y-%m-%d') = :date AND i.del_status = 1\n" + 
			"                ) AS todays_inq_count,\n" + 
			"                (\n" + 
			"                SELECT\n" + 
			"                    COUNT('')\n" + 
			"                FROM\n" + 
			"                    task_details\n" + 
			"                WHERE\n" + 
			"                    del_status = 1 AND task_final_status = 5 AND task_Sche_date LIKE :date AND task_alloted_to = :userId\n" + 
			"            ) AS sche_demo_cnt,\n" + 
			"            (\n" + 
			"            SELECT\n" + 
			"                COUNT('')\n" + 
			"            FROM\n" + 
			"                lms_header h\n" + 
			"            WHERE\n" + 
			"                h.maker_user_id = :userId AND DATE_FORMAT(h.maker_datetime, '%Y-%m-%d') BETWEEN :mStartDate AND :mEndDate  AND h.del_status = 1\n" + 
			"        ) AS monthly_lead_count,\n" + 
			"             (\n" + 
			"                SELECT\n" + 
			"                    COUNT('')\n" + 
			"                FROM\n" + 
			"                    task_details\n" + 
			"                WHERE\n" + 
			"                    del_status = 1 AND task_final_status = 5 AND task_Sche_date BETWEEN :mStartDate AND :mEndDate AND task_alloted_to = :userId\n" + 
			"            ) AS month_sche_demo,\n" + 
			"              (\n" + 
			"                    SELECT\n" + 
			"                        COUNT('')\n" + 
			"                    FROM\n" + 
			"                        inquiry_header i\n" + 
			"                    WHERE\n" + 
			"                        i.maker_user_id =:userId AND DATE_FORMAT(i.maker_datetime, '%Y-%m-%d') BETWEEN :mStartDate AND :mEndDate AND i.del_status = 1\n" + 
			"                ) AS monthly_inq_count",nativeQuery=true)
	DashBoardSummary getRegularDashboardSummry(int userId, String date,String mStartDate,String mEndDate);

}
