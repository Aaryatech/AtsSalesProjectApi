package com.ats.hrmgt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.hrmgt.model.AccountTpye;
import com.ats.hrmgt.repository.AccountTypeRepository;

@RestController
public class AccountTypeControllerApi {

	@Autowired
	AccountTypeRepository AccTypeRepo;
	
	
	@RequestMapping(value="/getAllAccouctTypeList",method=RequestMethod.POST)
	public @ResponseBody List<AccountTpye> getAllAccountTypeByDelStatus(){
		List<AccountTpye> accTypeListResp=new ArrayList<AccountTpye>();
		
		try {
			
			accTypeListResp = AccTypeRepo.getAllAccountTypeByDelStatus();
			
			return accTypeListResp;
		} catch (Exception e) {
		 accTypeListResp=new ArrayList<AccountTpye>();
			// TODO: handle exception
		}
		
		return accTypeListResp;
		
	}
	
	
	
}
