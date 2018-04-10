package com.scitportalsystem.www.dao;


import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scitportalsystem.www.mapper.ConsultMapper;
import com.scitportalsystem.www.mapper.NewsMapper;
import com.scitportalsystem.www.vo.AskQuestion;
import com.scitportalsystem.www.vo.AskQuestionReply;



@Repository
public class ConsultDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(ConsultDAO.class);
	
	/*학생용*/
	// 페이징 처리를 위한 다오다오
	public int getTotalStudent(HashMap<String, Object> searchMap){
		logger.info("전체 글 개수 시작 DAO");
		ConsultMapper mapper = sqlSession.getMapper(ConsultMapper.class);
		int total = 0;
		
		try {
			total = mapper.getTotalStudent(searchMap);			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		logger.info("전체 글 개수 시작 DAO");
		return total;
	}
	
	// 전체 글 불러오기 위한 다오
	public ArrayList<AskQuestion> selectAskQuestionStudent(HashMap<String, Object> searchMap,int StartRecord, int CountPerPage){
		logger.info("글 목록 시작");
		ArrayList<AskQuestion> askquestionlist = null;
		ConsultMapper mapper = sqlSession.getMapper(ConsultMapper.class);
		//전체 검색 결과 중 읽을 시작위치와 개수
		RowBounds rb = new RowBounds(StartRecord, CountPerPage);
		
		try{
			askquestionlist = mapper.selectAskQuestionStudent(searchMap,rb);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		logger.info("글 목록 종료");
		return askquestionlist;
	}
	
	/*교사용*/
	// 페이징 처리를 위한 다오다오
	public int getTotal(HashMap<String, Object> searchMap){
		logger.info("전체 글 개수 시작 DAO");
		ConsultMapper mapper = sqlSession.getMapper(ConsultMapper.class);
		int total = 0;
		
		try {
			total = mapper.getTotal(searchMap);			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		logger.info("전체 글 개수 시작 DAO");
		return total;
	}
	
	// 전체 글 불러오기 위한 다오
	public ArrayList<AskQuestion> selectAskQuestionAll(HashMap<String, Object> searchMap,int StartRecord, int CountPerPage){
		logger.info("글 목록 시작");
		ArrayList<AskQuestion> askquestionlist = null;
		ConsultMapper mapper = sqlSession.getMapper(ConsultMapper.class);
		//전체 검색 결과 중 읽을 시작위치와 개수
		RowBounds rb = new RowBounds(StartRecord, CountPerPage);
		
		try{
			askquestionlist = mapper.selectAskQuestionAll(searchMap,rb);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		logger.info("글 목록 종료");
		return askquestionlist;
	}
	
	
	// 문의글 하나 읽기 다오
	public AskQuestion selectAskQuestionOne(int askQuestionNum){
		logger.info("글 보기 시작 다오");
		ConsultMapper mapper = sqlSession.getMapper(ConsultMapper.class);
		AskQuestion askquestion = null;
		try {
			askquestion = mapper.selectAskQuestionOne(askQuestionNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("글 보기 시작 종료");
		return askquestion;
	}
	
	// 리플 달기 다오
	public void insertReply(AskQuestionReply askquestionreply, int askQuestionNum) {
		logger.info("댓글 등록 시작 DAO");
		ConsultMapper mapper = sqlSession.getMapper(ConsultMapper.class);
				
		try {
			mapper.insertReply(askquestionreply);
			// 리플 갯수 추가
			mapper.updateReplyHits(askQuestionNum);
			System.out.println(mapper);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		logger.info("댓글 등록 종료 DAO");
	}
	
	// 리플 받아오기 다오
	public ArrayList<AskQuestionReply> selectReplyAll(int askQuestionNum){
		logger.info("댓글 읽기 시작 DAO");
		
		ConsultMapper mapper = sqlSession.getMapper(ConsultMapper.class);
		
		ArrayList<AskQuestionReply> replyList = null;
		
		try {
			replyList = mapper.selectReplyAll(askQuestionNum);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		logger.info("댓글 읽기 종료 DAO");
		
		return replyList;
	}
	
	// 리플 삭제 다오
	public void deleteReply(AskQuestionReply askquestionreply, int askQuestionNum){
		logger.info("글 삭제 시작 DAO");
		
		ConsultMapper mapper = sqlSession.getMapper(ConsultMapper.class);
		
		try {
			
			mapper.deleteReply(askquestionreply);
			// 리플 갯수 삭제 다오
			mapper.deleteReplyHits(askQuestionNum);
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		logger.info("글 삭제 종료 DAO");	
		
	}
	
	// 문의글 쓰기 다오
	public void writeAskQuestion(AskQuestion askquestion){
		ConsultMapper mapper = sqlSession.getMapper(ConsultMapper.class);
		logger.info("1:1문의 글 쓰기 시작 다오");
		try {			
			mapper.writeAskQuestion(askquestion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("1:1문의 글 쓰기 종료 다오");
	}
	
	
	
	}
