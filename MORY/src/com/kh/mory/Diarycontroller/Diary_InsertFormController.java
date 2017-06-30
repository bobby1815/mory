package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class Diary_InsertFormController implements Controller 
{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView maAndView = new ModelAndView();
		
		maAndView.setViewName("DiaryInsertForm.jsp");
		
		return maAndView;
	}

}
