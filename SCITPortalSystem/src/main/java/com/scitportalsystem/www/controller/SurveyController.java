package com.scitportalsystem.www.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.scitportalsystem.www.dao.SurveyDAO;
import com.scitportalsystem.www.util.PageNavigator;
import com.scitportalsystem.www.vo.CreateSurvey;
import com.scitportalsystem.www.vo.MemberBasic;
import com.scitportalsystem.www.vo.MemberStudent;
import com.scitportalsystem.www.vo.PageArray;
import com.scitportalsystem.www.vo.RespondArray;
import com.scitportalsystem.www.vo.RespondSurvey;
import com.scitportalsystem.www.vo.Survey;
import com.scitportalsystem.www.vo.SurveyArray;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SurveyController {

	@Autowired
	SurveyDAO surveyDAO;
 
	private final int LIMIT = 10; // 페이지 당 아이템수
	private final int PAGES = 5; // 그룹 당 페이지수

	private static final Logger logger = LoggerFactory.getLogger(SurveyController.class);

	@RequestMapping(value = "survey", method = RequestMethod.GET)
	public String survey(HttpSession session, Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
 
		int memberNum = (int) session.getAttribute("loginMemberNum");
		
		String memberClass = surveyDAO.getMemberClass(memberNum);
		
		model.addAttribute("memberClass", memberClass);
		 
		int totalCount = 0; 
		PageNavigator navi = null;
		ArrayList<Survey> list = null;
		
		// 선생님일 경우 본인이 작성한 모든 공지 보기
		if (memberClass.equals("teacher")) {
			
			int teacherNum = (int) session.getAttribute("teacherNum");
			
			System.out.println(teacherNum);

			totalCount = surveyDAO.countSelectAll(teacherNum);
			navi = new PageNavigator(LIMIT, PAGES, page, totalCount);
			list = surveyDAO.selectAll(teacherNum, LIMIT, page);
			
			Survey target = new Survey();
			ArrayList<String> sizeList= new ArrayList<>();
			
			for (int i = 0; i < list.size(); i++) {
				
				target.setSurveyTargetAlumni(list.get(i).getSurveyTargetAlumni());
				target.setSurveyTargetClassroom(list.get(i).getSurveyTargetClassroom());
				
				int targetStudentSize = surveyDAO.countTargetStudent(target);
				System.out.println("targetStudentSize : " + targetStudentSize);
				
				int surveyNum = list.get(i).getSurveyNum();
				
				int respondStudentSize = surveyDAO.countRespondStudent(surveyNum);
				System.out.println("respondStudentSize : " + respondStudentSize);
				
				sizeList.add(respondStudentSize + " / " +targetStudentSize);
			}
			
			System.out.println(sizeList);
			model.addAttribute("sizeList", sizeList);
			
		}
		
		// 학생일 경우 자신이 타겟인 공지만 보기
		if (memberClass.equals("student")) {
			String id = (String) session.getAttribute("loginID"); 
			
			MemberStudent param = surveyDAO.getAlumniClassroom(id);
			totalCount = surveyDAO.countSelectAll2(param);
			navi = new PageNavigator(LIMIT, PAGES, page, totalCount);
			list = surveyDAO.selectAll2(param, LIMIT, page);
			
			Survey target = new Survey();
			ArrayList<String> checkRespondList = new ArrayList<>();
			
				for (int i = 0; i < list.size(); i++) {
				
				target.setSurveyTargetAlumni(list.get(i).getSurveyTargetAlumni());
				target.setSurveyTargetClassroom(list.get(i).getSurveyTargetClassroom());
				
				int surveyNum = list.get(i).getSurveyNum();
				
				target.setSurveyNum(surveyNum);
				target.setSurveyRespondmemberNum(memberNum);
				
				int respond = surveyDAO.checkRespond(target);
					if (respond == 1) {
						checkRespondList.add("참여");
					} else {
						checkRespondList.add("미참여");
					}
				
				}
				
				model.addAttribute("checkRespondList", checkRespondList);
			
		}
		
		System.out.println(list);

		model.addAttribute("list", list);
		model.addAttribute("navi", navi);

		return "survey/survey";
	}
	
	@RequestMapping(value = "checkSurveyRespondStatus", method = RequestMethod.GET)
	public String checkSurveyRespondStatus(Survey survey, Model model) {
		
		int surveyNum = survey.getSurveyNum();
		
		ArrayList<Survey> questionList = surveyDAO.getQuestionContents(surveyNum);
		model.addAttribute("questionList", questionList);
		ArrayList<Survey> respondTargetStudentsList = surveyDAO.getRespondTargetStudents(surveyNum);
		model.addAttribute("respondTargetStudentsList", respondTargetStudentsList);
		ArrayList<Survey> respondContentList = surveyDAO.getRespondContentList(surveyNum);
		
		model.addAttribute("respondContentList", respondContentList);
		
		
		return"survey/surveyAnswer";
	}
	
	@RequestMapping(value = "surveyCreate", method = RequestMethod.GET)
	public String surveyCreate(HttpSession session, Model model) {

		int teacherNum = (int) session.getAttribute("teacherNum");

		int inChargeAlumni = surveyDAO.selectInChargeAlumni(teacherNum);

		// 선생님의 담당기수를 확인하여 설문조사 작성 시 대상 기수에 담당 기수만 체크할 수 있도록

		// int alumniCount = surveyDAO.countSelectAlumni(inChargeAlumni);
		int alumni = surveyDAO.selectAlumni(inChargeAlumni);
		ArrayList<String> classRoom = surveyDAO.selectClassRoom(inChargeAlumni);

		model.addAttribute("alumni", alumni);
		model.addAttribute("classRoom", classRoom);

		return "survey/surveyCreate";
	}

	@ResponseBody
	@RequestMapping(value = "createNewSurvey", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String createNewSurvey(@RequestBody String createSurvey, HttpSession session, Survey survey) {

		Gson gson = new Gson();

		CreateSurvey cs = gson.fromJson(createSurvey, CreateSurvey.class);

		// Survey 객체에 Survey 테이블 관련 정보 저장

		SurveyArray sa = cs.getSurveyArray().get(0);

		int pageSize = sa.getSurveyPage().size();
		System.out.println(sa.getSurveyPage());
		
			int teacherNum = (int) session.getAttribute("teacherNum");

			// todo : 설문대상 기수선택/반선택 막기
			// survey 테이블에 설문 기본 정보 넣기
			survey.setTeacherNum(teacherNum);
			survey.setSurveyCategory(sa.getSurveyCategory());
			survey.setSurveyTargetAlumni(sa.getSurveyTargetAlumni());
			survey.setSurveyTargetClassroom(sa.getSurveyTargetClassroom());
			survey.setSurveyStartDate(sa.getSurveyStartDate());
			survey.setSurveyEndDate(sa.getSurveyEndDate());
			survey.setSurveyTitle(sa.getSurveyTitle());
			surveyDAO.insertSurvey(survey);
			
			// surveyPage 테이블에 설문의 각 페이지 정보 넣기
			for (int k = 0; k < pageSize; k++) {
				surveyDAO.insertSurveyPage(survey);

			int pageArraySize = cs.getPageArray().size();
			for (int i = 0; i < pageArraySize; i++) {

				PageArray pa = cs.getPageArray().get(i);

				if (sa.getSurveyPage().get(k).getSurveyPageId().equals(pa.getPage())) {

					// surveyQuesion 테이블에 각 페이지의 질문 정보 넣기
					survey.setSurveyQuestionContent(pa.getSurveyQuestionContent());
					survey.setSurveyQuestionType(pa.getSurveyQuestionType());
					survey.setSurveyQuestionRequired(pa.getSurveyQuestionRequired());
					surveyDAO.insetSurveyQuestion(survey);

					// 해당 질문이 옵션이 존재하는 항목일 경우
					int surveyOptionSize = 0;
					try {
						surveyOptionSize = pa.getSurveyOption().size();
					} catch (Exception e) {
					}

					if (surveyOptionSize > 0) {

						for (int j = 0; j < surveyOptionSize; j++) {
							System.out.println(survey.getSurveyQuestionContent());
							System.out.println(pa.getSurveyOption().get(j).getSurveyOptionContent());
							survey.setSurveyOptionContent(pa.getSurveyOption().get(j).getSurveyOptionContent());
							surveyDAO.insertSurveyOption(survey);
						}

					}
				}
			}

		}

		return "성공";
	}
	
	@ResponseBody
	@RequestMapping(value = "surveyRespond", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String surveyRespond(@RequestBody String respondSurvey, HttpSession session, Survey survey) {
		
		Gson gson = new Gson();

		RespondSurvey rs = gson.fromJson(respondSurvey, RespondSurvey.class);
		ArrayList<RespondArray> ra = (ArrayList<RespondArray>) rs.getRespondArray();
		
		int respondSize = ra.size();
		
		System.out.println(ra);
		
		int surveyRespondmemberNum = (int) session.getAttribute("loginMemberNum");
		
		for (int i = 0; i < respondSize; i++) {
			
			System.out.println(ra.get(i));
			
			survey.setSurveyNum(ra.get(i).getSurveyNum());
			survey.setSurveyQuestionNum(ra.get(i).getSurveyQuestionNum());
			survey.setSurveyQuestionType(ra.get(i).getSurveyQuestionType());
			survey.setSurveyRespondmemberNum(surveyRespondmemberNum);
			
			String questionType = ra.get(i).getSurveyQuestionType();
			
			System.out.println(questionType);
			
			if (questionType.equals("checkbox")) {
				
				for (int j = 0; j < ra.get(i).getSurveyRespondOptionNumArray().size(); j++) {
					survey.setSurveyRespondOptionNum(ra.get(i).getSurveyRespondOptionNumArray().get(j));
					surveyDAO.insertSurveyRespond(survey);
					survey.setSurveyRespondOptionNum(0);
					
				}
				
			} else if (questionType.equals("singleinput")) {
				
				survey.setSurveyRespondContent(ra.get(i).getSurveyRespondContent());
				surveyDAO.insertSurveyRespond(survey);
				survey.setSurveyRespondContent(null);
				
			} else if (questionType.equals("comment")) {
				
				survey.setSurveyRespondContent(ra.get(i).getSurveyRespondContent());
				surveyDAO.insertSurveyRespond(survey);
				survey.setSurveyRespondContent(null);
				
			} else if (questionType.equals("radiogroup")) {
				
				survey.setSurveyRespondOptionNum(ra.get(i).getSurveyRespondOptionNum());
				surveyDAO.insertSurveyRespond(survey);
				survey.setSurveyRespondOptionNum(0);
				
			} else if (questionType.equals("dropdown")) {
				
				survey.setSurveyRespondOptionNum(ra.get(i).getSurveyRespondOptionNum());
				surveyDAO.insertSurveyRespond(survey);
				survey.setSurveyRespondOptionNum(0);
			}
			
		}

		return "성공";
	}

	@RequestMapping(value = "surveyDetail", method = RequestMethod.GET)
	public String surveyDetail(int surveyNum, Model model, HttpSession session) {
		
		// 현재 로그인 한 회원 유형 확인
		int memberNum = (int) session.getAttribute("loginMemberNum");
		String memberClass = surveyDAO.getMemberClass(memberNum);
		model.addAttribute("memberClass", memberClass);
		
		// 설문 기본 정보(제목, 작성자 등)
		Survey survey = surveyDAO.selectASurvey(surveyNum);
		model.addAttribute("survey", survey);
		
		// 설문 페이지 관련 정보
		ArrayList<Survey> pages = surveyDAO.selectPages(surveyNum);
		for (int i = 0; i < pages.size(); i++) {
			System.out.println(pages.get(i).getSurveyPageNum());
		}
		HashMap<String, Object> pageNum = new HashMap<String, Object>();
		pageNum.put("pages", pages);
		model.addAttribute("pages", pages);
		
		// 설문 속 질문 관련 정보
		ArrayList<Survey> questions = surveyDAO.selectQuestions(pageNum);
		HashMap<String, Object> questionNum = new HashMap<String, Object>();
		questionNum.put("questions", questions);
		model.addAttribute("questions", questions);
		
		// 설문 속 질문의 각 선택지 정보
		ArrayList<Survey> options = surveyDAO.selectOptions(questionNum);
		model.addAttribute("options", options);
		
		return "survey/surveyDetail";
	} 

	@RequestMapping(value = "surveyEdit", method = RequestMethod.GET)
	public String surveyEdit(int surveyNum, Model model) {
		
		model.addAttribute("surveyNum", surveyNum);
		
		// 설문 기본 정보(제목, 작성자 등)
		Survey survey = surveyDAO.selectASurvey(surveyNum);
		System.out.println(survey);
		model.addAttribute("survey", survey);
		
		ArrayList<String> classRoom = surveyDAO.selectClassRoom(survey.getSurveyTargetAlumni());
		model.addAttribute("classRoom", classRoom);
				
		// 설문 페이지 관련 정보
		ArrayList<Survey> pages = surveyDAO.selectPages(surveyNum);
		for (int i = 0; i < pages.size(); i++) {
			System.out.println(pages.get(i).getSurveyPageNum());
		}
		HashMap<String, Object> pageNum = new HashMap<String, Object>();
		pageNum.put("pages", pages);
		model.addAttribute("pages", pages);
				
		// 설문 속 질문 관련 정보
		ArrayList<Survey> questions = surveyDAO.selectQuestions(pageNum);
		HashMap<String, Object> questionNum = new HashMap<String, Object>();
		questionNum.put("questions", questions);
		model.addAttribute("questions", questions);
				
		// 설문 속 질문의 각 선택지 정보
		ArrayList<Survey> options = surveyDAO.selectOptions(questionNum);
		model.addAttribute("options", options);

		return "survey/surveyEdit";
	}
	
	@ResponseBody
	@RequestMapping (value = "completeEditSurvey", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String completeEditSurvey(@RequestBody String createSurvey, HttpSession session, Survey survey) {
		Gson gson = new Gson();

		CreateSurvey cs = gson.fromJson(createSurvey, CreateSurvey.class);

		// Survey 객체에 Survey 테이블 관련 정보 저장

		SurveyArray sa = cs.getSurveyArray().get(0);

		int pageSize = sa.getSurveyPage().size();
		System.out.println(sa.getSurveyPage());
		
			int teacherNum = (int) session.getAttribute("teacherNum");

			// survey 테이블에 설문 기본 정보 넣기
			survey.setTeacherNum(teacherNum);
			survey.setSurveyNum(sa.getSurveyNum());
			survey.setSurveyCategory(sa.getSurveyCategory());
			survey.setSurveyTargetAlumni(sa.getSurveyTargetAlumni());
			survey.setSurveyTargetClassroom(sa.getSurveyTargetClassroom());
			survey.setSurveyStartDate(sa.getSurveyStartDate());
			survey.setSurveyEndDate(sa.getSurveyEndDate());
			survey.setSurveyTitle(sa.getSurveyTitle());
			surveyDAO.updateSurvey(survey);
			
			int surveyNum = sa.getSurveyNum();
			surveyDAO.deleteOldSurvey(surveyNum);
			
			// surveyPage 테이블에 설문의 각 페이지 정보 넣기
			for (int k = 0; k < pageSize; k++) {
				surveyDAO.insertSurveyPage(survey);

			int pageArraySize = cs.getPageArray().size();
			for (int i = 0; i < pageArraySize; i++) {

				PageArray pa = cs.getPageArray().get(i);

				if (sa.getSurveyPage().get(k).getSurveyPageId().equals(pa.getPage())) {

					// surveyQuesion 테이블에 각 페이지의 질문 정보 넣기
					survey.setSurveyQuestionContent(pa.getSurveyQuestionContent());
					survey.setSurveyQuestionType(pa.getSurveyQuestionType());
					survey.setSurveyQuestionRequired(pa.getSurveyQuestionRequired());
					surveyDAO.insetSurveyQuestion(survey);

					// 해당 질문이 옵션이 존재하는 항목일 경우
					int surveyOptionSize = 0;
					try {
						surveyOptionSize = pa.getSurveyOption().size();
					} catch (Exception e) {
					}

					if (surveyOptionSize > 0) {

						for (int j = 0; j < surveyOptionSize; j++) {
							System.out.println(survey.getSurveyQuestionContent());
							System.out.println(pa.getSurveyOption().get(j).getSurveyOptionContent());
							survey.setSurveyOptionContent(pa.getSurveyOption().get(j).getSurveyOptionContent());
							surveyDAO.insertSurveyOption(survey);
						}

					}
				}
			}

		}

		return "성공";
	}

}