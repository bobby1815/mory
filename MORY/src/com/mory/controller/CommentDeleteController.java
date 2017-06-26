/*====================================
   CommentDeleteController.java
   - ����� ���� ��Ʈ�ѷ� Ŭ����.
====================================*/

package com.mory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mory.idao.ICommentDAO;

public class CommentDeleteController implements Controller
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
      String requ_seq = request.getParameter("requ_seq");
      dao.commentDelete(comment_seq);
      
      modelAndView.setViewName("redirect:DiaryPost.do?requ_seq="+requ_seq);
      
      return modelAndView;
      
      
   }
   
   
   
   
}