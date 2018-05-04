package com.secondProject.mhk.dao;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.secondProject.mhk.vo.Company;
import com.secondProject.mhk.vo.CompanyReply;

@Repository
public class CompanyDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyDAO.class);
	
	/*
	 * Loading only one company using companyName
	 */
	public Company selectOneCompanyByName(String companyName){
		logger.info("**selectOneCompanyByName : start**");
		CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		Company foundCompany = null;
		try{
			foundCompany = mapper.selectOneCompanyByName(companyName);
		} catch (Exception e){
		}
		logger.info("**selectOneCompanyByName : terminate**");
		return foundCompany;
	}
	
	/*
	 * Loading only one company using companyNum
	 */
	public Company selectOneCompanyByNum(int companyNum){
		logger.info("**selectOneCompanyByNum : start**");
		CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		Company foundCompany = null;
		try{
			foundCompany = mapper.selectOneCompanyByNum(companyNum);
		} catch (Exception e){
				e.printStackTrace();
		}
		logger.info("**selectOneCompanyByNum : terminate**");
		return foundCompany;
	}
	
	
	/*
	 * add new Company
	 */
	public int addCompany(Company company){
		logger.info("**addCompany : start**");
		CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		int result = 0;
		try{
			result = mapper.addCompany(company);
		} catch (Exception e){
		}
		logger.info("**addCompany : terminate**");
		return result;
	}
	
	/*
	 * load all the companies
	 */
	public ArrayList<Company> getAllCompany(int startRecord, int countPerPage){
		logger.info("**getAllCompany : start**");
		CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		 ArrayList<Company> result = null;
		 RowBounds rb = new RowBounds(startRecord, countPerPage);
		try{
			result = mapper.getAllCompany(rb);
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("**getAllCompany : terminate**");
		return result;
	}
	
	public int updateCompany(Company company){
		logger.info("**updateCompany : start**");
		CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		int result = 0;
		try{
			result = mapper.updateCompany(company);
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("**updateCompany : terminate**");
		return result;
	}
	
	public int companyDelete(CompanyReply companyReply){
		logger.info("**companyDelete : start**");
		CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		int result = 0;
		try{
			result = mapper.companyDelete(companyReply);
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("**companyDelete : terminate**");
		return result;
	}
	
	public ArrayList<Company> getAllCompanyBySearch (String companyName
			, int startRecord
			, int countPerPage){
		logger.info("**getAllCompanyBySearch : start**");
		CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		ArrayList<Company> result = null;
		RowBounds rb = new RowBounds(startRecord, countPerPage);
		try{
			result = mapper.getAllCompanyBySearch(companyName, rb);
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("**getAllCompanyBySearch : terminate**");
		return result;
	}
	
	public int getNumberOfCompanies(String companyName){
		logger.info("**getNumberOfCompanies : start**");
		CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		int result = 0;
		try{
			result = mapper.getNumberOfCompanies(companyName);
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("**getNumberOfCompanies : terminate**");
		return result;
	}
}
