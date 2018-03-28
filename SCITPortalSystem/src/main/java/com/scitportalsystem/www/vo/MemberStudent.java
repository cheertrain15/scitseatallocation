package com.scitportalsystem.www.vo;

public class MemberStudent {
	private int memberNum; // -- 회원번호
	private int alumni; // -- 기수
	private int itMajor; // -- IT전공 유무
	private int jpMajor; // -- 일본어전공 유무
	private String classroom; // -- 반
	private int groupNum; // -- 조
	private int seat; // -- 좌석
	private int late; // -- 지각
	private int early; // -- 조퇴
	private int absent; // -- 결석

	public MemberStudent(int memberNum, int alumni, int itMajor, int jpMajor, String classroom, int groupNum, int seat,
			int late, int early, int absent) {
		super();
		this.memberNum = memberNum;
		this.alumni = alumni;
		this.itMajor = itMajor;
		this.jpMajor = jpMajor;
		this.classroom = classroom;
		this.groupNum = groupNum;
		this.seat = seat;
		this.late = late;
		this.early = early;
		this.absent = absent;
	}

	public MemberStudent() {
		super();
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getAlumni() {
		return alumni;
	}

	public void setAlumni(int alumni) {
		this.alumni = alumni;
	}

	public int getItMajor() {
		return itMajor;
	}

	public void setItMajor(int itMajor) {
		this.itMajor = itMajor;
	}

	public int getJpMajor() {
		return jpMajor;
	}

	public void setJpMajor(int jpMajor) {
		this.jpMajor = jpMajor;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public int getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public int getLate() {
		return late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public int getEarly() {
		return early;
	}

	public void setEarly(int early) {
		this.early = early;
	}

	public int getAbsent() {
		return absent;
	}

	public void setAbsent(int absent) {
		this.absent = absent;
	}

	@Override
	public String toString() {
		return "MemberStudent [memberNum=" + memberNum + ", alumni=" + alumni + ", itMajor=" + itMajor + ", jpMajor="
				+ jpMajor + ", classroom=" + classroom + ", groupNum=" + groupNum + ", seat=" + seat + ", late=" + late
				+ ", early=" + early + ", absent=" + absent + "]";
	}

}
