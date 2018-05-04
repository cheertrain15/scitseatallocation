package com.secondProject.mhk.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import com.secondProject.mhk.vo.CompanyReply;

public interface CompanyReplyMapper {

		public ArrayList<CompanyReply> getAllReplies(int companyNum, RowBounds rb);
		public int addCompanyReply(CompanyReply companyReply);
		public int deleteCompanyReply(CompanyReply companyReply);
		public double getAvgScore(int companyNum);
		public String getGrade(int companyNum);
		public int getReplies(int companyNum);
}
