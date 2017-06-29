package com.kh.mory.Diarycontroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.ICommentDAO;

public class Diary_CommentListController implements Controller
{
	   // DAO 인터페이스 자료형 멤버 구성
	   private ICommentDAO dao;

	   // setter 구성
	   public void setDao(ICommentDAO dao)
	   {
	      this.dao = dao;
	   }

	   @Override
	   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	   {
	      request.setCharacterEncoding("UTF-8");
	      

			ModelAndView modelAndView = new ModelAndView();

			String write_seq = request.getParameter("write_seq");

			try
			{
				DiaryDTO diary = new DiaryDTO();
				
				diary.setWrite_seq(write_seq);

				ArrayList<DiaryDTO> commentList =  dao.commentList(write_seq);
				
				modelAndView.addObject(commentList);

				modelAndView.setViewName("WEB-INF/diary/DiaryPost.do?write_seq="+write_seq);

			} catch (Exception e)
			{
				System.out.println(e.toString());
			}

			return modelAndView;
	   }
}
