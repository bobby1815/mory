/*====================================
   RecommentDeleteController.java
   - ����� ���� ��Ʈ�ѷ� Ŭ����.
====================================*/

package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryIDAO.IRecommentDAO;


public class Diary_RecommentDeleteController implements Controller
{
   // DAO �������̽� ����
   private IRecommentDAO recommentdao;

   // setter ����
   

public void setRecommentdao(IRecommentDAO recommentdao)
{
	this.recommentdao = recommentdao;
}
   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
   {
      ModelAndView modelAndView = new ModelAndView();
      
      String reco_seq = request.getParameter("reco_seq");
      String write_seq =request.getParameter("write_seq");
      recommentdao.recommentDelete(reco_seq);
      
      modelAndView.setViewName("redirect:diarypost.do?write_seq="+write_seq);
      
      return modelAndView;   

   }

   
   

}