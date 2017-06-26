/*==================================
   RecommentInsertController.java
   - 사용자 정의 컨트롤러 클래스.
==================================*/

package com.mory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mory.diary.DiaryDTO;
import com.mory.idao.IRecommentDAO;


public class RecommentInsertController implements Controller
{
   // DAO 인터페이스 자료형 멤버 구성
   private IRecommentDAO dao;

   // setter 구성
   public void setDao(IRecommentDAO dao)
   {
      this.dao = dao;
   }

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
   {
      request.setCharacterEncoding("UTF-8");
      

		ModelAndView modelAndView = new ModelAndView();

		String comment_cont = request.getParameter("cont");
		String user_id = request.getParameter("id");
		String commentseq = request.getParameter("commentseq");
		String write_seq = request.getParameter("write_seq");
		try
		{
			DiaryDTO diary = new DiaryDTO();
			
			diary.setComment_cont(comment_cont);
			diary.setUser_id(user_id);
			diary.setCommentseq(commentseq);
			
			dao.recommentInsert(diary);
			modelAndView.setViewName("DiaryPost.do?write_seq="+write_seq);

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return modelAndView;
   }
   
   
   
}