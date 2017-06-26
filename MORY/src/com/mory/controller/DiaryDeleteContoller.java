package com.mory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mory.idao.IDiaryDAO;

public class DiaryDeleteContoller  implements Controller 
{
	private IDiaryDAO dao;
	
	public void setDao(IDiaryDAO dao)
	{
		this.dao = dao;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		String write_seq = request.getParameter("write_seq");
		try
		{
			dao.remove(write_seq);
			mav.setViewName("Diary.jsp?write_seq="+write_seq);
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}

}

