package com.secondProject.mhk.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import com.secondProject.mhk.vo.Company;
import com.secondProject.mhk.vo.CompanyReply;

public interface CompanyMapper {
	public Company selectOneCompanyByName(String companyName);
	public Company selectOneCompanyByNum(int companyNum);
	public int updateCompany(Company company);
	public int addCompany(Company company);
	public ArrayList<Company> getAllCompany(RowBounds rb);
	public int companyDelete(CompanyReply companyReply);
	public ArrayList<Company> getAllCompanyBySearch (String companyName, RowBounds rb);
	public int getNumberOfCompanies(String companyName);
}
