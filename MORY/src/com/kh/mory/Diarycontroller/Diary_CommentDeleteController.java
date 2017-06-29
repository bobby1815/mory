/*====================================
   CommentDeleteController.java
   - ����� ���� ��Ʈ�ѷ� Ŭ����.
====================================*/

package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryIDAO.ICommentDAO;

public class Diary_CommentDeleteController implements Controller
{
   // DAO �������̽� ����
   private ICommentDAO dao;

   // setter ����
   public void setDao(ICommentDAO dao)
   {
      this.dao = dao;
   }

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
   {
      ModelAndView modelAndView = new ModelAndView();
      
      String comment_seq = request.getParameter("comment_seq");
      String write_seq = request.getParameter("write_seq");
      
      dao.commentDelete(comment_seq);
      
      modelAndView.setViewName("diarypost.do?write_seq="+write_seq);
      
      return modelAndView;
      
      
   }
   
   
   
   
}