package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.IDiaryDAO;

public class Diary_UpdateController implements Controller 
{
	private IDiaryDAO dao;
	
	public void setDao(IDiaryDAO dao)
	{
		this.dao = dao;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView maAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		String diary_post_title  = request.getParameter("diary_post_title");
		String write_reg_dtm = request.getParameter("write_reg_dtm");
		String write_cont = request.getParameter("write_cont");
		String write_seq = request.getParameter("write_seq");
		
		DiaryDTO dto = dao.mydiary(write_cont);
		String diary_seq = dto.getDiary_seq();
		
		write_cont.replaceAll("\n", "<br>");		
		
		try
		{
			DiaryDTO diary = new DiaryDTO();
			
			diary.setDiary_post_title(diary_post_title);
			diary.setWrite_reg_dtm(write_reg_dtm);
			diary.setWrite_cont(write_cont);
			diary.setDiary_requ_seq(diary_seq);
			diary.setWrite_seq(write_seq);
			System.out.println(write_seq);
			dao.modyfi(diary);
			maAndView.setViewName("redirect:diary.do");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return maAndView;
	}

}
