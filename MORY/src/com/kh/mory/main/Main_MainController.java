package com.kh.mory.main;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.join.Signup_IUserDAO;
import com.kh.mory.join.Signup_UserDTO;

public class Main_MainController implements Controller
{
	Signup_IUserDAO userDao;
	
	public void setUserDao(Signup_IUserDAO userDao)
	{
		this.userDao = userDao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("----------------------------------");
		System.out.println("MainController");
		System.out.println(request.getRequestURI());
		System.out.println("----------------------------------");
		
		
		// 로그인
		if (request.getRequestURI().indexOf("loginmain.do") > -1)
		{
			String user_id = request.getParameter("user_id");
			String user_pw = request.getParameter("user_pw");
			
			
			
			Signup_UserDTO userDto = userDao.userLogin(user_id, user_pw);
			/*
			System.out.println(userDto.getGen_code());
			System.out.println(userDto.getGen_name());
			System.out.println(userDto.getPage_code());
			System.out.println(userDto.getPage_name());
			System.out.println(userDto.getOpen_code());
			System.out.println(userDto.getOpen_name());
			System.out.println(userDto.getAcc_state_code());
			System.out.println(userDto.getAcc_state_name());
			System.out.println(userDto.getAcc_grade_code());
			System.out.println(userDto.getUser_nic());
			System.out.println(userDto.getUser_name());
			System.out.println(userDto.getUser_tel());
			System.out.println(userDto.getUser_birth());
			System.out.println(userDto.getUser_email());
			System.out.println(userDto.getZipcode());
			System.out.println(userDto.getDetail_addr());
			System.out.println(userDto.getBasic_addr());
			System.out.println(userDto.getLoca_code());
			System.out.println(userDto.getLoca_name());
			System.out.println(userDto.getCity_code());
			System.out.println(userDto.getCity_name());
			System.out.println(userDto.getPwqu_code());
			System.out.println(userDto.getPwqu_answ());
			*/
			//System.out.println(userDto);
			
			
			
			if (userDto.getUser_id() != null)	// 로그인 성공
			{
				System.out.println("로그인 성공");
				HttpSession session = request.getSession();
		


				session.setAttribute("userDto", userDto);
				session.setAttribute("user_id", userDto.getUser_id());
				session.setAttribute("acc_grade_code", userDto.getAcc_grade_code());
				session.setAttribute("page_code", userDto.getPage_code());
                
			    // 세션 유지시간 1시간
			    session.setMaxInactiveInterval(60*60);
				modelAndView.addObject("userDto",userDto);
				modelAndView.setViewName("redirect:newsfeedlist.do");
				//modelAndView.setViewName("redirect:newsfeed.do");
			}
			else	// 로그인 실패 
			{
				System.out.println("로그인 실패");
				modelAndView.setViewName("redirect:main.do");
			}
			
			
			
		}
		// 메인화면 호출
		else if (request.getRequestURI().indexOf("main.do") > -1)
		{
			System.out.println("메인호출");
			modelAndView.setViewName("WEB-INF/main/Main.jsp");
		}
		
		return modelAndView;
	}

}
