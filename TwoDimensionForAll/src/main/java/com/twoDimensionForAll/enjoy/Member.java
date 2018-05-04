package com.twoDimensionForAll.enjoy;

public class Member {
	private String id;

	public Member(String id) {
		super();
		this.id = id;
	}

	public Member() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + "]";
	}
	
	
}