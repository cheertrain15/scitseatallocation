package com.secondProject.mhk.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.secondProject.mhk.dao.CompanyReplyDAO;
import com.secondProject.mhk.vo.CompanyReply;


@Controller
@RequestMapping("company")
public class CompanyReplyController {

	@Autowired
	CompanyReplyDAO crdao;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyReplyController.class);
	
	@ResponseBody
	@RequestMapping(value="companyReplySave", method=RequestMethod.POST)
	public void companyReplySave(@RequestBody CompanyReply companyReply){
			logger.info("** companyReplySave : start **");
			crdao.addCompanyReply(companyReply);
			logger.info("** companyReplySave : terminate **");
	}
	
	@ResponseBody
	@RequestMapping(value="deleteCompanyReply", method=RequestMethod.POST)
	public void deleteCompanyReply(@RequestBody CompanyReply companyReply){
		logger.info("** deleteCompanyReply : start **");
		crdao.deleteCompanyReply(companyReply);
		logger.info("** deleteCompanyReply : terminate **");
}
}
