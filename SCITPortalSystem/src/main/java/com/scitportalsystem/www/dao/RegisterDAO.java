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
	
}
