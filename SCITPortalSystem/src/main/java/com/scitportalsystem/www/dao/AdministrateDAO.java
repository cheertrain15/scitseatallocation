package com.scitportalsystem.www.dao;


import java.util.ArrayList;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scitportalsystem.www.mapper.AdministrateMapper;
import com.scitportalsystem.www.vo.MemberBasic;

@Repository
public class AdministrateDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(AdministrateDAO.class);
	
	
	public ArrayList<MemberBasic> selectmemberlist() {
		logger.info("회원가입 목록 출력 시작");
		
		AdministrateMapper mapper = sqlSession.getMapper(AdministrateMapper.class);
		ArrayList<MemberBasic> result = null;
		
		try {
			result = mapper.selectmemberlist();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원가입 목록 출력 종료");
		return result;
	}
	
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
