package com.kh.mory.SetupController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Setup_Famliy_Management_Controller implements Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("가족확인");
		modelAndView.setViewName("WEB-INF/Source/Setup_Family_Managament.jsp");
		return modelAndView;
	}

}
