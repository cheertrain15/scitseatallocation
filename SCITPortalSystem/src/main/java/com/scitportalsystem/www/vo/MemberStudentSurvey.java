package com.scitportalsystem.www.vo;

import java.util.Date;

/*
 * 학생이 참여했던 설문조사 정보
 */
public class MemberStudentSurvey {
	private int surveyReplyNum; // -- 설문조사 응답 번호
	private int surveyNum; // -- 설문조사 양식 번호
	private int memberNum; // -- 회원번호
	private String surveyTitle; // -- 설문조사 제목
	private int participate; // -- 설문조사 참여 여부
	private Date participateDate; // -- 설문조사 참여일/수정일

	public MemberStudentSurvey(int surveyReplyNum, int surveyNum, int memberNum, String surveyTitle, int participate,
			Date participateDate) {
		super();
		this.surveyReplyNum = surveyReplyNum;
		this.surveyNum = surveyNum;
		this.memberNum = memberNum;
		this.surveyTitle = surveyTitle;
		this.participate = participate;
		this.participateDate = participateDate;
	}

	public MemberStudentSurvey() {
		super();
	}

	public int getSurveyReplyNum() {
		return surveyReplyNum;
	}

	public void setSurveyReplyNum(int surveyReplyNum) {
		this.surveyReplyNum = surveyReplyNum;
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

	public int getParticipate() {
		return participate;
	}

	public void setParticipate(int participate) {
		this.participate = participate;
	}

	public Date getParticipateDate() {
		return participateDate;
	}

	public void setParticipateDate(Date participateDate) {
		this.participateDate = participateDate;
	}

	@Override
	public String toString() {
		return "MemberStudentSurvey [surveyReplyNum=" + surveyReplyNum + ", surveyNum=" + surveyNum + ", memberNum="
				+ memberNum + ", surveyTitle=" + surveyTitle + ", participate=" + participate + ", participateDate="
				+ participateDate + "]";
	}

}
