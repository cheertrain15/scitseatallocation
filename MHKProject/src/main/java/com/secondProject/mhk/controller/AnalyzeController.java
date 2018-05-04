package com.secondProject.mhk.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secondProject.mhk.dao.CompanyDAO;
import com.secondProject.mhk.dao.MemberDAO;
import com.secondProject.mhk.vo.Company;
import com.secondProject.mhk.vo.Member;

@Controller
@RequestMapping("company")
public class AnalyzeController {

	@Autowired
	CompanyDAO cdao;
	
	@Autowired
	MemberDAO mdao;
	
	private static final Logger logger = LoggerFactory.getLogger(AnalyzeController.class);
	
	@RequestMapping(value="analyze", method=RequestMethod.GET)
	public String analyze(int companyNum, Model model, HttpSession session){
		logger.info("** analyze : start**");
		String loginId = (String)session.getAttribute("loginId");
		Member currentUser = mdao.selectOneMemberId(loginId);
		Company currentCompany = cdao.selectOneCompanyByNum(companyNum);
		HashMap<String, String> result = analyze(currentUser, currentCompany);
		model.addAttribute("User",currentUser);
		model.addAttribute("Company",currentCompany);
		model.addAttribute("Result", result);
		logger.info("** analyze : terminate**");
		return "company/analyzePage";
	}
	
	private HashMap<String, String> analyze(Member member, Company company){
		HashMap<String, String> result = new HashMap<>();
		int score = 0;
		if(member.getMemberDesireField().equals(company.getCompanyField())){
			String first = company.getCompanyName()+"'s specialty is the same specialty as yours, "
					+company.getCompanyField();
			result.put("first", first);
			score += 1;
		} else {
			String first = "Your specialty and the company's specialty is not same.";
			result.put("first", first);
		}
		
		if(member.getMemberDesirePayment() <= company.getCompanyPayment()){
			if(score == 0) {
				String second = "However, this company does meet your desired payment.";
				result.put("second", second);
			} else  if(score == 1) {
				String second = "This company does meet your desired payment.";
				result.put("second", second);
				score += 1;
		} else {
			if(score == 0) {
				String second = "This company does not meet your desired payment.";
				result.put("second", second);
				} 
			else if(score == 1) {
				String second = "However, this company does not meet your desired payment.";
				result.put("second", second);
			}
		}
		
		if(member.getMemberDesiredWorkingTime() >= company.getCompanyWorkingTime()){
				String third = "Fortunately, you may have to work shorter than you expected.";
				result.put("third", third);
				score += 1;
			} else { 
				if(score <= 2) {
					String third = "Unfortunately, you may have to longer than you expected.";
					result.put("third", third);
				}
			}
		}
		
		String fourth = "";
		String fourthSub = "";
		if(score <= 1){
			fourth = company.getCompanyName()+" may not be the company of your type.";
			fourthSub = "Instead, search for other companies."; 
		} else if (score == 2){
			fourth = company.getCompanyName()+" could the company you are looking for."; 
			fourthSub = "Read some comments of the former workers' experience.";
		} else if (score == 3){
			fourth = company.getCompanyName()+" meets many of your expectations."; 
			fourthSub = "This rarely happens. Apply as soon as possible.";
		}
			String fifth = "Having unconditional faith in the result is not recommended.";
			String sixth = "This is just a brief analysis.";
			String seventh = "More research about "+company.getCompanyName()+" is recommended.";
			result.put("fourth", fourth);
			result.put("fourthSub", fourthSub);
			result.put("fifth", fifth);
			result.put("sixth", sixth);
			result.put("seventh", seventh);
		return result;
	}
	
}







