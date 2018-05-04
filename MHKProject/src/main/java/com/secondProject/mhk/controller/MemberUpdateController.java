package com.secondProject.mhk.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secondProject.mhk.dao.MemberDAO;
import com.secondProject.mhk.vo.Member;

@Controller
@RequestMapping(value="member")
public class MemberUpdateController {
	
	@Autowired
	MemberDAO mdao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberLoginController.class);
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(Model model, HttpSession session){
		logger.info("**update : start**");
		String loginId = (String)session.getAttribute("loginId");
		Member loginMember = mdao.selectOneMemberId(loginId);
		model.addAttribute("loginMember", loginMember);
		logger.info("**update : terminate**");
		return "member/update";
	}
	
	@RequestMapping(value="updateProcess", method=RequestMethod.POST)
	public String updateProcess(Member member, HttpSession session){
		logger.info("**updateProcess : start**");
		mdao.updateMember(member);
		session.setAttribute("loginName", member.getMemberName());
		logger.info("**updateProcess : terminate**");
		return "redirect:/";
	}
	
}






















