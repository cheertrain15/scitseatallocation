package com.scitportalsystem.www.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.scitportalsystem.www.vo.AskQuestion;
import com.scitportalsystem.www.vo.AskQuestionReply;
import com.scitportalsystem.www.vo.News;



public interface ConsultMapper {
	
	/*학생용*/
	//글 전체 불러오기 매퍼
	public ArrayList<AskQuestion> selectAskQuestionStudent(HashMap<String, Object> searchMap, RowBounds rb);
	// 글 삭제
	public int deleteBoard(AskQuestion askquestion);
	//페이징 처리 매퍼
	public int getTotalStudent(HashMap<String, Object> searchMap);
	
	/*교사용*/
	//글 전체 불러오기 매퍼
	public ArrayList<AskQuestion> selectAskQuestionAll(HashMap<String, Object> searchMap, RowBounds rb);
	
	//페이징 처리 매퍼
	public int getTotal(HashMap<String, Object> searchMap);
	
	// 문의글 읽기 매퍼
	public AskQuestion selectAskQuestionOne(int askQuestionNum);
	
	// 댓글 등록 매퍼
	public void insertReply(AskQuestionReply askquestionreply);	
	
	// 리플 출력 매퍼
	public ArrayList<AskQuestionReply> selectReplyAll(int askQuestionNum);
	
	// 리플 삭제 매퍼
	public void deleteReply(AskQuestionReply askquestionreply);
	
	// 리플 작성 매퍼
	public void writeAskQuestion(AskQuestion askquestion);
	
	// 리플 등록시 갯수 상승 매퍼
	public void updateReplyHits(int askQuestionNum);
	
	// 리플 삭제 시 갯수 하락 매퍼
	public void deleteReplyHits(int askQuestionNum);
	
}
