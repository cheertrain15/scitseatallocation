package com.secondProject.mhk.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.secondProject.mhk.vo.Member;

@Repository
public class MemberDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAO.class);
	
	/*
	 * Loading only one member by using id and password
	 */
	public Member selectOneMemberIdPw(Member member){
		logger.info("**selectOneMemberIdPw : start**");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		Member loginMember = null;
		try{
			loginMember = mapper.selectOneMemberIdPw(member);
		} catch (Exception e){
		}
		logger.info("**selectOneMemberIdPw : terminate**");
		return loginMember;
	}
	
	/*
	 * Loading only one member by using id and password
	 */
	public Member selectOneMemberId(String memberId){
		logger.info("**selectOneMemberId : start**");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		Member foundMember = null;
		try{
			foundMember = mapper.selectOneMemberId(memberId);
		} catch (Exception e){
		}
		logger.info("**selectOneMemberId : terminate**");
		return foundMember;
	}
	
	/*
	 * add new member in Member table
	 */
	public int addMember(Member member){
		logger.info("**addMember : start**");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int result = 0;
		try{
			result = mapper.addMember(member);
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("**addMember : terminate**");
		return result;
	}
	
	/*
	 * update a member's information.
	 */
	public int updateMember(Member member){
		logger.info("**updateMember : start**");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int result = 0;
		try{
			result = mapper.updateMember(member);
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("**updateMember : terminate**");
		return result;
	}
}
