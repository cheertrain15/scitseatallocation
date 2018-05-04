package com.secondProject.mhk.vo;

import java.util.Date;

public class Member {

	private int memberNum;
	private String memberId, memberPassword, memberName, memberEmail, memberPhone, memberGender, memberAddress;
	private String memberDesireField;
	private int memberDesiredWorkingTime, memberDesirePayment, memberDesireCommuteDistance, memberRecieveNotice,
			memberDeletedStatus;
	private String memberDeletedBy;
	private Date memberRegisteredDate, memberDeletedTime;

	public Member(int memberNum, String memberId, String memberPassword, String memberName, String memberEmail,
			String memberPhone, String memberGender, String memberAddress, String memberDesireField,
			String memberDesireWorkingEnvironment, int memberDesiredWorkingTime, int memberDesirePayment,
			int memberDesireCommuteDistance, int memberRecieveNotice, int memberDeletedStatus, String memberDeletedBy,
			Date memberRegisteredDate, Date memberDeletedTime) {
		super();
		this.memberNum = memberNum;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberGender = memberGender;
		this.memberAddress = memberAddress;
		this.memberDesireField = memberDesireField;
		this.memberDesiredWorkingTime = memberDesiredWorkingTime;
		this.memberDesirePayment = memberDesirePayment;
		this.memberDesireCommuteDistance = memberDesireCommuteDistance;
		this.memberRecieveNotice = memberRecieveNotice;
		this.memberDeletedStatus = memberDeletedStatus;
		this.memberDeletedBy = memberDeletedBy;
		this.memberRegisteredDate = memberRegisteredDate;
		this.memberDeletedTime = memberDeletedTime;
	}

	public Member() {
		super();
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberDesireField() {
		return memberDesireField;
	}

	public void setMemberDesireField(String memberDesireField) {
		this.memberDesireField = memberDesireField;
	}

	public int getMemberDesiredWorkingTime() {
		return memberDesiredWorkingTime;
	}

	public void setMemberDesiredWorkingTime(int memberDesiredWorkingTime) {
		this.memberDesiredWorkingTime = memberDesiredWorkingTime;
	}

	public int getMemberDesirePayment() {
		return memberDesirePayment;
	}

	public void setMemberDesirePayment(int memberDesirePayment) {
		this.memberDesirePayment = memberDesirePayment;
	}

	public int getMemberDesireCommuteDistance() {
		return memberDesireCommuteDistance;
	}

	public void setMemberDesireCommuteDistance(int memberDesireCommuteDistance) {
		this.memberDesireCommuteDistance = memberDesireCommuteDistance;
	}

	public int getMemberRecieveNotice() {
		return memberRecieveNotice;
	}

	public void setMemberRecieveNotice(int memberRecieveNotice) {
		this.memberRecieveNotice = memberRecieveNotice;
	}

	public int getMemberDeletedStatus() {
		return memberDeletedStatus;
	}

	public void setMemberDeletedStatus(int memberDeletedStatus) {
		this.memberDeletedStatus = memberDeletedStatus;
	}

	public String getMemberDeletedBy() {
		return memberDeletedBy;
	}

	public void setMemberDeletedBy(String memberDeletedBy) {
		this.memberDeletedBy = memberDeletedBy;
	}

	public Date getMemberRegisteredDate() {
		return memberRegisteredDate;
	}

	public void setMemberRegisteredDate(Date memberRegisteredDate) {
		this.memberRegisteredDate = memberRegisteredDate;
	}

	public Date getMemberDeletedTime() {
		return memberDeletedTime;
	}

	public void setMemberDeletedTime(Date memberDeletedTime) {
		this.memberDeletedTime = memberDeletedTime;
	}

	@Override
	public String toString() {
		return "Member [memberNum=" + memberNum + ", memberId=" + memberId + ", memberPassword=" + memberPassword
				+ ", memberName=" + memberName + ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone
				+ ", memberGender=" + memberGender + ", memberAddress=" + memberAddress + ", memberAddressLatitude="
				+ ", memberAddressLongitude=" + ", memberDesireField=" + memberDesireField
				+ ", memberDesireWorkingEnvironment=" + ", memberDesiredWorkingTime=" + memberDesiredWorkingTime
				+ ", memberDesirePayment=" + memberDesirePayment + ", memberDesireCommuteDistance="
				+ memberDesireCommuteDistance + ", memberRecieveNotice=" + memberRecieveNotice
				+ ", memberDeletedStatus=" + memberDeletedStatus + ", memberDeletedBy=" + memberDeletedBy
				+ ", memberRegisteredDate=" + memberRegisteredDate + ", memberDeletedTime=" + memberDeletedTime + "]";
	}

}