package com.ats.hrmgt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.model.LmsDetail;
import com.ats.hrmgt.model.LmsHeaderWithNamesAndCustDetail;
import com.ats.hrmgt.repository.LmsDetailRepository;
import com.ats.hrmgt.repository.LmsHeaderWithCustDetailRepo;

@RestController
public class CustomerControllerApi {

	@Autowired
	LmsHeaderWithCustDetailRepo lmsheaderCustRepo;
	
	@Autowired
	LmsDetailRepository lmsDetailRepo;
	//For Customer
	@RequestMapping(value="/getCustList",method=RequestMethod.GET)
	public @ResponseBody List<LmsHeaderWithNamesAndCustDetail> getCustList(){
		List<LmsHeaderWithNamesAndCustDetail> custList=new ArrayList<LmsHeaderWithNamesAndCustDetail>();
		List<LmsDetail> lmsDetailList =new ArrayList<LmsDetail>();
		try {
			custList=lmsheaderCustRepo.getCustList();
			for(LmsHeaderWithNamesAndCustDetail item : custList) {
				
				lmsDetailList=lmsDetailRepo.getLmsDetailByLmsId(item.getLmsId());
				item.setLmsDetailList(lmsDetailList);
			}
			//System.err.println("Responece From /getCustList "+custList);
		} catch (Exception e) {
			// TODO: handle exception
			custList=new ArrayList<LmsHeaderWithNamesAndCustDetail>();
			//System.err.println("Exception Occuered!!! In /getCustList Catch Block");
			e.printStackTrace();
		}
		
		return custList;
	}
	
	
	
	//For Collabarator
	@RequestMapping(value="/getCollabratorList",method=RequestMethod.GET)
	public @ResponseBody List<LmsHeaderWithNamesAndCustDetail> getCollabratorList(){
		List<LmsHeaderWithNamesAndCustDetail> CollabratorList=new ArrayList<LmsHeaderWithNamesAndCustDetail>();
		List<LmsDetail> lmsDetailList =new ArrayList<LmsDetail>();
		try {
			CollabratorList=lmsheaderCustRepo.getCollabratorList();
			for(LmsHeaderWithNamesAndCustDetail item : CollabratorList) {
				
				lmsDetailList=lmsDetailRepo.getLmsDetailByLmsId(item.getLmsId());
				item.setLmsDetailList(lmsDetailList);
			}
			//System.err.println("Responece From /getCustList "+CollabratorList);
		} catch (Exception e) {
			// TODO: handle exception
			CollabratorList=new ArrayList<LmsHeaderWithNamesAndCustDetail>();
			//System.err.println("Exception Occuered!!! In /getCustList Catch Block");
			e.printStackTrace();
		}
		
		return CollabratorList;
	}
	
	
	
}
