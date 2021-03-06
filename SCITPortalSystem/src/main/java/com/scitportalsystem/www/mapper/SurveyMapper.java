 package com.scitportalsystem.www.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.scitportalsystem.www.vo.MemberBasic;
import com.scitportalsystem.www.vo.MemberStudent;
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

	String getMemberClass(int memberNum);

	Survey selectASurvey(int surveyNum);
 
	MemberStudent getAlumniClassroom(String id);

	int countSelectAll2(MemberStudent param);

	ArrayList<Survey> selectAll2(MemberStudent param, RowBounds rb);

	int insertSurveyRespond(Survey survey);

	void updateSurvey(Survey survey);

	void deleteOldSurvey(int surveyNum);

	int countTargetStudent(Survey target);

	int countRespondStudent(int surveyNum);

	int checkRespond(Survey target);
 
//	ArrayList<MemberStudent> getTargetStudents(Survey survey);

	ArrayList<Survey> getRespondContentList(int surveyNum);

	ArrayList<Survey> getQuestionContents(int surveyNum);

	ArrayList<Survey> getRespondTargetStudents(int surveyNum);

	void deleteSurvey(int surveyNum);
	
}