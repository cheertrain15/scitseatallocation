package com.scitportalsystem.www.vo;

import java.util.Date;
/*
 * 1:1 문의 기능
 */
public class AskQuestion {
	private int askQuestionNum; // -- 문의 글번호
	private int writerNum; // -- 문의 글 작성자 회원번호
	private String askQuestionTitle; // -- 문의 제목
	private String askQuestionContent; // -- 문의 글 내용
	private Date askQuestionDate; // -- 문의 글 작성일
	private int deleteStatus; // -- 논리적 삭제 여부
	private String deleteBy; // -- 논리적 삭제 실행자
	private Date deleteDate; // -- 논리적 삭제 실행일

	public AskQuestion(int askQuestionNum, int writerNum, String askQuestionTitle, String askQuestionContent,
			Date askQuestionDate, int deleteStatus, String deleteBy, Date deleteDate) {
		super();
		this.askQuestionNum = askQuestionNum;
		this.writerNum = writerNum;
		this.askQuestionTitle = askQuestionTitle;
		this.askQuestionContent = askQuestionContent;
		this.askQuestionDate = askQuestionDate;
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

	public int getWriterNum() {
		return writerNum;
	}

	public void setWriterNum(int writerNum) {
		this.writerNum = writerNum;
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

	@Override
	public String toString() {
		return "AskQuestion [askQuestionNum=" + askQuestionNum + ", writerNum=" + writerNum + ", askQuestionTitle="
				+ askQuestionTitle + ", askQuestionContent=" + askQuestionContent + ", askQuestionDate="
				+ askQuestionDate + ", deleteStatus=" + deleteStatus + ", deleteBy=" + deleteBy + ", deleteDate="
				+ deleteDate + "]";
	}

}
