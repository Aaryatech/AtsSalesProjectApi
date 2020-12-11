package com.ats.hrmgt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.common.DateConvertor;
import com.ats.hrmgt.model.Channel;
import com.ats.hrmgt.model.CustInfo;
import com.ats.hrmgt.model.DashBoardSummary;
import com.ats.hrmgt.model.Designation;
import com.ats.hrmgt.model.Employee;
import com.ats.hrmgt.model.Info;
import com.ats.hrmgt.model.InquiryDetail;
import com.ats.hrmgt.model.InquiryHeader;
import com.ats.hrmgt.model.InquiryHeaderWithNames;
import com.ats.hrmgt.model.LmsDetail;
import com.ats.hrmgt.model.LmsHeader;
import com.ats.hrmgt.model.LmsHeaderWithNames;
import com.ats.hrmgt.model.States;
import com.ats.hrmgt.model.Tags;
import com.ats.hrmgt.model.TaskDetails;
import com.ats.hrmgt.model.TaskDetailsEmpName;
import com.ats.hrmgt.model.TaskStatus;
import com.ats.hrmgt.repository.ChannelRepository;
import com.ats.hrmgt.repository.CustInfoRepo;
import com.ats.hrmgt.repository.DashBoardSummaryRepo;
import com.ats.hrmgt.repository.DesignationRepository;
import com.ats.hrmgt.repository.EmployeeRepository;
import com.ats.hrmgt.repository.InquiryDetailRepository;
import com.ats.hrmgt.repository.InquiryHeaderRepository;
import com.ats.hrmgt.repository.InquiryHeaderWithNamesRepository;
import com.ats.hrmgt.repository.LmsDetailRepository;
import com.ats.hrmgt.repository.LmsHeaderRepository;
import com.ats.hrmgt.repository.LmsHeaderWithNamesRepository;
import com.ats.hrmgt.repository.TagsRepository;
import com.ats.hrmgt.repository.TaskDetailEmpNameRepo;
import com.ats.hrmgt.repository.TaskDetailsRepository;
import com.ats.hrmgt.repository.TaskStatusRepository;

@RestController
public class MasterApiController {

	@Autowired
	TagsRepository tagsRepo;

	@Autowired
	TaskStatusRepository taskStatusRepo;

	@Autowired
	ChannelRepository channelRepo;

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	TaskDetailEmpNameRepo taskDetailEmpRepo;

	@Autowired
	TaskDetailsRepository taskDetailsRepo;

	// To Fetch Records With Account Type Names,Tag Names And Channel Names
	@Autowired
	LmsHeaderWithNamesRepository lmsHeaderWnamesRepo;

	@Autowired
	LmsDetailRepository lmsDetailRepo;

	// To Save And Delete Inquiry Header
	@Autowired
	InquiryHeaderRepository inquiryHeaderRepo;

	// To Fetch Data From inquiry_header With Channel Name And Tag Names
	@Autowired
	InquiryHeaderWithNamesRepository inquiryHeadWithNames;

	@Autowired
	InquiryDetailRepository inquiryDetailRepo;

	// To Add Or Delete LMS Header
	@Autowired
	LmsHeaderRepository lmsHeadRepo;

	@Autowired
	CustInfoRepo custInfoRepo;

	@Autowired
	DashBoardSummaryRepo dashBoardSummaryRepo;

	// To Fetch All Tags By m_acc_type_id Where del_status & is_active Status is
	// True
	@RequestMapping(value = "/getTagBymAccTypeId", method = RequestMethod.POST)
	public @ResponseBody List<Tags> getTagBymAccTypeId(@RequestParam int mAccTypeId) {
		List<Tags> tagResponse = new ArrayList<Tags>();
		try {
			tagResponse = tagsRepo.getTagBymAccTypeId(mAccTypeId);
		} catch (Exception e) {
			// TODO: handle exception
			tagResponse = new ArrayList<Tags>();
			//// System.err.println("Some Exception Occurs In Catch Block Of
			//// /getTagBymAccTypeId Mapping");
			e.printStackTrace();
		}

		return tagResponse;
	}

