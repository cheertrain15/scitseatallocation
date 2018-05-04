package com.twoDimensionForAll.enjoy;

public class UserHistory {
	private String id;
	private int historyVideo;

	public UserHistory(String id, int historyVideo) {
		super();
		this.id = id;
		this.historyVideo = historyVideo;
	}

	public UserHistory() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getHistoryVideo() {
		return historyVideo;
	}

	public void setHistoryVideo(int historyVideo) {
		this.historyVideo = historyVideo;
	}

	@Override
	public String toString() {
		return "UserHistory [id=" + id + ", historyVideo=" + historyVideo + "]";
	}

}
