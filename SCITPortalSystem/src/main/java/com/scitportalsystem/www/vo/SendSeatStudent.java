package com.scitportalsystem.www.vo;

import java.util.List;

public class SendSeatStudent {
	private int memberstudentNum; // 학생번호
	private String id; // 회원아이디
	private String name; // 회원이름
	private String memberSaverPicName; // 사진파일 경로
	private int alumni; // 기수
	private String classroom;// 반
	private int groupNum; // 조 번호
	private int seat; // 좌석 번호
	private List<SendSeatStudent> sendSeatStudentList; // 학생 묶음

	public SendSeatStudent(int memberstudentNum, String id, String name, String memberSaverPicName, int alumni,
			String classroom, int groupNum, int seat, List<SendSeatStudent> sendSeatStudentList) {
		super();
		this.memberstudentNum = memberstudentNum;
		this.id = id;
		this.name = name;
		this.memberSaverPicName = memberSaverPicName;
		this.alumni = alumni;
		this.classroom = classroom;
		this.groupNum = groupNum;
		this.seat = seat;
		this.sendSeatStudentList = sendSeatStudentList;
	}

	public SendSeatStudent() {
		super();
	}

	public int getMemberstudentNum() {
		return memberstudentNum;
	}

	public void setMemberstudentNum(int memberstudentNum) {
		this.memberstudentNum = memberstudentNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemberSaverPicName() {
		return memberSaverPicName;
	}

	public void setMemberSaverPicName(String memberSaverPicName) {
		this.memberSaverPicName = memberSaverPicName;
	}

	public int getAlumni() {
		return alumni;
	}

	public void setAlumni(int alumni) {
		this.alumni = alumni;
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

	public List<SendSeatStudent> getSendSeatStudentList() {
		return sendSeatStudentList;
	}

	public void setSendSeatStudentList(List<SendSeatStudent> sendSeatStudentList) {
		this.sendSeatStudentList = sendSeatStudentList;
	}

	@Override
	public String toString() {
		return "\n\nSendSeatStudent [멤버번호 =" + memberstudentNum + "\n 아이디=" + id + "\n 이름=" + name
				+ "\n 사진경로=" + memberSaverPicName + "\n 기수=" + alumni + "\n 반=" + classroom
				+ "\n 조 번호=" + groupNum + "\n 좌석=" + seat + "\n sendSeatStudentList=" + sendSeatStudentList + "]";
	}

	

	

}