package com.scitportalsystem.www.vo;

/*
 * 선생님에 대한 정보
 */
public class MemberStaff {
	private int teacherNum; // -- 학사번호
	private String id; // -- 회원번호
	private String inChargeAlumni; // -- 담당기수
	private String inChargeSubject; // varchar2(10) not null -- 담당과목

	public MemberStaff(int teacherNum, String id, String inChargeAlumni, String inChargeSubject) {
		super();
		this.teacherNum = teacherNum;
		this.id = id;
		this.inChargeAlumni = inChargeAlumni;
		this.inChargeSubject = inChargeSubject;
	}

	public MemberStaff() {
		super();
	}

	public int getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(int teacherNum) {
		this.teacherNum = teacherNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "MemberStaff [teacherNum=" + teacherNum + ", id=" + id + ", inChargeAlumni=" + inChargeAlumni
				+ ", inChargeSubject=" + inChargeSubject + "]";
	}

}