	// To Fetch All Tags Where del_status And is_active Is True
	@RequestMapping(value = "/getAllTagsList", method = RequestMethod.POST)
	public @ResponseBody List<Tags> getAllTagsList() {
		List<Tags> tagResponse = new ArrayList<Tags>();
		try {
			tagResponse = tagsRepo.getAllTagsList();
		} catch (Exception e) {
			// TODO: handle exception
			tagResponse = new ArrayList<Tags>();
			//// System.err.println("Exception Occurs In Catch Block Of /getAllTagsList
			//// Mapping");
			e.printStackTrace();
		}

		return tagResponse;

	}

	// To Fetch List Of All TaskStatus Where del_status And is_active Is True
	@RequestMapping(value = "/getAllTaskStatusList", method = RequestMethod.POST)
	public @ResponseBody List<TaskStatus> getAllTaskStatusList() {
		List<TaskStatus> taskStatuslistResp = new ArrayList<TaskStatus>();

		try {
			taskStatuslistResp = taskStatusRepo.getAllTaskStatusList();
			//// System.err.println("Response For getAllTaskStatusList Is" + "\n" +
			//// taskStatuslistResp);
		} catch (Exception e) {
			// TODO: handle exception
			taskStatuslistResp = new ArrayList<TaskStatus>();
			//// System.err.println("Exception Occurs!!! In Catch Block Of
			//// /getAllTaskStatusList Mapping");
			e.printStackTrace();
		}
		return taskStatuslistResp;
	}

	// To Fetch Record Where ms_acc_type_id And m_task_status_sequence Matched
	@RequestMapping(value = "/getTaskStatusByAccTypeIdAndSequnce", method = RequestMethod.POST)
	public @ResponseBody List<TaskStatus> getTaskStatusByAccTypeIdAndSequnce(@RequestParam int mdAccTypeId,
			@RequestParam int statusSequence) {
		List<TaskStatus> taskStatuslist = new ArrayList<TaskStatus>();

		try {
			taskStatuslist = taskStatusRepo.getTaskStatusByAccTypeIdAndSequnce(mdAccTypeId, statusSequence);
			//// System.err.println("Responce Of /statusSequence =" + "\n" +
			//// taskStatuslist);
		} catch (Exception e) {
			taskStatuslist = new ArrayList<TaskStatus>();
			//// System.err.println("Exceotion Occured!!! In Catch Block Of /statusSequence
			//// Mapping");
			e.printStackTrace();
			// TODO: handle exception
		}

		return taskStatuslist;

	}

	// To Fetch Records From Task Status By m_acc_type_id Where del_status And
	// is_active Status is True
	@RequestMapping(value = "/getAllTaskStatusBymdAccTypeId", method = RequestMethod.POST)
	public @ResponseBody List<TaskStatus> getAllTaskStatusBymdAccTypeId(@RequestParam List<Integer> mdAccTypeId) {
		List<TaskStatus> BymdAccTypeIdResp = new ArrayList<TaskStatus>();
		// ////System.err.println("m_acc_type_id="+mAccTypeId);
		try {
			BymdAccTypeIdResp = taskStatusRepo.getAllTaskStatusBymdAccTypeId(mdAccTypeId);
			//// System.err.println("Response For /getAllTaskStatusByMaccTypeId Is" + "\n" +
			//// BymdAccTypeIdResp);
		} catch (Exception e) {
			// TODO: handle exception
			//// System.err.println("Exception Occur!!! In Catch Block Of
			// /getAllTaskStatusBymdAccTypeId Mapping");
			BymdAccTypeIdResp = new ArrayList<TaskStatus>();
			e.printStackTrace();
		}

		return BymdAccTypeIdResp;
	}

	// Fetch All Records From Channeel Where del_status And is_active Is True
	@RequestMapping(value = "/getAllChannelList", method = RequestMethod.GET)
	public @ResponseBody List<Channel> getAllChannelList() {
		List<Channel> allChannelList = new ArrayList<Channel>();

		try {
			allChannelList = channelRepo.getAllChannelList();
			//// System.err.println("Response Of /getAllChannelList is" + "\n" +
			//// allChannelList);
		} catch (Exception e) {
			// TODO: handle exception
			allChannelList = new ArrayList<Channel>();
			//// System.err.println("Exception Occured!!! In Catch Block Of
			//// /getAllChannelList Mapping");
			e.printStackTrace();
		}

		return allChannelList;

	}

