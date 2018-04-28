package com.scitportalsystem.www.dao;


import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scitportalsystem.www.mapper.RegisterMapper;
import com.scitportalsystem.www.vo.MemberStudent;
import com.scitportalsystem.www.vo.Registration;
import com.scitportalsystem.www.vo.RegistrationResult;

@Repository
public class RegisterDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterDAO.class);
	
	
	/**
	 * 지각 및 결석 등록
	 * @param registration 객체
	 * @return result 결과
	 */
	public int insertRegist(Registration registration){
		RegisterMapper mapper = sqlSession.getMapper(RegisterMapper.class);
		
		int result = 0;
		
		try {
			result = mapper.insertRegist(registration);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;	
	}
	
	/**
	 * 로그인 유저 정보 출력
	 * @param id 아이디
	 * @return 멤버 구분
	 */
	public String userInfo(String id){
		RegisterMapper mapper = sqlSession.getMapper(RegisterMapper.class);
		
		String memberClass = "";
		
		try {
			memberClass = mapper.userInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberClass;
	}
	
	/**
	 * 지각 및 결석 목록(선생님용)
	 * @param searchText 검색어
	 * @param startRecord 전체 결과중 읽을 시작 위치 (첫행은 0)
	 * @param countPerPage 읽을 레코드 수 (한페이지당 글 개수)
	 * @return 글목록
	 */
	public ArrayList<RegistrationResult> listRegistAll(HashMap<String, Object> searchMap, int startRecord, int countPerPage ){
		RegisterMapper mapper = sqlSession.getMapper(RegisterMapper.class);
		//전체 검색 결과 중 읽을 시작위치와 개수
		RowBounds rb = new RowBounds(startRecord, countPerPage);
		
		ArrayList<RegistrationResult> registration = null;
		
		try {
			registration = mapper.listRegistAll(searchMap, rb); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registration;
	}
	
	
	/**
	 * 지각 및 결석 목록(학생용)
	 * @param id  로그인한 학생의 아이디
	 * @return 지각 및 결석 목록
	 */
	public ArrayList<RegistrationResult> listRegistOne(String id){
		RegisterMapper mapper = sqlSession.getMapper(RegisterMapper.class);
		ArrayList<RegistrationResult> registration = null;
		
		try {
			registration = mapper.listRegistOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return registration;
	}

	
	/**
	 * 검색 결과 레코드 수
	 * @param searchText 검색어
	 * @return 글개수
	 */
	public int getTotal(HashMap<String, Object> searchMap) {
		RegisterMapper mapper = sqlSession.getMapper(RegisterMapper.class);
		int total = 0;
		try {
			total = mapper.getTotal(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	
	/**
	 * 삭제 
	 * @param registrationnum 등록번호
	 * @return 확인
	 */
	public int deleteRegist(String registrationNum){
		RegisterMapper mapper = sqlSession.getMapper(RegisterMapper.class);
		int result = 0;
		try {
			result = mapper.deleteRegist(registrationNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * @comment : 출결 처리 하기 위한 Registration 객체 출력
	 * @author 김다희
	 *
	 */
	public Registration selectOneAttendande(int registrationNum) {
		RegisterMapper mapper = sqlSession.getMapper(RegisterMapper.class);
		Registration result = null;
		
		try {
			result = mapper.selectOneAttendande(registrationNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;			
	}
	
	
	/**
	 * @comment : 출결 확인 처리용 
	 * @param id : 지각 및 결석 작성 ID
	 * @author 김다희
	 * @return
	 */
	public boolean attendanceCheck(int registrationNum) {
		logger.info("출결확인용 DAO 시작");
		RegisterMapper mapper = sqlSession.getMapper(RegisterMapper.class);
		boolean result = false;
		int attendanceCheck = 0;
		
		try {
			attendanceCheck = mapper.attendanceCheck(registrationNum);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		if(attendanceCheck == 1){
			logger.info("출결확인 DAO 성공");
			result = true;
		} else {
			logger.info("출결확인 DAO 실패");
			result = false;
			
		}
		
		logger.info("출결확인용 DAO 종료");
		return result;
	}
	

}
