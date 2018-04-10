package com.scitportalsystem.www.vo;

import com.google.gson.annotations.SerializedName;
 
public class SurveyPage {
	
	@SerializedName("surveyPageId")
	private String surveyPageId;

	public String getSurveyPageId() {
		return surveyPageId;
	}

	public void setSurveyPageId(String surveyPageId) {
		this.surveyPageId = surveyPageId;
	}

	public SurveyPage(String surveyPageId) {
		super();
		this.surveyPageId = surveyPageId;
	}

	public SurveyPage() {
		super();
	}

	@Override
	public String toString() {
		return "SurveyPage [surveyPageId=" + surveyPageId + "]";
	}
	
}
