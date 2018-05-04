package com.twoDimensionForAll.enjoy;

public class Video {
	private int videoNum;
	private String videoName, videoGenre, videoSource, videoThumbnail;

	public Video(int videoNum, String videoName, String videoGenre, String videoSource, String videoThumbnail) {
		super();
		this.videoNum = videoNum;
		this.videoName = videoName;
		this.videoGenre = videoGenre;
		this.videoSource = videoSource;
		this.videoThumbnail = videoThumbnail;
	}

	public Video() {
		super();
	}

	public int getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(int videoNum) {
		this.videoNum = videoNum;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoGenre() {
		return videoGenre;
	}

	public void setVideoGenre(String videoGenre) {
		this.videoGenre = videoGenre;
	}

	public String getVideoSource() {
		return videoSource;
	}

	public void setVideoSource(String videoSource) {
		this.videoSource = videoSource;
	}

	public String getVideoThumbnail() {
		return videoThumbnail;
	}

	public void setVideoThumbnail(String videoThumbnail) {
		this.videoThumbnail = videoThumbnail;
	}

	@Override
	public String toString() {
		return "Video [videoNum=" + videoNum + ", videoName=" + videoName + ", videoGenre=" + videoGenre
				+ ", videoSource=" + videoSource + ", videoThumbnail=" + videoThumbnail + "]";
	}

}
