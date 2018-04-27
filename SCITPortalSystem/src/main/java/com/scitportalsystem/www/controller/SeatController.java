package com.scitportalsystem.www.controller;

import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.scitportalsystem.www.dao.SeatDAO;
import com.scitportalsystem.www.vo.EvaluationCount;
import com.scitportalsystem.www.vo.MemberStaff;

import com.scitportalsystem.www.vo.SeatPlacement;
import com.scitportalsystem.www.vo.SeatStudent;
import com.scitportalsystem.www.vo.SendSeatStudent;

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
			
			//TODO : 결합할때 손봐야할 부분 (로그인 세션)
			//담당 기수만 출력하게 하기 위해 로그인한 선생님의 정보를 가져오기 
			String loginedId = (String) session.getAttribute("loginID");
			MemberStaff foundStaff = seatdao.getStaffInfo(loginedId);
			int foundMemberNum = seatdao.getMemberNum(foundStaff.getId());
			
			//학사 선생님이 담당하는 기수의 반의 좌석 배치도 자료를 가져오고 모델에 담는다.
			ArrayList<SeatPlacement> loadedSeatPlacementList = seatdao.showSeatInfo(foundMemberNum);
			model.addAttribute("loginedStaffSeatPlacement",loadedSeatPlacementList);
			
		logger.info("**FINISHED LODING SEAT.JSP**");
		return "seat/seat";
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
			String loginedId = (String) session.getAttribute("loginID");
			MemberStaff loginedStaff = seatdao.getStaffInfo(loginedId);
			int alumni = Integer.parseInt((String)session.getAttribute("loginedChargeAlumni"));
			
			SeatPlacement seatPlacement = new SeatPlacement();
			seatPlacement.setSeatCreator(loginedStaff.getTeacherNum());
			seatPlacement.setSeatAlumni(alumni);
			seatPlacement.setSeatClassroom(classInfo);
			seatPlacement.setSeatContent(seatInfo);
			seatPlacement.setSeatCount(seatCount);
			
			int result = seatdao.saveSeatInfo(seatPlacement);
			if(result == 0) {
				logger.info("**ERROR DURING saveSeatConfig**");
			}
		logger.info("**FINISHED LODING saveSeatConfig**");
		return "redirect:seatpage";
	}
	

	/*
	 * 학생 반 배치 페이지의 수정모드 불러오기
	 */
	@RequestMapping(value="seatModify", method=RequestMethod.GET)
	public String seatModify(Model model, int seatPlacementNum){
		logger.info("**LODING seatModify.JSP**");	
			SeatPlacement seatPlacement = seatdao.modifySeatPlacement(seatPlacementNum);
			model.addAttribute("seatPlacement",seatPlacement);
		logger.info("**FINISHED LODING seatModify.JSP**");
		return "seat/seatModify";
	}	
	
	/*
	 * 학생 반 배치 페이지의 수정된 좌석 배치를 DB에 저장한다.
	 */
	@RequestMapping(value="seatModifySave", method=RequestMethod.POST)
	public String seatModifySave(SeatPlacement seatPlacement, String deletedStudentNum){
		logger.info("**LODING seatModifySave.JSP**");
		//좌석이 삭제된 학생의 자리번호랑 반 내용을 초기화 시킨다.
		int[] deleteStudentSeat = new int[deletedStudentNum.length()];
		for (int i = 0 ; i < deletedStudentNum.length(); i++) {
			deleteStudentSeat[i] = deletedStudentNum.charAt(i)-'0';
		}
		seatdao.cancelStudentSeat(deleteStudentSeat);
		
		//수정된 반 배치 정보를 DB에 저장한다.
		seatdao.modifiedSeatSave(seatPlacement);
		logger.info("**FINISHED LODING seatModifySave.JSP**");
		return "redirect:seatpage";
	}
	
	
	/*
	 * 학생 반 배치를 지우기
	 */
	@RequestMapping(value="seatDelete", method=RequestMethod.GET)
	public String seatDelete(int seatPlacementNum){
		logger.info("**LODING seatDelete**");
			//반 삭제 되기 전에, 해당 반에 배치되어있던 학생들의 반 정보를 초기화.
			seatdao.defaultStudentSeat(seatPlacementNum);
			//그리고 반 배치도 지운다
			seatdao.deleteSeatInfo(seatPlacementNum);
		logger.info("**FINISHED LODING seatDelete**");
		return "redirect:seatpage";
	}
	
	/*
	 * 반에 학생 배치하기
	 */
	@RequestMapping(value="seatAllocation", method=RequestMethod.GET)
	public String seatAllocation(HttpSession session, Model model, int seatPlacementNum){
		logger.info("**LODING seatAllocation.jsp**");
			//수정할 반 배치 가져오기
			SeatPlacement seatPlacement = seatdao.modifySeatPlacement(seatPlacementNum);
			//현재 로그인한 사람의 담당자 정보 가져오기
			MemberStaff loginedStaff = (MemberStaff) session.getAttribute("loginedStaffInfo");
			//역량평가 횟수 가져오기 
			EvaluationCount loadedEvaluation = seatdao.getEvaluationCount(Integer.parseInt(loginedStaff.getInChargeAlumni()));
			if(loadedEvaluation != null) {
				int evaluationCount = loadedEvaluation.getEvaluationCount();
				model.addAttribute("evaluationCount",evaluationCount);
			}
//			담당자가 담당하는 기수의 학생들 중, 반배치 미지정된 정보 가져오기 
			ArrayList<SeatStudent> getStudents = seatdao.seatForStudents(Integer.parseInt(loginedStaff.getInChargeAlumni()));
			model.addAttribute("getStudents",getStudents);
			model.addAttribute("seatPlacement",seatPlacement);
		logger.info("**FINISHED LODING seatAllocation.jsp**");
		return "seat/seatAllocation";
	}
	
	/*
	 * 반의 학생 자리 배치 저장하기 
	 */
	@SuppressWarnings("null")
	@RequestMapping(value="seatAllocationSave", method=RequestMethod.POST)
	public String seatAllocationSave(SendSeatStudent sendSeatStudent, String dispatchedSeatPlacement, int seatPlacementNum, int[] studentNumOfStudentList){
		logger.info("**LODING seatAllocationSave**");
			
			if(studentNumOfStudentList.length !=0) {
				seatdao.cancelStudentSeat(studentNumOfStudentList);
			}
			
			//학생의 정보에 자리와 반 번호 기입하기
			try {
				List<SeatStudent> seatStudentToDB = new ArrayList<>();
				if(sendSeatStudent != null || sendSeatStudent.getSendSeatStudentList().isEmpty() == false) { 
					for(int i = 0 ; i < sendSeatStudent.getSendSeatStudentList().size() ; i++) {
						// sendSeatStudent안의 값들중 리스트가 null값으로 들어온 정보들을 필터링한다.
						if(sendSeatStudent.getSendSeatStudentList().get(i).getId()!=null) {
						SeatStudent seatForStudent = new SeatStudent();
						seatForStudent.setMemberstudentNum(sendSeatStudent.getSendSeatStudentList().get(i).getMemberstudentNum()); // memberStudentNum
						seatForStudent.setId(sendSeatStudent.getSendSeatStudentList().get(i).getId()); // id
						seatForStudent.setClassroom(sendSeatStudent.getSendSeatStudentList().get(i).getClassroom());		// classroom
						seatForStudent.setSeat(sendSeatStudent.getSendSeatStudentList().get(i).getSeat());		// seat
						seatStudentToDB.add(seatForStudent); //학생의 좌석 정보를 갱신한다.
						}
					}
				seatdao.dispatchSeatForStudent(seatStudentToDB);
				} 
			} catch(Exception e) {
				
			}
			
			//좌석 배치 및 학생 배치 표시를 저장하기 
			SeatPlacement modifiedSeatPlacement = new SeatPlacement();
			modifiedSeatPlacement.setSeatPlacementNum(seatPlacementNum);
			modifiedSeatPlacement.setSeatContent(dispatchedSeatPlacement);
			seatdao.modifiedSeatStudentPlacement(modifiedSeatPlacement);
			
			
		logger.info("**FINISHED LODING seatAllocationSave**");
		return "redirect:seatpage";
	}
	
	
	/*	TODO: 결합해야할 부분
	 * 사진 출력해주는 기능
	 */
	@RequestMapping(value="downLoad",method=RequestMethod.GET)
	public void downLoad(String id, HttpServletResponse response, HttpServletRequest req) {
		logger.info("다운로드(img) 시작");	
		
//		MemberBasic memberOne = dao.searchOneMember(id);
		
//		String profileName = memberOne.getMemberPicName();
		
		String UPLOAD_PATH = req.getSession().getServletContext().getRealPath("/resources/img/profile");
		
		try {			
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("TODO", "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//파일이 저장된 전체 경로(profile에 저장된 파일명까지) 
		
//		String fullPath = UPLOAD_PATH + "/" + memberOne.getMemberSaverPicName();
		//서버의 파일을 읽을 입력 스트림과 클라이언트에게 전달할 출력스트림
		FileInputStream fis = null; //내 pc에 있는 걸 읽어올 때 사용
		ServletOutputStream sos = null; //서블릿을 통해 출력할 때 사용 (다른 pc와 서블릿으로 연결되어 있기때문에)
		
		try {
			
			fis = new FileInputStream("fullPath");
			sos = response.getOutputStream();
			
			FileCopyUtils.copy(fis, sos);
			
			fis.close();
			sos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("다운 로드 종료");
	}
}



















