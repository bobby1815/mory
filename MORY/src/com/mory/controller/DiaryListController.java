package com.mory.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mory.diary.DiaryDTO;
import com.mory.idao.IDiaryDAO;

public class DiaryListController implements Controller 
{
	private IDiaryDAO dao;
	
	public void setDao(IDiaryDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		String requ_seq = (String) request.getAttribute("requ_seq");
		
		try
		{
			ArrayList<DiaryDTO> diaryList = new ArrayList<DiaryDTO>();
			diaryList = dao.list(requ_seq);
			modelAndView.addObject("diaryList",diaryList);			
			modelAndView.setViewName("WEB-INF/diary/Diary.jsp");
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		
		
		
		
		return modelAndView;
	}

}
