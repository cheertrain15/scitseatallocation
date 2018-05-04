package com.twoDimensionForAll.enjoy.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.twoDimensionForAll.enjoy.Video;

/**
 * Video 관련 DAO
 */
@Repository
public class VideoDAO {
	@Autowired
	SqlSession sqlSession;
	
	
	public int addVideo(Video video) {
		VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
		
		int result = 0;
		try {
			result = mapper.addVideo(video);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Video> showAllVideo(){
		ArrayList<Video> result = new ArrayList<>();
		VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
		
		try{
			result = mapper.showAllVideo();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Video selectVideo(int videoNum) {
		Video result = new Video();
		VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);

		try{
			result = mapper.selectVideo(videoNum);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Video> searchVideo(String videoName){
		ArrayList<Video> result = new ArrayList<>();
		VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
		try{
			result = mapper.searchVideo(videoName);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Video> sortByGenre(String videoGenre){
		ArrayList<Video> result = new ArrayList<>();
		VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
		try{
			result = mapper.sortByGenre(videoGenre);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
