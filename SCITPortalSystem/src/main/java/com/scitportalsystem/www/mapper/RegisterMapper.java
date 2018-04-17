package com.scitportalsystem.www.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import com.scitportalsystem.www.vo.Registration;
import com.scitportalsystem.www.vo.RegistrationResult;

public interface RegisterMapper {
	// 지각 및 결석 등록
	public int insertRegist(Registration registration);
	// 로그인 유저 정보 가져오기
	public String userInfo(String id);
	// 지각 및 결석 목록(선생님용)
	public ArrayList<RegistrationResult> listRegistAll(HashMap<String, Object> searchMap, RowBounds rb);
	// 지각 및 결석 목록(학생용)
	public ArrayList<RegistrationResult> listRegistOne(String id);
	//검색 후의 총 글 개수
	public int getTotal(HashMap<String, Object> searchMap);
	// 지각 및 결석 목록 삭제 
	public int deleteRegist(String registrationNum);
	
	
	
} 
