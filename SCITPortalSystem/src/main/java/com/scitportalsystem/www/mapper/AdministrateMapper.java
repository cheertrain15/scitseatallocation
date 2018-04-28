package com.scitportalsystem.www.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.scitportalsystem.www.vo.MemberBasic;

/**
 * @comment : admin 처리 mapper
 * @author 김다희
 *
 */
public interface AdministrateMapper {
	
	// 회원가입 목록 출력
	public ArrayList<MemberBasic> selectmemberlist(HashMap<String, Object> hsm, RowBounds rb);	
	
	// 회원가입 승인
	public int memberApproval(String id);

	// 전체 가입 회원 수 가져오기
	public int getTotal(HashMap<String, Object> hsm);

	
	
}
