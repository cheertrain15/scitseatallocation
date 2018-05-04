package com.secondProject.mhk.vo;

import java.util.Date;

public class CompanyReply {
	private int companyReplyNum;
	private String writer;
	private int memberNum, companyNum;
	private String replyMessage;
	private Date replyDate;
	private int replyDeletedStatus;
	private Date replyDeletedDate;
	private String replyDeletedBy;
	private double companyScore;

	public CompanyReply(int companyReplyNum, String writer, int memberNum, int companyNum, String replyMessage,
			Date replyDate, int replyDeletedStatus, Date replyDeletedDate, String replyDeletedBy, double companyScore) {
		super();
		this.companyReplyNum = companyReplyNum;
		this.writer = writer;
		this.memberNum = memberNum;
		this.companyNum = companyNum;
		this.replyMessage = replyMessage;
		this.replyDate = replyDate;
		this.replyDeletedStatus = replyDeletedStatus;
		this.replyDeletedDate = replyDeletedDate;
		this.replyDeletedBy = replyDeletedBy;
		this.companyScore = companyScore;
	}

	public CompanyReply() {
		super();
	}

	public int getCompanyReplyNum() {
		return companyReplyNum;
	}

	public void setCompanyReplyNum(int companyReplyNum) {
		this.companyReplyNum = companyReplyNum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getCompanyNum() {
		return companyNum;
	}

	public void setCompanyNum(int companyNum) {
		this.companyNum = companyNum;
	}

	public String getReplyMessage() {
		return replyMessage;
	}

	public void setReplyMessage(String replyMessage) {
		this.replyMessage = replyMessage;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public int getReplyDeletedStatus() {
		return replyDeletedStatus;
	}

	public void setReplyDeletedStatus(int replyDeletedStatus) {
		this.replyDeletedStatus = replyDeletedStatus;
	}

	public Date getReplyDeletedDate() {
		return replyDeletedDate;
	}

	public void setReplyDeletedDate(Date replyDeletedDate) {
		this.replyDeletedDate = replyDeletedDate;
	}

	public String getReplyDeletedBy() {
		return replyDeletedBy;
	}

	public void setReplyDeletedBy(String replyDeletedBy) {
		this.replyDeletedBy = replyDeletedBy;
	}

	public double getCompanyScore() {
		return companyScore;
	}

	public void setCompanyScore(double companyScore) {
		this.companyScore = companyScore;
	}

	@Override
	public String toString() {
		return "CompanyReply [companyReplyNum=" + companyReplyNum + ", writer=" + writer + ", memberNum=" + memberNum
				+ ", companyNum=" + companyNum + ", replyMessage=" + replyMessage + ", replyDate=" + replyDate
				+ ", replyDeletedStatus=" + replyDeletedStatus + ", replyDeletedDate=" + replyDeletedDate
				+ ", replyDeletedBy=" + replyDeletedBy + ", companyScore=" + companyScore + "]";
	}

}
