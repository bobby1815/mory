package com.kh.mory.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Admin_CommunityController implements Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/admin/Admin_Comunity.jsp");
		return modelAndView;
	}

}
