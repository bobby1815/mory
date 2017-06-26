package com.kh.mory.SetupController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Setup_Main_Controller implements Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println(3);
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println(2);
		modelAndView.setViewName("WEB-INF/Source/Setup_Main.jsp");
		System.out.println(1);
		return modelAndView;
	}

}
