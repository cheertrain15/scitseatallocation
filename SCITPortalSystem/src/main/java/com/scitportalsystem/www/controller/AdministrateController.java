package com.scitportalsystem.www.controller;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scitportalsystem.www.dao.AdministrateDAO;
import com.scitportalsystem.www.dao.LoginDAO;
import com.scitportalsystem.www.vo.MemberBasic;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="admin")
public class AdministrateController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdministrateController.class);
	
	@Inject
	LoginDAO mDao;
	
	@Inject
	AdministrateDAO adDAO;
	
	
	@RequestMapping(value="management",method=RequestMethod.GET)
	public String management(Model model){
		logger.info("회원가입 목록 출력 DAO");
		
		ArrayList<MemberBasic> memberList = adDAO.selectmemberlist();
		
		model.addAttribute("memberList", memberList);		
		
		logger.info("회원가입 목록 출력 DAO 종료");
		
		return "/admin/management";
	}
	
	@RequestMapping(value="approvalComplete",method=RequestMethod.GET)
	@ResponseBody
	public void approvalComplete(Model model, String id){		
		
		int approval = adDAO.memberApproval(id);
	
		
		if(approval == 1){
			logger.info("회원승인 성공");			
		} else {
			logger.info("회원승인 실패");
			
		}	
		
	}
	
	
	
	
	
}
