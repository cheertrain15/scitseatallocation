package com.twoDimensionForAll.enjoy;

public class UserFavourite {
	private String id;
	private int favouriteVideo;

	public UserFavourite(String id, int favouriteVideo) {
		super();
		this.id = id;
		this.favouriteVideo = favouriteVideo;
	}

	public UserFavourite() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFavouriteVideo() {
		return favouriteVideo;
	}

	public void setFavouriteVideo(int favouriteVideo) {
		this.favouriteVideo = favouriteVideo;
	}

	@Override
	public String toString() {
		return "UserFavourite [id=" + id + ", favouriteVideo=" + favouriteVideo + "]";
	}

}
