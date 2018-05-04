package com.twoDimensionForAll.enjoy.dao;

import java.util.ArrayList;

import com.twoDimensionForAll.enjoy.Video;

/**
 * Video 관련 메소드
 */
public interface VideoMapper {
	public int addVideo(Video video);
	public ArrayList<Video> showAllVideo();
	public Video selectVideo(int videoNum);
	public ArrayList<Video> searchVideo(String videoName);
	public ArrayList<Video> sortByGenre(String videoGenre);
}
