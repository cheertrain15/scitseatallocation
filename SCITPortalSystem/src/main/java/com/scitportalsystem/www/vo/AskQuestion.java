package com.scitportalsystem.www.vo;

import java.util.Date;

/*
 * 1:1 문의 기능
 */
public class AskQuestion {
	private int askQuestionNum; // -- 문의 글번호
	private String id; // -- 문의 글 작성자 회원ID
	private String name;
	private String memberClass; // -- 회원 등급
	private String askQuestionTitle; // -- 문의 제목
	private String askQuestionContent; // -- 문의 글 내용
	private Date askQuestionDate; // -- 문의 글 작성일
	private int askQuestionReplies; // --문의 글의 댓글 수
	private int deleteStatus; // -- 논리적 삭제 여부
	private String deleteBy; // -- 논리적 삭제 실행자
	private Date deleteDate; // -- 논리적 삭제 실행일
	
	public AskQuestion(int askQuestionNum, String id, String name, String memberClass, String askQuestionTitle,
			String askQuestionContent, Date askQuestionDate, int askQuestionReplies, int deleteStatus, String deleteBy,
			Date deleteDate) {
		super();
		this.askQuestionNum = askQuestionNum;
		this.id = id;
		this.name = name;
		this.memberClass = memberClass;
		this.askQuestionTitle = askQuestionTitle;
		this.askQuestionContent = askQuestionContent;
		this.askQuestionDate = askQuestionDate;
		this.askQuestionReplies = askQuestionReplies;
		this.deleteStatus = deleteStatus;
		this.deleteBy = deleteBy;
		this.deleteDate = deleteDate;
	}
	
	public AskQuestion() {
		super();
	}

	public int getAskQuestionNum() {
		return askQuestionNum;
	}

	public void setAskQuestionNum(int askQuestionNum) {
		this.askQuestionNum = askQuestionNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemberClass() {
		return memberClass;
	}

	public void setMemberClass(String memberClass) {
		this.memberClass = memberClass;
	}

	public String getAskQuestionTitle() {
		return askQuestionTitle;
	}

	public void setAskQuestionTitle(String askQuestionTitle) {
		this.askQuestionTitle = askQuestionTitle;
	}

	public String getAskQuestionContent() {
		return askQuestionContent;
	}

	public void setAskQuestionContent(String askQuestionContent) {
		this.askQuestionContent = askQuestionContent;
	}

	public Date getAskQuestionDate() {
		return askQuestionDate;
	}

	public void setAskQuestionDate(Date askQuestionDate) {
		this.askQuestionDate = askQuestionDate;
	}

	public int getAskQuestionReplies() {
		return askQuestionReplies;
	}

	public void setAskQuestionReplies(int askQuestionReplies) {
		this.askQuestionReplies = askQuestionReplies;
	}

	public int getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(int deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getDeleteBy() {
		return deleteBy;
	}

	public void setDeleteBy(String deleteBy) {
		this.deleteBy = deleteBy;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

}
