package com.scitportalsystem.www.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scitportalsystem.www.dao.LoginDAO;
import com.scitportalsystem.www.dao.MyPageDAO;
import com.scitportalsystem.www.vo.MemberBasic;
import com.scitportalsystem.www.vo.MemberStaff;
import com.scitportalsystem.www.vo.MemberStudent;
import com.scitportalsystem.www.vo.MemberStudentCertificate;

/**
 * @category 정보 추가(업데이트) 입력 컨트롤러 
 * @author 김다희
 *
 */
@Controller
public class MyPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	@Inject
	private MyPageDAO Pdao;
	
	@Inject
	private LoginDAO dao;	
	
	/**
	 * @comment staff 추가 정보 입력 페이지 이동 
	 * @param model
	 * @param memberstaff
	 * @param session
	 * @author 김다희
	 */
	@RequestMapping(value="member/staffPage",method=RequestMethod.GET)
	public String staffPage(Model model, MemberStaff memberstaff, HttpSession session){
		
		String searchStaffId = (String) session.getAttribute("loginID");
		
		MemberStaff searchStaff = Pdao.selectStaff(searchStaffId);
		
		model.addAttribute("staff", searchStaff);
		
		return "member/staffPage";
	}
	
	/**
	 * @comment staff 추가 정보 입력(업데이트) 처리 
	 * @param model
	 * @param memberStaff
	 * @author 김다희 
	 */
	@RequestMapping(value="addStaffInfo",method=RequestMethod.POST)
	public String addStaffInfo(Model model, MemberStaff memberStaff) {
		logger.info("staffInfo 입력 시작");	
		
		int result = Pdao.updateStaff(memberStaff);
		
		if(result != 1) {
			model.addAttribute("errorUP", "Failure");
			logger.info("staff정보 입력 실패");
			return "additionalInfo/staffPage";			
		}
		
		logger.info("staffInfo 입력 종료");	
		
		return "redirect:/";
	}
	
	
	/**
	 * @comment : 학생 학사정보 업데이트 페이지 이동 
	 * @return
	 */
	@RequestMapping(value="member/updateCertificate",method=RequestMethod.GET)
	public String updateCertificate() {
		
		
		return "member/certificate";
	}
	
	/**
	 * @comment : 학생 학사정보 업데이트 처리 
	 * @param model
	 * @param memberstudent
	 * @param mcertificate
	 * @param session
	 * @return
	 */
	@RequestMapping(value="member/insertCertificate",method=RequestMethod.POST)
	public String insertCertificate(Model model, MemberStudent memberstudent, 
			MemberStudentCertificate mcertificate, HttpSession session) {
		logger.info("studentInfo 입력 시작");	
		
		String searId = (String) session.getAttribute("loginID");
		
		int resultCerti = Pdao.updateStudentCerti(mcertificate);
		System.out.println(mcertificate);
		int resultStuInfo =Pdao.updateStudentInfo(memberstudent);
		System.out.println(memberstudent);
		
		MemberStudent student = Pdao.selectStudentInfo(searId);
		MemberStudentCertificate certificate = Pdao.selectStudentCerti(searId);
		
		model.addAttribute("studentInfo", student);
		model.addAttribute("certificate", certificate);		
		
		return "redirect:/";
	}
	
	/**
	 * @comment : 개인정보 확인을 위한 마이페이지 (확인용)
	 * @param model
	 * @param memberBasic	: 로그인 한 회원의 개인정보들을 담고 있는 객체 
	 * @param session	: 로그인 한 ID 사용하기 위함 
	 * @author : 김다희 
	 */
	@RequestMapping(value="member/myPage",method=RequestMethod.GET)
	public String myPage(Model model, MemberBasic memberBasic, 
			MemberStudent memberstudent, HttpSession session){
		logger.info("개인정보 폼 이동 시작");	
		
		String loginId = (String) session.getAttribute("loginID");
	
		MemberBasic searchOne = dao.searchOneMember(loginId);
		MemberStudent searchStudent = Pdao.selectStudentInfo(loginId);
		MemberStaff searchStaff = Pdao.selectStaff(loginId);
		
		
		model.addAttribute("searchOne", searchOne);		
		model.addAttribute("searchStudent", searchStudent);
		model.addAttribute("searchStaff", searchStaff);
		
		logger.info("개인정보 폼 이동 종료");	
		
		return "member/myPage";
	}
	
	/**
	 * @comment : 개인정보 (personal) 수정 페이지 이동 
	 * @param model
	 * @param memberBasic
	 * @param session
	 * @author : 김다희 
	 */
	@RequestMapping(value="member/updateMypage",method=RequestMethod.GET)
	public String update(Model model, MemberBasic memberBasic, HttpSession session){
		logger.info("개인정보 변경 폼 이동 시작");			

		String loginId = (String) session.getAttribute("loginID");
	
		MemberBasic changeOne = dao.searchOneMember(loginId);
		
		model.addAttribute("changeOne", changeOne);		
		
		
		logger.info("개인정보 변경 폼 이동 종료");	
		return "member/updateMypage";
	}
	

	/**
	 * @comment : 개인정보 수정 처리 (현재, pw/phone/address/email 만 수정가능 )
	 * @param model
	 * @param memberBasic
	 * @param session
	 * @author : 김다희 
	 */
	@RequestMapping(value="member/update",method=RequestMethod.POST)
	public String update(MemberBasic memberBasic, Model model) {
		logger.info("개인정보 변경 시작");	
		
		int result = dao.updateMember(memberBasic);		

		if(result != 1) {
			model.addAttribute("errorUP", "Failure");
			logger.info("회원 정보 수정 실패");
			return "member/updateMypage";
			
		}
		
		logger.info("개인정보 변경 종료");			
		
		return "redirect:/";
	}
	
	/**
	 * @comment : 개인정보 수정이 완료되었다는 안내 메세지 페이지 이동 
	 * @param session
	 * @param model
	 * @param memberBasic
	 * @author : 김다희 
	 */
	@RequestMapping(value="member/updateComplete",method=RequestMethod.GET)
	public String updateComplete(HttpSession session, Model model, MemberBasic memberBasic) {
		
		String userId = (String) session.getAttribute("loginID");
		String userName = (String) session.getAttribute("loginName");
		
		
		model.addAttribute("userID", userId);
		model.addAttribute("userName", userName);
		
		return "member/updateComplete";
	}
	
	
	
}
