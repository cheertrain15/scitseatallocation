package com.scitportalsystem.www.vo;
/*
 * 학생이 소유중인 자격증에 대한 정보
 */
public class MemberStudentCertificate {
	private int memberNum; // -- 회원번호
	private int itCertificate; // -- 정보처리기사/산업기사 유무
	private int jpCertificate; // -- JLPT
	private int otherCertificate; // -- 기타 자격증

	public MemberStudentCertificate(int memberNum, int itCertificate, int jpCertificate, int otherCertificate) {
		super();
		this.memberNum = memberNum;
		this.itCertificate = itCertificate;
		this.jpCertificate = jpCertificate;
		this.otherCertificate = otherCertificate;
	}

	public MemberStudentCertificate() {
		super();
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getItCertificate() {
		return itCertificate;
	}

	public void setItCertificate(int itCertificate) {
		this.itCertificate = itCertificate;
	}

	public int getJpCertificate() {
		return jpCertificate;
	}

	public void setJpCertificate(int jpCertificate) {
		this.jpCertificate = jpCertificate;
	}

	public int getOtherCertificate() {
		return otherCertificate;
	}

	public void setOtherCertificate(int otherCertificate) {
		this.otherCertificate = otherCertificate;
	}

	@Override
	public String toString() {
		return "MemberStudentCertificate [memberNum=" + memberNum + ", itCertificate=" + itCertificate
				+ ", jpCertificate=" + jpCertificate + ", otherCertificate=" + otherCertificate + "]";
	}

}
