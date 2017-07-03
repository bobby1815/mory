package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.ICommentDAO;
import com.kh.mory.DiaryIDAO.IDiaryDAO;

public class Diary_DiarynameUpdateController implements Controller
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
		   String user_id = (String) session.getAttribute("user_id");
		   DiaryDTO dto = null;
			
		   String diary_seq = request.getParameter("diary_seq");
		   String diary_name = request.getParameter("diary_name");
			String diary_type = request.getParameter("diary_type");
			
			
			System.out.println(diary_name+"try전");
			System.out.println(diary_seq);
			try
			{
				System.out.println("try 진입");
				
				if (diary_seq == null || diary_seq == "")
				{
					System.out.println("개인다이어리 번호 검색");
					dto =  dao.mydiary(user_id);
					diary_seq = dto.getDiary_seq();
				}
				System.out.println(diary_seq);
				
				DiaryDTO diary = new DiaryDTO();
				
				diary.setDiary_name(diary_name);
				diary.setDiary_seq(diary_seq);
				
				
				System.out.println(diary_type.equals("2"));
				
				if (diary_type == "1" ||diary_type.equals(1)||diary_type.equals("1"))
				{	
					
					dao.diaryname(diary);
					modelAndView.setViewName("diary.do");
				}else if (diary_type.equals("2") ||diary_type.equals(2)||diary_type.equals("2")) {
					dao.couplediaryname(diary);
					modelAndView.setViewName("redirect:diary.do?requ_seq="+diary_seq);
				}
				
				
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
			
			
		return modelAndView;
		   
	   }
	
}
