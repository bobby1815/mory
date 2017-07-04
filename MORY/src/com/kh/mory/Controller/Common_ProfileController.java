package com.kh.mory.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.join.Signup_IUserDAO;

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
	
	// 
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("=========================================");
		System.out.println("Common_ProfileController");
		System.out.println("=========================================");
		
		if (request.getRequestURI().indexOf("commonprofilesearch.do") > -1)
		{
			// 로그인한 id 조회
			HttpSession session = request.getSession();
			String user_id = (String)session.getAttribute("user_id");
			
			modelAndView.addObject("userSearch", userDao.userList(user_id));
			modelAndView.setViewName("WEB-INF/Source/Common_Profile.jsp");
		}
		

		return modelAndView;
	}

}
