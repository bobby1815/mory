/*====================================
   RecommentDeleteController.java
   - ����� ���� ��Ʈ�ѷ� Ŭ����.
====================================*/

package com.mory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mory.idao.IRecommentDAO;


public class RecommentDeleteController implements Controller
{
   // DAO �������̽� ����
   private IRecommentDAO dao;

   // setter ����
   public void setDao(IRecommentDAO dao)
   {
      this.dao = dao;
   }

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
   {
      ModelAndView modelAndView = new ModelAndView();
      
      String reco_seq = request.getParameter("reco_seq");
      String requ_seq = request.getParameter("requ_seq");
      dao.recommentDelete(reco_seq);
      
      modelAndView.setViewName("redirect:DiaryPost.do?requ_seq="+requ_seq);
      
      return modelAndView;   

   }
   
   

}