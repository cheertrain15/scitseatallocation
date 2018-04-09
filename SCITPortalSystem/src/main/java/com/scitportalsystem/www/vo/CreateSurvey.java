package com.scitportalsystem.www.vo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CreateSurvey {
	
	@SerializedName("surveyArray") 
	private List<SurveyArray> surveyArray;
	
	@SerializedName("pageArray") 
	private List<PageArray> pageArray;

	public List<SurveyArray> getSurveyArray() {
		return surveyArray;
	}

	public void setSurveyArray(List<SurveyArray> surveyArray) {
		this.surveyArray = surveyArray;
	}

	public List<PageArray> getPageArray() {
		return pageArray;
	}

	public void setPageArray(List<PageArray> pageArray) {
		this.pageArray = pageArray;
	}
	public CreateSurvey() {
		super();
	}

	public CreateSurvey(List<SurveyArray> surveyArray, List<PageArray> pageArray) {
		super();
		this.surveyArray = surveyArray;
		this.pageArray = pageArray;
	}

	@Override
	public String toString() {
		return "CreateSurvey [surveyArray=" + surveyArray + ", pageArray=" + pageArray + "]";
	}

	
	
}
