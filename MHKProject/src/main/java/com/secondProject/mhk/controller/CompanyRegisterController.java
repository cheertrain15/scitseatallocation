package com.secondProject.mhk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.secondProject.mhk.dao.CompanyDAO;
import com.secondProject.mhk.vo.Company;

@Controller
@RequestMapping("company")
public class CompanyRegisterController {
	
	@Autowired
	CompanyDAO cdao;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyRegisterController.class);
	
	
	@ResponseBody
	@RequestMapping(value="nameDuplication", method=RequestMethod.POST)
	public String nameDuplication(@RequestBody String companyName){
		logger.info("**nameDuplication : start**");
		Company duplication = cdao.selectOneCompanyByName(companyName);
		String result = "" ;
		if(duplication == null){
			result = "true";
		} else {
			result = "false";
		}
		logger.info("**nameDuplication : terminate**");
		return result;
	}
	
	@RequestMapping(value="addCompanyProcess", method=RequestMethod.POST)
	public String addCompanyProcess(@ModelAttribute Company company){
		logger.info("**addCompanyProcess : start**");
			cdao.addCompany(company);
		logger.info("**addCompanyProcess : terminate**");
		return "redirect:brief";
	}
	
}
	













