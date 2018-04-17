package com.scitportalsystem.www.vo;

import java.util.Date;

/*
 * 출결관리, 지각보고에 대한 정보
 */
public class Registration {
	private int registrationNum; // -- 출결관리 글 번호
	private String id; // --글 작성자 회원번호
	private String registrationContent; // -- 출결관리 글 내용
	private int registrationReason;	 // -- 지각 사유
	private String estimatedTime; // -- 도착 예정 시간
	private Date registrationDate; // -- 출결관리 글 작성일
	private int deleteStatus; // -- 논리적 삭제 여부
	private String deleteBy; // -- 논리적 삭제 실행자
	private Date deleteDate; // --논리적 삭제 실행일
	
	
	
	
	public Registration(){
		
	}




	public Registration(int registrationNum, String id, String registrationContent, int registrationReason,
			String estimatedTime, Date registrationDate, int deleteStatus, String deleteBy, Date deleteDate) {
		super();
		this.registrationNum = registrationNum;
		this.id = id;
		this.registrationContent = registrationContent;
		this.registrationReason = registrationReason;
		this.estimatedTime = estimatedTime;
		this.registrationDate = registrationDate;
		this.deleteStatus = deleteStatus;
		this.deleteBy = deleteBy;
		this.deleteDate = deleteDate;
	}




	public int getRegistrationNum() {
		return registrationNum;
	}




	public void setRegistrationNum(int registrationNum) {
		this.registrationNum = registrationNum;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getRegistrationContent() {
		return registrationContent;
	}




	public void setRegistrationContent(String registrationContent) {
		this.registrationContent = registrationContent;
	}




	public int getRegistrationReason() {
		return registrationReason;
	}




	public void setRegistrationReason(int registrationReason) {
		this.registrationReason = registrationReason;
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
		return "Registration [registrationNum=" + registrationNum + ", id=" + id + ", registrationContent="
				+ registrationContent + ", registrationReason=" + registrationReason + ", estimatedTime="
				+ estimatedTime + ", registrationDate=" + registrationDate + ", deleteStatus=" + deleteStatus
				+ ", deleteBy=" + deleteBy + ", deleteDate=" + deleteDate + "]";
	}
	
	
	

	

}
