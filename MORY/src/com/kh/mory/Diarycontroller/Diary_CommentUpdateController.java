/*==================================
   CommentUpdateController.java
   - ����� ���� ��Ʈ�ѷ� Ŭ����.
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
   // DAO �������̽� �ڷ��� ��� ����
   private ICommentDAO commentdao;

   // setter ����
   public void setCommentdao(ICommentDAO commentdao)
   {
   	this.commentdao = commentdao;
   } 

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
   {
	   request.setCharacterEncoding("UTF-8");

		ModelAndView modelAndView = new ModelAndView();

		String comment_cont = request.getParameter("comment_cont");
		
		String write_seq=request.getParameter("write_seq");
		String comment_seq = request.getParameter("comment_seq");
		try
		{
			DiaryDTO diary = new DiaryDTO();
			
			diary.setComment_cont(comment_cont);
			diary.setComment_seq(comment_seq);
			
			commentdao.commentUpdate(diary);
			modelAndView.setViewName("redirect:diarypost.do?write_seq="+write_seq);

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return modelAndView;
   }


   
   
   

}