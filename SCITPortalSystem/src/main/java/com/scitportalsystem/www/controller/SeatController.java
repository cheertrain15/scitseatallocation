package com.scitportalsystem.www.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scitportalsystem.www.dao.SeatDAO;
import com.scitportalsystem.www.vo.MemberStaff;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("seat")

public class SeatController {
	
	@Autowired
	SeatDAO seatdao;
	
	private static final Logger logger = LoggerFactory.getLogger(SeatController.class);
	
	/*
	 * 학생 반 배치 페이지 불러오기
	 */
	@RequestMapping(value="seatpage", method=RequestMethod.GET)
	public String seatpage(HttpSession session){
		logger.info("**LODING SEAT.JSP**");
		
		//담당 기수만 출력하게 하기 위해 로그인한 선생님의 정보를 가져오기 
		MemberStaff foundStaff = seatdao.getStaffInfo();
		
		//가져온 선생님의 정보를 모델에 담아서 seat.jsp에 넘겨주기
		session.setAttribute("loginedStaffInfo",foundStaff);
		
		logger.info("**FINISHED LODING SEAT.JSP**");
		return "seat/seat";
	}
	
	/*
	 * 학생 반 배치 페이지의 테이블모드 불러오기
	 */
	@RequestMapping(value="seatPageTable", method=RequestMethod.GET)
	public String seatPageTable(Model model){
		logger.info("**LODING SeatTable.JSP**");
		
		//담당 기수만 출력하게 하기 위해 로그인한 선생님의 정보를 가져오기 
		MemberStaff foundStaff = seatdao.getStaffInfo();
		
		//가져온 선생님의 정보를 모델에 담아서 seat.jsp에 넘겨주기
		model.addAttribute("loginedStaffInfo",foundStaff);
		
		logger.info("**FINISHED LODING SeatTable.JSP**");
		return "seat/seatTable";
	}
	
	/*
	 * 학생 반 배치 페이지의 수정모드 불러오기
	 */
	@RequestMapping(value="seatModify", method=RequestMethod.GET)
	public String seatModify(Model model){
		logger.info("**LODING seatModify.JSP**");
		
		logger.info("**FINISHED LODING seatModify.JSP**");
		return "seat/seatModify";
	}
	
	/*
	 * 학생 반 배치 페이지의 수정모드 불러오기
	 */
	@RequestMapping(value="seatConfig", method=RequestMethod.GET)
	public String seatAuto(Model model){
		logger.info("**LODING seatAuto.JSP**");
		
		logger.info("**FINISHED LODING seatAuto.JSP**");
		return "seat/seatConfig";
	}
	
	
	
	
}
