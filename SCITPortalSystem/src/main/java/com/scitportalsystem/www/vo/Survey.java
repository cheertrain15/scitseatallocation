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
	private int memberNum; // -- 회원번호
	private String surveyTitle; // -- 설문조사 제목
	private Date surveyWrittenDate; // Date NOT NULL, -- 설문조사 작성일
	private Date surveyStartDate; // Date NOT NULL, -- 설문조사 시작일
	private Date surveyEndDate; // Date NOT NULL, -- 설문조사 종료일
	private int frontBack; // -- 선호하는 자리(앞/뒤)
	private int sideCenter; // -- 선호하는 자리(벽쪽/가운데)
	private String avoidMember; // -- 같은 조가 되기 싫은 사람
	private String etcMessage; // -- 비고란

	public Survey(int surveyNum, int memberNum, String surveyTitle, Date surveyWrittenDate, Date surveyStartDate,
			Date surveyEndDate, int frontBack, int sideCenter, String avoidMember, String etcMessage) {
		super();
		this.surveyNum = surveyNum;
		this.memberNum = memberNum;
		this.surveyTitle = surveyTitle;
		this.surveyWrittenDate = surveyWrittenDate;
		this.surveyStartDate = surveyStartDate;
		this.surveyEndDate = surveyEndDate;
		this.frontBack = frontBack;
		this.sideCenter = sideCenter;
		this.avoidMember = avoidMember;
		this.etcMessage = etcMessage;
	}

	public Survey() {
		super();
	}

	public int getSurveyNum() {
		return surveyNum;
	}

	public void setSurveyNum(int surveyNum) {
		this.surveyNum = surveyNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	public Date getSurveyWrittenDate() {
		return surveyWrittenDate;
	}

	public void setSurveyWrittenDate(Date surveyWrittenDate) {
		this.surveyWrittenDate = surveyWrittenDate;
	}

	public Date getSurveyStartDate() {
		return surveyStartDate;
	}

	public void setSurveyStartDate(Date surveyStartDate) {
		this.surveyStartDate = surveyStartDate;
	}

	public Date getSurveyEndDate() {
		return surveyEndDate;
	}

	public void setSurveyEndDate(Date surveyEndDate) {
		this.surveyEndDate = surveyEndDate;
	}

	public int getFrontBack() {
		return frontBack;
	}

	public void setFrontBack(int frontBack) {
		this.frontBack = frontBack;
	}

	public int getSideCenter() {
		return sideCenter;
	}

	public void setSideCenter(int sideCenter) {
		this.sideCenter = sideCenter;
	}

	public String getAvoidMember() {
		return avoidMember;
	}

	public void setAvoidMember(String avoidMember) {
		this.avoidMember = avoidMember;
	}

	public String getEtcMessage() {
		return etcMessage;
	}

	public void setEtcMessage(String etcMessage) {
		this.etcMessage = etcMessage;
	}

	@Override
	public String toString() {
		return "Survey [surveyNum=" + surveyNum + ", memberNum=" + memberNum + ", surveyTitle=" + surveyTitle
				+ ", surveyWrittenDate=" + surveyWrittenDate + ", surveyStartDate=" + surveyStartDate
				+ ", surveyEndDate=" + surveyEndDate + ", frontBack=" + frontBack + ", sideCenter=" + sideCenter
				+ ", avoidMember=" + avoidMember + ", etcMessage=" + etcMessage + "]";
	}

}
