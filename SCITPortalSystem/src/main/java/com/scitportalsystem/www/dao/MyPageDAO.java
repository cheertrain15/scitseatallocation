package com.scitportalsystem.www.dao;


import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scitportalsystem.www.mapper.MyPageMapper;
import com.scitportalsystem.www.vo.MemberStaff;
import com.scitportalsystem.www.vo.MemberStudent;
import com.scitportalsystem.www.vo.MemberStudentCertificate;

@Repository
public class MyPageDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(MyPageDAO.class);
	
	
	
	// staff(teacher 포함) 정보 추가 입력
	public int insertStaff(MemberStaff staff){
		logger.info("staff 정보 추가 입력 DAO 시작");
		
		MyPageMapper mapper = sqlSession.getMapper(MyPageMapper.class);
		int result = 0;
		
		try {
			result = mapper.insertStaff(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("staff 정보 추가 입력 DAO 종료");
		return result;
	}
	
	// staff 정보 출력
	public MemberStaff selectStaff(String id){
		logger.info("staff 정보 출력 DAO 시작");
		
		MyPageMapper mapper = sqlSession.getMapper(MyPageMapper.class);
		MemberStaff result = null;
		
		
		try {
			result = mapper.selectStaff(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("staff 정보 출력 DAO 종료");
		return result;
		
	}
	
	// staff 정보 업데이트
	public int updateStaff(MemberStaff staff){
		logger.info("staff 정보 업데이트  DAO 시작");
		MyPageMapper mapper = sqlSession.getMapper(MyPageMapper.class);
		int result = 0;
		
		try {
			result = mapper.updateStaff(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		logger.info("staff 정보 업데이트  DAO 종료");
		return result;
	}
	
	// 학생 자격증 정보 입력
	public int insertStudentCertificate(MemberStudentCertificate certificate){
		logger.info("student 자격증 정보 입력  DAO 시작");
		MyPageMapper mapper = sqlSession.getMapper(MyPageMapper.class);
		int CertiResult = 0;
		
		
		try {
			CertiResult = mapper.insertStudentCertificate(certificate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("student 자격증 정보 입력  DAO 종료");
		return CertiResult;
	}
	
	// 학생 자격증 정보 출력
	public MemberStudentCertificate selectStudentCerti(String id){
		logger.info("student 자격증 정보 출력  DAO 시작");
		MyPageMapper mapper = sqlSession.getMapper(MyPageMapper.class);
		MemberStudentCertificate result = null;
		
		try {
			result = mapper.selectStudentCerti(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("student 자격증 정보 출력  DAO 종료");
		return result;
	}
	
	// 학생 자격증 정보 업데이트
	public int updateStudentCerti(MemberStudentCertificate certificate) {
		logger.info("student 자격증 정보 update DAO 시작");
		MyPageMapper mapper = sqlSession.getMapper(MyPageMapper.class);
		int result = 0;
		
		try {
			result = mapper.updateStudentCerti(certificate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("student 자격증 정보 update DAO 종료");
		return result;
	}
		
	// 학생 학사정보 입력
	public int memberstudent(MemberStudent student){
		logger.info("student 학사 정보 입력  DAO 시작");
		MyPageMapper mapper = sqlSession.getMapper(MyPageMapper.class);
		int result = 0;
		
		try {
			result = mapper.memberstudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		logger.info("student 학사 정보 입력  DAO 종료");
		return result;
	}
	
	// 학생 학사 정보 출력
	public MemberStudent selectStudentInfo(String id) {
		logger.info("student 학사 정보 출력  DAO 시작");
		MyPageMapper mapper = sqlSession.getMapper(MyPageMapper.class);
		MemberStudent result = null;
		
		try {
			result = mapper.selectStudentInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("student 학사 정보 출력  DAO 종료");
		return result;
		
	}	
	
	// 학생 학사 정보 업데이트 
	public int updateStudentInfo(MemberStudent student) {
		logger.info("student 학사 정보 업데이트  DAO 시작");
		MyPageMapper mapper = sqlSession.getMapper(MyPageMapper.class);
		int result = 0;
		
		try {
			result = mapper.updateStudentInfo(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("student 학사 정보 업데이트  DAO 종료");
		return result;
	}
	
}
