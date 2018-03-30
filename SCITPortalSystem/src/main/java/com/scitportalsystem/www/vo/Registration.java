package com.scitportalsystem.www.vo;

import java.util.Date;

/*
 * 출결관리, 지각보고에 대한 정보
 */
public class Registration {
	private int registrationNum; // -- 출결관리 글 번호
	private int writerNum; // --글 작성자 회원번호
	private String registrationContent; // -- 출결관리 글 내용
	private String estimatedTime; // -- 도착 예정 시간
	private Date registrationDate; // -- 출결관리 글 작성일
	private int registerResult; // -- 출결결과 (0=정상, 1=지각, 2=결석)
	private int deleteStatus; // -- 논리적 삭제 여부
	private String deleteBy; // -- 논리적 삭제 실행자
	private Date deleteDate; // --논리적 삭제 실행일

	public Registration(int registrationNum, int writerNum, String registrationContent, String estimatedTime,
			Date registrationDate, int registerResult, int deleteStatus, String deleteBy, Date deleteDate) {
		super();
		this.registrationNum = registrationNum;
		this.writerNum = writerNum;
		this.registrationContent = registrationContent;
		this.estimatedTime = estimatedTime;
		this.registrationDate = registrationDate;
		this.registerResult = registerResult;
		this.deleteStatus = deleteStatus;
		this.deleteBy = deleteBy;
		this.deleteDate = deleteDate;
	}

	public Registration() {
		super();
	}

	public int getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(int registrationNum) {
		this.registrationNum = registrationNum;
	}

	public int getWriterNum() {
		return writerNum;
	}

	public void setWriterNum(int writerNum) {
		this.writerNum = writerNum;
	}

	public String getRegistrationContent() {
		return registrationContent;
	}

	public void setRegistrationContent(String registrationContent) {
		this.registrationContent = registrationContent;
	}

	public String getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public int getRegisterResult() {
		return registerResult;
	}

	public void setRegisterResult(int registerResult) {
		this.registerResult = registerResult;
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
		return "Registration [registrationNum=" + registrationNum + ", writerNum=" + writerNum
				+ ", registrationContent=" + registrationContent + ", estimatedTime=" + estimatedTime
				+ ", registrationDate=" + registrationDate + ", registerResult=" + registerResult + ", deleteStatus="
				+ deleteStatus + ", deleteBy=" + deleteBy + ", deleteDate=" + deleteDate + "]";
	}

}
