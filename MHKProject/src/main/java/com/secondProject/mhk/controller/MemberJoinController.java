package com.secondProject.mhk.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.secondProject.mhk.dao.MemberDAO;
import com.secondProject.mhk.vo.Member;

@Controller
@RequestMapping(value="member")
@SessionAttributes("newMember")
public class MemberJoinController {
	
	@Autowired
	MemberDAO mdao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberLoginController.class);
	/*
	 * Join : becoming a new member
	 */
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join(HttpSession session){
		logger.info("**join : start**");
		/*
		 * Block entering join.jsp while logged in.
		 */
		String loginId = (String)session.getAttribute("loginId");
		if(loginId != null){
			return "redirect:/";
		}
		logger.info("**join : terminate**");
		return "member/join";
	}
	
	/*
	 * Processing the information of the form from join.jsp
	 */
	@RequestMapping(value="joinProcess", method=RequestMethod.POST)
	public String joinProcess(Model model, Member member){
		logger.info("**joinProcess : start**");
		mdao.addMember(member);
		model.addAttribute("newMember",member);
		logger.info("**joinProcess : terminate**");
		return "member/joinComplete";
	}
	
	/*
	 * the page notifies user that the join process is done.
	 */
	@RequestMapping(value="joinFinish", method=RequestMethod.GET)
	public String joinFinish(@ModelAttribute("newMember") Member member
			, SessionStatus sessionS
			, HttpSession sessionH){
		logger.info("**joinFinish : start**");
		/*
		 * Block entering join.jsp while logged in.
		 */
		String loginId = (String)sessionH.getAttribute("loginId");
		if(loginId != null){
			return "redirect:/";
		}
		sessionS.setComplete();
		logger.info("**joinFinish : terminate**");
		return "redirect:/";
	}
	
	/*
	 * Id duplication check
	 */
	@ResponseBody
	@RequestMapping(value="idDuplication", method=RequestMethod.POST)
	public String idDuplication(@RequestBody String memberId){
		logger.info("**idDuplcation : start**");
		Member duplication = mdao.selectOneMemberId(memberId);
		String result = "" ;
		if(duplication == null){
			result = "true";
		} else {
			result = "false";
		}
		logger.info("**idDuplcation : terminate**");
		return result;
	}
}








