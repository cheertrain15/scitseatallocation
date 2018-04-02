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
import org.springframework.web.bind.annotation.RequestParam;

import com.scitportalsystem.www.dao.SurveyDAO;
import com.scitportalsystem.www.util.PageNavigator;
import com.scitportalsystem.www.vo.Survey;

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
	
	@RequestMapping (value="survey", method=RequestMethod.GET)
	public String survey(HttpSession session, Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		
//		int teacherNum = (int) session.getAttribute("teacherNum");
		
		int teacherNum = 1;
		
		int totalCount = surveyDAO.countSelectAll(teacherNum);
		
		PageNavigator navi = new PageNavigator(LIMIT, PAGES, page, totalCount);
		
		ArrayList<Survey> list = surveyDAO.selectAll(teacherNum, LIMIT, page);
		
		model.addAttribute("list", list);
		model.addAttribute("navi", navi);
		
		return "survey/survey";
	}
	
	@RequestMapping (value="surveyCreate", method=RequestMethod.GET)
	public String surveyCreate() {
		
		return "survey/surveyCreate";
	}
	 
	@RequestMapping (value="surveyAnswer", method=RequestMethod.GET)
	public String surveyAnswer() {
		
		return "survey/surveyAnswer";
	}
	
}