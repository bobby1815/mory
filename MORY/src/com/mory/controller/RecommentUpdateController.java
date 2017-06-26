/*==================================
   RecommentUpdateController.java
   - 사용자 정의 컨트롤러 클래스.
==================================*/

package com.mory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mory.diary.DiaryDTO;
import com.mory.idao.IRecommentDAO;


public class RecommentUpdateController implements Controller
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

		String reco_cont = request.getParameter("reco_cont");
		String reco_reg_dtm = request.getParameter("reco_reg_dtm");
		String user_id = request.getParameter("id");
		String write_seq = request.getParameter("write_seq");

		try
		{
			DiaryDTO diary = new DiaryDTO();
			
			diary.setReco_cont(reco_cont);
			diary.setReco_reg_dtm(reco_reg_dtm);
			diary.setUser_id(user_id);
			
			dao.recommentUpdate(diary);
			modelAndView.setViewName("DiaryPost.do?write_seq="+write_seq);

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return modelAndView;
      
   }
   
   
   

}