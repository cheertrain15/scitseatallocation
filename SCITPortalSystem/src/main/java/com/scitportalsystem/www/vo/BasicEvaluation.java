package com.scitportalsystem.www.vo;

/*
 * 학생의 BASIC 점수
 */
public class BasicEvaluation {
	private int basicEvaluationNum; // -- Basic 평가 번호
	private int memberNum; // -- 회원번호
	private int basicAttendance; // -- 출결 평가
	private int basicAction; // -- 언행 평가
	private int basicBehaviour; // -- 수업 태도
	private int basicRule; // -- 내규 엄수
	private int basicExplanatory; // -- 사유서 작성 횟수
	private int basicConsult;// -- 재시험 횟수

	public BasicEvaluation(int basicEvaluationNum, int memberNum, int basicAttendance, int basicAction,
			int basicBehaviour, int basicRule, int basicExplanatory, int basicConsult) {
		super();
		this.basicEvaluationNum = basicEvaluationNum;
		this.memberNum = memberNum;
		this.basicAttendance = basicAttendance;
		this.basicAction = basicAction;
		this.basicBehaviour = basicBehaviour;
		this.basicRule = basicRule;
		this.basicExplanatory = basicExplanatory;
		this.basicConsult = basicConsult;
	}

	public BasicEvaluation() {
		super();
	}

	public int getBasicEvaluationNum() {
		return basicEvaluationNum;
	}

	public void setBasicEvaluationNum(int basicEvaluationNum) {
		this.basicEvaluationNum = basicEvaluationNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getBasicAttendance() {
		return basicAttendance;
	}

	public void setBasicAttendance(int basicAttendance) {
		this.basicAttendance = basicAttendance;
	}

	public int getBasicAction() {
		return basicAction;
	}

	public void setBasicAction(int basicAction) {
		this.basicAction = basicAction;
	}

	public int getBasicBehaviour() {
		return basicBehaviour;
	}

	public void setBasicBehaviour(int basicBehaviour) {
		this.basicBehaviour = basicBehaviour;
	}

	public int getBasicRule() {
		return basicRule;
	}

	public void setBasicRule(int basicRule) {
		this.basicRule = basicRule;
	}

	public int getBasicExplanatory() {
		return basicExplanatory;
	}

	public void setBasicExplanatory(int basicExplanatory) {
		this.basicExplanatory = basicExplanatory;
	}

	public int getBasicConsult() {
		return basicConsult;
	}

	public void setBasicConsult(int basicConsult) {
		this.basicConsult = basicConsult;
	}

	@Override
	public String toString() {
		return "BasicEvaluation [basicEvaluationNum=" + basicEvaluationNum + ", memberNum=" + memberNum
				+ ", basicAttendance=" + basicAttendance + ", basicAction=" + basicAction + ", basicBehaviour="
				+ basicBehaviour + ", basicRule=" + basicRule + ", basicExplanatory=" + basicExplanatory
				+ ", basicConsult=" + basicConsult + "]";
	}

}
