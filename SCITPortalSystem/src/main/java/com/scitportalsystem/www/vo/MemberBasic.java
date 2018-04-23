package com.scitportalsystem.www.vo;

import java.util.Date;

/*
 * 기본적인 회원 정보 (선생님, 학생 불문)
 */
public class MemberBasic {

	private int memberNum; // -- 회원번호
	private String id; // -- 아이디
	private String password; // -- 비밀번호
	private String memberClass; // -- 회원등급
	private String memberPicName; // -- 회원 사진 파일 이름
	private String memberSaverPicName; // -- 실제로 서버에 저장된 회원 사진 파일 이름
	private String name; // -- 이름(실명)
	private String email; // -- 이메일
	private String phone; // -- 전화번호(하이픈 없이)
	private String address; // -- 주소
	private String postNum; // -- 우편번호
	private int emailApproval; // --이메일 인증 여부
	private int adminap;		// -- 회원가입 승인 여부(관리자계정)
	private int deleteStatus; // -- 논리적 삭제 여부(0=삭제안됨, 1=삭제됨)
	private String deleteBy; // -- 논리적 삭제 실행자
	private Date deleteDate; // -- 논리적 삭제 실행일
	
	public MemberBasic(int memberNum, String id, String password, String memberClass, String memberPicName,
			String memberSaverPicName, String name, String email, String phone, String address, String postNum,
			int emailApproval, int adminap, int deleteStatus, String deleteBy, Date deleteDate) {
		super();
		this.memberNum = memberNum;
		this.id = id;
		this.password = password;
		this.memberClass = memberClass;
		this.memberPicName = memberPicName;
		this.memberSaverPicName = memberSaverPicName;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.postNum = postNum;
		this.emailApproval = emailApproval;
		this.adminap = adminap;
		this.deleteStatus = deleteStatus;
		this.deleteBy = deleteBy;
		this.deleteDate = deleteDate;
	}

	public MemberBasic() {
		super();
	}

	
	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberClass() {
		return memberClass;
	}

	public void setMemberClass(String memberClass) {
		this.memberClass = memberClass;
	}

	public String getMemberPicName() {
		return memberPicName;
	}

	public void setMemberPicName(String memberPicName) {
		this.memberPicName = memberPicName;
	}

	public String getMemberSaverPicName() {
		return memberSaverPicName;
	}

	public void setMemberSaverPicName(String memberSaverPicName) {
		this.memberSaverPicName = memberSaverPicName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public int getEmailApproval() {
		return emailApproval;
	}

	public void setEmailApproval(int emailApproval) {
		this.emailApproval = emailApproval;
	}

	public int getAdminap() {
		return adminap;
	}

	public void setAdminap(int adminap) {
		this.adminap = adminap;
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
		return "MemberBasic [memberNum=" + memberNum + ", id=" + id + ", password=" + password + ", memberClass="
				+ memberClass + ", memberPicName=" + memberPicName + ", memberSaverPicName=" + memberSaverPicName
				+ ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + ", postNum="
				+ postNum + ", emailApproval=" + emailApproval + ", adminap=" + adminap + ", deleteStatus="
				+ deleteStatus + ", deleteBy=" + deleteBy + ", deleteDate=" + deleteDate + "]";
	}

	
	
	
}
