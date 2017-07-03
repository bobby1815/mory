package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		request.setCharacterEncoding("UTF-8");
		
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		
		
		String requ_seq = request.getParameter("requ_seq");
		DiaryDTO diary = null;
		DiaryDTO couplediary = null;
		String diary_seq = null;
		

		String user_id = (String) session.getAttribute("user_id");
		if (requ_seq == null)
		{	
			diary =  dao.mydiary(user_id);
			 diary_seq = diary.getDiary_seq();
			 System.out.println("singleform");
		}else if (diary_seq == null) {
			System.out.println("coupleform");
			couplediary = dao.couplediary(requ_seq);
		}
		
		
		modelAndView.addObject("diary",diary);
		modelAndView.addObject("couplediary",couplediary);
		modelAndView.addObject("requ_seq",requ_seq);
		
		modelAndView.setViewName("WEB-INF/diary/DiaryInsertForm.jsp");
		
		return modelAndView;
	}

}
