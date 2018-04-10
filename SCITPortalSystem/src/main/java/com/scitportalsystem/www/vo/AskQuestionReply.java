package com.scitportalsystem.www.vo;

import java.util.Date;

public class AskQuestionReply {
	private int AskQuestionReplyNum;// --리플번호
	private int AskQuestionNum;// -- 1:1문의 게시글 번호
	private String id;// --작성자 ID
	private String name; // -- 작성자 NAME
	private String text;// -- 리플내용
	private Date inputdate;// --댓글 작성일
	
	
	
	public AskQuestionReply() {
		super();
	}

	@Override
	public String toString() {
		return "AskQuestionReply [AskQuestionReplyNum=" + AskQuestionReplyNum + ", AskQuestionNum=" + AskQuestionNum
				+ ", id=" + id + ", name=" + name + ", text=" + text + ", inputdate=" + inputdate + "]";
	}
	
	public AskQuestionReply(int askQuestionReplyNum, int askQuestionNum, String id, String name, String text,
			Date inputdate) {
		super();
		AskQuestionReplyNum = askQuestionReplyNum;
		AskQuestionNum = askQuestionNum;
		this.id = id;
		this.name = name;
		this.text = text;
		this.inputdate = inputdate;
	}
	
	public int getAskQuestionReplyNum() {
		return AskQuestionReplyNum;
	}
	public void setAskQuestionReplyNum(int askQuestionReplyNum) {
		AskQuestionReplyNum = askQuestionReplyNum;
	}
	public int getAskQuestionNum() {
		return AskQuestionNum;
	}
	public void setAskQuestionNum(int askQuestionNum) {
		AskQuestionNum = askQuestionNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getInputdate() {
		return inputdate;
	}
	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}

	

}
