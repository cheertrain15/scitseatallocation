package com.scitportalsystem.www.vo;

public class SeatStudent {
	private int memberstudentNum; // 학생번호
	private String id; // 회원아이디
	private String name; // 회원이름
	private String memberSaverPicName; // 사진파일 경로
	private int alumni; // 기수
	private String classroom;// 반
	private int groupNum; // 조 번호
	private int seat; // 좌석 번호

	public SeatStudent(int memberstudentNum, String id, String name, String memberSaverPicName, int alumni,
			String classroom, int groupNum, int seat) {
		super();
		this.memberstudentNum = memberstudentNum;
		this.id = id;
		this.name = name;
		this.memberSaverPicName = memberSaverPicName;
		this.alumni = alumni;
		this.classroom = classroom;
		this.groupNum = groupNum;
		this.seat = seat;
	}

	public SeatStudent() {
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

	@Override
	public String toString() {
		return "SeatStudent [memberstudentNum=" + memberstudentNum + ", id=" + id + ", name=" + name
				+ ", memberSaverPicName=" + memberSaverPicName + ", alumni=" + alumni + ", classroom=" + classroom
				+ ", groupNum=" + groupNum + ", seat=" + seat + "]";
	}

}
