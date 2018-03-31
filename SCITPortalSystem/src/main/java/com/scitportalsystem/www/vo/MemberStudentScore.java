package com.scitportalsystem.www.vo;

/*
 * 학생의 성적자료
 */
public class MemberStudentScore {
	private int MemberStudentScoreNum; // -- 학생 평가 테이블 번호
	private String id; // -- 회원번호
	private int itEvaluation; // -- 현재 학생에 대한 IT 성적 자료 번호
	private int jpEvaluation; // -- 현재 학생에 대한 일본어 성적 자료 번호
	private int basicEvaluation; // -- 현재 학생에 대한 선생님의 평가 자료 번호

	public MemberStudentScore(int memberStudentScoreNum, String id, int itEvaluation, int jpEvaluation,
			int basicEvaluation) {
		super();
		MemberStudentScoreNum = memberStudentScoreNum;
		this.id = id;
		this.itEvaluation = itEvaluation;
		this.jpEvaluation = jpEvaluation;
		this.basicEvaluation = basicEvaluation;
	}

	public MemberStudentScore() {
		super();
	}

	public int getMemberStudentScoreNum() {
		return MemberStudentScoreNum;
	}

	public void setMemberStudentScoreNum(int memberStudentScoreNum) {
		MemberStudentScoreNum = memberStudentScoreNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getItEvaluation() {
		return itEvaluation;
	}

	public void setItEvaluation(int itEvaluation) {
		this.itEvaluation = itEvaluation;
	}

	public int getJpEvaluation() {
		return jpEvaluation;
	}

	public void setJpEvaluation(int jpEvaluation) {
		this.jpEvaluation = jpEvaluation;
	}

	public int getBasicEvaluation() {
		return basicEvaluation;
	}

	public void setBasicEvaluation(int basicEvaluation) {
		this.basicEvaluation = basicEvaluation;
	}

	@Override
	public String toString() {
		return "MemberStudentScore [MemberStudentScoreNum=" + MemberStudentScoreNum + ", id=" + id + ", itEvaluation="
				+ itEvaluation + ", jpEvaluation=" + jpEvaluation + ", basicEvaluation=" + basicEvaluation + "]";
	}

}
