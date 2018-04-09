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

	public List<SurveyOption> getSurveyOption() {
		return surveyOption;
	}

	public void setSurveyOption(List<SurveyOption> surveyOption) {
		this.surveyOption = surveyOption;
	}

	public PageArray(String page, String surveyQuestionContent, String surveyQuestionType,
			List<SurveyOption> surveyOption) {
		super();
		this.page = page;
		this.surveyQuestionContent = surveyQuestionContent;
		this.surveyQuestionType = surveyQuestionType;
		this.surveyOption = surveyOption;
	}

	public PageArray() {
		super();
	}

	@Override
	public String toString() {
		return "PageArray [page=" + page + ", surveyQuestionContent=" + surveyQuestionContent + ", surveyQuestionType="
				+ surveyQuestionType + ", surveyOption=" + surveyOption + "]";
	}

}
