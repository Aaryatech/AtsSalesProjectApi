package com.ats.hrmgt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.model.Channel;
import com.ats.hrmgt.model.Employee;
import com.ats.hrmgt.model.Info;
import com.ats.hrmgt.model.InquiryDetail;
import com.ats.hrmgt.model.InquiryHeader;
import com.ats.hrmgt.model.LmsDetail;
import com.ats.hrmgt.model.LmsHeader;
import com.ats.hrmgt.model.LmsHeaderWithNames;
import com.ats.hrmgt.model.Tags;
import com.ats.hrmgt.model.TaskDetails;
import com.ats.hrmgt.model.TaskDetailsEmpName;
import com.ats.hrmgt.model.TaskStatus;
import com.ats.hrmgt.repository.ChannelRepository;
import com.ats.hrmgt.repository.EmployeeRepository;
import com.ats.hrmgt.repository.InquiryDetailRepository;
import com.ats.hrmgt.repository.InquiryHeaderRepository;
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
	
	
	//To Fetch Records With Account Type Names,Tag Names And Channel Names
	@Autowired
	LmsHeaderWithNamesRepository lmsHeaderWnamesRepo;
	
	@Autowired
	LmsDetailRepository lmsDetailRepo;
	
	@Autowired
	InquiryHeaderRepository inquiryHeaderRepo;
	
	@Autowired
	InquiryDetailRepository inquiryDetailRepo;
	
	//To Add Or Delete  LMS Header
	@Autowired
	LmsHeaderRepository lmsHeadRepo;
	
	
	
	
	//To Fetch All Tags By m_acc_type_id Where del_status & is_active Status is True
	@RequestMapping(value="/getTagBymAccTypeId",method=RequestMethod.POST)
	public @ResponseBody List<Tags> getTagBymAccTypeId(@RequestParam int mAccTypeId){
		List<Tags> tagResponse=new ArrayList<Tags>();
		try {
			tagResponse=tagsRepo.getTagBymAccTypeId(mAccTypeId);
		} catch (Exception e) {
			// TODO: handle exception
			tagResponse=new ArrayList<Tags>();
			System.err.println("Some Exception Occurs In Catch Block Of /getTagBymAccTypeId Mapping");
			e.printStackTrace();
		}
		
		
		
		return tagResponse;
	}
	
	//To Fetch All Tags Where del_status And is_active Is True
	@RequestMapping(value="/getAllTagsList",method=RequestMethod.POST)
	public @ResponseBody List<Tags> getAllTagsList(){
		List<Tags> tagResponse=new ArrayList<Tags>();
		try {
			tagResponse=tagsRepo.getAllTagsList();
		} catch (Exception e) {
			// TODO: handle exception
			tagResponse=new ArrayList<Tags>();
			System.err.println("Exception Occurs In Catch Block Of /getAllTagsList Mapping");
			e.printStackTrace();
		}
		
		
		return tagResponse;
		
	}
	
	
	
	
	//To Fetch List Of All TaskStatus Where del_status And is_active Is True
	@RequestMapping(value="/getAllTaskStatusList",method=RequestMethod.POST)
	public @ResponseBody List<TaskStatus>  getAllTaskStatusList(){
		List<TaskStatus> taskStatuslistResp=new ArrayList<TaskStatus>();
		
		try {
			taskStatuslistResp=taskStatusRepo.getAllTaskStatusList();
			System.err.println("Response For  getAllTaskStatusList Is"+"\n"+taskStatuslistResp);
		} catch (Exception e) {
			// TODO: handle exception
			taskStatuslistResp=new ArrayList<TaskStatus>();
			System.err.println("Exception Occurs!!!  In Catch Block Of /getAllTaskStatusList  Mapping");
			e.printStackTrace();
		}
			return taskStatuslistResp;
	}
	
	
	
	//To Fetch Records From Task Status By  m_acc_type_id Where del_status And is_active Status is True
	@RequestMapping(value="/getAllTaskStatusBymdAccTypeId",method=RequestMethod.POST)
	public @ResponseBody List<TaskStatus> getAllTaskStatusBymdAccTypeId(@RequestParam int mdAccTypeId){
		List<TaskStatus> BymdAccTypeIdResp=new ArrayList<TaskStatus>();
		//System.err.println("m_acc_type_id="+mAccTypeId);
		try {
			BymdAccTypeIdResp=taskStatusRepo.getAllTaskStatusBymdAccTypeId(mdAccTypeId);
			System.err.println("Response For  /getAllTaskStatusByMaccTypeId Is"+"\n"+BymdAccTypeIdResp);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occur!!! In Catch Block Of /getAllTaskStatusBymdAccTypeId Mapping");
			BymdAccTypeIdResp=new ArrayList<TaskStatus>();
			e.printStackTrace();
		}
		
		
		
		return BymdAccTypeIdResp;
	}
	
	
	
	//Fetch All Records From Channeel Where del_status And is_active Is True
	@RequestMapping(value="/getAllChannelList",method=RequestMethod.POST )
	public @ResponseBody List<Channel> getAllChannelList(){
		List<Channel> allChannelList=new ArrayList<Channel>();
		
		
		try {
			allChannelList=channelRepo.getAllChannelList();
			System.err.println("Response Of /getAllChannelList is"+"\n"+allChannelList);
		} catch (Exception e) {
			// TODO: handle exception
			allChannelList=new ArrayList<Channel>();
			System.err.println("Exception Occured!!! In Catch Block Of /getAllChannelList Mapping");
			e.printStackTrace();
		}
		
		
		return allChannelList;
		
	}
	
	
	
	
	
	//To Fetch All Records From m_employee Where del_status And is_active Is True
	@RequestMapping(value="/getAllEmployeeList",method=RequestMethod.POST)
	public @ResponseBody List<Employee> getAllEmployeeList(){
		List<Employee> AllEmployeeRsp=new ArrayList<Employee>();
		
		try {
			AllEmployeeRsp=empRepo.getAllEmployeeList();
			System.err.println("Response Of /getAllEmployeeList Is"+"\n"+AllEmployeeRsp);
		} catch (Exception e) {
			// TODO: handle exception
			AllEmployeeRsp=new ArrayList<Employee>();
			System.err.println("Exception Occured!!! In Catch Block Of /getAllEmployeeList Mapping");
			e.printStackTrace();
		}
		
		
		
		
		return AllEmployeeRsp;
	}
	
	
	
	
	//To Find Record Where md_acc_type_id Is Matched(Using FIND_IN_SET)
	@RequestMapping(value="/findEmployeeBymdAccTypeId",method=RequestMethod.POST)
	public @ResponseBody List<Employee>  findEmployeeBymdAccTypeId(@RequestParam String mdAccTypeId){
		List<Employee> EmpListByAccTypeId=new ArrayList<Employee>();
		
		try {
				EmpListByAccTypeId=empRepo.findEmployeeBymdAccTypeId(mdAccTypeId);
				System.err.println("Response From /findEmployeeBymdAccTypeId Is"+"\n"+EmpListByAccTypeId);
		} catch (Exception e) {
			// TODO: handle exception
			EmpListByAccTypeId=new ArrayList<Employee>();
			System.err.println("Exception Occuered!!! In Catch Block Of /findEmployeeBymdAccTypeId Mapping");
			e.printStackTrace();
		}
		
		
		return EmpListByAccTypeId;
		
	}
	
	
	
	
	//Fetch All Task Details With Employee Name As Extra Field From task_details
	@RequestMapping(value="/getAllTaskWithEmpNAme",method=RequestMethod.POST)
	public @ResponseBody List<TaskDetailsEmpName> getAllTaskWithEmpNAme(){
		List<TaskDetailsEmpName> TaskDetailListResp=new ArrayList<TaskDetailsEmpName>();
		
		
		try {
			TaskDetailListResp=taskDetailEmpRepo.getAllTaskWithEmpNAme();
			System.err.println("Response Of /getAllTaskWithEmpNAme Is"+"\n"+TaskDetailListResp);
		} catch (Exception e) {
			// TODO: handle exception
			
			TaskDetailListResp=new ArrayList<TaskDetailsEmpName>();
			System.err.println("Exception Occuered!!! In Catch Block Of /getAllTaskWithEmpNAme Mapping");
			e.printStackTrace();
			
		}
		
		return TaskDetailListResp;
	}
	
	
	
	//To Fetch  Record Using empId From task_details With Employee Name
	@RequestMapping(value="/getTaskDetailWithEmpNameByEmpid",method=RequestMethod.POST)
	public @ResponseBody List<TaskDetailsEmpName> getTaskDetailWithEmpNameByEmpid(@RequestParam int empId ) {
		List<TaskDetailsEmpName> taskDetailsResp=new  ArrayList<TaskDetailsEmpName>();
		
		try {
			taskDetailsResp=taskDetailEmpRepo.getTaskDetailWithEmpNameByEmpid(empId);
			System.err.println("Response From /getSingleTaskDetailWithEmpName Is"+"\t"+taskDetailsResp);
		} catch (Exception e) {
			taskDetailsResp=new ArrayList<TaskDetailsEmpName>();
			System.err.println("Exception Occured!!! In Catch Block Of /getSingleTaskDetailWithEmpName Mapping");
			e.printStackTrace();
			// TODO: handle exception
		}
		return taskDetailsResp;
		
	}
	
	
	
	//To Fetch Record Using TaskId From TaskDetails With Employee Name
	@RequestMapping(value="/getTaskdetailsEmpnameByTaskId",method=RequestMethod.POST)
	public @ResponseBody TaskDetailsEmpName   getTaskdetailsEmpnameByTaskId(@RequestParam int taskId) {
		TaskDetailsEmpName taskDetails=new TaskDetailsEmpName();
		try {
			taskDetails=taskDetailEmpRepo.getTaskdetailsEmpnameByTaskId(taskId);
			System.err.println("Response From /getTaskdetailsEmpnameByTaskId Is"+"\n"+taskDetails);
		} catch (Exception e) {
			// TODO: handle exception
			taskDetails=new TaskDetailsEmpName();
			System.err.println("Exception Occured!!! In Catch Block Of /getTaskdetailsEmpnameByTaskId Mapping ");
			e.printStackTrace();
		}
		return taskDetails;
	}
	
	
	
	//To Add New Record In task_details
	@RequestMapping(value="/addNewTask",method=RequestMethod.POST)
	public @ResponseBody TaskDetails addNewTask(@RequestBody TaskDetails taskDetails) {
	 TaskDetails taskDetailsResp=new TaskDetails();
		
		try {
			taskDetailsResp=taskDetailsRepo.save(taskDetails);
			System.err.println("Saved Task Is ="+"\t"+taskDetailsResp);
		} catch (Exception e) {
			// TODO: handle exception
			taskDetailsResp=new TaskDetails();
			System.err.println("Exception Occured!!! In Catch Block Of /addNewTask Mapping" );
			e.printStackTrace();
		}
		
		return taskDetailsResp;
		
		
	}
	
	
	//To Delete Task From task_details Using task_id
	@RequestMapping(value="/deleteTaskDetailsByTaskId",method=RequestMethod.POST)
	public @ResponseBody Info deleteTaskDetailsByTaskId(@RequestParam int taskId) {
		Info info=new Info();
		int flag=0;
		
		try {
			flag=taskDetailsRepo.deleteTaskDetailsByTaskId(taskId);
			if(flag==0) {
				info.setError(true);
				info.setMsg("Unable To Delete Task");
			}else {
				info.setError(false);
				info.setMsg("Task Deleted!!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			info.setError(true);
			info.setMsg("Some Exception Occured Unable To Delete Task");
			System.err.println("Exception Occured!!! In /deleteTaskDetailsByTaskId Mapping");
			e.printStackTrace();
		}
		
		return info;
		
	}
	
	
	
	
	//Fetch LMS HEADER And DETAIL By lmsId
	@RequestMapping(value="/getLmsHeader",method=RequestMethod.POST)
	public @ResponseBody LmsHeaderWithNames getLmsHeader(@RequestParam int lmsId) {
		LmsHeaderWithNames lmsHeaderResp=new LmsHeaderWithNames();
		List<LmsDetail> lmsDetailList=new ArrayList<LmsDetail>();
		try {
			lmsHeaderResp=lmsHeaderWnamesRepo.getLmsHeaderByLmsId(lmsId);
			lmsDetailList=lmsDetailRepo.getLmsDetailByLmsId(lmsId);
			lmsHeaderResp.setLmsDetailList(lmsDetailList);
			System.err.println("Lms Header  IS ="+"\t"+lmsHeaderResp);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			lmsHeaderResp=new LmsHeaderWithNames();
			System.err.println("Exception Occured!!! In Catch Bolock /getLmsHeader mapping");
			e.printStackTrace();
		}
		
		
		return lmsHeaderResp;
		
	}
	
	
	//To Add New LMS Header With Lms Detail List
	@RequestMapping(value="/addNewLmsHeader",method=RequestMethod.POST)
	public @ResponseBody  LmsHeader addNewLmsHeader(@RequestBody LmsHeader lmsHeader) {
		LmsHeader lmsHeadResp=new LmsHeader();
		List<LmsDetail> lmsDetailresp=new ArrayList<LmsDetail>();
		try {
			
			
			lmsDetailresp=	lmsDetailRepo.saveAll(lmsHeader.getLmsDetailList());
			lmsHeadResp=lmsHeadRepo.save(lmsHeader);
			System.err.println("Added LMS Header Is="+"\t"+lmsHeadResp);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			lmsHeadResp=new LmsHeader();
			lmsDetailresp=new ArrayList<LmsDetail>();
			System.err.println("Exception Occuered!!! In Catch Block /addNewLmsHeader Mapping");
			e.printStackTrace();
		}
		return lmsHeadResp;
	}
	
	
	//To Delete Lms Header Using Lms ID
	@RequestMapping(value="/deleteLmsHeader",method=RequestMethod.POST)
	public @ResponseBody Info	deleteLmsHeader(@RequestParam int lmsId){
		Info info=new Info();
		int flag=0;
		try {
		flag=lmsHeadRepo.deleteLmsHeader(lmsId);
		if(flag==0) {
			info.setError(true);
			info.setMsg("Unable To Delete Header");
		}else {
			info.setError(false);
			info.setMsg("Lms Header Deleted Successfully");
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			info.setError(false);
			info.setMsg("Exception Occured Unable To Delete Lms Header");
		}
	
		return info;
	}
	
	
	//To Fetch List Of All LMS Header
	@RequestMapping(value="/getListOfAllLmsHeader",method=RequestMethod.POST)
	public @ResponseBody List<LmsHeaderWithNames> getListOfAllLmsHeader(){
		List<LmsHeaderWithNames> AllLmsHeaderList=new ArrayList<LmsHeaderWithNames>();
		List<LmsDetail> lmsDEtailList=new ArrayList<LmsDetail>();
		
		try {
			AllLmsHeaderList=lmsHeaderWnamesRepo.getListOfAllLmsHeader();
			for(LmsHeaderWithNames header : AllLmsHeaderList ) {
				
				lmsDEtailList=lmsDetailRepo.getLmsDetailByLmsId(header.getLmsId());
				header.setLmsDetailList(lmsDEtailList);
			}
			System.err.println("Response Of /getListOfAllLmsHeader Is"+"\t"+AllLmsHeaderList);
		} catch (Exception e) {
			// TODO: handle exception
			AllLmsHeaderList=new ArrayList<LmsHeaderWithNames>();
			System.err.println("Exception Occuered!!! In Catch Block /getListOfAllLmsHeader Mapping");
			e.printStackTrace();
		}
		
		return AllLmsHeaderList;
		
	}
	
	
	
	//To Get ALl Inquiry Header
	@RequestMapping(value="/getAllInquiryHeader",method=RequestMethod.POST)
	public @ResponseBody List<InquiryHeader> getAllInquiryHeader(){
		List<InquiryHeader> AllInquiryHeaderList=new ArrayList<InquiryHeader>();
		List<InquiryDetail> AllInquiryDetailList=new ArrayList<InquiryDetail>();
		
		
		try {
			
			AllInquiryHeaderList=inquiryHeaderRepo.getAllInquiryHeaderList();
			for(InquiryHeader header :  AllInquiryHeaderList) {
				AllInquiryDetailList=inquiryDetailRepo.getInqDeatilById(header.getInqId());
				header.setInqDetailList(AllInquiryDetailList);
			}
				System.err.println("response Of /getAllInquiryHeader"+"\n"+AllInquiryHeaderList);
		} catch (Exception e) {
			// TODO: handle exception
			AllInquiryHeaderList=new ArrayList<InquiryHeader>();
			System.err.println("Exception Occured!!! In Catch Block Of /getAllInquiryHeader Mapping");
			e.printStackTrace();
			
		}
		
		return AllInquiryHeaderList;
		
	}
	
	
	//For Add New Inquiry Header
	@RequestMapping(value="/addNewInquiryHeader",method=RequestMethod.POST)
	public @ResponseBody InquiryHeader addNewInquiryHeader(@RequestBody InquiryHeader inquiryHead ) {
		InquiryHeader inqHeaderResp=new InquiryHeader();
		List<InquiryDetail> inqDetailList=new ArrayList<InquiryDetail>();
		try {
			
			inqDetailList=inquiryDetailRepo.saveAll(inquiryHead.getInqDetailList());
			inqHeaderResp=inquiryHeaderRepo.save(inquiryHead);
			System.err.println("Saved Headr Is ="+"\t"+inqHeaderResp);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			inqHeaderResp=new InquiryHeader();
			System.err.println("Exception Occur!!! In Catch Block Of /addNewInquiryHeader Mapping");
			e.printStackTrace();
		}
		
		return inqHeaderResp;
		
	}
	
	
	
	
	
	
}
