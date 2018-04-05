package com.scitportalsystem.www.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.scitportalsystem.www.vo.News;


public interface NewsMapper {
	// 공지사항 글 쓰기 매퍼매퍼
	public void writeNews(News news);
	// 공지사항 글 전체보기 매퍼매퍼
	public ArrayList<News> selectNewsAll(News news);
	// 공지사항 글 하나보기 매퍼매퍼
	public News selectNewsOne(int newsNum);
	// 공지사항 글 조회수 매퍼매퍼
	public void updateHits(int newsNum);
	// 공지사항 기수, 반 받아오기 해쉬 맵 매퍼매퍼
	public ArrayList<News> selectNewsAll(HashMap<String, Object> searchMap, News news);
	
}
