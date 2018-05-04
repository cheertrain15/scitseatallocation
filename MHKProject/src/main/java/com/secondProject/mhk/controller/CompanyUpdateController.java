package com.secondProject.mhk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secondProject.mhk.dao.CompanyDAO;
import com.secondProject.mhk.vo.Company;

@Controller
@RequestMapping("company")
public class CompanyUpdateController {

	@Autowired
	CompanyDAO cdao;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyUpdateController.class);
	
	@RequestMapping(value="updateCompany", method=RequestMethod.GET)
	public String updateCompany(Model model, int companyNum){
		logger.info("** updateCompany : start**");
		Company selectedCompany = cdao.selectOneCompanyByNum(companyNum);
		model.addAttribute("selectedCompany", selectedCompany);
		logger.info("** updateCompany : terminate**");
		return "company/updateCompany";
	}
	
	@RequestMapping(value="updateCompanyProcess", method=RequestMethod.POST)
	public String updateCompanyProcess(Model model, Company company){
		cdao.updateCompany(company);
		return "redirect:companyInfo?companyNum="+company.getCompanyNum();
	}
}
