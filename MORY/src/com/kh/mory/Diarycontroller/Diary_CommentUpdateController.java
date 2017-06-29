/*==================================
   CommentUpdateController.java
   - 사용자 정의 컨트롤러 클래스.
==================================*/

package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.ICommentDAO;


public class Diary_CommentUpdateController implements Controller
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

		String comment_cont = request.getParameter("cont");
		String comment_reg_dtm = request.getParameter("dtm");
		String user_id = request.getParameter("id");
		String write_seq=request.getParameter("write_seq");

		try
		{
			DiaryDTO diary = new DiaryDTO();
			
			diary.setComment_cont(comment_cont);
			diary.setComment_reg_dtm(comment_reg_dtm);
			diary.setUser_id(user_id);
			
			dao.commentUpdate(diary);
			modelAndView.setViewName("WEB-INF/Diary/DiaryPost.do?write_seq="+write_seq);

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return modelAndView;
   }
   
   
   

}