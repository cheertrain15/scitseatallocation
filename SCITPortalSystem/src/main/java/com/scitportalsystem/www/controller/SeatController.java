package com.scitportalsystem.www.controller;

import java.util.ArrayList;

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
import com.scitportalsystem.www.vo.SeatPlacement;

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
	public String seatpage(HttpSession session, Model model){
		logger.info("**LODING SEAT.JSP**");
		
		//담당 기수만 출력하게 하기 위해 로그인한 선생님의 정보를 가져오기 
		MemberStaff foundStaff = seatdao.getStaffInfo("testid");
		int foundMemberNum = seatdao.getMemberNum(foundStaff.getId());
		
		//학사 선생님이 담당하는 기수의 반의 좌석 배치도 자료를 가져오고 모델에 담는다.
		ArrayList<SeatPlacement> loadedSeatPlacementList = seatdao.showSeatInfo(foundMemberNum);
		model.addAttribute("loginedStaffSeatPlacement",loadedSeatPlacementList);
		
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
	
	/*
	 * 반 좌석 설정 정보 저장하기
	 */
	@RequestMapping(value="saveSeatConfig", method=RequestMethod.POST)
	public String saveSeatConfig(HttpSession session,String seatInfo, String classInfo, int seatCount){
		logger.info("**LODING saveSeatConfig**");
			MemberStaff loginedStaff = (MemberStaff) session.getAttribute("loginedStaffInfo");
			
			SeatPlacement seatPlacement = new SeatPlacement();
			seatPlacement.setSeatCreator(loginedStaff.getTeacherNum());
			seatPlacement.setSeatAlumni(Integer.parseInt(loginedStaff.getInChargeAlumni()));
			seatPlacement.setSeatClassroom(classInfo);
			seatPlacement.setSeatContent(seatInfo);
			seatPlacement.setSeatCount(seatCount);
			System.out.println(seatPlacement);
			int result = seatdao.saveSeatInfo(seatPlacement);
			if(result == 0) {
				logger.info("**ERROR DURING saveSeatConfig**");
			}
		logger.info("**FINISHED LODING saveSeatConfig**");
		return "redirect:seatpage";
	}
	
	
	
	
}
