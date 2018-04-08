package com.scitportalsystem.www.vo;

import java.util.Date;

/* 
 * 설문조사 답변용에 대한 정보
 * 이건 설문조사 답변 양식의 프로토 타입입니다.
 * 양식이 유동적으로 바뀌게 되면 이 VO도 유동적으로 바꾸거나, 
 * 다른 방법으로 DB의 자료 사용할 수 있도록 불러와야합니다.
 */
public class Survey {
	private int surveyNum; // -- 설문조사 양식 번호
	private String name; // -- 설문조사 작성한 선생님 이름
	// 실제 데이터베이스상 Survey 테이블에는 name 항목 없음.
	// 조인으로 다른 테이블에서 이름을 가져올 때 VO를 통해 가져오기 위해 생성한 것.
	private int teacherNum; // -- 설문조사 작성한 선생님 번호
	private String surveyTitle; // -- 설문조사 제목
	private String surveyWrittenDate; // Date NOT NULL, -- 설문조사 작성일
	private String surveyStartDate; // Date NOT NULL, -- 설문조사 시작일
	private String surveyEndDate; // Date NOT NULL, -- 설문조사 종료일
	private String surveyTargetAlumni; // 설문조사 대상 기수
	private String surveyTargetClassroom; // 설문조사 대상 반
	private int surveyPage; // 각 설문에서의 페이지
	private String surveyQuestion; // 각 설문 페이지의 질문
	private String surveyOption; // 각 질문의 선택지
	public int getSurveyNum() {
		return surveyNum;
	}
	public void setSurveyNum(int surveyNum) {
		this.surveyNum = surveyNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTeacherNum() {
		return teacherNum;
	}
	public void setTeacherNum(int teacherNum) {
		this.teacherNum = teacherNum;
	}
	public String getSurveyTitle() {
		return surveyTitle;
	}
	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}
	public String getSurveyWrittenDate() {
		return surveyWrittenDate;
	}
	public void setSurveyWrittenDate(String surveyWrittenDate) {
		this.surveyWrittenDate = surveyWrittenDate;
	}
	public String getSurveyStartDate() {
		return surveyStartDate;
	}
	public void setSurveyStartDate(String surveyStartDate) {
		this.surveyStartDate = surveyStartDate;
	}
	public String getSurveyEndDate() {
		return surveyEndDate;
	}
	public void setSurveyEndDate(String surveyEndDate) {
		this.surveyEndDate = surveyEndDate;
	}
	public String getSurveyTargetAlumni() {
		return surveyTargetAlumni;
	}
	public void setSurveyTargetAlumni(String surveyTargetAlumni) {
		this.surveyTargetAlumni = surveyTargetAlumni;
	}
	public String getSurveyTargetClassroom() {
		return surveyTargetClassroom;
	}
	public void setSurveyTargetClassroom(String surveyTargetClassroom) {
		this.surveyTargetClassroom = surveyTargetClassroom;
	}
	public int getSurveyPage() {
		return surveyPage;
	}
	public void setSurveyPage(int surveyPage) {
		this.surveyPage = surveyPage;
	}
	public String getSurveyQuestion() {
		return surveyQuestion;
	}
	public void setSurveyQuestion(String surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}
	public String getSurveyOption() {
		return surveyOption;
	}
	public void setSurveyOption(String surveyOption) {
		this.surveyOption = surveyOption;
	}
	public Survey(int surveyNum, String name, int teacherNum, String surveyTitle, String surveyWrittenDate,
			String surveyStartDate, String surveyEndDate, String surveyTargetAlumni, String surveyTargetClassroom,
			int surveyPage, String surveyQuestion, String surveyOption) {
		super();
		this.surveyNum = surveyNum;
		this.name = name;
		this.teacherNum = teacherNum;
		this.surveyTitle = surveyTitle;
		this.surveyWrittenDate = surveyWrittenDate;
		this.surveyStartDate = surveyStartDate;
		this.surveyEndDate = surveyEndDate;
		this.surveyTargetAlumni = surveyTargetAlumni;
		this.surveyTargetClassroom = surveyTargetClassroom;
		this.surveyPage = surveyPage;
		this.surveyQuestion = surveyQuestion;
		this.surveyOption = surveyOption;
	}
	public Survey() {
		super();
	}
	@Override
	public String toString() {
		return "Survey [surveyNum=" + surveyNum + ", name=" + name + ", teacherNum=" + teacherNum + ", surveyTitle="
				+ surveyTitle + ", surveyWrittenDate=" + surveyWrittenDate + ", surveyStartDate=" + surveyStartDate
				+ ", surveyEndDate=" + surveyEndDate + ", surveyTargetAlumni=" + surveyTargetAlumni
				+ ", surveyTargetClassroom=" + surveyTargetClassroom + ", surveyPage=" + surveyPage
				+ ", surveyQuestion=" + surveyQuestion + ", surveyOption=" + surveyOption + "]";
	}
	
	
//	private String surveyContent; // -- 설문조사 내용
//	private int respondNum; // -- 설문조사 응답 번호
//	private String classroom; // --설문조사 응답자의 반
//	private int memberNum; // -- 설문조사 응답자 회원번호
//	private int respondStatus; // -- 설문조사 여부
//	private Date respondDate; // -- 설문조사 응답일
//	private String respondContent; // -- 설문조사 응답내용
	
//	private int frontBack; // -- 선호하는 자리(앞/뒤)
//	private int sideCenter; // -- 선호하는 자리(벽쪽/가운데)
//	private String avoidMember; // -- 같은 조가 되기 싫은 사람 
//	private String etcMessage; // -- 비고란
	
	
	
}