package com.scitportalsystem.www.vo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RespondSurvey {
	
	@SerializedName("respondArray") 
	private List<RespondArray> respondArray;

	public List<RespondArray> getRespondArray() {
		return respondArray;
	}
 
	public void setRespondArray(List<RespondArray> respondArray) {
		this.respondArray = respondArray;
	}

	public RespondSurvey(List<RespondArray> respondArray) {
		super();
		this.respondArray = respondArray;
	}

	public RespondSurvey() {
		super();
	}

	@Override
	public String toString() {
		return "RespondSurvey [respondArray=" + respondArray + "]";
	}

}
