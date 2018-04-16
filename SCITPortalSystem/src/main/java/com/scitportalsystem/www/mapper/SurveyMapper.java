 package com.scitportalsystem.www.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.scitportalsystem.www.vo.Survey;
 
public interface SurveyMapper {
   
	int countSelectAll(int teacherNum);
 
	ArrayList<Survey> selectAll(int teacherNum, RowBounds rb);
	
	int selectInChargeAlumni(int teacherNum);

//	int countSelectAlumni(int inChargeAlumni);

	int selectAlumni(int inChargeAlumni);
     
	ArrayList<String> selectClassRoom(int inChargeAlumni);

	int insertSurvey(Survey survey);

	int insertSurveyPage(Survey survey);

	int insetSurveyQuestion(Survey survey);

	int insertSurveyOption(Survey survey);

	ArrayList<Survey> selectPages(int surveyNum);

	ArrayList<Survey> selectQuestions(HashMap<String, Object> pageNum);

	ArrayList<Survey> selectOptions(HashMap<String, Object> questionNum);
	
}