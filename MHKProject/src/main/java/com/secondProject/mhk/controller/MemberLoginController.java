package com.secondProject.mhk.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.secondProject.mhk.dao.MemberDAO;
import com.secondProject.mhk.vo.Member;

@Controller
@RequestMapping(value="member")
public class MemberLoginController {
	
	@Autowired
	MemberDAO mdao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberLoginController.class);
	
	/*
	 * Login Method
	 */
	@ResponseBody
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@RequestBody Member member, HttpSession session){
		logger.info("**login : start**");
		Member loginMember = mdao.selectOneMemberIdPw(member);
		if(loginMember == null){
			return "false";
		}
		session.setAttribute("loginId", loginMember.getMemberId());
		session.setAttribute("loginName", loginMember.getMemberName());
		session.setAttribute("loginMemberNum", loginMember.getMemberNum());
		logger.info("**login : terminate**");
			return "true";
	}
	
	/*
	 * Logout Method
	 */
	@ResponseBody
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public void logout(HttpSession session){
		logger.info("**logout : start**");
		session.invalidate();
		logger.info("**logout : terminate**");
	}
	
	/*
	 * after loging in from login.jsp
	 */
	@RequestMapping(value="irregularLogin", method=RequestMethod.POST)
	public String irregularLogin(Member member, HttpSession session){
		logger.info("**irregularLogin : start**");
		Member loginMember = mdao.selectOneMemberIdPw(member);
		session.setAttribute("loginId", loginMember.getMemberId());
		session.setAttribute("loginName", loginMember.getMemberName());
		logger.info("**irregularLogin : terminate**");
		return "redirect:/";
	}
	
}














