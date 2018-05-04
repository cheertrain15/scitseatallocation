package com.secondProject.mhk.dao;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.secondProject.mhk.vo.CompanyReply;

@Repository
public class CompanyReplyDAO {

		@Inject
		SqlSession sqlSession;
		
		private static final Logger logger = LoggerFactory.getLogger(CompanyReplyDAO.class);
		
		public ArrayList<CompanyReply> getAllReplies(int companyNum, int startRecord, int countPerPage){
			logger.info("**getAllReplies : start**");
			CompanyReplyMapper mapper = sqlSession.getMapper(CompanyReplyMapper.class);
			ArrayList<CompanyReply> replyList = null;
			RowBounds rb = new RowBounds(startRecord, countPerPage);
			try{
				replyList = mapper.getAllReplies(companyNum, rb);
			} catch (Exception e){
			}
			logger.info("**getAllReplies : terminate**");
			return replyList;
		}
		
		public int addCompanyReply(CompanyReply companyReply){
			logger.info("**addCompanyReply : start**");
			CompanyReplyMapper mapper = sqlSession.getMapper(CompanyReplyMapper.class);
			int result = 0;
			try{
				result = mapper.addCompanyReply(companyReply);
			} catch (Exception e){
			}
			logger.info("**addCompanyReply : terminate**");
			return result;
		}
		
		public int deleteCompanyReply(CompanyReply companyReply){
			logger.info("**deleteCompanyReply : start**");
			CompanyReplyMapper mapper = sqlSession.getMapper(CompanyReplyMapper.class);
			int result = 0;
			try{
				result = mapper.deleteCompanyReply(companyReply);
			} catch (Exception e){
			}
			logger.info("**deleteCompanyReply : terminate**");
			return result;
		}
		
		public double getAvgScore(int companyNum){
			logger.info("**getAvgScore : start**");
			CompanyReplyMapper mapper = sqlSession.getMapper(CompanyReplyMapper.class);
			double result = 0;
			try{
				result = mapper.getAvgScore(companyNum);
			} catch (Exception e){
			}
			logger.info("**getAvgScore : terminate**");
			return result;
		}
		
		public String getGrade(int companyNum){
			logger.info("**getGrade : start**");
			CompanyReplyMapper mapper = sqlSession.getMapper(CompanyReplyMapper.class);
			String result = "";
			try{
				result = mapper.getGrade(companyNum);
			} catch (Exception e){
			}
			logger.info("**getGrade : terminate**");
			return result;
		}
		
		public int getReplies(int companyNum){
			logger.info("**getReplies : start**");
			CompanyReplyMapper mapper = sqlSession.getMapper(CompanyReplyMapper.class);
			int result = 0;
			try{
				result = mapper.getReplies(companyNum);
			} catch (Exception e){
			}
			logger.info("**getReplies : terminate**");
			return result;
		}
		
}
