package com.scitportalsystem.www.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scitportalsystem.www.dao.MyPageDAO;
import com.scitportalsystem.www.vo.MemberStaff;
import com.scitportalsystem.www.vo.MemberStudent;
import com.scitportalsystem.www.vo.MemberStudentCertificate;

/**
 * @category 직원 정보 추가 입력 컨트롤러 
 * @author 김다희
 *
 */
@Controller
public class MyPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	@Inject
	private MyPageDAO Pdao;
	
	
	/**
	 * @comment staff 추가 정보 입력 페이지 이동 
	 * @param model
	 * @param memberstaff
	 * @param session
	 * @author 김다희
	 */
	@RequestMapping(value="staffPage",method=RequestMethod.GET)
	public String staffPage(Model model, MemberStaff memberstaff, HttpSession session){
		
		String searchStaffId = (String) session.getAttribute("loginID");
		
		MemberStaff searchStaff = Pdao.selectStaff(searchStaffId);
		
		model.addAttribute("staff", searchStaff);
		
		return "additionalInfo/staffPage";
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
	
	
	@RequestMapping(value="member/updateCertificate",method=RequestMethod.GET)
	public String updateCertificate() {
		
		
		return "member/certificate";
	}
	
	
	@RequestMapping(value="member/insertCertificate",method=RequestMethod.POST)
	public String insertCertificate(Model model, MemberStudent memberstudent, 
			MemberStudentCertificate mcertificate, HttpSession session) {
		logger.info("studentInfo 입력 시작");	
		
		String searId = (String) session.getAttribute("loginID");
		
		int resultCerti = Pdao.updateStudentCerti(mcertificate);
		int resultStuInfo =Pdao.updateStudentInfo(memberstudent);
		
		MemberStudent student = Pdao.selectStudentInfo(searId);
		MemberStudentCertificate certificate = Pdao.selectStudentCerti(searId);
		
		model.addAttribute("studentInfo", student);
		model.addAttribute("certificate", certificate);		
		
		return "redirect:/";
	}
	
	
	
}
