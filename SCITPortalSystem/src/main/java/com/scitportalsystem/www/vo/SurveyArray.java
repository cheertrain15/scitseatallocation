package com.scitportalsystem.www.vo;

import java.util.List;

import com.google.gson.annotations.SerializedName;
 
public class SurveyArray {
	
	@SerializedName("surveyTargetAlumni")
	private int surveyTargetAlumni;
	
	@SerializedName("surveyTargetClassroom")
	private String surveyTargetClassroom;
	
	@SerializedName("surveyCategory")
	private int surveyCategory;
	
	@SerializedName("surveyStartDate")
	private String surveyStartDate;
	
	@SerializedName("surveyEndDate")
	private String surveyEndDate;
	
	@SerializedName("surveyTitle")
	private String surveyTitle;
	
	@SerializedName("surveyPage")
	private List<SurveyPage> surveyPage;

	public int getSurveyTargetAlumni() {
		return surveyTargetAlumni;
	}

	public void setSurveyTargetAlumni(int surveyTargetAlumni) {
		this.surveyTargetAlumni = surveyTargetAlumni;
	}

	public String getSurveyTargetClassroom() {
		return surveyTargetClassroom;
	}

	public void setSurveyTargetClassroom(String surveyTargetClassroom) {
		this.surveyTargetClassroom = surveyTargetClassroom;
	}

	public int getSurveyCategory() {
		return surveyCategory;
	}

	public void setSurveyCategory(int surveyCategory) {
		this.surveyCategory = surveyCategory;
	}

	public String getSurveyStartDate() {
		return surveyStartDate;
	}

	public void setSurveyStartDate(String surveyStartDate) {
		this.surveyStartDate = surveyStartDate;
	}

	public String getSurveyEndDate() {
		return surveyEndDate;
	}

	public void setSurveyEndDate(String surveyEndDate) {
		this.surveyEndDate = surveyEndDate;
	}

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	public List<SurveyPage> getSurveyPage() {
		return surveyPage;
	}

	public void setSurveyPage(List<SurveyPage> surveyPage) {
		this.surveyPage = surveyPage;
	}

	public SurveyArray(int surveyTargetAlumni, String surveyTargetClassroom, int surveyCategory, String surveyStartDate,
			String surveyEndDate, String surveyTitle, List<SurveyPage> surveyPage) {
		super();
		this.surveyTargetAlumni = surveyTargetAlumni;
		this.surveyTargetClassroom = surveyTargetClassroom;
		this.surveyCategory = surveyCategory;
		this.surveyStartDate = surveyStartDate;
		this.surveyEndDate = surveyEndDate;
		this.surveyTitle = surveyTitle;
		this.surveyPage = surveyPage;
	}

	public SurveyArray() {
		super();
	}

	@Override
	public String toString() {
		return "SurveyArray [surveyTargetAlumni=" + surveyTargetAlumni + ", surveyTargetClassroom="
				+ surveyTargetClassroom + ", surveyCategory=" + surveyCategory + ", surveyStartDate=" + surveyStartDate
				+ ", surveyEndDate=" + surveyEndDate + ", surveyTitle=" + surveyTitle + ", surveyPage=" + surveyPage
				+ "]";
	}
	
	

}