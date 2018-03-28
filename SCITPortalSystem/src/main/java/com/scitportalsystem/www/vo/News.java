package com.scitportalsystem.www.vo;

import java.util.Date;

/*
 * 공지사항에 대한 정보
 */
public class News {
	private int newsNum; // -- 공지사항 글번호
	private int writeNum; // -- 회원번호
	private String target; // -- 공지사항 조회 대상자
	private String newsTitle; // -- 공지사항 제목
	private String newsHeader; // -- 공지사항 말머리
	private String newsContent; // -- 공지사항 글 내용
	private String newsFileName; // -- 공지사항 첨부 파일 이름
	private String newsSavedFileName; // -- 실제로 서버에 저장된 첨부파일 이름
	private Date newsDate; // -- 공지사항 작성일
	private int newsDisplay; // -- 공지사항 노출
	private int deleteStatus; // -- 논리적 삭제여부
	private String deleteBy; // -- 논리적 삭제 실행자
	private Date deleteDate; // -- 논리적 삭제 실행일

	public News(int newsNum, int writeNum, String target, String newsTitle, String newsHeader, String newsContent,
			String newsFileName, String newsSavedFileName, Date newsDate, int newsDisplay, int deleteStatus,
			String deleteBy, Date deleteDate) {
		super();
		this.newsNum = newsNum;
		this.writeNum = writeNum;
		this.target = target;
		this.newsTitle = newsTitle;
		this.newsHeader = newsHeader;
		this.newsContent = newsContent;
		this.newsFileName = newsFileName;
		this.newsSavedFileName = newsSavedFileName;
		this.newsDate = newsDate;
		this.newsDisplay = newsDisplay;
		this.deleteStatus = deleteStatus;
		this.deleteBy = deleteBy;
		this.deleteDate = deleteDate;
	}

	public News() {
		super();
	}

	public int getNewsNum() {
		return newsNum;
	}

	public void setNewsNum(int newsNum) {
		this.newsNum = newsNum;
	}

	public int getWriteNum() {
		return writeNum;
	}

	public void setWriteNum(int writeNum) {
		this.writeNum = writeNum;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsHeader() {
		return newsHeader;
	}

	public void setNewsHeader(String newsHeader) {
		this.newsHeader = newsHeader;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsFileName() {
		return newsFileName;
	}

	public void setNewsFileName(String newsFileName) {
		this.newsFileName = newsFileName;
	}

	public String getNewsSavedFileName() {
		return newsSavedFileName;
	}

	public void setNewsSavedFileName(String newsSavedFileName) {
		this.newsSavedFileName = newsSavedFileName;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public int getNewsDisplay() {
		return newsDisplay;
	}

	public void setNewsDisplay(int newsDisplay) {
		this.newsDisplay = newsDisplay;
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
		return "News [newsNum=" + newsNum + ", writeNum=" + writeNum + ", target=" + target + ", newsTitle=" + newsTitle
				+ ", newsHeader=" + newsHeader + ", newsContent=" + newsContent + ", newsFileName=" + newsFileName
				+ ", newsSavedFileName=" + newsSavedFileName + ", newsDate=" + newsDate + ", newsDisplay=" + newsDisplay
				+ ", deleteStatus=" + deleteStatus + ", deleteBy=" + deleteBy + ", deleteDate=" + deleteDate + "]";
	}

}
