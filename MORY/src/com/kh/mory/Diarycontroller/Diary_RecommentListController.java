/*==================================
   RecommentListController.java
   - ����� ���� ��Ʈ�ѷ� Ŭ����.
==================================*/

package com.kh.mory.Diarycontroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.IRecommentDAO;


public class Diary_RecommentListController implements Controller
{
   // DAO �������̽� �ڷ��� ��� ����
   private IRecommentDAO dao;

   // setter ����
   public void setDao(IRecommentDAO dao)
   {
      this.dao = dao;
   }

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
   {
	   request.setCharacterEncoding("UTF-8");
	      

		ModelAndView modelAndView = new ModelAndView();

		String commentseq = request.getParameter("commentseq");
		String write_seq = request.getParameter("write_seq");

		try
		{
			DiaryDTO diary = new DiaryDTO();
			
			diary.setComment_seq(commentseq);

			ArrayList<DiaryDTO> commentList =  dao.recommentList(commentseq);
			
			modelAndView.addObject(commentList);

			modelAndView.setViewName("newsfeed_post.do?write_seq="+write_seq);

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return modelAndView;
  }
   
   
   
   

}