package com.kh.mory.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Signup_JoinCheckController implements Controller
{
	private Signup_IUserDAO userDao;
	
	public void setUserDao(Signup_IUserDAO userDao)
	{
		this.userDao = userDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("----------------------------------");
		System.out.println("JoinCheckController");
		System.out.println(request.getRequestURI());
		System.out.println("----------------------------------");
		
		if (request.getRequestURI().indexOf("idniccheck.do") > -1)
		{
			// 데이터 수신
			String user_id = request.getParameter("user_id");
			String user_nic = request.getParameter("user_nic");
			
			int idcnk = userDao.userIdCheck(user_id);
			int niccnk = userDao.userNicknameCheck(user_nic);
			
			modelAndView.addObject("idcnk", idcnk);
			modelAndView.addObject("niccnk", niccnk);
			modelAndView.setViewName("WEB-INF/join/Signup_JoinCheck.jsp");
		}
		
		return modelAndView;
	}

}
