package com.kh.mory.SetupController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Setup_Report_List_Controller implements Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("WEB-INF/Source/Setup_Report_List.jsp");
		return modelAndView;
	}

}
