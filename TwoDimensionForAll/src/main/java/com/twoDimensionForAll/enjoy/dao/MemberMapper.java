package com.twoDimensionForAll.enjoy.dao;

import java.util.ArrayList;

import com.twoDimensionForAll.enjoy.Member;
import com.twoDimensionForAll.enjoy.UserFavourite;
import com.twoDimensionForAll.enjoy.UserHistory;
import com.twoDimensionForAll.enjoy.Video;

/**
 * 사용자 관련 메소드
 */
public interface MemberMapper {
	public int insertMember(String id);
	public Member selectMember(String id);
	
	public int addFavourite(UserFavourite userfavourite); 
	public ArrayList<Video> getFavourite(String id);
	public int deleteFavourite(UserFavourite userfavourite);
	
	public int addHistory(UserHistory userhistory); 
	public ArrayList<Video> getHistory(String id);
	public int deleteHistory(UserHistory userhistory);
	
}
