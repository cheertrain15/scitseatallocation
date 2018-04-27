package com.scitportalsystem.www.vo;

public class EvaluationCount {
	private int itEvaluationCount; // IT 역량평가 시행 횟수
    private int jpEvaluationCount; // JP 역량평가 시행 횟수
    
	public EvaluationCount(int itEvaluationCount, int jpEvaluationCount) {
		super();
		this.itEvaluationCount = itEvaluationCount;
		this.jpEvaluationCount = jpEvaluationCount;
	}

	public EvaluationCount() {
		super();
	}
	
	//역량 평가 횟수 합
	public int getEvaluationCount() {
		return itEvaluationCount+jpEvaluationCount;
	}

	public int getItEvaluationCount() {
		return itEvaluationCount;
	}

	public void setItEvaluationCount(int itEvaluationCount) {
		this.itEvaluationCount = itEvaluationCount;
	}

	public int getJpEvaluationCount() {
		return jpEvaluationCount;
	}

	public void setJpEvaluationCount(int jpEvaluationCount) {
		this.jpEvaluationCount = jpEvaluationCount;
	}

	@Override
	public String toString() {
		return "EvaluationCount [itEvaluationCount=" + itEvaluationCount + ", jpEvaluationCount=" + jpEvaluationCount
				+ "]";
	}
    
    
}
