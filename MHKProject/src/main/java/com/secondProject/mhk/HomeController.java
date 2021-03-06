package com.secondProject.mhk;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("**home : start**");
		return "home";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		if(loginId!=null){
			return "redirect:/";
		}
		return "login";
	}
	
	@RequestMapping(value = "error", method = RequestMethod.GET)
	public String error() {
		return "redirect:error";
	}
}
