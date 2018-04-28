package com.scitportalsystem.www.dao;


import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scitportalsystem.www.mapper.AdministrateMapper;
import com.scitportalsystem.www.vo.MemberBasic;

/**
 * @commnet : admin 처리 DAO
 * @author 김다희
 *
 */
@Repository
public class AdministrateDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(AdministrateDAO.class);
	
	
	public ArrayList<MemberBasic> selectmemberlist(HashMap<String, Object> hsm, int startRecord, int countPerPage) {
		logger.info("회원가입 목록 출력 시작");
		
		AdministrateMapper mapper = sqlSession.getMapper(AdministrateMapper.class);
		ArrayList<MemberBasic> result = null;
		
		// 전체 검색 결과 중 읽을 시작위치와 개수		
		RowBounds rb = new RowBounds(startRecord, countPerPage);	// between A and B
		
		try {
			result = mapper.selectmemberlist(hsm, rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원가입 목록 출력 종료");
		return result;
	}
	
	
		// 전체 가입 회원 수 가져오기
		public int getTotal(HashMap<String, Object> hsm) {
			AdministrateMapper mapper = sqlSession.getMapper(AdministrateMapper.class);
			int result = 0;
			
			try {
				result = mapper.getTotal(hsm);
			} catch (Exception e) {
				e.printStackTrace();
			}		
			
			return result;
		}
		
	
	// 회원 관리자 승인
	public int memberApproval(String id) {
		logger.info("회원가입 승인 DAO 시작");
		AdministrateMapper mapper = sqlSession.getMapper(AdministrateMapper.class);
		int result = 0;
		
		try {
			result = mapper.memberApproval(id);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		logger.info("회원가입 승인 DAO 종료");
		return result;
	}
	
}
