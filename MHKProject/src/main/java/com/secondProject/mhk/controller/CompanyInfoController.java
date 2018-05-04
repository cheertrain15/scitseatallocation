package com.secondProject.mhk.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

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
import com.secondProject.mhk.dao.CompanyReplyDAO;
import com.secondProject.mhk.vo.Company;
import com.secondProject.mhk.vo.CompanyReply;

@Controller
@RequestMapping("company")
public class CompanyInfoController {
	
	@Autowired
	CompanyDAO cdao;
	
	@Autowired
	CompanyReplyDAO crdao;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyInfoController.class);
	
	@RequestMapping(value="companyInfo",method=RequestMethod.GET)
	public String companyInfo(Model model, int companyNum
			, @RequestParam (value="page", defaultValue="1") int page){
		logger.info("** companyInfo : start**");
		int allReplies = crdao.getReplies(companyNum);
		PageNavigator navi = new PageNavigator(5,5,page,allReplies);
		Company selectedCompany = cdao.selectOneCompanyByNum(companyNum);
		ArrayList<CompanyReply> replyList = crdao.getAllReplies(companyNum, navi.getStartRecord(), navi.getCountPerPage());
		double avgScore = crdao.getAvgScore(companyNum);
		String grade = crdao.getGrade(companyNum);
		model.addAttribute("selectedCompany", selectedCompany);
		model.addAttribute("replyList", replyList);
		model.addAttribute("avgScore", avgScore);
		model.addAttribute("grade", grade);
		model.addAttribute("navi", navi);
		logger.info("** companyInfo : terminate**");
		return "company/companyInfo";
	}
	
	@RequestMapping(value="companyDelete",method=RequestMethod.GET)
	public String companyDelete(int companyNum, HttpSession session){
		logger.info("** companyDelete : start**");
		String loginId = (String)session.getAttribute("loginId");
		if(!loginId.equals("admin")){
			return "redirect:companyInfo?companyNum="+companyNum;
		}
		CompanyReply delete = new CompanyReply();
		delete.setCompanyNum(companyNum);
		delete.setWriter(loginId);
		cdao.companyDelete(delete);
		logger.info("** companyDelete : terminate**");
		return "redirect:brief";
	}
	
}









