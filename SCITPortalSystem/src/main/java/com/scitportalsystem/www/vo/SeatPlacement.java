package com.scitportalsystem.www.vo;

import java.util.Date;

public class SeatPlacement {
	private int seatPlacementNum; // 좌석 배치도의 고유 번호
	private int seatCreator; // 좌석 배치도 작성자(학사)의 번호
	private String seatCreatorName; // 좌석 배치도 작성자
	private int seatAlumni; // 이 배치도를 활용할 기수
	private String seatClassroom; // 이 배치도를 활용할 반
	private int seatCount; // 현재 존재하는 좌석의 수
	private String seatContent; // 좌석 배치도에 대한 html 내용
	private Date seatCreatedDate; // --작성일

	public SeatPlacement(int seatPlacementNum, int seatCreator, String seatCreatorName, int seatAlumni,
			String seatClassroom, int seatCount, String seatContent, Date seatCreatedDate) {
		super();
		this.seatPlacementNum = seatPlacementNum;
		this.seatCreator = seatCreator;
		this.seatCreatorName = seatCreatorName;
		this.seatAlumni = seatAlumni;
		this.seatClassroom = seatClassroom;
		this.seatCount = seatCount;
		this.seatContent = seatContent;
		this.seatCreatedDate = seatCreatedDate;
	}

	public SeatPlacement() {
		super();
	}

	public int getSeatPlacementNum() {
		return seatPlacementNum;
	}

	public void setSeatPlacementNum(int seatPlacementNum) {
		this.seatPlacementNum = seatPlacementNum;
	}

	public int getSeatCreator() {
		return seatCreator;
	}

	public void setSeatCreator(int seatCreator) {
		this.seatCreator = seatCreator;
	}

	public String getSeatCreatorName() {
		return seatCreatorName;
	}

	public void setSeatCreatorName(String seatCreatorName) {
		this.seatCreatorName = seatCreatorName;
	}

	public int getSeatAlumni() {
		return seatAlumni;
	}

	public void setSeatAlumni(int seatAlumni) {
		this.seatAlumni = seatAlumni;
	}

	public String getSeatClassroom() {
		return seatClassroom;
	}

	public void setSeatClassroom(String seatClassroom) {
		this.seatClassroom = seatClassroom;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public String getSeatContent() {
		return seatContent;
	}

	public void setSeatContent(String seatContent) {
		this.seatContent = seatContent;
	}

	public Date getSeatCreatedDate() {
		return seatCreatedDate;
	}

	public void setSeatCreatedDate(Date seatCreatedDate) {
		this.seatCreatedDate = seatCreatedDate;
	}

	@Override
	public String toString() {
		return "SeatPlacement [seatPlacementNum=" + seatPlacementNum + ", seatCreator=" + seatCreator
				+ ", seatCreatorName=" + seatCreatorName + ", seatAlumni=" + seatAlumni + ", seatClassroom="
				+ seatClassroom + ", seatCount=" + seatCount + ", seatContent=" + seatContent + ", seatCreatedDate="
				+ seatCreatedDate + "]";
	}

}
