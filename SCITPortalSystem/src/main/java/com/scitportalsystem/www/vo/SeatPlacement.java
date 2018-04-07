package com.scitportalsystem.www.vo;

import java.util.Date;

public class SeatPlacement {
	private int seatPlacementNum; // Number Primary Key --좌석 배치도의 고유 번호
	private int seatCreator; // Number NOT NULL --좌석 배치도 작성자(학사)의 번호
	private String seatCreatorName; // Number NOT NULL --좌석 배치도 작성자
	private int seatAlumni; // Number NOT NULL --이 배치도를 활용할 기수
	private String seatClassroom; // varchar(1) NOT NULL --이 배치도를 활용할 반
	private String seatContent; // CLOB; --좌석 배치도에 대한 html 내용
	private Date seatCreatedDate; // Date NOT NULL --작성일

	public SeatPlacement(int seatPlacementNum, int seatCreator, String seatCreatorName, int seatAlumni,
			String seatClassroom, String seatContent, Date seatCreatedDate) {
		super();
		this.seatPlacementNum = seatPlacementNum;
		this.seatCreator = seatCreator;
		this.seatCreatorName = seatCreatorName;
		this.seatAlumni = seatAlumni;
		this.seatClassroom = seatClassroom;
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

	public String getseatCreatorName() {
		return seatCreatorName;
	}

	public void setseatCreatorName(String seatCreatorName) {
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
				+ ", seatCreatorName=" + seatCreatorName + ", seatAlumni=" + seatAlumni + ", seatClassroom=" + seatClassroom
				+ ", seatContent=" + seatContent + ", seatCreatedDate=" + seatCreatedDate + "]";
	}

}
