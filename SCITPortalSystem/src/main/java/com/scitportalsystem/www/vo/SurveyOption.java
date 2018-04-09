package com.scitportalsystem.www.vo;

import com.google.gson.annotations.SerializedName;

public class SurveyOption {
	
	@SerializedName("surveyOptionContent")
	private String surveyOptionContent;

	public String getSurveyOptionContent() {
		return surveyOptionContent;
	}

	public void setSurveyOptionContent(String surveyOptionContent) {
		this.surveyOptionContent = surveyOptionContent;
	}

	public SurveyOption(String surveyOptionContent) {
		super();
		this.surveyOptionContent = surveyOptionContent;
	}

	public SurveyOption() {
		super();
	}

	@Override
	public String toString() {
		return "SurveyOption [surveyOptionContent=" + surveyOptionContent + "]";
	}
	

}
