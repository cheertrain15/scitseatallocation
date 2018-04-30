package com.scitportalsystem.www.vo;

public class SeatAvoid {
	//
	private int memberNum; // 회원 번호
	private String avoidPerson; // 같은 반 되기 싫은 사람

	public SeatAvoid(int memberNum, String avoidPerson) {
		super();
		this.memberNum = memberNum;
		this.avoidPerson = avoidPerson;
	}

	public SeatAvoid() {
		super();
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getAvoidPerson() {
		return avoidPerson;
	}

	public void setAvoidPerson(String avoidPerson) {
		this.avoidPerson = avoidPerson;
	}

	@Override
	public String toString() {
		return "SeatAvoid [memberNum=" + memberNum + ", avoidPerson=" + avoidPerson + "]";
	}

}
