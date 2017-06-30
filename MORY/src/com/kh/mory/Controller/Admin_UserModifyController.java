package com.kh.mory.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Admin_UserModifyController implements Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		
		String val = request.getParameter("value");
		String id = request.getParameter("id");
		String href = request.getParameter("href");
		
		System.out.println(href);
		System.out.println(5);
		
		
		modelAndView.setViewName("WEB-INF/admin/Admin_DeclarationCommunityUserList.jsp");
		return modelAndView;
	}
	
	
	

}
