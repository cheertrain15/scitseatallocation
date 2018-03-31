package com.scitportalsystem.www.vo;

/*
 * 학생의 IT 성적표 정보
 */
public class ITEvaluation {
	private int itEvaluationNum; // -- IT 평가 번호
	private String id; // -- 회원ID
	private int itTestFirst; // -- IT 1차 역량평가
	private int itTestSecond; // -- IT 2차 역량평가
	private int itTestThird; // -- IT 3차 역량평가
	private int itProjectFirst; // -- IT 1차 프로젝트
	private int itProjectSecond; // -- IT 2차 프로젝트
	private int itProjectThird; // -- IT 3차 프로젝트
	private int itProjectFInal; // --IT 단체 프로젝트

	public ITEvaluation(int itEvaluationNum, String id, int itTestFirst, int itTestSecond, int itTestThird,
			int itProjectFirst, int itProjectSecond, int itProjectThird, int itProjectFInal) {
		super();
		this.itEvaluationNum = itEvaluationNum;
		this.id = id;
		this.itTestFirst = itTestFirst;
		this.itTestSecond = itTestSecond;
		this.itTestThird = itTestThird;
		this.itProjectFirst = itProjectFirst;
		this.itProjectSecond = itProjectSecond;
		this.itProjectThird = itProjectThird;
		this.itProjectFInal = itProjectFInal;
	}

	public ITEvaluation() {
		super();
	}

	public int getItEvaluationNum() {
		return itEvaluationNum;
	}

	public void setItEvaluationNum(int itEvaluationNum) {
		this.itEvaluationNum = itEvaluationNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getItTestFirst() {
		return itTestFirst;
	}

	public void setItTestFirst(int itTestFirst) {
		this.itTestFirst = itTestFirst;
	}

	public int getItTestSecond() {
		return itTestSecond;
	}

	public void setItTestSecond(int itTestSecond) {
		this.itTestSecond = itTestSecond;
	}

	public int getItTestThird() {
		return itTestThird;
	}

	public void setItTestThird(int itTestThird) {
		this.itTestThird = itTestThird;
	}

	public int getItProjectFirst() {
		return itProjectFirst;
	}

	public void setItProjectFirst(int itProjectFirst) {
		this.itProjectFirst = itProjectFirst;
	}

	public int getItProjectSecond() {
		return itProjectSecond;
	}

	public void setItProjectSecond(int itProjectSecond) {
		this.itProjectSecond = itProjectSecond;
	}

	public int getItProjectThird() {
		return itProjectThird;
	}

	public void setItProjectThird(int itProjectThird) {
		this.itProjectThird = itProjectThird;
	}

	public int getItProjectFInal() {
		return itProjectFInal;
	}

	public void setItProjectFInal(int itProjectFInal) {
		this.itProjectFInal = itProjectFInal;
	}

	@Override
	public String toString() {
		return "ITEvaluation [itEvaluationNum=" + itEvaluationNum + ", id=" + id + ", itTestFirst=" + itTestFirst
				+ ", itTestSecond=" + itTestSecond + ", itTestThird=" + itTestThird + ", itProjectFirst="
				+ itProjectFirst + ", itProjectSecond=" + itProjectSecond + ", itProjectThird=" + itProjectThird
				+ ", itProjectFInal=" + itProjectFInal + "]";
	}

}
