package com.ats.hrmgt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.ats.hrmgt.model.ChannelReports;
import com.ats.hrmgt.model.ChannelWiseDetailReport;
import com.ats.hrmgt.model.CityReports;
import com.ats.hrmgt.model.CityWiseDetailReport;
import com.ats.hrmgt.model.DomainTypeReports;
import com.ats.hrmgt.model.DomainWiseDetailReport;
import com.ats.hrmgt.model.EmployeeReport;
import com.ats.hrmgt.model.LeadConversionTimeReport;
import com.ats.hrmgt.repository.ChannelReportsRepository;
import com.ats.hrmgt.repository.ChannelWiseDetailReportRepository;
import com.ats.hrmgt.repository.CityReportsRepository;
import com.ats.hrmgt.repository.CityWiseDetailReportRepository;
import com.ats.hrmgt.repository.DomainTypeReportsRepository;
import com.ats.hrmgt.repository.DomainWiseDetailReportRepository;
import com.ats.hrmgt.repository.EmpLeadInqCountReportRepository;
import com.ats.hrmgt.repository.LeadConversionTimeReportRepository;

@RestController
public class ReportsControllerApi {
	
	
	@Autowired
	ChannelReportsRepository channelReportRepo;
	
	@Autowired
	DomainTypeReportsRepository domainReportsRepo;
	
	
	@Autowired
	CityReportsRepository cityReportsRepo;
	
	@Autowired
	ChannelWiseDetailReportRepository channelDetailReportRepo;
	
	
	@Autowired
	DomainWiseDetailReportRepository DomaiWiseDetlReportRepo;
	
	@Autowired
	CityWiseDetailReportRepository CityWiseDtlRlRepo;
	
	
	@Autowired
	LeadConversionTimeReportRepository leadConTymRepo;
	
	
	
	@Autowired
	EmpLeadInqCountReportRepository empLMSINACntRepo;
	
	
	
	@RequestMapping(value="/getChannelWiseCount",method=RequestMethod.POST)
	public @ResponseBody  List<ChannelReports> getChannelWiseCount(@RequestParam String fromDate,@RequestParam String toDate){
		List<ChannelReports> channelReportsList=new ArrayList<ChannelReports>();
		try {
			
			
			channelReportsList=channelReportRepo.getChannelLMSandINQCount(fromDate, toDate);
			System.err.println("channelCountResp List Size=="+channelReportsList.size());
		} catch (Exception e) {
			// TODO: handle exception
			channelReportsList=new ArrayList<ChannelReports>();
			System.err.println("Exception Occuered In /getChannelWiseCount");
			e.printStackTrace();
			
		}
		
		
		return channelReportsList;
	}
	
	

	
	
	
	@RequestMapping(value="/getCityWiseCount",method=RequestMethod.POST)
	public @ResponseBody List<CityReports> getCityWiseCount(@RequestParam String fromDate,@RequestParam String toDate){
		
		List<CityReports> CityRepList=new ArrayList<CityReports>();
		try {
			
			
			CityRepList=cityReportsRepo.getCityWiseLMSAndINQCount(fromDate, toDate);
			System.err.println("City Wise Report  List Size=="+CityRepList.size());
		} catch (Exception e) {
			// TODO: handle exception
			CityRepList=new ArrayList<CityReports>();
			System.err.println("Exception Occuered In /getCityWiseCount");
			e.printStackTrace();
			
		}
		
		return CityRepList;
	}
	
	@RequestMapping(value="/getDomainWiseCount",method=RequestMethod.POST)
	public @ResponseBody  List<DomainTypeReports>  getDomainWiseCount(@RequestParam String fromDate,@RequestParam String toDate){
		List<DomainTypeReports> dominReportList=new ArrayList<DomainTypeReports>();
		
		
		try {
			dominReportList=domainReportsRepo.getDomainWiseLMSandInqCount(fromDate, toDate);
			System.err.println("Domain  Wise  Report  List Size=="+dominReportList.size());
		} catch (Exception e) {
			// TODO: handle exception
			dominReportList=new ArrayList<DomainTypeReports>();
			System.err.println("Exception Occuered In /getDomainWiseCount");
			e.printStackTrace();
		}
		
		
		
		return dominReportList;
		
	}
	
	
	
	
	@RequestMapping(value="/getAllChannelWiseDetailLeadReport",method=RequestMethod.POST)
	public @ResponseBody List<ChannelWiseDetailReport> getAllChannelWiseDetailLeadReport(@RequestParam String fromDate,@RequestParam String toDate){
		List<ChannelWiseDetailReport> channelDetailReportList=new ArrayList<ChannelWiseDetailReport>();
		
		
		
		try {
			channelDetailReportList=channelDetailReportRepo.getChannelWiseDetailLeadReport(fromDate, toDate);
			System.err.println("Size Of channelDetailLeadReportList== "+channelDetailReportList.size());
			
		} catch (Exception e) {
			// TODO: handle exception
			channelDetailReportList=new ArrayList<ChannelWiseDetailReport>();
			System.err.println("Exception Occuered In /getAllChannelWiseDetailLeadReport");
			e.printStackTrace();
		}
		
		
		return channelDetailReportList;
		
		
	}
	
	
	