	@RequestMapping(value = "/getChannelBychanelname", method = RequestMethod.POST)
	public @ResponseBody Channel getChannelBychanelname(@Param("channelName") String channelName) {
		Channel channel = new Channel();

		try {
			channel = channelRepo.findByChannelName(channelName);

			if (channel == null) {
				channel = new Channel();
			}

		} catch (Exception e) {
			channel = new Channel();
			e.printStackTrace();
		}

		return channel;

	}

	@RequestMapping(value = "/saveChannel", method = RequestMethod.POST)
	public @ResponseBody Channel saveChannel(@RequestBody Channel channel) {
		Channel res = new Channel();

		try {
			res = channelRepo.save(channel);

		} catch (Exception e) {
			channel = new Channel();
			e.printStackTrace();
		}

		return res;

	}

	// To Fetch All Records From m_employee Where del_status And is_active Is True
	@RequestMapping(value = "/getAllEmployeeList", method = RequestMethod.POST)
	public @ResponseBody List<Employee> getAllEmployeeList() {
		List<Employee> AllEmployeeRsp = new ArrayList<Employee>();

		try {
			AllEmployeeRsp = empRepo.getAllEmployeeList();
			// System.err.println("Response Of /getAllEmployeeList Is" + "\n" +
			// AllEmployeeRsp);
		} catch (Exception e) {
			// TODO: handle exception
			AllEmployeeRsp = new ArrayList<Employee>();
			// System.err.println("Exception Occured!!! In Catch Block Of
			// /getAllEmployeeList Mapping");
			e.printStackTrace();
		}

		return AllEmployeeRsp;
	}

	// To Find Record Where md_acc_type_id Is Matched(Using FIND_IN_SET)
	@RequestMapping(value = "/findEmployeeBymdAccTypeId", method = RequestMethod.POST)
	public @ResponseBody List<Employee> findEmployeeBymdAccTypeId(@RequestParam String mdAccTypeId) {
		List<Employee> EmpListByAccTypeId = new ArrayList<Employee>();

		try {
			EmpListByAccTypeId = empRepo.findEmployeeBymdAccTypeId(mdAccTypeId);
			// System.err.println("Response From /findEmployeeBymdAccTypeId Is" + "\n" +
			// EmpListByAccTypeId);
		} catch (Exception e) {
			// TODO: handle exception
			EmpListByAccTypeId = new ArrayList<Employee>();
			// System.err.println("Exception Occuered!!! In Catch Block Of
			// /findEmployeeBymdAccTypeId Mapping");
			e.printStackTrace();
		}

		return EmpListByAccTypeId;

	}

	// Fetch All Task Details With Employee Name As Extra Field From task_details
	@RequestMapping(value = "/getAllTaskWithEmpNAme", method = RequestMethod.POST)
	public @ResponseBody List<TaskDetailsEmpName> getAllTaskWithEmpNAme() {
		List<TaskDetailsEmpName> TaskDetailListResp = new ArrayList<TaskDetailsEmpName>();

		try {
			TaskDetailListResp = taskDetailEmpRepo.getAllTaskWithEmpNAme();
			// System.err.println("Response Of /getAllTaskWithEmpNAme Is" + "\n" +
			// TaskDetailListResp);
		} catch (Exception e) {
			// TODO: handle exception

			TaskDetailListResp = new ArrayList<TaskDetailsEmpName>();
			// System.err.println("Exception Occuered!!! In Catch Block Of
			// /getAllTaskWithEmpNAme Mapping");
			e.printStackTrace();

		}

		return TaskDetailListResp;
	}

