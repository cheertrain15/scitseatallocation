package com.scitportalsystem.www.controller;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.scitportalsystem.www.dao.LoginDAO;
import com.scitportalsystem.www.dao.MyPageDAO;
import com.scitportalsystem.www.util.FileService;
import com.scitportalsystem.www.vo.MemberBasic;
import com.scitportalsystem.www.vo.MemberStaff;
import com.scitportalsystem.www.vo.MemberStudent;
import com.scitportalsystem.www.vo.MemberStudentCertificate;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="member")
@SessionAttributes("user")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Inject
	private LoginDAO dao;	
	
	@Inject
	private MyPageDAO Pdao;

	@Inject
	private JavaMailSender mailSender;

	/**
	 * @comment	: 회원가입 클릭 시 종류에 따라 회원가입 페이지로 이동 
	 * @param 	: model (오류로 인해 회원가입 실패했을 때 가입정보 다시 보여주기 위해)
	 * @author  : 김다희
	 */
	@RequestMapping(value="joinType",method=RequestMethod.GET)
	public String userForm(Model model) {
		logger.info("회원가입 폼 시작");
		
		MemberBasic memberBasic = new MemberBasic();
		
		model.addAttribute("user", memberBasic);
		
		logger.info("회원가입 폼 종료");
		
		return "member/joinType";
	}
	
	@RequestMapping(value="joinStaff",method=RequestMethod.GET)
	public String joinStaff(Model model){
		logger.info("staff 회원가입 폼 시작");
		
		MemberBasic memberBasic = new MemberBasic();
		
		model.addAttribute("user", memberBasic);
		
		logger.info("staff 회원가입 폼 종료");		
		
		
		return "member/joinStaff";
	}
	
	@RequestMapping(value="joinStudent",method=RequestMethod.GET)
	public String joinStudent(Model model){
		logger.info("student 회원가입 폼 시작");
		
		MemberBasic memberBasic = new MemberBasic();
		
		model.addAttribute("user", memberBasic);
		
		logger.info("student 회원가입 폼 종료");
		
		
		return "member/joinStudent";
	}

	@RequestMapping(value="joinTeacher",method=RequestMethod.GET)
	public String joinTeacher(Model model){
		logger.info("teacher 회원가입 폼 시작");
		
		MemberBasic memberBasic = new MemberBasic();
		
		model.addAttribute("user", memberBasic);
		
		logger.info("teacher 회원가입 폼 종료");
		return "member/joinTeacher";
	}
	
	
	/**
	 * @comment : 회원가입 시 ID 중복체크 페이지 이동 
	 * @param	: model
	 * @author  : 김다희
	 */
	@RequestMapping(value="idCheck",method=RequestMethod.GET)
	public String idCheck(Model model){
		logger.info("ID 중복 폼 이동 시작");
		
		model.addAttribute("search", false);		
		
		logger.info("ID 중복 폼 이동 종료");
		return "member/idCheckForm";
	}
	
	/**
	 * @comment : 회원가입 시 ID 중복체크 
	 * @param	: model, String (회원가입 시 작성한 ID)
	 * @author  : 김다희
	 */
	@RequestMapping(value="idSearch",method=RequestMethod.POST)
	public String idSearch(Model model, String searchId){
		
		logger.info("ID 찾기 폼 이동 시작");
		
		// id로 검색하여 정보 출력
		MemberBasic search = dao.searchOneMember(searchId);
		
		model.addAttribute("searchId", searchId);
		model.addAttribute("searchResult", search);
		model.addAttribute("search", true);	
		
		logger.info("ID 찾기 폼 이동 종료");
		
		return "member/idCheckForm";
	}
	
	/**
	 * @comment : 회원가입처리(인증을 위한 Email 발송 기능 / 프로필 사진을 위한 파일 업로드 기능 포함)
	 * @param memberBasic : view에서 받은 회원의 정보를 가진 객체 
	 * @param model
	 * @param upload
	 * @return
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException	 * 
	 * @author : 김다희
	 */
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(MemberBasic memberBasic, Model model, MultipartFile upload, 
			HttpServletRequest req, MemberStaff memberstaff, MemberStudentCertificate certificate,
			MemberStudent memberstudent) throws MessagingException, UnsupportedEncodingException{
		logger.info("회원가입 시작");		
		
		memberBasic.setDeleteBy(" ");
		/*memberBasic.setMemberClass("student");*/
		
		// 관리자 계정
		String admin = "project4u5cho@gmail.com";		
		
		String UPLOAD_PATH = req.getSession().getServletContext().getRealPath("/resources/img/profile");
		
		if(upload.isEmpty() == false){
			
			String savedfile = FileService.saveFile(upload, UPLOAD_PATH);
			
			memberBasic.setMemberPicName(upload.getOriginalFilename());
			memberBasic.setMemberSaverPicName(savedfile);
			
			
			
			logger.info("파일 업로드 완료");	
		}	
			
		boolean result = dao.joinMember(memberBasic);
		
		
		String id = memberBasic.getId();
		
		// 직원 추가 정보 생성 처리
		MemberStaff staff = new MemberStaff();		
		staff.setId(id);
		staff.setInChargeAlumni(" ");
		staff.setInChargeSubject(" ");
		
		logger.info("staff 추가 정보 시작 ");	
		int staffResult = Pdao.insertStaff(staff);		
		
		// 학생 자격증 정보 생성 처리
		MemberStudentCertificate insertCerti = new MemberStudentCertificate();		
		insertCerti.setId(id);
		insertCerti.setItCertificate(0);
		insertCerti.setJpCertificate(0);
		insertCerti.setOtherCertificate(" ");
		
		int insertCertificate = Pdao.insertStudentCertificate(insertCerti);
		
		// 학생 추가 학사 정보 생성 처리
		MemberStudent student = new MemberStudent();
		student.setId(id);
		student.setAlumni(0);
		student.setItMajor(0);
		student.setJpMajor(0);
		student.setClassroom(" ");
		student.setGroupNum(0);
		student.setSeat(0);
		student.setLate(0);
		student.setEarly(0);
		student.setAbsent(0);
		
		int insertStudent = Pdao.memberstudent(student);
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper 
								= new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom(admin);	// 보내는 사람
			messageHelper.setTo(memberBasic.getEmail());	// 받는 사람 이메일
			messageHelper.setSubject("[Email Check]");		// 메일제목(생략해도 OK)
			messageHelper.setText(					
					new StringBuffer()
					.append("Join Approval\n")
					.append("http://localhost:8888/www/member/email4u?id=")
					+ memberBasic.getId()
					.toString());
							
			mailSender.send(message);						
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result && staffResult == 1) {
			
			logger.info("회원가입 종료");				
			
		} else {
			
			model.addAttribute("errorMsg", "Join fail");
			return "member/joinForm";
		}
		

		
		return "redirect:joinComplete";	
		
	}
	
	/**
	 * @comment : 인증을 위한 Email을 발송했다는 안내 메세지 페이지로 이동
	 * @param session
	 * @param memberBasic
	 * @param model
	 * @author  : 김다희 
	 */
	@RequestMapping(value="joinComplete",method=RequestMethod.GET)
	public String joinComplete(SessionStatus session, @ModelAttribute("user") MemberBasic memberBasic, Model model){
		
		logger.info("회원 가입 성공 폼 이동 시작");
		model.addAttribute("id", memberBasic.getId());
		
		session.setComplete();
		
		logger.info("회원 가입 성공 폼 이동 종료");
		return "member/joinComplete";
	}
	
	/**
	 * @comment : 인증 받은 회원의 emailApproval 속성을 '1'로 변경한다.
	 * @param id : Email 인증을 받은 회원의 ID
	 * @author  : 김다희
	 */
	@RequestMapping(value="email4u", method=RequestMethod.GET)
	public String approval(@RequestParam String id) {
		
		logger.info("E-mail approval");
		
		int approvalCom = dao.approvalUser(id);
		
		if(approvalCom == 1) {
			
			logger.info("E-mail Success");
		}
		else {
			
			logger.info("E-mail Fail");
		}
		
		return "redirect:joinSuccess";
	}
	
	/**
	 * @comment : Email 인증이 완료되었다는 인내 메세지 페이지로 이동
	 * @author  : 김다희 
	 */
	@RequestMapping(value="joinSuccess", method=RequestMethod.GET)
	public String joinSuccess() {
		logger.info("JoinSuccess Page 이동");
		
		return "member/joinSuccess";
		
	}
	
	/**
	 * @comment : 로그인 페이지로 이동 
	 * @return
	 */
	@RequestMapping(value="loginForm",method=RequestMethod.GET)
	public String loginForm(){		
		
		return "member/loginForm";
	}
	
	
	/**
	 * @comment : 로그인 처리(Email 인증이 완료된 회원만 로그인 가능)
	 * @param model	: 로그인 실패 시 실패 메세지를 memberBasic에게 알리기 위한 메세지 저장
	 * @param memberBasic : View에서 입력받은 memberBasic의 ID와 PW를 저장하고 있는 객체 
	 * @param session	: 로그인 성공 시 memberBasic의 ID, Name, memberNum을 저장
	 * @author : 김다희 
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(Model model, MemberBasic memberBasic, HttpSession session, MemberStaff memberStaff) {
		
		// 검색할 ID
		
		
		MemberBasic login = dao.searchOneMember(memberBasic.getId());
		int memberEmail = login.getEmailApproval(); // email 인증 여부 
		
		MemberStaff staff = Pdao.selectStaff(memberBasic.getId());
		/*MemberBasic Admin = dao.searchOneMember("admin");*/
		
	
		// email 인증된 멤버만 로그인 가능 		
		if(login != null && memberEmail == 1) {
			if(login.getMemberClass().equals("student")) {	// 학생으로 로그인 했을 떄는 teacherNum 제외
				session.setAttribute("loginID", login.getId());
				session.setAttribute("loginName", login.getName());
				session.setAttribute("loginMemberNum", login.getMemberNum());
				session.setAttribute("loginMemberClass", login.getMemberClass());	
				
				logger.info("학생 login 성공 ");
			} else {				
				session.setAttribute("loginID", login.getId());
				session.setAttribute("loginName", login.getName());
				session.setAttribute("loginMemberNum", login.getMemberNum());
				session.setAttribute("loginMemberClass", login.getMemberClass());			
				session.setAttribute("teacherNum", staff.getTeacherNum());	// teacherNum
				session.setAttribute("loginedStaffInfo",staff.getInChargeAlumni());
				logger.info("staff / teacher login 성공 ");
				
			}			
			
			logger.info("login 성공 ");		
		} 		
		else if(login != null && memberEmail == 0) {
			logger.info("login 이메일 인증 실패 ");
			model.addAttribute("errorEmail", "Please Check Your Email!!");
			
			logger.info("login 실패 ");
			return "member/loginForm";
			
		} else if(!login.getPassword().equals(memberBasic.getPassword())){
			
			model.addAttribute("errorPW", "I'm Sorry! Please Check Your PW!!");
			logger.info("login 비밀번호 실패 ");
			return "member/loginForm";
			
		} else {
			model.addAttribute("errorID", "Please Check Your ID!!");
			
			logger.info("login 실패 ");			
		}
		
		
		return "redirect:/";
	}
	
	/**
	 * @comment : 로그아웃 처리 
	 * @param session : session에 저장된 값 지운다. 
	 * @author : 김다희 
	 */
	@RequestMapping(value="logoutForm",method=RequestMethod.GET)
	public String logoutForm(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	/**
	 * @comment : 프로필 사진을 업로드를 위한 파일 업로드 
	 * @param id
	 * @param response
	 * @author : 김다희 
	 */
	@RequestMapping(value="downLoad",method=RequestMethod.GET)
	public void downLoad(String id, HttpServletResponse response, HttpServletRequest req) {
		logger.info("다운로드(img) 시작");	
		
		MemberBasic memberOne = dao.searchOneMember(id);
		
		String profileName = memberOne.getMemberPicName();	
		
		
		String UPLOAD_PATH = req.getSession().getServletContext().getRealPath("/resources/img/profile");		
	
		
		try {			
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(profileName, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//파일이 저장된 전체 경로(profile에 저장된 파일명까지) 
		
		String fullPath = UPLOAD_PATH + "/" + memberOne.getMemberSaverPicName();
		//서버의 파일을 읽을 입력 스트림과 클라이언트에게 전달할 출력스트림
		FileInputStream fis = null; //내 pc에 있는 걸 읽어올 때 사용
		ServletOutputStream sos = null; //서블릿을 통해 출력할 때 사용 (다른 pc와 서블릿으로 연결되어 있기때문에)
		
		try {
			
			fis = new FileInputStream(fullPath);
			sos = response.getOutputStream();
			
			FileCopyUtils.copy(fis, sos);
			
			fis.close();
			sos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("다운 로드 종료");
	}

	
	
}
