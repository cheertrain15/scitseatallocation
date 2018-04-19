package com.scitportalsystem.www.vo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RespondArray {
		
	@SerializedName("surveyNum")
	private int surveyNum;
		
	@SerializedName("surveyQuestionNum") 
	private int surveyQuestionNum;
		 
	@SerializedName("surveyQuestionType")
	private String surveyQuestionType;
		
	@SerializedName("surveyRespondOptionNum")
	private int surveyRespondOptionNum;
		
	@SerializedName("surveyRespondContent")
	private String surveyRespondContent;
		
	@SerializedName("surveyRespondOptionNumArray")
	private List<Integer> surveyRespondOptionNumArray;

	public int getSurveyNum() {
		return surveyNum;
	}

	public void setSurveyNum(int surveyNum) {
		this.surveyNum = surveyNum;
	}

	public int getSurveyQuestionNum() {
		return surveyQuestionNum;
	}

	public void setSurveyQuestionNum(int surveyQuestionNum) {
		this.surveyQuestionNum = surveyQuestionNum;
	}

	public String getSurveyQuestionType() {
		return surveyQuestionType;
	}

	public void setSurveyQuestionType(String surveyQuestionType) {
		this.surveyQuestionType = surveyQuestionType;
	}

	public int getSurveyRespondOptionNum() {
		return surveyRespondOptionNum;
	}

	public void setSurveyRespondOptionNum(int surveyRespondOptionNum) {
		this.surveyRespondOptionNum = surveyRespondOptionNum;
	}

	public String getSurveyRespondContent() {
		return surveyRespondContent;
	}

	public void setSurveyRespondContent(String surveyRespondContent) {
		this.surveyRespondContent = surveyRespondContent;
	}

	public List<Integer> getSurveyRespondOptionNumArray() {
		return surveyRespondOptionNumArray;
	}

	public void setSurveyRespondOptionNumArray(List<Integer> surveyRespondOptionNumArray) {
		this.surveyRespondOptionNumArray = surveyRespondOptionNumArray;
	}

	public RespondArray(int surveyNum, int surveyQuestionNum, String surveyQuestionType, int surveyRespondOptionNum,
			String surveyRespondContent, List<Integer> surveyRespondOptionNumArray) {
		super();
		this.surveyNum = surveyNum;
		this.surveyQuestionNum = surveyQuestionNum;
		this.surveyQuestionType = surveyQuestionType;
		this.surveyRespondOptionNum = surveyRespondOptionNum;
		this.surveyRespondContent = surveyRespondContent;
		this.surveyRespondOptionNumArray = surveyRespondOptionNumArray;
	}

	public RespondArray() {
		super();
	}

	@Override
	public String toString() {
		return "RespondArray [surveyNum=" + surveyNum + ", surveyQuestionNum=" + surveyQuestionNum
				+ ", surveyQuestionType=" + surveyQuestionType + ", surveyRespondOptionNum=" + surveyRespondOptionNum
				+ ", surveyRespondContent=" + surveyRespondContent + ", surveyRespondOptionNumArray="
				+ surveyRespondOptionNumArray + "]";
	}

	
}



