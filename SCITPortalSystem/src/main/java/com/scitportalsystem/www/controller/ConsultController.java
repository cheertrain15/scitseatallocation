package com.scitportalsystem.www.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.scitportalsystem.www.dao.ConsultDAO;
import com.scitportalsystem.www.util.FileService;
import com.scitportalsystem.www.util.PageNavigator;
import com.scitportalsystem.www.vo.AskQuestion;
import com.scitportalsystem.www.vo.AskQuestionReply;
import com.scitportalsystem.www.vo.MemberBasic;
import com.scitportalsystem.www.vo.News;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="AskQuestion")
public class ConsultController {
	
	@Inject
	ConsultDAO dao;
	final int countPerPage = 5;
	final int pagePerGroup = 5;
	
	private static final Logger logger = LoggerFactory.getLogger(ConsultController.class);
	
	// 1:1문의 글 목록 전체 담아오는 컨트롤러
	@RequestMapping(value="QnA", method=RequestMethod.GET)
	public String QnA(HttpSession session, Model model,
			@RequestParam(value="searchText", defaultValue="") String searchText,
			@RequestParam(value="page", defaultValue="1")int page,
			@RequestParam(value="searchSelect", defaultValue="AskQuestionTitle") String searchSelect){
		
		logger.info("글 목록 이동 시작");
		String id = (String) session.getAttribute("loginID");
		String MemberClass = (String) session.getAttribute("loginMemberClass");
		
		// 검색 조건 과 검색어 담는 해쉬 맵 입니다.
		HashMap<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchText", searchText);
		searchMap.put("searchSelect", searchSelect);
		searchMap.put("id", id);		
		
		if (MemberClass.equals("student")) {
			logger.info("학생용 컨트롤러 시작");			
			
			int total = dao.getTotalStudent(searchMap);
			
			PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total); 		
			System.out.println(navi);
			// 글 전체를 불러오는 다오
			ArrayList<AskQuestion> askquestionList = dao.selectAskQuestionStudent(searchMap, navi.getStartRecord(), navi.getCountPerPage());
			// 전체 글 담기
			model.addAttribute("askquestionList", askquestionList);
			// 검색어 담기
			model.addAttribute("searchText", searchText);
			// 검색조건 담기
			model.addAttribute("searchSelect",searchSelect);
			// 페이징 담기
			model.addAttribute("navi", navi);
			
			logger.info("학생용 컨트롤러 종료");
		} else {
			logger.info("교사용 컨트롤러 시작");
			
			int total = dao.getTotal(searchMap);
			
			PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total); 		
			System.out.println(navi);
			
			// 글 전체를 불러오는 다오
			ArrayList<AskQuestion> askquestionList = dao.selectAskQuestionAll(searchMap, navi.getStartRecord(), navi.getCountPerPage());
			
			// 전체 글 담기
			model.addAttribute("askquestionList", askquestionList);
			// 검색어 담기
			model.addAttribute("searchText", searchText);
			// 검색조건 담기
			model.addAttribute("searchSelect",searchSelect);
			// 페이징 담기
			model.addAttribute("navi", navi);
			
			logger.info("교사용 컨트롤러 종료");
		}
		
		logger.info("글 목록 이동 종료");
		
		return"consult/consult";
	}
	
	// 글 하나 읽기 컨트롤러
	@RequestMapping(value="read", method=RequestMethod.GET)
	public String read(int askQuestionNum, Model model){
		logger.info("해당 글 읽기 시작");
		
		// 해당 글 읽기 다오
		AskQuestion askquestion = dao.selectAskQuestionOne(askQuestionNum);
		model.addAttribute("askquestion", askquestion);
		
		// 해당글 리플 읽기 다오
		ArrayList<AskQuestionReply> replyList = dao.selectReplyAll(askQuestionNum);
		model.addAttribute("replyList", replyList);
		
		logger.info("해당 글 읽기 종료");
		return"consult/consultRead";
	}
	
	// 리플 등록
	@RequestMapping(value="insertReply",method=RequestMethod.POST)
	public String insertReply(AskQuestionReply askquestionreply, HttpSession session, int askQuestionNum){
		logger.info("리플 등록 시작 컨트롤러");
		
		String id = (String) session.getAttribute("loginID");

		askquestionreply.setId(id);
		
		dao.insertReply(askquestionreply, askQuestionNum);
		logger.info("리플 등록 종료 컨트롤러");
		return"redirect:read?askQuestionNum="+askquestionreply.getAskQuestionNum();
	}
	
	//리플 삭제
	@RequestMapping(value="deleteReply", method=RequestMethod.GET)
	public String deleteReply(AskQuestionReply askquestionreply, HttpSession session, int askQuestionNum){
		
		logger.info("해당 글 삭제 이동 시작 컨트롤러");
		
		// 임의로 아이디 넣음
		String id = (String) session.getAttribute("loginID");

		askquestionreply.setId(id);
		
		dao.deleteReply(askquestionreply, askQuestionNum);
		
		logger.info("해당 글 삭제 이동 종료 컨트롤러");
		
		return"redirect:read?askQuestionNum="+askquestionreply.getAskQuestionNum(); 
	}
	
	//문의글 쓰기 폼 이동
	@RequestMapping(value="insertQuestion", method=RequestMethod.GET)
	public String insertQuestion(HttpSession session, AskQuestion askquestion){
		logger.info("글쓰기 폼 이동 시작");
		
		logger.info("글쓰기 폼 이동 종료");
		return"consult/consultWrite";
	}
	
	// 문의글 쓰기
	@RequestMapping(value="writeQuestion", method=RequestMethod.POST)
	public String writeQuestion(HttpSession session, AskQuestion askquestion){
		logger.info("글쓰기 시작");
		
		// 아이디 넣음
		String id = (String) session.getAttribute("loginID");

		askquestion.setId(id);
		// 임의로 논리적 삭제 값 넣음
		askquestion.setDeleteBy(" ");
		System.out.println(askquestion);
		
		
		dao.writeAskQuestion(askquestion);
		
		logger.info("글쓰기 종료");
		return"redirect:QnA";
	}
	
	// 글 삭제
		@RequestMapping(value="deleteBoard", method=RequestMethod.GET)
		public String deleteBoard(HttpSession session ,int askQuestionNum){
			
			String id = (String) session.getAttribute("loginID");
			AskQuestion askquestion = new AskQuestion();
			askquestion.setId(id);
			askquestion.setAskQuestionNum(askQuestionNum);
			
			AskQuestion vo = dao.selectAskQuestionOne(askQuestionNum);
			
			
			int result = dao.deleteBoard(askquestion);

			
			return"redirect:QnA";
		}
	
}
