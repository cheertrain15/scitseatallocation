package com.secondProject.mhk.dao;

import com.secondProject.mhk.vo.Member;

public interface MemberMapper {
	public Member selectOneMemberIdPw(Member member);
	public Member selectOneMemberId(String memberId);
	public int updateMember(Member member);
	public int addMember(Member member);
}
