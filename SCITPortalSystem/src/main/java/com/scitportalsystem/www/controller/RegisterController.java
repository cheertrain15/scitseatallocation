package com.scitportalsystem.www.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.scitportalsystem.www.dao.RegisterDAO;
import com.scitportalsystem.www.util.PageNavigator;
import com.scitportalsystem.www.vo.Registration;
import com.scitportalsystem.www.vo.RegistrationResult;


/**
 * 지각 및 출석 콘트롤러
 * 글쓰기, 글 목록 출력
 * 
 */
@Controller
@RequestMapping("attendance")
public class RegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	RegisterDAO dao;		// 학새 지각 및 결석 관련 데이터 처리 객체
	
	//지각 및 결석 게시판 관련 상수값들(선생님용)
	final int countPerPage = 5;			//페이지 당 글 수
	final int pagePerGroup = 5;				//페이지 이동 그룹 당 표시할 페이지 수
	
	/**
	 * 글 저장 처리
	 * @param registration 사용자가 입력한 글 내용
	 */
	@RequestMapping(value="writeRegist", method=RequestMethod.GET)
	public String insertRegist(Registration registration, HttpSession session){
		logger.info("지각 및 결석 등록 폼 이동 시작");
		
		
		logger.info("지각 및 결석 등록 폼 이동 종료");
		return "attendance/attendanceWrite";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(Registration registration, HttpSession session, Model model, String arrive_h, String arrive_m, String etcReason){
		logger.info("지각 및 결석 글 등록 시작");	
		
		String id = (String)session.getAttribute("loginID");
		String deleteBy = " ";
		String estimatedTime = arrive_h + "시 " + arrive_m + "분";
		
		registration.setId(id);
		registration.setDeleteBy(deleteBy);
		registration.setEstimatedTime(estimatedTime);
		
		String registrationContent = "";
		if (etcReason != null) {
			registrationContent = registration.getRegistrationContent() +" : "  + etcReason;
			registration.setRegistrationContent(registrationContent);
		}
		
		System.out.println("Controller : Test : result : " + registration.getId());
		System.out.println("Controller : Test : RegistrationContent : " + registration.getRegistrationContent());
		System.out.println("Controller : Test : EstimatedTime : " + registration.getEstimatedTime());
		System.out.println("Controller : Test : RegistrationReason : " + registration.getRegistrationReason());
		
		int result = dao.insertRegist(registration);
		
		if (result != 1) {
			model.addAttribute("errMsg", "등록 실패");
			logger.info("지각 및 결석 등록  실패");
			return "attendance/attendanceWrite";
		}
		
		logger.info("지각 및 결석 글 등록 종료");
		return "attendance/attendanceWriteComplete";
	}
	
	
	/**
	 * 글 목록
	 * @param page 현재 페이지. 없으면 1로 처리
	 * @param searchText 검색어. 없으면 ""로 처리
	 */
	@RequestMapping(value="attendance", method=RequestMethod.GET)
	public String registListAll(@RequestParam(value="page", defaultValue="1") int page,
							 	@RequestParam(value="searchText", defaultValue="") String searchText,
							 	@RequestParam(value="selAlumni", defaultValue="") String selAlumni,
							 	@RequestParam(value="selClassroom", defaultValue="") String selClassroom,
							 Model model, HttpSession session){
		logger.info("지각 및 결석 등록 목록 출력 시작");
		logger.info("page: {}, searchText: {}", page, searchText, selAlumni, selClassroom);
		
		HashMap<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchText", searchText);
		searchMap.put("selAlumni", selAlumni);
		searchMap.put("selClassroom", selClassroom);
		
		System.out.println(searchMap);
		
		// 전체 글 개수
		int total = dao.getTotal(searchMap);
		
		//페이지 계산을 위한 객체 생성
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total);
		
		//검색어와 시작 위치, 페이지당 글 수를 전달하여 전체 목록 읽기
		ArrayList<RegistrationResult> registlist = dao.listRegistAll(searchMap, navi.getStartRecord(), navi.getCountPerPage());
	
		
		
		//세션에서 로그인한 사용자의 아이디를 읽어서  jsp에서 선생님과 학생 구분
		String id = (String) session.getAttribute("loginID");
		String memberClass = dao.userInfo(id);
		ArrayList<RegistrationResult> registlist_stu = dao.listRegistOne(id);
		
		model.addAttribute("registlist_stu", registlist_stu);
		model.addAttribute("memberClass", memberClass);
		model.addAttribute("total", total);
		
		//페이지 정보 객체와 글 목록, 검색어를 모델에 저장
		model.addAttribute("registlist", registlist);
		model.addAttribute("navi", navi);
		model.addAttribute("searchText", searchText);
		model.addAttribute("selAlumni", selAlumni);
		model.addAttribute("selClassroom", selClassroom);
		
		
		logger.info("지각 및 결석 등록 목록 출력 종료");
		return "attendance/attendance";
	}
	
	@RequestMapping(value="delRegistration", method=RequestMethod.GET)
	public String delRegistration(String reginumCheck , HttpSession session, Model model ){
		
		System.out.println(reginumCheck);
		HashMap<String, Object> delMap = new HashMap<>();
		
		String[] registrationNum1 = reginumCheck.split(",");
		System.out.println(registrationNum1);
		for (int i = 0; i < registrationNum1.length; i++) {
			dao.deleteRegist(registrationNum1[i]);
		}
		
		System.out.println(registrationNum1);
		
		return "redirect:attendance";
	}
	
	
}
