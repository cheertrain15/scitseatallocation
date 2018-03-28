package com.scitportalsystem.www.vo;

/*
 * 선생님에 대한 정보
 */
public class MemberStaff {
	private int memberNum; // -- 회원번호
	private int teacherNum; // -- 학사번호
	private String inChargeAlumni; // -- 담당기수
	private String inChargeSubject; // varchar2(10) not null -- 담당과목

	public MemberStaff(int memberNum, int teacherNum, String inChargeAlumni, String inChargeSubject) {
		super();
		this.memberNum = memberNum;
		this.teacherNum = teacherNum;
		this.inChargeAlumni = inChargeAlumni;
		this.inChargeSubject = inChargeSubject;
	}

	public MemberStaff() {
		super();
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(int teacherNum) {
		this.teacherNum = teacherNum;
	}

	public String getInChargeAlumni() {
		return inChargeAlumni;
	}

	public void setInChargeAlumni(String inChargeAlumni) {
		this.inChargeAlumni = inChargeAlumni;
	}

	public String getInChargeSubject() {
		return inChargeSubject;
	}

	public void setInChargeSubject(String inChargeSubject) {
		this.inChargeSubject = inChargeSubject;
	}

	@Override
	public String toString() {
		return "MemberStaff [memberNum=" + memberNum + ", teacherNum=" + teacherNum + ", inChargeAlumni="
				+ inChargeAlumni + ", inChargeSubject=" + inChargeSubject + "]";
	}

}