	// To Fetch Record Using empId From task_details With Employee Name
	@RequestMapping(value = "/getTaskDetailWithEmpNameByEmpid", method = RequestMethod.POST)
	public @ResponseBody List<TaskDetailsEmpName> getTaskDetailWithEmpNameByEmpid(@RequestParam int empId) {
		List<TaskDetailsEmpName> taskDetailsResp = new ArrayList<TaskDetailsEmpName>();

		try {
			taskDetailsResp = taskDetailEmpRepo.getTaskDetailWithEmpNameByEmpid(empId);
			// System.err.println("Response From /getSingleTaskDetailWithEmpName Is" + "\t"
			// + taskDetailsResp);
		} catch (Exception e) {
			taskDetailsResp = new ArrayList<TaskDetailsEmpName>();
			// System.err.println("Exception Occured!!! In Catch Block Of
			// /getSingleTaskDetailWithEmpName Mapping");
			e.printStackTrace();
			// TODO: handle exception
		}
		return taskDetailsResp;

	}

	// To Fetch Record Using TaskId From TaskDetails With Employee Name
	@RequestMapping(value = "/getTaskdetailsEmpnameByTaskId", method = RequestMethod.POST)
	public @ResponseBody TaskDetailsEmpName getTaskdetailsEmpnameByTaskId(@RequestParam int taskId) {
		TaskDetailsEmpName taskDetails = new TaskDetailsEmpName();
		try {
			taskDetails = taskDetailEmpRepo.getTaskdetailsEmpnameByTaskId(taskId);
			// System.err.println("Response From /getTaskdetailsEmpnameByTaskId Is" + "\n" +
			// taskDetails);
		} catch (Exception e) {
			// TODO: handle exception
			taskDetails = new TaskDetailsEmpName();
			// System.err.println("Exception Occured!!! In Catch Block Of
			// /getTaskdetailsEmpnameByTaskId Mapping ");
			e.printStackTrace();
		}
		return taskDetails;
	}

	// To Add New Record In task_details
	@RequestMapping(value = "/addNewTask", method = RequestMethod.POST)
	public @ResponseBody TaskDetails addNewTask(@RequestBody TaskDetails taskDetails) {
		TaskDetails taskDetailsResp = new TaskDetails();

		try {
			taskDetailsResp = taskDetailsRepo.save(taskDetails);
			// System.err.println("Saved Task Is =" + "\t" + taskDetailsResp);
		} catch (Exception e) {
			// TODO: handle exception
			taskDetailsResp = new TaskDetails();
			// System.err.println("Exception Occured!!! In Catch Block Of /addNewTask
			// Mapping");
			e.printStackTrace();
		}

		return taskDetailsResp;

	}

	@RequestMapping(value = "/getTaskById", method = RequestMethod.POST)
	public @ResponseBody TaskDetails getTaskById(@RequestParam("taskId") int taskId) {
		TaskDetails taskDetailsResp = new TaskDetails();

		try {
			taskDetailsResp = taskDetailsRepo.finByTaskId(taskId);
			// System.err.println("Saved Task Is =" + "\t" + taskDetailsResp);
		} catch (Exception e) {
			// TODO: handle exception
			taskDetailsResp = new TaskDetails();
			// System.err.println("Exception Occured!!! In Catch Block Of /addNewTask
			// Mapping");
			e.printStackTrace();
		}

		return taskDetailsResp;

	}

