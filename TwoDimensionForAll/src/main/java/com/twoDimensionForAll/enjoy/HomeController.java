package com.twoDimensionForAll.enjoy;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.twoDimensionForAll.enjoy.dao.MemberDAO;
import com.twoDimensionForAll.enjoy.dao.VideoDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private VideoDAO vdao;	
	
	private String loginedId;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "checkId", method = RequestMethod.POST)
	public String checkId(String id) {
		Member gotMember = dao.selectMember(id);
		if(gotMember == null) {
			dao.insertMember(id);
		}
		loginedId = gotMember.getId();
		System.out.println(loginedId);
		return "Welcome to 2DForAll.";
	}
	
	@ResponseBody
	@RequestMapping(value = "loadAllVideo", method = RequestMethod.GET)
	public String loadAllVideo() {
		ArrayList<Video> videoList = vdao.showAllVideo();
		Gson gson = new Gson();
		String result = gson.toJson(videoList); 
		return result;
	}

	
	@ResponseBody
	@RequestMapping(value = "searchVideo", method = RequestMethod.POST)
	public String searchVideo(String videoName) {
		ArrayList<Video> searchedVideoList = vdao.searchVideo(videoName);
		Gson gson = new Gson();
		String result = gson.toJson(searchedVideoList); 
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "addFavourite", method = RequestMethod.POST)
	public String addFavourite(String videoNum) {
		if(loginedId == null) {
			return "You are not a member";
		}
		int modifiedVideoNum = Integer.parseInt(videoNum);
		UserFavourite bookmark = new UserFavourite(loginedId, modifiedVideoNum);
		dao.addFavourite(bookmark);
		return "The video is added to your bookmark.";
	}
	
	@ResponseBody
	@RequestMapping(value = "getFavourite", method = RequestMethod.POST)
	public String getFavourite() {
		if(loginedId == null) {
			return "You are not a member";
		}
		ArrayList<Video> gotFavouriteList = dao.getFavourite(loginedId);
		Gson gson = new Gson();
		String result = gson.toJson(gotFavouriteList); 
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "deleteFavourite", method = RequestMethod.POST)
	public String deleteFavourite(String videoNum) {
		if(loginedId == null) {
			return "You are not a member";
		}
		int modifiedVideoNum = Integer.parseInt(videoNum);
		UserFavourite bookmark = new UserFavourite(loginedId, modifiedVideoNum);
		dao.deleteFavourite(bookmark);
		return "The video is deleted from your bookmark.";
	}

	@ResponseBody
	@RequestMapping(value = "addHistory", method = RequestMethod.POST)
	public String addHistory(String videoNum) {
		if(loginedId == null) {
			return "You are not a member";
		}
		int castedVideoNum = Integer.parseInt(videoNum);
		UserHistory userhistory = new UserHistory(loginedId, castedVideoNum);
		int result = dao.addHistory(userhistory);
		if(result == 0) {
			return "Error occured during adding history";
		}
		return "Enjoy";
	}
	
	@ResponseBody
	@RequestMapping(value = "getHistory", method = RequestMethod.POST)
	public String getHistory() {
		if(loginedId == null) {
			return "You are not a member";
		}
		ArrayList<Video> gotFavouriteList = dao.getHistory(loginedId);
		Gson gson = new Gson();
		String result = gson.toJson(gotFavouriteList); 
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "deleteHistory", method = RequestMethod.POST)
	public String deleteHistory(String videoNum) {
		if(loginedId == null) {
			return "You are not a member";
		}
		int modifiedVideoNum = Integer.parseInt(videoNum);
		UserHistory history = new UserHistory(loginedId, modifiedVideoNum);
		dao.deleteHistory(history);
		return "The video is deleted from your history.";
	}
	
	@ResponseBody
	@RequestMapping(value = "sortByGenre", method = RequestMethod.POST)
	public String sortByGenre(String videoGenre) {
		if(loginedId == null) {
			return "You are not a member";
		}
		ArrayList<Video> sortedVideo = vdao.sortByGenre(videoGenre);
		Gson gson = new Gson();
		String result = gson.toJson(sortedVideo); 
		return result;
	}
}
