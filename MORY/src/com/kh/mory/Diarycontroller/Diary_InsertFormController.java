package com.kh.mory.Diarycontroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.IDiaryDAO;


public class Diary_InsertFormController implements Controller 
{
	private IDiaryDAO dao;
		
	public void setDao(IDiaryDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// [眠啊 累诀] - 技记 贸府
		/*
		
		ArrayList<DiaryDTO> diaryList = new ArrayList<DiaryDTO>(); 
		
		try
		{
			diaryList = dao.list();
			
			modelAndView.addObject("diaryList", diaryList);
			
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		*/
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("WEB-INF/diary/DiaryInsertForm.jsp");
		
		return modelAndView;
	}

}
