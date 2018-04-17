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
import com.scitportalsystem.www.vo.MemberStudent;
import com.scitportalsystem.www.vo.PageArray;
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
			
//			int teacherNum = (int) session.getAttribute("teacherNum");
			int teacherNum = 1;

			totalCount = surveyDAO.countSelectAll(teacherNum);
			navi = new PageNavigator(LIMIT, PAGES, page, totalCount);
			list = surveyDAO.selectAll(teacherNum, LIMIT, page);
			
		}
		
		// 학생일 경우 자신이 타겟인 공지만 보기
		if (memberClass.equals("student")) {
//			String id = (String) session.getAttribute("loginID"); 
			String id = "testid8";
			
			MemberStudent param = surveyDAO.getAlumniClassroom(id);
			totalCount = surveyDAO.countSelectAll2(param);
			navi = new PageNavigator(LIMIT, PAGES, page, totalCount);
			list = surveyDAO.selectAll2(param, LIMIT, page);
		}
		
		System.out.println(list);

		model.addAttribute("list", list);
		model.addAttribute("navi", navi);

		return "survey/survey";
	}

	@RequestMapping(value = "surveyCreate", method = RequestMethod.GET)
	public String surveyCreate(HttpSession session, Model model) {

		// int teacherNum = (int) session.getAttribute("teacherNum");

		int teacherNum = 1;

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
		
			// int teacherNum = session.getAttribute("teacherNum");
			int teacherNum = 1;

			// todo : 설문대상 기수선택/반선택 막기
			// survey 테이블에 설문 기본 정보 넣기
			survey.setTeacherNum(teacherNum);
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

	@RequestMapping(value = "surveyAnswer", method = RequestMethod.GET)
	public String surveyAnswer(Model model) {

		return "survey/surveyAnswer";
	}

	@RequestMapping(value = "surveyDetail", method = RequestMethod.GET)
	public String surveyDetail(int surveyNum, Model model, HttpSession session) {
		
		// 현재 로그인 한 회원 유형 확인
//		int memberNum = (int) session.getAttribute("loginMemberNum");
		int memberNum = 8;
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
	public String surveyEdit() {

		return "survey/surveyEdit";
	}

}