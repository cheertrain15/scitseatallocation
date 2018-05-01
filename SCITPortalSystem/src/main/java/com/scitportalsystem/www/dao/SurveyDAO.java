package com.scitportalsystem.www.dao;


import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scitportalsystem.www.mapper.SurveyMapper;
import com.scitportalsystem.www.vo.MemberBasic;
import com.scitportalsystem.www.vo.MemberStudent;
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

//	public int countSelectAlumni(int inChargeAlumni) {
//		int result=0;
//		
//		try {
//			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
//			result = mapper.countSelectAlumni(inChargeAlumni);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//	} 
    
	public int selectAlumni(int inChargeAlumni) {
		int result = 0;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.selectAlumni(inChargeAlumni);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int selectInChargeAlumni(int teacherNum) {
		int result=0;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.selectInChargeAlumni(teacherNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<String> selectClassRoom(int inChargeAlumni) {
		ArrayList<String> result = null;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.selectClassRoom(inChargeAlumni);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int insertSurvey(Survey survey) {
		
		int result = 0;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.insertSurvey(survey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	} 

	public int insertSurveyPage(Survey survey) {
		int result = 0;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.insertSurveyPage(survey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	public int insetSurveyQuestion(Survey survey) {
		int result = 0;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.insetSurveyQuestion(survey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	public int insertSurveyOption(Survey survey) {
		int result = 0;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.insertSurveyOption(survey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	public ArrayList<Survey> selectPages(int surveyNum) {
		ArrayList<Survey> result = null;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.selectPages(surveyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<Survey> selectQuestions(HashMap<String, Object> pageNum) {
		ArrayList<Survey> result = null;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.selectQuestions(pageNum);
		} catch (Exception e) {
			e.printStackTrace();
		}     
		
		return result;
	}

	public ArrayList<Survey> selectOptions(HashMap<String, Object> questionNum) {
		ArrayList<Survey> result = null;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.selectOptions(questionNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public String getMemberClass(int memberNum) {
		String result = null;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.getMemberClass(memberNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public Survey selectASurvey(int surveyNum) {
		Survey result = null;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.selectASurvey(surveyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		
		return result;
	}

	public MemberStudent getAlumniClassroom(String id) {
		MemberStudent result = null;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.getAlumniClassroom(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int countSelectAll2(MemberStudent param) {
		int result = 0;

		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.countSelectAll2(param);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<Survey> selectAll2(MemberStudent param, int lIMIT, int page) {
		RowBounds rb = new RowBounds((page - 1) * lIMIT, lIMIT);
		
		ArrayList<Survey> result = null;
		
		try {
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.selectAll2(param, rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int insertSurveyRespond(Survey survey) {
		int result = 0;
		
		try { 
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.insertSurveyRespond(survey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	public void updateSurvey(Survey survey) {
		
		try { 
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			mapper.updateSurvey(survey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteOldSurvey(int surveyNum) {
		
		try { 
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			mapper.deleteOldSurvey(surveyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public int countTargetStudent(Survey target) {
		int result = 0;
		
		try { 
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.countTargetStudent(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int countRespondStudent(int surveyNum) {
		int result = 0;
		
		try { 
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.countRespondStudent(surveyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int checkRespond(Survey target) {
		int result = 0;
		
		try { 
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.checkRespond(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

//	public ArrayList<MemberStudent> getTargetStudents(Survey survey) {
//		
//		ArrayList<MemberStudent> result = null;
//		
//		try { 
//			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
//			result = mapper.getTargetStudents(survey);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//	}

	public ArrayList<Survey> getRespondContentList(int surveyNum) {
		ArrayList<Survey> result = null;
		
		try { 
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.getRespondContentList(surveyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<Survey> getQuestionContents(int surveyNum) {
		ArrayList<Survey> result = null;
		
		try { 
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.getQuestionContents(surveyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<Survey> getRespondTargetStudents(int surveyNum) {
		ArrayList<Survey> result = null;
		
		try { 
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			result = mapper.getRespondTargetStudents(surveyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public void deleteSurvey(int surveyNum) {
		try { 
			SurveyMapper mapper = sqlSession.getMapper(SurveyMapper.class);
			mapper.deleteSurvey(surveyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
	