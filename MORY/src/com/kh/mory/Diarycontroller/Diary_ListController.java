package com.kh.mory.Diarycontroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.IDiaryDAO;

public class Diary_ListController implements Controller 
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
		
		HttpSession session = request.getSession();
		
		String user_id = (String) session.getAttribute("user_id");
		
		DiaryDTO dto = null;
		DiaryDTO couplediary = null;
		String diary_seq = null;
		
		String requ_seq = request.getParameter("requ_seq");
		
		System.out.println(user_id);
		System.out.println(requ_seq);
		
		try
		{
			ArrayList<DiaryDTO> diaryList = new ArrayList<DiaryDTO>();
			
			if (requ_seq == null)
			{	
				dto =  dao.mydiary(user_id);
				diaryList = dao.list(dto.getDiary_seq());
				 diary_seq = dto.getDiary_seq();
			}else if (diary_seq == null) {
				diaryList = dao.couplelist(requ_seq);
				System.out.println("couple");
			}
			
			int matecheck = dao.matecheck(user_id);
			
			
			
			couplediary = dao.couplediary(requ_seq);
			System.out.println(couplediary.getShar_diary_name());
			
			

			
			ArrayList<DiaryDTO> memberdiarylist = dao.memberdiarylist(user_id);
			

			

			modelAndView.addObject("matecheck",matecheck);
			modelAndView.addObject("memberdiarylist",memberdiarylist);
			
			modelAndView.addObject("couplediary",couplediary);
			modelAndView.addObject("diary",dto);	
			modelAndView.addObject("diaryList",diaryList);			
			modelAndView.setViewName("WEB-INF/diary/Diary.jsp");
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		
		
		
		
		return modelAndView;
	}

}