	// To Delete Task From task_details Using task_id
	@RequestMapping(value = "/deleteTaskDetailsByTaskId", method = RequestMethod.POST)
	public @ResponseBody Info deleteTaskDetailsByTaskId(@RequestParam int taskId) {
		Info info = new Info();
		int flag = 0;

		try {
			flag = taskDetailsRepo.deleteTaskDetailsByTaskId(taskId);
			if (flag == 0) {
				info.setError(true);
				info.setMsg("Unable To Delete Task");
			} else {
				info.setError(false);
				info.setMsg("Task Deleted!!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			info.setError(true);
			info.setMsg("Some Exception Occured Unable To Delete Task");
			// System.err.println("Exception Occured!!! In /deleteTaskDetailsByTaskId
			// Mapping");
			e.printStackTrace();
		}

		return info;

	}

	// Fetch LMS HEADER And DETAIL By lmsId
	@RequestMapping(value = "/getLmsHeader", method = RequestMethod.POST)
	public @ResponseBody LmsHeaderWithNames getLmsHeader(@RequestParam int lmsId) {
		LmsHeaderWithNames lmsHeaderResp = new LmsHeaderWithNames();
		List<LmsDetail> lmsDetailList = new ArrayList<LmsDetail>();
		try {
			lmsHeaderResp = lmsHeaderWnamesRepo.getLmsHeaderByLmsId(lmsId);
			lmsDetailList = lmsDetailRepo.getLmsDetailByLmsId(lmsId);
			lmsHeaderResp.setLmsDetailList(lmsDetailList);
			// System.err.println("Lms Header IS =" + "\t" + lmsHeaderResp);

		} catch (Exception e) {
			// TODO: handle exception
			lmsHeaderResp = new LmsHeaderWithNames();
			// System.err.println("Exception Occured!!! In Catch Bolock /getLmsHeader
			// mapping");
			e.printStackTrace();
		}

		return lmsHeaderResp;

	}

	// To Add New LMS Header With Lms Detail List
	@RequestMapping(value = "/addNewLmsHeader", method = RequestMethod.POST)
	public @ResponseBody LmsHeader addNewLmsHeader(@RequestBody LmsHeader lmsHeader) {
		LmsHeader lmsHeadResp = new LmsHeader();
		List<LmsDetail> lmsDetailresp = new ArrayList<LmsDetail>();
		try {
			// System.out.println(lmsHeader);
			lmsHeadResp = lmsHeadRepo.save(lmsHeader);
			lmsDetailresp = lmsHeader.getLmsDetailList();
			for (LmsDetail detail : lmsDetailresp) {
				detail.setLmsId(lmsHeader.getLmsId());

			}
			lmsDetailresp = lmsDetailRepo.saveAll(lmsHeader.getLmsDetailList());
			// System.err.println("Added LMS Header Is=" + "\t" + lmsHeadResp);

		} catch (Exception e) {
			// TODO: handle exception
			lmsHeadResp = new LmsHeader();
			lmsDetailresp = new ArrayList<LmsDetail>();
			// System.err.println("Exception Occuered!!! In Catch Block /addNewLmsHeader
			// Mapping");
			e.printStackTrace();
		}
		return lmsHeadResp;
	}

	@RequestMapping(value = "/updateAccCodeInLms", method = RequestMethod.POST)
	public @ResponseBody Info updateAccCodeInLms(@RequestParam("type") int type, @RequestParam("lmsId") String lmsId) {

		Info info = new Info();

		try {

			int maxcount = lmsHeadRepo.getmaxcount(type);
			maxcount = maxcount + 1;
			int update = lmsHeadRepo.updateAccCodeInLms(maxcount, lmsId);
			info.setError(false);
			info.setMsg("generated");
		} catch (Exception e) {
			info.setError(true);
			info.setMsg("failed");
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = "/checkCompanyName", method = RequestMethod.POST)
	public @ResponseBody Info checkCompanyName(@RequestParam("compName") String compName) {
		Info info = new Info();

		try {

			LmsHeader lmsHeadResp = lmsHeadRepo.checkCompanyName(compName.trim());

			if (lmsHeadResp == null) {
				info.setError(false);
				info.setMsg("1");
			} else {
				info.setError(true);
				info.setMsg("0");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return info;
	}

	// To Delete Lms Header Using Lms ID
	@Transactional
	@RequestMapping(value = "/deleteLmsHeader", method = RequestMethod.POST)
	public @ResponseBody Info deleteLmsHeader(@RequestParam int lmsId) {
		Info info = new Info();
		int flag = 0;
		info.setError(false);
		info.setMsg("Exception Occured Unable To Delete Lms Header");

		flag = lmsHeadRepo.deleteLmsHeader(lmsId);

		int delete = taskDetailsRepo.deleteTask(1, lmsId);

		if (flag == 0) {
			info.setError(true);
			info.setMsg("Unable To Delete Header");
		} else {
			info.setError(false);
			info.setMsg("Lms Header Deleted Successfully");
		}

		return info;
	}

	// To Fetch List Of All LMS Header
	@RequestMapping(value = "/getListOfAllLmsHeader", method = RequestMethod.GET)
	public @ResponseBody List<LmsHeaderWithNames> getListOfAllLmsHeader() {
		List<LmsHeaderWithNames> AllLmsHeaderList = new ArrayList<LmsHeaderWithNames>();
		// List<LmsDetail> lmsDEtailList=new ArrayList<LmsDetail>();

		try {
			AllLmsHeaderList = lmsHeaderWnamesRepo.getListOfAllLmsHeader();
			/*
			 * for(LmsHeaderWithNames header : AllLmsHeaderList ) {
			 * 
			 * lmsDEtailList=lmsDetailRepo.getLmsDetailByLmsId(header.getLmsId());
			 * header.setLmsDetailList(lmsDEtailList); }
			 */
			// //System.err.println("Response Of /getListOfAllLmsHeader Is" + "\t" +
			// AllLmsHeaderList);
		} catch (Exception e) {
			// TODO: handle exception
			AllLmsHeaderList = new ArrayList<LmsHeaderWithNames>();
			// //System.err.println("Exception Occuered!!! In Catch Block
			// /getListOfAllLmsHeader Mapping");
			e.printStackTrace();
		}

		return AllLmsHeaderList;

	}

	/*
	 * //To Get ALl Inquiry Header Without Names
	 * 
	 * @RequestMapping(value="/getAllInquiryHeader",method=RequestMethod.POST)
	 * public @ResponseBody List<InquiryHeader> getAllInquiryHeader(){
	 * List<InquiryHeader> AllInquiryHeaderList=new ArrayList<InquiryHeader>();
	 * List<InquiryDetail> AllInquiryDetailList=new ArrayList<InquiryDetail>();
	 * 
	 * 
	 * try {
	 * 
	 * AllInquiryHeaderList=inquiryHeaderRepo.getAllInquiryHeaderList();
	 * for(InquiryHeader header : AllInquiryHeaderList) {
	 * AllInquiryDetailList=inquiryDetailRepo.getInqDeatilById(header.getInqId());
	 * header.setInqDetailList(AllInquiryDetailList); }
	 * //System.err.println("response Of /getAllInquiryHeader"+"\n"+
	 * AllInquiryHeaderList); } catch (Exception e) { // TODO: handle exception
	 * AllInquiryHeaderList=new ArrayList<InquiryHeader>(); //System.err.
	 * println("Exception Occured!!! In Catch Block Of /getAllInquiryHeader Mapping"
	 * ); e.printStackTrace();
	 * 
	 * }
	 * 
	 * return AllInquiryHeaderList;
	 * 
	 * }
	 */

	// For Add New Inquiry Header
	@RequestMapping(value = "/addNewInquiryHeader", method = RequestMethod.POST)
	public @ResponseBody InquiryHeader addNewInquiryHeader(@RequestBody InquiryHeader inquiryHead) {
		InquiryHeader inqHeaderResp = new InquiryHeader();
		List<InquiryDetail> inqDetailList = new ArrayList<InquiryDetail>();
		try {

			inqHeaderResp = inquiryHeaderRepo.save(inquiryHead);
			for (InquiryDetail detail : inquiryHead.getInqDetailList()) {
				detail.setInqId(inquiryHead.getInqId());
			}
			inqDetailList = inquiryDetailRepo.saveAll(inquiryHead.getInqDetailList());
			// System.err.println("Saved Headr Is =" + "\t" + inqHeaderResp);

		} catch (Exception e) {
			// TODO: handle exception
			inqHeaderResp = new InquiryHeader();
			// System.err.println("Exception Occur!!! In Catch Block Of /addNewInquiryHeader
			// Mapping");
			e.printStackTrace();
		}

		return inqHeaderResp;

	}

	// To Delete Inquiry Header
	@RequestMapping(value = "/deleteInquiryHeaderByInqId", method = RequestMethod.POST)
	public @ResponseBody Info deleteInquiryHeaderByInqId(@RequestParam int inqId) {

		Info info = new Info();
		int flag = 0;
		try {
			flag = inquiryHeaderRepo.deleteInquiryHeaderByInqId(inqId);
			int delete = taskDetailsRepo.deleteTask(2, inqId);
			if (flag == 0) {
				info.setError(true);
				info.setMsg("Unable To Delete Inquiry Header!!!");
			} else {
				info.setError(false);
				info.setMsg("Inquiry Header Deleted SuccessFully!!!");
			}

		} catch (Exception e) {
			// TODO: handle exception
			info.setError(true);
			info.setMsg("Exception Occuered Unable To Delete Inquiry Header");
			// System.err.println("Exception occuered!!! In Catch Block Of
			// /deleteInquiryHeaderByInqId Mapping");
			e.printStackTrace();
		}

		return info;

	}

	// To Fetch All Records From Inquiry Header With Channel Name And Tag Names
	@RequestMapping(value = "/getAllInquiryHeaderWithName", method = RequestMethod.GET)
	public @ResponseBody List<InquiryHeaderWithNames> getAllInquiryHeaderWithName() {
		List<InquiryHeaderWithNames> inqHeadResp = new ArrayList<InquiryHeaderWithNames>();
		List<InquiryDetail> inqDetailResp = new ArrayList<InquiryDetail>();
		try {

			inqHeadResp = inquiryHeadWithNames.getAllInquiryHeaderWithName();
			/*
			 * for (InquiryHeaderWithNames header : inqHeadResp) { inqDetailResp =
			 * inquiryDetailRepo.getInqDeatilById(header.getInqId());
			 * header.setInqDetailList(inqDetailResp);
			 * 
			 * }
			 */

			// System.err.println("Response From /getAllInquiryHeaderWithName =" + "\t" +
			// inqHeadResp);

		} catch (Exception e) {
			// TODO: handle exception
			inqHeadResp = new ArrayList<InquiryHeaderWithNames>();
			// System.err.println("Exception Occuered!!! In Catcg Of
			// /getAllInquiryHeaderWithName Mapping");
			e.printStackTrace();
		}

		return inqHeadResp;

	}

	// To Fetch Single Inquiry Header With Channel Name And Tag Names Using inq_id
	@RequestMapping(value = "/getInqHeaderWithNameById", method = RequestMethod.POST)
	public @ResponseBody InquiryHeaderWithNames getInqHeaderWithNameById(@RequestParam int inqId) {
		InquiryHeaderWithNames inqHeadResp = new InquiryHeaderWithNames();
		List<InquiryDetail> inqDetailList = new ArrayList<InquiryDetail>();

		try {

			inqDetailList = inquiryDetailRepo.getInqDeatilById(inqId);
			// //System.err.println("inqDetailLis" + inqDetailList);
			inqHeadResp = inquiryHeadWithNames.getInqHeaderWithNameById(inqId);
			if (inqHeadResp == null) {
				inqHeadResp = new InquiryHeaderWithNames();
			}
			// //System.err.println("Before Add inqDEtailLsit"+inqHeadResp);
			inqHeadResp.setInqDetailList(inqDetailList);
			// System.err.println("Response From /getInqHeaderWithNameById =" + "\t" +
			// inqHeadResp);
		} catch (Exception e) {
			// TODO: handle exception
			inqHeadResp = new InquiryHeaderWithNames();
			// System.err.println("Exception Occured!!! In /getInqHeaderWithNameById
			// Mapping");
			e.printStackTrace();
		}

		return inqHeadResp;

	}

	@RequestMapping(value = "/getTaskPreviousLog", method = RequestMethod.POST)
	public @ResponseBody List<TaskDetailsEmpName> getTaskPreviousLog(@RequestParam("type") int type,
			@RequestParam("primaryKey") int primaryKey) {
		List<TaskDetailsEmpName> taskDetailsResp = new ArrayList<TaskDetailsEmpName>();

		try {
			taskDetailsResp = taskDetailEmpRepo.getTaskPreviousLog(type, primaryKey);

		} catch (Exception e) {

			e.printStackTrace();
			// TODO: handle exception
		}
		return taskDetailsResp;

	}

	@RequestMapping(value = "/getCustInfo", method = RequestMethod.POST)
	public @ResponseBody CustInfo getCustInfo(@RequestParam("type") int type,
			@RequestParam("primaryKey") int primaryKey) {
		CustInfo custInfo = new CustInfo();

		try {

			if (type == 1) {
				custInfo = custInfoRepo.getCustInfoLms(primaryKey);
			} else if (type == 2) {
				custInfo = custInfoRepo.getCustInfoInq(primaryKey);
			}

		} catch (Exception e) {

			e.printStackTrace();
			// TODO: handle exception
		}
		return custInfo;

	}

	@RequestMapping(value = "/getRegularDashboardSummry", method = RequestMethod.POST)
	public @ResponseBody DashBoardSummary getRegularDashboardSummry(@RequestParam("empId") int empId) {
		DashBoardSummary dashBoardSummary = new DashBoardSummary();

		try {

			Date dt = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			String StartEndOfMnth =	DateConvertor.getMonthsStartEnd();
			String dates[]=StartEndOfMnth.split("to");
			String mStartDate=DateConvertor.convertToYMD(dates[0]);
			String mEndDate=DateConvertor.convertToYMD(dates[1]);
			System.err.println("Month Dates"+mStartDate+mEndDate);

			dashBoardSummary = dashBoardSummaryRepo.getRegularDashboardSummry(empId, sf.format(dt),mStartDate,mEndDate);

		} catch (Exception e) {

			e.printStackTrace();
			// TODO: handle exception
		}
		return dashBoardSummary;

	}

	@Autowired
	DesignationRepository designationRepo;

	@RequestMapping(value = "/getDesignationBydesName", method = RequestMethod.POST)
	public @ResponseBody Designation getDesignationBydesName(@RequestParam String desigName) {
		Designation allDesignationList = new Designation();

		try {
			allDesignationList = designationRepo.getDesignationBydesName(desigName);

			if (allDesignationList == null) {
				allDesignationList = new Designation();
			}

		} catch (Exception e) {
			allDesignationList = new Designation();
			e.printStackTrace();
			// TODO: handle exception
		}

		return allDesignationList;
	}

	@RequestMapping(value = "/savedesignation", method = RequestMethod.POST)
	public @ResponseBody Designation savedesignation(@RequestBody Designation designation) {
		Designation allDesignationList = new Designation();

		try {
			allDesignationList = designationRepo.save(designation);

		} catch (Exception e) {
			allDesignationList = new Designation();
			e.printStackTrace();
			// TODO: handle exception
		}

		return allDesignationList;
	}

	@RequestMapping(value = "/getDesignationByIdAndDelstatus", method = RequestMethod.POST)
	public @ResponseBody Designation getDesignationByIdAndDelstatus(@RequestParam int desgId) {
		Designation desg = new Designation();
		// System.err.println("In /getDesignationByIdAndDelstatus");
		try {
			desg = designationRepo.getDesignationByIdAndDelstatus(desgId);
			if (desg == null) {
				desg = new Designation();
			}
		} catch (Exception e) {
			// TODO: handle exception
			desg = new Designation();
			// System.err.println("Exception Occuered In /getDesignationByIdAndDelstatus");
			e.printStackTrace();
		}

		return desg;
	}

	@RequestMapping(value = "/editDesignation", method = RequestMethod.POST)
	public @ResponseBody Info editDesignation(@RequestParam int desgId, @RequestParam String desgName) {
		Info info = new Info();
		int flag = 0;
		try {
			flag = designationRepo.editDesignation(desgId, desgName);
			if (flag != 0) {
				info.setError(true);
				info.setMsg("Designation Updated");
			} else {
				info.setError(false);
				info.setMsg("Unable To Update Designation");
			}

		} catch (Exception e) {
			// System.err.println("Ecxeption Occuered In /editDesignation ");
			info.setError(false);
			info.setMsg("Exception Occured");
			// TODO: handle exception
			e.printStackTrace();

		}

		return info;

	}

	@RequestMapping(value = "/deleteDesignation", method = RequestMethod.POST)
	public @ResponseBody Info deleteDesignation(@RequestParam int desgId, @RequestParam String makerDtTime,
			@RequestParam int makerId) {
		Info info = new Info();
		int flag = 0;
		try {
			flag = designationRepo.deleteDesignation(desgId, makerId, makerDtTime);
			if (flag != 0) {
				info.setError(false);
				info.setMsg("Designation Deleted");
			} else {
				info.setError(false);
				info.setMsg("Unable To Delete Designation");
			}

		} catch (Exception e) {
			// TODO: handle exception
			info.setError(false);
			info.setMsg("Unable To Delete Designation Exception Occuered");
			e.printStackTrace();
		}

		return info;
	}

}
