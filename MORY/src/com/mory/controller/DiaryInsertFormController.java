package com.mory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class DiaryInsertFormController implements Controller 
{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView maAndView = new ModelAndView();
		
		maAndView.setViewName("DiaryInsertForm.jsp");
		
		return maAndView;
	}

}
