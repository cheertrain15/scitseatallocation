package com.scitportalsystem.www.dao;


import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scitportalsystem.www.mapper.NewsMapper;
import com.scitportalsystem.www.vo.News;


@Repository
public class NewsDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(NewsDAO.class);
	
	// 공지사항 글 쓰기 다오다오
	public void writeNews(News news){
		NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
		logger.info("공지사항 글 쓰기 시작 다오");
		try {			
			mapper.writeNews(news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("공지사항 글 쓰기 종료 다오");
	}
	
	// 공지사항 글 전체보기 다오다오
	public ArrayList<News> selectNewsAll(HashMap<String, Object> searchMap, News news){
		NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
		logger.info("공지사항 전체 출력 시작 다오");
		ArrayList<News> newslist = null;
		try {
			newslist = mapper.selectNewsAll(news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("공지사항 전체 출력 종료 다오");
		return newslist;
	}
	
	// 공지사항 글 하나 보기 다오다오
	public News selectNewsOne(int boardnum){
		logger.info("글 보기 시작 다오");
		NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
		News board = null;
		try {
			board = mapper.selectNewsOne(boardnum);
			mapper.updateHits(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("글 보기 다오 종료");
		return board;
	}
	
	
	}
