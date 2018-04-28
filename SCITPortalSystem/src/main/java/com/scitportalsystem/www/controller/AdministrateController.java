package com.scitportalsystem.www.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scitportalsystem.www.dao.AdministrateDAO;
import com.scitportalsystem.www.dao.LoginDAO;
import com.scitportalsystem.www.util.PageNavigator;
import com.scitportalsystem.www.vo.MemberBasic;


/**
 * Handles requests for the application home page.
 * @author 김다희
 * @comment : amdin 처리 페이지 
 */
@Controller
@RequestMapping(value="admin")
public class AdministrateController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdministrateController.class);
	
	@Inject
	LoginDAO mDao;
	
	@Inject
	AdministrateDAO adDAO;
	
	final int countPerPage = 5;
	final int pagePerGroup = 5;
	
	
	
	@RequestMapping(value="management",method=RequestMethod.GET)
	public String management(Model model,
			@RequestParam(value="searchText", defaultValue="") String searchText, 
			@RequestParam(value="searchList", defaultValue="id") String searchList, 
			@RequestParam(value="page", defaultValue="1") int page){
		logger.info("회원가입 목록 출력 DAO");
		
		HashMap<String, Object> hsm = new HashMap<String, Object>();
		hsm.put("searchList", searchList);
		hsm.put("searchText", searchText);
		
		// 전체 가입 회원 수(검색어 포함)
		int total = adDAO.getTotal(hsm);
		
		// 페이지 계산을 위한 객체 생성
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total);
		// 파라미터 : (countPerPage, pagePerGroup, currentPage, totalRecordsCount) 
		
		ArrayList<MemberBasic> list = new ArrayList<>();
		list = adDAO.selectmemberlist(hsm, navi.getStartRecord(), navi.getCountPerPage());
		
		model.addAttribute("memberList", list);		
		model.addAttribute("searchText", searchText);
		model.addAttribute("searchList", searchList);
		model.addAttribute("navi", navi);
		
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
