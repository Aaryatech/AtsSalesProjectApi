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

import com.ats.hrmgt.model.Info;
import com.ats.hrmgt.model.Tags;
import com.ats.hrmgt.repository.TagsRepository;
@RestController
public class TagsApiController {
	
	
	
	@Autowired
	TagsRepository tagRepo;
	
	@RequestMapping(value="/addNewTag",method=RequestMethod.POST)
	public @ResponseBody Tags addNewTag(@RequestBody Tags tag) {
		
		Tags res = new Tags();
		
		try {
			res=tagRepo.save(tag);
		
		} catch (Exception e) {
			res = new Tags();
			e.printStackTrace();
			
		}
		return res;
	}
	
	@RequestMapping(value="/getAllTAgsByDelStatus",method=RequestMethod.POST)
	public @ResponseBody List<Tags> getAllTAgsByDelStatus(){
		List<Tags> tagResponse=new ArrayList<Tags>();
		
		try {
			tagResponse=tagRepo.getAllTAgsByDelStatus();
		} catch (Exception e) {
			tagResponse=new ArrayList<Tags>();
			//System.err.println("Exception Occurs In Catch Of /getAllTAgsByDelStatus Mapping ");
			e.printStackTrace();
			
		}
		
		
		return tagResponse;
	}
	
	@RequestMapping(value="/getAllTagsWithAccountTypeName",method=RequestMethod.POST)
	public @ResponseBody List<Tags> getAllTagsWithAccountTypeName(){
		List<Tags> tagResponse=new ArrayList<Tags>();
		
		try {
			tagResponse=tagRepo.getAllTagsWithAccountTypeName();
			//System.err.println(tagResponse);
		} catch (Exception e) {
			tagResponse=new ArrayList<Tags>();
			//System.err.println("Exception Occurs In Catch Of /getAllTagsWithAccountTypeName Mapping ");
			e.printStackTrace();
			
		}
		
		
		return tagResponse;
	}
	
	@RequestMapping(value="/deleteTagByDelStatus",method=RequestMethod.POST)
	public @ResponseBody Info  deleteTagByDelStatus(@RequestParam int tagId) {
		Info info=new Info();
		int flag=0;
		try {
			flag=tagRepo.deleteTagByDelStatus(tagId);
			if(flag!=0) {
				info.setError(false);
				info.setMsg("Tag Deleted Successfully");
				
			}
			else {
				info.setError(true);
				info.setMsg("Unable To  Delete Tag");
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			
			//System.err.println("Exception Occurs In Catch Block Of /deleteTagByDelStatus  Mapping");
			e.printStackTrace();
			info.setError(true);
			info.setMsg("Unable To  Delete Tag Given Exception Occurrs"+e);
		}
		return info;
	}
	
	
	@RequestMapping(value="/getSingTagByIdAndDelStatus",method=RequestMethod.POST)
	public @ResponseBody Tags getSingTagByIdAndDelStatus(@RequestParam int tagId) {
		Tags tagResp=new Tags();
		
		try {
			tagResp=tagRepo.getTagByIdANddelStatus(tagId);
			
		} catch (Exception e) {
			// TODO: handle exception
			tagResp=new Tags();
			//System.err.println("Somthing Went Wrong In Catch Block Of /getSingTagByIdAndDelStatus Mapping");
			e.printStackTrace();
		}
		
		return tagResp;
	}
	
	
	@RequestMapping(value="/editTag",method=RequestMethod.POST)
	public @ResponseBody Info editTag(@RequestBody Tags tag ) {
		Info info=new Info();
		int flag=0;
		try {
		flag=	tagRepo.editTag(tag.getmTagId(), tag.getmAccTypeId(), tag.getmTagName());
		if(flag==0) {
			info.setError(true);
			info.setMsg("Cant Find Tag WIth TagID");
			
		}else {
			info.setError(false);
			info.setMsg("Tag Succesfully Updated");
		}
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.err.println("Somthing Went Wrong In Catch Of /editTag Mapping");
			info.setError(true);
			info.setMsg("Eception Occours"+e);
			e.printStackTrace();
			
		}
		return info;
	}
	
	
	

}
