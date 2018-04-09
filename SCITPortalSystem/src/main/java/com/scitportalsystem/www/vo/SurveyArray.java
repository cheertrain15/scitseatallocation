package com.scitportalsystem.www.vo;

import com.google.gson.annotations.SerializedName;

public class SurveyArray {
	
	@SerializedName("surveyTargetAlumni")
	private String surveyTargetAlumni;
	
	@SerializedName("surveyTargetClassroom")
	private String surveyTargetClassroom;
	
	@SerializedName("surveyStartDate")
	private String surveyStartDate;
	
	@SerializedName("surveyEndDate")
	private String surveyEndDate;
	
	@SerializedName("surveyTitle")
	private String surveyTitle;

	public String getSurveyTargetAlumni() {
		return surveyTargetAlumni;
	}

	public void setSurveyTargetAlumni(String surveyTargetAlumni) {
		this.surveyTargetAlumni = surveyTargetAlumni;
	}

	public String getSurveyTargetClassroom() {
		return surveyTargetClassroom;
	}

	public void setSurveyTargetClassroom(String surveyTargetClassroom) {
		this.surveyTargetClassroom = surveyTargetClassroom;
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

	public SurveyArray(String surveyTargetAlumni, String surveyTargetClassroom, String surveyStartDate,
			String surveyEndDate, String surveyTitle) {
		super();
		this.surveyTargetAlumni = surveyTargetAlumni;
		this.surveyTargetClassroom = surveyTargetClassroom;
		this.surveyStartDate = surveyStartDate;
		this.surveyEndDate = surveyEndDate;
		this.surveyTitle = surveyTitle;
	}

	public SurveyArray() {
		super();
	}

	@Override
	public String toString() {
		return "SurveyArray [surveyTargetAlumni=" + surveyTargetAlumni + ", surveyTargetClassroom="
				+ surveyTargetClassroom + ", surveyStartDate=" + surveyStartDate + ", surveyEndDate=" + surveyEndDate
				+ ", surveyTitle=" + surveyTitle + "]";
	}
}
