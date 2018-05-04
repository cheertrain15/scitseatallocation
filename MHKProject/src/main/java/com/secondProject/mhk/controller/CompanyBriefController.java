package com.secondProject.mhk.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.secondProject.mhk.common.util.PageNavigator;
import com.secondProject.mhk.dao.CompanyDAO;
import com.secondProject.mhk.vo.Company;

@Controller
@RequestMapping("company")
public class CompanyBriefController {
	
	@Autowired
	CompanyDAO cdao;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyBriefController.class);
	
	@RequestMapping(value="brief",method=RequestMethod.GET)
	public String brief(Model model
			, @RequestParam (value="searchName", defaultValue="") String searchName
			, @RequestParam (value="page", defaultValue="1") int page
			){
		logger.info("** brief : start**");
		int companies = cdao.getNumberOfCompanies(searchName);
		PageNavigator navi = new PageNavigator (3,3,page,companies);
		ArrayList<Company> companyList = cdao.getAllCompany(navi.getStartRecord(), navi.getCountPerPage());
		if (!searchName.equals("")){
			companyList = cdao.getAllCompanyBySearch(searchName, navi.getStartRecord(), navi.getCountPerPage());
		}
		model.addAttribute("companyList", companyList);
		model.addAttribute("searchName", searchName);
		model.addAttribute("navi",navi);
		logger.info("** brief : terminate**");
		return "company/brief";
	}
	
	@RequestMapping(value="addCompany",method=RequestMethod.GET)
	public String addCompany(){
		logger.info("** addCompany : start**");
		logger.info("** addCompany : terminate**");
		return "company/addCompany";
	}
	

	
}
