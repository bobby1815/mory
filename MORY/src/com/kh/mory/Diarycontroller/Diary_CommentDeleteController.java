/*====================================
   CommentDeleteController.java
   - ����� ���� ��Ʈ�ѷ� Ŭ����.
====================================*/

package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryIDAO.ICommentDAO;

public class Diary_CommentDeleteController implements Controller
{
   // DAO �������̽� ����
   private ICommentDAO commentdao;

   // setter ����
  

   public void setCommentdao(ICommentDAO commentdao)
{
	this.commentdao = commentdao;
}

@Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
   {
      ModelAndView modelAndView = new ModelAndView();
      
      HttpSession session = request.getSession();
      String user_id = (String) session.getAttribute("user_id");
      
      String comment_seq = request.getParameter("comment_seq");
      String write_seq = request.getParameter("write_seq");
      
      int result = commentdao.commentDelete(comment_seq);
      
      System.out.println(result);
      
      
      modelAndView.setViewName("redirect:diarypost.do?write_seq="+write_seq);
      
      return modelAndView;
      
      
   }
   
   
   
   
}