	@RequestMapping(value="/getAllDomainlWiseDetailLeadReport",method=RequestMethod.POST)
	public @ResponseBody List<DomainWiseDetailReport> getAllDomainlWiseDetailLeadReport(@RequestParam String fromDate,@RequestParam String toDate){
		List<DomainWiseDetailReport> DomainDtlReportList=new ArrayList<DomainWiseDetailReport>();
	
		
		try {
			DomainDtlReportList=DomaiWiseDetlReportRepo.getDomainlWiseDetailLeadReport(fromDate, toDate);
			
			System.err.println("Size Of DomainDtlLeadReportList=="+DomainDtlReportList.size());
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.err.println("Exception Occuered In /getAllDomainlWiseDetailLeadReport");
			e.printStackTrace();
		}
		
		return DomainDtlReportList;
		
		
	}
	
	
	@RequestMapping(value="/getAllCityWiseDetailLeadReport",method=RequestMethod.POST)
	public @ResponseBody List<CityWiseDetailReport> getAllCityWiseDetailLeadReport(@RequestParam String fromDate,
																			@RequestParam String toDate){
		
		List<CityWiseDetailReport> cityWiseDtlReportList=new ArrayList<CityWiseDetailReport>();
		
		try {
		cityWiseDtlReportList=	CityWiseDtlRlRepo.getAllCityWiseDetailLeadReport(fromDate, toDate);
		System.err.println("Size Of cityWiseDtlLeadReportList=="+cityWiseDtlReportList.size());
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occuered In /getAllCityWiseDetailLeadReport");
			e.printStackTrace();
		}
		
		
		return cityWiseDtlReportList;
		
	}
	
	
	@RequestMapping(value="/getAllCityWiseDetailInqReport",method=RequestMethod.POST)
	public @ResponseBody List<CityWiseDetailReport> getAllCityWiseDetailInqReport(@RequestParam String fromDate,
																			@RequestParam String toDate){
		
		List<CityWiseDetailReport> cityWiseDtlReportList=new ArrayList<CityWiseDetailReport>();
		
		try {
		cityWiseDtlReportList=	CityWiseDtlRlRepo.getAllCityWiseDetailInqReport(fromDate, toDate);
		System.err.println("Size Of cityWiseDtlINQReportList=="+cityWiseDtlReportList.size());
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occuered In /getAllCityWiseDetailInqReport");
			e.printStackTrace();
		}
		
		
		return cityWiseDtlReportList;
		
	}
	
	
	
	@RequestMapping(value="/getAllDomainlWiseDetailINQReport",method=RequestMethod.POST)
	public @ResponseBody List<DomainWiseDetailReport> getAllDomainlWiseDetailINQReport(@RequestParam String fromDate,@RequestParam String toDate){
		List<DomainWiseDetailReport> DomainDtlReportList=new ArrayList<DomainWiseDetailReport>();
	
		
		try {
			DomainDtlReportList=DomaiWiseDetlReportRepo.getDomainlWiseDetailINQReport(fromDate, toDate);
			
			System.err.println("Size Of DomainDtlINQReportList=="+DomainDtlReportList.size());
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.err.println("Exception Occuered In /getAllDomainlWiseDetailINQReport");
			e.printStackTrace();
		}
		
		return DomainDtlReportList;
		
		
	}
	
	@RequestMapping(value="/getAllChannelWiseDetailINQReport",method=RequestMethod.POST)
	public @ResponseBody List<ChannelWiseDetailReport> getAllChannelWiseDetailINQReport(@RequestParam String fromDate,@RequestParam String toDate){
		List<ChannelWiseDetailReport> channelDetailReportList=new ArrayList<ChannelWiseDetailReport>();
		
		
		
		try {
			channelDetailReportList=channelDetailReportRepo.getChannelWiseDetailINQReport(fromDate, toDate);
			System.err.println("Size Of channelDetailINQReportList== "+channelDetailReportList.size());
			
		} catch (Exception e) {
			// TODO: handle exception
			channelDetailReportList=new ArrayList<ChannelWiseDetailReport>();
			System.err.println("Exception Occuered In /getAllChannelWiseDetailINQReport");
			e.printStackTrace();
		}
		
		
		return channelDetailReportList;
		
		
	}
	
	
	@RequestMapping(value="/getLeadConTymReportList",method=RequestMethod.POST)
	public @ResponseBody List<LeadConversionTimeReport> getLeadConTymReportList(@RequestParam String fromDate,@RequestParam String toDate){
		List<LeadConversionTimeReport> leadConTrepList=new ArrayList<LeadConversionTimeReport>();
		
		try {
			leadConTrepList=leadConTymRepo.getLeadConTymReportList(fromDate, toDate);
			System.err.println(" leadConTrepList Size=="+leadConTrepList.size());
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occured In /getLeadConTymReportList");
			e.printStackTrace();
		}
		
		return leadConTrepList;
	}
	
	
	@RequestMapping(value="/getEmpWiseLMSIMScount",method=RequestMethod.POST)
	public @ResponseBody List<EmployeeReport> getEmpWiseLMSIMScount(@RequestParam String fromDate,@RequestParam String toDate){
		List<EmployeeReport> empLmsIMsCntList=new ArrayList<EmployeeReport>();
		
		try {
			
			empLmsIMsCntList=empLMSINACntRepo.getEmpWiseLMSIMScount(fromDate, toDate);
			System.err.println("Size Of empLmsIMsCntList=="+empLmsIMsCntList.size());
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occured In /getEmpWiseLMSIMScount");
			e.printStackTrace();
		}
		
		
		
		
		return empLmsIMsCntList;
		
	}
	
	
	
	
}
