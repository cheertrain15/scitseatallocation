package com.scitportalsystem.www.mapper;

import com.scitportalsystem.www.vo.MemberBasic;

public interface LoginMapper {
	

	// 회원가입
	public int joinMember(MemberBasic member);
	
	// 회원 1명 출력
	public MemberBasic searchOneMember(String id);

	// 회원 수정
	public int updateMember(MemberBasic member);

	// 이메일 인증 처리
	public int approvalUser(String id);
	
	
	
}
