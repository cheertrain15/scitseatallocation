package com.scitportalsystem.www.vo;

import java.util.Date;

public class AskQuestionReply {
	private int AskQuestionReplyNum;// --리플번호
	private int AskQuestionNum;// -- 1:1문의 게시글 번호
	private String id;// --작성자 ID
	private String text;// -- 리플내용
	private Date inputdate;// --댓글 작성일

	public AskQuestionReply(int askQuestionReplyNum, int askQuestionNum, String id, String text, Date inputdate) {
		super();
		AskQuestionReplyNum = askQuestionReplyNum;
		AskQuestionNum = askQuestionNum;
		this.id = id;
		this.text = text;
		this.inputdate = inputdate;
	}

	public AskQuestionReply() {
		super();
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

	@Override
	public String toString() {
		return "AskQuestionReply [AskQuestionReplyNum=" + AskQuestionReplyNum + ", AskQuestionNum=" + AskQuestionNum
				+ ", id=" + id + ", text=" + text + ", inputdate=" + inputdate + "]";
	}

}
