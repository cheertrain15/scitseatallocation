package com.scitportalsystem.www.vo;

/*
 * 학생이 소유중인 자격증에 대한 정보
 */
public class MemberStudentCertificate {
	private String id; // -- 회원번호
	private int itCertificate; // -- 정보처리기사/산업기사 유무
	private int jpCertificate; // -- JLPT
	private String otherCertificate; // -- 기타 자격증
	
	public MemberStudentCertificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberStudentCertificate(String id, int itCertificate, int jpCertificate, String otherCertificate) {
		super();
		this.id = id;
		this.itCertificate = itCertificate;
		this.jpCertificate = jpCertificate;
		this.otherCertificate = otherCertificate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getOtherCertificate() {
		return otherCertificate;
	}

	public void setOtherCertificate(String otherCertificate) {
		this.otherCertificate = otherCertificate;
	}

	@Override
	public String toString() {
		return "MemberStudentCertificate [id=" + id + ", itCertificate=" + itCertificate + ", jpCertificate="
				+ jpCertificate + ", otherCertificate=" + otherCertificate + "]";
	}

	
}
