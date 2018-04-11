package com.scitportalsystem.www.vo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PageArray {
	
	@SerializedName("page")
	private String page;
	
	@SerializedName("surveyQuestionContent")
	private String surveyQuestionContent;
	
	@SerializedName("surveyQuestionType")
	private String surveyQuestionType;
	
	@SerializedName("surveyQuestionRequired")
	private int surveyQuestionRequired;
	
	@SerializedName("surveyOption")
	private List<SurveyOption> surveyOption;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getSurveyQuestionContent() {
		return surveyQuestionContent;
	}

	public void setSurveyQuestionContent(String surveyQuestionContent) {
		this.surveyQuestionContent = surveyQuestionContent;
	}

	public String getSurveyQuestionType() {
		return surveyQuestionType;
	}

	public void setSurveyQuestionType(String surveyQuestionType) {
		this.surveyQuestionType = surveyQuestionType;
	}

	public int getSurveyQuestionRequired() {
		return surveyQuestionRequired;
	} 

	public void setSurveyQuestionRequired(int surveyQuestionRequired) {
		this.surveyQuestionRequired = surveyQuestionRequired;
	}

	public List<SurveyOption> getSurveyOption() {
		return surveyOption;
	}

	public void setSurveyOption(List<SurveyOption> surveyOption) {
		this.surveyOption = surveyOption;
	}

	public PageArray(String page, String surveyQuestionContent, String surveyQuestionType,
			int surveyQuestionRequired, List<SurveyOption> surveyOption) {
		super();
		this.page = page;
		this.surveyQuestionContent = surveyQuestionContent;
		this.surveyQuestionType = surveyQuestionType;
		this.surveyQuestionRequired = surveyQuestionRequired;
		this.surveyOption = surveyOption;
	}

	public PageArray() {
		super();
	}

	@Override
	public String toString() {
		return "PageArray [page=" + page + ", surveyQuestionContent=" + surveyQuestionContent + ", surveyQuestionType="
				+ surveyQuestionType + ", surveyQuestionRequired=" + surveyQuestionRequired + ", surveyOption="
				+ surveyOption + "]";
	}

	

}
