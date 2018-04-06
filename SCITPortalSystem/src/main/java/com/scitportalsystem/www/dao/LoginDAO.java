package com.scitportalsystem.www.dao;


import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scitportalsystem.www.dao.LoginDAO;
import com.scitportalsystem.www.mapper.LoginMapper;
import com.scitportalsystem.www.vo.MemberBasic;

@Repository
public class LoginDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginDAO.class);
	
	
	// 회원가입
	public boolean joinMember(MemberBasic member){
		logger.info("회원가입 DAO 시작");
		
		LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
		boolean result = false;
		int joinCount = 0;
		
		
		try {
			joinCount = mapper.joinMember(member);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(joinCount == 1) {
			result = true;
		} else {
			result = false;
		}
		
		logger.info("회원가입 DAO 종료");
		
		return result;
		
	}
	
	// 회원 1명 가져오기
	public MemberBasic searchOneMember(String id){
		logger.info("ID 확인 DAO 시작");
		
		LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
		MemberBasic result = null;
		
		try {
			result = mapper.searchOneMember(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("ID 확인DAO 종료");
		return result;
		
	}
	
	// 회원 개인정보 수정
	public int updateMember(MemberBasic member){
		logger.info("회원정보 수정 DAO 시작");
		
		LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
		int result = 0;
		
		try {
			result = mapper.updateMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원정보 수정 DAO 종료");
		
		return result;
	}
	
	// 이메일 인증
	public int approvalUser(String id){
		logger.info("E-mail DAO start");
		
		LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
		
		
		int result = 0;
		
		try {
			result = mapper.approvalUser(id);			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("E-mail DAO 종료");
		
		return result;		
	
	}	
	
}
