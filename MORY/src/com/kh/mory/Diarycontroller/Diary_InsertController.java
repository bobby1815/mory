package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		String diary_post_title  = request.getParameter("diary_post_title");
		String write_reg_dtm = request.getParameter("write_reg_dtm");
		String write_cont = request.getParameter("write_cont");
		String requ_seq = request.getParameter("requ_seq");
		
		DiaryDTO dto = null;
		String diary_seq = null;
		
		if (requ_seq ==null|| requ_seq =="")
		{
			dto = dao.mydiary(user_id);
			diary_seq = dto.getDiary_seq();
		}
		else {
			dto = dao.couplediary(requ_seq);
		}

 
		
		try
		{
			DiaryDTO diary = new DiaryDTO();
			
			diary.setUser_id(user_id);
			diary.setWrite_reg_dtm(write_reg_dtm);
			diary.setWrite_cont(write_cont);
			diary.setDiary_post_title(diary_post_title);
			
			
			if (requ_seq ==null || requ_seq =="")
			{
				
				diary.setDiary_requ_seq(diary_seq);
				diary.setDiary_type_code("1");
				
				int a = dao.add(diary);
				mav.setViewName("redirect:diary.do");
			}
			else 
			{
				diary.setDiary_requ_seq(requ_seq);
				diary.setDiary_type_code("2");
				
				int b = dao.add(diary);
				
				mav.setViewName("redirect:diary.do?requ_seq="+requ_seq);
			}
			
			
			
			
			
			

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}

}
