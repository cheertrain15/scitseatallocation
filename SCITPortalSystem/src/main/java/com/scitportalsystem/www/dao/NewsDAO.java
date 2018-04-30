package com.scitportalsystem.www.dao;


import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scitportalsystem.www.mapper.ConsultMapper;
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
	
public int updateBoard(News news){
		
		logger.info("글 수정 종료 DAO");
		NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
		int result = 0;
		try {
			
			result = mapper.updateBoard(news);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		logger.info("글 수정 종료 DAO");
		return result;
	}
	
	public int deleteBoard(News news){
		logger.info("글 삭제 시작 DAO");
		
		NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
		int result = 0;
		try {
			
			result = mapper.deleteBoard(news);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		logger.info("글 삭제 종료 DAO");
		return result;		
		
	}
	
	
	// 페이징 처리를 위한 다오다오
	public int getTotal(HashMap<String, Object> searchMap){
		logger.info("전체 글 개수 시작 DAO");
		NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
		int total = 0;
		
		try {
			total = mapper.getTotal(searchMap);			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		logger.info("전체 글 개수 시작 DAO");
		return total;
	}
	
	// 공지사항 글 전체보기 학생용
	public ArrayList<News> selectNewsAll(HashMap<String, Object> searchMap, int StartRecord, int CountPerPage){
		logger.info("공지사항 전체 출력 시작 다오");
		ArrayList<News> newslist = null;
		NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
		//전체 검색 결과 중 읽을 시작위치와 개수
		RowBounds rb = new RowBounds(StartRecord, CountPerPage);
		try {
			newslist = mapper.selectNewsAll(searchMap, rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("공지사항 전체 출력 종료 다오");
		return newslist;
	}
	
	// 공지사항 글 전체보기 선생용
	public ArrayList<News> selectNewsTheacher(HashMap<String, Object> searchMap, int StartRecord, int CountPerPage){
		logger.info("공지사항 전체 출력 시작 다오");
		ArrayList<News> newslist = null;
		NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
		//전체 검색 결과 중 읽을 시작위치와 개수
		RowBounds rb = new RowBounds(StartRecord, CountPerPage);
		try {
			newslist = mapper.selectNewsTheacher(searchMap, rb);
			System.out.println("출력 되고 있서요!"+newslist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("공지사항 전체 출력 종료 다오");
		return newslist;
	}
	
	// 공지사항 글 하나 보기 다오다오
	public News selectNewsOne(int newsNum){
		logger.info("글 보기 시작 다오");
		NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
		News board = null;
		try {
			board = mapper.selectNewsOne(newsNum);
			mapper.updateHits(newsNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("글 보기 다오 종료");
		return board;
	}
	
	
	}
