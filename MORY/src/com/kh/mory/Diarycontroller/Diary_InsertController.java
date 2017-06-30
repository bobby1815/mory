package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.IDiaryDAO;

public class Diary_InsertController implements Controller 
{
	private IDiaryDAO dao;
	
	public void setDao(IDiaryDAO dao)
	{
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setCharacterEncoding("UTF-8");
		
		ModelAndView mav = new ModelAndView();
		
		String diary_post_title  = request.getParameter("title");
		String write_reg_dtm = request.getParameter("dtm");
		String write_cont = request.getParameter("cont");
		try
		{
			DiaryDTO diary = new DiaryDTO();
			
			diary.setDiary_post_title(diary_post_title);
			diary.setWrite_reg_dtm(write_reg_dtm);
			diary.setWrite_cont(write_cont);
			
			dao.add(diary);
<<<<<<< HEAD
			
			mav.setViewName("redirect:diary.do");
=======
			mav.setViewName("redirect:WEB-INF/diary/Diary.jsp");
>>>>>>> branch 'master' of https://github.com/bobby1815/mory.git
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}

}
