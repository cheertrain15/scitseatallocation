package com.scitportalsystem.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import com.scitportalsystem.www.vo.Survey;

public interface SurveyMapper {

	int countSelectAll(int teacherNum);

	ArrayList<Survey> selectAll(int teacherNum, RowBounds rb);
	
}