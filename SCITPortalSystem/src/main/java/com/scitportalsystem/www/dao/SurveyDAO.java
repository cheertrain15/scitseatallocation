package com.scitportalsystem.www.dao;


import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scitportalsystem.www.mapper.SurveyMapper;
import com.scitportalsystem.www.vo.Survey;

@Repository
public class SurveyDAO {
	
	@Inject
	SqlSession sqlSession;
	 
	private static final Logger logger = LoggerFactory.getLogger(SurveyDAO.class);

	public int countSelectAll(int teacherNum) {
		int result = 0;

		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.countSelectAll(teacherNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<Survey> selectAll(int teacherNum, int lIMIT, int page) {
		RowBounds rb = new RowBounds((page - 1) * lIMIT, lIMIT);
		
		ArrayList<Survey> result = null;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.selectAll(teacherNum, rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	}