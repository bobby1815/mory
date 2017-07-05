package com.kh.mory.Controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.join.Signup_IUserDAO;
import com.kh.mory.join.Signup_UserDTO;
import com.kh.mory.main.Main_IPwquestionDAO;
import com.kh.mory.main.Main_PwquestionDTO;
import com.kh.mory.newsfeed.Newsfeed_NewsfeedDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/*======================================================
	
	화면명 : Common_ProfileController.java
	화면 설명 : 공통 프로필 컨트롤러
	최초작성일 : 2017-07-03
	작성자 : 박아영

======================================================*/
public class Common_ProfileController implements Controller
{
	private Signup_IUserDAO userDao;
	
	public void setUserDao(Signup_IUserDAO userDao)
	{
		this.userDao = userDao;
	}
	
	private Main_IPwquestionDAO pwDao;
	
	public void setPwDao(Main_IPwquestionDAO pwDao)
	{
		this.pwDao = pwDao;
	}
	// 
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("=========================================");
		System.out.println("Common_ProfileController");
		System.out.println("=========================================");
		
		// 로그인한 id 조회
		HttpSession session = request.getSession();
		String user_id = null;
		
		if (request.getParameter("cust")== null)
		{
			user_id = (String)session.getAttribute("user_id");;
		}
		else
			user_id = request.getParameter("cust");
		
		// 프로필 조회
		if (request.getRequestURI().indexOf("commonprofilesearch.do") > -1)
		{
			modelAndView.addObject("userDTO", userDao.userList(user_id));
			
			// 토글에서 프로필 조회
			if (request.getParameter("type")== null)
			{
				modelAndView.setViewName("WEB-INF/Source/Common_Profile.jsp");
			}
			// 회원 정보 수정에서 user정보 조회
			else
			{
				ArrayList<Main_PwquestionDTO> pwquLists = pwDao.pwquLists();
				
				modelAndView.addObject("pwquLists", pwquLists);
				
				modelAndView.setViewName("WEB-INF/Source/Setup_Profile.jsp");
			}
		}
		// 프로필 수정
		else if (request.getRequestURI().indexOf("commonprofileset.do") > -1)
		{
			request.setCharacterEncoding("UTF-8");
			
			// 업로드 파일 경로
			//String path = "D:\\MORY\\mory_ay\\WebContent\\uploads";
			String root = request.getServletContext().getRealPath("/");
			String path = root + "profileupload";
			System.out.println(root+"/"+path);
			 System.out.println(path);
			
			// 폴더 경로가 존재하지않으면 생성
			File dir = new File(path);
			if(!dir.exists()) dir.mkdirs();
			
			String encType = "UTF-8";	//-- 인코딩 방식
			int maxFileSize = 5*1024*1024;	//-- 최대 사이즈
			
			MultipartRequest req = null;
			try
			{
				req = new MultipartRequest(request, path, maxFileSize, encType, new DefaultFileRenamePolicy());
				
				
				String user_pw = req.getParameter("user_pw");
				String user_nic = req.getParameter("user_nic");
				String user_name = req.getParameter("user_name");
				String user_birth = req.getParameter("user_birth");
				String gen_code = req.getParameter("gen_code");
				String user_email = req.getParameter("user_email");
				String user_tel = req.getParameter("user_tel");
				String zipcode = req.getParameter("zipcode");
				String basic_addr = req.getParameter("basic_addr");
				String detail_addr = req.getParameter("detail_addr");
				String pwqu_code = req.getParameter("pwqu_code");
				String pwqu_answ = req.getParameter("pwqu_answ");
				String siNm = req.getParameter("siNm");	// 시이름
				String sggNm = req.getParameter("sggNm");	// 시군구
				// 업로드한 파일명
				String profile_location = req.getFilesystemName("profile_pt");
				
				System.out.println(user_id);
				System.out.println(user_pw);
				System.out.println(user_nic);
				System.out.println(user_name);
				System.out.println(user_birth);
				System.out.println(gen_code);
				System.out.println(user_email);
				System.out.println(user_tel);
				System.out.println(zipcode);
				System.out.println(basic_addr);
				System.out.println(detail_addr);
				System.out.println(pwqu_code);
				System.out.println(pwqu_answ);
				System.out.println(siNm);
				System.out.println(sggNm);
				System.out.println("profile_location============= : "+profile_location);
				
				Signup_UserDTO dto = new Signup_UserDTO();
				
				dto.setUser_id(user_id);
				dto.setUser_pw(user_pw);
				dto.setUser_name(user_name);
				dto.setUser_nic(user_nic);
				dto.setUser_birth(user_birth);
				dto.setGen_code(gen_code);
				dto.setUser_email(user_email);
				dto.setUser_tel(user_tel);
				dto.setZipcode(zipcode);
				dto.setBasic_addr(basic_addr);
				dto.setDetail_addr(detail_addr);
				dto.setLoca_name(siNm);
				dto.setCity_name(sggNm);
				dto.setPwqu_code(pwqu_code);
				dto.setPwqu_answ(pwqu_answ);
				dto.setProfile_location(profile_location);
				
				int res = userDao.userModify(dto);

				modelAndView.setViewName("redirect:commonprofilesearch.do?type=modify");
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		

		return modelAndView;
	}

}
