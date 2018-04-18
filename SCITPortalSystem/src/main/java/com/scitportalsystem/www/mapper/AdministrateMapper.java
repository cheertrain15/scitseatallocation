package com.scitportalsystem.www.mapper;

import java.util.ArrayList;

import com.scitportalsystem.www.vo.MemberBasic;

public interface AdministrateMapper {
	
	// 회원가입 목록 출력
	public ArrayList<MemberBasic> selectmemberlist();
	
	// 회원가입 승인
	public int memberApproval(String id);

	
	
}
