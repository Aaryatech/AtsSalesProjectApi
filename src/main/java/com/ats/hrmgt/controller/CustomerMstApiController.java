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

import com.ats.hrmgt.model.CustomerMst;
import com.ats.hrmgt.model.Info;
import com.ats.hrmgt.repository.CustomerMstRepo;

@RestController
public class CustomerMstApiController {
	
	
	@Autowired
	CustomerMstRepo custMstRepo;
 	

	@RequestMapping(value="/getAllCustomerList",method=RequestMethod.GET)
	public @ResponseBody List<CustomerMst>  getAllCustomerList(){
		List<CustomerMst> CustMstList=new ArrayList<>();
		
		try {
			CustMstList=custMstRepo.getAllCustomerList();
		} catch (Exception e) {
			CustMstList=new ArrayList<>();
			// TODO: handle exception
			System.err.println("Exception Occuered In /getAllCustomerList");
				e.printStackTrace();
		}
		return CustMstList;
		
		
	}
	
	@RequestMapping(value="/saveCustMst",method=RequestMethod.POST)
	public @ResponseBody CustomerMst saveCustMst(@RequestBody CustomerMst cust) {
		CustomerMst customer=new CustomerMst();
		
		try {
			customer=custMstRepo.save(cust);
		} catch (Exception e) {
			customer=new CustomerMst();
			// TODO: handle exception
			System.err.println("Exception Occuered In /saveCustMst");
			e.printStackTrace();
			
		}
		return customer;
	}
	
	
	
	@RequestMapping(value="/deleteCustMst",method=RequestMethod.POST)
	public @ResponseBody Info deleteCustMst(@RequestParam int custId) {
		Info info=new Info();
		int flag=0;
		
		try {
			flag=custMstRepo.deleteCustMst(custId);
			if(flag==0) {
				info.setError(true);
				info.setMsg("Unable To Delete Customer");
			}else {
				info.setError(false);
				info.setMsg("Customer Deleted Successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			info.setError(true);
			info.setMsg("Unable To Delete Customer Exception Occuered!!!");
			System.err.println("Exception Occuered In /deleteCustMst");
			e.printStackTrace();
		}
		
		
		
		return info;
	}
	
	@RequestMapping(value="/getCustById",method=RequestMethod.POST)
	public @ResponseBody CustomerMst getCustById(@RequestParam int custId) {
		CustomerMst cust=new CustomerMst();
		try {
			cust=custMstRepo.getCustById(custId);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occuered In /getCustById");
			e.printStackTrace();
		}
		
		return cust;
		
	}
	
	
	
	
	
	
	
}
