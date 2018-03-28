package com.scitportalsystem.www.vo;

/*
 * 학생의 일본어 성적표
 */
public class JPEvaluation {
	private int jpEvaluationNum; // -- 일본어 평가 번호
	private int memberNum; // -- 회원번호
	private int jpTestFirst; // -- 일본어 1차 역량평가
	private int jpTestSecond; // -- 일본어 2차 역량평가
	private int jpTestThird; // -- 일본어 3차 역량평가
	private int jpOralTestFirst; // -- 일본어 1차 인터뷰
	private int jpOralTestSecond; // -- 일본어 2차 인터뷰
	private int jpOralTestThird; // -- 일본어 3차 인터뷰
	private int jpTestIntroduction; // -- 일본어 자기 소개 스피치
	private int jpTestPresentation; // -- 일본어 프로젝트 발표

	public JPEvaluation(int jpEvaluationNum, int memberNum, int jpTestFirst, int jpTestSecond, int jpTestThird,
			int jpOralTestFirst, int jpOralTestSecond, int jpOralTestThird, int jpTestIntroduction,
			int jpTestPresentation) {
		super();
		this.jpEvaluationNum = jpEvaluationNum;
		this.memberNum = memberNum;
		this.jpTestFirst = jpTestFirst;
		this.jpTestSecond = jpTestSecond;
		this.jpTestThird = jpTestThird;
		this.jpOralTestFirst = jpOralTestFirst;
		this.jpOralTestSecond = jpOralTestSecond;
		this.jpOralTestThird = jpOralTestThird;
		this.jpTestIntroduction = jpTestIntroduction;
		this.jpTestPresentation = jpTestPresentation;
	}

	public JPEvaluation() {
		super();
	}

	public int getJpEvaluationNum() {
		return jpEvaluationNum;
	}

	public void setJpEvaluationNum(int jpEvaluationNum) {
		this.jpEvaluationNum = jpEvaluationNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getJpTestFirst() {
		return jpTestFirst;
	}

	public void setJpTestFirst(int jpTestFirst) {
		this.jpTestFirst = jpTestFirst;
	}

	public int getJpTestSecond() {
		return jpTestSecond;
	}

	public void setJpTestSecond(int jpTestSecond) {
		this.jpTestSecond = jpTestSecond;
	}

	public int getJpTestThird() {
		return jpTestThird;
	}

	public void setJpTestThird(int jpTestThird) {
		this.jpTestThird = jpTestThird;
	}

	public int getJpOralTestFirst() {
		return jpOralTestFirst;
	}

	public void setJpOralTestFirst(int jpOralTestFirst) {
		this.jpOralTestFirst = jpOralTestFirst;
	}

	public int getJpOralTestSecond() {
		return jpOralTestSecond;
	}

	public void setJpOralTestSecond(int jpOralTestSecond) {
		this.jpOralTestSecond = jpOralTestSecond;
	}

	public int getJpOralTestThird() {
		return jpOralTestThird;
	}

	public void setJpOralTestThird(int jpOralTestThird) {
		this.jpOralTestThird = jpOralTestThird;
	}

	public int getJpTestIntroduction() {
		return jpTestIntroduction;
	}

	public void setJpTestIntroduction(int jpTestIntroduction) {
		this.jpTestIntroduction = jpTestIntroduction;
	}

	public int getJpTestPresentation() {
		return jpTestPresentation;
	}

	public void setJpTestPresentation(int jpTestPresentation) {
		this.jpTestPresentation = jpTestPresentation;
	}

	@Override
	public String toString() {
		return "JPEvaluation [jpEvaluationNum=" + jpEvaluationNum + ", memberNum=" + memberNum + ", jpTestFirst="
				+ jpTestFirst + ", jpTestSecond=" + jpTestSecond + ", jpTestThird=" + jpTestThird + ", jpOralTestFirst="
				+ jpOralTestFirst + ", jpOralTestSecond=" + jpOralTestSecond + ", jpOralTestThird=" + jpOralTestThird
				+ ", jpTestIntroduction=" + jpTestIntroduction + ", jpTestPresentation=" + jpTestPresentation + "]";
	}

}
