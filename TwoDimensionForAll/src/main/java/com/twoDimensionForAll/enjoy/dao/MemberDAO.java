package com.twoDimensionForAll.enjoy.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.twoDimensionForAll.enjoy.Member;
import com.twoDimensionForAll.enjoy.UserFavourite;
import com.twoDimensionForAll.enjoy.UserHistory;
import com.twoDimensionForAll.enjoy.Video;

/**
 * 사용자 관련 DAO
 */
@Repository
public class MemberDAO {
	@Autowired
	SqlSession sqlSession;
	
	
	public int insertMember(String id) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		int result = 0;
		try {
			result = mapper.insertMember(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public Member selectMember(String id){
		Member result = new Member();
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try{
			result = mapper.selectMember(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int addFavourite(UserFavourite userfavourite){
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		int result = 0;
		try {
			result = mapper.addFavourite(userfavourite);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Video> getFavourite(String id){
		ArrayList<Video> result = new ArrayList<>();
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try{
			result = mapper.getFavourite(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteFavourite(UserFavourite userfavourite) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int result = 0;
		try {
			result = mapper.deleteFavourite(userfavourite);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int addHistory(UserHistory userhistory) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		int result = 0;
		try {
			result = mapper.addHistory(userhistory);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	} 
	
	public ArrayList<Video> getHistory(String id){
		ArrayList<Video> result = new ArrayList<>();
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try{
			result = mapper.getHistory(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteHistory(UserHistory userhistory) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int result = 0;
		try {
			result = mapper.deleteHistory(userhistory);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
