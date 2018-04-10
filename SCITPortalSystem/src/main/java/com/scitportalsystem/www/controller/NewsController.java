package com.scitportalsystem.www.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.scitportalsystem.www.dao.NewsDAO;
import com.scitportalsystem.www.util.FileService;
import com.scitportalsystem.www.vo.News;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="News")
public class NewsController {
	
	@Inject
	NewsDAO dao;
	
	final int countPerPage = 5;
	final int pagePerGroup = 5;	
	
	final String uploadPath = "/boardfile";
	
	private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
	
	// 공지 사항 글 목록 전체 담아오는 컨트롤러
	@RequestMapping(value="NewsMain", method=RequestMethod.GET)
	public String NewsMain(HttpSession session, Model model, News news,
			@RequestParam(value="targetAlumni", defaultValue="34") String searchSelectAlumni,
			@RequestParam(value="targetClass", defaultValue="A") String searchSelectClass){		
		logger.info("글 목록 이동 시작");
		
		// 기수와 반을 담는 해쉬 맵 입니다.
		HashMap<String, Object> searchMap = new HashMap<>();
		
		// 기수 담기
		searchMap.put("targetAlumni", searchSelectAlumni);
		
		// 반 담기
		searchMap.put("targetClass", searchSelectClass);
		
		// 잘 담앗는지 출력
		System.out.println(searchMap);
		
		String MemberClass = (String) session.getAttribute("loginMemberClass");
		System.out.println(MemberClass);
		
		// 글 전체를 불러오는 다오
		ArrayList<News> NewsList = dao.selectNewsAll(searchMap, news);
		System.out.println(NewsList);
		
		// 전체 글 담기
		model.addAttribute("NewsList", NewsList);
		
		// 전체 기수 담기
		model.addAttribute("targetAlumni", 33);
		System.out.println("나 기수가 출력 되고 있어!"+searchSelectAlumni);
		
		// 전체 반 담기
		model.addAttribute("targetClass", "B");
		System.out.println("나 기수가 출력 되고 있어!"+searchSelectClass);
		logger.info("글 목록 이동 종료");
		return"news/news";
	}
	
	// 공지사항 글 폼 이동 컨트롤러
	@RequestMapping(value="newsWrite", method=RequestMethod.GET)
	public String newsWrite(){
		logger.info("글쓰기 폼 이동 시작");
		
		logger.info("글쓰기 폼 이동 종료");
		return"news/newsWrite";
	}
	
	// 공지사항 글쓰기 컨트롤러
	@RequestMapping(value="insertNewsWrite", method=RequestMethod.POST)
	public String insertNewsWrite(News news, MultipartFile upload){
		logger.info("글쓰기 시작");
		
		// 임의로 아이디 담기
		news.setId("testid");
		// 임의로 반 담기
		news.setTargetAlumni(34);
		// 임의로 기수 담기
		news.setTargetClass("B");
		// 임의로 논리적 삭제  담기
		news.setDeleteBy(" ");
		
		/*String id = (String) session.getAttribute("loginId");
		news.setId(id);	*/
		if(news.getNewsHeader() == null){
			System.out.println("나 여기 왔어!");
			news.setNewsHeader(" ");
		}
		
		// 파일이 잇을 경우
		if (!upload.isEmpty()) {
			logger.info("파일이 있는 경우 컨트롤러");
			String savedfile = FileService.saveFile(upload, uploadPath); 
			logger.info(savedfile);
			news.setNewsSavedFileName(savedfile);
			news.setNewsFileName(upload.getOriginalFilename());
		}
		
		dao.writeNews(news);
		
		logger.info("글쓰기 종료");
		return"redirect:NewsMain";
	}
	
	// 글 한개씩 읽기 컨트롤러
	@RequestMapping(value="read", method=RequestMethod.GET)
	public String read(int newsNum, Model model){
		logger.info("해당 글 읽기 시작");
		News news = dao.selectNewsOne(newsNum);
		
		model.addAttribute("news", news);	
		
		logger.info("해당 글 읽기 종료");
		return"news/newRead";
	}
	
	// 파일 다운로드
	@RequestMapping(value="download", method=RequestMethod.GET)

	 // 리턴이 void인 이유 : 다운로드 누루면 어디로 가게 하지 않게 하기 위해서다.

	 public void download(int newsNum, HttpServletResponse response){

	  logger.info("다운로드 처리 시작");

	  News news = dao.selectNewsOne(newsNum);	  

	  //원래 파일 명을 response Header에 인코딩해서 등록

	  String originalFile = news.getNewsFileName();

	  try{

	   response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(originalFile,"UTF-8"));

	  } catch (UnsupportedEncodingException e) {

	   e.printStackTrace();

	  }
	  //아웃풋 스트림을 연결시켜줘야 한다.

	  String fullPath = uploadPath + "/" + news.getNewsSavedFileName();	  

	  //서버의 파일을 읽을 입력 스트림 FileInputStream

	  //클라이언트에게 전달할 풀력 스트림 ServletOutputStream

	  FileInputStream fis = null;

	  ServletOutputStream sos = null;	  

	  try {

	   fis = new FileInputStream(fullPath);

	   sos = response.getOutputStream();	   

	   FileCopyUtils.copy(fis,sos); //Java로 일일히 I/O처리를 코딩안하게 해주는 스프링의 기능	   

	   fis.close();

	   sos.close();	   

	  } catch (IOException e) {

	   e.printStackTrace();

	  }	  

	  logger.info("다운로드 처리 종료");


	 }
	
}


